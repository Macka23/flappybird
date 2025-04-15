package com.example.flappybird.GameObjects.Obstacles

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import com.example.flappybird.Constants.Constants
import com.example.flappybird.Interfaces.Drawable
import com.example.flappybird.Interfaces.Updatable

abstract class Obstacle: Updatable {
    var pipeSpeedX = 5f
    var Xpos = Constants.screenWidth
    var Ypos = 0f
    open val width : Float = 100f
    private val paint = Paint()
    protected var color = 0
    var allShapesForOnePipe = ArrayList<RectF>()


    fun draw(canvas: Canvas){
        paint.color = color
        for (shape in allShapesForOnePipe){
            canvas.drawRect(shape, paint)
        }
    }
}