package com.maw79.mods.client.gui.mathsgui;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.maw79.mods.client.gui.GuiNotif;
import com.maw79.mods.handlers.ModSoundHandler;
import com.maw79.mods.main.Maw79Mod;
import com.maw79.mods.main.Reference;
import com.maw79.mods.network.store.StoreItem1Message;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class GuiMathsDivisionBlock extends GuiScreen {
	
	private static DecimalFormat df2 = new DecimalFormat(".##");
		double divmax = GuiNotif.divimax; 
	    double divimin = GuiNotif.divimin;
	    Random rand = new Random();
	    double randomNum1 = rand.nextInt((int)(( divmax - divimin)+1))+divimin;
	    double randomNum2 = rand.nextInt((int) (( divmax - divimin)+1))+divimin;
	    double randomNum3 = rand.nextInt((int) (( divmax - divimin)+1))+divimin;
	    double randanswer  = randomNum1 / randomNum2;
	    double randanswer2  = randanswer + 1;
	    double randanswer3  = randanswer - 1;
	    String question = randomNum1 + " ÷ " + randomNum2;
	    String number ="";
	    int answer = 0;  
	    
	
	final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/gui/division.png");
    int guiWidth = 175;
    int guiHeight = 210;
    
    String title = "Division";
    
   public static int buttonvalue = 0;
    
    
    GuiButton button1, button2, button3;
    final int BUTTON1 = 1, BUTTON2 = 2, BUTTON3 = 3;
    
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
        	GlStateManager.translate((width / 2) - fontRendererObj.getStringWidth(title), centerY + 10, 0);
            GlStateManager.scale(2, 2, 2);
            fontRendererObj.drawString(title, 0, 0, 0x6028ff);
           
        }
        GlStateManager.popMatrix();
        
       
        
        GlStateManager.pushMatrix();
        {
            GlStateManager.translate((width / 2), centerY + 10, 0);
            GlStateManager.scale(1.4, 1.4, 1.4);
           
            fontRendererObj.drawString( String.format("%.0f", randomNum1) + " ÷ " + (String.format("%.0f", randomNum2)), (-23), (20), 0xffffff);
    		fontRendererObj.drawString( String.format("%.2f", randanswer), (-23), (40), 0xffffff);
    		fontRendererObj.drawString( String.format("%.2f", randanswer2), (-23), (56), 0xffffff);
    		fontRendererObj.drawString( String.format("%.2f", randanswer3), (-23), (74), 0xffffff);
    		
        }
        GlStateManager.popMatrix();
        
        
        
       // button1.drawButton(mc, mouseX, mouseY);
       // button2.drawButton(mc, mouseX, mouseY);
        //button3.drawButton(mc, mouseX, mouseY);
       
      
        
        
        List<String> text = new ArrayList<String>();
        
       
        String s2 = "Hello Mate";
       
        drawTooltip2(s2, mouseX, mouseY, centerX +10, centerY + 58, 22, 22);
       
        
        //super.drawScreen(mouseX, mouseY, partialTicks);
    }
    
 
    public void drawTooltip2(String line, int mouseX, int mouseY, int posX, int posY, int width, int height) {
        if (mouseX >= posX && mouseX <= posX + width && mouseY >= posY && mouseY <= posY + height) {
            drawCreativeTabHoveringText(line, mouseX, mouseY);
        }
    }
   
    
    
    @Override
    public void initGui() {
    	int guiX = (width - guiWidth)/2;
    	int guiY = (height - guiHeight)/2; 
    	int centerY = (height / 2) - guiHeight / 2;
        buttonList.clear();
       
        
        buttonList.add(button1 = new GuiButton(BUTTON1, (width / 2) + 51, centerY + 59, 30, 20, "Submit"));
        buttonList.add(button2 = new GuiButton(BUTTON2, (width / 2) + 51, centerY + 83, 30, 20, "Submit"));
        buttonList.add(button3 = new GuiButton(BUTTON3, (width / 2) + 51, centerY + 109, 30, 20, "Submit"));
      
     
       
       
        super.initGui();
    }
    

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
    	
        switch (button.id) {
            case BUTTON1:
            	
            	if(GuiNotif.playerScore >= 100){
            		mc.player.playSound(ModSoundHandler.MAWSOUND_COINDROP, 1.0f, 1.0f);
            		buttonvalue = 1;
            		Maw79Mod.networkWrapper9.sendToServer(new StoreItem1Message(mc.player));
            		GuiNotif.playerScore -= 100;
            	}
            	else {
            		mc.player.playSound(ModSoundHandler.MAWSOUND_ERRORNOISE, 1.0f, 1.0f);
            		System.out.println("Not Enough Points (for 1) :( ");
            	}
            	
            	break;
            	
            case BUTTON2:
            	
            	if(GuiNotif.playerScore >= 100){
            		mc.player.playSound(ModSoundHandler.MAWSOUND_COINDROP, 1.0f, 1.0f);
            		buttonvalue = 2;
            		Maw79Mod.networkWrapper9.sendToServer(new StoreItem1Message(mc.player));
            		GuiNotif.playerScore -= 100;
            	}
            	else {
            		mc.player.playSound(ModSoundHandler.MAWSOUND_ERRORNOISE, 1.0f, 1.0f);
            		System.out.println("Not Enough Points (for 2) :( ");
            	}
            	
            	break;
            	
            case BUTTON3:
            	
            	if(GuiNotif.playerScore >= 100){
            		mc.player.playSound(ModSoundHandler.MAWSOUND_COINDROP, 1.0f, 1.0f);
            		buttonvalue = 3;
            		Maw79Mod.networkWrapper9.sendToServer(new StoreItem1Message(mc.player));
            		GuiNotif.playerScore -= 100;
            	}
            	else {
            		mc.player.playSound(ModSoundHandler.MAWSOUND_ERRORNOISE, 1.0f, 1.0f);
            		System.out.println("Not Enough Points (for 3) :( ");
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
        return true;
    }
    
    public void onEvent(){
    	System.out.println("ON EVENT HAS BEEN CALLED!");
    	
         
    }
    
}
	 