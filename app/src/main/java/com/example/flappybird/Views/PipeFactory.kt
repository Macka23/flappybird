package com.example.flappybird.Views

import com.example.flappybird.GameObjects.Obstacles.Pipe
import com.example.flappybird.GameObjects.Obstacles.StaticPipe
import com.example.flappybird.GameObjects.Obstacles.PipeMoving
import com.example.flappybird.GameObjects.Obstacles.HorizontalPipe

class PipeFactory {
    companion object {
        fun createPipe(type: PipeType): Pipe {
            return when (type) {
                PipeType.STATIC -> StaticPipe()
                PipeType.MOVING -> PipeMoving()
                PipeType.BLOC -> HorizontalPipe()
            }
        }
    }
}
