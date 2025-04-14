package com.example.flappybird

import android.graphics.Color
import android.graphics.RectF

class PipeMoving: Obstacle() {
    private val pipe_speed_x = 5f
    override val width = 50f
    private val upperShapeHeight = 200f + (0..600).random()
    private val pipeSpeedY = 5f
    private var inverter = listOf(-1, 1).random().toFloat()


    private val upperShape = RectF(x_pos, -(pipeSpeedY * 25), x_pos + width,  upperShapeHeight)
    private val lowerShape = RectF(x_pos, upperShapeHeight + 500, x_pos + width,  Constants.screenHeight + (pipeSpeedY * 25))

    init {
        allShapesForOnePipe.add(upperShape)
        allShapesForOnePipe.add(lowerShape)
        color = Color.RED
    }

    override fun update() {
        x_pos -= pipe_speed_x
        if (upperShape.bottom - 100 > upperShapeHeight || upperShape.bottom + 100 < upperShapeHeight) {
            inverter = -inverter
        }
        for (shape in allShapesForOnePipe){
            shape.offset(-pipe_speed_x, pipeSpeedY * inverter)
        }
    }
}
