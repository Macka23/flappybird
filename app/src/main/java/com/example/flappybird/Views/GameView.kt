package com.example.flappybird.Views

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.SurfaceHolder
import android.view.SurfaceView
import com.example.flappybird.GameObjects.AllObjects

open class GameView @JvmOverloads constructor (context: Context, attributes: AttributeSet? = null, defStyleAttr: Int = 0): SurfaceView(context, attributes,defStyleAttr), SurfaceHolder.Callback, Runnable {
    private lateinit var thread: Thread
    private var drawing = false
    private var canvas = Canvas()

    private var allObjects  = AllObjects(context, canvas, holder)
    private var gameRun = GameRun(allObjects)
    private var gameDisplay = GameDisplay(allObjects)


    override fun run() {
        gameRun.setTime()
        while (drawing) {
            gameRun.run()
            gameDisplay.draw()
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event?.action == MotionEvent.ACTION_DOWN) {
            allObjects.bird.oldY = allObjects.bird.y
            allObjects.bird.ascendingState = true
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
        resume()
    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {
        pause()
    }


}