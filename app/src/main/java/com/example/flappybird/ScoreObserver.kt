package com.example.flappybird

import android.content.Context
import android.media.MediaPlayer
import android.util.Log

class ScoreObserver(private val context: Context) : GameObserver {

    private var mediaPlayer: MediaPlayer? = null

    override fun onScoreChanged(score: Int) {
        playSound()
    }

    override fun onGameOver() {
        Log.d("ScoreObserver", "Game Over")
        playSound()
    }

    private fun playSound() {
        mediaPlayer = MediaPlayer.create(context, R.raw.score_sound)
        mediaPlayer?.start()

        mediaPlayer?.setOnCompletionListener {
            mediaPlayer?.release()
        }
    }
}
