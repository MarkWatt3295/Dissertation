package com.maw79.mods.client.gui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.maw79.mods.blocks.mathsblocks.questblock.TileEntityMathsQuest;
import com.maw79.mods.blocks.pointsblocks.TileEntityPointsBlock;
import com.maw79.mods.handlers.ModSoundHandler;
import com.maw79.mods.init.ModItems;
import com.maw79.mods.main.Maw79Mod;
import com.maw79.mods.main.Reference;
import com.maw79.mods.network.MathsMessage;
import com.maw79.mods.network.MathsQuestManualMessage;
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
	
	
	    
	
	final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/gui/quest.png");
    int guiWidth = 175;
    int guiHeight = 210;
    
    String title = "Maths Quest";
    
   public static int buttonvalue = 0;
    
   
    GuiButton button1, button2, button3, button4, button5, button2alt, button3alt,
    button4alt, button5alt;
    final int BUTTON1 = 1, BUTTON2 = 2, BUTTON3 = 3, BUTTON4 = 4, BUTTON5 = 5, BUTTON6 = 6,
    		BUTTON2alt = 22, BUTTON3alt = 33, BUTTON4alt = 44, BUTTON5alt = 55;
    
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
          
            fontRendererObj.drawString("Active Quest : "+questnumber, (-40), (20), 0xffffff);
    		fontRendererObj.drawString("§c"+TileEntityMathsQuest.questPrimeNumbers, (-50), (40), 0xffffff);
    		fontRendererObj.drawString("§d"+TileEntityMathsQuest.questEvenNumbers, (-50), (56), 0xffffff);
    		fontRendererObj.drawString("§6"+TileEntityMathsQuest.questOddNumbers, (-50), (74), 0xffffff);
    		fontRendererObj.drawString("§2"+TileEntityMathsQuest.questNumberSequence, (-50), (90), 0xffffff);
    		
        }
        
        
        GlStateManager.popMatrix();
        
        super.drawScreen(mouseX, mouseY, partialTicks);
        
        List<String> text = new ArrayList<String>();
        text.add("§9"+"QUEST INFORMATION" +"§f"+ "\nSelect a Quest below. Explore and dig in the mines below and try to find Number"
        		+ " Blocks that match the Quest criteria. Bring any blocks you find to the Maths Quest Block."
        		+ " Upon completion of a quest you will recieve a reward.\n\n"
        		+ "All Quests Numbers range from "+"§9"+ "1 - 20"+"§f"+ " with the exception of the Number Sequence Quest."
        				+ "\n\nMore help on quests can be found at the Quest block."); 
     
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
        int centerY = (height / 2) - guiHeight / 2;
        
		if (TileEntityMathsQuest.primecomplete == false) {
			buttonList.add(button2 = new GuiButton(BUTTON2, (width / 2) + 40, centerY + 59, 36, 20, "Select"));
		}
		buttonList.add(button2alt = new GuiButton(BUTTON2alt, (width / 2), centerY + 59, 80, 20, "Claim Reward"));
		
		
		if (TileEntityMathsQuest.evencomplete == false) {
			buttonList.add(button3 = new GuiButton(BUTTON3, (width / 2) + 40, centerY + 83, 36, 20, "Select"));
		}
		buttonList.add(button3alt = new GuiButton(BUTTON3alt, (width / 2), centerY + 83, 80, 20, "Claim Reward"));

		
		if (TileEntityMathsQuest.oddcomplete == false) {
		buttonList.add(button4 = new GuiButton(BUTTON4, (width / 2) + 40, centerY + 109, 36, 20, "Select"));
		}
		buttonList.add(button4alt = new GuiButton(BUTTON4alt, (width / 2), centerY + 109, 80, 20, "Claim Reward"));
		
		
		if (TileEntityMathsQuest.sequencecomplete == false) {
			buttonList.add(button5 = new GuiButton(BUTTON5, (width / 2) + 40, centerY + 133, 36, 20, "Select"));
		}
		buttonList.add(button5alt = new GuiButton(BUTTON5alt, (width / 2), centerY + 133, 80, 20, "Claim Reward"));
		
		
		button2alt.visible = false;
		button3alt.visible = false;
		button4alt.visible = false;
		button5alt.visible = false;
        
        //Sequence
        if(TileEntityMathsQuest.sequenceclaimed == false){
      if(TileEntityMathsQuest.sequencecomplete == true){
    	  button5alt.visible=true;
    	  
      }
        }
        
       //Prime 
        if(TileEntityMathsQuest.primeclaimed == false){
      if(TileEntityMathsQuest.primecomplete == true){
    	  button2alt.visible=true;
      }
        }
        
        //Even 
        if(TileEntityMathsQuest.evenclaimed == false){
      if(TileEntityMathsQuest.evencomplete == true){
    	  button3alt.visible=true;
      }
        }
        
        //Odd 
        if(TileEntityMathsQuest.oddclaimed == false){
      if(TileEntityMathsQuest.oddcomplete == true){
    	  button4alt.visible=true;
      }
        }
     
       
        super.initGui();
    }
    

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
    	
        switch (button.id) {
            
            case BUTTON2: //PRIME NUMBERS
            		questnumber = 1;
            		mc.player.playSound(ModSoundHandler.STEEL_BUTTON_CLICK_OFF, 1.0f, 1.0f);
            	if(TileEntityMathsQuest.primeBookGive == false){
            		Maw79Mod.NETWORK.sendToServer(new MathsQuestManualMessage(mc.player));
            		TileEntityMathsQuest.primeBookGive = true;
            	}
            	break;
            	
            case BUTTON2alt:
            	// Prime NUMBER 
        		mc.player.playSound(ModSoundHandler.STEEL_BUTTON_CLICK_OFF, 1.0f, 1.0f);
        		TileEntityPointsBlock.playerScore +=50;
        		button2alt.visible=false;
        		questnumber = 0;
        		TileEntityMathsQuest.primeclaimed = true;
            	break;
            	
            	
            	
            	
            case BUTTON3://EVEN NUMBERS
            	questnumber = 2;
        		mc.player.playSound(ModSoundHandler.STEEL_BUTTON_CLICK_OFF, 1.0f, 1.0f);
        		if(TileEntityMathsQuest.evenBookGive == false){
        			Maw79Mod.NETWORK.sendToServer(new MathsQuestManualMessage(mc.player));
            		TileEntityMathsQuest.evenBookGive = true;
            	}
            	break;
            	
            case BUTTON3alt:
            	// Even NUMBER 
        		mc.player.playSound(ModSoundHandler.STEEL_BUTTON_CLICK_OFF, 1.0f, 1.0f);
        		TileEntityPointsBlock.playerScore +=50;
        		button3alt.visible=false;
        		questnumber = 0;
        		TileEntityMathsQuest.evenclaimed = true;
            	break;
            	
            	
            	
            	
            case BUTTON4: //ODD Numbers
            	questnumber = 3;
        		mc.player.playSound(ModSoundHandler.STEEL_BUTTON_CLICK_OFF, 1.0f, 1.0f);
        		if(TileEntityMathsQuest.oddBookGive == false){
        			Maw79Mod.NETWORK.sendToServer(new MathsQuestManualMessage(mc.player));
            		TileEntityMathsQuest.oddBookGive = true;
            	}
            	break;
            	
            case BUTTON4alt:
            	// Odd NUMBER 
        		mc.player.playSound(ModSoundHandler.STEEL_BUTTON_CLICK_OFF, 1.0f, 1.0f);
        		TileEntityPointsBlock.playerScore +=50;
        		button4alt.visible=false;
        		questnumber = 0;
        		TileEntityMathsQuest.oddclaimed = true;
            	break;
            	
            	
           
            	
            case BUTTON5:
            	questnumber = 4; // NUMBER SEQUENCE
        		mc.player.playSound(ModSoundHandler.STEEL_BUTTON_CLICK_OFF, 1.0f, 1.0f);
        		if(TileEntityMathsQuest.seqBookGive == false){
        			Maw79Mod.NETWORK.sendToServer(new MathsQuestManualMessage(mc.player));
            		TileEntityMathsQuest.seqBookGive = true;
            	}
            	break;
            	
            case BUTTON5alt:
            	// NUMBER SEQUENCE
        		mc.player.playSound(ModSoundHandler.STEEL_BUTTON_CLICK_OFF, 1.0f, 1.0f);
        		TileEntityPointsBlock.playerScore +=50;
        		button5alt.visible=false;
        		TileEntityMathsQuest.sequenceclaimed = true;
        		questnumber = 0;
        		
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
	 