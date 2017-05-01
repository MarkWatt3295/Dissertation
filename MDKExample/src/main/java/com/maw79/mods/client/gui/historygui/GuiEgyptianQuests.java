package com.maw79.mods.client.gui.historygui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.maw79.mods.blocks.historyblocks.artifactupdater.TileEntityArtifactResearcher;
import com.maw79.mods.blocks.historyblocks.romanquests.TileEntityRomanQuest;
import com.maw79.mods.blocks.mathsblocks.coordinatesquest.TileEntityCoordinatesQuest;
import com.maw79.mods.blocks.mathsblocks.questblock.TileEntityMathsQuest;
import com.maw79.mods.blocks.pointsblocks.TileEntityPointsBlock;
import com.maw79.mods.client.gui.GuiNotif;
import com.maw79.mods.handlers.ModSoundHandler;
import com.maw79.mods.handlers.TickHandler;
import com.maw79.mods.init.ModItems;
import com.maw79.mods.main.Maw79Mod;
import com.maw79.mods.main.Reference;
import com.maw79.mods.network.EgyptQuestMessage;
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
import net.minecraft.util.text.TextComponentString;

public class GuiEgyptianQuests extends GuiScreen {
	
	public static int questnumber = 0;
	
	final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/gui/roman_quest.png");
    int guiWidth = 175;
    int guiHeight = 210;
    
    String title = "Egypt Quests";
    
   public static int buttonvalue = 0;
    
   
    GuiButton  button2, button3, button4, button5, button2alt, button3alt;
    final int  BUTTON2 = 2, BUTTON3 = 3, BUTTON4 = 4, 
    		BUTTON2alt = 22, BUTTON3alt = 33;
    
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
    		fontRendererObj.drawString("§4"+TileEntityArtifactResearcher.artifacthunttitle, (-50), (40), 0xffffff);
    		fontRendererObj.drawString("§9"+TileEntityArtifactResearcher.egyptquiztitle, (-50), (56), 0xffffff);
    		fontRendererObj.drawString("§6"+"Store", (-50), (74), 0xffffff);
    
        }
        
        
        GlStateManager.popMatrix();
        
        super.drawScreen(mouseX, mouseY, partialTicks);
        
        List<String> text = new ArrayList<String>();
        text.add("§9"+"QUEST INFORMATION" +"§f"+ "\nSelect a Quest below. Follow the instruction manuals given by Pyramid Steve."
        		+ " Completing the activitys will reward you with achievements and points that can be used to purchase items to gain more points."
        		+ " Points can also be used to buy Teleporter Tokens that will take you to other Islands.\n\n"
        		+ "Pyramid Steve has 2 Quests available. The First is an Artifact Hunt that will have you searching for various Artifacts hidden around the map. The "
        		+ "Second is a Quiz. In order to initiate the Quiz you must first speak to some Mummys and Explorers to gain some knowledge."
        				+ "\n\nMore help on quests can be found in the individual manuals given by Pyramid Steve."); 
     
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
        
		if (TileEntityArtifactResearcher.artifactqueststart == false) {
			buttonList.add(button2 = new GuiButton(BUTTON2, (width / 2) + 40, centerY + 59, 36, 20, "Select"));
		}
		buttonList.add(button2alt = new GuiButton(BUTTON2alt, (width / 2), centerY + 59, 80, 20, "Claim Reward"));
		
		
		if (TileEntityArtifactResearcher.allpressed == false) {
			buttonList.add(button3 = new GuiButton(BUTTON3, (width / 2) + 40, centerY + 83, 36, 20, "Select"));
		}
		buttonList.add(button3alt = new GuiButton(BUTTON3alt, (width / 2), centerY + 83, 80, 20, "Claim Reward"));

		buttonList.add(button4 = new GuiButton(BUTTON4, (width / 2) + 40, centerY + 109, 36, 20, "Select"));
		
	
		
		button2alt.visible = false;
		button3alt.visible = false;
		
		
       //Artifact Quest 
        if(TileEntityArtifactResearcher.relicrewardclaimed == false){
      if(TileEntityArtifactResearcher.allfound == true){
    	  button2alt.visible=true;
      }
        }
        
        //Quiz Quest
        if(TileEntityArtifactResearcher.quizrewardclaimed == false){
      if(TileEntityArtifactResearcher.allpressed == true){
    	  button3alt.visible=true;
      }
        }
        
     
        
  
        super.initGui();
    }
    

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
    	
        switch (button.id) {
            
            case BUTTON2: //Artifact Quest
            		questnumber = 1;
            		mc.player.playSound(ModSoundHandler.STEEL_BUTTON_CLICK_OFF, 1.0f, 1.0f);
            	if(TileEntityArtifactResearcher.ArtifactManualgive == false){
            		Maw79Mod.NETWORK.sendToServer(new EgyptQuestMessage(mc.player));
            		TileEntityArtifactResearcher.ArtifactManualgive = true;
            		TileEntityArtifactResearcher.artifactqueststart = true;
            	}
            	break;
            	
            case BUTTON2alt:
            	// Artifact Quest
        		mc.player.playSound(ModSoundHandler.STEEL_BUTTON_CLICK_OFF, 1.0f, 1.0f);
        		TileEntityPointsBlock.playerScore +=50;
        		TileEntityPointsBlock.playerScore += TileEntityRomanQuest.scorecard;
        		TileEntityRomanQuest.scorecard=0;
        		button2alt.visible=false;
        		questnumber = 0;
        		TileEntityArtifactResearcher.relicrewardclaimed = true;
            	break;
            	
            	
            case BUTTON3://Quiz
            	questnumber = 2;
        		mc.player.playSound(ModSoundHandler.STEEL_BUTTON_CLICK_OFF, 1.0f, 1.0f);
        		if(TickHandler.npcchats ==0){
        		Minecraft.getMinecraft().displayGuiScreen(new GuiEgyptQuiz());
        		}
        		else{
        			mc.player.sendMessage(new TextComponentString("\n"+"§c"+"Pyramid Steve :\n"+"§c"+"\""+"§f"+"Speak to some Facts Mummys or Explorers before attempting\nthis quiz."+"§c"+"\""+"\n"));
        		}
            	break;
            	
            case BUTTON3alt:
            	// Quiz
        		mc.player.playSound(ModSoundHandler.STEEL_BUTTON_CLICK_OFF, 1.0f, 1.0f);
        		TileEntityPointsBlock.playerScore +=50;
        		button3alt.visible=false;
        		questnumber = 0;
        		TileEntityArtifactResearcher.quizrewardclaimed = true;
            	break;
            	
            case BUTTON4: //Store
            	questnumber = 3;
        		mc.player.playSound(ModSoundHandler.STEEL_BUTTON_CLICK_OFF, 1.0f, 1.0f);
        		Minecraft.getMinecraft().displayGuiScreen(new GuiEgyptStore());
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
	 