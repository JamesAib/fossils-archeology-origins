package com.praepositi.fossilsorigins.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import com.praepositi.fossilsorigins.entity.DimetrodonEntity;

public class DimetrodonModel extends AnimatedGeoModel<DimetrodonEntity> {
	@Override
	public ResourceLocation getAnimationResource(DimetrodonEntity entity) {
		return new ResourceLocation("fossilsorigins", "animations/dimetrodon.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(DimetrodonEntity entity) {
		return new ResourceLocation("fossilsorigins", "geo/dimetrodon.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(DimetrodonEntity entity) {
		return new ResourceLocation("fossilsorigins", "textures/entities/" + entity.getTexture() + ".png");
	}

}
