package com.example.flappybird

import com.example.flappybird.Views.PipeType

class GameStateManager {
    private var currentState: State = EasyState()

    fun updateState(score: Int) {
        currentState = when {
            score >= 9 -> HardState()
            score >= 3 && score < 9 -> MediumState()
            else -> EasyState()
        }
    }

    fun getPipeType(): PipeType {
        return currentState.getPipeType()
    }
}
