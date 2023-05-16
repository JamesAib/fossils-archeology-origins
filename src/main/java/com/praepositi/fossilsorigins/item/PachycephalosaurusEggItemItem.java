
package com.praepositi.fossilsorigins.item;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.InteractionResult;

import com.praepositi.fossilsorigins.procedures.PachycephalosaurusEggPlacementProcedure;
import com.praepositi.fossilsorigins.init.FossilsoriginsModTabs;

public class PachycephalosaurusEggItemItem extends Item {
	public PachycephalosaurusEggItemItem() {
		super(new Item.Properties().tab(FossilsoriginsModTabs.TAB_FOSSILS_ORIGINS).stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		PachycephalosaurusEggPlacementProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getPlayer());
		return InteractionResult.SUCCESS;
	}
}
