package com.example.flappybird

import android.app.Activity
import android.os.Bundle


class GameActivity : Activity() {
    private lateinit var gameView: GameView

    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_game)
//        gameView = findViewById(R.id.vEasy)
//        gameView.setWillNotDraw(false) // Cette ligne et la suivante s'occupent en arrière plan d'autoriser l'affichage, d'effacer tout ce qui se trouve à l'écran et finalement d'exécuter au mieux l'affichage graphique sur la vue dessin (explication tirée de la formation du prof)
//        gameView.invalidate()

        super.onCreate(savedInstanceState)
        gameView = GameView(this)
        setContentView(gameView)
    }

    override fun onResume() {
        super.onResume()
        gameView.resume()
    }

    override fun onPause() {
        super.onPause()
        gameView.pause()
    }
}