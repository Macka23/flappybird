package com.example.flappybird

import com.example.flappybird.Views.PipeType

class HardState : State() {
    override fun getPipeType() = PipeType.BLOC
}