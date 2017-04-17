package com.maw79.mods.client.gui.mathsgui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import com.maw79.mods.client.gui.GuiNotif;
import com.maw79.mods.handlers.ModSoundHandler;
import com.maw79.mods.main.Maw79Mod;
import com.maw79.mods.main.Reference;
import com.maw79.mods.network.MathsMessage;
import com.maw79.mods.util.Utils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class GuiAdditionBlock extends GuiScreen {
	
	   
	final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/gui/mathsblocks.png");
    int guiWidth = 175;
    int guiHeight = 228;
    
 
    String title = "Addition";
    
    int addmax = GuiNotif.addmax; 
    int addmin = GuiNotif.addmin;
    Random rand = new Random();
    int randomNum1 = rand.nextInt(( addmax - addmin)+1)+addmin;
    int randomNum2 = rand.nextInt(( addmax - addmin)+1)+addmin;
    int randanswer  = randomNum1 + randomNum2;
    String question = randomNum1 + " + " + randomNum2;
    String number ="";
    int answer = 0;
    GuiTextField textBox;
    GuiButton button1, button2, button3;
    final int BUTTON1 = 0, BUTTON2 = 2, BUTTON3 = 3;
    
    
    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {

        //drawDefaultBackground();
        Utils.getLogger().info("Title1 is: " + title);
    	Utils.getLogger().info("FRO1 is: " + fontRendererObj); //I think FRO becoming null is my issue
    	
        Minecraft.getMinecraft().renderEngine.bindTexture(texture);
        int centerX = (width / 2) - guiWidth / 2;
        int centerY = (height / 2) - guiHeight / 2;
        drawtext();
       
            
        textBox.drawTextBox();
        
      
        super.drawScreen(mouseX, mouseY, partialTicks);
       
        
    	Utils.getLogger().info("Title4 is: " + title);
    	Utils.getLogger().info("FRO is4: " + fontRendererObj);
    	
    	 List<String> text = new ArrayList<String>();
         text.add("§9"+"What is : "+ question +"§f"+ "\nInput your anwer in the text box then press the submit button. "
         		+ "If your Answer is correct you shall recieve a reward"); 
      
         drawTooltip(text, mouseX, mouseY, centerX +155, centerY +5, 15, 15);
      
    	
    }
   
    private void drawtext() {
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
       
         
             GlStateManager.scale(2, 2, 2);
         	Utils.getLogger().info("Title2 is: " + title);
         	Utils.getLogger().info("FRO2 is: " + fontRendererObj);
         
         	
            mc.fontRendererObj.drawString(title, centerX - 40, centerY, 0x6028ff);
         	Utils.getLogger().info("Title3 is: " + title);
         	Utils.getLogger().info("FRO3 is: " + fontRendererObj);
         	
         
             mc.fontRendererObj.drawString(question, centerX - 40, centerY + 20, 0x6028ff);
             GlStateManager.popMatrix();
             
	}
    
    

	public void drawTooltip(List<String> lines, int mouseX, int mouseY, int posX, int posY, int width, int height) {
        if (mouseX >= posX && mouseX <= posX + width && mouseY >= posY && mouseY <= posY + height) {
            drawHoveringText(lines, mouseX, mouseY);
        }
    }


    
    @Override
    public void initGui() {
    
        buttonList.add(button1 = new GuiButton(BUTTON1, (width / 2) - 100 / 2, height - 110, 100, 20, "§a"+"CORRECT"));
        buttonList.add(button2 = new GuiButton(BUTTON2, (width / 2) - 100 / 2, height - 130, 100, 20, "Submit"));
        buttonList.add(button3 = new GuiButton(BUTTON3, (width / 2) - 100 / 2, height - 110, 100, 20, ""));
        button1.visible = false;
        button1.enabled = false;
        textBox = new GuiTextField(0, fontRendererObj, (width / 2) - 100 / 2,   height - 150, 100, 20 );
        
        updateButtons();
        super.initGui();
    }
    

    public void updateButtons() {
    	Utils.getLogger().info("Random Answer = "+ randanswer);
    	Utils.getLogger().info("Player Answer = "+ answer);
    	Utils.getLogger().info("Addmax is: "+ addmax);
    	Utils.getLogger().info("Addmin is: "+ addmin);
    	
        if (answer == randanswer)  {
            onEvent();
         
        } else {
           
        	System.out.println("***************** [No Answer or Incorrect] *****************");
        }
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
   

 
    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
    	
        switch (button.id) {
            case BUTTON1:
            	Utils.getLogger().info("Correct Answer! Heres your reward");
            	GuiNotif.playerScore += 10;
            	mc.player.playSound(ModSoundHandler.STEEL_BUTTON_CLICK_OFF, 1.0f, 1.0f);
            	Maw79Mod.networkWrapper2.sendToServer(new MathsMessage(mc.player));
            	//mc.displayGuiScreen((GuiScreen)null);
            	mc.player.closeScreen();
            	
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
          button1.visible = true;
          button3.visible = false;
          button3.enabled = false;
          button1.enabled = true;  
    }
    
}
	 