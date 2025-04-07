package com.example.flappybird

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

class Bird(x: Float, y: Float) : GameObject(x, y, 60f, 60f) {

    private var velocity = 0f
    private val gravity = 1.5f
    private val flapPower = -20f

    fun flap() {
        velocity = flapPower
    }

    override fun update() {
        velocity += gravity
        y += velocity

        if (y > 1800f) {
            y = 1800f
            velocity = 0f
        }
    }

    override fun draw(canvas: Canvas, paint: Paint) {
        paint.color = Color.YELLOW
        canvas.drawCircle(x, y, width, paint)
    }
}
