package com.example.flappybird.GameObjects.Obstacles

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import com.example.flappybird.Constants.Constants
import com.example.flappybird.Interfaces.Updatable

abstract class Pipe: Obstacle(), Updatable {
    var Xpos = Constants.screenWidth
    var Ypos = 0f
    protected lateinit var lowerShape: RectF
    protected lateinit var upperShape: RectF
    protected val pipeSpeedY = 5f
    protected var pipeSpeedX = 5f
    open val width : Float = 100f
}