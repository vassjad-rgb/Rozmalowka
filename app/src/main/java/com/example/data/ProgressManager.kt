package com.example.data

import android.content.Context
import android.content.SharedPreferences
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import com.example.model.PlacedSticker
import org.json.JSONArray
import org.json.JSONObject

class ProgressManager(context: Context) {

    private val prefs: SharedPreferences = context.getSharedPreferences("coloring_kids_prefs", Context.MODE_PRIVATE)

    var soundEnabled: Boolean
        get() = prefs.getBoolean(KEY_SOUND, true)
        set(value) = prefs.edit().putBoolean(KEY_SOUND, value).apply()

    fun getUnlockedLevelMax(): Int {
        return prefs.getInt(KEY_MAX_UNLOCKED_LEVEL, 1)
    }

    fun unlockNextLevel(completedLevelId: Int) {
        val currentMax = getUnlockedLevelMax()
        val nextLevel = completedLevelId + 1
        if (nextLevel > currentMax && nextLevel <= 100) {
            prefs.edit().putInt(KEY_MAX_UNLOCKED_LEVEL, nextLevel).apply()
        }
    }

    fun isLevelCompleted(levelId: Int): Boolean {
        val completedSet = prefs.getStringSet(KEY_COMPLETED_LEVELS, emptySet()) ?: emptySet()
        return completedSet.contains(levelId.toString())
    }

    fun markLevelCompleted(levelId: Int) {
        val completedSet = (prefs.getStringSet(KEY_COMPLETED_LEVELS, emptySet()) ?: emptySet()).toMutableSet()
        completedSet.add(levelId.toString())
        prefs.edit().putStringSet(KEY_COMPLETED_LEVELS, completedSet).apply()
        unlockNextLevel(levelId)
    }

    fun getUnlockedStickers(): Set<String> {
        return prefs.getStringSet(KEY_UNLOCKED_STICKERS, emptySet()) ?: emptySet()
    }

    fun unlockSticker(stickerId: String) {
        val set = (prefs.getStringSet(KEY_UNLOCKED_STICKERS, emptySet()) ?: emptySet()).toMutableSet()
        set.add(stickerId)
        prefs.edit().putStringSet(KEY_UNLOCKED_STICKERS, set).apply()
    }

    fun savePictureColors(pictureId: Int, regionColors: Map<String, Color>) {
        val json = JSONObject()
        for ((regionId, color) in regionColors) {
            json.put(regionId, color.toArgb())
        }
        prefs.edit().putString(KEY_PICTURE_COLORS_PREFIX + pictureId, json.toString()).apply()
    }

    fun loadPictureColors(pictureId: Int): Map<String, Color> {
        val jsonStr = prefs.getString(KEY_PICTURE_COLORS_PREFIX + pictureId, null) ?: return emptyMap()
        val result = mutableMapOf<String, Color>()
        try {
            val json = JSONObject(jsonStr)
            val keys = json.keys()
            while (keys.hasNext()) {
                val regionId = keys.next()
                val argb = json.getInt(regionId)
                result[regionId] = Color(argb)
            }
        } catch (_: Exception) {}
        return result
    }

    fun clearPictureColors(pictureId: Int) {
        prefs.edit().remove(KEY_PICTURE_COLORS_PREFIX + pictureId).apply()
    }

    fun getPlacedStickers(): List<PlacedSticker> {
        val jsonStr = prefs.getString(KEY_PLACED_STICKERS, null) ?: return getDefaultPlacedStickers()
        val list = mutableListOf<PlacedSticker>()
        try {
            val arr = JSONArray(jsonStr)
            for (i in 0 until arr.length()) {
                val obj = arr.getJSONObject(i)
                list.add(
                    PlacedSticker(
                        instanceId = obj.getString("instanceId"),
                        stickerId = obj.getString("stickerId"),
                        emoji = obj.getString("emoji"),
                        title = obj.getString("title"),
                        xPercent = obj.getDouble("xPercent").toFloat(),
                        yPercent = obj.getDouble("yPercent").toFloat(),
                        scale = obj.optDouble("scale", 1.0).toFloat(),
                        rotation = obj.optDouble("rotation", 0.0).toFloat()
                    )
                )
            }
        } catch (_: Exception) {
            return getDefaultPlacedStickers()
        }
        return list
    }

    fun savePlacedStickers(stickers: List<PlacedSticker>) {
        val arr = JSONArray()
        for (item in stickers) {
            val obj = JSONObject().apply {
                put("instanceId", item.instanceId)
                put("stickerId", item.stickerId)
                put("emoji", item.emoji)
                put("title", item.title)
                put("xPercent", item.xPercent.toDouble())
                put("yPercent", item.yPercent.toDouble())
                put("scale", item.scale.toDouble())
                put("rotation", item.rotation.toDouble())
            }
            arr.put(obj)
        }
        prefs.edit().putString(KEY_PLACED_STICKERS, arr.toString()).apply()
    }

    private fun getDefaultPlacedStickers(): List<PlacedSticker> {
        return emptyList()
    }

    companion object {
        private const val KEY_SOUND = "sound_enabled"
        private const val KEY_MAX_UNLOCKED_LEVEL = "max_unlocked_level"
        private const val KEY_COMPLETED_LEVELS = "completed_levels_set"
        private const val KEY_UNLOCKED_STICKERS = "unlocked_stickers_set"
        private const val KEY_PICTURE_COLORS_PREFIX = "pic_colors_"
        private const val KEY_PLACED_STICKERS = "placed_stickers"
    }
}
