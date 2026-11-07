package com.example.data.catalog

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import com.example.model.ColoringPicture
import com.example.model.StickerReward

object LevelCatalog51To75 {

    val levels: List<ColoringPicture> by lazy {
        listOf(
            createLevel51(), createLevel52(), createLevel53(), createLevel54(), createLevel55(),
            createLevel56(), createLevel57(), createLevel58(), createLevel59(), createLevel60(),
            createLevel61(), createLevel62(), createLevel63(), createLevel64(), createLevel65(),
            createLevel66(), createLevel67(), createLevel68(), createLevel69(), createLevel70(),
            createLevel71(), createLevel72(), createLevel73(), createLevel74(), createLevel75()
        )
    }

    // 51: Космічна Ракета (Rocket)
    private fun createLevel51() = ColoringPicture(
        id = 51, title = "Космічна Ракета", subtitle = "Швидка ракета мчить до далеких зірок", levelNumber = 51, categoryTier = 3,
        stickerReward = StickerReward("sticker_51", "🚀", "Космічний Піонер", "Досягає далеких галактик!", Color(0xFF00C7FF)),
        regions = listOf(
            CatalogHelpers.createRegion("nose", "Носик ракети", 200f, 75f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(150f * sx, 115f * sy); cubicTo(160f * sx, 55f * sy, 200f * sx, 35f * sy, 200f * sx, 35f * sy); cubicTo(200f * sx, 35f * sy, 240f * sx, 55f * sy, 250f * sx, 115f * sy); close() }
            },
            CatalogHelpers.createRegion("body", "Корпус", 200f, 195f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(150f * sx, 115f * sy); lineTo(250f * sx, 115f * sy); lineTo(250f * sx, 275f * sy); lineTo(150f * sx, 275f * sy); close() }
            },
            CatalogHelpers.createRegion("porthole", "Ілюмінатор", 200f, 185f, pathBuilder = CatalogHelpers.ovalPath(165f, 150f, 235f, 220f)),
            CatalogHelpers.createRegion("fin_l", "Ліве крило", 115f, 255f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(150f * sx, 200f * sy); lineTo(85f * sx, 285f * sy); lineTo(150f * sx, 275f * sy); close() }
            },
            CatalogHelpers.createRegion("fin_r", "Праве крило", 285f, 255f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(250f * sx, 200f * sy); lineTo(315f * sx, 285f * sy); lineTo(250f * sx, 275f * sy); close() }
            },
            CatalogHelpers.createRegion("flame", "Полум'я двигуна", 200f, 325f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(170f * sx, 275f * sy); lineTo(185f * sx, 340f * sy); lineTo(200f * sx, 365f * sy); lineTo(215f * sx, 340f * sy); lineTo(230f * sx, 275f * sy); close() }
            }
        )
    )

    // 52: Супутник Зв'язку (Satellite)
    private fun createLevel52() = ColoringPicture(
        id = 52, title = "Супутник Зв'язку", subtitle = "Космічний апарат із сонячними крилами", levelNumber = 52, categoryTier = 3,
        stickerReward = StickerReward("sticker_52", "🛰️", "Орбітальний Супутник", "Передає сигнали на Землю!", Color(0xFF007AFF)),
        regions = listOf(
            CatalogHelpers.createRegion("center_module", "Головний модуль", 200f, 200f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(160f * sx, 160f * sy); lineTo(240f * sx, 160f * sy); lineTo(240f * sx, 240f * sy); lineTo(160f * sx, 240f * sy); close() }
            },
            CatalogHelpers.createRegion("solar_l", "Ліва сонячна батарея", 95f, 200f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(50f * sx, 170f * sy); lineTo(145f * sx, 170f * sy); lineTo(145f * sx, 230f * sy); lineTo(50f * sx, 230f * sy); close() }
            },
            CatalogHelpers.createRegion("solar_r", "Права сонячна батарея", 305f, 200f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(255f * sx, 170f * sy); lineTo(350f * sx, 170f * sy); lineTo(350f * sx, 230f * sy); lineTo(255f * sx, 230f * sy); close() }
            },
            CatalogHelpers.createRegion("dish", "Тарілка антени", 200f, 105f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(165f * sx, 120f * sy); cubicTo(165f * sx, 75f * sy, 235f * sx, 75f * sy, 235f * sx, 120f * sy); close() }
            }
        )
    )

    // 53: Сріблястий Літачок (Airplane)
    private fun createLevel53() = ColoringPicture(
        id = 53, title = "Сріблястий Літачок", subtitle = "Пасажирський літак високо у хмарах", levelNumber = 53, categoryTier = 3,
        stickerReward = StickerReward("sticker_53", "✈️", "Срібне Крило", "Летить над хмарами!", Color(0xFF00C7FF)),
        regions = listOf(
            CatalogHelpers.createRegion("fuselage", "Корпус літака", 200f, 200f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(70f * sx, 200f * sy); cubicTo(100f * sx, 175f * sy, 300f * sx, 175f * sy, 335f * sx, 200f * sy); cubicTo(300f * sx, 225f * sy, 100f * sx, 225f * sy, 70f * sx, 200f * sy); close() }
            },
            CatalogHelpers.createRegion("wing_top", "Верхнє крило", 200f, 120f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(180f * sx, 180f * sy); lineTo(240f * sx, 60f * sy); lineTo(210f * sx, 60f * sy); lineTo(140f * sx, 180f * sy); close() }
            },
            CatalogHelpers.createRegion("wing_bottom", "Нижнє крило", 200f, 280f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(180f * sx, 220f * sy); lineTo(240f * sx, 340f * sy); lineTo(210f * sx, 340f * sy); lineTo(140f * sx, 220f * sy); close() }
            },
            CatalogHelpers.createRegion("tail_fin", "Хвостовий кіль", 320f, 150f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(290f * sx, 185f * sy); lineTo(335f * sx, 115f * sy); lineTo(345f * sx, 115f * sy); lineTo(335f * sx, 195f * sy); close() }
            }
        )
    )

    // 54: Рятувальний Гелікоптер (Helicopter)
    private fun createLevel54() = ColoringPicture(
        id = 54, title = "Рятувальний Гелікоптер", subtitle = "Гвинтокрил із великим пропелером", levelNumber = 54, categoryTier = 3,
        stickerReward = StickerReward("sticker_54", "🚁", "Швидкий Гелікоптер", "Рятує та допомагає друзям!", Color(0xFFFF3B30)),
        regions = listOf(
            CatalogHelpers.createRegion("cabin", "Кабіна", 170f, 200f, pathBuilder = CatalogHelpers.ovalPath(100f, 140f, 240f, 260f)),
            CatalogHelpers.createRegion("tail_boom", "Хвостова балка", 290f, 200f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(230f * sx, 190f * sy); lineTo(345f * sx, 180f * sy); lineTo(345f * sx, 215f * sy); lineTo(230f * sx, 210f * sy); close() }
            },
            CatalogHelpers.createRegion("rotor", "Головний пропелер", 170f, 105f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(60f * sx, 115f * sy); lineTo(280f * sx, 115f * sy); lineTo(280f * sx, 125f * sy); lineTo(60f * sx, 125f * sy); close() }
            },
            CatalogHelpers.createRegion("skids", "Лижі посадки", 170f, 290f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(80f * sx, 295f * sy); lineTo(250f * sx, 295f * sy); lineTo(250f * sx, 305f * sy); lineTo(80f * sx, 305f * sy); close() }
            }
        )
    )

    // 55: Веселий Потяг (Train)
    private fun createLevel55() = ColoringPicture(
        id = 55, title = "Веселий Потяг", subtitle = "Паровоз із вагончиками та димом", levelNumber = 55, categoryTier = 3,
        stickerReward = StickerReward("sticker_55", "🚂", "Залізний Потяг", "Чух-чух по коліях!", Color(0xFF34C759)),
        regions = listOf(
            CatalogHelpers.createRegion("boiler", "Котел паровоза", 175f, 205f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(110f * sx, 160f * sy); lineTo(240f * sx, 160f * sy); lineTo(240f * sx, 250f * sy); lineTo(110f * sx, 250f * sy); close() }
            },
            CatalogHelpers.createRegion("cab", "Кабіна машиніста", 275f, 185f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(240f * sx, 120f * sy); lineTo(320f * sx, 120f * sy); lineTo(320f * sx, 250f * sy); lineTo(240f * sx, 250f * sy); close() }
            },
            CatalogHelpers.createRegion("stack", "Труба для диму", 145f, 130f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(130f * sx, 160f * sy); lineTo(130f * sx, 105f * sy); lineTo(160f * sx, 105f * sy); lineTo(160f * sx, 160f * sy); close() }
            },
            CatalogHelpers.createRegion("wheel_1", "Колесо 1", 150f, 275f, pathBuilder = CatalogHelpers.ovalPath(125f, 250f, 175f, 300f)),
            CatalogHelpers.createRegion("wheel_2", "Колесо 2", 215f, 275f, pathBuilder = CatalogHelpers.ovalPath(190f, 250f, 240f, 300f)),
            CatalogHelpers.createRegion("wheel_big", "Велике колесо", 280f, 275f, pathBuilder = CatalogHelpers.ovalPath(250f, 245f, 310f, 305f))
        )
    )

    // 56: Спортивне Авто (Race Car)
    private fun createLevel56() = ColoringPicture(
        id = 56, title = "Спортивне Авто", subtitle = "Червоний болід для швидких перегонів", levelNumber = 56, categoryTier = 3,
        stickerReward = StickerReward("sticker_56", "🏎️", "Супергонщик", "Мчить швидше за вітер!", Color(0xFFFF3B30)),
        regions = listOf(
            CatalogHelpers.createRegion("body", "Кузов боліда", 200f, 220f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(70f * sx, 240f * sy); lineTo(140f * sx, 200f * sy); lineTo(260f * sx, 200f * sy); lineTo(330f * sx, 230f * sy); lineTo(330f * sx, 255f * sy); lineTo(70f * sx, 255f * sy); close() }
            },
            CatalogHelpers.createRegion("spoiler", "Спойлер", 85f, 180f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(60f * sx, 165f * sy); lineTo(110f * sx, 165f * sy); lineTo(110f * sx, 195f * sy); lineTo(60f * sx, 195f * sy); close() }
            },
            CatalogHelpers.createRegion("wheel_f", "Переднє колесо", 285f, 260f, pathBuilder = CatalogHelpers.ovalPath(260f, 235f, 310f, 285f)),
            CatalogHelpers.createRegion("wheel_r", "Заднє колесо", 125f, 260f, pathBuilder = CatalogHelpers.ovalPath(100f, 235f, 150f, 285f))
        )
    )

    // 57: Велика Вантажівка (Truck)
    private fun createLevel57() = ColoringPicture(
        id = 57, title = "Велика Вантажівка", subtitle = "Міцний самоскид із піском у кузові", levelNumber = 57, categoryTier = 3,
        stickerReward = StickerReward("sticker_57", "🚛", "Міцна Вантажівка", "Перевозить важливі вантажі!", Color(0xFFFF9500)),
        regions = listOf(
            CatalogHelpers.createRegion("cab", "Кабіна", 120f, 200f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(80f * sx, 160f * sy); lineTo(160f * sx, 160f * sy); lineTo(160f * sx, 265f * sy); lineTo(80f * sx, 265f * sy); close() }
            },
            CatalogHelpers.createRegion("cargo", "Кузов", 245f, 185f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(170f * sx, 130f * sy); lineTo(325f * sx, 130f * sy); lineTo(325f * sx, 265f * sy); lineTo(170f * sx, 265f * sy); close() }
            },
            CatalogHelpers.createRegion("wheel_1", "Колесо переднє", 115f, 280f, pathBuilder = CatalogHelpers.ovalPath(95f, 260f, 135f, 300f)),
            CatalogHelpers.createRegion("wheel_2", "Колесо середнє", 215f, 280f, pathBuilder = CatalogHelpers.ovalPath(195f, 260f, 235f, 300f)),
            CatalogHelpers.createRegion("wheel_3", "Колесо заднє", 285f, 280f, pathBuilder = CatalogHelpers.ovalPath(265f, 260f, 305f, 300f))
        )
    )

    // 58: Пожежна Машина (Fire Truck)
    private fun createLevel58() = ColoringPicture(
        id = 58, title = "Пожежна Машина", subtitle = "Червона машина з драбиною та сиреною", levelNumber = 58, categoryTier = 3,
        stickerReward = StickerReward("sticker_58", "🚒", "Герой-Пожежник", "Завжди поспішає на допомогу!", Color(0xFFFF3B30)),
        regions = listOf(
            CatalogHelpers.createRegion("body", "Червоний корпус", 200f, 215f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(80f * sx, 170f * sy); lineTo(320f * sx, 170f * sy); lineTo(320f * sx, 265f * sy); lineTo(80f * sx, 265f * sy); close() }
            },
            CatalogHelpers.createRegion("ladder", "Пожежна драбина", 190f, 140f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(110f * sx, 135f * sy); lineTo(270f * sx, 135f * sy); lineTo(270f * sx, 155f * sy); lineTo(110f * sx, 155f * sy); close() }
            },
            CatalogHelpers.createRegion("siren", "Мигалка", 125f, 145f, pathBuilder = CatalogHelpers.ovalPath(115f, 135f, 135f, 155f)),
            CatalogHelpers.createRegion("wheel_1", "Переднє колесо", 130f, 280f, pathBuilder = CatalogHelpers.ovalPath(110f, 260f, 150f, 300f)),
            CatalogHelpers.createRegion("wheel_2", "Заднє колесо", 270f, 280f, pathBuilder = CatalogHelpers.ovalPath(250f, 260f, 290f, 300f))
        )
    )

    // 59: Польовий Трактор (Tractor)
    private fun createLevel59() = ColoringPicture(
        id = 59, title = "Польовий Трактор", subtitle = "Працьовитий трактор із великими колесами", levelNumber = 59, categoryTier = 3,
        stickerReward = StickerReward("sticker_59", "🚜", "Господар Полів", "Оре та засіває землю!", Color(0xFF34C759)),
        regions = listOf(
            CatalogHelpers.createRegion("hood", "Капот двигуна", 150f, 220f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(95f * sx, 190f * sy); lineTo(205f * sx, 190f * sy); lineTo(205f * sx, 250f * sy); lineTo(95f * sx, 250f * sy); close() }
            },
            CatalogHelpers.createRegion("cab", "Кабіна", 240f, 180f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(205f * sx, 130f * sy); lineTo(275f * sx, 130f * sy); lineTo(275f * sx, 230f * sy); lineTo(205f * sx, 230f * sy); close() }
            },
            CatalogHelpers.createRegion("wheel_rear", "Гігантське колесо", 255f, 265f, pathBuilder = CatalogHelpers.ovalPath(210f, 220f, 300f, 310f)),
            CatalogHelpers.createRegion("wheel_front", "Мале колесо", 135f, 265f, pathBuilder = CatalogHelpers.ovalPath(115f, 245f, 155f, 285f))
        )
    )

    // 60: Підводний Човен (Submarine)
    private fun createLevel60() = ColoringPicture(
        id = 60, title = "Підводний Човен", subtitle = "Жовтий батискаф серед підводних рифів", levelNumber = 60, categoryTier = 3,
        stickerReward = StickerReward("sticker_60", "🤿", "Глибоководний Човен", "Досліджує морське дно!", Color(0xFFFFD54F)),
        regions = listOf(
            CatalogHelpers.createRegion("hull", "Корпус субмарини", 190f, 215f, pathBuilder = CatalogHelpers.ovalPath(90f, 160f, 290f, 270f)),
            CatalogHelpers.createRegion("tower", "Рубка з перископом", 190f, 125f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(165f * sx, 160f * sy); lineTo(165f * sx, 115f * sy); lineTo(215f * sx, 115f * sy); lineTo(215f * sx, 160f * sy); close() }
            },
            CatalogHelpers.createRegion("porthole_1", "Ілюмінатор 1", 150f, 215f, pathBuilder = CatalogHelpers.ovalPath(135f, 200f, 165f, 230f)),
            CatalogHelpers.createRegion("porthole_2", "Ілюмінатор 2", 230f, 215f, pathBuilder = CatalogHelpers.ovalPath(215f, 200f, 245f, 230f)),
            CatalogHelpers.createRegion("propeller", "Гвинт", 305f, 215f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(290f * sx, 215f * sy); lineTo(325f * sx, 190f * sy); lineTo(325f * sx, 240f * sy); close() }
            }
        )
    )

    // 61: Морський Вітрильник (Sailboat)
    private fun createLevel61() = ColoringPicture(
        id = 61, title = "Морський Вітрильник", subtitle = "Велична яхта під білими вітрилами", levelNumber = 61, categoryTier = 3,
        stickerReward = StickerReward("sticker_61", "⛵", "Володар Хвиль", "Мчить під попутним вітром!", Color(0xFF007AFF)),
        regions = listOf(
            CatalogHelpers.createRegion("hull", "Корпус яхти", 200f, 280f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(85f * sx, 250f * sy); lineTo(315f * sx, 250f * sy); lineTo(265f * sx, 310f * sy); lineTo(135f * sx, 310f * sy); close() }
            },
            CatalogHelpers.createRegion("mainsail", "Головне вітрило", 240f, 155f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(205f * sx, 75f * sy); lineTo(295f * sx, 235f * sy); lineTo(205f * sx, 235f * sy); close() }
            },
            CatalogHelpers.createRegion("foresail", "Переднє вітрило", 160f, 170f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(195f * sx, 105f * sy); lineTo(195f * sx, 235f * sy); lineTo(125f * sx, 235f * sy); close() }
            }
        )
    )

    // 62: Повітряна Куля (Hot Air Balloon)
    private fun createLevel62() = ColoringPicture(
        id = 62, title = "Повітряна Куля", subtitle = "Велика куля з кошиком у синьому небі", levelNumber = 62, categoryTier = 3,
        stickerReward = StickerReward("sticker_62", "🧺", "Небесний Мандрівник", "Відкриває дивовижні краєвиди!", Color(0xFFFF9500)),
        regions = listOf(
            CatalogHelpers.createRegion("envelope", "Купольна куля", 200f, 160f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(200f * sx, 260f * sy); cubicTo(90f * sx, 230f * sy, 80f * sx, 70f * sy, 200f * sx, 70f * sy); cubicTo(320f * sx, 70f * sy, 310f * sx, 230f * sy, 200f * sx, 260f * sy); close() }
            },
            CatalogHelpers.createRegion("basket", "Плетений кошик", 200f, 310f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(175f * sx, 290f * sy); lineTo(225f * sx, 290f * sy); lineTo(220f * sx, 330f * sy); lineTo(180f * sx, 330f * sy); close() }
            }
        )
    )

    // 63: Швидкий Мотоцикл (Motorcycle)
    private fun createLevel63() = ColoringPicture(
        id = 63, title = "Швидкий Мотоцикл", subtitle = "Двоколісний мотобайк на шосе", levelNumber = 63, categoryTier = 3,
        stickerReward = StickerReward("sticker_63", "🏍️", "Лихий Байкер", "Рев мотора і свобода!", Color(0xFFFF3B30)),
        regions = listOf(
            CatalogHelpers.createRegion("tank_body", "Бак та рама", 195f, 195f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(130f * sx, 180f * sy); lineTo(260f * sx, 180f * sy); lineTo(230f * sx, 240f * sy); lineTo(150f * sx, 240f * sy); close() }
            },
            CatalogHelpers.createRegion("wheel_front", "Переднє колесо", 270f, 255f, pathBuilder = CatalogHelpers.ovalPath(240f, 225f, 300f, 285f)),
            CatalogHelpers.createRegion("wheel_back", "Заднє колесо", 130f, 255f, pathBuilder = CatalogHelpers.ovalPath(100f, 225f, 160f, 285f))
        )
    )

    // 64: Дитячий Велосипед (Bicycle)
    private fun createLevel64() = ColoringPicture(
        id = 64, title = "Дитячий Велосипед", subtitle = "Зручний ровер із дзвіночком на кермі", levelNumber = 64, categoryTier = 3,
        stickerReward = StickerReward("sticker_64", "🚲", "Вело-Чемпіон", "Крути педалі швидше!", Color(0xFF34C759)),
        regions = listOf(
            CatalogHelpers.createRegion("frame", "Рама велосипеда", 200f, 205f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(130f * sx, 255f * sy); lineTo(200f * sx, 160f * sy); lineTo(270f * sx, 255f * sy); close() }
            },
            CatalogHelpers.createRegion("wheel_front", "Переднє колесо", 275f, 255f, pathBuilder = CatalogHelpers.ovalPath(245f, 225f, 305f, 285f)),
            CatalogHelpers.createRegion("wheel_rear", "Заднє колесо", 125f, 255f, pathBuilder = CatalogHelpers.ovalPath(95f, 225f, 155f, 285f))
        )
    )

    // 65: Шкільний Автобус (Bus)
    private fun createLevel65() = ColoringPicture(
        id = 65, title = "Шкільний Автобус", subtitle = "Жовтий автобус везе друзів на уроки", levelNumber = 65, categoryTier = 3,
        stickerReward = StickerReward("sticker_65", "🚌", "Шкільний Автобус", "Весела поїздка до школи!", Color(0xFFFFD54F)),
        regions = listOf(
            CatalogHelpers.createRegion("bus_body", "Жовтий кузов", 200f, 205f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(70f * sx, 150f * sy); lineTo(330f * sx, 150f * sy); lineTo(330f * sx, 260f * sy); lineTo(70f * sx, 260f * sy); close() }
            },
            CatalogHelpers.createRegion("windows", "Вікна", 200f, 180f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(95f * sx, 165f * sy); lineTo(305f * sx, 165f * sy); lineTo(305f * sx, 200f * sy); lineTo(95f * sx, 200f * sy); close() }
            },
            CatalogHelpers.createRegion("wheel_f", "Переднє колесо", 280f, 275f, pathBuilder = CatalogHelpers.ovalPath(260f, 255f, 300f, 295f)),
            CatalogHelpers.createRegion("wheel_b", "Заднє колесо", 130f, 275f, pathBuilder = CatalogHelpers.ovalPath(110f, 255f, 150f, 295f))
        )
    )

    // 66: Будівельний Екскаватор (Excavator)
    private fun createLevel66() = ColoringPicture(
        id = 66, title = "Будівельний Екскаватор", subtitle = "Потужний ківш насипає гору піску", levelNumber = 66, categoryTier = 3,
        stickerReward = StickerReward("sticker_66", "🏗️", "Майстер Будівництва", "Будує нові міста!", Color(0xFFFF9500)),
        regions = listOf(
            CatalogHelpers.createRegion("cab", "Кабіна екскаватора", 160f, 200f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(120f * sx, 160f * sy); lineTo(200f * sx, 160f * sy); lineTo(200f * sx, 250f * sy); lineTo(120f * sx, 250f * sy); close() }
            },
            CatalogHelpers.createRegion("arm", "Стріла та ківш", 270f, 175f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(200f * sx, 210f * sy); lineTo(280f * sx, 120f * sy); lineTo(330f * sx, 200f * sy); lineTo(300f * sx, 210f * sy); close() }
            },
            CatalogHelpers.createRegion("tracks", "Гусениці", 160f, 275f, pathBuilder = CatalogHelpers.ovalPath(100f, 250f, 220f, 300f))
        )
    )

    // 67: Космічне НЛО (UFO)
    private fun createLevel67() = ColoringPicture(
        id = 67, title = "Космічне НЛО", subtitle = "Тарілка прибульців із променем світла", levelNumber = 67, categoryTier = 3,
        stickerReward = StickerReward("sticker_67", "🛸", "Гість із Космосу", "Прибульці з далекої галактики!", Color(0xFFAF52DE)),
        regions = listOf(
            CatalogHelpers.createRegion("dome", "Скляний купол", 200f, 140f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(155f * sx, 170f * sy); cubicTo(155f * sx, 100f * sy, 245f * sx, 100f * sy, 245f * sx, 170f * sy); close() }
            },
            CatalogHelpers.createRegion("saucer", "Літаюча тарілка", 200f, 195f, pathBuilder = CatalogHelpers.ovalPath(85f, 160f, 315f, 230f)),
            CatalogHelpers.createRegion("beam", "Промінь світла", 200f, 290f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(160f * sx, 225f * sy); lineTo(100f * sx, 355f * sy); lineTo(300f * sx, 355f * sy); lineTo(240f * sx, 225f * sy); close() }
            }
        )
    )

    // 68: Кільчастий Сатурн (Saturn)
    private fun createLevel68() = ColoringPicture(
        id = 68, title = "Кільчастий Сатурн", subtitle = "Гігантська планета з сяючими кільцями", levelNumber = 68, categoryTier = 3,
        stickerReward = StickerReward("sticker_68", "🪐", "Кільця Сатурна", "Космічна перлина Сонячної системи!", Color(0xFFFFD54F)),
        regions = listOf(
            CatalogHelpers.createRegion("planet", "Планета Сатурн", 200f, 200f, pathBuilder = CatalogHelpers.ovalPath(130f, 130f, 270f, 270f)),
            CatalogHelpers.createRegion("ring_front", "Сяючі кільця", 200f, 200f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(50f * sx, 200f * sy); cubicTo(90f * sx, 270f * sy, 310f * sx, 270f * sy, 350f * sx, 200f * sy); cubicTo(310f * sx, 250f * sy, 90f * sx, 250f * sy, 50f * sx, 200f * sy); close() }
            }
        )
    )

    // 69: Космічний Скафандр (Astronaut)
    private fun createLevel69() = ColoringPicture(
        id = 69, title = "Космічний Скафандр", subtitle = "Костюм хороброго космонавта на Місяці", levelNumber = 69, categoryTier = 3,
        stickerReward = StickerReward("sticker_69", "👨‍🚀", "Юний Космонавт", "Перший крок на Місяці!", Color(0xFF00C7FF)),
        regions = listOf(
            CatalogHelpers.createRegion("helmet", "Шолом", 200f, 130f, pathBuilder = CatalogHelpers.ovalPath(150f, 80f, 250f, 180f)),
            CatalogHelpers.createRegion("visor", "Золоте скло", 200f, 130f, pathBuilder = CatalogHelpers.ovalPath(165f, 105f, 235f, 155f)),
            CatalogHelpers.createRegion("suit", "Скафандр", 200f, 260f, pathBuilder = CatalogHelpers.ovalPath(135f, 180f, 265f, 340f))
        )
    )

    // 70: Морський Маяк (Lighthouse)
    private fun createLevel70() = ColoringPicture(
        id = 70, title = "Морський Маяк", subtitle = "Висока вежа, що світить кораблям у шторм", levelNumber = 70, categoryTier = 3,
        stickerReward = StickerReward("sticker_70", "🗼", "Незламний Маяк", "Світить крізь шторм!", Color(0xFFFF3B30)),
        regions = listOf(
            CatalogHelpers.createRegion("tower", "Вежа маяка", 200f, 220f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(175f * sx, 130f * sy); lineTo(225f * sx, 130f * sy); lineTo(250f * sx, 330f * sy); lineTo(150f * sx, 330f * sy); close() }
            },
            CatalogHelpers.createRegion("lantern", "Ліхтарна рубка", 200f, 95f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(175f * sx, 130f * sy); lineTo(225f * sx, 130f * sy); lineTo(200f * sx, 60f * sy); close() }
            },
            CatalogHelpers.createRegion("rock", "Скеля", 200f, 350f, pathBuilder = CatalogHelpers.ovalPath(100f, 325f, 300f, 375f))
        )
    )

    // 71: Піратський Фрегат (Pirate Ship)
    private fun createLevel71() = ColoringPicture(
        id = 71, title = "Піратський Фрегат", subtitle = "Старовинний корабель із чорним прапором", levelNumber = 71, categoryTier = 3,
        stickerReward = StickerReward("sticker_71", "🏴‍☠️", "Капітан Піратів", "Скарби та пригоди на морі!", Color(0xFF8B572A)),
        regions = listOf(
            CatalogHelpers.createRegion("hull", "Дерев'яний корпус", 200f, 280f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(80f * sx, 240f * sy); lineTo(320f * sx, 240f * sy); lineTo(275f * sx, 315f * sy); lineTo(125f * sx, 315f * sy); close() }
            },
            CatalogHelpers.createRegion("sail_1", "Вітрило переднє", 155f, 160f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(125f * sx, 115f * sy); lineTo(185f * sx, 115f * sy); lineTo(185f * sx, 210f * sy); lineTo(125f * sx, 210f * sy); close() }
            },
            CatalogHelpers.createRegion("sail_2", "Вітрило заднє", 245f, 160f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(215f * sx, 115f * sy); lineTo(275f * sx, 115f * sy); lineTo(275f * sx, 210f * sy); lineTo(215f * sx, 210f * sy); close() }
            }
        )
    )

    // 72: Повітряний Змій (Kite)
    private fun createLevel72() = ColoringPicture(
        id = 72, title = "Повітряний Змій", subtitle = "Ромбовий змій із барвистим довгим хвостом", levelNumber = 72, categoryTier = 3,
        stickerReward = StickerReward("sticker_72", "🪁", "Вільний Змій", "Танцює з вітром!", Color(0xFFFF2D55)),
        regions = listOf(
            CatalogHelpers.createRegion("top_quad", "Верхня половина", 200f, 115f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(200f * sx, 50f * sy); lineTo(290f * sx, 170f * sy); lineTo(110f * sx, 170f * sy); close() }
            },
            CatalogHelpers.createRegion("bot_quad", "Нижня половина", 200f, 245f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(110f * sx, 170f * sy); lineTo(290f * sx, 170f * sy); lineTo(200f * sx, 320f * sy); close() }
            },
            CatalogHelpers.createRegion("tail_bow", "Бантик на хвості", 200f, 355f, pathBuilder = CatalogHelpers.ovalPath(185f, 345f, 215f, 365f))
        )
    )

    // 73: Трюковий Скейтборд (Skateboard)
    private fun createLevel73() = ColoringPicture(
        id = 73, title = "Трюковий Скейтборд", subtitle = "Дошка на колесах для сміливих стрибків", levelNumber = 73, categoryTier = 3,
        stickerReward = StickerReward("sticker_73", "🛹", "Майстер Скейту", "Трюки та адреналін!", Color(0xFF007AFF)),
        regions = listOf(
            CatalogHelpers.createRegion("deck", "Дошка скейтборда", 200f, 200f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(60f * sx, 185f * sy); cubicTo(110f * sx, 205f * sy, 290f * sx, 205f * sy, 340f * sx, 185f * sy); lineTo(335f * sx, 210f * sy); cubicTo(285f * sx, 230f * sy, 115f * sx, 230f * sy, 65f * sx, 210f * sy); close() }
            },
            CatalogHelpers.createRegion("wheel_1", "Переднє колесо", 285f, 245f, pathBuilder = CatalogHelpers.ovalPath(270f, 230f, 300f, 260f)),
            CatalogHelpers.createRegion("wheel_2", "Заднє колесо", 115f, 245f, pathBuilder = CatalogHelpers.ovalPath(100f, 230f, 130f, 260f))
        )
    )

    // 74: Підводний Батискаф (Bathyscaphe)
    private fun createLevel74() = ColoringPicture(
        id = 74, title = "Підводний Батискаф", subtitle = "Глибоководний апарат із прожекторами", levelNumber = 74, categoryTier = 3,
        stickerReward = StickerReward("sticker_74", "🫧", "Шукач Перлин", "Глибини Маріанської западини!", Color(0xFF00C7FF)),
        regions = listOf(
            CatalogHelpers.createRegion("sphere", "Сферичний корпус", 200f, 200f, pathBuilder = CatalogHelpers.ovalPath(120f, 120f, 280f, 280f)),
            CatalogHelpers.createRegion("viewport", "Оглядове вікно", 200f, 200f, pathBuilder = CatalogHelpers.ovalPath(155f, 155f, 245f, 245f)),
            CatalogHelpers.createRegion("light", "Прожектор", 285f, 155f, pathBuilder = CatalogHelpers.ovalPath(270f, 140f, 300f, 170f))
        )
    )

    // 75: Золотий Кубок (Trophy Cup)
    private fun createLevel75() = ColoringPicture(
        id = 75, title = "Золотий Кубок", subtitle = "Блискучий кубок за перемогу в грі", levelNumber = 75, categoryTier = 3,
        stickerReward = StickerReward("sticker_75", "🏆", "Золотий Тріумф", "Кубок справжнього переможця!", Color(0xFFFFD54F)),
        regions = listOf(
            CatalogHelpers.createRegion("cup_bowl", "Чаша кубка", 200f, 145f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(130f * sx, 90f * sy); lineTo(270f * sx, 90f * sy); cubicTo(270f * sx, 190f * sy, 200f * sx, 200f * sy, 200f * sx, 200f * sy); cubicTo(200f * sx, 200f * sy, 130f * sx, 190f * sy, 130f * sx, 90f * sy); close() }
            },
            CatalogHelpers.createRegion("handle_l", "Ліва ручка", 110f, 140f, pathBuilder = CatalogHelpers.ovalPath(90f, 110f, 130f, 170f)),
            CatalogHelpers.createRegion("handle_r", "Права ручка", 290f, 140f, pathBuilder = CatalogHelpers.ovalPath(270f, 110f, 310f, 170f)),
            CatalogHelpers.createRegion("stem", "Ніжка кубка", 200f, 240f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(190f * sx, 200f * sy); lineTo(210f * sx, 200f * sy); lineTo(210f * sx, 280f * sy); lineTo(190f * sx, 280f * sy); close() }
            },
            CatalogHelpers.createRegion("base", "Постамент", 200f, 310f) { w, h ->
                val sx = w / 400f; val sy = h / 400f
                Path().apply { moveTo(140f * sx, 280f * sy); lineTo(260f * sx, 280f * sy); lineTo(275f * sx, 340f * sy); lineTo(125f * sx, 340f * sy); close() }
            }
        )
    )
}
