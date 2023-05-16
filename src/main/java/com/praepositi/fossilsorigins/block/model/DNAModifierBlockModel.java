package com.praepositi.fossilsorigins.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import com.praepositi.fossilsorigins.block.entity.DNAModifierTileEntity;

public class DNAModifierBlockModel extends AnimatedGeoModel<DNAModifierTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(DNAModifierTileEntity animatable) {
		return new ResourceLocation("fossilsorigins", "animations/dnamodifier.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(DNAModifierTileEntity animatable) {
		return new ResourceLocation("fossilsorigins", "geo/dnamodifier.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(DNAModifierTileEntity entity) {
		return new ResourceLocation("fossilsorigins", "textures/blocks/dnamodifer.png");
	}
}
