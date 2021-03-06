package com.maw79.mods.tileentity.storetileentity;


import com.maw79.mods.init.ModItems;
import com.maw79.mods.main.Reference;
import com.maw79.mods.util.Utils;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class GuiStore extends GuiContainer{
	
	private IInventory playerInv;
	private Entity entity;

	public GuiStore(IInventory playerInv, Entity entity) {
		super(new ContainerStore(playerInv, entity));
		Utils.getLogger().info("GuiStore: Constructor");
		
		this.xSize=176;
		this.ySize=166;		
		this.playerInv = playerInv;
		this.entity = entity;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		//Utils.getLogger().info("GuiBasic: drawGuiContainerBackgroundLayer");
		
		GlStateManager.color(1.0F, 1.0F, 1.0F,1.0F);
		this.mc.getTextureManager().bindTexture(new ResourceLocation(Reference.MOD_ID, "textures/gui/container/store.png"));
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize,this.ySize);
		 GlStateManager.popMatrix();
		  ItemStack icon = new ItemStack(ModItems.obsidianingot);
		GlStateManager.translate(width/2, height/2, 0);
        GlStateManager.scale(1, 1, 1);
        mc.getRenderItem().renderItemAndEffectIntoGUI(icon, 0, 0);
		GlStateManager.pushMatrix();
	}
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		//Utils.getLogger().info("GuiBasic: drawGuiContainerForegroundLayer");
		
		String s = ("Store"); //Gets the formatted name for the block breaker from the language file
		this.mc.fontRendererObj.drawString(s, this.xSize / 2 - this.mc.fontRendererObj.getStringWidth(s) / 2, 6, 4210752); //Draws the block breaker name in the center on the top of the gui
		//this.mc.fontRendererObj.drawString(this.playerInv.getDisplayName().getFormattedText(), 8, 72, 4210752); //The player's inventory name
		this.fontRendererObj.drawString("Item 1", (46), (15), 0xffffff);
		this.fontRendererObj.drawString("Item 2", (46), (38), 0xffffff);
		this.fontRendererObj.drawString("Item 3", (46), (62), 0xffffff);
		this.fontRendererObj.drawString("Item 4", (127), (15), 0xffffff);
		this.fontRendererObj.drawString("Item 5", (127), (39), 0xffffff);
		this.fontRendererObj.drawString("Item 6", (126), (62), 0xffffff);
		int actualMouseX = mouseX - ((this.width - this.xSize) / 2);
		int actualMouseY = mouseY - ((this.height - this.ySize) / 2);
		
	}
	

}
