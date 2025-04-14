package com.example.flappybird.GameObjects

import android.graphics.RectF
import com.example.flappybird.Constants.Constants
import com.example.flappybird.Interfaces.Drawable
import com.example.flappybird.GameObjects.Obstacles.Obstacle

abstract class GameObject(var x: Float, var y: Float, protected var width: Float, protected var height: Float) :
    Drawable {
    lateinit var bodyObject : RectF

    abstract fun update(time: Int)

    fun returnCollision(obstacle: Obstacle): Boolean{
        for (shape in obstacle.allShapesForOnePipe){
            if (bodyObject.intersect(shape)) {
                return true
            }
        }
        if (y < 0 || y > Constants.screenHeight){
            return true
        }
        return false
    }
}
