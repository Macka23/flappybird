package com.example.flappybird.GameObjects.Score

import android.content.Context
import android.media.MediaPlayer
import com.example.flappybird.Interfaces.GameObserver
import com.example.flappybird.R

class ScoreObserver(private val context: Context) : GameObserver {
    override fun onScoreChanged(score: Int) {
        playSound()
    }

    override fun onGameOver() {
        playSound()
    }

    private fun playSound() {

    }
}
