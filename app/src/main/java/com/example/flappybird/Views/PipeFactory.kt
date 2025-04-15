package com.example.flappybird.Views

import com.example.flappybird.GameObjects.Obstacles.Obstacle
import com.example.flappybird.GameObjects.Obstacles.Pipe
import com.example.flappybird.GameObjects.Obstacles.PipeMoving
import com.example.flappybird.GameObjects.Obstacles.RandomBlocs

class PipeFactory {
    companion object {
        fun createPipe(type: PipeType): Obstacle {
            return when (type) {
                PipeType.STATIC -> Pipe()
                PipeType.MOVING -> PipeMoving()
                PipeType.BLOC -> RandomBlocs()
            }
        }
    }
}

enum class PipeType {
    STATIC,
    MOVING,
    BLOC
}