package com.praepositi.fossilsorigins.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import com.praepositi.fossilsorigins.entity.PlesiosuarusEntity;

public class PlesiosuarusModel extends AnimatedGeoModel<PlesiosuarusEntity> {
	@Override
	public ResourceLocation getAnimationResource(PlesiosuarusEntity entity) {
		return new ResourceLocation("fossilsorigins", "animations/plesiosaurus.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(PlesiosuarusEntity entity) {
		return new ResourceLocation("fossilsorigins", "geo/plesiosaurus.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(PlesiosuarusEntity entity) {
		return new ResourceLocation("fossilsorigins", "textures/entities/" + entity.getTexture() + ".png");
	}

}
