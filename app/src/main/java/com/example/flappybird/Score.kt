package com.example.flappybird

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

object Score : GameObject(x = 50f, y = 140f, width = 0f, height = 0f), Observable  {
    var yourScore = 0
    private val textPaint = Paint()
    private val observers = mutableListOf<GameObserver>()

    override fun update(t: Int) {
        yourScore += 1
        println("update")
        notifyObservers()
    }

    override fun draw(canvas: Canvas, paint: Paint) {
        textPaint.color = Color.WHITE
        textPaint.textSize = 50f
        val scoreToString = "Your score is $yourScore"
        canvas.drawText(scoreToString, x, y, textPaint)
    }

    fun clearObservers() {
        observers.clear()
    }

    override fun addObserver(observer: GameObserver) {
        if (!observers.contains(observer)) {
            observers.add(observer)
        }
    }

    override fun removeObserver(observer: GameObserver) {
        observers.remove(observer)
    }

    override fun notifyObservers() {
        for (observer in observers) {
            println("notif")
            observer.onScoreChanged(yourScore)
        }
    }
}