package com.praepositi.fossilsorigins.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import com.praepositi.fossilsorigins.block.display.DNAModifierDisplayItem;

public class DNAModifierDisplayModel extends AnimatedGeoModel<DNAModifierDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(DNAModifierDisplayItem animatable) {
		return new ResourceLocation("fossilsorigins", "animations/dnamodifier.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(DNAModifierDisplayItem animatable) {
		return new ResourceLocation("fossilsorigins", "geo/dnamodifier.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(DNAModifierDisplayItem entity) {
		return new ResourceLocation("fossilsorigins", "textures/blocks/dnamodifer.png");
	}
}
