package com.example.model

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

/**
 * Represents a color crayon in the side palette.
 */
data class CrayonItem(
    val id: String,
    val nameUk: String,
    val color: Color,
    val emoji: String,
    val isRainbow: Boolean = false,
    val isEraser: Boolean = false
)

object ColorPalette {

    val kidCrayons = listOf(
        CrayonItem(
            id = "sun_yellow",
            nameUk = "Сонячний",
            color = Color(0xFFFFD600),
            emoji = "☀️"
        ),
        CrayonItem(
            id = "tangerine_orange",
            nameUk = "Апельсин",
            color = Color(0xFFFF9100),
            emoji = "🍊"
        ),
        CrayonItem(
            id = "cherry_red",
            nameUk = "Вишневий",
            color = Color(0xFFFF3B30),
            emoji = "🍒"
        ),
        CrayonItem(
            id = "bubblegum_pink",
            nameUk = "Малиновий",
            color = Color(0xFFFF4081),
            emoji = "🌸"
        ),
        CrayonItem(
            id = "cotton_candy",
            nameUk = "Ніжно-рожевий",
            color = Color(0xFFFF8DA1),
            emoji = "🎀"
        ),
        CrayonItem(
            id = "royal_purple",
            nameUk = "Фіолетовий",
            color = Color(0xFFAF52DE),
            emoji = "🍇"
        ),
        CrayonItem(
            id = "sky_blue",
            nameUk = "Небесний",
            color = Color(0xFF00C7FF),
            emoji = "☁️"
        ),
        CrayonItem(
            id = "ocean_blue",
            nameUk = "Морський",
            color = Color(0xFF0066FF),
            emoji = "🌊"
        ),
        CrayonItem(
            id = "spring_green",
            nameUk = "Зелений",
            color = Color(0xFF34C759),
            emoji = "🌿"
        ),
        CrayonItem(
            id = "lime_fresh",
            nameUk = "Салатовий",
            color = Color(0xFFA6E22E),
            emoji = "🍏"
        ),
        CrayonItem(
            id = "chocolate_brown",
            nameUk = "Шоколадний",
            color = Color(0xFF8B572A),
            emoji = "🍫"
        ),
        CrayonItem(
            id = "soft_peach",
            nameUk = "Персиковий",
            color = Color(0xFFFFCCA7),
            emoji = "🍑"
        ),
        CrayonItem(
            id = "rainbow_magic",
            nameUk = "Чарівний",
            color = Color(0xFFFF5252),
            emoji = "✨",
            isRainbow = true
        ),
        CrayonItem(
            id = "eraser_white",
            nameUk = "Гумка",
            color = Color.White,
            emoji = "🧼",
            isEraser = true
        )
    )

    val RainbowBrush = Brush.linearGradient(
        colors = listOf(
            Color(0xFFFF3366),
            Color(0xFFFF9933),
            Color(0xFFFFFF33),
            Color(0xFF33CC66),
            Color(0xFF3399FF),
            Color(0xFF9933FF)
        )
    )

    // A collection of bright cycling colors for the magic rainbow mode
    val magicColors = listOf(
        Color(0xFFFF4081),
        Color(0xFFFFD700),
        Color(0xFF00E5FF),
        Color(0xFF76FF03),
        Color(0xFFFF9100),
        Color(0xFFE040FB),
        Color(0xFF00E676)
    )
}
