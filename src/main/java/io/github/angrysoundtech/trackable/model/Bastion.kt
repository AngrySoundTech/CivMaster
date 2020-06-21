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
package io.github.angrysoundtech.trackable.model

import net.minecraft.block.Block
import net.minecraft.block.Blocks

sealed class Bastion : Trackable

class VaultBastion : Bastion() {

    override val radius = 20
    override val block: Block = Blocks.SPONGE
}

class CityBastion : Bastion() {

    override val radius = 50
    override val block: Block = Blocks.BONE_BLOCK
}
