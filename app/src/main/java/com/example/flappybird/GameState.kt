package com.example.flappybird.GameStates

import com.example.flappybird.Views.PipeType

interface GameState {
    fun getPipeType(): PipeType
}
