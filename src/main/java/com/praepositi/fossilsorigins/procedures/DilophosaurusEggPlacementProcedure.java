package com.praepositi.fossilsorigins.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;

import com.praepositi.fossilsorigins.init.FossilsoriginsModItems;
import com.praepositi.fossilsorigins.init.FossilsoriginsModEntities;
import com.praepositi.fossilsorigins.entity.DilophosaurusEggEntityEntity;

public class DilophosaurusEggPlacementProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player) {
			ItemStack _stktoremove = new ItemStack(FossilsoriginsModItems.DILOPHOSAURUS_EGG_ITEM.get());
			_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
		}
		if (world instanceof ServerLevel _level) {
			Entity entityToSpawn = new DilophosaurusEggEntityEntity(FossilsoriginsModEntities.DILOPHOSAURUS_EGG_ENTITY.get(), _level);
			entityToSpawn.moveTo(x, (1 + y), z, world.getRandom().nextFloat() * 360F, 0);
			if (entityToSpawn instanceof Mob _mobToSpawn)
				_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
			world.addFreshEntity(entityToSpawn);
		}
	}
}
