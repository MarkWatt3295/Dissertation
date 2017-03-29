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
	GuiButton button1, button2, button3;
	final int BUTTON1=1, BUTTON2 = 2, BUTTON3 = 3;
	
	public static boolean buttonRelease = false;
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
        buttonList.add(button3 = new GuiButton(BUTTON3, (width / 2) - 100 / 2, 95, 100, 20, "Check Answers"));
        buttonList.add(button2 = new GuiButton(BUTTON2, (width / 2) - 100 / 2, 115, 100, 20, "Submit Answers"));
        //updateButtons();
        super.initGui();
        button2.visible = false;
    }
	  @Override
	    public boolean doesGuiPauseGame() {
	        return false;
	    }
	
	 @Override
	    public void actionPerformed(GuiButton button) throws IOException {
	    	
	    	
	        switch (button.id) {
	            case BUTTON1:
	            	//buttonRelease = true;
	            	System.out.println("Skimmed button 1");
	            	//mc.player.playSound(ModSoundHandler.STEEL_BUTTON_CLICK_OFF, 1.0f, 1.0f);
	            	//System.out.println("Before GUI --> Correct Properties = "+ te.correctproperties);
	            	//onEvent();
	            	//mc.displayGuiScreen((GuiScreen)null);
	            	//System.out.println("After GUI --> Correct Properties = "+ te.correctproperties);
	            	break;
	            	
	            case BUTTON2:
	            	buttonRelease = false;
	            	mc.player.playSound(ModSoundHandler.STEEL_BUTTON_CLICK_OFF, 1.0f, 1.0f);
	            	
	            	onEvent2();
	            	
	            	break;
	            	
	            case BUTTON3:
	            	buttonRelease = true;
	            	mc.player.playSound(ModSoundHandler.STEEL_BUTTON_CLICK_OFF, 1.0f, 1.0f);
	            	//System.out.println("Before GUI --> Correct Properties = "+ te.correctproperties);
	            	onEvent();
	            	//mc.displayGuiScreen((GuiScreen)null);
	            	//System.out.println("After GUI --> Correct Properties = "+ te.correctproperties);
	            	break;
	            	
	        }
	        updateButtons();
	        super.actionPerformed(button);
	      
	    }
	 
	 public void onEvent2(){
		 System.out.println("On event 2 called");
		 button3.visible = true;
 		button2.visible =false;
 		te.setremove = true;
 		//te.setremove=true;
 		//Maw79Mod.networkWrapperGuiInventory1.sendToServer(new GuiInventoryMessage(mc.player, te));
	 }
	 
	 public void onEvent(){
	    	System.out.println("On Event 1 called");
	    	if(te.correctproperties = true){
	    		//if(buttonRelease = true){
        		mc.player.playSound(ModSoundHandler.MAWSOUND_SQUELCH, 1.0f, 3.0f);
        		//te.handler.extractItem(3, 1, false);
        		//te.handler.extractItem(4, 1, false);
        		//te.handler.extractItem(5, 1, false);
        		//te.removeItems();
        		//button3.visible = false;
        		button2.visible =true;
        		button3.visible = false;
        		//Maw79Mod.networkWrapperGuiInventory1.sendToServer(new GuiInventoryMessage(mc.player, te));
        		//buttonRelease = true;
        		te.correctproperties = false;
        		buttonRelease = false;
	    		//}
        	}
	    	  
	    }
	 
	 public void updateButtons() {
        // onEvent(); 
   
 }
	 @Override
	    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
	      
	        super.mouseClicked(mouseX, mouseY, mouseButton);
	    }
	 
	 }


