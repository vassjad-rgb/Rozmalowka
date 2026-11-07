package com.example.ui

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.audio.SoundPlayer
import com.example.data.PictureRepository
import com.example.data.ProgressManager
import com.example.model.PlacedSticker
import com.example.model.StickerReward
import com.example.ui.components.ConfettiOverlay
import java.util.UUID
import kotlin.math.roundToInt

@Composable
fun StickerAlbumScreen(
    progressManager: ProgressManager,
    soundPlayer: SoundPlayer,
    onBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    BackHandler {
        onBack()
    }

    val pictures = remember { PictureRepository.getPictures() }
    val allStickers = remember { pictures.map { it.stickerReward } }
    val unlockedStickerIds = remember { progressManager.getUnlockedStickers() }

    var selectedTab by remember { mutableIntStateOf(0) }
    var showSparkles by remember { mutableStateOf(false) }

    // Placed stickers state in the playground
    val placedStickers = remember {
        mutableStateListOf<PlacedSticker>().apply {
            addAll(progressManager.getPlacedStickers())
        }
    }

    fun saveStickers() {
        progressManager.savePlacedStickers(placedStickers)
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color(0xFFFFF9E6),
                        Color(0xFFFFF1C6),
                        Color(0xFFFFE599)
                    )
                )
            )
    ) {
        // --- TOP BAR ---
        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = Color(0xFFFFFBEF),
            shadowElevation = 4.dp
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 14.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = {
                        soundPlayer.playPop()
                        onBack()
                    },
                    modifier = Modifier
                        .size(44.dp)
                        .background(Color(0xFFFFE082), CircleShape)
                        .testTag("btn_back_from_album")
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Назад",
                        tint = Color(0xFF5D4037)
                    )
                }

                Spacer(modifier = Modifier.width(12.dp))

                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Альбом Стікерів 🏆",
                        fontSize = 19.sp,
                        fontWeight = FontWeight.Black,
                        color = Color(0xFF3E2723)
                    )
                    Text(
                        text = "Зібрано ${unlockedStickerIds.size} з ${allStickers.size} стікерів",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFE65100)
                    )
                }

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color(0xFFFFD54F))
                        .padding(horizontal = 10.dp, vertical = 6.dp)
                ) {
                    Text(
                        text = "⭐ ${unlockedStickerIds.size * 3} Зірок",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFF5D4037)
                    )
                }
            }
        }

        // --- TABS: КОЛЕКЦІЯ / ГАЛЯВИНА ---
        TabRow(
            selectedTabIndex = selectedTab,
            containerColor = Color(0xFFFFF8E1),
            contentColor = Color(0xFFE65100)
        ) {
            Tab(
                selected = selectedTab == 0,
                onClick = {
                    selectedTab = 0
                    soundPlayer.playPop()
                },
                text = {
                    Text(
                        text = "Колекція Нагород 🎖️",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )
                }
            )
            Tab(
                selected = selectedTab == 1,
                onClick = {
                    selectedTab = 1
                    soundPlayer.playPop()
                },
                text = {
                    Text(
                        text = "Чарівна Галявина 🏞️",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )
                }
            )
        }

        if (selectedTab == 0) {
            // --- TAB 0: STICKER COLLECTION GRID ---
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(16.dp),
                horizontalArrangement = Arrangement.spacedBy(14.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp),
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .testTag("sticker_collection_grid")
            ) {
                items(allStickers, key = { it.id }) { sticker ->
                    val isUnlocked = unlockedStickerIds.contains(sticker.id)
                    val correspondingPic = pictures.firstOrNull { it.stickerReward.id == sticker.id }

                    StickerCardItem(
                        sticker = sticker,
                        isUnlocked = isUnlocked,
                        levelTitle = correspondingPic?.title ?: "Малюнок",
                        onTap = {
                            if (isUnlocked) {
                                soundPlayer.playSparkle()
                                showSparkles = true
                            } else {
                                soundPlayer.playBoing()
                            }
                        }
                    )
                }
            }
        } else {
            // --- TAB 1: INTERACTIVE STICKER PLAYGROUND ---
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                // Top tray with stickers ready to place
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = Color(0xFFFFF8E1),
                    shadowElevation = 3.dp
                ) {
                    Column(modifier = Modifier.padding(vertical = 6.dp)) {
                        Text(
                            text = "Торкнися стікера, щоб додати на галявину:",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF5D4037),
                            modifier = Modifier.padding(horizontal = 14.dp, vertical = 2.dp)
                        )

                        if (unlockedStickerIds.isEmpty()) {
                            Text(
                                text = "Заверши малюнки, щоб відкрити стікери для галявини!",
                                fontSize = 12.sp,
                                color = Color(0xFF757575),
                                modifier = Modifier.padding(horizontal = 14.dp, vertical = 6.dp)
                            )
                        } else {
                            LazyRow(
                                contentPadding = PaddingValues(horizontal = 12.dp),
                                horizontalArrangement = Arrangement.spacedBy(8.dp),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                items(allStickers.filter { unlockedStickerIds.contains(it.id) }) { sticker ->
                                    Box(
                                        modifier = Modifier
                                            .size(52.dp)
                                            .shadow(3.dp, CircleShape)
                                            .clip(CircleShape)
                                            .background(Color.White)
                                            .border(2.dp, Color(0xFFFFD54F), CircleShape)
                                            .clickable {
                                                soundPlayer.playPop()
                                                val newSticker = PlacedSticker(
                                                    instanceId = UUID.randomUUID().toString(),
                                                    stickerId = sticker.id,
                                                    emoji = sticker.emoji,
                                                    title = sticker.title,
                                                    xPercent = 0.3f + (Math.random() * 0.4f).toFloat(),
                                                    yPercent = 0.3f + (Math.random() * 0.4f).toFloat()
                                                )
                                                placedStickers.add(newSticker)
                                                saveStickers()
                                            },
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Text(text = sticker.emoji, fontSize = 28.sp)
                                    }
                                }
                            }
                        }
                    }
                }

                // Scenic interactive playground
                BoxWithConstraints(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .padding(10.dp)
                        .shadow(8.dp, RoundedCornerShape(24.dp))
                        .clip(RoundedCornerShape(24.dp))
                        .background(
                            Brush.verticalGradient(
                                listOf(
                                    Color(0xFF81D4FA), // Sunny sky
                                    Color(0xFFB3E5FC),
                                    Color(0xFFFFF9C4), // Sun glow
                                    Color(0xFFAED581), // Meadow
                                    Color(0xFF8BC34A)
                                )
                            )
                        )
                        .border(4.dp, Color(0xFFFFD54F), RoundedCornerShape(24.dp))
                        .testTag("sticker_playground")
                ) {
                    val canvasWidth = maxWidth
                    val canvasHeight = maxHeight

                    // Decorative background landscape elements
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp, start = 20.dp, end = 20.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "☀️", fontSize = 38.sp)
                        Text(text = "🌈", fontSize = 42.sp)
                        Text(text = "☁️", fontSize = 36.sp)
                    }

                    // Flowers on meadow bottom
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.BottomCenter)
                            .padding(bottom = 12.dp, start = 16.dp, end = 16.dp),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        Text(text = "🌸", fontSize = 22.sp)
                        Text(text = "🌼", fontSize = 24.sp)
                        Text(text = "🌷", fontSize = 22.sp)
                        Text(text = "🌻", fontSize = 26.sp)
                        Text(text = "🌸", fontSize = 22.sp)
                    }

                    // Render placed stickers
                    placedStickers.forEachIndexed { index, placed ->
                        var offsetX by remember(placed.instanceId) {
                            mutableStateOf(canvasWidth.value * placed.xPercent)
                        }
                        var offsetY by remember(placed.instanceId) {
                            mutableStateOf(canvasHeight.value * placed.yPercent)
                        }

                        Box(
                            modifier = Modifier
                                .offset { IntOffset(offsetX.roundToInt(), offsetY.roundToInt()) }
                                .size(64.dp)
                                .shadow(6.dp, CircleShape)
                                .clip(CircleShape)
                                .background(Color.White.copy(alpha = 0.95f))
                                .border(3.dp, Color(0xFFFFD54F), CircleShape)
                                .pointerInput(placed.instanceId) {
                                    detectDragGestures(
                                        onDragEnd = {
                                            val xRatio = (offsetX / canvasWidth.value).coerceIn(0f, 0.85f)
                                            val yRatio = (offsetY / canvasHeight.value).coerceIn(0f, 0.85f)
                                            placedStickers[index] = placed.copy(xPercent = xRatio, yPercent = yRatio)
                                            saveStickers()
                                        }
                                    ) { change, dragAmount ->
                                        change.consume()
                                        offsetX = (offsetX + dragAmount.x).coerceIn(0f, canvasWidth.value - 64f)
                                        offsetY = (offsetY + dragAmount.y).coerceIn(0f, canvasHeight.value - 64f)
                                    }
                                }
                                .clickable {
                                    soundPlayer.playSparkle()
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = placed.emoji, fontSize = 36.sp)
                        }
                    }

                    // Clear playground button
                    if (placedStickers.isNotEmpty()) {
                        IconButton(
                            onClick = {
                                soundPlayer.playPop()
                                placedStickers.clear()
                                saveStickers()
                            },
                            modifier = Modifier
                                .align(Alignment.BottomEnd)
                                .padding(12.dp)
                                .size(44.dp)
                                .background(Color.White, CircleShape)
                                .border(2.dp, Color(0xFFFF5252), CircleShape)
                                .testTag("btn_clear_playground")
                        ) {
                            Icon(
                                imageVector = Icons.Default.Delete,
                                contentDescription = "Очистити",
                                tint = Color(0xFFFF5252)
                            )
                        }
                    }
                }
            }
        }
    }

    // Sparkle fireworks effect
    if (showSparkles) {
        ConfettiOverlay(modifier = Modifier.fillMaxSize())
    }
}

@Composable
fun StickerCardItem(
    sticker: StickerReward,
    isUnlocked: Boolean,
    levelTitle: String,
    onTap: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(if (isUnlocked) 8.dp else 2.dp, RoundedCornerShape(22.dp))
            .clip(RoundedCornerShape(22.dp))
            .border(
                width = if (isUnlocked) 3.5.dp else 1.dp,
                color = if (isUnlocked) Color(0xFFFFD54F) else Color(0xFFBDBDBD),
                shape = RoundedCornerShape(22.dp)
            )
            .clickable(onClick = onTap)
            .testTag("sticker_card_${sticker.id}"),
        colors = CardDefaults.cardColors(
            containerColor = if (isUnlocked) Color(0xFFFFFDF5) else Color(0xFFEEEEEE)
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .shadow(if (isUnlocked) 6.dp else 0.dp, CircleShape)
                    .clip(CircleShape)
                    .background(
                        if (isUnlocked) Brush.radialGradient(
                            listOf(
                                sticker.sparkleColor.copy(alpha = 0.5f),
                                Color.White
                            )
                        ) else Brush.radialGradient(
                            listOf(Color(0xFFE0E0E0), Color(0xFFBDBDBD))
                        )
                    )
                    .border(
                        width = 2.dp,
                        color = if (isUnlocked) Color(0xFFFFD54F) else Color(0xFFBDBDBD),
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                if (isUnlocked) {
                    Text(text = sticker.emoji, fontSize = 42.sp)
                } else {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = "Заблоковано",
                        tint = Color(0xFF757575),
                        modifier = Modifier.size(32.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = sticker.title,
                fontSize = 15.sp,
                fontWeight = FontWeight.ExtraBold,
                color = if (isUnlocked) Color(0xFF3E2723) else Color(0xFF757575),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = if (isUnlocked) sticker.description else "Заверши малюнок «$levelTitle»",
                fontSize = 11.sp,
                color = if (isUnlocked) Color(0xFF5D4037) else Color(0xFF9E9E9E),
                textAlign = TextAlign.Center
            )
        }
    }
}
