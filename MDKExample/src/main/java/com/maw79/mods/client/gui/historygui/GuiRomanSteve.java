package com.maw79.mods.client.gui.historygui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.maw79.mods.blocks.historyblocks.romanquests.TileEntityRomanQuest;
import com.maw79.mods.blocks.mathsblocks.coordinatesquest.TileEntityCoordinatesQuest;
import com.maw79.mods.blocks.mathsblocks.questblock.TileEntityMathsQuest;
import com.maw79.mods.blocks.pointsblocks.TileEntityPointsBlock;
import com.maw79.mods.client.gui.GuiNotif;
import com.maw79.mods.handlers.ModSoundHandler;
import com.maw79.mods.init.ModItems;
import com.maw79.mods.main.Maw79Mod;
import com.maw79.mods.main.Reference;
import com.maw79.mods.network.FractionsManualMessage;
import com.maw79.mods.network.MathsMessage;
import com.maw79.mods.network.MathsQuestManualMessage;
import com.maw79.mods.network.RomanQuestMessage;
import com.maw79.mods.network.store.StoreItem1Message;
import com.maw79.mods.network.store.XYZMessage;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class GuiRomanSteve extends GuiScreen {
	
	public static int questnumber = 0;
	
	final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/gui/roman_quest.png");
    int guiWidth = 175;
    int guiHeight = 210;
    
    String title = "Roman Quests";
    
   public static int buttonvalue = 0;
    
   
    GuiButton button1, button2, button3, button4, button5, button2alt, button3alt,
    button4alt, button5alt;
    final int BUTTON1 = 1, BUTTON2 = 2, BUTTON3 = 3, BUTTON4 = 4, 
    		BUTTON2alt = 22, BUTTON3alt = 33, BUTTON4alt = 44;
    
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
    		fontRendererObj.drawString("§c"+TileEntityRomanQuest.buildertitle, (-50), (40), 0xffffff);
    		fontRendererObj.drawString("§d"+TileEntityRomanQuest.relichunttitle, (-50), (56), 0xffffff);
    		fontRendererObj.drawString("§6"+TileEntityRomanQuest.romanquiztitle, (-50), (74), 0xffffff);
    
        }
        
        
        GlStateManager.popMatrix();
        
        super.drawScreen(mouseX, mouseY, partialTicks);
        
        List<String> text = new ArrayList<String>();
        text.add("§9"+"QUEST INFORMATION" +"§f"+ "\nSelect a Quest below. Follow the instruction manuals given by Roman Steve."
        		+ " Completing the activitys will reward you with achievements and points that can be used to purchase items to gain more points."
        		+ " Points can also be used to buy Teleporter Tokens that will take you to other Islands.\n\n"
        		+ "Roman Steve has 3 Quests available. The Build Quest will require Peer Marking / Review."
        				+ "\n\nMore help on quests can be found in the individual manuals given by Roman Steve."); 
     
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
        
		if (TileEntityRomanQuest.buildquestdone == false) {
			buttonList.add(button2 = new GuiButton(BUTTON2, (width / 2) + 40, centerY + 59, 36, 20, "Select"));
		}
		buttonList.add(button2alt = new GuiButton(BUTTON2alt, (width / 2), centerY + 59, 80, 20, "Claim Reward"));
		
		
		if (TileEntityRomanQuest.allfound == false) {
			buttonList.add(button3 = new GuiButton(BUTTON3, (width / 2) + 40, centerY + 83, 36, 20, "Select"));
		}
		buttonList.add(button3alt = new GuiButton(BUTTON3alt, (width / 2), centerY + 83, 80, 20, "Claim Reward"));

		
		if (TileEntityRomanQuest.allpressed == false) {
		buttonList.add(button4 = new GuiButton(BUTTON4, (width / 2) + 40, centerY + 109, 36, 20, "Select"));
		}
		buttonList.add(button4alt = new GuiButton(BUTTON4alt, (width / 2), centerY + 109, 80, 20, "Claim Reward"));
		
		
		
		
		button2alt.visible = false;
		button3alt.visible = false;
		button4alt.visible = false;
		
        
     
        
       //Build Quest 
        if(TileEntityRomanQuest.buildrewardclaimed == false){
      if(TileEntityRomanQuest.buildquestdone == true){
    	  button2alt.visible=true;
      }
        }
        
        //Relic Quest
        if(TileEntityRomanQuest.relicrewardclaimed == false){
      if(TileEntityRomanQuest.allfound == true){
    	  button3alt.visible=true;
      }
        }
        
        //Quiz 
        if(TileEntityRomanQuest.quizrewardclaimed == false){
      if(TileEntityRomanQuest.allpressed == true){
    	  button4alt.visible=true;
      }
        }
        
  
        super.initGui();
    }
    

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
    	
        switch (button.id) {
            
            case BUTTON2: //BuildQuest
            		questnumber = 1;
            		mc.player.playSound(ModSoundHandler.STEEL_BUTTON_CLICK_OFF, 1.0f, 1.0f);
            	if(TileEntityRomanQuest.buildquestbookqive == false){
            		Maw79Mod.NETWORK.sendToServer(new RomanQuestMessage(mc.player));
            		TileEntityRomanQuest.buildquestbookqive = true;
            	}
            	break;
            	
            case BUTTON2alt:
            	// Build Quest
        		mc.player.playSound(ModSoundHandler.STEEL_BUTTON_CLICK_OFF, 1.0f, 1.0f);
        		TileEntityPointsBlock.playerScore +=50;
        		TileEntityPointsBlock.playerScore += TileEntityRomanQuest.scorecard;
        		TileEntityRomanQuest.scorecard=0;
        		button2alt.visible=false;
        		questnumber = 0;
        		TileEntityRomanQuest.buildrewardclaimed = true;
        		TileEntityRomanQuest.buildmodedone = false;
            	break;
            	
            	
            case BUTTON3://Relics
            	questnumber = 2;
        		mc.player.playSound(ModSoundHandler.STEEL_BUTTON_CLICK_OFF, 1.0f, 1.0f);
        		if(TileEntityRomanQuest.relicquestbookgive == false){
            		Maw79Mod.NETWORK.sendToServer(new RomanQuestMessage(mc.player));
            		TileEntityRomanQuest.relicquestbookgive = true;
            	}
            	break;
            	
            case BUTTON3alt:
            	// Relics
        		mc.player.playSound(ModSoundHandler.STEEL_BUTTON_CLICK_OFF, 1.0f, 1.0f);
        		TileEntityPointsBlock.playerScore +=50;
        		button3alt.visible=false;
        		questnumber = 0;
        		TileEntityRomanQuest.relicrewardclaimed = true;
            	break;
            	
            	
            	
            	
            case BUTTON4: //Quiz
            	questnumber = 3;
        		mc.player.playSound(ModSoundHandler.STEEL_BUTTON_CLICK_OFF, 1.0f, 1.0f);
        		Minecraft.getMinecraft().displayGuiScreen(new GuiRomanQuiz());
            	break;
            	
            case BUTTON4alt:
            	// Quarters  
        		mc.player.playSound(ModSoundHandler.STEEL_BUTTON_CLICK_OFF, 1.0f, 1.0f);
        		TileEntityPointsBlock.playerScore +=50;
        		button4alt.visible=false;
        		questnumber = 0;
        		TileEntityRomanQuest.quizrewardclaimed = true;
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
	 