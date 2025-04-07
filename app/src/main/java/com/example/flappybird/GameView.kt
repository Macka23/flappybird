package com.example.flappybird

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.SurfaceHolder
import android.view.SurfaceView

class GameView @JvmOverloads constructor (context: Context, attributes: AttributeSet? = null, defStyleAttr: Int = 0): SurfaceView(context, attributes,defStyleAttr), SurfaceHolder.Callback, Runnable {
    private lateinit var thread: Thread
    private var drawing = false
    var canvas = Canvas()
    val paint = Paint()
    var screenWidth = 0f
    var screenHeight = 0f
    var totalElapsedTime = 0.0


    var allObjects : AllObjects


    init {
        allObjects = AllObjects(canvas, holder)

    }

    override fun onSizeChanged(w:Int, h:Int, oldw:Int, oldh:Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        screenWidth = w.toFloat()
        screenHeight = h.toFloat()
    }

    override fun run() {
        var previousFrameTime = System.currentTimeMillis()
        while (drawing) {
            val currentTime = System.currentTimeMillis()
            var elapsedTimeMS: Double = (currentTime - previousFrameTime).toDouble()
            totalElapsedTime += elapsedTimeMS / 1000.0
            updatePositions(elapsedTimeMS)
            draw()
            previousFrameTime = currentTime
        }
    }

    private fun draw() {
        if (allObjects.holder.surface.isValid) {
            allObjects.canvas = allObjects.holder.lockCanvas()
            /* All drawings here */

            allObjects.canvas.drawColor(Color.CYAN)
            allObjects.bird.draw(allObjects.canvas, paint)
            allObjects.pipe.draw(allObjects.canvas, paint)

            /* End drawings */
            allObjects.holder.unlockCanvasAndPost(allObjects.canvas)
        }
    }

    fun updatePositions(elapsedTimeMS: Double) {
        val interval = elapsedTimeMS / 1000.0
        allObjects.bird.update()
        allObjects.pipe.update()
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event?.action == MotionEvent.ACTION_DOWN) {
            allObjects.bird.flap()
        }
        return true
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
        resume()  // Lance le thread quand la surface est prête
    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {
        pause()  // Arrête le thread lorsque la surface est détruite
    }


}