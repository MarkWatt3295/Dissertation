package com.maw79.mods.blocks.scienceblocks.tileentityscience;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.maw79.mods.client.gui.GuiNotif;
import com.maw79.mods.handlers.ModSoundHandler;
import com.maw79.mods.main.Reference;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.items.CapabilityItemHandler;

/**
 * The {@link BlockBreaker}'s gui
 * @author Mark Watt
 *
 */
public class GuiScienceTe extends GuiContainer {

	/**
	 * The tile entity and player inventory
	 */
	private TileEntityScience te;
	private IInventory playerInv;
	GuiButton button1;
	final int BUTTON1=1;
	
	public boolean woodproperties1 = false;
	public boolean woodproperties2 = false;
	public boolean woodproperties3 = false;
	
	/**
	 * Typical {@link GuiContainer} constructor
	 * @param playerInv The players inventory
	 * @param te The tile entity
	 */
	
	
	 
	public GuiScienceTe(IInventory playerInv, TileEntityScience te) {
		super(new ContainerScience(playerInv, te));
		
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
		this.mc.getTextureManager().bindTexture(new ResourceLocation(Reference.MOD_ID, "textures/gui/container/tileentityscience.png")); //Binds the texture for rendering
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize); //Draws our texture
	}
	
	/**
	 * Draws the text that is an overlay, i.e where it says Block Breaker in the gui on the top
	 */
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		String s = ("Material Properties"); //Gets the formatted name for the block breaker from the language file
		this.mc.fontRendererObj.drawString(s, this.xSize / 2 - this.mc.fontRendererObj.getStringWidth(s) / 2, 6, 4210752); //Draws the block breaker name in the center on the top of the gui
		//this.mc.fontRendererObj.drawString(this.playerInv.getDisplayName().getFormattedText(), 8, 72, 4210752); //The player's inventory name
		int actualMouseX = mouseX - ((this.width - this.xSize) / 2);
		int actualMouseY = mouseY - ((this.height - this.ySize) / 2);
		if(actualMouseX >= 134 && actualMouseX <= 149 && actualMouseY >= 17 && actualMouseY <= 32 && te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).getStackInSlot(9) == ItemStack.EMPTY) {
			List<String> text = new ArrayList<String>();
			//text.add(TextFormatting.GRAY + I18n.format("gui.block_breaker.enchanted_book.tooltip"));
			text.add(TextFormatting.BLUE + ("This is a Tooltip"));
			this.drawHoveringText(text, actualMouseX, actualMouseY);
		}
	}
	@Override
    public void initGui() {
    	
        buttonList.clear();
        buttonList.add(button1 = new GuiButton(BUTTON1, (width / 2) - 100 / 2, 95, 100, 20, "Submit Answers"));
        updateButtons();
        super.initGui();
    }
	
	 @Override
	    protected void actionPerformed(GuiButton button) throws IOException {
	    	
	    	
	        switch (button.id) {
	            case BUTTON1:
	            	mc.player.playSound(ModSoundHandler.STEEL_BUTTON_CLICK_OFF, 1.0f, 1.0f);
	            	mc.displayGuiScreen((GuiScreen)null);
	            	break;
	        }
	        updateButtons();
	        super.actionPerformed(button);
	      
	    }
	 
	 public void onEvent(){
	    	System.out.println("Tile Entity With button Pressed");
	    	  
	    }
	 
	 public void updateButtons() {
         onEvent(); 
   
 }
	 
	 }


