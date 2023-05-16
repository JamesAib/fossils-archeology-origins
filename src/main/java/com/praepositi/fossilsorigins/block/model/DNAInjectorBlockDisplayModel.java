package com.praepositi.fossilsorigins.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import com.praepositi.fossilsorigins.block.display.DNAInjectorBlockDisplayItem;

public class DNAInjectorBlockDisplayModel extends AnimatedGeoModel<DNAInjectorBlockDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(DNAInjectorBlockDisplayItem animatable) {
		return new ResourceLocation("fossilsorigins", "animations/dnainjector.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(DNAInjectorBlockDisplayItem animatable) {
		return new ResourceLocation("fossilsorigins", "geo/dnainjector.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(DNAInjectorBlockDisplayItem entity) {
		return new ResourceLocation("fossilsorigins", "textures/blocks/texture.png");
	}
}
