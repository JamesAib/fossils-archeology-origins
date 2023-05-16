
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.praepositi.fossilsorigins.init;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class FossilsoriginsModTabs {
	public static CreativeModeTab TAB_FOSSILS_ORIGINS;

	public static void load() {
		TAB_FOSSILS_ORIGINS = new CreativeModeTab("tabfossils_origins") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(FossilsoriginsModItems.TYRANNOSAURUS_FOSSIL.get());
			}

			@Override
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
}
