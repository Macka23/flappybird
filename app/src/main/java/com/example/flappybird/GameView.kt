package com.example.flappybird

import android.content.Intent
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.SurfaceHolder
import android.view.SurfaceView

open class GameView @JvmOverloads constructor (context: Context, attributes: AttributeSet? = null, defStyleAttr: Int = 0): SurfaceView(context, attributes,defStyleAttr), SurfaceHolder.Callback, Runnable {
    private lateinit var thread: Thread
    private var drawing = false
    private var canvas = Canvas()
    private val paint = Paint()
    private var totalElapsedTime = 0.0

    private var allObjects : AllObjects = AllObjects(canvas, holder)

    override fun run() {
        var previousFrameTime = System.currentTimeMillis()
        while (drawing) {
            // For Thread
            val currentTime = System.currentTimeMillis()
            val elapsedTimeMS: Double = (currentTime - previousFrameTime).toDouble()
            totalElapsedTime += elapsedTimeMS / 1000.0

            updatePositions(elapsedTimeMS)

            if (returnEndGame()){
                /* Tu mets les bails de GameOver ICI */
                gameOver()
                //pause()
            }

            previousFrameTime = currentTime

            draw()
        }
    }

    fun gameOver(){
        val intent = Intent(context, GameOverActivity::class.java)
        context.startActivity(intent)
    }

    private fun updatePositions(elapsedTimeMS: Double) {
        allObjects.bird.update()


        /* Conditions for pipes */
        if (elapsedTimeMS > 10){
            for (pipe in allObjects.ListOfPipes) {
                pipe.update()
            }
        }

        if (allObjects.ListOfPipes.last().x_pos < allObjects.bird.x){
            createPipe()
            allObjects.score.yourScore += 1
        }


        if (allObjects.ListOfPipes.first().x_pos + allObjects.ListOfPipes.first().pipe_width < 0){
            allObjects.ListOfPipes.removeAt(0)
        }
    }

    private fun returnEndGame(): Boolean {
        for (pipe in allObjects.ListOfPipes){
            if (allObjects.bird.returnCollision(pipe)){
                return true
            }
        }
        return false
    }

    private fun createPipe(){
        allObjects.ListOfPipes.add(Pipe())
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event?.action == MotionEvent.ACTION_DOWN) {
            allObjects.bird.jump()
        }
        return true
    }

    private fun draw() {
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

    fun pause() {
        drawing = false
        thread.join()
    }

    fun resume() {
        drawing = true
        thread = Thread(this)
        thread.start()
    }
    override fun surfaceChanged(holder: SurfaceHolder, format: Int,
                                width: Int, height: Int) {}

    override fun surfaceCreated(holder: SurfaceHolder) {
        resume()
    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {
        pause()
    }


}