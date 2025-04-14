package com.example.flappybird.Interfaces

interface GameObserver {
    fun onScoreChanged(score: Int)
    fun onGameOver()
    // Tu peux ajouter d'autres callbacks selon tes besoins
}
