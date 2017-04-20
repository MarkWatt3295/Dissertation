package com.maw79.mods.client.gui;

import java.io.IOException;

import com.maw79.mods.handlers.ModEventHandler;
import com.maw79.mods.handlers.ModSoundHandler;
import com.maw79.mods.main.Maw79Mod;
import com.maw79.mods.main.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class GuiGameType extends GuiScreen {
	
	
	final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/gui/playerlevel.png");
    int guiWidth = 175;
    int guiHeight = 210;
    
    String title = "GameType";
    
   
    String number ="";
    public static int answer = 0;
   
   // GuiTextField textBox;
    GuiButton button1, button2;
    final int BUTTON1 = 1, BUTTON2 = 2;
    
    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        drawDefaultBackground();
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
            GlStateManager.translate((width / 2) - fontRendererObj.getStringWidth(title), centerY + 10, 0);
            GlStateManager.scale(2, 2, 2);
            fontRendererObj.drawString(title, 0, 0, 0x6028ff);
        }
            GlStateManager.popMatrix();
           
        super.drawScreen(mouseX, mouseY, partialTicks);
      
      
      
    }


    
    @Override
    public void initGui() {
    	
        buttonList.clear();
        
        
        buttonList.add(button1 = new GuiButton(BUTTON1, (width / 2) - 100 / 2, 85, 100, 20, "§4"+"Admin"));
        buttonList.add(button2 = new GuiButton(BUTTON2, (width / 2) - 100 / 2,  110, 100, 20, "§a"+"Standard Player"));
        //buttonList.add(button3 = new GuiButton(BUTTON3, (width / 2) - 100 / 2, 135, 100, 20, "§9"+"Level 3"));
      

       
        super.initGui();
    }
    



   

 
    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
    	
    	
        switch (button.id) {
            case BUTTON1:
            	  ModEventHandler.adminmode = true;
            		System.out.println( ModEventHandler.adminmode);
            	mc.player.playSound(ModSoundHandler.STEEL_BUTTON_CLICK_OFF, 1.0f, 1.0f);
            	mc.displayGuiScreen((GuiScreen)null);

            	
            	break;
            	
            case BUTTON2:
            ModEventHandler.adminmode = false;
            	System.out.println( ModEventHandler.adminmode);
            	mc.player.playSound(ModSoundHandler.STEEL_BUTTON_CLICK_OFF, 1.0f, 1.0f);
            	mc.displayGuiScreen((GuiScreen)null);
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
	 