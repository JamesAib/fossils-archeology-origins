package com.praepositi.fossilsorigins.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import com.praepositi.fossilsorigins.init.FossilsoriginsModItems;
import com.praepositi.fossilsorigins.init.FossilsoriginsModBlocks;

public class PlacingDNAmodifierProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player) {
			ItemStack _stktoremove = new ItemStack(FossilsoriginsModItems.DN_AMODIFIER_I_TEM.get());
			_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
		}
		world.setBlock(new BlockPos(x, y + 1, z), FossilsoriginsModBlocks.DNA_MODIFIER.get().defaultBlockState(), 3);
	}
}
