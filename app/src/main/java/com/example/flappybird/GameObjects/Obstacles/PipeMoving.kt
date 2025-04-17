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
        firstLip = RectF(Xpos - width / 3, upperShapeHeight - width / 3, Xpos + width + width/3, upperShapeHeight)
        lastLip = RectF(Xpos - width/3, upperShapeHeight + 500, Xpos + width + width/3, upperShapeHeight +500 + width/3)
        allShapesForOneObstacle.add(firstLip)
        allShapesForOneObstacle.add(lastLip)
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
