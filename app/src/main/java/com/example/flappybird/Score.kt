package com.example.flappybird

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

class Score(x : Float, y: Float) : GameObject(x, y, width = 0f, height = 0f) {
    var yourScore = 0
    private val textPaint = Paint()

    override fun update(){
        yourScore += 1
    }

    override fun draw(canvas: Canvas, paint: Paint) {
        textPaint.color = Color.WHITE
        textPaint.textSize = 50f
        val scoreToString = "Your score is $yourScore"
        canvas.drawText(scoreToString, x, y, textPaint)
    }
}