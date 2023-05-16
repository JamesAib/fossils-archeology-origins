
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.praepositi.fossilsorigins.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import com.praepositi.fossilsorigins.block.entity.FossilAnalyzerBlockEntity;
import com.praepositi.fossilsorigins.block.entity.DNAModifierBlockEntity;
import com.praepositi.fossilsorigins.block.entity.DNAInjectorBlockBlockEntity;
import com.praepositi.fossilsorigins.FossilsoriginsMod;

public class FossilsoriginsModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, FossilsoriginsMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> FOSSIL_ANALYZER = register("fossil_analyzer", FossilsoriginsModBlocks.FOSSIL_ANALYZER, FossilAnalyzerBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> DNA_INJECTOR_BLOCK = register("dna_injector_block", FossilsoriginsModBlocks.DNA_INJECTOR_BLOCK, DNAInjectorBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> DNA_MODIFIER = register("dna_modifier", FossilsoriginsModBlocks.DNA_MODIFIER, DNAModifierBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
