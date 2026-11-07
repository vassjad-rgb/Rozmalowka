package com.example.data.catalog

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import com.example.model.ColoringPicture
import com.example.model.StickerReward

object LevelCatalog1To25 {

    val levels: List<ColoringPicture> by lazy {
        listOf(
            createLevel1(), createLevel2(), createLevel3(), createLevel4(), createLevel5(),
            createLevel6(), createLevel7(), createLevel8(), createLevel9(), createLevel10(),
            createLevel11(), createLevel12(), createLevel13(), createLevel14(), createLevel15(),
            createLevel16(), createLevel17(), createLevel18(), createLevel19(), createLevel20(),
            createLevel21(), createLevel22(), createLevel23(), createLevel24(), createLevel25()
        )
    }

    // 1: Веселе Сонечко
    private fun createLevel1(): ColoringPicture {
        val regions = mutableListOf(
            CatalogHelpers.createRegion("sun_face", "Личко Сонечка", 200f, 200f, pathBuilder = CatalogHelpers.ovalPath(140f, 140f, 260f, 260f))
        )
        val angles = listOf(0, 45, 90, 135, 180, 225, 270, 315)
        angles.forEachIndexed { idx, deg ->
            val rad = Math.toRadians(deg.toDouble())
            val tipX = (200f + 145f * Math.cos(rad)).toFloat()
            val tipY = (200f + 145f * Math.sin(rad)).toFloat()
            val rL = Math.toRadians((deg - 16.0))
            val rR = Math.toRadians((deg + 16.0))
            regions.add(CatalogHelpers.createRegion("ray_$idx", "Промінчик ${idx + 1}", tipX, tipY) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply {
                    moveTo((200f + 65f * Math.cos(rL)).toFloat() * sx, (200f + 65f * Math.sin(rL)).toFloat() * sy)
                    lineTo(tipX * sx, tipY * sy)
                    lineTo((200f + 65f * Math.cos(rR)).toFloat() * sx, (200f + 65f * Math.sin(rR)).toFloat() * sy)
                    close()
                }
            })
        }
        return ColoringPicture(
            id = 1, title = "Веселе Сонечко", subtitle = "Тепле сонечко з великими промінчиками", levelNumber = 1, categoryTier = 1,
            stickerReward = StickerReward("sticker_1", "☀️", "Золоте Сонечко", "Сяє теплом і дарує радість!", Color(0xFFFFD54F)),
            regions = regions,
            outlinePainter = { scope, w, h ->
                val sx = w / 400f; val sy = h / 400f
                scope.drawCircle(Color(0xFF222222), 8f * sx, Offset(175f * sx, 190f * sy))
                scope.drawCircle(Color(0xFF222222), 8f * sx, Offset(225f * sx, 190f * sy))
                scope.drawCircle(Color.White, 3f * sx, Offset(172f * sx, 187f * sy))
                scope.drawCircle(Color.White, 3f * sx, Offset(222f * sx, 187f * sy))
                val smile = Path().apply { moveTo(180f * sx, 212f * sy); quadraticTo(200f * sx, 235f * sy, 220f * sx, 212f * sy) }
                scope.drawPath(smile, Color(0xFF222222), style = Stroke(width = 5f * sx, cap = StrokeCap.Round))
            }
        )
    }

    // 2: Соковите Яблуко
    private fun createLevel2() = ColoringPicture(
        id = 2, title = "Соковите Яблуко", subtitle = "Кругле яблучко з гілочкою та листочком", levelNumber = 2, categoryTier = 1,
        stickerReward = StickerReward("sticker_2", "🍎", "Червоне Яблучко", "Солодке та вітамінне!", Color(0xFFFF3B30)),
        regions = listOf(
            CatalogHelpers.createRegion("apple_l", "Ліва половинка", 160f, 210f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(200f * sx, 120f * sy); cubicTo(120f * sx, 100f * sy, 80f * sx, 200f * sy, 100f * sx, 270f * sy); cubicTo(120f * sx, 330f * sy, 180f * sx, 340f * sy, 200f * sx, 330f * sy); close() }
            },
            CatalogHelpers.createRegion("apple_r", "Права половинка", 240f, 210f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(200f * sx, 120f * sy); cubicTo(280f * sx, 100f * sy, 320f * sx, 200f * sy, 300f * sx, 270f * sy); cubicTo(280f * sx, 330f * sy, 220f * sx, 340f * sy, 200f * sx, 330f * sy); close() }
            },
            CatalogHelpers.createRegion("apple_stem", "Гілочка", 200f, 90f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(195f * sx, 120f * sy); lineTo(192f * sx, 70f * sy); lineTo(208f * sx, 70f * sy); lineTo(205f * sx, 120f * sy); close() }
            },
            CatalogHelpers.createRegion("apple_leaf", "Листочок", 240f, 75f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(208f * sx, 70f * sy); quadraticTo(240f * sx, 45f * sy, 275f * sx, 65f * sy); quadraticTo(245f * sx, 95f * sy, 208f * sx, 70f * sy); close() }
            }
        )
    )

    // 3: Повітряна Кулька
    private fun createLevel3() = ColoringPicture(
        id = 3, title = "Повітряна Кулька", subtitle = "Яскрава святкова кулька зі стрічкою", levelNumber = 3, categoryTier = 1,
        stickerReward = StickerReward("sticker_3", "🎈", "Чарівна Кулька", "Злітає високо у небо!", Color(0xFFFF4081)),
        regions = listOf(
            CatalogHelpers.createRegion("balloon_main", "Кулька", 200f, 180f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(200f * sx, 290f * sy); cubicTo(90f * sx, 270f * sy, 80f * sx, 70f * sy, 200f * sx, 70f * sy); cubicTo(320f * sx, 70f * sy, 310f * sx, 270f * sy, 200f * sx, 290f * sy); close() }
            },
            CatalogHelpers.createRegion("balloon_knot", "Вузлик", 200f, 305f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(190f * sx, 290f * sy); lineTo(210f * sx, 290f * sy); lineTo(215f * sx, 315f * sy); lineTo(185f * sx, 315f * sy); close() }
            },
            CatalogHelpers.createRegion("balloon_ribbon", "Стрічка", 215f, 350f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(200f * sx, 315f * sy); cubicTo(230f * sx, 330f * sy, 180f * sx, 360f * sy, 215f * sx, 385f * sy); cubicTo(205f * sx, 385f * sy, 170f * sx, 360f * sy, 195f * sx, 315f * sy); close() }
            },
            CatalogHelpers.createRegion("balloon_glint", "Відблиск", 150f, 140f, pathBuilder = CatalogHelpers.ovalPath(135f, 115f, 165f, 165f))
        )
    )

    // 4: Яскрава Зірочка
    private fun createLevel4() = ColoringPicture(
        id = 4, title = "Яскрава Зірочка", subtitle = "Велика добра зірочка у нічному небі", levelNumber = 4, categoryTier = 1,
        stickerReward = StickerReward("sticker_4", "⭐", "Супер Зірочка", "Освітлює казки!", Color(0xFFFFD54F)),
        regions = listOf(
            CatalogHelpers.createRegion("star_center", "Центр зірки", 200f, 200f, pathBuilder = CatalogHelpers.ovalPath(160f, 160f, 240f, 240f)),
            CatalogHelpers.createRegion("star_t", "Верхній промінь", 200f, 90f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(170f * sx, 165f * sy); lineTo(200f * sx, 50f * sy); lineTo(230f * sx, 165f * sy); close() }
            },
            CatalogHelpers.createRegion("star_tr", "Правий верхній", 280f, 160f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(230f * sx, 165f * sy); lineTo(345f * sx, 160f * sy); lineTo(235f * sx, 215f * sy); close() }
            },
            CatalogHelpers.createRegion("star_br", "Правий нижній", 260f, 280f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(235f * sx, 215f * sy); lineTo(295f * sx, 335f * sy); lineTo(200f * sx, 240f * sy); close() }
            },
            CatalogHelpers.createRegion("star_bl", "Лівий нижній", 140f, 280f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(200f * sx, 240f * sy); lineTo(105f * sx, 335f * sy); lineTo(165f * sx, 215f * sy); close() }
            },
            CatalogHelpers.createRegion("star_tl", "Лівий верхній", 120f, 160f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(165f * sx, 215f * sy); lineTo(55f * sx, 160f * sy); lineTo(170f * sx, 165f * sy); close() }
            }
        )
    )

    // 5: Лісовий Грибок
    private fun createLevel5() = ColoringPicture(
        id = 5, title = "Лісовий Грибок", subtitle = "Шапочка грибочка з білими цятками", levelNumber = 5, categoryTier = 1,
        stickerReward = StickerReward("sticker_5", "🍄", "Боровик-Здоровань", "Міцний та казковий!", Color(0xFFFF3B30)),
        regions = listOf(
            CatalogHelpers.createRegion("shroom_cap", "Шапочка", 200f, 140f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(70f * sx, 200f * sy); cubicTo(70f * sx, 70f * sy, 330f * sx, 70f * sy, 330f * sx, 200f * sy); close() }
            },
            CatalogHelpers.createRegion("shroom_stem", "Ніжка", 200f, 260f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(150f * sx, 200f * sy); lineTo(250f * sx, 200f * sy); cubicTo(270f * sx, 320f * sy, 250f * sx, 340f * sy, 230f * sx, 340f * sy); lineTo(170f * sx, 340f * sy); cubicTo(150f * sx, 340f * sy, 130f * sx, 320f * sy, 150f * sx, 200f * sy); close() }
            },
            CatalogHelpers.createRegion("dot_1", "Цятка 1", 140f, 130f, pathBuilder = CatalogHelpers.ovalPath(120f, 110f, 160f, 150f)),
            CatalogHelpers.createRegion("dot_2", "Цятка 2", 260f, 130f, pathBuilder = CatalogHelpers.ovalPath(240f, 110f, 280f, 150f)),
            CatalogHelpers.createRegion("grass", "Травичка", 200f, 355f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(80f * sx, 370f * sy); lineTo(120f * sx, 330f * sy); lineTo(160f * sx, 360f * sy); lineTo(200f * sx, 320f * sy); lineTo(240f * sx, 360f * sy); lineTo(280f * sx, 330f * sy); lineTo(320f * sx, 370f * sy); close() }
            }
        )
    )

    // 6: Пухнаста Хмаринка (Хмарка з краплями дощу!)
    private fun createLevel6() = ColoringPicture(
        id = 6, title = "Пухнаста Хмаринка", subtitle = "М'яка хмаринка з теплим літнім дощиком", levelNumber = 6, categoryTier = 1,
        stickerReward = StickerReward("sticker_6", "☁️", "Краплинка Дощу", "Дарує свіжість квітам!", Color(0xFF00C7FF)),
        regions = listOf(
            CatalogHelpers.createRegion("cloud_body", "Хмаринка", 200f, 160f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply {
                    moveTo(100f * sx, 220f * sy)
                    cubicTo(50f * sx, 220f * sy, 50f * sx, 150f * sy, 110f * sx, 140f * sy)
                    cubicTo(120f * sx, 80f * sy, 220f * sx, 80f * sy, 240f * sx, 130f * sy)
                    cubicTo(310f * sx, 110f * sy, 350f * sx, 180f * sy, 310f * sx, 220f * sy)
                    close()
                }
            },
            CatalogHelpers.createRegion("drop_1", "Крапелька 1", 130f, 280f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(130f * sx, 255f * sy); lineTo(145f * sx, 285f * sy); cubicTo(145f * sx, 305f * sy, 115f * sx, 305f * sy, 115f * sx, 285f * sy); close() }
            },
            CatalogHelpers.createRegion("drop_2", "Крапелька 2", 200f, 295f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(200f * sx, 270f * sy); lineTo(215f * sx, 300f * sy); cubicTo(215f * sx, 320f * sy, 185f * sx, 320f * sy, 185f * sx, 300f * sy); close() }
            },
            CatalogHelpers.createRegion("drop_3", "Крапелька 3", 270f, 280f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(270f * sx, 255f * sy); lineTo(285f * sx, 285f * sy); cubicTo(285f * sx, 305f * sy, 255f * sx, 305f * sy, 255f * sx, 285f * sy); close() }
            }
        )
    )

    // 7: Польова Ромашка (Daisy Flower)
    private fun createLevel7() = ColoringPicture(
        id = 7, title = "Польова Ромашка", subtitle = "Біла квіточка із золотою серединкою", levelNumber = 7, categoryTier = 1,
        stickerReward = StickerReward("sticker_7", "🌼", "Золота Ромашка", "Сонце серед трав!", Color(0xFFFFD54F)),
        regions = listOf(
            CatalogHelpers.createRegion("flower_center", "Серединка", 200f, 150f, pathBuilder = CatalogHelpers.ovalPath(170f, 120f, 230f, 180f)),
            CatalogHelpers.createRegion("petal_top", "Верхня пелюстка", 200f, 85f, pathBuilder = CatalogHelpers.ovalPath(185f, 50f, 215f, 125f)),
            CatalogHelpers.createRegion("petal_bottom", "Нижня пелюстка", 200f, 215f, pathBuilder = CatalogHelpers.ovalPath(185f, 175f, 215f, 250f)),
            CatalogHelpers.createRegion("petal_left", "Ліва пелюстка", 135f, 150f, pathBuilder = CatalogHelpers.ovalPath(100f, 135f, 175f, 165f)),
            CatalogHelpers.createRegion("petal_right", "Права пелюстка", 265f, 150f, pathBuilder = CatalogHelpers.ovalPath(225f, 135f, 300f, 165f)),
            CatalogHelpers.createRegion("stem", "Стебельце", 200f, 300f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(195f * sx, 240f * sy); lineTo(195f * sx, 360f * sy); lineTo(205f * sx, 360f * sy); lineTo(205f * sx, 240f * sy); close() }
            },
            CatalogHelpers.createRegion("leaf", "Листочок", 240f, 290f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(205f * sx, 300f * sy); cubicTo(240f * sx, 260f * sy, 280f * sx, 275f * sy, 275f * sx, 305f * sy); cubicTo(240f * sx, 315f * sy, 210f * sx, 310f * sy, 205f * sx, 300f * sy); close() }
            }
        )
    )

    // 8: Місяць-Молодик (Crescent Moon)
    private fun createLevel8() = ColoringPicture(
        id = 8, title = "Місяць-Молодик", subtitle = "Казковий місяць, що колише сни", levelNumber = 8, categoryTier = 1,
        stickerReward = StickerReward("sticker_8", "🌙", "Срібний Місяць", "Вартовий солодких снів!", Color(0xFFFFD54F)),
        regions = listOf(
            CatalogHelpers.createRegion("moon_body", "Місяць", 190f, 200f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply {
                    moveTo(240f * sx, 70f * sy)
                    cubicTo(120f * sx, 100f * sy, 110f * sx, 290f * sy, 240f * sx, 330f * sy)
                    cubicTo(170f * sx, 280f * sy, 170f * sx, 120f * sy, 240f * sx, 70f * sy)
                    close()
                }
            },
            CatalogHelpers.createRegion("star_companion", "Зірочка поруч", 300f, 130f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply {
                    moveTo(300f * sx, 105f * sy); lineTo(307f * sx, 122f * sy); lineTo(325f * sx, 125f * sy); lineTo(311f * sx, 137f * sy); lineTo(315f * sx, 155f * sy); lineTo(300f * sx, 144f * sy); lineTo(285f * sx, 155f * sy); lineTo(289f * sx, 137f * sy); lineTo(275f * sx, 125f * sy); lineTo(293f * sx, 122f * sy); close()
                }
            }
        )
    )

    // 9: Солодка Цукерка (Wrapped Candy)
    private fun createLevel9() = ColoringPicture(
        id = 9, title = "Солодка Цукерка", subtitle = "Смачний карамельний льодяник", levelNumber = 9, categoryTier = 1,
        stickerReward = StickerReward("sticker_9", "🍬", "Карамелька", "Найсолодша радість!", Color(0xFFFF4081)),
        regions = listOf(
            CatalogHelpers.createRegion("candy_center", "Цукерка", 200f, 200f, pathBuilder = CatalogHelpers.ovalPath(130f, 140f, 270f, 260f)),
            CatalogHelpers.createRegion("wrap_left", "Обгортка ліва", 90f, 200f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(140f * sx, 190f * sy); lineTo(60f * sx, 140f * sy); lineTo(60f * sx, 260f * sy); lineTo(140f * sx, 210f * sy); close() }
            },
            CatalogHelpers.createRegion("wrap_right", "Обгортка права", 310f, 200f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(260f * sx, 190f * sy); lineTo(340f * sx, 140f * sy); lineTo(340f * sx, 260f * sy); lineTo(260f * sx, 210f * sy); close() }
            }
        )
    )

    // 10: Смугастий Кавунчик (Watermelon Slice)
    private fun createLevel10() = ColoringPicture(
        id = 10, title = "Смугастий Кавунчик", subtitle = "Соковита скибочка літнього кавуна", levelNumber = 10, categoryTier = 1,
        stickerReward = StickerReward("sticker_10", "🍉", "Солодкий Кавунчик", "Охолоджує у спекотний день!", Color(0xFF34C759)),
        regions = listOf(
            CatalogHelpers.createRegion("rind", "Зелена шкірка", 200f, 310f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(60f * sx, 150f * sy); cubicTo(90f * sx, 330f * sy, 310f * sx, 330f * sy, 340f * sx, 150f * sy); lineTo(315f * sx, 150f * sy); cubicTo(290f * sx, 305f * sy, 110f * sx, 305f * sy, 85f * sx, 150f * sy); close() }
            },
            CatalogHelpers.createRegion("pulp", "Червона м'якоть", 200f, 220f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(85f * sx, 150f * sy); cubicTo(110f * sx, 305f * sy, 290f * sx, 305f * sy, 315f * sx, 150f * sy); close() }
            },
            CatalogHelpers.createRegion("seed_1", "Зернятко 1", 160f, 210f, pathBuilder = CatalogHelpers.ovalPath(152f, 202f, 168f, 218f)),
            CatalogHelpers.createRegion("seed_2", "Зернятко 2", 200f, 240f, pathBuilder = CatalogHelpers.ovalPath(192f, 232f, 208f, 248f)),
            CatalogHelpers.createRegion("seed_3", "Зернятко 3", 240f, 210f, pathBuilder = CatalogHelpers.ovalPath(232f, 202f, 248f, 218f))
        )
    )

    // 11: Веселий М'ячик
    private fun createLevel11() = ColoringPicture(
        id = 11, title = "Веселий М'ячик", subtitle = "Смугастий м'ячик для веселих ігор", levelNumber = 11, categoryTier = 1,
        stickerReward = StickerReward("sticker_11", "⚽", "Стрибучий М'ячик", "Стрибає вище за всіх!", Color(0xFF007AFF)),
        regions = listOf(
            CatalogHelpers.createRegion("stripe_mid", "Центральна смуга", 200f, 200f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(85f * sx, 160f * sy); lineTo(315f * sx, 160f * sy); lineTo(315f * sx, 240f * sy); lineTo(85f * sx, 240f * sy); close() }
            },
            CatalogHelpers.createRegion("stripe_top", "Верхня частина", 200f, 115f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(85f * sx, 160f * sy); cubicTo(110f * sx, 80f * sy, 290f * sx, 80f * sy, 315f * sx, 160f * sy); close() }
            },
            CatalogHelpers.createRegion("stripe_bot", "Нижня частина", 200f, 285f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(85f * sx, 240f * sy); cubicTo(110f * sx, 320f * sy, 290f * sx, 320f * sy, 315f * sx, 240f * sy); close() }
            }
        )
    )

    // 12: Маленький Кораблик (Boat with sails)
    private fun createLevel12() = ColoringPicture(
        id = 12, title = "Маленький Кораблик", subtitle = "Паперовий човник із білим вітрилом", levelNumber = 12, categoryTier = 1,
        stickerReward = StickerReward("sticker_12", "⛵", "Відважний Човник", "Мчить морськими просторами!", Color(0xFF00C7FF)),
        regions = listOf(
            CatalogHelpers.createRegion("hull", "Корпус човна", 200f, 290f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(90f * sx, 260f * sy); lineTo(310f * sx, 260f * sy); lineTo(260f * sx, 325f * sy); lineTo(140f * sx, 325f * sy); close() }
            },
            CatalogHelpers.createRegion("sail_main", "Велике вітрило", 240f, 170f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(205f * sx, 80f * sy); lineTo(295f * sx, 245f * sy); lineTo(205f * sx, 245f * sy); close() }
            },
            CatalogHelpers.createRegion("sail_front", "Мале вітрило", 160f, 185f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(195f * sx, 120f * sy); lineTo(195f * sx, 245f * sy); lineTo(120f * sx, 245f * sy); close() }
            },
            CatalogHelpers.createRegion("wave", "Морські хвилі", 200f, 350f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(60f * sx, 360f * sy); cubicTo(120f * sx, 335f * sy, 160f * sx, 365f * sy, 220f * sx, 340f * sy); cubicTo(280f * sx, 365f * sy, 320f * sx, 335f * sy, 340f * sx, 360f * sy); lineTo(340f * sx, 375f * sy); lineTo(60f * sx, 375f * sy); close() }
            }
        )
    )

    // 13: Затишний Будиночок (House)
    private fun createLevel13() = ColoringPicture(
        id = 13, title = "Затишний Будиночок", subtitle = "Маленька хатка з віконцем і димарем", levelNumber = 13, categoryTier = 1,
        stickerReward = StickerReward("sticker_13", "🏠", "Тепла Оселя", "Затишок для всієї родини!", Color(0xFFFF9500)),
        regions = listOf(
            CatalogHelpers.createRegion("roof", "Дах", 200f, 125f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(90f * sx, 175f * sy); lineTo(200f * sx, 75f * sy); lineTo(310f * sx, 175f * sy); close() }
            },
            CatalogHelpers.createRegion("wall", "Стіни", 200f, 250f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(110f * sx, 175f * sy); lineTo(290f * sx, 175f * sy); lineTo(290f * sx, 325f * sy); lineTo(110f * sx, 325f * sy); close() }
            },
            CatalogHelpers.createRegion("window", "Віконечко", 160f, 225f, pathBuilder = CatalogHelpers.ovalPath(140f, 205f, 180f, 245f)),
            CatalogHelpers.createRegion("door", "Двері", 235f, 265f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(215f * sx, 215f * sy); lineTo(260f * sx, 215f * sy); lineTo(260f * sx, 325f * sy); lineTo(215f * sx, 325f * sy); close() }
            },
            CatalogHelpers.createRegion("chimney", "Димар", 260f, 95f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(245f * sx, 135f * sy); lineTo(245f * sx, 70f * sy); lineTo(275f * sx, 70f * sy); lineTo(275f * sx, 155f * sy); close() }
            }
        )
    )

    // 14: Сніговичок (Snowman)
    private fun createLevel14() = ColoringPicture(
        id = 14, title = "Сніговичок", subtitle = "Зимовий дружечок з морквиною-носом", levelNumber = 14, categoryTier = 1,
        stickerReward = StickerReward("sticker_14", "☃️", "Добрий Сніговик", "Любить сніг та морозець!", Color(0xFF00C7FF)),
        regions = listOf(
            CatalogHelpers.createRegion("snow_bot", "Нижня куля", 200f, 280f, pathBuilder = CatalogHelpers.ovalPath(120f, 210f, 280f, 350f)),
            CatalogHelpers.createRegion("snow_mid", "Середня куля", 200f, 175f, pathBuilder = CatalogHelpers.ovalPath(140f, 130f, 260f, 220f)),
            CatalogHelpers.createRegion("snow_head", "Голова", 200f, 95f, pathBuilder = CatalogHelpers.ovalPath(160f, 60f, 240f, 130f)),
            CatalogHelpers.createRegion("scarf", "Шарфик", 200f, 135f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(160f * sx, 130f * sy); lineTo(240f * sx, 130f * sy); lineTo(245f * sx, 150f * sy); lineTo(155f * sx, 150f * sy); close() }
            },
            CatalogHelpers.createRegion("hat", "Капелюшок-відерце", 200f, 45f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(170f * sx, 65f * sy); lineTo(230f * sx, 65f * sy); lineTo(220f * sx, 30f * sy); lineTo(180f * sx, 30f * sy); close() }
            }
        )
    )

    // 15: Різнобарвна Пірамідка (Stacking toy)
    private fun createLevel15() = ColoringPicture(
        id = 15, title = "Різнобарвна Пірамідка", subtitle = "Дитяча пірамідка з великими кільцями", levelNumber = 15, categoryTier = 1,
        stickerReward = StickerReward("sticker_15", "🪵", "Чемпіон Башточки", "Збирає все правильно!", Color(0xFFFF9500)),
        regions = listOf(
            CatalogHelpers.createRegion("ring_1", "Верхівка", 200f, 85f, pathBuilder = CatalogHelpers.ovalPath(175f, 60f, 225f, 110f)),
            CatalogHelpers.createRegion("ring_2", "Кільце 2", 200f, 135f, pathBuilder = CatalogHelpers.ovalPath(155f, 115f, 245f, 160f)),
            CatalogHelpers.createRegion("ring_3", "Кільце 3", 200f, 185f, pathBuilder = CatalogHelpers.ovalPath(135f, 165f, 265f, 215f)),
            CatalogHelpers.createRegion("ring_4", "Кільце 4", 200f, 240f, pathBuilder = CatalogHelpers.ovalPath(115f, 220f, 285f, 275f)),
            CatalogHelpers.createRegion("ring_5", "Основа пірамідки", 200f, 300f, pathBuilder = CatalogHelpers.ovalPath(95f, 280f, 305f, 340f))
        )
    )

    // 16: Смачний Кекс (Cupcake)
    private fun createLevel16() = ColoringPicture(
        id = 16, title = "Смачний Кекс", subtitle = "Святковий капкейк із ягідкою зверху", levelNumber = 16, categoryTier = 1,
        stickerReward = StickerReward("sticker_16", "🧁", "Солодкий Кексик", "Смакує до чаю!", Color(0xFFFF4081)),
        regions = listOf(
            CatalogHelpers.createRegion("cup", "Формочка", 200f, 285f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(125f * sx, 210f * sy); lineTo(275f * sx, 210f * sy); lineTo(245f * sx, 340f * sy); lineTo(155f * sx, 340f * sy); close() }
            },
            CatalogHelpers.createRegion("frosting", "Крем", 200f, 165f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(110f * sx, 210f * sy); cubicTo(100f * sx, 130f * sy, 200f * sx, 100f * sy, 200f * sx, 100f * sy); cubicTo(200f * sx, 100f * sy, 300f * sx, 130f * sy, 290f * sx, 210f * sy); close() }
            },
            CatalogHelpers.createRegion("cherry", "Вишенька", 200f, 85f, pathBuilder = CatalogHelpers.ovalPath(185f, 70f, 215f, 100f))
        )
    )

    // 17: Золота Рибка (Fish)
    private fun createLevel17() = ColoringPicture(
        id = 17, title = "Золота Рибка", subtitle = "Чарівна рибка у прозорій воді", levelNumber = 17, categoryTier = 1,
        stickerReward = StickerReward("sticker_17", "🐠", "Золота Рибка", "Виконує найзаповітніші бажання!", Color(0xFFFFD54F)),
        regions = listOf(
            CatalogHelpers.createRegion("fish_body", "Тіло рибки", 175f, 200f, pathBuilder = CatalogHelpers.ovalPath(100f, 140f, 250f, 260f)),
            CatalogHelpers.createRegion("tail", "Хвостик", 300f, 200f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(245f * sx, 200f * sy); lineTo(345f * sx, 130f * sy); lineTo(315f * sx, 200f * sy); lineTo(345f * sx, 270f * sy); close() }
            },
            CatalogHelpers.createRegion("fin_top", "Верхній плавець", 185f, 115f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(150f * sx, 145f * sy); cubicTo(170f * sx, 90f * sy, 220f * sx, 90f * sy, 230f * sx, 150f * sy); close() }
            },
            CatalogHelpers.createRegion("bubble", "Бульбашка", 70f, 120f, pathBuilder = CatalogHelpers.ovalPath(50f, 100f, 90f, 140f))
        )
    )

    // 18: Веселий Дзвіночок (Bell)
    private fun createLevel18() = ColoringPicture(
        id = 18, title = "Веселий Дзвіночок", subtitle = "Дзвінкий новорічний дзвіночок", levelNumber = 18, categoryTier = 1,
        stickerReward = StickerReward("sticker_18", "🔔", "Срібний Дзвіночок", "Дзвенить веселу пісеньку!", Color(0xFFFFD54F)),
        regions = listOf(
            CatalogHelpers.createRegion("bell_body", "Дзвін", 200f, 200f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(170f * sx, 110f * sy); cubicTo(170f * sx, 70f * sy, 230f * sx, 70f * sy, 230f * sx, 110f * sy); lineTo(260f * sx, 250f * sy); cubicTo(270f * sx, 280f * sy, 130f * sx, 280f * sy, 140f * sx, 250f * sy); close() }
            },
            CatalogHelpers.createRegion("clapper", "Язичок дзвіночка", 200f, 305f, pathBuilder = CatalogHelpers.ovalPath(185f, 285f, 215f, 325f)),
            CatalogHelpers.createRegion("bow", "Святковий бант", 200f, 65f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(200f * sx, 65f * sy); lineTo(155f * sx, 45f * sy); lineTo(155f * sx, 85f * sy); lineTo(200f * sx, 65f * sy); lineTo(245f * sx, 45f * sy); lineTo(245f * sx, 85f * sy); close() }
            }
        )
    )

    // 19: Стиглі Вишеньки (Cherries)
    private fun createLevel19() = ColoringPicture(
        id = 19, title = "Стиглі Вишеньки", subtitle = "Дві солодкі ягідки на спільній гілці", levelNumber = 19, categoryTier = 1,
        stickerReward = StickerReward("sticker_19", "🍒", "Близнюки-Вишеньки", "Подвійна насолода!", Color(0xFFFF3B30)),
        regions = listOf(
            CatalogHelpers.createRegion("cherry_left", "Ліва вишня", 145f, 260f, pathBuilder = CatalogHelpers.ovalPath(100f, 215f, 190f, 305f)),
            CatalogHelpers.createRegion("cherry_right", "Права вишня", 255f, 260f, pathBuilder = CatalogHelpers.ovalPath(210f, 215f, 300f, 305f)),
            CatalogHelpers.createRegion("stems", "Стеблинки", 200f, 140f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(145f * sx, 220f * sy); cubicTo(160f * sx, 130f * sy, 200f * sx, 90f * sy, 200f * sx, 90f * sy); cubicTo(200f * sx, 90f * sy, 240f * sx, 130f * sy, 255f * sx, 220f * sy); close() }
            },
            CatalogHelpers.createRegion("leaf", "Листочок", 225f, 75f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(200f * sx, 90f * sy); quadraticTo(240f * sx, 55f * sy, 265f * sx, 75f * sy); quadraticTo(235f * sx, 105f * sy, 200f * sx, 90f * sy); close() }
            }
        )
    )

    // 20: Хрустка Морквинка (Carrot)
    private fun createLevel20() = ColoringPicture(
        id = 20, title = "Хрустка Морквинка", subtitle = "Помаранчева вітамінна морквинка", levelNumber = 20, categoryTier = 1,
        stickerReward = StickerReward("sticker_20", "🥕", "Зайчикова Морква", "Хрумка і корисна!", Color(0xFFFF9500)),
        regions = listOf(
            CatalogHelpers.createRegion("root", "Морквина", 200f, 250f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(140f * sx, 140f * sy); cubicTo(200f * sx, 130f * sy, 260f * sx, 140f * sy, 260f * sx, 140f * sy); lineTo(200f * sx, 360f * sy); close() }
            },
            CatalogHelpers.createRegion("leaf_left", "Лівий листочок", 160f, 95f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(190f * sx, 140f * sy); quadraticTo(140f * sx, 100f * sy, 145f * sx, 60f * sy); quadraticTo(185f * sx, 95f * sy, 190f * sx, 140f * sy); close() }
            },
            CatalogHelpers.createRegion("leaf_mid", "Центральний чубчик", 200f, 85f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(195f * sx, 140f * sy); lineTo(200f * sx, 45f * sy); lineTo(205f * sx, 140f * sy); close() }
            },
            CatalogHelpers.createRegion("leaf_right", "Правий листочок", 240f, 95f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(210f * sx, 140f * sy); quadraticTo(260f * sx, 100f * sy, 255f * sx, 60f * sy); quadraticTo(215f * sx, 95f * sy, 210f * sx, 140f * sy); close() }
            }
        )
    )

    // 21: Зелений Листочок (Leaf)
    private fun createLevel21() = ColoringPicture(
        id = 21, title = "Зелений Листочок", subtitle = "Кленовий листочок осінньої пори", levelNumber = 21, categoryTier = 1,
        stickerReward = StickerReward("sticker_21", "🍁", "Золотий Листочок", "Кружляє у лісовому танку!", Color(0xFFFF9500)),
        regions = listOf(
            CatalogHelpers.createRegion("lobe_center", "Центральна лопать", 200f, 130f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(170f * sx, 180f * sy); lineTo(200f * sx, 65f * sy); lineTo(230f * sx, 180f * sy); close() }
            },
            CatalogHelpers.createRegion("lobe_left", "Ліва лопать", 130f, 170f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(175f * sx, 195f * sy); lineTo(70f * sx, 150f * sy); lineTo(155f * sx, 235f * sy); close() }
            },
            CatalogHelpers.createRegion("lobe_right", "Права лопать", 270f, 170f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(225f * sx, 195f * sy); lineTo(330f * sx, 150f * sy); lineTo(245f * sx, 235f * sy); close() }
            },
            CatalogHelpers.createRegion("leaf_stem", "Ніжка листка", 200f, 305f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(195f * sx, 220f * sy); lineTo(195f * sx, 350f * sy); lineTo(205f * sx, 350f * sy); lineTo(205f * sx, 220f * sy); close() }
            }
        )
    )

    // 22: Чарівне Сердечко (Heart)
    private fun createLevel22() = ColoringPicture(
        id = 22, title = "Чарівне Сердечко", subtitle = "Тепле серце з крильцями доброти", levelNumber = 22, categoryTier = 1,
        stickerReward = StickerReward("sticker_22", "💖", "Добре Сердечко", "Сповнене щирої любові!", Color(0xFFFF2D55)),
        regions = listOf(
            CatalogHelpers.createRegion("heart_left", "Ліва половинка", 165f, 180f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(200f * sx, 140f * sy); cubicTo(190f * sx, 80f * sy, 110f * sx, 80f * sy, 110f * sx, 160f * sy); cubicTo(110f * sx, 220f * sy, 180f * sx, 270f * sy, 200f * sx, 310f * sy); close() }
            },
            CatalogHelpers.createRegion("heart_right", "Права половинка", 235f, 180f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(200f * sx, 140f * sy); cubicTo(210f * sx, 80f * sy, 290f * sx, 80f * sy, 290f * sx, 160f * sy); cubicTo(290f * sx, 220f * sy, 220f * sx, 270f * sy, 200f * sx, 310f * sy); close() }
            },
            CatalogHelpers.createRegion("wing_left", "Ліве крило", 75f, 160f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(115f * sx, 150f * sy); cubicTo(60f * sx, 100f * sy, 30f * sx, 170f * sy, 115f * sx, 210f * sy); close() }
            },
            CatalogHelpers.createRegion("wing_right", "Праве крило", 325f, 160f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(285f * sx, 150f * sy); cubicTo(340f * sx, 100f * sy, 370f * sx, 170f * sy, 285f * sx, 210f * sy); close() }
            }
        )
    )

    // 23: Метелик-Малюк (Baby Butterfly)
    private fun createLevel23() = ColoringPicture(
        id = 23, title = "Метелик-Малюк", subtitle = "Маленький метелик з круглими крильцями", levelNumber = 23, categoryTier = 1,
        stickerReward = StickerReward("sticker_23", "🦋", "Лісовий Метелик", "Пурхає з квітки на квітку!", Color(0xFFAF52DE)),
        regions = listOf(
            CatalogHelpers.createRegion("body", "Тільце", 200f, 200f, pathBuilder = CatalogHelpers.ovalPath(185f, 120f, 215f, 280f)),
            CatalogHelpers.createRegion("wing_tl", "Верхнє ліве крильце", 115f, 140f, pathBuilder = CatalogHelpers.ovalPath(55f, 90f, 185f, 190f)),
            CatalogHelpers.createRegion("wing_tr", "Верхнє праве крильце", 285f, 140f, pathBuilder = CatalogHelpers.ovalPath(215f, 90f, 345f, 190f)),
            CatalogHelpers.createRegion("wing_bl", "Нижнє ліве крильце", 130f, 240f, pathBuilder = CatalogHelpers.ovalPath(85f, 195f, 185f, 285f)),
            CatalogHelpers.createRegion("wing_br", "Нижнє праве крильце", 270f, 240f, pathBuilder = CatalogHelpers.ovalPath(215f, 195f, 315f, 285f))
        )
    )

    // 24: Кольорова Дзиґа (Spinning Top)
    private fun createLevel24() = ColoringPicture(
        id = 24, title = "Кольорова Дзиґа", subtitle = "Іграшкова дзиґа, що швидко крутиться", levelNumber = 24, categoryTier = 1,
        stickerReward = StickerReward("sticker_24", "🌀", "Швидка Дзиґа", "Кружляє без зупинки!", Color(0xFFFF9500)),
        regions = listOf(
            CatalogHelpers.createRegion("top_cone", "Верхній конус", 200f, 150f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(200f * sx, 80f * sy); lineTo(310f * sx, 200f * sy); lineTo(90f * sx, 200f * sy); close() }
            },
            CatalogHelpers.createRegion("mid_rim", "Широкий поясок", 200f, 220f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(90f * sx, 200f * sy); lineTo(310f * sx, 200f * sy); lineTo(300f * sx, 240f * sy); lineTo(100f * sx, 240f * sy); close() }
            },
            CatalogHelpers.createRegion("bot_point", "Нижній шпиль", 200f, 280f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(100f * sx, 240f * sy); lineTo(300f * sx, 240f * sy); lineTo(200f * sx, 335f * sy); close() }
            },
            CatalogHelpers.createRegion("handle", "Ручка дзиґи", 200f, 55f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(192f * sx, 80f * sy); lineTo(192f * sy, 35f * sy); lineTo(208f * sx, 35f * sy); lineTo(208f * sx, 80f * sy); close() }
            }
        )
    )

    // 25: Ніжний Тюльпан (Tulip)
    private fun createLevel25() = ColoringPicture(
        id = 25, title = "Ніжний Тюльпан", subtitle = "Весняна квіточка з міцним стебельцем", levelNumber = 25, categoryTier = 1,
        stickerReward = StickerReward("sticker_25", "🌷", "Весняний Тюльпан", "Перша усмішка весни!", Color(0xFFFF2D55)),
        regions = listOf(
            CatalogHelpers.createRegion("petal_center", "Центральна пелюстка", 200f, 150f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(180f * sx, 85f * sy); lineTo(220f * sx, 85f * sy); lineTo(235f * sx, 200f * sy); lineTo(165f * sx, 200f * sy); close() }
            },
            CatalogHelpers.createRegion("petal_left", "Ліва пелюстка", 145f, 140f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(180f * sx, 85f * sy); cubicTo(110f * sx, 100f * sy, 120f * sx, 200f * sy, 175f * sx, 215f * sy); close() }
            },
            CatalogHelpers.createRegion("petal_right", "Права пелюстка", 255f, 140f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(220f * sx, 85f * sy); cubicTo(290f * sx, 100f * sy, 280f * sx, 200f * sy, 225f * sx, 215f * sy); close() }
            },
            CatalogHelpers.createRegion("stem", "Стебло", 200f, 285f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(195f * sx, 215f * sy); lineTo(195f * sx, 360f * sy); lineTo(205f * sx, 360f * sy); lineTo(205f * sx, 215f * sy); close() }
            },
            CatalogHelpers.createRegion("leaf", "Широкий листок", 250f, 290f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(205f * sx, 330f * sy); cubicTo(260f * sx, 240f * sy, 290f * sx, 240f * sy, 290f * sx, 240f * sy); cubicTo(270f * sx, 290f * sy, 220f * sx, 340f * sy, 205f * sx, 330f * sy); close() }
            }
        )
    )
}
