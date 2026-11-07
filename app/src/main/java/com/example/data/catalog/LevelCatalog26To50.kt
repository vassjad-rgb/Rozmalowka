package com.example.data.catalog

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import com.example.model.ColoringPicture
import com.example.model.StickerReward

object LevelCatalog26To50 {

    val levels: List<ColoringPicture> by lazy {
        listOf(
            createLevel26(), createLevel27(), createLevel28(), createLevel29(), createLevel30(),
            createLevel31(), createLevel32(), createLevel33(), createLevel34(), createLevel35(),
            createLevel36(), createLevel37(), createLevel38(), createLevel39(), createLevel40(),
            createLevel41(), createLevel42(), createLevel43(), createLevel44(), createLevel45(),
            createLevel46(), createLevel47(), createLevel48(), createLevel49(), createLevel50()
        )
    }

    // 26: Добрий Котик (Cat)
    private fun createLevel26() = ColoringPicture(
        id = 26, title = "Добрий Котик", subtitle = "Пухнастий котик з бантиком і хвостиком", levelNumber = 26, categoryTier = 2,
        stickerReward = StickerReward("sticker_26", "🐱", "Котик-Мурчик", "Лагідний та муркотливий!", Color(0xFFFF9500)),
        regions = listOf(
            CatalogHelpers.createRegion("cat_head", "Голова", 200f, 150f, pathBuilder = CatalogHelpers.ovalPath(110f, 80f, 290f, 230f)),
            CatalogHelpers.createRegion("ear_l", "Ліве вушко", 130f, 65f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(120f * sx, 110f * sy); lineTo(110f * sx, 35f * sy); lineTo(170f * sx, 85f * sy); close() }
            },
            CatalogHelpers.createRegion("ear_r", "Праве вушко", 270f, 65f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(230f * sx, 85f * sy); lineTo(290f * sx, 35f * sy); lineTo(280f * sx, 110f * sy); close() }
            },
            CatalogHelpers.createRegion("cat_body", "Тільце", 200f, 290f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(140f * sx, 215f * sy); cubicTo(100f * sx, 250f * sy, 110f * sx, 360f * sy, 140f * sx, 365f * sy); lineTo(260f * sx, 365f * sy); cubicTo(290f * sx, 360f * sy, 300f * sx, 250f * sy, 260f * sx, 215f * sy); close() }
            },
            CatalogHelpers.createRegion("cat_tail", "Хвостик", 320f, 300f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(260f * sx, 340f * sy); cubicTo(310f * sx, 340f * sy, 355f * sx, 300f * sy, 345f * sx, 250f * sy); cubicTo(335f * sx, 235f * sy, 315f * sx, 240f * sy, 320f * sx, 260f * sy); cubicTo(325f * sx, 280f * sy, 295f * sx, 310f * sy, 255f * sx, 315f * sy); close() }
            },
            CatalogHelpers.createRegion("cat_bow", "Бантик", 200f, 222f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(200f * sx, 222f * sy); lineTo(165f * sx, 205f * sy); lineTo(165f * sx, 240f * sy); lineTo(200f * sx, 222f * sy); lineTo(235f * sx, 205f * sy); lineTo(235f * sx, 240f * sy); close() }
            }
        ),
        outlinePainter = { scope, w, h ->
            val sx = w / 400f; val sy = h / 400f
            scope.drawCircle(Color(0xFF222222), 8f * sx, Offset(165f * sx, 145f * sy))
            scope.drawCircle(Color(0xFF222222), 8f * sx, Offset(235f * sx, 145f * sy))
            scope.drawCircle(Color.White, 3f * sx, Offset(162f * sx, 142f * sy))
            scope.drawCircle(Color.White, 3f * sx, Offset(232f * sx, 142f * sy))
            val nose = Path().apply { moveTo(194f * sx, 160f * sy); lineTo(206f * sx, 160f * sy); lineTo(200f * sx, 168f * sy); close() }
            scope.drawPath(nose, Color(0xFFFF4081))
        }
    )

    // 27: Песик-Дружок (Dog)
    private fun createLevel27() = ColoringPicture(
        id = 27, title = "Песик-Дружок", subtitle = "Вірний цуцик із веселим хвостиком", levelNumber = 27, categoryTier = 2,
        stickerReward = StickerReward("sticker_27", "🐶", "Песик-Барбосик", "Найвірніший захисник!", Color(0xFFFF9500)),
        regions = listOf(
            CatalogHelpers.createRegion("dog_head", "Голова песика", 200f, 150f, pathBuilder = CatalogHelpers.ovalPath(120f, 80f, 280f, 220f)),
            CatalogHelpers.createRegion("ear_l", "Ліве вухо", 100f, 150f, pathBuilder = CatalogHelpers.ovalPath(75f, 95f, 125f, 215f)),
            CatalogHelpers.createRegion("ear_r", "Праве вухо", 300f, 150f, pathBuilder = CatalogHelpers.ovalPath(275f, 95f, 325f, 215f)),
            CatalogHelpers.createRegion("dog_body", "Тільце", 200f, 280f, pathBuilder = CatalogHelpers.ovalPath(130f, 205f, 270f, 355f)),
            CatalogHelpers.createRegion("bone", "Цукрова кісточка", 200f, 345f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(160f * sx, 340f * sy); lineTo(240f * sx, 340f * sy); lineTo(240f * sx, 355f * sy); lineTo(160f * sx, 355f * sy); close() }
            }
        )
    )

    // 28: Вухатий Зайчик (Bunny)
    private fun createLevel28() = ColoringPicture(
        id = 28, title = "Вухатий Зайчик", subtitle = "М'який сірий зайчик з довгими вушками", levelNumber = 28, categoryTier = 2,
        stickerReward = StickerReward("sticker_28", "🐰", "Швидкий Зайчик", "Стрибає у високу траву!", Color(0xFFFF4081)),
        regions = listOf(
            CatalogHelpers.createRegion("head", "Голова зайчика", 200f, 180f, pathBuilder = CatalogHelpers.ovalPath(130f, 120f, 270f, 250f)),
            CatalogHelpers.createRegion("ear_left", "Ліве довге вухо", 155f, 65f, pathBuilder = CatalogHelpers.ovalPath(135f, 20f, 175f, 130f)),
            CatalogHelpers.createRegion("ear_right", "Праве довге вухо", 245f, 65f, pathBuilder = CatalogHelpers.ovalPath(225f, 20f, 265f, 130f)),
            CatalogHelpers.createRegion("body", "Пухнастий животик", 200f, 295f, pathBuilder = CatalogHelpers.ovalPath(125f, 230f, 275f, 360f))
        )
    )

    // 29: Плюшевий Ведмедик (Teddy Bear)
    private fun createLevel29() = ColoringPicture(
        id = 29, title = "Плюшевий Ведмедик", subtitle = "Добрий ведмедик із медовим барильцем", levelNumber = 29, categoryTier = 2,
        stickerReward = StickerReward("sticker_29", "🧸", "Ведмежа-Ласун", "Обожнює солодкий медок!", Color(0xFF8B572A)),
        regions = listOf(
            CatalogHelpers.createRegion("head", "Голова ведмедика", 200f, 140f, pathBuilder = CatalogHelpers.ovalPath(125f, 75f, 275f, 215f)),
            CatalogHelpers.createRegion("ear_l", "Ліве кругле вухо", 130f, 80f, pathBuilder = CatalogHelpers.ovalPath(110f, 60f, 150f, 105f)),
            CatalogHelpers.createRegion("ear_r", "Праве кругле вухо", 270f, 80f, pathBuilder = CatalogHelpers.ovalPath(250f, 60f, 290f, 105f)),
            CatalogHelpers.createRegion("body", "Животик", 200f, 265f, pathBuilder = CatalogHelpers.ovalPath(120f, 195f, 280f, 345f)),
            CatalogHelpers.createRegion("honey_pot", "Горщик з медом", 270f, 280f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(245f * sx, 255f * sy); lineTo(295f * sx, 255f * sy); lineTo(305f * sx, 320f * sy); lineTo(235f * sx, 320f * sy); close() }
            }
        )
    )

    // 30: Маленький Їжачок (Hedgehog)
    private fun createLevel30() = ColoringPicture(
        id = 30, title = "Маленький Їжачок", subtitle = "Колючий лісовий друг з яблучком", levelNumber = 30, categoryTier = 2,
        stickerReward = StickerReward("sticker_30", "🦔", "Мудрий Їжачок", "Працьовитий лісовий помічник!", Color(0xFF8B572A)),
        regions = listOf(
            CatalogHelpers.createRegion("spikes", "Колюча спинка", 185f, 200f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(80f * sx, 260f * sy); cubicTo(70f * sx, 120f * sy, 270f * sx, 100f * sy, 280f * sx, 240f * sy); close() }
            },
            CatalogHelpers.createRegion("face", "Мордочка їжачка", 295f, 235f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(270f * sx, 195f * sy); lineTo(345f * sx, 235f * sy); lineTo(270f * sx, 265f * sy); close() }
            },
            CatalogHelpers.createRegion("apple_on_back", "Яблучко на голках", 160f, 115f, pathBuilder = CatalogHelpers.ovalPath(135f, 90f, 185f, 140f))
        )
    )

    // 31: Зелена Жабка (Frog)
    private fun createLevel31() = ColoringPicture(
        id = 31, title = "Зелена Жабка", subtitle = "Весела квакушка на лататті", levelNumber = 31, categoryTier = 2,
        stickerReward = StickerReward("sticker_31", "🐸", "Жабка-Мандрівниця", "Ква-ква у ставку!", Color(0xFF34C759)),
        regions = listOf(
            CatalogHelpers.createRegion("frog_head", "Голова", 200f, 150f, pathBuilder = CatalogHelpers.ovalPath(120f, 100f, 280f, 200f)),
            CatalogHelpers.createRegion("eye_l", "Ліве очко", 145f, 105f, pathBuilder = CatalogHelpers.ovalPath(125f, 80f, 165f, 130f)),
            CatalogHelpers.createRegion("eye_r", "Праве очко", 255f, 105f, pathBuilder = CatalogHelpers.ovalPath(235f, 80f, 275f, 130f)),
            CatalogHelpers.createRegion("frog_body", "Тільце", 200f, 245f, pathBuilder = CatalogHelpers.ovalPath(130f, 185f, 270f, 305f)),
            CatalogHelpers.createRegion("lily_pad", "Листок латаття", 200f, 325f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(70f * sx, 330f * sy); cubicTo(70f * sx, 290f * sy, 330f * sx, 290f * sy, 330f * sx, 330f * sy); cubicTo(330f * sx, 370f * sy, 70f * sx, 370f * sy, 70f * sx, 330f * sy); close() }
            }
        )
    )

    // 32: Мудра Сова (Owl)
    private fun createLevel32() = ColoringPicture(
        id = 32, title = "Мудра Сова", subtitle = "Лісова сова з великими очима", levelNumber = 32, categoryTier = 2,
        stickerReward = StickerReward("sticker_32", "🦉", "Мудра Совуня", "Бачить у темряві все!", Color(0xFF8B572A)),
        regions = listOf(
            CatalogHelpers.createRegion("owl_body", "Тіло сови", 200f, 190f, pathBuilder = CatalogHelpers.ovalPath(120f, 90f, 280f, 290f)),
            CatalogHelpers.createRegion("eye_patch_l", "Ліве око", 160f, 150f, pathBuilder = CatalogHelpers.ovalPath(130f, 120f, 190f, 180f)),
            CatalogHelpers.createRegion("eye_patch_r", "Праве око", 240f, 150f, pathBuilder = CatalogHelpers.ovalPath(210f, 120f, 270f, 180f)),
            CatalogHelpers.createRegion("wing_l", "Ліве крило", 105f, 210f, pathBuilder = CatalogHelpers.ovalPath(75f, 160f, 135f, 260f)),
            CatalogHelpers.createRegion("wing_r", "Праве крило", 295f, 210f, pathBuilder = CatalogHelpers.ovalPath(265f, 160f, 325f, 260f)),
            CatalogHelpers.createRegion("branch", "Гілка дуба", 200f, 320f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(60f * sx, 310f * sy); lineTo(340f * sx, 310f * sy); lineTo(340f * sx, 335f * sy); lineTo(60f * sx, 335f * sy); close() }
            }
        )
    )

    // 33: Черепашка-Повільня (Turtle)
    private fun createLevel33() = ColoringPicture(
        id = 33, title = "Черепашка-Повільня", subtitle = "Черепашка з міцним візерунчастим панциром", levelNumber = 33, categoryTier = 2,
        stickerReward = StickerReward("sticker_33", "🐢", "Спокійна Черепаха", "Нікуди не поспішає і всюди встигає!", Color(0xFF34C759)),
        regions = listOf(
            CatalogHelpers.createRegion("shell", "Панцир", 190f, 200f, pathBuilder = CatalogHelpers.ovalPath(100f, 130f, 280f, 270f)),
            CatalogHelpers.createRegion("head", "Голова", 310f, 185f, pathBuilder = CatalogHelpers.ovalPath(275f, 160f, 345f, 215f)),
            CatalogHelpers.createRegion("leg_fl", "Передня лапка", 260f, 265f, pathBuilder = CatalogHelpers.ovalPath(240f, 250f, 280f, 285f)),
            CatalogHelpers.createRegion("leg_bl", "Задня лапка", 125f, 265f, pathBuilder = CatalogHelpers.ovalPath(105f, 250f, 145f, 285f))
        )
    )

    // 34: Маленький Равлик (Snail)
    private fun createLevel34() = ColoringPicture(
        id = 34, title = "Маленький Равлик", subtitle = "Равлик із красивою крученою мушлею", levelNumber = 34, categoryTier = 2,
        stickerReward = StickerReward("sticker_34", "🐌", "Равлик-Павлик", "Носить свою хатинку з собою!", Color(0xFFFF9500)),
        regions = listOf(
            CatalogHelpers.createRegion("shell", "Мушля равлика", 185f, 195f, pathBuilder = CatalogHelpers.ovalPath(110f, 120f, 260f, 270f)),
            CatalogHelpers.createRegion("body", "Тільце равлика", 220f, 260f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(80f * sx, 270f * sy); lineTo(330f * sx, 270f * sy); lineTo(335f * sx, 230f * sy); cubicTo(300f * sx, 220f * sy, 260f * sx, 240f * sy, 220f * sx, 250f * sy); lineTo(80f * sx, 250f * sy); close() }
            },
            CatalogHelpers.createRegion("antenna", "Ріжки", 330f, 190f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(325f * sx, 230f * sy); lineTo(320f * sx, 175f * sy); lineTo(335f * sx, 175f * sy); lineTo(335f * sx, 230f * sy); close() }
            }
        )
    )

    // 35: Жовте Каченя (Duck)
    private fun createLevel35() = ColoringPicture(
        id = 35, title = "Жовте Каченя", subtitle = "Маленьке пташеня біля теплого озерця", levelNumber = 35, categoryTier = 2,
        stickerReward = StickerReward("sticker_35", "🐥", "Золоте Каченя", "Хлюпочеться у воді!", Color(0xFFFFD54F)),
        regions = listOf(
            CatalogHelpers.createRegion("head", "Голова каченяти", 175f, 135f, pathBuilder = CatalogHelpers.ovalPath(130f, 90f, 220f, 180f)),
            CatalogHelpers.createRegion("bill", "Дзьобик", 95f, 140f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(135f * sx, 125f * sy); lineTo(70f * sx, 140f * sy); lineTo(135f * sx, 155f * sy); close() }
            },
            CatalogHelpers.createRegion("body", "Тільце", 230f, 230f, pathBuilder = CatalogHelpers.ovalPath(150f, 170f, 310f, 290f)),
            CatalogHelpers.createRegion("wing", "Крильце", 225f, 225f, pathBuilder = CatalogHelpers.ovalPath(185f, 190f, 265f, 260f))
        )
    )

    // 36: Пінгвін на крижині (Penguin)
    private fun createLevel36() = ColoringPicture(
        id = 36, title = "Пінгвін на крижині", subtitle = "Південний пінгвінчик у теплому шарфику", levelNumber = 36, categoryTier = 2,
        stickerReward = StickerReward("sticker_36", "🐧", "Полярний Пінгвін", "Любить морозну зиму!", Color(0xFF00C7FF)),
        regions = listOf(
            CatalogHelpers.createRegion("body_black", "Тіло пінгвіна", 200f, 195f, pathBuilder = CatalogHelpers.ovalPath(120f, 80f, 280f, 310f)),
            CatalogHelpers.createRegion("belly_white", "Білий животик", 200f, 210f, pathBuilder = CatalogHelpers.ovalPath(150f, 125f, 250f, 295f)),
            CatalogHelpers.createRegion("beak", "Дзьоб", 200f, 115f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(185f * sx, 110f * sy); lineTo(215f * sx, 110f * sy); lineTo(200f * sx, 130f * sy); close() }
            },
            CatalogHelpers.createRegion("iceberg", "Крижина", 200f, 335f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(70f * sx, 330f * sy); lineTo(330f * sx, 330f * sy); lineTo(300f * sx, 365f * sy); lineTo(100f * sx, 365f * sy); close() }
            }
        )
    )

    // 37: Сміливе Левеня (Lion)
    private fun createLevel37() = ColoringPicture(
        id = 37, title = "Сміливе Левеня", subtitle = "Маленький цар звірів із золотою гривою", levelNumber = 37, categoryTier = 2,
        stickerReward = StickerReward("sticker_37", "🦁", "Хоробрий Левчик", "Володар савани!", Color(0xFFFF9500)),
        regions = listOf(
            CatalogHelpers.createRegion("mane", "Розкішна грива", 200f, 170f, pathBuilder = CatalogHelpers.ovalPath(90f, 60f, 310f, 280f)),
            CatalogHelpers.createRegion("face", "Мордочка лева", 200f, 170f, pathBuilder = CatalogHelpers.ovalPath(135f, 105f, 265f, 235f)),
            CatalogHelpers.createRegion("body", "Тіло левеняти", 200f, 305f, pathBuilder = CatalogHelpers.ovalPath(140f, 250f, 260f, 360f))
        )
    )

    // 38: Добрий Слоник (Elephant)
    private fun createLevel38() = ColoringPicture(
        id = 38, title = "Добрий Слоник", subtitle = "Слоник з довгим хоботом і великими вухами", levelNumber = 38, categoryTier = 2,
        stickerReward = StickerReward("sticker_38", "🐘", "Слоник-Велетень", "Добрий велетень!", Color(0xFF007AFF)),
        regions = listOf(
            CatalogHelpers.createRegion("body", "Тіло слоника", 220f, 220f, pathBuilder = CatalogHelpers.ovalPath(140f, 140f, 300f, 300f)),
            CatalogHelpers.createRegion("head", "Голова", 140f, 180f, pathBuilder = CatalogHelpers.ovalPath(95f, 130f, 185f, 230f)),
            CatalogHelpers.createRegion("ear", "Велике вухо", 185f, 175f, pathBuilder = CatalogHelpers.ovalPath(160f, 125f, 215f, 235f)),
            CatalogHelpers.createRegion("trunk", "Хобот", 85f, 240f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(125f * sx, 205f * sy); cubicTo(70f * sx, 230f * sy, 60f * sx, 290f * sy, 95f * sx, 280f * sy); cubicTo(80f * sx, 260f * sy, 90f * sx, 220f * sy, 135f * sx, 215f * sy); close() }
            }
        )
    )

    // 39: Плямиста Жирафа (Giraffe)
    private fun createLevel39() = ColoringPicture(
        id = 39, title = "Плямиста Жирафа", subtitle = "Висока жирафа з доброю посмішкою", levelNumber = 39, categoryTier = 2,
        stickerReward = StickerReward("sticker_39", "🦒", "Висока Жирафа", "Дістає до верхівок дерев!", Color(0xFFFFD54F)),
        regions = listOf(
            CatalogHelpers.createRegion("head", "Голова жирафи", 170f, 85f, pathBuilder = CatalogHelpers.ovalPath(140f, 55f, 200f, 115f)),
            CatalogHelpers.createRegion("neck", "Довга шия", 185f, 190f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(165f * sx, 105f * sy); lineTo(195f * sx, 105f * sy); lineTo(215f * sx, 280f * sy); lineTo(175f * sx, 280f * sy); close() }
            },
            CatalogHelpers.createRegion("body", "Тільце", 230f, 305f, pathBuilder = CatalogHelpers.ovalPath(170f, 260f, 290f, 350f)),
            CatalogHelpers.createRegion("spot_1", "Плямка 1", 185f, 160f, pathBuilder = CatalogHelpers.ovalPath(175f, 145f, 195f, 175f)),
            CatalogHelpers.createRegion("spot_2", "Плямка 2", 195f, 220f, pathBuilder = CatalogHelpers.ovalPath(185f, 205f, 205f, 235f))
        )
    )

    // 40: Грайливий Дельфін (Dolphin)
    private fun createLevel40() = ColoringPicture(
        id = 40, title = "Грайливий Дельфін", subtitle = "Морський стрибун серед хвиль", levelNumber = 40, categoryTier = 2,
        stickerReward = StickerReward("sticker_40", "🐬", "Морський Дельфін", "Стрибає через хвилі!", Color(0xFF00C7FF)),
        regions = listOf(
            CatalogHelpers.createRegion("dolphin_body", "Тіло дельфіна", 200f, 180f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(80f * sx, 220f * sy); cubicTo(110f * sx, 90f * sy, 270f * sx, 90f * sy, 320f * sx, 210f * sy); cubicTo(260f * sx, 220f * sy, 140f * sx, 235f * sy, 80f * sx, 220f * sy); close() }
            },
            CatalogHelpers.createRegion("dorsal_fin", "Плавець", 200f, 95f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(180f * sx, 120f * sy); lineTo(205f * sx, 65f * sy); lineTo(230f * sx, 125f * sy); close() }
            },
            CatalogHelpers.createRegion("tail_fluke", "Хвіст", 335f, 230f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(315f * sx, 210f * sy); lineTo(365f * sx, 190f * sy); lineTo(350f * sx, 230f * sy); lineTo(365f * sx, 270f * sy); close() }
            },
            CatalogHelpers.createRegion("wave", "Морська піна", 200f, 320f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(60f * sx, 330f * sy); cubicTo(130f * sx, 290f * sy, 270f * sx, 350f * sy, 340f * sx, 310f * sy); lineTo(340f * sx, 360f * sy); lineTo(60f * sx, 360f * sy); close() }
            }
        )
    )

    // 41: Синій Китик (Whale)
    private fun createLevel41() = ColoringPicture(
        id = 41, title = "Синій Китик", subtitle = "Величний добрий кит із водяним фонтанчиком", levelNumber = 41, categoryTier = 2,
        stickerReward = StickerReward("sticker_41", "🐳", "Веселий Китик", "Фонтанчик радості!", Color(0xFF007AFF)),
        regions = listOf(
            CatalogHelpers.createRegion("whale_body", "Тіло кита", 190f, 220f, pathBuilder = CatalogHelpers.ovalPath(80f, 150f, 300f, 290f)),
            CatalogHelpers.createRegion("fountain", "Водяний фонтан", 150f, 95f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(150f * sx, 150f * sy); cubicTo(120f * sx, 60f * sy, 90f * sx, 80f * sy, 90f * sx, 100f * sy); cubicTo(110f * sx, 90f * sy, 140f * sx, 110f * sy, 150f * sx, 150f * sy); close() }
            },
            CatalogHelpers.createRegion("fountain_r", "Правий струмінь", 175f, 95f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(155f * sx, 150f * sy); cubicTo(185f * sx, 60f * sy, 215f * sx, 80f * sy, 215f * sx, 100f * sy); cubicTo(195f * sx, 90f * sy, 165f * sx, 110f * sy, 155f * sx, 150f * sy); close() }
            },
            CatalogHelpers.createRegion("whale_tail", "Хвостовий плавець", 325f, 200f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(290f * sx, 210f * sy); lineTo(355f * sx, 150f * sy); lineTo(335f * sx, 205f * sy); lineTo(355f * sx, 260f * sy); close() }
            }
        )
    )

    // 42: Бамбукова Панда (Panda)
    private fun createLevel42() = ColoringPicture(
        id = 42, title = "Бамбукова Панда", subtitle = "Чорно-біле ведмежа із зеленим пагоном", levelNumber = 42, categoryTier = 2,
        stickerReward = StickerReward("sticker_42", "🐼", "Панда-Мрійниця", "Ласує солодким бамбуком!", Color(0xFF34C759)),
        regions = listOf(
            CatalogHelpers.createRegion("face", "Мордочка панди", 200f, 150f, pathBuilder = CatalogHelpers.ovalPath(125f, 85f, 275f, 215f)),
            CatalogHelpers.createRegion("ear_l", "Чорне вушко ліве", 125f, 85f, pathBuilder = CatalogHelpers.ovalPath(105f, 65f, 145f, 110f)),
            CatalogHelpers.createRegion("ear_r", "Чорне вушко праве", 275f, 85f, pathBuilder = CatalogHelpers.ovalPath(255f, 65f, 295f, 110f)),
            CatalogHelpers.createRegion("eye_patch_l", "Очна плямка ліва", 160f, 145f, pathBuilder = CatalogHelpers.ovalPath(145f, 125f, 175f, 165f)),
            CatalogHelpers.createRegion("eye_patch_r", "Очна плямка права", 240f, 145f, pathBuilder = CatalogHelpers.ovalPath(225f, 125f, 255f, 165f)),
            CatalogHelpers.createRegion("bamboo", "Пагін бамбука", 305f, 240f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(295f * sx, 150f * sy); lineTo(315f * sx, 150f * sy); lineTo(315f * sx, 330f * sy); lineTo(295f * sx, 330f * sy); close() }
            }
        )
    )

    // 43: Руда Лисичка (Fox)
    private fun createLevel43() = ColoringPicture(
        id = 43, title = "Руда Лисичка", subtitle = "Хитра сестричка з пухнастим хвостом", levelNumber = 43, categoryTier = 2,
        stickerReward = StickerReward("sticker_43", "🦊", "Руда Лисичка", "Швидка та кмітлива!", Color(0xFFFF9500)),
        regions = listOf(
            CatalogHelpers.createRegion("fox_head", "Голова лисички", 185f, 160f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(115f * sx, 115f * sy); lineTo(255f * sx, 115f * sy); lineTo(185f * sx, 215f * sy); close() }
            },
            CatalogHelpers.createRegion("ear_l", "Ліве вухо", 130f, 75f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(115f * sx, 115f * sy); lineTo(130f * sx, 45f * sy); lineTo(165f * sx, 115f * sy); close() }
            },
            CatalogHelpers.createRegion("ear_r", "Праве вухо", 240f, 75f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(205f * sx, 115f * sy); lineTo(240f * sx, 45f * sy); lineTo(255f * sx, 115f * sy); close() }
            },
            CatalogHelpers.createRegion("tail", "Пухнастий хвіст", 280f, 260f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(185f * sx, 245f * sy); cubicTo(330f * sx, 200f * sy, 360f * sx, 310f * sy, 220f * sx, 330f * sy); close() }
            }
        )
    )

    // 44: Прудка Білочка (Squirrel)
    private fun createLevel44() = ColoringPicture(
        id = 44, title = "Прудка Білочка", subtitle = "Лісова білочка із золотим горішком", levelNumber = 44, categoryTier = 2,
        stickerReward = StickerReward("sticker_44", "🐿️", "Лісова Білочка", "Стрибає з гілки на гілку!", Color(0xFFFF9500)),
        regions = listOf(
            CatalogHelpers.createRegion("head", "Голова білочки", 170f, 150f, pathBuilder = CatalogHelpers.ovalPath(125f, 110f, 215f, 190f)),
            CatalogHelpers.createRegion("body", "Тільце", 185f, 250f, pathBuilder = CatalogHelpers.ovalPath(140f, 190f, 230f, 310f)),
            CatalogHelpers.createRegion("big_tail", "Величезний хвіст", 270f, 185f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(195f * sx, 290f * sy); cubicTo(330f * sx, 290f * sy, 350f * sx, 80f * sy, 260f * sx, 75f * sy); cubicTo(300f * sx, 130f * sy, 250f * sx, 220f * sy, 205f * sx, 260f * sy); close() }
            },
            CatalogHelpers.createRegion("acorn", "Горішок", 130f, 220f, pathBuilder = CatalogHelpers.ovalPath(115f, 205f, 145f, 235f))
        )
    )

    // 45: Сонечко-Жучок (Ladybug)
    private fun createLevel45() = ColoringPicture(
        id = 45, title = "Сонечко-Жучок", subtitle = "Червоний жучок із чорними цяточками", levelNumber = 45, categoryTier = 2,
        stickerReward = StickerReward("sticker_45", "🐞", "Щасливий Жучок", "Приносить удачу!", Color(0xFFFF3B30)),
        regions = listOf(
            CatalogHelpers.createRegion("head", "Чорна голівка", 200f, 95f, pathBuilder = CatalogHelpers.ovalPath(165f, 65f, 235f, 125f)),
            CatalogHelpers.createRegion("wing_l", "Ліве крильце", 150f, 210f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(195f * sx, 115f * sy); cubicTo(90f * sx, 130f * sy, 85f * sx, 290f * sy, 195f * sx, 310f * sy); close() }
            },
            CatalogHelpers.createRegion("wing_r", "Праве крильце", 250f, 210f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(205f * sx, 115f * sy); cubicTo(310f * sx, 130f * sy, 315f * sx, 290f * sy, 205f * sx, 310f * sy); close() }
            },
            CatalogHelpers.createRegion("dot_l", "Цяточка ліва", 145f, 210f, pathBuilder = CatalogHelpers.ovalPath(130f, 195f, 160f, 225f)),
            CatalogHelpers.createRegion("dot_r", "Цяточка права", 255f, 210f, pathBuilder = CatalogHelpers.ovalPath(240f, 195f, 270f, 225f))
        )
    )

    // 46: Працьовита Бджілка (Bee)
    private fun createLevel46() = ColoringPicture(
        id = 46, title = "Працьовита Бджілка", subtitle = "Смугаста трудівниця біля солодкого меду", levelNumber = 46, categoryTier = 2,
        stickerReward = StickerReward("sticker_46", "🐝", "Бджілка-Мая", "Збирає запашний нектар!", Color(0xFFFFD54F)),
        regions = listOf(
            CatalogHelpers.createRegion("bee_body", "Тільце бджілки", 190f, 210f, pathBuilder = CatalogHelpers.ovalPath(120f, 150f, 260f, 270f)),
            CatalogHelpers.createRegion("head", "Голівка", 105f, 210f, pathBuilder = CatalogHelpers.ovalPath(80f, 185f, 130f, 235f)),
            CatalogHelpers.createRegion("wing_top", "Верхнє прозоре крило", 200f, 105f, pathBuilder = CatalogHelpers.ovalPath(165f, 60f, 235f, 155f)),
            CatalogHelpers.createRegion("wing_bot", "Нижнє крило", 240f, 120f, pathBuilder = CatalogHelpers.ovalPath(210f, 85f, 270f, 155f))
        )
    )

    // 47: Біла Овечка (Sheep)
    private fun createLevel47() = ColoringPicture(
        id = 47, title = "Біла Овечка", subtitle = "Кучерява м'яка овечка на пасовищі", levelNumber = 47, categoryTier = 2,
        stickerReward = StickerReward("sticker_47", "🐑", "Кучерява Овечка", "М'якенька як хмаринка!", Color(0xFF00C7FF)),
        regions = listOf(
            CatalogHelpers.createRegion("fleece", "Хмаринка вовни", 200f, 200f, pathBuilder = CatalogHelpers.ovalPath(100f, 120f, 300f, 280f)),
            CatalogHelpers.createRegion("head", "Мордочка овечки", 130f, 200f, pathBuilder = CatalogHelpers.ovalPath(95f, 160f, 165f, 240f)),
            CatalogHelpers.createRegion("leg_front", "Передні ніжки", 160f, 305f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(150f * sx, 275f * sy); lineTo(170f * sx, 275f * sy); lineTo(170f * sx, 340f * sy); lineTo(150f * sx, 340f * sy); close() }
            },
            CatalogHelpers.createRegion("leg_back", "Задні ніжки", 240f, 305f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(230f * sx, 275f * sy); lineTo(250f * sx, 275f * sy); lineTo(250f * sx, 340f * sy); lineTo(230f * sx, 340f * sy); close() }
            }
        )
    )

    // 48: Маленьке Оленятко (Deer)
    private fun createLevel48() = ColoringPicture(
        id = 48, title = "Маленьке Оленятко", subtitle = "Лісове плямисте оленятко з ріжками", levelNumber = 48, categoryTier = 2,
        stickerReward = StickerReward("sticker_48", "🦌", "Лісовий Олень", "Стрункий красунь діброви!", Color(0xFF8B572A)),
        regions = listOf(
            CatalogHelpers.createRegion("head", "Голова оленятка", 160f, 130f, pathBuilder = CatalogHelpers.ovalPath(120f, 90f, 200f, 170f)),
            CatalogHelpers.createRegion("body", "Тільце", 230f, 230f, pathBuilder = CatalogHelpers.ovalPath(160f, 170f, 300f, 290f)),
            CatalogHelpers.createRegion("antler_l", "Лівий ріжок", 140f, 60f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(150f * sx, 95f * sy); lineTo(130f * sx, 35f * sy); lineTo(145f * sx, 35f * sy); lineTo(155f * sx, 95f * sy); close() }
            },
            CatalogHelpers.createRegion("antler_r", "Правий ріжок", 175f, 60f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(165f * sx, 95f * sy); lineTo(185f * sx, 35f * sy); lineTo(195f * sx, 35f * sy); lineTo(175f * sx, 95f * sy); close() }
            }
        )
    )

    // 49: Рожевий Фламінго (Flamingo)
    private fun createLevel49() = ColoringPicture(
        id = 49, title = "Рожевий Фламінго", subtitle = "Стрункий птах на одній ніжці", levelNumber = 49, categoryTier = 2,
        stickerReward = StickerReward("sticker_49", "🦩", "Граційний Фламінго", "Сяє ніжними рожевими барвами!", Color(0xFFFF4081)),
        regions = listOf(
            CatalogHelpers.createRegion("flamingo_body", "Тільце фламінго", 230f, 200f, pathBuilder = CatalogHelpers.ovalPath(170f, 150f, 290f, 250f)),
            CatalogHelpers.createRegion("neck", "Вигнута шия", 160f, 140f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(190f * sx, 185f * sy); cubicTo(130f * sx, 180f * sy, 120f * sx, 70f * sy, 175f * sx, 70f * sy); lineTo(185f * sx, 85f * sy); cubicTo(145f * sx, 85f * sy, 150f * sx, 170f * sy, 195f * sx, 195f * sy); close() }
            },
            CatalogHelpers.createRegion("beak", "Дзьоб", 195f, 95f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(180f * sx, 80f * sy); lineTo(215f * sx, 95f * sy); lineTo(185f * sx, 105f * sy); close() }
            },
            CatalogHelpers.createRegion("legs", "Стрункі ноги", 230f, 310f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(225f * sx, 245f * sy); lineTo(225f * sx, 365f * sy); lineTo(235f * sx, 365f * sy); lineTo(235f * sx, 245f * sy); close() }
            }
        )
    )

    // 50: Яскравий Папужка (Parrot)
    private fun createLevel50() = ColoringPicture(
        id = 50, title = "Яскравий Папужка", subtitle = "Тропічний птах із різнобарвним пір'ям", levelNumber = 50, categoryTier = 2,
        stickerReward = StickerReward("sticker_50", "🦜", "Тропічний Папуга", "Розмовляє та співає пісеньки!", Color(0xFF34C759)),
        regions = listOf(
            CatalogHelpers.createRegion("head", "Голова папуги", 175f, 115f, pathBuilder = CatalogHelpers.ovalPath(135f, 75f, 215f, 155f)),
            CatalogHelpers.createRegion("beak", "Гачкуватий дзьоб", 125f, 125f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(145f * sx, 105f * sy); lineTo(95f * sx, 130f * sy); lineTo(145f * sx, 145f * sy); close() }
            },
            CatalogHelpers.createRegion("body", "Тільце", 200f, 210f, pathBuilder = CatalogHelpers.ovalPath(150f, 145f, 250f, 275f)),
            CatalogHelpers.createRegion("wing", "Крило", 220f, 215f, pathBuilder = CatalogHelpers.ovalPath(180f, 175f, 260f, 255f)),
            CatalogHelpers.createRegion("tail", "Довгий хвіст", 240f, 320f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(205f * sx, 270f * sy); lineTo(260f * sx, 365f * sy); lineTo(235f * sx, 365f * sy); lineTo(195f * sx, 270f * sy); close() }
            }
        )
    )
}
