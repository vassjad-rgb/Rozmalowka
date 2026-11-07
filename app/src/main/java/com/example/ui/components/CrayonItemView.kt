package com.example.ui.components

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.ColorPalette
import com.example.model.CrayonItem

@Composable
fun CrayonItemView(
    crayon: CrayonItem,
    isSelected: Boolean,
    onSelect: () -> Unit,
    modifier: Modifier = Modifier
) {
    val offsetTransition by animateDpAsState(
        targetValue = if (isSelected) (-10).dp else 0.dp,
        animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy, stiffness = Spring.StiffnessLow),
        label = "crayon_offset"
    )

    val interactionSource = remember { MutableInteractionSource() }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .offset(x = offsetTransition)
            .padding(vertical = 3.dp)
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onSelect
            )
            .testTag("crayon_${crayon.id}")
    ) {
        // Crayon tip (points to the left towards the canvas)
        Box(
            modifier = Modifier
                .width(14.dp)
                .height(if (isSelected) 36.dp else 28.dp)
                .clip(RoundedCornerShape(topStart = 12.dp, bottomStart = 12.dp))
                .background(
                    if (crayon.isRainbow) ColorPalette.RainbowBrush
                    else if (crayon.isEraser) Brush.linearGradient(listOf(Color(0xFFEEEEEE), Color.White))
                    else Brush.linearGradient(listOf(crayon.color.copy(alpha = 0.85f), crayon.color))
                )
                .border(
                    width = 2.dp,
                    color = if (isSelected) Color(0xFF222222) else Color(0x33000000),
                    shape = RoundedCornerShape(topStart = 12.dp, bottomStart = 12.dp)
                )
        )

        // Crayon main chubby body
        Box(
            modifier = Modifier
                .width(if (isSelected) 74.dp else 64.dp)
                .height(if (isSelected) 42.dp else 34.dp)
                .shadow(
                    elevation = if (isSelected) 6.dp else 2.dp,
                    shape = RoundedCornerShape(topEnd = 8.dp, bottomEnd = 8.dp)
                )
                .clip(RoundedCornerShape(topEnd = 8.dp, bottomEnd = 8.dp))
                .background(
                    if (crayon.isRainbow) ColorPalette.RainbowBrush
                    else if (crayon.isEraser) Brush.linearGradient(listOf(Color(0xFFF0F0F0), Color.White))
                    else Brush.horizontalGradient(
                        listOf(
                            crayon.color,
                            crayon.color.copy(alpha = 0.95f),
                            crayon.color.copy(alpha = 0.8f)
                        )
                    )
                )
                .border(
                    width = if (isSelected) 2.5.dp else 1.5.dp,
                    color = if (isSelected) Color(0xFF222222) else Color(0x33000000),
                    shape = RoundedCornerShape(topEnd = 8.dp, bottomEnd = 8.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            // Paper label sleeve
            Box(
                modifier = Modifier
                    .fillMaxSizeLabel()
                    .padding(horizontal = 4.dp, vertical = 2.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(Color.White.copy(alpha = 0.92f)),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.padding(horizontal = 2.dp)
                ) {
                    Text(
                        text = crayon.emoji,
                        fontSize = if (isSelected) 14.sp else 12.sp
                    )
                    Spacer(modifier = Modifier.width(3.dp))
                    Text(
                        text = crayon.nameUk,
                        fontSize = if (isSelected) 10.sp else 9.sp,
                        fontWeight = if (isSelected) FontWeight.ExtraBold else FontWeight.Bold,
                        color = Color(0xFF222222),
                        maxLines = 1
                    )
                }
            }
        }
    }
}

private fun Modifier.fillMaxSizeLabel(): Modifier = this.then(
    Modifier.padding(horizontal = 2.dp)
)
