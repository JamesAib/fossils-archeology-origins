package com.praepositi.fossilsorigins.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import com.praepositi.fossilsorigins.FossilsoriginsMod;

public class EatingHerbavoresProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		FossilsoriginsMod.queueServerWork(6000, () -> {
			EatingGrassProcedure.execute(world, x, y, z, entity);
		});
	}
}
