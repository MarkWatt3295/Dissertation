package com.maw79.mods.blocks.scienceblocks.propertiesmatcher;


import java.io.IOException;

import com.maw79.mods.client.gui.GuiMathsQuestGive;
import com.maw79.mods.handlers.ModSoundHandler;
import com.maw79.mods.main.Reference;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.items.CapabilityItemHandler;

/**
 * The {@link BlockBreaker}'s gui
 * @author Mark Watt
 *
 */
public class GuiPropertiesMatcher extends GuiContainer {

	/**
	 * The tile entity and player inventory
	 */
	private TileEntityPropertiesMatcher te;
	private IInventory playerInv;
	
	public boolean help = false;
	
	
	public GuiPropertiesMatcher(IInventory playerInv, TileEntityPropertiesMatcher te) {
		super(new ContainerPropertiesMatcher(playerInv, te));
		
		this.xSize = 176; //Texture xSize
		this.ySize = 166; //Texture ySize
		this.te = te;
		this.playerInv = playerInv;
		 
	}

	/**
	 * Draws the gui and the grey background behind it
	 */
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F); //Grey background
	
		this.mc.getTextureManager().bindTexture(new ResourceLocation(Reference.MOD_ID, "textures/gui/container/matcher.png"));
		
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize); //Draws our texture
	}
	
	/**
	 * Draws the text that is an overlay, i.e where it says Insulator in the gui on the top
	 */
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		
    	
		//Default Strings
		String s = ("Properties Matcher"); 
		String s2 = ("Insert a Property Label");
		String s3 = "";
		String s4 = "";
		String s5 = "Then Select The Material";
		String s6 = "That Matches the Label";
		
		
		
			
	//DECIMAL COLOUR VALUES
		this.mc.fontRendererObj.drawString(s, this.xSize / 2 - this.mc.fontRendererObj.getStringWidth(s) / 2, 6, 30000); //Draws the block breaker name in the center on the top of the gui
		this.mc.fontRendererObj.drawString(s2, this.xSize / 2 - this.mc.fontRendererObj.getStringWidth(s2) / 2, 22, 16777215);
		this.mc.fontRendererObj.drawString(s3, this.xSize / 2 - this.mc.fontRendererObj.getStringWidth(s3) / 2, 58, 16777215);
		this.mc.fontRendererObj.drawString(s4, this.xSize / 2 - this.mc.fontRendererObj.getStringWidth(s4) / 2, 72, 16777215);
		this.mc.fontRendererObj.drawString(s5, this.xSize / 2 - this.mc.fontRendererObj.getStringWidth(s5) / 2, 62, 16777215);
		this.mc.fontRendererObj.drawString(s6, this.xSize / 2 - this.mc.fontRendererObj.getStringWidth(s6) / 2, 82, 16777215);
		
		
		 
		int actualMouseX = mouseX - ((this.width - this.xSize) / 2);
		int actualMouseY = mouseY - ((this.height - this.ySize) / 2);
		if(actualMouseX >= 134 && actualMouseX <= 149 && actualMouseY >= 17 && actualMouseY <= 32 && te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).getStackInSlot(9) == ItemStack.EMPTY) {
			
		}
	}

	  @Override
	    public boolean doesGuiPauseGame() {
	        return false;
	    }
	  
	 
	
	
	
	

	@Override
	    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
	      
	        super.mouseClicked(mouseX, mouseY, mouseButton);
	    }
	 
	
	 

}