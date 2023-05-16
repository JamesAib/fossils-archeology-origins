package com.praepositi.fossilsorigins.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import com.praepositi.fossilsorigins.entity.CarnotaurusEntity;

public class CarnotaurusModel extends AnimatedGeoModel<CarnotaurusEntity> {
	@Override
	public ResourceLocation getAnimationResource(CarnotaurusEntity entity) {
		return new ResourceLocation("fossilsorigins", "animations/carnotaurus.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(CarnotaurusEntity entity) {
		return new ResourceLocation("fossilsorigins", "geo/carnotaurus.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(CarnotaurusEntity entity) {
		return new ResourceLocation("fossilsorigins", "textures/entities/" + entity.getTexture() + ".png");
	}

}
