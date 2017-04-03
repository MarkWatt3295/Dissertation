package com.maw79.mods.blocks.scienceblocks.tileentityscience;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.maw79.mods.client.gui.GuiNotif;
import com.maw79.mods.handlers.ModSoundHandler;
import com.maw79.mods.main.Maw79Mod;
import com.maw79.mods.main.Reference;
import com.maw79.mods.network.GuiInventoryMessage;
import com.maw79.mods.network.MathsMessage;
import com.maw79.mods.util.Utils;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
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
	GuiButton button1, button2, button3;
	final int BUTTON1=1, BUTTON2 = 2, BUTTON3 = 3;
	
	public static boolean correctlabels = false;
	
	
	
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
        buttonList.add(button3 = new GuiButton(BUTTON3, (width / 2) - 100 / 2, 95, 100, 20, "Check Answers"));
        buttonList.add(button2 = new GuiButton(BUTTON2, (width / 2) - 100 / 2, 115, 100, 20, "Submit Answers"));
      
        super.initGui();
        button3.visible = false;
    }
	  @Override
	    public boolean doesGuiPauseGame() {
	        return false;
	    }
	
	 @Override
	    public void actionPerformed(GuiButton button) throws IOException {
	    	
	    	
	        switch (button.id) {
	            case BUTTON1:
	            	
	            	break;
	            	
	            case BUTTON2:
				
	            	mc.player.playSound(SoundEvent.REGISTRY.getObject(new ResourceLocation(("entity.chicken.egg"))), 1.0F, 1.0F);
	            	onEvent();
	      
	            	break;
	            	
	            case BUTTON3:
	            	
	            	mc.player.playSound(ModSoundHandler.STEEL_BUTTON_CLICK_OFF, 1.0f, 1.0f);
	            	
	            	break;
	            	
	        }
	        updateButtons();
	        super.actionPerformed(button);
	      
	    }
	
	 public void onEvent(){
		if (correctlabels == true){
			Utils.getLogger().info("Button Pressed and Labels are true");
		}
		if (te.cangiveblocks == true){
			Utils.getLogger().info("Give Blocks fjddslslsssl");
			Maw79Mod.networkWrapper2.sendToServer(new MathsMessage(mc.player));
			te.cangiveblocks = false;
		}
 		}
 		
	 
	 public void onEvent2(){
		
	 }
	    	
	    	  
	   public void onEvent3(){
		
	   }
	 
	 public void updateButtons() {
       
   
 }
	 @Override
	    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
	      
	        super.mouseClicked(mouseX, mouseY, mouseButton);
	    }
	 
	
	 }

