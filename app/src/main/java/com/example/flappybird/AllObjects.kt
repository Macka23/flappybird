package com.example.flappybird

import android.content.Context
import android.graphics.Canvas
import android.view.SurfaceHolder

class AllObjects(var context: Context, var canvas: Canvas, val holder: SurfaceHolder) {
    val bird = Bird(300f, 600f)
    var ListOfPipes = mutableListOf<Obstacle>().apply {
        add(Pipe())
    }
    val score = Score
    private var scoreObserver: ScoreObserver? = null

    init {
        score.clearObservers()
        println("Initialisation")
        Score.yourScore = 0
        ListOfPipes.clear()
        ListOfPipes.add(Pipe())

        scoreObserver = ScoreObserver(context)
        score.addObserver(scoreObserver!!)
    }
}