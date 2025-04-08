package com.example.flappybird

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

class Bird(x: Float, y: Float) : GameObject(x, y, 60f, 60f) {
    private val gravity = 5f
    private val jumpPower = 200f

    fun jump() {
        y -= jumpPower
    }

    override fun update() {
        if (y - 60 > Constants.screenHeight) {
            y -= gravity
        }
        y += gravity
    }

    override fun draw(canvas: Canvas, paint: Paint) {
        paint.color = Color.YELLOW
        canvas.drawCircle(x, y, width, paint)
    }
}
