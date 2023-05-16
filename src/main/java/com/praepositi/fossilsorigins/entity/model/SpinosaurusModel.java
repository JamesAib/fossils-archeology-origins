package com.praepositi.fossilsorigins.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import com.praepositi.fossilsorigins.entity.SpinosaurusEntity;

public class SpinosaurusModel extends AnimatedGeoModel<SpinosaurusEntity> {
	@Override
	public ResourceLocation getAnimationResource(SpinosaurusEntity entity) {
		return new ResourceLocation("fossilsorigins", "animations/spinosaurus.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SpinosaurusEntity entity) {
		return new ResourceLocation("fossilsorigins", "geo/spinosaurus.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SpinosaurusEntity entity) {
		return new ResourceLocation("fossilsorigins", "textures/entities/" + entity.getTexture() + ".png");
	}

}
