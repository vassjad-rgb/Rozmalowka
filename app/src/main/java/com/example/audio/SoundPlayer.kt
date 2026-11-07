package com.example.audio

import android.media.AudioAttributes
import android.media.AudioFormat
import android.media.AudioTrack
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.math.PI
import kotlin.math.sin

/**
 * Kid-friendly, low-latency synthesized audio effects player using standard Android AudioTrack.
 * Generates cheerful musical chimes, pops, fanfares, and boings without needing external audio files.
 */
class SoundPlayer(private val coroutineScope: CoroutineScope) {

    var isSoundEnabled: Boolean = true

    private val sampleRate = 22050

    /**
     * Plays a cute, short pitch-drop "pop" when selecting a crayon or tapping.
     */
    fun playPop() {
        if (!isSoundEnabled) return
        coroutineScope.launch(Dispatchers.Default) {
            val durationMs = 80
            val numSamples = (durationMs * sampleRate) / 1000
            val samples = ShortArray(numSamples)
            for (i in 0 until numSamples) {
                val t = i.toFloat() / numSamples
                val freq = 550f - (t * 220f)
                val envelope = (1f - t) * (1f - t)
                val sample = (sin(2.0 * PI * freq * i / sampleRate) * 0.7f * envelope * Short.MAX_VALUE).toInt()
                samples[i] = sample.coerceIn(Short.MIN_VALUE.toInt(), Short.MAX_VALUE.toInt()).toShort()
            }
            playPcm(samples)
        }
    }

    /**
     * Plays a pleasant musical chime when a region is filled with color.
     */
    fun playColorFill(pitchOffset: Int = 0) {
        if (!isSoundEnabled) return
        coroutineScope.launch(Dispatchers.Default) {
            val durationMs = 180
            val numSamples = (durationMs * sampleRate) / 1000
            val samples = ShortArray(numSamples)
            // Pentatonic cheerful frequencies
            val baseFreqs = listOf(523.25f, 587.33f, 659.25f, 783.99f, 880.00f, 1046.50f)
            val baseFreq = baseFreqs[Math.floorMod(pitchOffset, baseFreqs.size)]
            for (i in 0 until numSamples) {
                val t = i.toFloat() / numSamples
                val envelope = Math.exp(-4.5 * t).toFloat()
                // Rich tone with soft 2nd harmonic
                val s1 = sin(2.0 * PI * baseFreq * i / sampleRate)
                val s2 = 0.35 * sin(4.0 * PI * baseFreq * i / sampleRate)
                val sample = ((s1 + s2) * 0.7f * envelope * Short.MAX_VALUE).toInt()
                samples[i] = sample.coerceIn(Short.MIN_VALUE.toInt(), Short.MAX_VALUE.toInt()).toShort()
            }
            playPcm(samples)
        }
    }

    /**
     * Plays a playful boing/wiggle sound.
     */
    fun playBoing() {
        if (!isSoundEnabled) return
        coroutineScope.launch(Dispatchers.Default) {
            val durationMs = 220
            val numSamples = (durationMs * sampleRate) / 1000
            val samples = ShortArray(numSamples)
            for (i in 0 until numSamples) {
                val t = i.toFloat() / numSamples
                val wobble = sin(2.0 * PI * 18.0 * t).toFloat() * 60f
                val freq = 320f + wobble
                val envelope = (1f - t) * (1f - t)
                val sample = (sin(2.0 * PI * freq * i / sampleRate) * 0.65f * envelope * Short.MAX_VALUE).toInt()
                samples[i] = sample.coerceIn(Short.MIN_VALUE.toInt(), Short.MAX_VALUE.toInt()).toShort()
            }
            playPcm(samples)
        }
    }

    /**
     * Plays magical sparkles for hints, magic brush, or sticker taps.
     */
    fun playSparkle() {
        if (!isSoundEnabled) return
        coroutineScope.launch(Dispatchers.Default) {
            val notes = listOf(880f, 1108.7f, 1318.5f, 1760f)
            val noteDurationMs = 50
            val numSamplesPerNote = (noteDurationMs * sampleRate) / 1000
            val totalSamples = numSamplesPerNote * notes.size
            val samples = ShortArray(totalSamples)

            for ((noteIdx, freq) in notes.withIndex()) {
                val offset = noteIdx * numSamplesPerNote
                for (i in 0 until numSamplesPerNote) {
                    val t = i.toFloat() / numSamplesPerNote
                    val envelope = (1f - t)
                    val sample = (sin(2.0 * PI * freq * (offset + i) / sampleRate) * 0.5f * envelope * Short.MAX_VALUE).toInt()
                    samples[offset + i] = sample.coerceIn(Short.MIN_VALUE.toInt(), Short.MAX_VALUE.toInt()).toShort()
                }
            }
            playPcm(samples)
        }
    }

    /**
     * Plays a triumphant fanfare when a level is 100% completed and sticker is won!
     * Ascending fanfare: C5, E5, G5, C6 with celebratory chime.
     */
    fun playFanfare() {
        if (!isSoundEnabled) return
        coroutineScope.launch(Dispatchers.Default) {
            val notes = listOf(523.25f, 659.25f, 783.99f, 1046.50f)
            val durations = listOf(140, 140, 160, 450)
            val totalDurationMs = durations.sum()
            val totalSamples = (totalDurationMs * sampleRate) / 1000
            val samples = ShortArray(totalSamples)

            var currentIndex = 0
            for (idx in notes.indices) {
                val freq = notes[idx]
                val durMs = durations[idx]
                val noteSamples = (durMs * sampleRate) / 1000
                for (i in 0 until noteSamples) {
                    if (currentIndex + i >= totalSamples) break
                    val t = i.toFloat() / noteSamples
                    val decay = if (idx == notes.lastIndex) Math.exp(-2.5 * t).toFloat() else (1f - 0.2f * t)
                    val s1 = sin(2.0 * PI * freq * i / sampleRate)
                    val s2 = 0.3 * sin(4.0 * PI * freq * i / sampleRate)
                    val s3 = 0.2 * sin(6.0 * PI * freq * i / sampleRate)
                    val sample = ((s1 + s2 + s3) * 0.75f * decay * Short.MAX_VALUE).toInt()
                    samples[currentIndex + i] = sample.coerceIn(Short.MIN_VALUE.toInt(), Short.MAX_VALUE.toInt()).toShort()
                }
                currentIndex += noteSamples
            }
            playPcm(samples)
        }
    }

    private fun playPcm(samples: ShortArray) {
        try {
            val audioTrack = AudioTrack.Builder()
                .setAudioAttributes(
                    AudioAttributes.Builder()
                        .setUsage(AudioAttributes.USAGE_GAME)
                        .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                        .build()
                )
                .setAudioFormat(
                    AudioFormat.Builder()
                        .setEncoding(AudioFormat.ENCODING_PCM_16BIT)
                        .setSampleRate(sampleRate)
                        .setChannelMask(AudioFormat.CHANNEL_OUT_MONO)
                        .build()
                )
                .setBufferSizeInBytes(samples.size * 2)
                .setTransferMode(AudioTrack.MODE_STATIC)
                .build()

            audioTrack.write(samples, 0, samples.size)
            audioTrack.play()
            // Track will release naturally once played or in a coroutine
            coroutineScope.launch(Dispatchers.IO) {
                val durationMs = (samples.size * 1000L) / sampleRate
                kotlinx.coroutines.delay(durationMs + 200)
                try {
                    audioTrack.stop()
                    audioTrack.release()
                } catch (_: Exception) {}
            }
        } catch (_: Exception) {
            // AudioTrack fallback gracefully ignored on emulator audio constraints
        }
    }
}
