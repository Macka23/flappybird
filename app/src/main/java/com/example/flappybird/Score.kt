package com.example.flappybird

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

object Score : GameObject(x = 50f, y = 140f, width = 0f, height = 0f) {
    var yourScore = 0
    private val textPaint = Paint()

    override fun update(t: Int) {
        yourScore += 1
    }

    override fun draw(canvas: Canvas, paint: Paint) {
        textPaint.color = Color.WHITE
        textPaint.textSize = 50f
        val scoreToString = "Your score is $yourScore"
        canvas.drawText(scoreToString, x, y, textPaint)
    }
}