
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.praepositi.fossilsorigins.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.levelgen.feature.Feature;

import com.praepositi.fossilsorigins.world.features.ores.FossilsFeature;
import com.praepositi.fossilsorigins.FossilsoriginsMod;

@Mod.EventBusSubscriber
public class FossilsoriginsModFeatures {
	public static final DeferredRegister<Feature<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.FEATURES, FossilsoriginsMod.MODID);
	public static final RegistryObject<Feature<?>> FOSSILS = REGISTRY.register("fossils", FossilsFeature::feature);
}
