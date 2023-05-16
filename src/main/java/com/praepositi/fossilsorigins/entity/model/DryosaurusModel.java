package com.praepositi.fossilsorigins.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import com.praepositi.fossilsorigins.entity.DryosaurusEntity;

public class DryosaurusModel extends AnimatedGeoModel<DryosaurusEntity> {
	@Override
	public ResourceLocation getAnimationResource(DryosaurusEntity entity) {
		return new ResourceLocation("fossilsorigins", "animations/dryosaurus.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(DryosaurusEntity entity) {
		return new ResourceLocation("fossilsorigins", "geo/dryosaurus.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(DryosaurusEntity entity) {
		return new ResourceLocation("fossilsorigins", "textures/entities/" + entity.getTexture() + ".png");
	}

}
