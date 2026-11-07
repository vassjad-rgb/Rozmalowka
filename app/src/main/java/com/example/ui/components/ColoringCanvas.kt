package com.example.ui.components

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.asAndroidPath
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.example.model.ColoringPicture
import com.example.model.ColoringRegion
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.sqrt

data class TapSparkle(
    val id: Long,
    val offset: Offset,
    val color: Color
)

@Composable
fun ColoringCanvas(
    picture: ColoringPicture,
    highlightUncolored: Boolean,
    onRegionTapped: (regionId: String, tapOffset: Offset) -> Unit,
    modifier: Modifier = Modifier
) {
    val coroutineScope = rememberCoroutineScope()
    val activeSparkles = remember { mutableStateListOf<TapSparkle>() }

    // Pulsing animation for hints on uncolored white areas
    val infiniteTransition = rememberInfiniteTransition(label = "pulse_transition")
    val pulseAlpha by infiniteTransition.animateFloat(
        initialValue = 0.2f,
        targetValue = 0.75f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 650, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "hint_pulse"
    )

    Box(
        modifier = modifier
            .aspectRatio(1f)
            .shadow(elevation = 8.dp, shape = RoundedCornerShape(20.dp))
            .clip(RoundedCornerShape(20.dp))
            .background(Color.White)
            .border(width = 3.5.dp, color = Color(0xFFFFD54F), shape = RoundedCornerShape(20.dp))
            .padding(6.dp)
            .testTag("coloring_canvas_box")
    ) {
        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .pointerInput(picture.id) {
                    detectTapGestures { offset ->
                        val w = size.width.toFloat()
                        val h = size.height.toFloat()
                        if (w <= 0 || h <= 0) return@detectTapGestures

                        val scaleX = w / 400f
                        val scaleY = h / 400f
                        val clip = android.graphics.Region(0, 0, w.toInt(), h.toInt())

                        var hitRegion: ColoringRegion? = null

                        // 1. Precise vector region detection
                        for (region in picture.regions.asReversed()) {
                            val composePath = region.pathBuilder(w, h)
                            val androidPath = composePath.asAndroidPath()
                            val testRegion = android.graphics.Region()
                            testRegion.setPath(androidPath, clip)
                            if (testRegion.contains(offset.x.toInt(), offset.y.toInt())) {
                                hitRegion = region
                                break
                            }
                        }

                        // 2. Child-friendly forgiving proximity detection
                        if (hitRegion == null) {
                            val maxDist = 70f * scaleX
                            hitRegion = picture.regions.minByOrNull { r ->
                                val cx = r.centerPoint.x * scaleX
                                val cy = r.centerPoint.y * scaleY
                                val dx = cx - offset.x
                                val dy = cy - offset.y
                                sqrt(dx * dx + dy * dy)
                            }?.takeIf { r ->
                                val cx = r.centerPoint.x * scaleX
                                val cy = r.centerPoint.y * scaleY
                                val dx = cx - offset.x
                                val dy = cy - offset.y
                                sqrt(dx * dx + dy * dy) < maxDist
                            }
                        }

                        hitRegion?.let { region ->
                            val sparkle = TapSparkle(
                                id = System.currentTimeMillis(),
                                offset = offset,
                                color = region.currentColor ?: Color(0xFFFFD54F)
                            )
                            activeSparkles.add(sparkle)
                            coroutineScope.launch {
                                delay(350)
                                activeSparkles.remove(sparkle)
                            }
                            onRegionTapped(region.id, offset)
                        }
                    }
                }
                .testTag("coloring_canvas")
        ) {
            val w = size.width
            val h = size.height

            // 1. Draw each region's filled color
            picture.regions.forEach { region ->
                val path = region.pathBuilder(w, h)
                val isUncolored = region.currentColor == null || region.currentColor == Color.White
                val fillColor = region.currentColor ?: Color.White

                drawPath(path = path, color = fillColor)

                // If hint active, pulse uncolored areas with gentle warm yellow glow
                if (highlightUncolored && isUncolored) {
                    drawPath(
                        path = path,
                        color = Color(0xFFFFD54F).copy(alpha = pulseAlpha)
                    )
                }
            }

            // 2. Draw thick, bold child-friendly black outlines
            val outlineStroke = Stroke(
                width = 5.dp.toPx(),
                cap = StrokeCap.Round,
                join = StrokeJoin.Round
            )
            picture.regions.forEach { region ->
                val path = region.pathBuilder(w, h)
                drawPath(
                    path = path,
                    color = Color(0xFF222222),
                    style = outlineStroke
                )
            }

            // 3. Draw cute details (eyes, nose, cheeks, smile, textures)
            picture.outlinePainter?.invoke(this, w, h)

            // 4. Draw tap sparkle bursts
            activeSparkles.forEach { sparkle ->
                drawCircle(
                    color = sparkle.color,
                    radius = 18f,
                    center = sparkle.offset
                )
                drawCircle(
                    color = Color.White,
                    radius = 9f,
                    center = sparkle.offset
                )
            }
        }
    }
}
