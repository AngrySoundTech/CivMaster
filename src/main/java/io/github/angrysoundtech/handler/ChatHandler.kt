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
package io.github.angrysoundtech.handler

import io.github.angrysoundtech.MOD_ID
import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.client.event.ClientChatReceivedEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod

@Mod.EventBusSubscriber(Dist.CLIENT, modid = MOD_ID)
object ChatHandler {

    @SubscribeEvent
    fun onChatMessage(event: ClientChatReceivedEvent) {
        println(event.message.unformattedComponentText)

        if (true) { // TODO
            // Create snitch
        }
    }

}