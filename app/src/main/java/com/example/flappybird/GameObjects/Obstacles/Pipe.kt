package com.example.flappybird.GameObjects.Obstacles

import android.graphics.Color
import android.graphics.RectF
import com.example.flappybird.Constants.Constants

class Pipe : Obstacle() {
    private val pipe_speed = 5f
    private val upperShapeHeight = 200f + (0..600).random()

    private val upperShape = RectF(x_pos, 0f, x_pos + width,  upperShapeHeight)
    private val lowerShape = RectF(x_pos, upperShapeHeight + 500, x_pos + width,  Constants.screenHeight)

    init {
        allShapesForOnePipe.add(upperShape)
        allShapesForOnePipe.add(lowerShape)
        color = Color.GREEN
    }

    override fun update() {
        x_pos -= pipe_speed
        for (shape in allShapesForOnePipe){
            shape.offset(-pipe_speed, 0f)
        }
    }
}

