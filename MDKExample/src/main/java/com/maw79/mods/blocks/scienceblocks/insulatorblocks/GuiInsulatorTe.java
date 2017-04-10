package com.maw79.mods.blocks.scienceblocks.insulatorblocks;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.opengl.GL11;

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
public class GuiInsulatorTe extends GuiContainer {

	/**
	 * The tile entity and player inventory
	 */
	private TileEntityInsulator te;
	private IInventory playerInv;
	GuiButton button1, button2, button3, button4, button5;
	final int BUTTON1= 1, BUTTON2 = 2, BUTTON3 = 3, BUTTON4 = 4, BUTTON5 = 5;
	
	
	public boolean help = false;
	
	
	
	public GuiInsulatorTe(IInventory playerInv, TileEntityInsulator te) {
		super(new ContainerInsulator(playerInv, te));
		
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
			mc.getTextureManager().bindTexture(new ResourceLocation(Reference.MOD_ID, "textures/gui/container/insulatorhelp.png"));
		}
		else{
		this.mc.getTextureManager().bindTexture(new ResourceLocation(Reference.MOD_ID, "textures/gui/container/insulator.png"));
		}//Binds the texture for rendering
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize); //Draws our texture
	}
	
	/**
	 * Draws the text that is an overlay, i.e where it says Insulator in the gui on the top
	 */
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		String s = ("Insulator Tester"); 
		String s1 = "";
		
		String s2 = ("Tempreature : "+ te.insulated);
		String s3 = "";
		String s4 = "";
		String s5 = "";
		
		if (te.insulated == 1000000
				){
			s5 = ("[*] [*] [*] [*] [*] [*] [*] [*] [*] [*]");
		}
		if (te.insulated >= 900000){
			s5 = ("[*] [*] [*] [*] [*] [*] [*] [*] [*] [*]");
		}
		else if (te.insulated >= 800000){
			s5 = ("[*] [*] [*] [*] [*] [*] [*] [*] [*]");
		}
		else if (te.insulated > 700000){
			s5 = ("[*] [*] [*] [*] [*] [*] [*] [*]");
		}
		else if (te.insulated > 600000){
			s5 = ("[*] [*] [*] [*] [*] [*] [*]");
		}
		else if (te.insulated > 500000){
			s5 = ("[*] [*] [*] [*] [*] [*]");
		}
		else if (te.insulated > 400000){
			s5 = ("[*] [*] [*] [*] [*]");
		}
		else if (te.insulated > 300000){
			s5 = ("[*] [*] [*] [*]");
		}
		else if (te.insulated > 200000){
			s5 = ("[*] [*] [*]");
		}
		else if (te.insulated > 100000){
			s5 = ("[*] [*]");
		}
		else if (te.insulated > 0){
			s5 = ("[*]");
		}
		else if (te.insulated == 0){
			s5 = ("0");
		}
		
		String s6 = (s5);
		String s7 = ("HEAT LEFT");
		String s8 = ("");
		
		 if(help == true){
			 s = ("Insulator Help");
			 s2 = ("Insulator Input");
			 s3 = ("Move Insulators");
			 s4 = ("to slow the heat loss");
			 s8 = ("- "+te.insulatedval);
		}
	
	//DECIMAL COLOUR VALUES
		this.mc.fontRendererObj.drawString(s, this.xSize / 2 - this.mc.fontRendererObj.getStringWidth(s) / 2, 6, 30000); //Draws the block breaker name in the center on the top of the gui
		this.mc.fontRendererObj.drawString(s2, this.xSize / 2 - this.mc.fontRendererObj.getStringWidth(s2) / 2, 22, 4210752);
		this.mc.fontRendererObj.drawString(s3, this.xSize / 2 - this.mc.fontRendererObj.getStringWidth(s3) / 2, 82, 4210752);
		this.mc.fontRendererObj.drawString(s4, this.xSize / 2 - this.mc.fontRendererObj.getStringWidth(s4) / 2, 92, 4210752);
		this.mc.fontRendererObj.drawString(s6, this.xSize / 2 - this.mc.fontRendererObj.getStringWidth(s6) / 2, 68, 4210752);
		this.mc.fontRendererObj.drawString(s7, this.xSize / 2 - this.mc.fontRendererObj.getStringWidth(s7) / 2, 57, 16716800);
		this.mc.fontRendererObj.drawString(s8, this.xSize / 2 - this.mc.fontRendererObj.getStringWidth(s8) / 2 - 45, 40, 30000);
		 
		int actualMouseX = mouseX - ((this.width - this.xSize) / 2);
		int actualMouseY = mouseY - ((this.height - this.ySize) / 2);
		if(actualMouseX >= 134 && actualMouseX <= 149 && actualMouseY >= 17 && actualMouseY <= 32 && te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).getStackInSlot(9) == ItemStack.EMPTY) {
			
		}
	}
	@Override
    public void initGui() {
    	
        buttonList.clear();												//+120 -100
       // buttonList.add(button3 = new GuiButton(BUTTON3, (width / 2) + 80 / 2, (height/2) -5, 30, 20, "Help"));
       // buttonList.add(button2 = new GuiButton(BUTTON2, (width / 2) - 170 / 2, (height/2) -5, 40, 20, "Reset"));
        buttonList.add(button1 = new GuiButton(BUTTON1, (width / 2) + 80 / 2, (height/2) -50, 30, 20, "Back"));
        buttonList.add(button3 = new GuiButton(BUTTON3, (width / 2) -5 / 2, (height/2) -5, 40, 20, "Help"));
        buttonList.add(button2 = new GuiButton(BUTTON2, (width / 2) -95 / 2, (height/2) -5, 40, 20, "Reset"));
      
      
        super.initGui();
        button1.visible = false;
        
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
	            	button2.visible = true;
	            	//button4.visible = true;
	            	//button5.visible = true;
	            	
	            	break;
	            	
	            case BUTTON2: //reset
				
	            	mc.player.playSound(SoundEvent.REGISTRY.getObject(new ResourceLocation(("entity.chicken.egg"))), 1.0F, 1.0F);
	            	te.heatlevel = 3;
	            	
	      
	            	break;
	            	
	            case BUTTON3: //help
	            	
	            	mc.player.playSound(ModSoundHandler.STEEL_BUTTON_CLICK_OFF, 1.0f, 1.0f);
	            	
	            	help = true;
	            	//button5.visible = false;
	            	//button4.visible = false;
	            	button3.visible = false;
	            	button2.visible = false;
	            	drawGuiContainerBackgroundLayer(zLevel, BUTTON3, BUTTON3);
	            	button1.visible = true;
	            	
	            	break;
	            	
	            case BUTTON4: //pause
	            	mc.player.playSound(SoundEvent.REGISTRY.getObject(new ResourceLocation(("entity.chicken.egg"))), 1.0F, 1.0F);
	            	te.heatlevel = 1;
	            	
	            	break;

	            case BUTTON5: //play
	            	mc.player.playSound(SoundEvent.REGISTRY.getObject(new ResourceLocation(("entity.chicken.egg"))), 1.0F, 1.0F);
	            	te.heatlevel = 0;
	            	
	            	break;
	            	
	        }
	      
	        super.actionPerformed(button);
	      
	    }
	
	 

	
	 @Override
	    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
	      
	        super.mouseClicked(mouseX, mouseY, mouseButton);
	    }
	 
	
	 

}