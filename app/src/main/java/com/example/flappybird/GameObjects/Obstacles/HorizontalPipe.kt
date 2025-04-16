package com.example.flappybird.GameObjects.Obstacles

import android.graphics.Color
import android.graphics.RectF
import com.example.flappybird.Constants.Constants

class HorizontalPipe: Pipe() {
    private val lenght = 200f + (0..800).random()
    private val opening = 200f + (0..300).random()

    init {
        upperShape = RectF(0f, 0f,lenght, width)
        lowerShape = RectF(lenght + opening, 0f, Constants.screenWidth + 2000, width)
        allShapesForOneObstacle.add(upperShape)
        allShapesForOneObstacle.add(lowerShape)
        color = Color.BLACK
    }

    override fun update(t: Int?) {
        Ypos += pipeSpeedY

        for (shape in allShapesForOneObstacle){
            shape.offset(-pipeSpeedX/2, pipeSpeedY)
        }
    }
}
