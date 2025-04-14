package com.example.flappybird

interface Observable {
    fun addObserver(observer: GameObserver)
    fun removeObserver(observer: GameObserver)
    fun notifyObservers()
}