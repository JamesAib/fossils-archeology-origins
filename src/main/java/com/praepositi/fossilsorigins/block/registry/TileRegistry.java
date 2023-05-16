package com.praepositi.fossilsorigins.block.registry;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;

import com.praepositi.fossilsorigins.init.FossilsoriginsModBlocks;
import com.praepositi.fossilsorigins.block.entity.DNAModifierTileEntity;
import com.praepositi.fossilsorigins.block.entity.DNAInjectorBlockTileEntity;
import com.praepositi.fossilsorigins.FossilsoriginsMod;

public class TileRegistry {
	public static final DeferredRegister<BlockEntityType<?>> TILES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, FossilsoriginsMod.MODID);
	public static final RegistryObject<BlockEntityType<DNAInjectorBlockTileEntity>> DNA_INJECTOR_BLOCK = TILES.register("dna_injector_block_block",
			() -> BlockEntityType.Builder.of(DNAInjectorBlockTileEntity::new, FossilsoriginsModBlocks.DNA_INJECTOR_BLOCK.get()).build(null));
	public static final RegistryObject<BlockEntityType<DNAModifierTileEntity>> DNA_MODIFIER = TILES.register("dna_modifier_block", () -> BlockEntityType.Builder.of(DNAModifierTileEntity::new, FossilsoriginsModBlocks.DNA_MODIFIER.get()).build(null));
}
