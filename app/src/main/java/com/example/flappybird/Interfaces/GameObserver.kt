package com.example.flappybird.Interfaces

interface GameObserver {
    fun onScoreChanged(score: Int)
    fun onGameOver()
}
