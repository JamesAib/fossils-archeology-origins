
package com.praepositi.fossilsorigins.client.renderer;

import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.praepositi.fossilsorigins.procedures.SettingMobParametersProcedure;
import com.praepositi.fossilsorigins.entity.model.GalimimusModel;
import com.praepositi.fossilsorigins.entity.GalimimusEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class GalimimusRenderer extends GeoEntityRenderer<GalimimusEntity> {
	public GalimimusRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new GalimimusModel());
		this.shadowRadius = 0f;
	}

	@Override
	public RenderType getRenderType(GalimimusEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		Level world = entity.level;
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		float scale = (float) SettingMobParametersProcedure.execute(entity);
		stack.scale(scale, scale, scale);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}
}
