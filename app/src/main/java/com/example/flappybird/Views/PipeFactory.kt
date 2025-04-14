package com.example.flappybird.Views

import com.example.flappybird.GameObjects.Obstacles.Obstacle
import com.example.flappybird.GameObjects.Obstacles.Pipe
import com.example.flappybird.GameObjects.Obstacles.PipeMoving

class PipeFactory {
    companion object {
        fun createPipe(type: PipeType): Obstacle {
            return when (type) {
                PipeType.STATIC -> Pipe()
                PipeType.MOVING -> PipeMoving()
            }
        }
    }
}

enum class PipeType {
    STATIC, // Pour les tuyaux normaux
    MOVING  // Pour les tuyaux en mouvement
}