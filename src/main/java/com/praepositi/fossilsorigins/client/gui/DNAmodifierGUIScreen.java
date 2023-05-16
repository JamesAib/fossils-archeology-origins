package com.praepositi.fossilsorigins.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Checkbox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

import com.praepositi.fossilsorigins.world.inventory.DNAmodifierGUIMenu;
import com.praepositi.fossilsorigins.network.DNAmodifierGUIButtonMessage;
import com.praepositi.fossilsorigins.FossilsoriginsMod;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class DNAmodifierGUIScreen extends AbstractContainerScreen<DNAmodifierGUIMenu> {
	private final static HashMap<String, Object> guistate = DNAmodifierGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Checkbox gender;
	Button button_apply_modifications;

	public DNAmodifierGUIScreen(DNAmodifierGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("fossilsorigins:textures/screens/dn_amodifier_gui.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		button_apply_modifications = new Button(this.leftPos + 8, this.topPos + 61, 124, 20, Component.translatable("gui.fossilsorigins.dn_amodifier_gui.button_apply_modifications"), e -> {
			if (true) {
				FossilsoriginsMod.PACKET_HANDLER.sendToServer(new DNAmodifierGUIButtonMessage(0, x, y, z));
				DNAmodifierGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_apply_modifications", button_apply_modifications);
		this.addRenderableWidget(button_apply_modifications);
		gender = new Checkbox(this.leftPos + 8, this.topPos + 3, 20, 20, Component.translatable("gui.fossilsorigins.dn_amodifier_gui.gender"), false);
		guistate.put("checkbox:gender", gender);
		this.addRenderableWidget(gender);
	}
}
