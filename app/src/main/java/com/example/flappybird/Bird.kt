package com.example.flappybird

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

class Bird(x: Float, y: Float) : GameObject(x, y, 60f, 60f) {
    private val gravity = 2f

    fun flap() {
        y -= 100f
    }

    override fun update() {
        y += gravity
    }

    override fun draw(canvas: Canvas, paint: Paint) {
        paint.color = Color.YELLOW
        canvas.drawCircle(x, y, width, paint)
    }
}
