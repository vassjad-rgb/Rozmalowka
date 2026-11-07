package com.example

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.data.PictureRepository
import com.example.data.ProgressManager
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [34])
class ExampleRobolectricTest {

    @Test
    fun `read string from context`() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val appName = context.getString(R.string.app_name)
        assertEquals("Розмальовка", appName)
    }

    @Test
    fun `pictures repository has 100 levels with valid regions and rewards`() {
        val pictures = PictureRepository.getPictures()
        assertEquals(100, pictures.size)

        for (picture in pictures) {
            assertTrue("Picture ${picture.title} must have regions", picture.regions.isNotEmpty())
            assertTrue("Sticker reward must not be blank", picture.stickerReward.title.isNotBlank())
            assertTrue("Sticker emoji must not be blank", picture.stickerReward.emoji.isNotBlank())
        }
    }

    @Test
    fun `progress manager unlocks levels sequentially on completion`() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val progressManager = ProgressManager(context)

        assertEquals(1, progressManager.getUnlockedLevelMax())
        assertFalse(progressManager.isLevelCompleted(1))

        // Complete level 1
        progressManager.markLevelCompleted(1)
        assertTrue(progressManager.isLevelCompleted(1))
        assertEquals(2, progressManager.getUnlockedLevelMax())

        // Complete level 2
        progressManager.markLevelCompleted(2)
        assertTrue(progressManager.isLevelCompleted(2))
        assertEquals(3, progressManager.getUnlockedLevelMax())
    }
}
