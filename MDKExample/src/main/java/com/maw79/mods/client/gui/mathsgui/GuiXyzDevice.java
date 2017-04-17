package com.maw79.mods.client.gui.mathsgui;

import java.io.IOException;
import com.maw79.mods.handlers.ModSoundHandler;
import com.maw79.mods.main.Maw79Mod;
import com.maw79.mods.main.Reference;
import com.maw79.mods.network.NXmanagerMessage;
import com.maw79.mods.network.NYmanagerMessage;
import com.maw79.mods.network.NZmanagerMessage;
import com.maw79.mods.network.XmanagerMessage;
import com.maw79.mods.network.YmanagerMessage;
import com.maw79.mods.network.ZmanagerMessage;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentString;

public class GuiXyzDevice extends GuiScreen {
	
	   
	    
	
	final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/gui/playerlevel.png");
    int guiWidth = 175;
    int guiHeight = 210;
    
    String title = "XYZ Device";
    
    String question = "Hello";
    String number ="";
    public static int answer = 0;
   
    GuiTextField textBox;
    GuiButton button1, button2, button3, button4, button5, button6, button7;
    final int BUTTON1 = 1, BUTTON2 = 2, BUTTON3 = 3, BUTTON4 = 4, BUTTON5 = 5, 
    		BUTTON6 = 6, BUTTON7 = 7, BUTTON8 = 8, BUTTON9 = 9, BUTTON10 = 10;
    
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
            GlStateManager.pushMatrix();{
           // GlStateManager.translate((width / 2) - fontRendererObj.getStringWidth(question), centerY + 10, 0);
          //  GlStateManager.scale(2, 2, 2);
           // fontRendererObj.drawString(question, 1, 15, 0x6028ff);
            
            
        }
        GlStateManager.popMatrix();
        super.drawScreen(mouseX, mouseY, partialTicks);
        button1.drawButton(mc, mouseX, mouseY);
      
       
        textBox.drawTextBox();
       
      
      
    }


    
    @Override
    public void initGui() {
    	
        buttonList.clear();
        
        textBox = new GuiTextField(0, fontRendererObj, (width / 2) - 100 / 2,   60, 100, 20 );//0,0,0,box height
        buttonList.add(button1 = new GuiButton(BUTTON1, (width / 2) - 100 / 2, 85, 50, 20, "§4"+"+ X"));
        buttonList.add(button2 = new GuiButton(BUTTON2, (width / 2), 85, 50, 20, "§4"+"- X"));
        
        buttonList.add(button3 = new GuiButton(BUTTON3, (width / 2) - 100 / 2,  110, 50, 20, "§a"+"+ Y"));
        buttonList.add(button4 = new GuiButton(BUTTON4, (width / 2),  110, 50, 20, "§a"+"- Y"));
        
        buttonList.add(button5 = new GuiButton(BUTTON3, (width / 2) - 100 / 2, 135, 50, 20, "§9"+"+ Z"));
        buttonList.add(button6 = new GuiButton(BUTTON4, (width / 2), 135, 50, 20, "§9"+"- Z"));
        
        buttonList.add(button7 = new GuiButton(BUTTON7, (width / 2) - 100 / 2, 155, 100, 20, "LAND"));
        
       /* buttonList.add(button1 = new GuiButton(BUTTON1, (width / 2) - 100 / 2, 85, 100, 20, "§4"+"X"));
        buttonList.add(button2 = new GuiButton(BUTTON2, (width / 2) - 100 / 2,  110, 100, 20, "§a"+"Y"));
        buttonList.add(button3 = new GuiButton(BUTTON3, (width / 2) - 100 / 2, 135, 100, 20, "§9"+"Z"));
        buttonList.add(button4 = new GuiButton(BUTTON4, (width / 2) - 100 / 2, 155, 100, 20, "LAND"));
        buttonList.add(button5 = new GuiButton(BUTTON5, (width / 2) - 100 / 2, 175, 50, 20, "- X"));
        buttonList.add(button6 = new GuiButton(BUTTON6, (width / 2) , 175, 50, 20, "+ X"));*/
     
        updateButtons();
        super.initGui();
    }
    

    public void updateButtons() {
    	
      //  if (answer == randanswer)  {
            onEvent();
         
       // } else {
           
      //  }
    }


    public  void updateTextBoxes() {
        if (!textBox.getText().isEmpty()) {
            if (!textBox.isFocused()) {
            	number = textBox.getText();
          	  try {
              answer=Integer.parseInt(number);
          	  } catch (NumberFormatException e) {
              System.out.println(answer);
          	  }
            }
        }
       updateButtons();
    }
   
   public boolean blockreturn = false;
 
    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
    	if(answer >= 20){
    		answer = 20;
    		mc.player.sendMessage(new TextComponentString("Cannot Go Higher than 20 Blocks"));
    	}
    	updateTextBoxes();
        switch (button.id) {
            case BUTTON1:
       
            	mc.player.sendMessage(new TextComponentString("X Pressed with Answer as: "+answer));
            	Maw79Mod.NETWORK.sendToServer(new XmanagerMessage(mc.player));
            	mc.player.setNoGravity(true);
            	mc.displayGuiScreen((GuiScreen)null);
            	 mc.player.playSound(ModSoundHandler.MAWSOUND_FLYBY, 1.0f, 1.0f);
            	break;
            	
            case BUTTON2:
            	mc.player.sendMessage(new TextComponentString("-X Pressed with Answer as: "+answer));
            	Maw79Mod.NETWORK.sendToServer(new NXmanagerMessage(mc.player));
            	mc.player.setNoGravity(true);
            	mc.displayGuiScreen((GuiScreen)null);
            	 mc.player.playSound(ModSoundHandler.MAWSOUND_FLYBY, 2.0f, 2.0f);
            	break;
            	
            case BUTTON3:
            	mc.player.sendMessage(new TextComponentString("Y Pressed with Answer as: "+answer));
            	Maw79Mod.NETWORK.sendToServer(new YmanagerMessage(mc.player));
            	mc.player.setNoGravity(true);
            	mc.displayGuiScreen((GuiScreen)null);
            	 mc.player.playSound(ModSoundHandler.MAWSOUND_FLYBY, 1.0f, 1.0f);
            	break;
            	
            case BUTTON4:
            	mc.player.sendMessage(new TextComponentString("-Y Pressed with Answer as: "+answer));
            	Maw79Mod.NETWORK.sendToServer(new NYmanagerMessage(mc.player));
            	mc.player.setNoGravity(true);
            	mc.displayGuiScreen((GuiScreen)null);
            	 mc.player.playSound(ModSoundHandler.MAWSOUND_FLYBY, 3.0f, 3.0f);
            	break;
            	
            case BUTTON5:
            	mc.player.sendMessage(new TextComponentString("Z Pressed with Answer as: "+answer));
            	Maw79Mod.NETWORK.sendToServer(new ZmanagerMessage(mc.player));
            	mc.player.setNoGravity(true);
            	mc.displayGuiScreen((GuiScreen)null);
            	 mc.player.playSound(ModSoundHandler.MAWSOUND_FLYBY, 1.0f, 1.0f);
            	break;
            	
            case BUTTON6:
            	mc.player.sendMessage(new TextComponentString("-Z Pressed with Answer as: "+answer));
            	Maw79Mod.NETWORK.sendToServer(new NZmanagerMessage(mc.player));
            	mc.player.setNoGravity(true);
            	mc.displayGuiScreen((GuiScreen)null);
            	 mc.player.playSound(ModSoundHandler.MAWSOUND_FLYBY, 4.0f, 4.0f);
            	
            	break;
            	
            case BUTTON7:
            	mc.player.sendMessage(new TextComponentString("DEBUG Pressed with Gravity as: "+answer));
            	mc.player.setNoGravity(false);
            	mc.displayGuiScreen((GuiScreen)null);
            	 mc.player.playSound(ModSoundHandler.MAWSOUND_FLYBY, 5.0f, 5.0f);
            	mc.player.setNoGravity(false);
            	break;
     
        }
        updateButtons();
        super.actionPerformed(button);
      
    }
    
   

    
 
	@Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException {
        textBox.textboxKeyTyped(typedChar, keyCode);
        updateTextBoxes();
        super.keyTyped(typedChar, keyCode);
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        textBox.mouseClicked(mouseX, mouseY, mouseButton);
        updateTextBoxes();
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
	 