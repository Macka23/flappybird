package com.example.flappybird

import com.example.flappybird.GameStates.GameState
import com.example.flappybird.Views.PipeType

class HardState : GameState {
    override fun getPipeType() = PipeType.BLOC
}