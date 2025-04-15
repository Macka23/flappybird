package com.example.flappybird.GameStates

import com.example.flappybird.Views.PipeType

interface GameState {
    fun getPipeType(): PipeType
}

class EasyState : GameState {
    override fun getPipeType() = PipeType.STATIC
}

class MediumState : GameState {
    override fun getPipeType() = PipeType.MOVING
}

class HardState : GameState {
    override fun getPipeType() = PipeType.BLOC
}
