package com.example.ui.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.model.StickerReward

@Composable
fun CelebrationDialog(
    stickerReward: StickerReward,
    hasNextLevel: Boolean,
    onNextLevel: () -> Unit,
    onGoToAlbum: () -> Unit,
    onDismiss: () -> Unit
) {
    val scaleAnim = remember { Animatable(0.2f) }

    LaunchedEffect(Unit) {
        scaleAnim.animateTo(
            targetValue = 1f,
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioMediumBouncy,
                stiffness = Spring.StiffnessLow
            )
        )
    }

    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            contentAlignment = Alignment.Center
        ) {
            // Confetti falling overlay
            ConfettiOverlay(modifier = Modifier.matchParentSize())

            Surface(
                modifier = Modifier
                    .scale(scaleAnim.value)
                    .fillMaxWidth()
                    .shadow(16.dp, RoundedCornerShape(32.dp))
                    .clip(RoundedCornerShape(32.dp))
                    .border(5.dp, Color(0xFFFFD54F), RoundedCornerShape(32.dp))
                    .testTag("celebration_dialog"),
                color = Color(0xFFFFFBEF)
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Joyful Stars header
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "⭐", fontSize = 28.sp)
                        Spacer(modifier = Modifier.size(6.dp))
                        Text(text = "🌟", fontSize = 42.sp)
                        Spacer(modifier = Modifier.size(6.dp))
                        Text(text = "⭐", fontSize = 28.sp)
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "УРА! ТИ МОЛОДЕЦЬ!",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Black,
                        color = Color(0xFFFF6F00),
                        textAlign = TextAlign.Center
                    )

                    Text(
                        text = "Малюнок замальовано повністю!",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF555555),
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Shiny Sticker Showcase Card
                    Box(
                        modifier = Modifier
                            .size(110.dp)
                            .shadow(10.dp, CircleShape)
                            .clip(CircleShape)
                            .background(
                                Brush.radialGradient(
                                    listOf(
                                        stickerReward.sparkleColor.copy(alpha = 0.5f),
                                        Color.White,
                                        stickerReward.sparkleColor.copy(alpha = 0.85f)
                                    )
                                )
                            )
                            .border(4.dp, Color(0xFFFFD54F), CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = stickerReward.emoji,
                            fontSize = 58.sp
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = "Новий стікер:",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFF777777)
                    )

                    Text(
                        text = stickerReward.title,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFF222222)
                    )

                    Text(
                        text = stickerReward.description,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color(0xFF666666),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    // Buttons
                    if (hasNextLevel) {
                        Button(
                            onClick = onNextLevel,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(52.dp)
                                .testTag("btn_next_level"),
                            shape = RoundedCornerShape(20.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF34C759)
                            )
                        ) {
                            Text(
                                text = "Наступний малюнок 🚀",
                                fontSize = 17.sp,
                                fontWeight = FontWeight.Black,
                                color = Color.White
                            )
                        }

                        Spacer(modifier = Modifier.height(10.dp))
                    }

                    Button(
                        onClick = onGoToAlbum,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .testTag("btn_to_sticker_album"),
                        shape = RoundedCornerShape(20.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFFF9500)
                        )
                    ) {
                        Text(
                            text = "Альбом стікерів 🏆",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    OutlinedButton(
                        onClick = onDismiss,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(44.dp)
                            .testTag("btn_admire_drawing"),
                        shape = RoundedCornerShape(18.dp)
                    ) {
                        Text(
                            text = "Помилуватися малюнком 🎨",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF555555)
                        )
                    }
                }
            }
        }
    }
}
