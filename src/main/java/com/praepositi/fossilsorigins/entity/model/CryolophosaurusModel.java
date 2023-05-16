package com.praepositi.fossilsorigins.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import com.praepositi.fossilsorigins.entity.CryolophosaurusEntity;

public class CryolophosaurusModel extends AnimatedGeoModel<CryolophosaurusEntity> {
	@Override
	public ResourceLocation getAnimationResource(CryolophosaurusEntity entity) {
		return new ResourceLocation("fossilsorigins", "animations/crylocryolophosaurus.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(CryolophosaurusEntity entity) {
		return new ResourceLocation("fossilsorigins", "geo/crylocryolophosaurus.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(CryolophosaurusEntity entity) {
		return new ResourceLocation("fossilsorigins", "textures/entities/" + entity.getTexture() + ".png");
	}

}
