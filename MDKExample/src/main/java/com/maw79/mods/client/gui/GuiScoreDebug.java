package com.maw79.mods.client.gui;

import java.io.IOException;
import com.maw79.mods.handlers.ModSoundHandler;
import com.maw79.mods.main.Maw79Mod;
import com.maw79.mods.main.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class GuiScoreDebug extends GuiScreen {
	
	   
	    
	
	final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/gui/playerlevel.png");
    int guiWidth = 175;
    int guiHeight = 210;
    
    String title = "Score Debug";
    
    GuiButton button1, button2, button3, button4, button5;
    final int BUTTON1 = 1, BUTTON2 = 2, BUTTON3 = 3, BUTTON4 = 4, BUTTON5 =5;
    
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
            fontRendererObj.drawString("§9"+title, 0, 0, 0x6028ff);
        }
            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();{
          
            
            
        }
        GlStateManager.popMatrix();
        super.drawScreen(mouseX, mouseY, partialTicks);
        
      
      
    }


    @Override
    public void initGui() {
    	
        buttonList.clear();
        buttonList.add(button5 = new GuiButton(BUTTON5, (width / 2) - 100 / 2, 45, 100, 20, "Score + 5"));
        buttonList.add(button4 = new GuiButton(BUTTON4, (width / 2) - 100 / 2,  70, 100, 20, "Score + 1000"));
        buttonList.add(button1 = new GuiButton(BUTTON1, (width / 2) - 100 / 2, 95, 100, 20, "Score + 10"));
        buttonList.add(button2 = new GuiButton(BUTTON2, (width / 2) - 100 / 2,  120, 100, 20, "Score + 100"));
        buttonList.add(button3 = new GuiButton(BUTTON3, (width / 2) - 100 / 2, 145, 100, 20, "Score = 0"));
       
        super.initGui();
    }
    

   
   public boolean blockreturn = false;
   
 
    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
    	
    	
        switch (button.id) {
            case BUTTON1:
           GuiNotif.playerScore += 10;
            	mc.player.playSound(ModSoundHandler.STEEL_BUTTON_CLICK_OFF, 1.0f, 1.0f);
            	break;
            	
            case BUTTON2:
            	  GuiNotif.playerScore += 100;
            	System.out.println(Maw79Mod.playerlevel);
            	mc.player.playSound(ModSoundHandler.STEEL_BUTTON_CLICK_OFF, 1.0f, 1.0f);
            
            	break;
            	
            case BUTTON3:
            	GuiNotif.playerScore =0;
            	mc.player.playSound(ModSoundHandler.STEEL_BUTTON_CLICK_OFF, 1.0f, 1.0f);
            	break;
            	
            case BUTTON4:
                GuiNotif.playerScore += 1000;
                 	mc.player.playSound(ModSoundHandler.STEEL_BUTTON_CLICK_OFF, 1.0f, 1.0f);
                 	break;
                 	
            case BUTTON5:
                GuiNotif.playerScore += 5;
                 	mc.player.playSound(ModSoundHandler.STEEL_BUTTON_CLICK_OFF, 1.0f, 1.0f);
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
    
  
    
}
	 