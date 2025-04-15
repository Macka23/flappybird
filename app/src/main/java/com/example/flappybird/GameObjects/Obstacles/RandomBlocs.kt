package com.example.flappybird.GameObjects.Obstacles

import android.graphics.Color
import android.graphics.RectF
import android.graphics.drawable.shapes.Shape
import com.example.flappybird.Constants.Constants

class RandomBlocs: Obstacle() {
    private val pipe_speed_x = 2f
    private val pipeSpeedY = 5f
    private val lenght = 200f + (0..800).random()
    private val opening = 200f + (0..300).random()

    private val leftShape = RectF(0f, 0f,lenght, width)
    private val rightShape = RectF(lenght + opening, 0f, Constants.screenWidth + 2000, width)

    init {
        allShapesForOnePipe.add(leftShape)
        allShapesForOnePipe.add(rightShape)
        color = Color.BLACK
    }

    override fun update() {
        y_pos += pipeSpeedY

        for (shape in allShapesForOnePipe){
            shape.offset(-pipe_speed_x, pipeSpeedY)
        }
    }
}
