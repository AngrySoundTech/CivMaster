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
package io.github.angrysoundtech.gui.screen

import io.github.angrysoundtech.trackable.model.Trackable
import net.minecraft.client.gui.screen.Screen
import net.minecraft.client.gui.widget.button.Button
import net.minecraft.util.text.StringTextComponent
import net.minecraftforge.fml.client.config.GuiButtonExt

class TrackableScreen<out T : Trackable> : Screen(StringTextComponent("Trackable")) {

    override fun init() {
        this.buttons.clear()

        val xPos = width / 2 - BUTTON_WIDTH / 2
        var yPos = height / 4 + 8 - (BUTTON_HEIGHT + SEPARATION)

        addButton(GuiButtonExt(
            xPos, yPos, BUTTON_WIDTH, BUTTON_HEIGHT,
            "Refresh All", Button.IPressable {

            }
        ))
    }

}
