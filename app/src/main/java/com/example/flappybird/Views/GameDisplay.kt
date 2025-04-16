package com.example.flappybird.Views

import android.graphics.Color
import android.graphics.Paint
import com.example.flappybird.GameObjects.AllObjects

class GameDisplay(val allObjects : AllObjects) {
    private val paint = Paint()

    fun draw(){
        if (allObjects.holder.surface.isValid) {
            allObjects.canvas = allObjects.holder.lockCanvas()
            /* All drawings here */

            allObjects.canvas.drawColor(Color.CYAN)
            allObjects.bird.draw(allObjects.canvas, paint)
            for (pipe in allObjects.ListOfPipes) {
                pipe.draw(allObjects.canvas, paint)
            }
            allObjects.score.draw(allObjects.canvas, paint)

            /* End drawings */
            allObjects.holder.unlockCanvasAndPost(allObjects.canvas)
        }
    }
}