package com.example.flappybird

import com.example.flappybird.GameStates.GameState
import com.example.flappybird.Views.PipeType

class EasyState : State() {
    override fun getPipeType() = PipeType.STATIC
}