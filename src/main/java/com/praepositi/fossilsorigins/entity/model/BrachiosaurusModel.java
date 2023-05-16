package com.praepositi.fossilsorigins.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import com.praepositi.fossilsorigins.entity.BrachiosaurusEntity;

public class BrachiosaurusModel extends AnimatedGeoModel<BrachiosaurusEntity> {
	@Override
	public ResourceLocation getAnimationResource(BrachiosaurusEntity entity) {
		return new ResourceLocation("fossilsorigins", "animations/brachiosaurus.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BrachiosaurusEntity entity) {
		return new ResourceLocation("fossilsorigins", "geo/brachiosaurus.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BrachiosaurusEntity entity) {
		return new ResourceLocation("fossilsorigins", "textures/entities/" + entity.getTexture() + ".png");
	}

}
