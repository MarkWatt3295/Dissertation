package com.maw79.mods.client.gui.profilerpages;



import java.io.IOException;

import com.maw79.mods.handlers.ModSoundHandler;
import com.maw79.mods.main.Maw79Mod;
import com.maw79.mods.main.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class GuiProfilerObsidianIngot extends GuiScreen {
	
	   
	    
	
	final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/gui/playerlevel.png");
    int guiWidth = 175;
    int guiHeight = 210;
    
   
    public static String title = "Obsidian Ingot";
    
   
    
    GuiButton button1, button2, button3, button4;
    final int BUTTON1 = 1, BUTTON2 = 2, BUTTON3 = 3, BUTTON4 = 4;
    
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
        buttonList.add(button1 = new GuiButton(BUTTON1, (width / 2) - 170 / 2, (height/2) -5, 40, 20, "Reset"));
        buttonList.add(button2 = new GuiButton(BUTTON2, (width / 2) + 80 / 2, (height/2) -50, 30, 20, "Back"));
        buttonList.add(button3 = new GuiButton(BUTTON3, (width / 2) -20 / 2, (height/2) -5, 40, 20, "Pause"));
        
        super.initGui();
    }
    

   
    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
    	
    	
        switch (button.id) {
            case BUTTON1:
     
            	mc.player.playSound(ModSoundHandler.STEEL_BUTTON_CLICK_OFF, 1.0f, 1.0f);
            	mc.displayGuiScreen((GuiScreen)null);

            	
            	break;
            	
            case BUTTON2:
            	
            	System.out.println(Maw79Mod.playerlevel);
            	mc.player.playSound(ModSoundHandler.STEEL_BUTTON_CLICK_OFF, 1.0f, 1.0f);
            	mc.displayGuiScreen((GuiScreen)null);
            	break;
            	
            case BUTTON3:
            	
            	mc.player.playSound(ModSoundHandler.STEEL_BUTTON_CLICK_OFF, 1.0f, 1.0f);
            	mc.displayGuiScreen((GuiScreen)null);
            	break;
            	
          
        }
        
        super.actionPerformed(button);
      
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
    	mc.displayGuiScreen((GuiScreen)null);
    	
         
    }
    
}
	 