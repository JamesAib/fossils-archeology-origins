package com.praepositi.fossilsorigins.block.renderer;

import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.praepositi.fossilsorigins.block.model.DNAModifierDisplayModel;
import com.praepositi.fossilsorigins.block.display.DNAModifierDisplayItem;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class DNAModifierDisplayItemRenderer extends GeoItemRenderer<DNAModifierDisplayItem> {
	public DNAModifierDisplayItemRenderer() {
		super(new DNAModifierDisplayModel());
	}

	@Override
	public RenderType getRenderType(DNAModifierDisplayItem animatable, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, VertexConsumer buffer, int packedLight, ResourceLocation texture) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
