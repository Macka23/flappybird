package com.example.flappybird.GameObjects.Obstacles

import android.graphics.Color
import android.graphics.RectF
import com.example.flappybird.Constants.Constants

class StaticPipe : Pipe() {
    private val upperShapeHeight = 200f + (0..600).random()

    init {
        upperShape = RectF(Xpos, 0f, Xpos + width,  upperShapeHeight)
        lowerShape = RectF(Xpos, upperShapeHeight + 500, Xpos + width,  Constants.screenHeight)
        allShapesForOneObstacle.add(upperShape)
        allShapesForOneObstacle.add(lowerShape)
        color = Color.GREEN
    }

    override fun update() {
        Xpos -= pipeSpeedX
        for (shape in allShapesForOneObstacle){
            shape.offset(-pipeSpeedX, 0f)
        }
    }
}

