package com.example.flappybird

import android.graphics.RectF
import android.util.Log
import kotlin.random.Random

class Pipe : Obstacle() {
    private val pipe_speed = 5f
    val pipe_width = 50f
    private val upperShapeHeight = 200f + (0..600).random()

    private val upperShape = RectF(x_pos, 0f, x_pos + pipe_width,  upperShapeHeight)
    private val lowerShape = RectF(x_pos, upperShapeHeight + 500, x_pos + pipe_width,  10000f)

    init {
        allShapesForOnePipe.add(upperShape)
        allShapesForOnePipe.add(lowerShape)
        Log.d("Pipe", Constants.screenHeight.toString())
    }

    fun update() {
       x_pos -= pipe_speed
        for (shape in allShapesForOnePipe){
            shape.offset(-pipe_speed, 0f)
        }
    }
}

