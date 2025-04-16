package com.example.flappybird.GameObjects.Obstacles

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF

abstract class Obstacle {
    var allShapesForOneObstacle = ArrayList<RectF>()
    private val paint = Paint()
    protected var color = 0

    fun draw(canvas: Canvas){
        paint.color = color
        for (shape in allShapesForOneObstacle){
            canvas.drawRect(shape, paint)
        }
    }
}