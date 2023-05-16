
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.praepositi.fossilsorigins.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.biome.Biome;

import com.praepositi.fossilsorigins.world.biome.AncientPlainsBiome;
import com.praepositi.fossilsorigins.world.biome.AncientJungleBiome;
import com.praepositi.fossilsorigins.FossilsoriginsMod;

public class FossilsoriginsModBiomes {
	public static final DeferredRegister<Biome> REGISTRY = DeferredRegister.create(ForgeRegistries.BIOMES, FossilsoriginsMod.MODID);
	public static final RegistryObject<Biome> ANCIENT_JUNGLE = REGISTRY.register("ancient_jungle", AncientJungleBiome::createBiome);
	public static final RegistryObject<Biome> ANCIENT_PLAINS = REGISTRY.register("ancient_plains", AncientPlainsBiome::createBiome);
}
