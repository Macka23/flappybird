package com.example.flappybird

import com.example.flappybird.Views.PipeType

class MediumState : State() {
    override fun getPipeType() = PipeType.MOVING
}