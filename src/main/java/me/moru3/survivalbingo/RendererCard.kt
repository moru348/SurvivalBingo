package me.moru3.survivalbingo

import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.map.MapCanvas
import org.bukkit.map.MapRenderer
import org.bukkit.map.MapView
import java.awt.Color
import java.awt.image.BufferedImage
import java.lang.IllegalArgumentException

class RendererCard(private val card: Card): MapRenderer(false) {
    override fun render(map: MapView, canvas: MapCanvas, player: Player) {
        try {
            if(card.p.size>24) return
            map.scale = MapView.Scale.CLOSEST
            canvas.drawImage(0, 0, card.getCardDesign())
            var left = 18
            var top = 28
            var plus = 0
            for(i in 0 until card.p.size) {
                if(i==12) {
                    plus = 1
                    left += 19
                }
                canvas.drawImage(left, top, card.p[i]!!.getImage())
                left+=19
                if((i+1+plus)%5==0) {
                    if(i==0) continue
                    top+=19
                    left=18
                }
            }
        } catch (e: IllegalArgumentException) {
            player.inventory.setItem(8, ItemStack(Material.AIR))
        }
    }
}