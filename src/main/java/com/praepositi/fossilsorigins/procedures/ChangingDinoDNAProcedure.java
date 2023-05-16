package com.praepositi.fossilsorigins.procedures;

import net.minecraft.world.scores.criteria.ObjectiveCriteria;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import com.praepositi.fossilsorigins.init.FossilsoriginsModItems;

public class ChangingDinoDNAProcedure {
	public static void execute(Entity entity, Entity sourceentity, ItemStack itemstack) {
		if (entity == null || sourceentity == null)
			return;
		if (sourceentity instanceof Player _player) {
			ItemStack _stktoremove = new ItemStack(FossilsoriginsModItems.NEEDLE_OF_DNA.get());
			_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
		}
		{
			Entity _ent = entity;
			Scoreboard _sc = _ent.getLevel().getScoreboard();
			Objective _so = _sc.getObjective("Gender");
			if (_so == null)
				_so = _sc.addObjective("Gender", ObjectiveCriteria.DUMMY, Component.literal("Gender"), ObjectiveCriteria.RenderType.INTEGER);
			_sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).setScore((int) itemstack.getOrCreateTag().getDouble("Gender"));
		}
		{
			Entity _ent = entity;
			Scoreboard _sc = _ent.getLevel().getScoreboard();
			Objective _so = _sc.getObjective("BabySize");
			if (_so == null)
				_so = _sc.addObjective("BabySize", ObjectiveCriteria.DUMMY, Component.literal("BabySize"), ObjectiveCriteria.RenderType.INTEGER);
			_sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).setScore((int) itemstack.getOrCreateTag().getDouble("Size"));
		}
	}
}
