package com.example.flappybird.GameObjects

import android.content.Context
import android.graphics.Canvas
import android.view.SurfaceHolder
import com.example.flappybird.GameObjects.Playable.Bird
import com.example.flappybird.GameObjects.Obstacles.Pipe
import com.example.flappybird.GameObjects.Obstacles.StaticPipe
import com.example.flappybird.GameObjects.Score.Score
import com.example.flappybird.GameObjects.Score.ScoreObserver

class AllObjects(var context: Context, var canvas: Canvas, val holder: SurfaceHolder) {
    val bird = Bird(300f, 600f)
    var ListOfPipes = mutableListOf<Pipe>()

    val score = Score
    private var scoreObserver: ScoreObserver? = null

    init {
        Score.clearObservers()
        Score.yourScore = 0

        ListOfPipes.clear()
        ListOfPipes.add(StaticPipe())

        scoreObserver = ScoreObserver(context)
        Score.addObserver(scoreObserver!!)
    }
}