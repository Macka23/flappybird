package com.example.flappybird

import com.example.flappybird.GameStates.GameState
import com.example.flappybird.GameStates.EasyState
import com.example.flappybird.GameStates.MediumState
import com.example.flappybird.GameStates.HardState
import com.example.flappybird.Views.PipeType

class GameStateManager {
    private var currentState: GameState = EasyState()

    fun updateState(score: Int) {
        currentState = when {
            score >= 9 -> HardState()
            score >= 3 -> MediumState()
            else -> EasyState()
        }
    }

    fun getPipeType(): PipeType {
        return currentState.getPipeType()
    }
}
