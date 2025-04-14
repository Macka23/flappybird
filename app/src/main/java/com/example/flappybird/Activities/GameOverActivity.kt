package com.example.flappybird.Activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.flappybird.GameObjects.Score.Score
import com.example.flappybird.R

class GameOverActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game_over)

        val retryButton: Button = findViewById(R.id.retryButton)
        val mainMenuButton: Button = findViewById(R.id.mainMenuButton)
        val finalScoreText: TextView = findViewById(R.id.finalScoreText)

        retryButton.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            startActivity(intent)
            finish()
        }

        val score = intent.getIntExtra("score", 0)
        finalScoreText.text = "Score: ${score}"

        mainMenuButton.setOnClickListener {
            val intent = Intent(this, MainMenuActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}