package com.maw79.mods.client.gui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.lwjgl.input.Mouse;

import com.maw79.mods.blocks.BlockTestBlock3;
import com.maw79.mods.handlers.AchievementHandler;
import com.maw79.mods.handlers.DropHandler;
import com.maw79.mods.handlers.ModEventHandler;
import com.maw79.mods.handlers.ModSoundHandler;
import com.maw79.mods.init.ModBlocks;
import com.maw79.mods.init.ModItems;
import com.maw79.mods.main.Maw79Mod;
import com.maw79.mods.main.Reference;
import com.maw79.mods.mathsworld.mathBlockStates;
import com.maw79.mods.network.MathsMessage;
import com.maw79.mods.network.TeleportMessage;
import com.maw79.mods.util.Utilities;
import com.maw79.mods.util.Utils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiLabel;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GuiMathsMultiplicationBlock1 extends GuiScreen {
	
	   
	    
	
	final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/gui/mathsblocks.png");
    int guiWidth = 175;
    int guiHeight = 228;
    
 
    
    String title = "Multiplication";
    
    int multimax = GuiNotif.multimax; 
    int multimin = GuiNotif.multimin;
    Random rand = new Random();
    int randomNum1 = rand.nextInt(( multimax - multimin)+1)+multimin;
    int randomNum2 = rand.nextInt(( multimax - multimin)+1)+multimin;
    int randanswer  = randomNum1 * randomNum2;
    String question = randomNum1 + " X " + randomNum2;
    String number ="";
    int answer = 0;
    GuiTextField textBox;
    GuiButton button1, button2, button3;
    final int BUTTON1 = 0, BUTTON2 = 2, BUTTON3 = 3;
    
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
            
            GlStateManager.pushMatrix();{
            GlStateManager.translate((width / 2) - fontRendererObj.getStringWidth(question), centerY + 10, 0);
            GlStateManager.scale(2, 2, 2);
            fontRendererObj.drawString(question, 1, 15, 0x6028ff);
            
            
        }
        GlStateManager.popMatrix();
        super.drawScreen(mouseX, mouseY, partialTicks);
        button1.drawButton(mc, mouseX, mouseY);
        textBox.drawTextBox();
   
        List<String> text = new ArrayList<String>();
        text.add("§9"+"What is : "+ question +"§f"+ "\nInput your anwer in the text box then press the submit button. "
        		+ "If your Answer is correct you shall recieve a reward"); 
     
        drawTooltip(text, mouseX, mouseY, centerX +155, centerY +5, 15, 15);
    }

    public void drawTooltip(List<String> lines, int mouseX, int mouseY, int posX, int posY, int width, int height) {
        if (mouseX >= posX && mouseX <= posX + width && mouseY >= posY && mouseY <= posY + height) {
            drawHoveringText(lines, mouseX, mouseY);
        }
    }

    
    @Override
    public void initGui() {
    	
        buttonList.clear();
        buttonList.add(button1 = new GuiButton(BUTTON1, (width / 2) - 100 / 2, height - 110, 100, 20, "§a"+"CORRECT"));
        buttonList.add(button2 = new GuiButton(BUTTON2, (width / 2) - 100 / 2, height - 130, 100, 20, "Submit"));
        buttonList.add(button3 = new GuiButton(BUTTON3, (width / 2) - 100 / 2, height - 110, 100, 20, ""));
        button1.visible = false;
        button1.enabled = false;
        textBox = new GuiTextField(0, fontRendererObj, (width / 2) - 100 / 2,   80, 100, 20 );//0,0,0,box height
        updateButtons();
        super.initGui();
    }
    

    public void updateButtons() {
    	
    	System.out.println("***************** [Random Answer: "+ randanswer+" ]"  + " *****************");
    	System.out.println("***************** [Player Answer: "+ answer+" ]"  + " *****************");
    	System.out.println("***************** [Multimax is: "+ multimax+" ]"  + " *****************");
    	System.out.println("***************** [Multimin is: "+ multimin+" ]"  + " *****************");
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
   
   public boolean blockreturn = false;
 
    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
    	
        switch (button.id) {
            case BUTTON1:
       
            	Utils.getLogger().info("Correct Answer! Heres your reward");
            	GuiNotif.playerScore += 10;
            	mc.player.playSound(ModSoundHandler.STEEL_BUTTON_CLICK_OFF, 1.0f, 1.0f);
            	Maw79Mod.networkWrapper2.sendToServer(new MathsMessage(mc.player));
            	
            	mc.displayGuiScreen((GuiScreen)null);
            	
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
	 