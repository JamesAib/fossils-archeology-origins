
/*
*	MCreator note: This file will be REGENERATED on each build.
*/
package com.praepositi.fossilsorigins.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.common.BasicItemListing;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class FossilsoriginsModTrades {
	@SubscribeEvent
	public static void registerWanderingTrades(WandererTradesEvent event) {
		event.getGenericTrades().add(new BasicItemListing(new ItemStack(Items.EMERALD, 5),

				new ItemStack(FossilsoriginsModBlocks.ANCIENT_STONE.get(), 3), 20, 5, 0.015f));
		event.getGenericTrades().add(new BasicItemListing(new ItemStack(Items.EMERALD, 5),

				new ItemStack(FossilsoriginsModBlocks.GREAT_BASIN_BRISTLECONE_PINE_LOG.get(), 3), 20, 5, 0.015f));
	}
}
