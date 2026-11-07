package com.example.ui.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.rotate
import kotlin.random.Random

data class Particle(
    val startX: Float,
    val speedY: Float,
    val speedX: Float,
    val size: Float,
    val color: Color,
    val rotationSpeed: Float,
    val isStar: Boolean
)

@Composable
fun ConfettiOverlay(
    modifier: Modifier = Modifier,
    particleCount: Int = 50
) {
    val progress = remember { Animatable(0f) }

    val particles = remember {
        val colors = listOf(
            Color(0xFFFF3B30),
            Color(0xFFFF9500),
            Color(0xFFFFCC00),
            Color(0xFF34C759),
            Color(0xFF00C7FF),
            Color(0xFFAF52DE),
            Color(0xFFFF2D55)
        )
        List(particleCount) {
            Particle(
                startX = Random.nextFloat(),
                speedY = Random.nextFloat() * 0.7f + 0.3f,
                speedX = (Random.nextFloat() - 0.5f) * 0.3f,
                size = Random.nextFloat() * 12f + 8f,
                color = colors.random(),
                rotationSpeed = (Random.nextFloat() - 0.5f) * 720f,
                isStar = Random.nextBoolean()
            )
        }
    }

    LaunchedEffect(Unit) {
        progress.animateTo(
            targetValue = 1f,
            animationSpec = tween(durationMillis = 3500, easing = LinearEasing)
        )
    }

    if (progress.value < 1f) {
        Canvas(modifier = modifier.fillMaxSize()) {
            val w = size.width
            val h = size.height
            val currentProgress = progress.value

            particles.forEach { p ->
                val currentY = (p.speedY * currentProgress * h * 1.2f) % (h * 1.2f) - (h * 0.1f)
                val currentX = (p.startX * w + p.speedX * currentProgress * w).coerceIn(0f, w)
                val currentRotation = p.rotationSpeed * currentProgress
                val alpha = (1f - (currentProgress * 0.8f)).coerceIn(0f, 1f)

                rotate(degrees = currentRotation, pivot = Offset(currentX, currentY)) {
                    if (p.isStar) {
                        drawStar(
                            center = Offset(currentX, currentY),
                            radius = p.size,
                            color = p.color.copy(alpha = alpha)
                        )
                    } else {
                        drawRect(
                            color = p.color.copy(alpha = alpha),
                            topLeft = Offset(currentX - p.size / 2, currentY - p.size / 2),
                            size = Size(p.size, p.size * 0.6f)
                        )
                    }
                }
            }
        }
    }
}

private fun androidx.compose.ui.graphics.drawscope.DrawScope.drawStar(
    center: Offset,
    radius: Float,
    color: Color
) {
    val path = Path()
    val innerRadius = radius * 0.45f
    val numPoints = 5
    val angleStep = Math.PI / numPoints

    for (i in 0 until (numPoints * 2)) {
        val r = if (i % 2 == 0) radius else innerRadius
        val angle = i * angleStep - (Math.PI / 2)
        val x = (center.x + r * Math.cos(angle)).toFloat()
        val y = (center.y + r * Math.sin(angle)).toFloat()
        if (i == 0) path.moveTo(x, y) else path.lineTo(x, y)
    }
    path.close()
    drawPath(path, color = color)
}
