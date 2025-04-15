package com.example.flappybird.GameObjects.Obstacles

import android.graphics.Color
import android.graphics.RectF
import com.example.flappybird.Constants.Constants

class Pipe : Obstacle() {
    private val upperShapeHeight = 200f + (0..600).random()

    private val upperShape = RectF(Xpos, 0f, Xpos + width,  upperShapeHeight)
    private val lowerShape = RectF(Xpos, upperShapeHeight + 500, Xpos + width,  Constants.screenHeight)

    init {
        allShapesForOnePipe.add(upperShape)
        allShapesForOnePipe.add(lowerShape)
        color = Color.GREEN
    }

    override fun update() {
        Xpos -= pipeSpeedX
        for (shape in allShapesForOnePipe){
            shape.offset(-pipeSpeedX, 0f)
        }
    }
}

