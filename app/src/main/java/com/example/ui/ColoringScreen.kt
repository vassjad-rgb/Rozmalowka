package com.example.ui

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.VolumeOff
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.audio.SoundPlayer
import com.example.data.ProgressManager
import com.example.model.ColorPalette
import com.example.model.ColoringPicture
import com.example.ui.components.CelebrationDialog
import com.example.ui.components.ColoringCanvas
import com.example.ui.components.CrayonItemView
import kotlinx.coroutines.delay

@Composable
fun ColoringScreen(
    picture: ColoringPicture,
    progressManager: ProgressManager,
    soundPlayer: SoundPlayer,
    hasNextLevel: Boolean,
    onBackToLevels: () -> Unit,
    onNextLevel: () -> Unit,
    onGoToAlbum: () -> Unit,
    modifier: Modifier = Modifier
) {
    BackHandler {
        onBackToLevels()
    }

    // Load saved region colors or start fresh
    var currentPictureState by remember(picture.id) {
        val savedColors = progressManager.loadPictureColors(picture.id)
        val updatedRegions = picture.regions.map { region ->
            region.copy(currentColor = savedColors[region.id])
        }
        mutableStateOf(picture.copy(regions = updatedRegions))
    }

    var selectedCrayon by remember { mutableStateOf(ColorPalette.kidCrayons.first()) }
    var magicColorIndex by remember { mutableIntStateOf(0) }
    var highlightUncolored by remember { mutableStateOf(false) }
    var showCelebrationDialog by remember { mutableStateOf(false) }
    var showResetDialog by remember { mutableStateOf(false) }
    var tipMessage by remember { mutableStateOf<String?>(null) }
    var isSoundOn by remember { mutableStateOf(progressManager.soundEnabled) }

    val totalCount = currentPictureState.totalRegions
    val coloredCount = currentPictureState.coloredRegionsCount
    val isComplete = currentPictureState.isFullyColored

    // Auto-clear hint
    LaunchedEffect(highlightUncolored) {
        if (highlightUncolored) {
            delay(3500)
            highlightUncolored = false
        }
    }

    // Auto-clear tip message
    LaunchedEffect(tipMessage) {
        if (tipMessage != null) {
            delay(2800)
            tipMessage = null
        }
    }

    fun handleRegionClick(regionId: String) {
        val region = currentPictureState.regions.find { it.id == regionId } ?: return

        val newColor = when {
            selectedCrayon.isEraser -> null
            selectedCrayon.isRainbow -> {
                val color = ColorPalette.magicColors[magicColorIndex % ColorPalette.magicColors.size]
                magicColorIndex++
                color
            }
            else -> selectedCrayon.color
        }

        val updatedRegions = currentPictureState.regions.map { r ->
            if (r.id == regionId) r.copy(currentColor = newColor) else r
        }
        val updatedPicture = currentPictureState.copy(regions = updatedRegions)
        currentPictureState = updatedPicture

        // Save progress to local preferences
        val colorsToSave = updatedRegions.mapNotNull { r ->
            r.currentColor?.let { c -> r.id to c }
        }.toMap()
        progressManager.savePictureColors(picture.id, colorsToSave)

        // Play feedback sounds
        if (selectedCrayon.isEraser) {
            soundPlayer.playPop()
        } else if (selectedCrayon.isRainbow) {
            soundPlayer.playSparkle()
        } else {
            soundPlayer.playColorFill(updatedPicture.coloredRegionsCount)
        }

        // Check if now fully colored!
        if (updatedPicture.isFullyColored) {
            progressManager.markLevelCompleted(picture.id)
            progressManager.unlockSticker(picture.stickerReward.id)
            soundPlayer.playFanfare()
            showCelebrationDialog = true
        }
    }

    fun verifyCompletion() {
        if (currentPictureState.isFullyColored) {
            progressManager.markLevelCompleted(picture.id)
            progressManager.unlockSticker(picture.stickerReward.id)
            soundPlayer.playFanfare()
            showCelebrationDialog = true
        } else {
            val remaining = currentPictureState.totalRegions - currentPictureState.coloredRegionsCount
            tipMessage = "Залишилось замалювати: $remaining ${if (remaining == 1) "детальку" else "деталей"}! 🎨"
            highlightUncolored = true
            soundPlayer.playBoing()
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color(0xFFFFF9E6),
                        Color(0xFFFFF2D0),
                        Color(0xFFFFE8B5)
                    )
                )
            )
    ) {
        // --- TOP BAR ---
        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = Color(0xFFFFFBEF),
            shadowElevation = 3.dp
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = onBackToLevels,
                    modifier = Modifier
                        .size(40.dp)
                        .background(Color(0xFFFFE082), CircleShape)
                        .testTag("btn_back_to_gallery")
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Назад",
                        tint = Color(0xFF5D4037)
                    )
                }

                Spacer(modifier = Modifier.width(8.dp))

                Column(modifier = Modifier.weight(1f)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "${picture.levelNumber}. ${currentPictureState.title}",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Black,
                            color = Color(0xFF3E2723),
                            maxLines = 1
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        if (isComplete) {
                            Text(text = "⭐ 100%", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color(0xFF2E7D32))
                        }
                    }

                    Spacer(modifier = Modifier.height(3.dp))

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        LinearProgressIndicator(
                            progress = { currentPictureState.progressFraction },
                            modifier = Modifier
                                .weight(1f)
                                .height(9.dp)
                                .clip(RoundedCornerShape(4.dp)),
                            color = if (isComplete) Color(0xFF34C759) else Color(0xFFFF9800),
                            trackColor = Color(0xFFE0E0E0),
                            strokeCap = StrokeCap.Round
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "$coloredCount/$totalCount",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF5D4037)
                        )
                    }
                }

                Spacer(modifier = Modifier.width(6.dp))

                // Sound Toggle
                IconButton(
                    onClick = {
                        val newState = !isSoundOn
                        isSoundOn = newState
                        progressManager.soundEnabled = newState
                        soundPlayer.isSoundEnabled = newState
                        if (newState) soundPlayer.playPop()
                    },
                    modifier = Modifier
                        .size(36.dp)
                        .background(Color(0xFFFFECB3), CircleShape)
                        .testTag("btn_toggle_sound")
                ) {
                    Icon(
                        imageVector = if (isSoundOn) Icons.Default.VolumeUp else Icons.Default.VolumeOff,
                        contentDescription = "Звук",
                        tint = Color(0xFF5D4037),
                        modifier = Modifier.size(18.dp)
                    )
                }
            }
        }

        // --- TIP BANNER ---
        AnimatedVisibility(
            visible = tipMessage != null,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            tipMessage?.let { msg ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 14.dp, vertical = 2.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color(0xFFFFE082))
                        .padding(horizontal = 10.dp, vertical = 4.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = msg,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF5D4037),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }

        // --- MAIN WORKSPACE: LARGER CANVAS + SIDE PALETTE ---
        Row(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(horizontal = 6.dp, vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Left: Enlarged Coloring Canvas (fills maximum space!)
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                contentAlignment = Alignment.Center
            ) {
                ColoringCanvas(
                    picture = currentPictureState,
                    highlightUncolored = highlightUncolored,
                    onRegionTapped = { regionId, _ ->
                        handleRegionClick(regionId)
                    },
                    modifier = Modifier.fillMaxSize()
                )
            }

            Spacer(modifier = Modifier.width(4.dp))

            // Right: Vertical Side Color Palette (вибір кольорів з боку на екрані)
            Surface(
                modifier = Modifier
                    .width(84.dp)
                    .fillMaxHeight()
                    .shadow(4.dp, RoundedCornerShape(16.dp))
                    .clip(RoundedCornerShape(16.dp))
                    .border(2.5.dp, Color(0xFFFFD54F), RoundedCornerShape(16.dp))
                    .testTag("side_palette_container"),
                color = Color(0xFFFFF8E1)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(vertical = 4.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Палітра",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Black,
                        color = Color(0xFF5D4037)
                    )

                    Spacer(modifier = Modifier.height(2.dp))

                    LazyColumn(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.End
                    ) {
                        items(ColorPalette.kidCrayons, key = { it.id }) { crayon ->
                            CrayonItemView(
                                crayon = crayon,
                                isSelected = selectedCrayon.id == crayon.id,
                                onSelect = {
                                    selectedCrayon = crayon
                                    soundPlayer.playPop()
                                }
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(4.dp))

                    // Quick Actions: Hint & Reset
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 4.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        IconButton(
                            onClick = {
                                highlightUncolored = true
                                soundPlayer.playSparkle()
                                val uncolored = currentPictureState.totalRegions - currentPictureState.coloredRegionsCount
                                tipMessage = if (uncolored > 0) "Шукай сяючі білі деталі! ✨" else "Все вже замальовано! 🎉"
                            },
                            modifier = Modifier
                                .size(36.dp)
                                .background(Color(0xFFFFECB3), CircleShape)
                                .border(1.5.dp, Color(0xFFFFB300), CircleShape)
                                .testTag("btn_hint")
                        ) {
                            Icon(
                                imageVector = Icons.Default.Lightbulb,
                                contentDescription = "Підказка",
                                tint = Color(0xFFFF8F00),
                                modifier = Modifier.size(20.dp)
                            )
                        }

                        IconButton(
                            onClick = {
                                showResetDialog = true
                                soundPlayer.playPop()
                            },
                            modifier = Modifier
                                .size(36.dp)
                                .background(Color(0xFFFFECB3), CircleShape)
                                .border(1.5.dp, Color(0xFFFF8A65), CircleShape)
                                .testTag("btn_reset_drawing")
                        ) {
                            Icon(
                                imageVector = Icons.Default.Refresh,
                                contentDescription = "Почати заново",
                                tint = Color(0xFFD84315),
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    }
                }
            }
        }

        // --- BOTTOM BAR: CHECK COMPLETION BUTTON ---
        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = Color(0xFFFFFBEF),
            shadowElevation = 5.dp
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 14.dp, vertical = 6.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = { verifyCompletion() },
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .height(44.dp)
                        .testTag("btn_check_task_completion"),
                    shape = RoundedCornerShape(22.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (isComplete) Color(0xFF34C759) else Color(0xFFFF9800)
                    )
                ) {
                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = if (isComplete) "Завдання виконано! Нагорода 🏆" else "Перевірити малюнок ✨",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Black,
                        color = Color.White
                    )
                }
            }
        }
    }

    // --- CELEBRATION DIALOG ---
    if (showCelebrationDialog) {
        CelebrationDialog(
            stickerReward = picture.stickerReward,
            hasNextLevel = hasNextLevel,
            onNextLevel = {
                showCelebrationDialog = false
                onNextLevel()
            },
            onGoToAlbum = {
                showCelebrationDialog = false
                onGoToAlbum()
            },
            onDismiss = {
                showCelebrationDialog = false
            }
        )
    }

    // --- RESET CONFIRMATION DIALOG ---
    if (showResetDialog) {
        AlertDialog(
            onDismissRequest = { showResetDialog = false },
            title = {
                Text(
                    text = "Почати заново? 🎨",
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp,
                    color = Color(0xFF3E2723)
                )
            },
            text = {
                Text(
                    text = "Очистити всі кольори та розмалювати цей малюнок ще раз?",
                    fontSize = 14.sp,
                    color = Color(0xFF5D4037)
                )
            },
            confirmButton = {
                Button(
                    onClick = {
                        progressManager.clearPictureColors(picture.id)
                        val resetRegions = currentPictureState.regions.map { it.copy(currentColor = null) }
                        currentPictureState = currentPictureState.copy(regions = resetRegions)
                        showResetDialog = false
                        soundPlayer.playPop()
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF5252))
                ) {
                    Text("Очистити", fontWeight = FontWeight.Bold)
                }
            },
            dismissButton = {
                OutlinedButton(onClick = { showResetDialog = false }) {
                    Text("Залишити")
                }
            },
            containerColor = Color(0xFFFFFBEF),
            shape = RoundedCornerShape(22.dp)
        )
    }
}
