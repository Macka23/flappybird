package com.example.flappybird

import android.content.Context
import android.graphics.Canvas
import android.view.SurfaceHolder

class AllObjects(var canvas: Canvas, val holder: SurfaceHolder) {
    val bird : Bird = Bird(300f, 600f)
    val pipe: Pipe = Pipe(800f, 0f, 150f, 500f)
}