package com.example.flappybird.Views

import android.graphics.Color

object SkinManager {
    private val skinColors = listOf(
        Color.RED,
        Color.GREEN,
        Color.BLUE,
        Color.YELLOW,
        Color.CYAN,
        Color.MAGENTA
    )

    private var selectedIndex = 0

    fun setSkin(index: Int) {
        if (index in skinColors.indices) {
            selectedIndex = index
        }
    }

    fun getCurrentColor(): Int {
        return skinColors[selectedIndex]
    }

    fun getAvailableColors(): List<Int> {
        return skinColors
    }

    fun getCurrentIndex(): Int {
        return selectedIndex
    }
}
