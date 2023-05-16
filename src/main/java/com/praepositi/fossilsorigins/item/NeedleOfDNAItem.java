
package com.praepositi.fossilsorigins.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;

import com.praepositi.fossilsorigins.procedures.ChangingDinoDNAProcedure;
import com.praepositi.fossilsorigins.init.FossilsoriginsModTabs;

public class NeedleOfDNAItem extends Item {
	public NeedleOfDNAItem() {
		super(new Item.Properties().tab(FossilsoriginsModTabs.TAB_FOSSILS_ORIGINS).stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		ChangingDinoDNAProcedure.execute(entity, sourceentity, itemstack);
		return retval;
	}
}
