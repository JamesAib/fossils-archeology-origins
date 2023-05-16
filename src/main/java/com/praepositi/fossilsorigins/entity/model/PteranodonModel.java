package com.praepositi.fossilsorigins.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import com.praepositi.fossilsorigins.entity.PteranodonEntity;

public class PteranodonModel extends AnimatedGeoModel<PteranodonEntity> {
	@Override
	public ResourceLocation getAnimationResource(PteranodonEntity entity) {
		return new ResourceLocation("fossilsorigins", "animations/pteranodon.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(PteranodonEntity entity) {
		return new ResourceLocation("fossilsorigins", "geo/pteranodon.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(PteranodonEntity entity) {
		return new ResourceLocation("fossilsorigins", "textures/entities/" + entity.getTexture() + ".png");
	}

}
