package com.example.flappybird

import android.graphics.Canvas
import android.graphics.Paint

abstract class GameObject(
    var x: Float,
    protected var y: Float,
    protected var width: Float,
    protected var height: Float
) {
    abstract fun update()
    abstract fun draw(canvas: Canvas, paint: Paint)
}
