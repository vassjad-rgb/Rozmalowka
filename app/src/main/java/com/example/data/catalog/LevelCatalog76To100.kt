package com.example.data.catalog

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import com.example.model.ColoringPicture
import com.example.model.StickerReward

object LevelCatalog76To100 {

    val levels: List<ColoringPicture> by lazy {
        listOf(
            createLevel76(), createLevel77(), createLevel78(), createLevel79(), createLevel80(),
            createLevel81(), createLevel82(), createLevel83(), createLevel84(), createLevel85(),
            createLevel86(), createLevel87(), createLevel88(), createLevel89(), createLevel90(),
            createLevel91(), createLevel92(), createLevel93(), createLevel94(), createLevel95(),
            createLevel96(), createLevel97(), createLevel98(), createLevel99(), createLevel100()
        )
    }

    // 76: Смачне Морозиво (Ice Cream Feast)
    private fun createLevel76() = ColoringPicture(
        id = 76, title = "Смачне Морозиво", subtitle = "Ріжок із трьома кульками, сиропом і вишнею", levelNumber = 76, categoryTier = 4,
        stickerReward = StickerReward("sticker_76", "🍦", "Райдужне Морозиво", "Найсолодша нагорода для художника!", Color(0xFFFF4081)),
        regions = listOf(
            CatalogHelpers.createRegion("cone", "Хрусткий ріжок", 200f, 315f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(135f * sx, 230f * sy); lineTo(265f * sx, 230f * sy); lineTo(200f * sx, 380f * sy); close() }
            },
            CatalogHelpers.createRegion("scoop_1", "Шоколадна кулька", 200f, 205f, pathBuilder = CatalogHelpers.ovalPath(120f, 160f, 280f, 245f)),
            CatalogHelpers.createRegion("scoop_2", "Полунична кулька", 200f, 135f, pathBuilder = CatalogHelpers.ovalPath(130f, 90f, 270f, 180f)),
            CatalogHelpers.createRegion("glaze", "Шоколадна поливка", 200f, 105f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(140f * sx, 120f * sy); cubicTo(160f * sx, 150f * sy, 180f * sx, 110f * sy, 200f * sx, 140f * sy); cubicTo(220f * sx, 160f * sy, 240f * sx, 110f * sy, 260f * sx, 120f * sy); cubicTo(250f * sx, 80f * sy, 150f * sx, 80f * sy, 140f * sx, 120f * sy); close() }
            },
            CatalogHelpers.createRegion("cherry", "Вишенька на топі", 200f, 55f, pathBuilder = CatalogHelpers.ovalPath(185f, 40f, 215f, 70f))
        )
    )

    // 77: Казковий Замок (Castle)
    private fun createLevel77() = ColoringPicture(
        id = 77, title = "Казковий Замок", subtitle = "Палац із високими вежами та прапорцями", levelNumber = 77, categoryTier = 4,
        stickerReward = StickerReward("sticker_77", "🏰", "Королівський Замок", "Міцні стіни та високі вежі!", Color(0xFFAF52DE)),
        regions = listOf(
            CatalogHelpers.createRegion("keep", "Центральна стіна", 200f, 235f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(150f * sx, 170f * sy); lineTo(250f * sx, 170f * sy); lineTo(250f * sx, 330f * sy); lineTo(150f * sx, 330f * sy); close() }
            },
            CatalogHelpers.createRegion("gate", "Арочна брама", 200f, 280f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(180f * sx, 330f * sy); lineTo(180f * sx, 250f * sy); cubicTo(180f * sx, 230f * sy, 220f * sx, 230f * sy, 220f * sx, 250f * sy); lineTo(220f * sx, 330f * sy); close() }
            },
            CatalogHelpers.createRegion("tower_l", "Ліва вежа", 115f, 215f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(90f * sx, 140f * sy); lineTo(140f * sx, 140f * sy); lineTo(140f * sx, 330f * sy); lineTo(90f * sx, 330f * sy); close() }
            },
            CatalogHelpers.createRegion("roof_l", "Лівий шпиль", 115f, 95f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(80f * sx, 140f * sy); lineTo(115f * sx, 55f * sy); lineTo(150f * sx, 140f * sy); close() }
            },
            CatalogHelpers.createRegion("tower_r", "Права вежа", 285f, 215f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(260f * sx, 140f * sy); lineTo(310f * sx, 140f * sy); lineTo(310f * sx, 330f * sy); lineTo(260f * sx, 330f * sy); close() }
            },
            CatalogHelpers.createRegion("roof_r", "Правий шпиль", 285f, 95f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(250f * sx, 140f * sy); lineTo(285f * sx, 55f * sy); lineTo(320f * sx, 140f * sy); close() }
            }
        )
    )

    // 78: Вогняний Дракончик (Dragon)
    private fun createLevel78() = ColoringPicture(
        id = 78, title = "Вогняний Дракончик", subtitle = "Добрий крилатий дракон над хмарами", levelNumber = 78, categoryTier = 4,
        stickerReward = StickerReward("sticker_78", "🐲", "Володар Драконів", "Дихає теплим вогнем!", Color(0xFFFF9500)),
        regions = listOf(
            CatalogHelpers.createRegion("head", "Голова дракона", 160f, 140f, pathBuilder = CatalogHelpers.ovalPath(120f, 100f, 200f, 180f)),
            CatalogHelpers.createRegion("body", "Тіло дракона", 215f, 235f, pathBuilder = CatalogHelpers.ovalPath(155f, 175f, 275f, 295f)),
            CatalogHelpers.createRegion("wing_l", "Ліве крило", 105f, 190f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(175f * sx, 180f * sy); lineTo(55f * sx, 130f * sy); lineTo(95f * sx, 235f * sy); close() }
            },
            CatalogHelpers.createRegion("wing_r", "Праве крило", 295f, 190f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(235f * sx, 180f * sy); lineTo(345f * sx, 130f * sy); lineTo(305f * sx, 235f * sy); close() }
            },
            CatalogHelpers.createRegion("flame", "Вогняний подих", 105f, 140f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(125f * sx, 135f * sy); lineTo(60f * sx, 120f * sy); lineTo(80f * sx, 155f * sy); close() }
            }
        )
    )

    // 79: Чарівний Єдиноріг (Unicorn)
    private fun createLevel79() = ColoringPicture(
        id = 79, title = "Чарівний Єдиноріг", subtitle = "Білосніжний коник із золотим рогом", levelNumber = 79, categoryTier = 4,
        stickerReward = StickerReward("sticker_79", "🦄", "Сяючий Єдиноріг", "Чарівне створіння з казки!", Color(0xFFAF52DE)),
        regions = listOf(
            CatalogHelpers.createRegion("head", "Мордочка єдинорога", 175f, 160f, pathBuilder = CatalogHelpers.ovalPath(125f, 115f, 225f, 205f)),
            CatalogHelpers.createRegion("horn", "Золотий ріг", 155f, 75f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(165f * sx, 115f * sy); lineTo(145f * sx, 35f * sy); lineTo(185f * sx, 110f * sy); close() }
            },
            CatalogHelpers.createRegion("mane", "Райдужна грива", 255f, 175f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(215f * sx, 120f * sy); cubicTo(290f * sx, 110f * sy, 310f * sx, 250f * sy, 235f * sx, 260f * sy); close() }
            },
            CatalogHelpers.createRegion("body", "Тільце", 230f, 280f, pathBuilder = CatalogHelpers.ovalPath(160f, 225f, 300f, 335f))
        )
    )

    // 80: Грибний Будиночок (Mushroom House)
    private fun createLevel80() = ColoringPicture(
        id = 80, title = "Грибний Будиночок", subtitle = "Казкова оселя лісових гномиків", levelNumber = 80, categoryTier = 4,
        stickerReward = StickerReward("sticker_80", "🍄", "Будинок Гномика", "Затишна хатинка в лісі!", Color(0xFFFF3B30)),
        regions = listOf(
            CatalogHelpers.createRegion("roof", "Дах-шапочка", 200f, 120f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(75f * sx, 185f * sy); cubicTo(75f * sx, 55f * sy, 325f * sx, 55f * sy, 325f * sx, 185f * sy); close() }
            },
            CatalogHelpers.createRegion("wall", "Стіни-ніжка", 200f, 260f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(140f * sx, 185f * sy); lineTo(260f * sx, 185f * sy); lineTo(250f * sx, 335f * sy); lineTo(150f * sx, 335f * sy); close() }
            },
            CatalogHelpers.createRegion("door", "Дверцята", 200f, 290f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(180f * sx, 335f * sy); lineTo(180f * sx, 255f * sy); cubicTo(180f * sx, 240f * sy, 220f * sx, 240f * sy, 220f * sx, 255f * sy); lineTo(220f * sx, 335f * sy); close() }
            },
            CatalogHelpers.createRegion("window", "Віконце на даху", 200f, 105f, pathBuilder = CatalogHelpers.ovalPath(185f, 90f, 215f, 120f))
        )
    )

    // 81: Морська Русалонька (Mermaid)
    private fun createLevel81() = ColoringPicture(
        id = 81, title = "Морська Русалонька", subtitle = "Казкова красуня з блискучим хвостом", levelNumber = 81, categoryTier = 4,
        stickerReward = StickerReward("sticker_81", "🧜‍♀️", "Перлина Океану", "Співає пісні для дельфінів!", Color(0xFF00C7FF)),
        regions = listOf(
            CatalogHelpers.createRegion("head", "Обличчя русалоньки", 200f, 110f, pathBuilder = CatalogHelpers.ovalPath(170f, 80f, 230f, 140f)),
            CatalogHelpers.createRegion("hair", "Довгі коси", 200f, 150f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(160f * sx, 90f * sy); cubicTo(110f * sx, 140f * sy, 130f * sx, 250f * sy, 170f * sx, 240f * sy); cubicTo(180f * sx, 180f * sy, 220f * sx, 180f * sy, 230f * sx, 240f * sy); cubicTo(270f * sx, 250f * sy, 290f * sx, 140f * sy, 240f * sx, 90f * sy); close() }
            },
            CatalogHelpers.createRegion("tail", "Лускатий хвіст", 200f, 275f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(180f * sx, 200f * sy); lineTo(220f * sx, 200f * sy); cubicTo(240f * sx, 280f * sy, 170f * sx, 310f * sy, 200f * sx, 350f * sy); cubicTo(160f * sx, 300f * sy, 170f * sx, 240f * sy, 180f * sx, 200f * sy); close() }
            },
            CatalogHelpers.createRegion("fin", "Хвостовий плавець", 200f, 365f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(200f * sx, 345f * sy); lineTo(165f * sx, 385f * sy); lineTo(200f * sx, 370f * sy); lineTo(235f * sx, 385f * sy); close() }
            }
        )
    )

    // 82: Королівська Корона (Crown)
    private fun createLevel82() = ColoringPicture(
        id = 82, title = "Королівська Корона", subtitle = "Золота корона з коштовним камінням", levelNumber = 82, categoryTier = 4,
        stickerReward = StickerReward("sticker_82", "👑", "Королівська Велич", "Сяє золотом та смарагдами!", Color(0xFFFFD54F)),
        regions = listOf(
            CatalogHelpers.createRegion("crown_body", "Золота корона", 200f, 200f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(80f * sx, 260f * sy); lineTo(320f * sx, 260f * sy); lineTo(340f * sx, 130f * sy); lineTo(280f * sx, 190f * sy); lineTo(200f * sx, 90f * sy); lineTo(120f * sx, 190f * sy); lineTo(60f * sx, 130f * sy); close() }
            },
            CatalogHelpers.createRegion("jewel_mid", "Центральний рубін", 200f, 220f, pathBuilder = CatalogHelpers.ovalPath(185f, 205f, 215f, 235f)),
            CatalogHelpers.createRegion("jewel_l", "Смарагд лівий", 140f, 220f, pathBuilder = CatalogHelpers.ovalPath(128f, 208f, 152f, 232f)),
            CatalogHelpers.createRegion("jewel_r", "Сапфір правий", 260f, 220f, pathBuilder = CatalogHelpers.ovalPath(248f, 208f, 272f, 232f))
        )
    )

    // 83: Робот-Помічник (Robot)
    private fun createLevel83() = ColoringPicture(
        id = 83, title = "Робот-Помічник", subtitle = "Металевий друг з антеною та лампочками", levelNumber = 83, categoryTier = 4,
        stickerReward = StickerReward("sticker_83", "🤖", "Супер-Робот", "Знає відповіді на всі загадки!", Color(0xFF007AFF)),
        regions = listOf(
            CatalogHelpers.createRegion("head", "Квадратна голова", 200f, 115f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(150f * sx, 75f * sy); lineTo(250f * sx, 75f * sy); lineTo(250f * sx, 155f * sy); lineTo(150f * sx, 155f * sy); close() }
            },
            CatalogHelpers.createRegion("chest", "Тіло-екран", 200f, 235f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(135f * sx, 165f * sy); lineTo(265f * sx, 165f * sy); lineTo(265f * sx, 305f * sy); lineTo(135f * sx, 305f * sy); close() }
            },
            CatalogHelpers.createRegion("antenna", "Антена на голові", 200f, 50f, pathBuilder = CatalogHelpers.ovalPath(190f, 35f, 210f, 55f)),
            CatalogHelpers.createRegion("dial", "Екран-датчик", 200f, 235f, pathBuilder = CatalogHelpers.ovalPath(170f, 205f, 230f, 265f))
        )
    )

    // 84: Скриня зі Скарбами (Treasure Chest)
    private fun createLevel84() = ColoringPicture(
        id = 84, title = "Скриня зі Скарбами", subtitle = "Старовинна скриня повна золотих монет", levelNumber = 84, categoryTier = 4,
        stickerReward = StickerReward("sticker_84", "🪙", "Скарби Острова", "Піратське золото знайдено!", Color(0xFFFFD54F)),
        regions = listOf(
            CatalogHelpers.createRegion("lid", "Вигнута кришка", 200f, 145f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(80f * sx, 180f * sy); cubicTo(80f * sx, 90f * sy, 320f * sx, 90f * sy, 320f * sx, 180f * sy); close() }
            },
            CatalogHelpers.createRegion("chest_base", "Дерев'яна скриня", 200f, 255f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(90f * sx, 180f * sy); lineTo(310f * sx, 180f * sy); lineTo(300f * sx, 330f * sy); lineTo(100f * sx, 330f * sy); close() }
            },
            CatalogHelpers.createRegion("lock", "Золотий замок", 200f, 195f, pathBuilder = CatalogHelpers.ovalPath(185f, 180f, 215f, 210f))
        )
    )

    // 85: Старий Вітряк (Windmill)
    private fun createLevel85() = ColoringPicture(
        id = 85, title = "Старий Вітряк", subtitle = "Млин із великими крилами серед пшениці", levelNumber = 85, categoryTier = 4,
        stickerReward = StickerReward("sticker_85", "🌾", "Золотий Вітряк", "Меле зерно на смачне борошно!", Color(0xFFFF9500)),
        regions = listOf(
            CatalogHelpers.createRegion("tower", "Вежа млина", 200f, 240f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(165f * sx, 150f * sy); lineTo(235f * sx, 150f * sy); lineTo(260f * sx, 340f * sy); lineTo(140f * sx, 340f * sy); close() }
            },
            CatalogHelpers.createRegion("blade_t", "Верхнє крило", 200f, 85f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(190f * sx, 150f * sy); lineTo(200f * sx, 35f * sy); lineTo(210f * sx, 150f * sy); close() }
            },
            CatalogHelpers.createRegion("blade_r", "Праве крило", 270f, 150f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(200f * sx, 140f * sy); lineTo(335f * sx, 150f * sy); lineTo(200f * sx, 160f * sy); close() }
            },
            CatalogHelpers.createRegion("blade_l", "Ліве крило", 130f, 150f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(200f * sx, 140f * sy); lineTo(65f * sx, 150f * sy); lineTo(200f * sx, 160f * sy); close() }
            }
        )
    )

    // 86: Башта з Годинником (Clock Tower)
    private fun createLevel86() = ColoringPicture(
        id = 86, title = "Башта з Годинником", subtitle = "Висока старовинна міська вежа", levelNumber = 86, categoryTier = 4,
        stickerReward = StickerReward("sticker_86", "🕰️", "Вартовий Часу", "Б'є щогодини точний час!", Color(0xFF007AFF)),
        regions = listOf(
            CatalogHelpers.createRegion("spire", "Шпиль даху", 200f, 85f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(150f * sx, 135f * sy); lineTo(200f * sx, 45f * sy); lineTo(250f * sx, 135f * sy); close() }
            },
            CatalogHelpers.createRegion("clock_tier", "Ярус з годинником", 200f, 185f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(150f * sx, 135f * sy); lineTo(250f * sx, 135f * sy); lineTo(250f * sx, 235f * sy); lineTo(150f * sx, 235f * sy); close() }
            },
            CatalogHelpers.createRegion("clock_dial", "Циферблат", 200f, 185f, pathBuilder = CatalogHelpers.ovalPath(175f, 160f, 225f, 210f)),
            CatalogHelpers.createRegion("tower_base", "Основа вежі", 200f, 285f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(140f * sx, 235f * sy); lineTo(260f * sx, 235f * sy); lineTo(270f * sx, 345f * sy); lineTo(130f * sx, 345f * sy); close() }
            }
        )
    )

    // 87: Чарівна Квітка (Magic Flower)
    private fun createLevel87() = ColoringPicture(
        id = 87, title = "Чарівна Квітка", subtitle = "Семибарвна квітка, що виконує бажання", levelNumber = 87, categoryTier = 4,
        stickerReward = StickerReward("sticker_87", "🌺", "Квітка Бажань", "Здійснює сім найзаповітніших мрій!", Color(0xFFFF2D55)),
        regions = listOf(
            CatalogHelpers.createRegion("center", "Золоте серце квітки", 200f, 200f, pathBuilder = CatalogHelpers.ovalPath(165f, 165f, 235f, 235f)),
            CatalogHelpers.createRegion("petal_1", "Пелюстка 1", 200f, 100f, pathBuilder = CatalogHelpers.ovalPath(175f, 60f, 225f, 155f)),
            CatalogHelpers.createRegion("petal_2", "Пелюстка 2", 285f, 145f, pathBuilder = CatalogHelpers.ovalPath(245f, 115f, 325f, 175f)),
            CatalogHelpers.createRegion("petal_3", "Пелюстка 3", 270f, 260f, pathBuilder = CatalogHelpers.ovalPath(235f, 225f, 305f, 295f)),
            CatalogHelpers.createRegion("petal_4", "Пелюстка 4", 130f, 260f, pathBuilder = CatalogHelpers.ovalPath(95f, 225f, 165f, 295f)),
            CatalogHelpers.createRegion("petal_5", "Пелюстка 5", 115f, 145f, pathBuilder = CatalogHelpers.ovalPath(75f, 115f, 155f, 175f))
        )
    )

    // 88: Кораловий Риф (Coral Reef)
    private fun createLevel88() = ColoringPicture(
        id = 88, title = "Кораловий Риф", subtitle = "Підводне царство водоростей та мушель", levelNumber = 88, categoryTier = 4,
        stickerReward = StickerReward("sticker_88", "🪸", "Кораловий Світ", "Різнобарвні скарби морських глибин!", Color(0xFFFF4081)),
        regions = listOf(
            CatalogHelpers.createRegion("coral_center", "Центральний корал", 200f, 230f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(180f * sx, 330f * sy); lineTo(180f * sx, 160f * sy); lineTo(195f * sx, 130f * sy); lineTo(205f * sx, 130f * sy); lineTo(220f * sx, 160f * sy); lineTo(220f * sx, 330f * sy); close() }
            },
            CatalogHelpers.createRegion("coral_branch_l", "Ліва гілка корала", 135f, 220f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(180f * sx, 250f * sy); cubicTo(100f * sx, 220f * sy, 90f * sx, 140f * sy, 130f * sx, 150f * sy); cubicTo(140f * sx, 180f * sy, 160f * sx, 220f * sy, 180f * sx, 220f * sy); close() }
            },
            CatalogHelpers.createRegion("starfish", "Морська зірка", 280f, 280f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(280f * sx, 250f * sy); lineTo(290f * sx, 275f * sy); lineTo(315f * sx, 280f * sy); lineTo(295f * sx, 295f * sy); lineTo(300f * sx, 320f * sy); lineTo(280f * sx, 305f * sy); lineTo(260f * sx, 320f * sy); lineTo(265f * sx, 295f * sy); lineTo(245f * sx, 280f * sy); lineTo(270f * sx, 275f * sy); close() }
            }
        )
    )

    // 89: Орбітальна Станція (Space Station)
    private fun createLevel89() = ColoringPicture(
        id = 89, title = "Орбітальна Станція", subtitle = "Міжнародна наукова лабораторія в космосі", levelNumber = 89, categoryTier = 4,
        stickerReward = StickerReward("sticker_89", "🛸", "Зоряна Брама", "Дім для дослідників Всесвіту!", Color(0xFF00C7FF)),
        regions = listOf(
            CatalogHelpers.createRegion("core", "Центральний відсік", 200f, 200f, pathBuilder = CatalogHelpers.ovalPath(155f, 155f, 245f, 245f)),
            CatalogHelpers.createRegion("solar_top", "Верхня панель", 200f, 85f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(160f * sx, 45f * sy); lineTo(240f * sx, 45f * sy); lineTo(240f * sx, 140f * sy); lineTo(160f * sx, 140f * sy); close() }
            },
            CatalogHelpers.createRegion("solar_bot", "Нижня панель", 200f, 315f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(160f * sx, 260f * sy); lineTo(240f * sx, 260f * sy); lineTo(240f * sx, 355f * sy); lineTo(160f * sx, 355f * sy); close() }
            }
        )
    )

    // 90: Веселковий Водоспад (Waterfall)
    private fun createLevel90() = ColoringPicture(
        id = 90, title = "Веселковий Водоспад", subtitle = "Гірська річка спадає з високих скель", levelNumber = 90, categoryTier = 4,
        stickerReward = StickerReward("sticker_90", "🌈", "Райдужна Вода", "Грає барвами під сонечком!", Color(0xFF00C7FF)),
        regions = listOf(
            CatalogHelpers.createRegion("stream", "Водоспадний потік", 200f, 200f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(165f * sx, 60f * sy); lineTo(235f * sx, 60f * sy); lineTo(250f * sx, 310f * sy); lineTo(150f * sx, 310f * sy); close() }
            },
            CatalogHelpers.createRegion("pool", "Озерце внизу", 200f, 340f, pathBuilder = CatalogHelpers.ovalPath(90f, 305f, 310f, 375f)),
            CatalogHelpers.createRegion("rainbow", "Райдужна арка", 200f, 120f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(80f * sx, 210f * sy); cubicTo(110f * sx, 80f * sy, 290f * sx, 80f * sy, 320f * sx, 210f * sy); lineTo(300f * sx, 210f * sy); cubicTo(275f * sx, 105f * sy, 125f * sx, 105f * sy, 100f * sx, 210f * sy); close() }
            }
        )
    )

    // 91: Лісовий Оркестр (Violin)
    private fun createLevel91() = ColoringPicture(
        id = 91, title = "Лісовий Оркестр", subtitle = "Музичні інструменти лісових звірят", levelNumber = 91, categoryTier = 4,
        stickerReward = StickerReward("sticker_91", "🎻", "Маестро Лісу", "Чарівні звуки живої природи!", Color(0xFF8B572A)),
        regions = listOf(
            CatalogHelpers.createRegion("body", "Корпус скрипки", 200f, 240f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(160f * sx, 160f * sy); cubicTo(120f * sx, 180f * sy, 120f * sx, 310f * sy, 200f * sx, 340f * sy); cubicTo(280f * sx, 310f * sy, 280f * sx, 180f * sy, 240f * sx, 160f * sy); close() }
            },
            CatalogHelpers.createRegion("neck", "Гриф скрипки", 200f, 95f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(190f * sx, 160f * sy); lineTo(190f * sx, 45f * sy); lineTo(210f * sx, 45f * sy); lineTo(210f * sx, 160f * sy); close() }
            }
        )
    )

    // 92: Кришталевий Палац (Crystal Palace)
    private fun createLevel92() = ColoringPicture(
        id = 92, title = "Кришталевий Палац", subtitle = "Палац із прозорими вежами та балконами", levelNumber = 92, categoryTier = 4,
        stickerReward = StickerReward("sticker_92", "✨", "Кришталева Казка", "Сяє мов справжній діамант!", Color(0xFF00C7FF)),
        regions = listOf(
            CatalogHelpers.createRegion("main_hall", "Головна зала", 200f, 250f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(130f * sx, 180f * sy); lineTo(270f * sx, 180f * sy); lineTo(280f * sx, 340f * sy); lineTo(120f * sx, 340f * sy); close() }
            },
            CatalogHelpers.createRegion("spire", "Кришталевий шпиль", 200f, 105f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(130f * sx, 180f * sy); lineTo(200f * sx, 45f * sy); lineTo(270f * sx, 180f * sy); close() }
            }
        )
    )

    // 93: Дерево Життя (Tree of Life)
    private fun createLevel93() = ColoringPicture(
        id = 93, title = "Дерево Життя", subtitle = "Могутній старий дуб із плодами та гніздечком", levelNumber = 93, categoryTier = 4,
        stickerReward = StickerReward("sticker_93", "🌳", "Віковий Дуб", "Символ сили, мудрості та добра!", Color(0xFF34C759)),
        regions = listOf(
            CatalogHelpers.createRegion("trunk", "Могутній стовбур", 200f, 275f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(180f * sx, 180f * sy); lineTo(220f * sx, 180f * sy); lineTo(245f * sx, 350f * sy); lineTo(155f * sx, 350f * sy); close() }
            },
            CatalogHelpers.createRegion("canopy", "Зелена крона", 200f, 125f, pathBuilder = CatalogHelpers.ovalPath(90f, 50f, 310f, 200f))
        )
    )

    // 94: Зачарований Ліс (Enchanted Woods)
    private fun createLevel94() = ColoringPicture(
        id = 94, title = "Зачарований Ліс", subtitle = "Казкові дерева з мерехтливими світлячками", levelNumber = 94, categoryTier = 4,
        stickerReward = StickerReward("sticker_94", "🧚", "Лісова Магія", "Місце де живуть лісові феї!", Color(0xFFAF52DE)),
        regions = listOf(
            CatalogHelpers.createRegion("tree_1", "Дерево зліва", 130f, 200f, pathBuilder = CatalogHelpers.ovalPath(70f, 100f, 190f, 300f)),
            CatalogHelpers.createRegion("tree_2", "Дерево справа", 270f, 200f, pathBuilder = CatalogHelpers.ovalPath(210f, 100f, 330f, 300f)),
            CatalogHelpers.createRegion("fairy_star", "Чарівна іскра", 200f, 175f, pathBuilder = CatalogHelpers.ovalPath(185f, 160f, 215f, 190f))
        )
    )

    // 95: Золотий Соняшник (Sunflower)
    private fun createLevel95() = ColoringPicture(
        id = 95, title = "Золотий Соняшник", subtitle = "Велика квітка сонця із чорним насінням", levelNumber = 95, categoryTier = 4,
        stickerReward = StickerReward("sticker_95", "🌻", "Сонце Степів", "Завжди повертається до тепла!", Color(0xFFFFD54F)),
        regions = listOf(
            CatalogHelpers.createRegion("seeds", "Насіння", 200f, 175f, pathBuilder = CatalogHelpers.ovalPath(150f, 125f, 250f, 225f)),
            CatalogHelpers.createRegion("petals", "Золоті пелюстки", 200f, 175f, pathBuilder = CatalogHelpers.ovalPath(100f, 75f, 300f, 275f)),
            CatalogHelpers.createRegion("stem", "Міцне стебло", 200f, 315f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(190f * sx, 270f * sy); lineTo(210f * sx, 270f * sy); lineTo(210f * sx, 360f * sy); lineTo(190f * sx, 360f * sy); close() }
            }
        )
    )

    // 96: Будиночок із Солодощів (Candy House)
    private fun createLevel96() = ColoringPicture(
        id = 96, title = "Будиночок із Солодощів", subtitle = "Стіни з пряників, дах із льодяників", levelNumber = 96, categoryTier = 4,
        stickerReward = StickerReward("sticker_96", "🍭", "Пряниковий Рай", "Казка смаку та карамелі!", Color(0xFFFF4081)),
        regions = listOf(
            CatalogHelpers.createRegion("frosting_roof", "Дах із глазурі", 200f, 135f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(80f * sx, 180f * sy); lineTo(200f * sx, 80f * sy); lineTo(320f * sx, 180f * sy); close() }
            },
            CatalogHelpers.createRegion("ginger_wall", "Пряникові стіни", 200f, 255f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(100f * sx, 180f * sy); lineTo(300f * sx, 180f * sy); lineTo(300f * sx, 330f * sy); lineTo(100f * sx, 330f * sy); close() }
            },
            CatalogHelpers.createRegion("candy_door", "Карамельні двері", 200f, 280f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(180f * sx, 235f * sy); lineTo(220f * sx, 235f * sy); lineTo(220f * sx, 330f * sy); lineTo(180f * sx, 330f * sy); close() }
            }
        )
    )

    // 97: Святкова Ялинка (Xmas Tree)
    private fun createLevel97() = ColoringPicture(
        id = 97, title = "Святкова Ялинка", subtitle = "Новорічне дерево з іграшками та гірляндою", levelNumber = 97, categoryTier = 4,
        stickerReward = StickerReward("sticker_97", "🎄", "Зимова Красуня", "Свято приходить у кожен дім!", Color(0xFF34C759)),
        regions = listOf(
            CatalogHelpers.createRegion("tier_top", "Верхній ярус", 200f, 115f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(200f * sx, 65f * sy); lineTo(260f * sx, 145f * sy); lineTo(140f * sx, 145f * sy); close() }
            },
            CatalogHelpers.createRegion("tier_mid", "Середній ярус", 200f, 185f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(200f * sx, 125f * sy); lineTo(285f * sx, 220f * sy); lineTo(115f * sx, 220f * sy); close() }
            },
            CatalogHelpers.createRegion("tier_bot", "Нижній ярус", 200f, 260f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(200f * sx, 195f * sy); lineTo(315f * sx, 310f * sy); lineTo(85f * sx, 310f * sy); close() }
            },
            CatalogHelpers.createRegion("star", "Зірка на ялинці", 200f, 50f, pathBuilder = CatalogHelpers.ovalPath(185f, 35f, 215f, 65f))
        )
    )

    // 98: Казкова Карета (Carriage)
    private fun createLevel98() = ColoringPicture(
        id = 98, title = "Казкова Карета", subtitle = "Золочена карета для принцеси на бал", levelNumber = 98, categoryTier = 4,
        stickerReward = StickerReward("sticker_98", "🪞", "Чарівна Карета", "Мчить на королівський бал!", Color(0xFFFFD54F)),
        regions = listOf(
            CatalogHelpers.createRegion("cabin", "Кузов-гарбуз", 200f, 180f, pathBuilder = CatalogHelpers.ovalPath(110f, 95f, 290f, 265f)),
            CatalogHelpers.createRegion("window", "Вікно карети", 200f, 180f, pathBuilder = CatalogHelpers.ovalPath(165f, 145f, 235f, 215f)),
            CatalogHelpers.createRegion("wheel_l", "Ліве колесо", 130f, 280f, pathBuilder = CatalogHelpers.ovalPath(100f, 250f, 160f, 310f)),
            CatalogHelpers.createRegion("wheel_r", "Праве колесо", 270f, 280f, pathBuilder = CatalogHelpers.ovalPath(240f, 250f, 300f, 310f))
        )
    )

    // 99: Далека Галактика (Galaxy)
    private fun createLevel99() = ColoringPicture(
        id = 99, title = "Далека Галактика", subtitle = "Спіральна зоряна туманність і комети", levelNumber = 99, categoryTier = 4,
        stickerReward = StickerReward("sticker_99", "🌌", "Володар Галактик", "Безмежні таємниці космосу!", Color(0xFFAF52DE)),
        regions = listOf(
            CatalogHelpers.createRegion("core", "Ядро галактики", 200f, 200f, pathBuilder = CatalogHelpers.ovalPath(145f, 145f, 255f, 255f)),
            CatalogHelpers.createRegion("spiral_arm_1", "Спіральний рукав 1", 140f, 120f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(200f * sx, 155f * sy); cubicTo(90f * sx, 110f * sy, 70f * sx, 270f * sy, 160f * sx, 245f * sy); close() }
            },
            CatalogHelpers.createRegion("spiral_arm_2", "Спіральний рукав 2", 260f, 280f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(200f * sx, 245f * sy); cubicTo(310f * sx, 290f * sy, 330f * sx, 130f * sy, 240f * sx, 155f * sy); close() }
            }
        )
    )

    // 100: Великий Кубок Майстра (Grand Master Trophy)
    private fun createLevel100() = ColoringPicture(
        id = 100, title = "Великий Кубок Майстра", subtitle = "Найвища нагорода за замальовку 100 шедеврів!", levelNumber = 100, categoryTier = 4,
        stickerReward = StickerReward("sticker_100", "🎖️", "Великий Майстер", "Ти розмалював усі 100 малюнків! Справжній геній!", Color(0xFFFFD54F)),
        regions = listOf(
            CatalogHelpers.createRegion("cup", "Золотий кубок", 200f, 150f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(115f * sx, 80f * sy); lineTo(285f * sx, 80f * sy); cubicTo(285f * sx, 210f * sy, 200f * sx, 220f * sy, 200f * sx, 220f * sy); cubicTo(200f * sx, 220f * sy, 115f * sx, 210f * sy, 115f * sx, 80f * sy); close() }
            },
            CatalogHelpers.createRegion("star_badge", "Діамантова зірка", 200f, 140f, pathBuilder = CatalogHelpers.ovalPath(180f, 120f, 220f, 160f)),
            CatalogHelpers.createRegion("handle_l", "Ліва ручка кубка", 90f, 140f, pathBuilder = CatalogHelpers.ovalPath(65f, 105f, 115f, 175f)),
            CatalogHelpers.createRegion("handle_r", "Права ручка кубка", 310f, 140f, pathBuilder = CatalogHelpers.ovalPath(285f, 105f, 335f, 175f)),
            CatalogHelpers.createRegion("pedestal", "Царський постамент", 200f, 290f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(140f * sx, 240f * sy); lineTo(260f * sx, 240f * sy); lineTo(275f * sx, 340f * sy); lineTo(125f * sx, 340f * sy); close() }
            }
        )
    )
}
