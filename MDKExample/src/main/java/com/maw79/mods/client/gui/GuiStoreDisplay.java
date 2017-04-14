package com.maw79.mods.client.gui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.maw79.mods.handlers.ModSoundHandler;
import com.maw79.mods.init.ModItems;
import com.maw79.mods.main.Maw79Mod;
import com.maw79.mods.main.Reference;
import com.maw79.mods.network.MathsMessage;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class GuiStoreDisplay extends GuiScreen {
	
	   
	    
	
	final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/gui/store2.png");
    int guiWidth = 175;
    int guiHeight = 210;
    
    String title = "Store";
    public static String calcquestion = "null";
    
   
    //GuiTextField textBox;
    GuiButton button1, button2, button3, button4, button5;
    final int BUTTON1 = 1, BUTTON2 = 2, BUTTON3 = 3, BUTTON4 = 4, BUTTON5 = 5;
    
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
        
        GlStateManager.pushMatrix();
        {
            GlStateManager.translate((width / 2), centerY + 10, 0);
            GlStateManager.scale(1.4, 1.4, 1.4);
           
            fontRendererObj.drawString("100 Points", (-23), (20), 0xffffff);
    		fontRendererObj.drawString("100 Points", (-23), (40), 0xffffff);
    		fontRendererObj.drawString("100 Points", (-23), (56), 0xffffff);
    		fontRendererObj.drawString("100 Points", (-23), (74), 0xffffff);
    		fontRendererObj.drawString("500 Points", (-23), (90), 0xffffff);
    		
        }
        GlStateManager.popMatrix();
        
        
        
        button1.drawButton(mc, mouseX, mouseY);
        button2.drawButton(mc, mouseX, mouseY);
        button3.drawButton(mc, mouseX, mouseY);
        button4.drawButton(mc, mouseX, mouseY);
        button5.drawButton(mc, mouseX, mouseY);
        ItemStack icon = new ItemStack(ModItems.MATHS_TOKEN);
        ItemStack icon2 = new ItemStack(ModItems.ENGLISH_TOKEN);
        ItemStack icon3 = new ItemStack(ModItems.SCIENCE_TOKEN);
        ItemStack icon4 = new ItemStack(ModItems.HISTORY_TOKEN);
        ItemStack icon5 = new ItemStack(ModItems.FREEPLAY_TOKEN);
        
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
        
        List<String> text = new ArrayList<String>();
        
        text.add(icon.getDisplayName()); //MATHS
        String s2 = icon2.getDisplayName();//ENGLISH
        String s3 = icon3.getDisplayName(); //SCIENCE
        String s4 = icon4.getDisplayName(); //HISTORY
        String s5 = icon5.getDisplayName(); //FREEPLAY
        drawTooltip(text, mouseX, mouseY, centerX +10, centerY + 33, 22, 22);
        drawTooltip2(s2, mouseX, mouseY, centerX +10, centerY + 58, 22, 22);
        drawTooltip2(s3, mouseX, mouseY, centerX +10, centerY + 83, 22, 22);
        drawTooltip2(s4, mouseX, mouseY, centerX +10, centerY + 108, 22, 22);
        drawTooltip2(s5, mouseX, mouseY, centerX +10, centerY + 133, 22, 22);
        
      
    }
    
    public void drawTooltip(List<String> lines, int mouseX, int mouseY, int posX, int posY, int width, int height) {
        if (mouseX >= posX && mouseX <= posX + width && mouseY >= posY && mouseY <= posY + height) {
            drawHoveringText(lines, mouseX, mouseY);
        }
    }
    public void drawTooltip2(String line, int mouseX, int mouseY, int posX, int posY, int width, int height) {
        if (mouseX >= posX && mouseX <= posX + width && mouseY >= posY && mouseY <= posY + height) {
            drawCreativeTabHoveringText(line, mouseX, mouseY);
        }
    }
    public void drawTooltip3(String line, int mouseX, int mouseY, int posX, int posY, int width, int height) {
        if (mouseX >= posX && mouseX <= posX + width && mouseY >= posY && mouseY <= posY + height) {
            drawCreativeTabHoveringText(line, mouseX, mouseY);
        }
    }

    

    
    @Override
    public void initGui() {
    	
        buttonList.clear();
        int centerY = (height / 2) - guiHeight / 2;
        
        buttonList.add(button1 = new GuiButton(BUTTON1, (width / 2) + 51, centerY + 33, 30, 20, "Buy"));
        buttonList.add(button2 = new GuiButton(BUTTON2, (width / 2) + 51, centerY + 59, 30, 20, "Buy2"));
        buttonList.add(button3 = new GuiButton(BUTTON3, (width / 2) + 51, centerY + 83, 30, 20, "Buy3"));
        buttonList.add(button4 = new GuiButton(BUTTON4, (width / 2) + 51, centerY + 109, 30, 20, "Buy4"));
        buttonList.add(button5 = new GuiButton(BUTTON5, (width / 2) + 51, centerY + 133, 30, 20, "Buy5"));
     
       
       
        super.initGui();
    }
    

   
   public boolean blockreturn = false;
   
 
    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
    	
        switch (button.id) {
            case BUTTON1:
       
            	mc.player.playSound(ModSoundHandler.STEEL_BUTTON_CLICK_OFF, 1.0f, 1.0f);
            	if(GuiNotif.playerScore >= 100){
            		Maw79Mod.networkWrapper2.sendToServer(new MathsMessage(mc.player));
            		GuiNotif.playerScore -= 100;
            	}
            	else {
            		System.out.println("Not Enough Points :( ");
            	}
            	//mc.displayGuiScreen((GuiScreen)null);

            	
            	break;
            	
            case BUTTON2:
            	  GuiNotif.playerlevel ="2";
            	System.out.println(Maw79Mod.playerlevel);
            	mc.player.playSound(ModSoundHandler.STEEL_BUTTON_CLICK_OFF, 1.0f, 1.0f);
            	mc.displayGuiScreen((GuiScreen)null);
            	break;
            	
            case BUTTON3:
            	GuiNotif.playerlevel ="3";
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
	 