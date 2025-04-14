package com.example.flappybird

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF

class Bird(x: Float, y: Float) : GameObject(x, y, 60f, 60f) {
    private val gravity = 5f
    private val jumpPower = 200f
    private val offsetHitbox = 10


    init {
        bodyObject = RectF(x - width + offsetHitbox, y - height + offsetHitbox, x + width - offsetHitbox, y + height - offsetHitbox)
    }

    fun jump() {
        y -= jumpPower
        updateHitbox()
    }

    override fun update() {
        if (y > Constants.screenHeight){
            y -= gravity
        }
        y += gravity
        updateHitbox()
    }

    private fun updateHitbox() {
        bodyObject.set(x - width + offsetHitbox, y - height + offsetHitbox, x + width - offsetHitbox, y + height - offsetHitbox)
    }

    override fun draw(canvas: Canvas, paint: Paint) {
        paint.color = Color.YELLOW
        canvas.drawCircle(x, y, width, paint)
        /* Hitbox testing */
//        paint.style = Paint.Style.STROKE
//        paint.color = Color.RED
//        canvas.drawRect(bodyObject, paint)
//        paint.style = Paint.Style.FILL
    }
}
