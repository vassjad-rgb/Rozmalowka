package com.example.data

import com.example.data.catalog.LevelCatalog1To25
import com.example.data.catalog.LevelCatalog26To50
import com.example.data.catalog.LevelCatalog51To75
import com.example.data.catalog.LevelCatalog76To100
import com.example.model.ColoringPicture

object PictureRepository {

    private val cachedPictures: List<ColoringPicture> by lazy {
        LevelCatalog1To25.levels +
            LevelCatalog26To50.levels +
            LevelCatalog51To75.levels +
            LevelCatalog76To100.levels
    }

    fun getPictures(): List<ColoringPicture> = cachedPictures

    fun getPictureById(id: Int): ColoringPicture? = cachedPictures.find { it.id == id }
}
