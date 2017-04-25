package com.maw79.mods.blocks.mathsblocks.coordinatesquest;


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
public class GuiCoordinatesQuest extends GuiContainer {

	/**
	 * The tile entity and player inventory
	 */
	private TileEntityCoordinatesQuest te;
	private IInventory playerInv;
	GuiButton button1, button3, button4, button5, reward;
	final int BUTTON1= 1, BUTTON3 = 3, BUTTON4 = 4, BUTTON5 = 5, REWARD = 6;
	
	

	public boolean help = false;
	
	public GuiCoordinatesQuest(IInventory playerInv, TileEntityCoordinatesQuest te) {
		super(new ContainerCoordinatesQuest(playerInv, te));
		
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
		if(help == true){
			mc.getTextureManager().bindTexture(new ResourceLocation(Reference.MOD_ID, "textures/gui/container/mathsquesthelp.png"));
		}
		else{
		this.mc.getTextureManager().bindTexture(new ResourceLocation(Reference.MOD_ID, "textures/gui/container/mathsquest.png"));
		}//Binds the texture for rendering
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize); //Draws our texture
	}
	
	/**
	 * Draws the text that is an overlay, i.e where it says Insulator in the gui on the top
	 */
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		
    	
		//Default Strings
		String s = ("Coordinates Quest"); 
		String s2 = ("Return Items Here");
		String s3 = "";
		String s4 = "";
		String s5 = "";
		String s6 = "";
		String findnums = "Visit Mr. Numbers For A Quest";
		
		
		
		if(help == true){
			 s = ("Helpy helpy help");
			 s2 = ("");
			 s3 = ("");
			 s4 = ("Visit Mr. Numbers");
			 s5 = ("To Start a Quest");
			 s6 = ("");
			
		}
		
			
	//DECIMAL COLOUR VALUES
		this.mc.fontRendererObj.drawString(s, this.xSize / 2 - this.mc.fontRendererObj.getStringWidth(s) / 2, 6, 30000); //Draws the block breaker name in the center on the top of the gui
		this.mc.fontRendererObj.drawString(s2, this.xSize / 2 - this.mc.fontRendererObj.getStringWidth(s2) / 2, 22, 4210752);
		this.mc.fontRendererObj.drawString(s3, this.xSize / 2 - this.mc.fontRendererObj.getStringWidth(s3) / 2, 58, 4210752);
		this.mc.fontRendererObj.drawString(s4, this.xSize / 2 - this.mc.fontRendererObj.getStringWidth(s4) / 2, 72, 4210752);
		this.mc.fontRendererObj.drawString(s5, this.xSize / 2 - this.mc.fontRendererObj.getStringWidth(s5) / 2, 82, 4210752);
		this.mc.fontRendererObj.drawString(s6, this.xSize / 2 - this.mc.fontRendererObj.getStringWidth(s6) / 2, 92, 4210752);
		this.mc.fontRendererObj.drawString(findnums, this.xSize / 2 - this.mc.fontRendererObj.getStringWidth(findnums) / 2, 62, 30000);
		
		 
		int actualMouseX = mouseX - ((this.width - this.xSize) / 2);
		int actualMouseY = mouseY - ((this.height - this.ySize) / 2);
		if(actualMouseX >= 134 && actualMouseX <= 149 && actualMouseY >= 17 && actualMouseY <= 32 && te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).getStackInSlot(9) == ItemStack.EMPTY) {
			
		}
	}
	@Override
    public void initGui() {
    
        buttonList.add(button1 = new GuiButton(BUTTON1, (width / 2) + 80 / 2, (height/2) -50, 30, 20, "Back"));
        buttonList.add(button3 = new GuiButton(BUTTON3, (width / 2) - 20 , (height/2) -5, 40, 20, "Help"));
        buttonList.add(reward = new GuiButton(REWARD, (width / 2)-70 , (height/2) -5, 140, 20, "Now Return to Mr. Numbers"));
      
        super.initGui();
        button1.visible = false;
        reward.visible = false;
        
    }
	  @Override
	    public boolean doesGuiPauseGame() {
	        return false;
	    }
	  
	 
	
	 @Override
	    public void actionPerformed(GuiButton button) throws IOException {
	    	
	    	
	        switch (button.id) {
	            case BUTTON1: //back
	            	help = false;
	            	button1.visible = false;
	            	drawGuiContainerBackgroundLayer(zLevel, BUTTON1, BUTTON1);
	            	button3.visible = true;
	            	
	            	break;
	            	
	          
	            	
	            case BUTTON3: //help

	            	help = true;
	            	button3.visible = false;
	            	drawGuiContainerBackgroundLayer(zLevel, BUTTON3, BUTTON3);
	            	button1.visible = true;
	            	
	            	break;
	            	
	            case REWARD: //help
	            
	            	reward.visible = false;
	            	mc.player.closeScreen();
	            	
	            	break;
	            	
	        }
	      
	        super.actionPerformed(button);
	      
	    }
	
	 
	 private void onEvent() {
		
	}

	@Override
	    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
	      
	        super.mouseClicked(mouseX, mouseY, mouseButton);
	    }
	 
	
	 

}