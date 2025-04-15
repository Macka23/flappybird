package com.example.flappybird.GameObjects.Obstacles

import android.graphics.Color
import android.graphics.RectF
import com.example.flappybird.Constants.Constants

class PipeMoving: Obstacle() {
    private val upperShapeHeight = 200f + (0..600).random()
    private val pipeSpeedY = 5f
    private var inverter = listOf(-1, 1).random().toFloat()

    private val upperShape = RectF(Xpos, -(pipeSpeedY * 25), Xpos + width,  upperShapeHeight)
    private val lowerShape = RectF(Xpos, upperShapeHeight + 500, Xpos + width,  Constants.screenHeight + (pipeSpeedY * 25))

    init {
        allShapesForOnePipe.add(upperShape)
        allShapesForOnePipe.add(lowerShape)
        color = Color.RED
    }

    override fun update() {
        Xpos -= pipeSpeedX
        if (upperShape.bottom - 100 > upperShapeHeight || upperShape.bottom + 100 < upperShapeHeight) {
            inverter = -inverter
        }

        for (shape in allShapesForOnePipe){
            shape.offset(-pipeSpeedX, pipeSpeedY * inverter)
        }
    }
}
