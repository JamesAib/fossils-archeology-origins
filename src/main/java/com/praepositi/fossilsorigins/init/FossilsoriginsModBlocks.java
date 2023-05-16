
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.praepositi.fossilsorigins.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;

import com.praepositi.fossilsorigins.block.GreatBasinBristleconePineWoodBlock;
import com.praepositi.fossilsorigins.block.GreatBasinBristleconePineStairsBlock;
import com.praepositi.fossilsorigins.block.GreatBasinBristleconePinePressurePlateBlock;
import com.praepositi.fossilsorigins.block.GreatBasinBristleconePinePlanksBlock;
import com.praepositi.fossilsorigins.block.GreatBasinBristleconePineLogBlock;
import com.praepositi.fossilsorigins.block.GreatBasinBristleconePineFenceGateBlock;
import com.praepositi.fossilsorigins.block.GreatBasinBristleconePineFenceBlock;
import com.praepositi.fossilsorigins.block.GreatBasinBristleconePineButtonBlock;
import com.praepositi.fossilsorigins.block.FossilsBlock;
import com.praepositi.fossilsorigins.block.FossilAnalyzerBlock;
import com.praepositi.fossilsorigins.block.DNAModifierBlock;
import com.praepositi.fossilsorigins.block.DNAInjectorBlockBlock;
import com.praepositi.fossilsorigins.block.AncientStoneBlock;
import com.praepositi.fossilsorigins.block.AncientLeavesBlock;
import com.praepositi.fossilsorigins.block.AncientCobblestoneBlock;
import com.praepositi.fossilsorigins.block.AncientBricksBlock;
import com.praepositi.fossilsorigins.FossilsoriginsMod;

public class FossilsoriginsModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, FossilsoriginsMod.MODID);
	public static final RegistryObject<Block> FOSSILS = REGISTRY.register("fossils", () -> new FossilsBlock());
	public static final RegistryObject<Block> FOSSIL_ANALYZER = REGISTRY.register("fossil_analyzer", () -> new FossilAnalyzerBlock());
	public static final RegistryObject<Block> GREAT_BASIN_BRISTLECONE_PINE_WOOD = REGISTRY.register("great_basin_bristlecone_pine_wood", () -> new GreatBasinBristleconePineWoodBlock());
	public static final RegistryObject<Block> GREAT_BASIN_BRISTLECONE_PINE_LOG = REGISTRY.register("great_basin_bristlecone_pine_log", () -> new GreatBasinBristleconePineLogBlock());
	public static final RegistryObject<Block> GREAT_BASIN_BRISTLECONE_PINE_PLANKS = REGISTRY.register("great_basin_bristlecone_pine_planks", () -> new GreatBasinBristleconePinePlanksBlock());
	public static final RegistryObject<Block> GREAT_BASIN_BRISTLECONE_PINE_STAIRS = REGISTRY.register("great_basin_bristlecone_pine_stairs", () -> new GreatBasinBristleconePineStairsBlock());
	public static final RegistryObject<Block> GREAT_BASIN_BRISTLECONE_PINE_FENCE = REGISTRY.register("great_basin_bristlecone_pine_fence", () -> new GreatBasinBristleconePineFenceBlock());
	public static final RegistryObject<Block> GREAT_BASIN_BRISTLECONE_PINE_FENCE_GATE = REGISTRY.register("great_basin_bristlecone_pine_fence_gate", () -> new GreatBasinBristleconePineFenceGateBlock());
	public static final RegistryObject<Block> GREAT_BASIN_BRISTLECONE_PINE_PRESSURE_PLATE = REGISTRY.register("great_basin_bristlecone_pine_pressure_plate", () -> new GreatBasinBristleconePinePressurePlateBlock());
	public static final RegistryObject<Block> GREAT_BASIN_BRISTLECONE_PINE_BUTTON = REGISTRY.register("great_basin_bristlecone_pine_button", () -> new GreatBasinBristleconePineButtonBlock());
	public static final RegistryObject<Block> ANCIENT_STONE = REGISTRY.register("ancient_stone", () -> new AncientStoneBlock());
	public static final RegistryObject<Block> ANCIENT_COBBLESTONE = REGISTRY.register("ancient_cobblestone", () -> new AncientCobblestoneBlock());
	public static final RegistryObject<Block> ANCIENT_BRICKS = REGISTRY.register("ancient_bricks", () -> new AncientBricksBlock());
	public static final RegistryObject<Block> ANCIENT_LEAVES = REGISTRY.register("ancient_leaves", () -> new AncientLeavesBlock());
	public static final RegistryObject<Block> DNA_INJECTOR_BLOCK = REGISTRY.register("dna_injector_block", () -> new DNAInjectorBlockBlock());
	public static final RegistryObject<Block> DNA_MODIFIER = REGISTRY.register("dna_modifier", () -> new DNAModifierBlock());

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void blockColorLoad(RegisterColorHandlersEvent.Block event) {
			AncientLeavesBlock.blockColorLoad(event);
		}
	}
}
