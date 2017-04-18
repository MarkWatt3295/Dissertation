package com.maw79.mods.client.gui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.maw79.mods.handlers.ModSoundHandler;
import com.maw79.mods.init.ModItems;
import com.maw79.mods.main.Maw79Mod;
import com.maw79.mods.main.Reference;
import com.maw79.mods.network.MathsMessage;
import com.maw79.mods.network.store.StoreItem1Message;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class GuiMathsQuestGive extends GuiScreen {
	
	public static int questnumber = 0;
	
     
	    
	
	final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/gui/store2.png");
    int guiWidth = 175;
    int guiHeight = 210;
    
    String title = "Maths Quest";
    
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
            GlStateManager.translate((width / 2), centerY + 10, 0);
            GlStateManager.scale(1.4, 1.4, 1.4);
           
            fontRendererObj.drawString("Active Quests : "+questnumber, (-40), (20), 0xffffff);
    		fontRendererObj.drawString("Prime Numbers", (-50), (40), 0xffffff);
    		fontRendererObj.drawString("Even Numbers", (-50), (56), 0xffffff);
    		fontRendererObj.drawString("Odd Numbers", (-50), (74), 0xffffff);
    		fontRendererObj.drawString("Sequence", (-50), (90), 0xffffff);
    		
        }
        
        
        GlStateManager.popMatrix();
        
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
    
  
    public void drawTooltip2(String line, int mouseX, int mouseY, int posX, int posY, int width, int height) {
        if (mouseX >= posX && mouseX <= posX + width && mouseY >= posY && mouseY <= posY + height) {
            drawCreativeTabHoveringText(line, mouseX, mouseY);
        }
    }
   
    

    
    @Override
    public void initGui() {
    	
        buttonList.clear();
        int centerY = (height / 2) - guiHeight / 2;
        
       // buttonList.add(button1 = new GuiButton(BUTTON1, (width / 2) + 51, centerY + 33, 30, 20, "Buy"));
        buttonList.add(button2 = new GuiButton(BUTTON2, (width / 2) + 51, centerY + 59, 30, 20, "Set"));
        buttonList.add(button3 = new GuiButton(BUTTON3, (width / 2) + 51, centerY + 83, 30, 20, "Set"));
        buttonList.add(button4 = new GuiButton(BUTTON4, (width / 2) + 51, centerY + 109, 30, 20, "Set"));
        buttonList.add(button5 = new GuiButton(BUTTON5, (width / 2) + 51, centerY + 133, 30, 20, "Set"));
      
     
       
        super.initGui();
    }
    

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
    	
        switch (button.id) {
            
            case BUTTON2: //PRIME NUMBERS
            		questnumber = 1;
            		mc.player.playSound(ModSoundHandler.MAWSOUND_FLYBY, 1.0f, 1.0f);
            	
            	break;
            	
            case BUTTON3://EVEN NUMBERS
            	
            	questnumber = 2;
        		mc.player.playSound(ModSoundHandler.MAWSOUND_FLYBY, 1.0f, 1.0f);
            	
            	break;
            	
            case BUTTON4: //ODD Numbers
            	questnumber = 3;
        		mc.player.playSound(ModSoundHandler.MAWSOUND_FLYBY, 1.0f, 1.0f);
            	break;
            	
            case BUTTON5:
            	
            	questnumber = 4; // NUMBER SEQUENCE
        		mc.player.playSound(ModSoundHandler.MAWSOUND_FLYBY, 1.0f, 1.0f);
            	
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
        return true;
    }
    
    public void onEvent(){
    	System.out.println("ON EVENT HAS BEEN CALLED!");
    	
         
    }
    
}
	 