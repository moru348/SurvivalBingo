package me.moru3.survivalbingo

import java.awt.image.BufferedImage

class Card(sb: SurvivalBingo, val card: BufferedImage) {

    val p = mutableMapOf<Int, Square>()

    fun getCardDesign(): BufferedImage {
        return card
    }

    init {
        val item = sb.items.keys.toMutableList()
        println(item)
        for(i in 0 until 24) {
            val key = item.random()
            p[i] = Square(sb, key)
            item.remove(key)
        }
    }
}