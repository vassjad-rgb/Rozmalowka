package com.example.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.VolumeOff
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.audio.SoundPlayer
import com.example.data.PictureRepository
import com.example.data.ProgressManager
import com.example.model.ColoringPicture

@Composable
fun LevelSelectScreen(
    progressManager: ProgressManager,
    soundPlayer: SoundPlayer,
    onSelectPicture: (ColoringPicture) -> Unit,
    onOpenStickerAlbum: () -> Unit,
    modifier: Modifier = Modifier
) {
    var isSoundOn by remember { mutableStateOf(progressManager.soundEnabled) }
    val maxUnlockedLevel = progressManager.getUnlockedLevelMax()
    val allPictures = remember { PictureRepository.getPictures() }
    val unlockedStickersCount = progressManager.getUnlockedStickers().size
    var selectedTierTab by remember { mutableIntStateOf(0) }

    val tierTabs = listOf(
        "1-25 Малюк ☀️",
        "26-50 Друзі 🐱",
        "51-75 Космос 🚀",
        "76-100 Казка 🏰"
    )

    val currentTierPictures = remember(selectedTierTab) {
        val tier = selectedTierTab + 1
        allPictures.filter { it.categoryTier == tier }
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
        // --- TOP HEADER ---
        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = Color(0xFFFFFBEF),
            shadowElevation = 4.dp
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 14.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(42.dp)
                            .shadow(3.dp, CircleShape)
                            .clip(CircleShape)
                            .background(Color(0xFFFFD54F)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "🎨", fontSize = 24.sp)
                    }

                    Spacer(modifier = Modifier.width(10.dp))

                    Column {
                        Text(
                            text = "Весела Розмальовка",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Black,
                            color = Color(0xFF3E2723)
                        )
                        Text(
                            text = "100 малюнків зі штрихуванням",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF795548)
                        )
                    }
                }

                IconButton(
                    onClick = {
                        val newState = !isSoundOn
                        isSoundOn = newState
                        progressManager.soundEnabled = newState
                        soundPlayer.isSoundEnabled = newState
                        if (newState) soundPlayer.playPop()
                    },
                    modifier = Modifier
                        .size(38.dp)
                        .background(Color(0xFFFFECB3), CircleShape)
                        .testTag("btn_sound_level_select")
                ) {
                    Icon(
                        imageVector = if (isSoundOn) Icons.Default.VolumeUp else Icons.Default.VolumeOff,
                        contentDescription = "Звук",
                        tint = Color(0xFF5D4037)
                    )
                }
            }
        }

        // --- STICKER ALBUM BANNER ---
        Card(
            onClick = {
                soundPlayer.playPop()
                onOpenStickerAlbum()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 6.dp)
                .shadow(4.dp, RoundedCornerShape(18.dp))
                .testTag("btn_open_sticker_album"),
            shape = RoundedCornerShape(18.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFFFB300)
            )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 14.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "🏆", fontSize = 28.sp)
                    Spacer(modifier = Modifier.width(10.dp))
                    Column {
                        Text(
                            text = "Альбом Стікерів",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Black,
                            color = Color(0xFF3E2723)
                        )
                        Text(
                            text = "Зібрано: $unlockedStickersCount з 100 нагород",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF4E342E)
                        )
                    }
                }

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color.White.copy(alpha = 0.9f))
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = "Відкрити ⭐",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFFE65100)
                    )
                }
            }
        }

        // --- TABS FOR 100 LEVELS (25 PER TAB) ---
        ScrollableTabRow(
            selectedTabIndex = selectedTierTab,
            containerColor = Color(0xFFFFF8E1),
            contentColor = Color(0xFFE65100),
            edgePadding = 8.dp
        ) {
            tierTabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTierTab == index,
                    onClick = {
                        selectedTierTab = index
                        soundPlayer.playPop()
                    },
                    text = {
                        Text(
                            text = title,
                            fontWeight = if (selectedTierTab == index) FontWeight.Black else FontWeight.Bold,
                            fontSize = 12.sp
                        )
                    }
                )
            }
        }

        // --- GRID OF 25 PICTURES PER SELECTED TIER ---
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 10.dp, end = 10.dp, bottom = 18.dp, top = 6.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .testTag("levels_grid")
        ) {
            items(currentTierPictures, key = { it.id }) { picture ->
                val isUnlocked = picture.levelNumber <= maxUnlockedLevel
                val isCompleted = progressManager.isLevelCompleted(picture.id)

                LevelCardItem(
                    picture = picture,
                    isUnlocked = isUnlocked,
                    isCompleted = isCompleted,
                    onSelect = {
                        if (isUnlocked) {
                            soundPlayer.playPop()
                            onSelectPicture(picture)
                        } else {
                            soundPlayer.playBoing()
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun LevelCardItem(
    picture: ColoringPicture,
    isUnlocked: Boolean,
    isCompleted: Boolean,
    onSelect: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(if (isUnlocked) 4.dp else 1.dp, RoundedCornerShape(18.dp))
            .clip(RoundedCornerShape(18.dp))
            .border(
                width = if (isCompleted) 3.dp else if (isUnlocked) 1.5.dp else 1.dp,
                color = if (isCompleted) Color(0xFF4CAF50) else if (isUnlocked) Color(0xFFFFD54F) else Color(0xFFBDBDBD),
                shape = RoundedCornerShape(18.dp)
            )
            .clickable(onClick = onSelect)
            .testTag("level_card_${picture.id}"),
        colors = CardDefaults.cardColors(
            containerColor = if (isUnlocked) Color(0xFFFFFDF7) else Color(0xFFF2ECE4)
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1.25f)
                    .clip(RoundedCornerShape(14.dp))
                    .background(
                        if (isUnlocked) Brush.radialGradient(
                            listOf(
                                picture.stickerReward.sparkleColor.copy(alpha = 0.35f),
                                Color.White
                            )
                        ) else Brush.radialGradient(
                            listOf(Color(0xFFE0E0E0), Color(0xFFCCCCCC))
                        )
                    )
                    .border(
                        width = 1.dp,
                        color = if (isUnlocked) Color(0xFFFFE082) else Color(0xFFCCCCCC),
                        shape = RoundedCornerShape(14.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                if (isUnlocked) {
                    Text(
                        text = picture.stickerReward.emoji,
                        fontSize = 42.sp
                    )

                    if (isCompleted) {
                        Box(
                            modifier = Modifier
                                .align(Alignment.TopEnd)
                                .padding(4.dp)
                                .clip(RoundedCornerShape(6.dp))
                                .background(Color(0xFF4CAF50))
                                .padding(horizontal = 4.dp, vertical = 2.dp)
                        ) {
                            Text(
                                text = "⭐ 100%",
                                fontSize = 8.sp,
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                } else {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            imageVector = Icons.Default.Lock,
                            contentDescription = "Заблоковано",
                            tint = Color(0xFF9E9E9E),
                            modifier = Modifier.size(28.dp)
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = "Рівень ${picture.levelNumber}",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF757575)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "${picture.levelNumber}. ${picture.title}",
                fontSize = 12.sp,
                fontWeight = FontWeight.ExtraBold,
                color = if (isUnlocked) Color(0xFF3E2723) else Color(0xFF757575),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(2.dp))

            if (isUnlocked) {
                Text(
                    text = if (isCompleted) "Заштриховано! 🎨" else "Заштрихуй олівцем ✏️",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (isCompleted) Color(0xFF2E7D32) else Color(0xFFE65100),
                    textAlign = TextAlign.Center
                )
            } else {
                Text(
                    text = "Пройди Рівень ${picture.levelNumber - 1}",
                    fontSize = 9.sp,
                    color = Color(0xFF9E9E9E),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}
