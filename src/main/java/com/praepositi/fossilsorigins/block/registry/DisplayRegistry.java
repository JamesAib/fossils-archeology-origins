package com.praepositi.fossilsorigins.block.registry;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Item;

import com.praepositi.fossilsorigins.init.FossilsoriginsModBlocks;
import com.praepositi.fossilsorigins.block.display.DNAModifierDisplayItem;
import com.praepositi.fossilsorigins.block.display.DNAInjectorBlockDisplayItem;
import com.praepositi.fossilsorigins.FossilsoriginsMod;

public class DisplayRegistry {
	public static final DeferredRegister<Item> DISPLAY = DeferredRegister.create(ForgeRegistries.ITEMS, FossilsoriginsMod.MODID);
	public static final RegistryObject<Item> DNA_INJECTOR_BLOCK_ITEM = DISPLAY.register("dna_injector_block_item", () -> new DNAInjectorBlockDisplayItem(FossilsoriginsModBlocks.DNA_INJECTOR_BLOCK.get(), new Item.Properties().tab(null)));
	public static final RegistryObject<Item> DNA_MODIFIER_ITEM = DISPLAY.register("dna_modifier_item", () -> new DNAModifierDisplayItem(FossilsoriginsModBlocks.DNA_MODIFIER.get(), new Item.Properties().tab(null)));
}
