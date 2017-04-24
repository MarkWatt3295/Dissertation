package com.maw79.mods.client.gui.mathsgui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.maw79.mods.blocks.pointsblocks.TileEntityPointsBlock;
import com.maw79.mods.client.gui.GuiNotif;
import com.maw79.mods.handlers.ModSoundHandler;
import com.maw79.mods.init.ModItems;
import com.maw79.mods.init.ModTools;
import com.maw79.mods.main.Maw79Mod;
import com.maw79.mods.main.Reference;
import com.maw79.mods.network.store.FarmerCoinsMessage;
import com.maw79.mods.network.store.MathsStore1Message;
import com.maw79.mods.network.store.StoreItem1Message;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class GuiFarmerCoins extends GuiScreen {
	
	   
	    
	
	final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/gui/store2.png");
    int guiWidth = 175;
    int guiHeight = 210;
    
    String title = "Store";
    
   public static int buttonvalue = 0;
    
    
    GuiButton button1, button2, button3, button4, button5, buttonnextpage;
    final int BUTTON1 = 1, BUTTON2 = 2, BUTTON3 = 3, BUTTON4 = 4, BUTTON5 = 5, BUTTON6 = 6;
    
    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        //drawDefaultBackground();
        Minecraft.getMinecraft().renderEngine.bindTexture(texture);
        int centerX = (width / 2) - guiWidth / 2;
        int centerY = (height / 2) - guiHeight / 2;
       
        GlStateManager.pushMatrix();
        {
            GlStateManager.enableAlpha();
            GlStateManager.enableBlend();
            GlStateManager.color(1, 1, 1, 1);
            Minecraft.getMinecraft().renderEngine.bindTexture(texture);
            drawTexturedModalRect(centerX, centerY, 0, 0, guiWidth, guiHeight);
        }
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        {
            GlStateManager.translate((width / 2) -80, centerY + 10, 0);
            GlStateManager.scale(2, 2, 2);
            fontRendererObj.drawString(title, 0, 0, 0x6028ff);
           
        }
        GlStateManager.popMatrix();
        
        GlStateManager.pushMatrix();
        {
            GlStateManager.translate((width / 2) , centerY + 15, 0);
            GlStateManager.scale(1.2, 1.2, 1.2);
            String heading = "Points : "+ TileEntityPointsBlock.playerScore;
            fontRendererObj.drawString(heading, 0, 0, 0xffffff);
           
        }
        GlStateManager.popMatrix();
        
        GlStateManager.pushMatrix();
        {
            GlStateManager.translate((width / 2), centerY + 10, 0);
            GlStateManager.scale(1.4, 1.4, 1.4);
           
            fontRendererObj.drawString("40 Points", (-23), (20), 0xffffff); //Ladder
    		fontRendererObj.drawString("50 Points", (-23), (40), 0xffffff); //Spade
    		fontRendererObj.drawString("30 Points", (-23), (56), 0xffffff);//Glowstone
    		fontRendererObj.drawString("40 Points", (-23), (74), 0xffffff);//Torch
    		fontRendererObj.drawString("30 Points", (-23), (90), 0xffffff);//book
    		
        }
        GlStateManager.popMatrix();
        
        
        
        button1.drawButton(mc, mouseX, mouseY);
        button2.drawButton(mc, mouseX, mouseY);
        button3.drawButton(mc, mouseX, mouseY);
        button4.drawButton(mc, mouseX, mouseY);
        button5.drawButton(mc, mouseX, mouseY);
        ItemStack icon = new ItemStack(Blocks.LADDER);
        ItemStack icon2 = new ItemStack(ModTools.glassSpade);
        ItemStack icon3 = new ItemStack(Blocks.GLOWSTONE);
        ItemStack icon4 = new ItemStack(Blocks.TORCH);
        ItemStack icon5 = new ItemStack(ModItems.FRACTIONS_BOOK);
        
        GlStateManager.pushMatrix();
        {
		GlStateManager.translate((width / 2) - 77.5, centerY + 33, 0);
      GlStateManager.scale(1.4, 1.4, 1.4);
      mc.getRenderItem().renderItemAndEffectIntoGUI(icon, 0, 0);
		
        }     
        GlStateManager.popMatrix();
        
        GlStateManager.pushMatrix();
        {
        	GlStateManager.translate((width / 2) - 77.5, centerY + 59, 0);
        	GlStateManager.scale(1.4, 1.4, 1.4);
        	mc.getRenderItem().renderItemAndEffectIntoGUI(icon2, 0, 0);
		
        }     
        GlStateManager.popMatrix();
        
        GlStateManager.pushMatrix();
        {
        	GlStateManager.translate((width / 2) - 77.5, centerY + 83, 0);
        	GlStateManager.scale(1.4, 1.4, 1.4);
        	mc.getRenderItem().renderItemAndEffectIntoGUI(icon3, 0, 0);
		
        }     
        GlStateManager.popMatrix();
        
        GlStateManager.pushMatrix();
        {
        	GlStateManager.translate((width / 2) - 77.5, centerY + 108, 0);
        	GlStateManager.scale(1.4, 1.4, 1.4);
        	mc.getRenderItem().renderItemAndEffectIntoGUI(icon4, 0, 0);
		
        }     
        GlStateManager.popMatrix();
        
        GlStateManager.pushMatrix();
        {
        	GlStateManager.translate((width / 2) - 77.5, centerY + 132, 0);
        	GlStateManager.scale(1.4, 1.4, 1.4);
        	mc.getRenderItem().renderItemAndEffectIntoGUI(icon5, 0, 0);
		
        }     
        GlStateManager.popMatrix();
        
       
        
        String s1 =icon.getDisplayName(); //Ladder
        String s2 = icon2.getDisplayName();//Spade
        String s3 = icon3.getDisplayName(); //Glowstone
        String s4 = icon4.getDisplayName(); //Torch
        String s5 = icon5.getDisplayName(); //Fractions Book
        drawTooltip(s1, mouseX, mouseY, centerX +10, centerY + 33, 22, 22);
        drawTooltip(s2, mouseX, mouseY, centerX +10, centerY + 58, 22, 22);
        drawTooltip(s3, mouseX, mouseY, centerX +10, centerY + 83, 22, 22);
        drawTooltip(s4, mouseX, mouseY, centerX +10, centerY + 108, 22, 22);
        drawTooltip(s5, mouseX, mouseY, centerX +10, centerY + 133, 22, 22);
        
      
    }
    
    public void drawTooltip(String line, int mouseX, int mouseY, int posX, int posY, int width, int height) {
        if (mouseX >= posX && mouseX <= posX + width && mouseY >= posY && mouseY <= posY + height) {
            drawCreativeTabHoveringText(line, mouseX, mouseY);
        }
    }
   
    

    
    @Override
    public void initGui() {
    	
        buttonList.clear();
        int centerY = (height / 2) - guiHeight / 2;
        
        buttonList.add(button1 = new GuiButton(BUTTON1, (width / 2) + 51, centerY + 33, 30, 20, "Buy"));
        buttonList.add(button2 = new GuiButton(BUTTON2, (width / 2) + 51, centerY + 59, 30, 20, "Buy"));
        buttonList.add(button3 = new GuiButton(BUTTON3, (width / 2) + 51, centerY + 83, 30, 20, "Buy"));
        buttonList.add(button4 = new GuiButton(BUTTON4, (width / 2) + 51, centerY + 109, 30, 20, "Buy"));
        buttonList.add(button5 = new GuiButton(BUTTON5, (width / 2) + 51, centerY + 133, 30, 20, "Buy"));
     
     
        super.initGui();
    }
    

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
    	
        switch (button.id) {
            case BUTTON1:
            	
            	if(TileEntityPointsBlock.playerScore >= 40){
            		mc.player.playSound(ModSoundHandler.MAWSOUND_COINDROP, 1.0f, 1.0f);
            		buttonvalue = 1;
            		Maw79Mod.NETWORK.sendToServer(new FarmerCoinsMessage(mc.player));
            		TileEntityPointsBlock.playerScore -= 40;
            	}
            	else {
            		mc.player.playSound(ModSoundHandler.MAWSOUND_ERRORNOISE, 1.0f, 1.0f);
            		System.out.println("Not Enough Points (for 1 - Ladder 40) :( ");
            	}
            	
            	break;
            	
            case BUTTON2:
            	
            	if(TileEntityPointsBlock.playerScore >= 50){
            		mc.player.playSound(ModSoundHandler.MAWSOUND_COINDROP, 1.0f, 1.0f);
            		buttonvalue = 2;
            		Maw79Mod.NETWORK.sendToServer(new FarmerCoinsMessage(mc.player));
            		TileEntityPointsBlock.playerScore -= 50;
            	}
            	else {
            		mc.player.playSound(ModSoundHandler.MAWSOUND_ERRORNOISE, 1.0f, 1.0f);
            		System.out.println("Not Enough Points (for 2 - Spade 50) :( ");
            	}
            	
            	break;
            	
            case BUTTON3:
            	
            	if(TileEntityPointsBlock.playerScore >= 30){
            		mc.player.playSound(ModSoundHandler.MAWSOUND_COINDROP, 1.0f, 1.0f);
            		buttonvalue = 3;
            		Maw79Mod.NETWORK.sendToServer(new FarmerCoinsMessage(mc.player));
            		TileEntityPointsBlock.playerScore -= 30;
            	}
            	else {
            		mc.player.playSound(ModSoundHandler.MAWSOUND_ERRORNOISE, 1.0f, 1.0f);
            		System.out.println("Not Enough Points (for 3 - Glowstone Pick 30) :( ");
            	}
            	
            	break;
            	
            case BUTTON4:
            
            	if(TileEntityPointsBlock.playerScore >= 40){
            		mc.player.playSound(ModSoundHandler.MAWSOUND_COINDROP, 1.0f, 1.0f);
            		buttonvalue = 4;
            		Maw79Mod.NETWORK.sendToServer(new FarmerCoinsMessage(mc.player));
            		TileEntityPointsBlock.playerScore -= 40;
            	}
            	else {
            		mc.player.playSound(ModSoundHandler.MAWSOUND_ERRORNOISE, 1.0f, 1.0f);
            		System.out.println("Not Enough Points (for 4 - Torch 40):( ");
            	}
            	
            	break;
            	
            case BUTTON5:
            	
            	if(TileEntityPointsBlock.playerScore >= 30){
            		mc.player.playSound(ModSoundHandler.MAWSOUND_COINDROP, 1.0f, 1.0f);
            		buttonvalue = 5;
            		Maw79Mod.NETWORK.sendToServer(new FarmerCoinsMessage(mc.player));
            		TileEntityPointsBlock.playerScore -= 30;
            	}
            	else {
            		mc.player.playSound(ModSoundHandler.MAWSOUND_ERRORNOISE, 1.0f, 1.0f);
            		System.out.println("Not Enough Points (for 5 - Pick 30) :( ");
            	}
            	
            	break;
            	
          
        }
      
        super.actionPerformed(button);
      
    }
    
   

    
 
	@Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException {
    
        super.keyTyped(typedChar, keyCode);
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
       
        
        super.mouseClicked(mouseX, mouseY, mouseButton);
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
    
    public void onEvent(){
    	System.out.println("ON EVENT HAS BEEN CALLED!");
    	
         
    }
    
}
	 