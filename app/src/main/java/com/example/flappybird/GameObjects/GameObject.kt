package com.example.flappybird.GameObjects

import android.graphics.RectF
import com.example.flappybird.Constants.Constants
import com.example.flappybird.Interfaces.Drawable
import com.example.flappybird.GameObjects.Obstacles.Pipe

abstract class GameObject(var x: Float, var y: Float, protected var width: Float, protected var height: Float): Drawable {
    lateinit var bodyObject : RectF

    abstract fun update(time: Int)

    fun returnCollision(pipe: Pipe): Boolean{
        for (shape in pipe.allShapesForOneObstacle){
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
