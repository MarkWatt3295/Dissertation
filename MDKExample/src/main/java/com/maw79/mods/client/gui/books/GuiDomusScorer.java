package com.maw79.mods.client.gui.books;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

import com.maw79.mods.blocks.historyblocks.romanquests.TileEntityRomanQuest;
import com.maw79.mods.blocks.pointsblocks.TileEntityPointsBlock;
import com.maw79.mods.main.Reference;
import com.maw79.mods.util.Utils;

import java.io.IOException;


public class GuiDomusScorer extends GuiScreen {
	
    final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/gui/book2.png");
    int guiWidth = 175;
    int guiHeight = 228;

    GuiButton button1, buttonWindows, buttonPaintings, buttonMultiplefloors, buttonPool, buttonMultipleRooms,
    buttonMainBedroom, buttonCouches, buttonCulina, buttonStudy, buttonAtrium, buttonGarden, buttonSecretPassage,
    buttonBed, buttonTriclinium, buttonImpluvium, buttonPosticum, buttonServantarea;
    String title = "Domus Score Card";

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        drawDefaultBackground();
        Minecraft.getMinecraft().renderEngine.bindTexture(texture);
        int centerX = (width / 2) - guiWidth / 2;
        int centerY = (height / 2) - guiHeight / 2;
        //drawTexturedModalRect(centerX, centerY, 0, 0, guiWidth, guiHeight);
        //drawString(fontRendererObj, "Tutorial", centerX, centerY, 0x6028ff);
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
            GlStateManager.translate((width / 2) - 75, centerY + 10, 0);
            GlStateManager.scale(1.7, 1.7, 1.7);
            fontRendererObj.drawString(title, 0, 0, 0x6028ff);
            
        }
        GlStateManager.popMatrix();
        super.drawScreen(mouseX, mouseY, partialTicks);
        button1.drawButton(mc, mouseX, mouseY);
     
    }



    @Override
    public void initGui() { 
    button1 = new GuiButton(0, (width / 2) - 100 / 2, height - 45, 100, 20, "Close");  
    buttonWindows = new GuiButton(1, width / 2 -86, height - 210, 87, 20, "Windows");
    buttonPaintings = new GuiButton(2, width / 2 + 1 , height - 210, 87, 20, "Paintings");
    buttonMultiplefloors = new GuiButton(3, width / 2 -86, height - 190, 87, 20, "Multiple Floors");
    buttonPool = new GuiButton(4, width / 2 + 1 , height - 190, 87, 20, "Pool");
    buttonMultipleRooms = new GuiButton(5, width / 2 -86, height - 170, 87, 20, "Multiple Rooms");
    buttonMainBedroom = new GuiButton(6, width / 2 + 1 , height - 170, 87, 20, "Main Bedroom");
    buttonCouches = new GuiButton(7, width / 2 -86, height - 150, 87, 20, "Couches");
    buttonCulina = new GuiButton(8, width / 2 + 1 , height - 150, 87, 20, "Culina");
    buttonStudy = new GuiButton(9, width / 2 -86, height - 130, 87, 20, "Small Study");
    buttonAtrium = new GuiButton(10, width / 2 + 1 , height - 130, 87, 20, "Atrium");
    buttonGarden = new GuiButton(11, width / 2 -86, height - 110, 87, 20, "Garden");
    buttonSecretPassage = new GuiButton(12, width / 2 + 1 , height - 110, 87, 20, "Secret Passage");
    buttonBed = new GuiButton(13, width / 2 -86, height - 90, 87, 20, "Bed");
    buttonTriclinium = new GuiButton(14, width / 2 + 1 , height - 90, 87, 20, "Triclinium");
    buttonImpluvium = new GuiButton(15, width / 2 -86, height - 70, 87, 20, "Impluvium");
    buttonPosticum = new GuiButton(16, width / 2 + 1 , height - 70, 87, 20, "Posticum");
      
  	buttonList.add(buttonWindows);
  	buttonList.add(buttonPaintings);
	buttonList.add(buttonMultiplefloors);
  	buttonList.add(buttonPool);
  	buttonList.add(buttonMultipleRooms);
  	buttonList.add(buttonMainBedroom);
	buttonList.add(buttonCouches);
  	buttonList.add(buttonCulina);
  	buttonList.add(buttonStudy);
  	buttonList.add(buttonAtrium);
  	buttonList.add(buttonGarden);
  	buttonList.add(buttonSecretPassage);
  	buttonList.add(buttonBed);
  	buttonList.add(buttonTriclinium);
  	buttonList.add(buttonImpluvium);
  	buttonList.add(buttonPosticum);
  	buttonList.add(button1);
  	
  	if(TileEntityRomanQuest.Posticum==true){
  		buttonPosticum.enabled=false;
  	}
  	if(TileEntityRomanQuest.Impluvium==true){
  		buttonImpluvium.enabled=false;
  	}
  	if(TileEntityRomanQuest.Triclinium==true){
  		buttonTriclinium.enabled=false;
  	}
  	if(TileEntityRomanQuest.Bed==true){
  		buttonBed.enabled=false;
  	}
  	if(TileEntityRomanQuest.SecretPassage==true){
  		buttonSecretPassage.enabled=false;
  	}
  	if(TileEntityRomanQuest.Garden==true){
  		buttonGarden.enabled=false;
  	}
  	if(TileEntityRomanQuest.Atrium==true){
  		buttonAtrium.enabled=false;
  	}
  	if(TileEntityRomanQuest.Study==true){
  		buttonStudy.enabled=false;
  	}
  	if(TileEntityRomanQuest.Culina==true){
  		buttonCulina.enabled=false;
  	}
  	if(TileEntityRomanQuest.Couches==true){
  		buttonCouches.enabled=false;
  	}
  	if(TileEntityRomanQuest.MainBedroom==true){
  		buttonMainBedroom.enabled=false;
  	}
  	if(TileEntityRomanQuest.MultipleRooms==true){
  		buttonMultipleRooms.enabled=false;
  	}
  	if(TileEntityRomanQuest.Pool==true){
  		buttonPool.enabled=false;
  	}
  	if(TileEntityRomanQuest.Multiplefloors==true){
  		buttonMultiplefloors.enabled=false;
  	}
  	if(TileEntityRomanQuest.Paintings==true){
  		buttonPaintings.enabled=false;
  	}
  	if(TileEntityRomanQuest.windowsbutton==true){
  		buttonWindows.enabled=false;
  	}
      
        super.initGui();
    }

  

    @Override
   	protected void actionPerformed(GuiButton parButton) 
       {
       	 if (parButton == button1)	{
                mc.displayGuiScreen(null);
        }
       	 else if (parButton == buttonWindows)	{
           Utils.getLogger().info("Button Windows");
           TileEntityRomanQuest.scorecard+=20;
           TileEntityRomanQuest.windowsbutton=true;
           buttonWindows.enabled=false;
    }
       	 else if (parButton == buttonPaintings)	{
             Utils.getLogger().info("Button Paintings");
             TileEntityRomanQuest.scorecard+=20;
             TileEntityRomanQuest.Paintings=true;
             buttonPaintings.enabled=false;
      }
       	 else if (parButton == buttonMultiplefloors)	{
             Utils.getLogger().info("Button Multiple Floors");
             TileEntityRomanQuest.scorecard+=20;
             TileEntityRomanQuest.Multiplefloors=true;
             buttonMultiplefloors.enabled=false;
      }
     	 else if (parButton == buttonPool)	{
             Utils.getLogger().info("Button Pool");
             TileEntityRomanQuest.scorecard+=20;
             TileEntityRomanQuest.Pool=true;
             buttonPool.enabled=false;
      }
     	 else if (parButton == buttonMultipleRooms)	{
             Utils.getLogger().info("Button Multiple Rooms");
             TileEntityRomanQuest.scorecard+=20;
             TileEntityRomanQuest.MultipleRooms=true;
             buttonMultipleRooms.enabled=false;
      }
    	 else if (parButton == buttonMainBedroom)	{
             Utils.getLogger().info("Button Main Bedroom");
             TileEntityRomanQuest.scorecard+=20;
             TileEntityRomanQuest.MainBedroom=true;
             buttonMainBedroom.enabled=false;
      }
    	 else if (parButton == buttonCouches)	{
             Utils.getLogger().info("Button Couches");
             TileEntityRomanQuest.scorecard+=20;
             TileEntityRomanQuest.Couches=true;
             buttonCouches.enabled=false;
      }
    	 else if (parButton == buttonCulina)	{
             Utils.getLogger().info("Button Culina");
             TileEntityRomanQuest.scorecard+=20;
             TileEntityRomanQuest.Culina=true;
             buttonCulina.enabled=false;
      }
    	 else if (parButton == buttonStudy)	{
             Utils.getLogger().info("Button Study");
             TileEntityRomanQuest.scorecard+=20;
             TileEntityRomanQuest.Study=true;
             buttonStudy.enabled=false;
      }
    	 else if (parButton == buttonAtrium)	{
             Utils.getLogger().info("Button Atrium");
             TileEntityRomanQuest.scorecard+=20;
             TileEntityRomanQuest.Atrium=true;
             buttonAtrium.enabled=false;
      }
    	 else if (parButton == buttonGarden)	{
             Utils.getLogger().info("Button Garden");
             TileEntityRomanQuest.scorecard+=20;
             TileEntityRomanQuest.Garden=true;
             buttonGarden.enabled=false;
      } 
    	 else if (parButton == buttonSecretPassage)	{
          Utils.getLogger().info("Button Secret Passage");
          TileEntityRomanQuest.scorecard+=20;
          TileEntityRomanQuest.SecretPassage=true;
          buttonSecretPassage.enabled=false;
   }
        
    else if (parButton == buttonBed)	{
           Utils.getLogger().info("Button Bed");
           TileEntityRomanQuest.scorecard+=20;
           TileEntityRomanQuest.Bed=true;
           buttonBed.enabled=false;
    }
    else if (parButton == buttonTriclinium)	{
        Utils.getLogger().info("Button Triclinium");
        TileEntityRomanQuest.scorecard+=20;
        TileEntityRomanQuest.Triclinium=true;
        buttonTriclinium.enabled=false;
 }
    else if (parButton == buttonImpluvium)	{
        Utils.getLogger().info("Button Impluvium");
        TileEntityRomanQuest.scorecard+=20;
        TileEntityRomanQuest.Impluvium=true;
        buttonImpluvium.enabled=false;
 }
    else if (parButton == buttonPosticum)	{
        Utils.getLogger().info("Button Posticum");
        TileEntityRomanQuest.scorecard+=20;
        TileEntityRomanQuest.Posticum=true;
        buttonPosticum.enabled=false;
 }
   
      
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