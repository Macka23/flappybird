package com.example.flappybird

import android.content.Context
import android.graphics.Canvas
import android.view.SurfaceHolder

class AllObjects(var canvas: Canvas, val holder: SurfaceHolder) {
    val bird = Bird(300f, 600f)
    var ListOfPipes = mutableListOf<Pipe>().apply {
        add(Pipe())
    }
    val score = Score(50f, 140f)
}