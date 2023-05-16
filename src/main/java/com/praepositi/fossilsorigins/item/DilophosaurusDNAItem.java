
package com.praepositi.fossilsorigins.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

import com.praepositi.fossilsorigins.init.FossilsoriginsModTabs;

public class DilophosaurusDNAItem extends Item {
	public DilophosaurusDNAItem() {
		super(new Item.Properties().tab(FossilsoriginsModTabs.TAB_FOSSILS_ORIGINS).stacksTo(64).rarity(Rarity.COMMON));
	}
}
