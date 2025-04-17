package com.example.flappybird.GameObjects.Obstacles

import android.graphics.Color
import android.graphics.RectF
import com.example.flappybird.Constants.Constants

class StaticPipe : Pipe() {
    private val upperShapeHeight = 200f + (0..600).random()

    init {
        upperShape = RectF(Xpos, 0f, Xpos + width,  upperShapeHeight)
        lowerShape = RectF(Xpos, upperShapeHeight + 500, Xpos + width,  Constants.screenHeight)
        firstLip = RectF(Xpos - width / 3, upperShapeHeight - width / 3, Xpos + width + width/3, upperShapeHeight)
        lastLip = RectF(Xpos - width/3, upperShapeHeight + 500, Xpos + width + width/3, upperShapeHeight +500 + width/3)
        allShapesForOneObstacle.add(firstLip)
        allShapesForOneObstacle.add(lastLip)
        allShapesForOneObstacle.add(upperShape)
        allShapesForOneObstacle.add(lowerShape)
        color = Color.GREEN
    }

    override fun update(t: Int?) {
        Xpos -= pipeSpeedX
        for (shape in allShapesForOneObstacle){
            shape.offset(-pipeSpeedX, 0f)
        }
    }
}

