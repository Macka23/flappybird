package com.example.flappybird

import android.graphics.Canvas
import android.graphics.Paint

interface Drawable {
    fun draw(canvas: Canvas, paint: Paint)
}