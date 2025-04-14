package com.example.flappybird

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF

abstract class GameObject(var x: Float, protected var y: Float, protected var width: Float, protected var height: Float) : Drawable {
    lateinit var bodyObject : RectF

    abstract fun update()

    fun returnCollision(obstacle: Obstacle): Boolean{
        for (shape in obstacle.allShapesForOnePipe){
            if (bodyObject.intersect(shape)) {
                return true
            }
        }
//        if (y < 0 || y > Constants.screenHeight){
//            return true
//        }
        return false
    }
}
