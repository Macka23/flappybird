package com.example.flappybird

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

class Pipe(x: Float, y: Float, width: Float, height: Float) : GameObject(x, y, width, height) {

    override fun update() {
        // Pour l’instant, rien : les tuyaux sont fixes
    }

    override fun draw(canvas: Canvas, paint: Paint) {
        paint.color = Color.GREEN
        canvas.drawRect(x, y, x + width, y + height, paint)
    }
}
