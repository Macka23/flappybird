package com.example.flappybird.GameObjects.Obstacles

import android.graphics.Color
import android.graphics.RectF
import com.example.flappybird.Constants.Constants
import com.example.flappybird.Interfaces.Updatable

class PipeMoving: Pipe() {
    private val upperShapeHeight = 200f + (0..600).random()
    private var inverter = listOf(-1, 1).random().toFloat()

    init {
        upperShape = RectF(Xpos, -(pipeSpeedY * 25), Xpos + width,  upperShapeHeight)
        lowerShape = RectF(Xpos, upperShapeHeight + 500, Xpos + width,  Constants.screenHeight + (pipeSpeedY * 25))
        allShapesForOneObstacle.add(upperShape)
        allShapesForOneObstacle.add(lowerShape)
        color = Color.RED
    }

    override fun update(t: Int?) {
        Xpos -= pipeSpeedX
        if (upperShape.bottom - 100 > upperShapeHeight || upperShape.bottom + 100 < upperShapeHeight) {
            inverter = -inverter
        }

        for (shape in allShapesForOneObstacle){
            shape.offset(-pipeSpeedX, pipeSpeedY * inverter)
        }
    }
}
