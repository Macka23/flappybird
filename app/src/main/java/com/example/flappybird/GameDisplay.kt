package com.example.flappybird

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

class GameDisplay(val allObjects : AllObjects) {
    private val paint = Paint()

    fun draw(){
        if (allObjects.holder.surface.isValid) {
            allObjects.canvas = allObjects.holder.lockCanvas()
            /* All drawings here */

            allObjects.canvas.drawColor(Color.CYAN)
            allObjects.bird.draw(allObjects.canvas, paint)
            for (pipe in allObjects.ListOfPipes) {
                pipe.draw(allObjects.canvas)
            }
            allObjects.score.draw(allObjects.canvas, paint)

            /* End drawings */
            allObjects.holder.unlockCanvasAndPost(allObjects.canvas)
        }
    }
}