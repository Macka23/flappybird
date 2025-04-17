package com.example.flappybird.Interfaces

interface Observable {
    fun addObserver(observer: GameObserver)
    fun removeObserver(observer: GameObserver)
    fun notifyGameOver()
}