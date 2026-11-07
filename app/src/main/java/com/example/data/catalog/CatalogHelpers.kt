package com.example.data.catalog

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Path
import com.example.model.ColoringRegion

object CatalogHelpers {

    /**
     * Creates a ColoringRegion with normalized (0..400) coordinates and automatic sample points.
     */
    fun createRegion(
        id: String,
        name: String,
        cx: Float,
        cy: Float,
        sampleOffsets: List<Offset>? = null,
        pathBuilder: (width: Float, height: Float) -> Path
    ): ColoringRegion {
        val samples = sampleOffsets ?: listOf(
            Offset(cx, cy),
            Offset(cx - 14f, cy - 14f),
            Offset(cx + 14f, cy - 14f),
            Offset(cx - 14f, cy + 14f),
            Offset(cx + 14f, cy + 14f)
        )
        return ColoringRegion(
            id = id,
            name = name,
            centerPoint = Offset(cx, cy),
            samplePoints = samples,
            pathBuilder = pathBuilder
        )
    }

    /**
     * Helper to generate a closed oval path.
     */
    fun ovalPath(left: Float, top: Float, right: Float, bottom: Float): (Float, Float) -> Path {
        return { w, h ->
            val sx = w / 400f; val sy = h / 400f
            Path().apply {
                addOval(Rect(left * sx, top * sy, right * sx, bottom * sy))
            }
        }
    }
}
