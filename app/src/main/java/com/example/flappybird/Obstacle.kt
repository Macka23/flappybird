package com.example.flappybird

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF

abstract class Obstacle {
    var x_pos = Constants.screenWidth
    open val width : Float = 0f
    private val paint = Paint()
    protected var color = 0
    var allShapesForOnePipe = ArrayList<RectF>()


    fun draw(canvas: Canvas){
        paint.color = color
        for (shape in allShapesForOnePipe){
            canvas.drawRect(shape, paint)
        }
    }
    abstract fun update()
}