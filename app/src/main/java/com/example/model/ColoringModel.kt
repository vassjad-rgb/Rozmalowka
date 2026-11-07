package com.example.model

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope

/**
 * Represents a distinct closed region of a drawing with sample verification points for shading.
 */
data class ColoringRegion(
    val id: String,
    val name: String,
    val centerPoint: Offset = Offset(200f, 200f),
    val samplePoints: List<Offset> = listOf(centerPoint),
    val pathBuilder: (width: Float, height: Float) -> Path,
    val currentColor: Color? = null,
    val isShaded: Boolean = false
)

/**
 * Sticker reward earned when a level is 100% completed without white gaps.
 */
data class StickerReward(
    val id: String,
    val emoji: String,
    val title: String,
    val description: String,
    val sparkleColor: Color
)

/**
 * Pencil stroke width selection for realistic crayon shading.
 */
enum class PencilThickness(val labelUk: String, val strokeWidthDp: Float, val icon: String) {
    THIN("Тонкий", 16f, "✏️"),
    MEDIUM("Середній", 26f, "🖍️"),
    CHUBBY("Широкий", 38f, "🖌️")
}

/**
 * Full drawing level with vector regions and charming outline artwork.
 * Supports up to 100 levels with progressive detail.
 */
data class ColoringPicture(
    val id: Int,
    val title: String,
    val subtitle: String,
    val levelNumber: Int,
    val categoryTier: Int, // 1: 1-25, 2: 26-50, 3: 51-75, 4: 76-100
    val stickerReward: StickerReward,
    val regions: List<ColoringRegion>,
    val outlinePainter: ((DrawScope, width: Float, height: Float) -> Unit)? = null
) {
    val totalRegions: Int get() = regions.size
    val coloredRegionsCount: Int get() = regions.count { it.isShaded || (it.currentColor != null && it.currentColor != Color.White) }
    val isFullyColored: Boolean get() = totalRegions > 0 && coloredRegionsCount == totalRegions
    val progressFraction: Float get() = if (totalRegions == 0) 0f else coloredRegionsCount.toFloat() / totalRegions
}

/**
 * A collectible sticker placed by the child in the interactive Sticker Album playground.
 */
data class PlacedSticker(
    val instanceId: String,
    val stickerId: String,
    val emoji: String,
    val title: String,
    val xPercent: Float, // 0f..1f relative to canvas
    val yPercent: Float, // 0f..1f relative to canvas
    val scale: Float = 1.0f,
    val rotation: Float = 0f
)
