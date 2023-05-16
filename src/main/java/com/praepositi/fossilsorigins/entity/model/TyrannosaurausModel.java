package com.praepositi.fossilsorigins.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import com.praepositi.fossilsorigins.entity.TyrannosaurausEntity;

public class TyrannosaurausModel extends AnimatedGeoModel<TyrannosaurausEntity> {
	@Override
	public ResourceLocation getAnimationResource(TyrannosaurausEntity entity) {
		return new ResourceLocation("fossilsorigins", "animations/tyrannosauraus.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(TyrannosaurausEntity entity) {
		return new ResourceLocation("fossilsorigins", "geo/tyrannosauraus.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(TyrannosaurausEntity entity) {
		return new ResourceLocation("fossilsorigins", "textures/entities/" + entity.getTexture() + ".png");
	}

}
