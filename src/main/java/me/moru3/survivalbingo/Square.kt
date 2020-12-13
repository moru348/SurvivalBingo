package me.moru3.survivalbingo

import org.bukkit.Material
import java.awt.Color
import java.awt.image.BufferedImage

class Square(val sb: SurvivalBingo, val item: Material) {
    val canv = BufferedImage(16, 16, BufferedImage.TYPE_INT_RGB)
    val g2 = canv.createGraphics()
    var status = Status.ITEM

    fun getImage(): BufferedImage {
        if(status==Status.OPEN) {
            g2.color = Color.getHSBColor(180F, 27F, 100F)
            g2.fillRect(0, 0, 128, 128)
            g2.drawImage(sb.items[item], 0, 0, null)
            g2.drawImage(sb.check, 0, 0, null)
            g2.dispose()
        } else {
            g2.color = Color.WHITE
            g2.fillRect(0, 0, 128, 128)
            g2.drawImage(sb.items[item], 0, 0, null)
            g2.dispose()
        }
        return canv
    }
}