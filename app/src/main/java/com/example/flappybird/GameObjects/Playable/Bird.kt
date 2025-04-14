package com.example.flappybird.GameObjects.Playable

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import com.example.flappybird.GameObjects.GameObject

class Bird(x: Float, y: Float) : GameObject(x, y, 60f, 60f) {
    private val gravity = 0.05f
    private val jumpPower = 0.1f
    private val offsetHitbox = 10
    var ascendingState = false
    private val acceleration = 0.01f // Accélération constante
    var oldY = y

    init {
        bodyObject = RectF(x - width + offsetHitbox, y - height + offsetHitbox, x + width - offsetHitbox, y + height - offsetHitbox)
    }

    override fun update(time: Int) {
        if (ascendingState && y > oldY - 300) {
            y -= jumpPower * time * time / 2
        } else {
            ascendingState = false
            oldY = y
            y += (gravity) * time * time / 2
        }

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
