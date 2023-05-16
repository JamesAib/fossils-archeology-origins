package com.praepositi.fossilsorigins.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import com.praepositi.fossilsorigins.block.entity.DNAInjectorBlockTileEntity;

public class DNAInjectorBlockBlockModel extends AnimatedGeoModel<DNAInjectorBlockTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(DNAInjectorBlockTileEntity animatable) {
		return new ResourceLocation("fossilsorigins", "animations/dnainjector.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(DNAInjectorBlockTileEntity animatable) {
		return new ResourceLocation("fossilsorigins", "geo/dnainjector.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(DNAInjectorBlockTileEntity entity) {
		return new ResourceLocation("fossilsorigins", "textures/blocks/texture.png");
	}
}
