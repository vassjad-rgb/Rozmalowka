package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.audio.SoundPlayer
import com.example.data.PictureRepository
import com.example.data.ProgressManager
import com.example.model.ColoringPicture
import com.example.ui.ColoringScreen
import com.example.ui.LevelSelectScreen
import com.example.ui.StickerAlbumScreen
import com.example.ui.theme.MyApplicationTheme

sealed class AppScreen {
    object LevelSelect : AppScreen()
    data class Coloring(val picture: ColoringPicture) : AppScreen()
    object StickerAlbum : AppScreen()
}

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val progressManager = ProgressManager(this)

        setContent {
            MyApplicationTheme {
                val coroutineScope = rememberCoroutineScope()
                val soundPlayer = remember {
                    SoundPlayer(coroutineScope).apply {
                        isSoundEnabled = progressManager.soundEnabled
                    }
                }

                val allPictures = remember { PictureRepository.getPictures() }
                var currentScreen by remember { mutableStateOf<AppScreen>(AppScreen.LevelSelect) }

                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .safeDrawingPadding(),
                    color = Color(0xFFFFF9E6)
                ) {
                    when (val screen = currentScreen) {
                        is AppScreen.LevelSelect -> {
                            LevelSelectScreen(
                                progressManager = progressManager,
                                soundPlayer = soundPlayer,
                                onSelectPicture = { picture ->
                                    currentScreen = AppScreen.Coloring(picture)
                                },
                                onOpenStickerAlbum = {
                                    currentScreen = AppScreen.StickerAlbum
                                }
                            )
                        }

                        is AppScreen.Coloring -> {
                            val currentIndex = allPictures.indexOfFirst { it.id == screen.picture.id }
                            val hasNext = currentIndex in 0 until (allPictures.size - 1)
                            val nextPic = if (hasNext) allPictures[currentIndex + 1] else null

                            ColoringScreen(
                                picture = screen.picture,
                                progressManager = progressManager,
                                soundPlayer = soundPlayer,
                                hasNextLevel = hasNext,
                                onBackToLevels = {
                                    currentScreen = AppScreen.LevelSelect
                                },
                                onNextLevel = {
                                    if (nextPic != null) {
                                        currentScreen = AppScreen.Coloring(nextPic)
                                    } else {
                                        currentScreen = AppScreen.LevelSelect
                                    }
                                },
                                onGoToAlbum = {
                                    currentScreen = AppScreen.StickerAlbum
                                }
                            )
                        }

                        is AppScreen.StickerAlbum -> {
                            StickerAlbumScreen(
                                progressManager = progressManager,
                                soundPlayer = soundPlayer,
                                onBack = {
                                    currentScreen = AppScreen.LevelSelect
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}
