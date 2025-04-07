package com.example.flappybird

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

class GameDisplay(val allObjects : AllObjects) {
    private val paint = Paint()

    fun draw(){
        if (allObjects.holder.surface.isValid) {
            allObjects.canvas = allObjects.holder.lockCanvas()
            allObjects.canvas.drawColor(Color.CYAN)
            allObjects.holder.unlockCanvasAndPost(allObjects.canvas)
        }
    }
}