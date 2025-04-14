package com.example.flappybird.GameObjects.Score

import android.content.Context
import android.media.MediaPlayer
import com.example.flappybird.Interfaces.GameObserver
import com.example.flappybird.R

class ScoreObserver(private val context: Context) : GameObserver {

    private var mediaPlayer: MediaPlayer? = null

    override fun onScoreChanged(score: Int) {
        playSound()
    }

    override fun onGameOver() {
        playSound()
    }

    private fun playSound() {
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(context, R.raw.score_sound)
            mediaPlayer?.setOnCompletionListener {
                mediaPlayer?.release()
                mediaPlayer = null
            }
        }
        mediaPlayer?.start()
    }
}
