/**
 * Copyright (C) 2020 AngrySoundTech
 * This file is part of CivMaster.
 *
 * CivMaster is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * CivMaster is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CivMaster.  If not, see <https://www.gnu.org/licenses/>.
 */
package io.github.angrysoundtech.gui.button

import net.minecraft.client.Minecraft
import net.minecraft.client.gui.widget.Widget
import net.minecraft.client.gui.widget.button.Button
import net.minecraft.client.renderer.RenderHelper
import net.minecraft.item.ItemStack
import net.minecraftforge.fml.client.config.GuiUtils

class ButtonIcon(
    widthIn: Int,
    heightIn: Int,
    width: Int,
    height: Int,
    text: String,
    onPress: Button.IPressable,
    private val leftIcon: ItemStack,
    private val rightIcon: ItemStack = leftIcon
): Button(widthIn, heightIn, width, height, text, onPress) {

    override fun render(mouseX: Int, mouseY: Int, partialTicks: Float) {
        if (visible) {

            val mc = Minecraft.getInstance()

            isHovered = mouseX >= x && mouseY >= y && mouseX < x + width && mouseY < y + height

            val k = getYImage(isHovered)

            GuiUtils.drawContinuousTexturedBox(
                Widget.WIDGETS_LOCATION, x, y, 0, 46 + k * 20, width, height, 200, 20, 2, 3, 2, 2, blitOffset.toFloat()
            )

            renderBg(mc, mouseX, mouseY)

            val color = if (packedFGColor != 0) {
                packedFGColor
            } else if (!active) {
                10526880
            } else if (isHovered) {
                16777120
            } else {
                14737632
            }

            var buttonText = message
            val strWidth = mc.fontRenderer.getStringWidth(buttonText)
            val ellipsisWidth = mc.fontRenderer.getStringWidth("...")

            if (strWidth > width - 6 && strWidth > ellipsisWidth) {
                buttonText = mc.fontRenderer.trimStringToWidth(
                    buttonText, width - 6 - ellipsisWidth
                ).trim { it <= ' ' } + "..."
            }

            RenderHelper.disableStandardItemLighting()
            RenderHelper.enableGUIStandardItemLighting()

            Minecraft.getInstance().itemRenderer.renderItemIntoGUI(leftIcon, x + 8, y + height / 2 - 8)
            Minecraft.getInstance().itemRenderer.renderItemIntoGUI(rightIcon, x + width - 24 , y + height / 2 - 8)
            drawCenteredString(mc.fontRenderer, buttonText, x + width / 2, y + (height - 8) / 2, color)
        }
    }
}
