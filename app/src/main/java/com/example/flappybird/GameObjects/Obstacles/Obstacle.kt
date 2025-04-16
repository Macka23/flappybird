package com.example.flappybird.GameObjects.Obstacles

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import com.example.flappybird.Interfaces.Drawable

abstract class Obstacle: Drawable {
    var allShapesForOneObstacle = ArrayList<RectF>()
    protected var color = 0

    override fun draw(canvas: Canvas, paint: Paint){
        paint.color = color
        for (shape in allShapesForOneObstacle){
            canvas.drawRect(shape, paint)
        }
    }
}