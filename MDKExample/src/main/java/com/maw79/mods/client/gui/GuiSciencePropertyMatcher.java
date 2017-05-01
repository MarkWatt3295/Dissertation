package com.maw79.mods.client.gui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.maw79.mods.blocks.pointsblocks.TileEntityPointsBlock;
import com.maw79.mods.blocks.scienceblocks.propertiesmatcher.GuiPropertiesMatcher;
import com.maw79.mods.blocks.scienceblocks.propertiesmatcher.TileEntityPropertiesMatcher;
import com.maw79.mods.client.gui.GuiNotif;
import com.maw79.mods.client.gui.mathsgui.GuiSubtractionBlock;
import com.maw79.mods.handlers.ModSoundHandler;
import com.maw79.mods.init.ModBlocks;
import com.maw79.mods.init.ModItems;
import com.maw79.mods.init.ModTools;
import com.maw79.mods.main.Maw79Mod;
import com.maw79.mods.main.Reference;
import com.maw79.mods.network.LabelMessage;
import com.maw79.mods.network.store.FarmerCoinsMessage;
import com.maw79.mods.network.store.MathsStore1Message;
import com.maw79.mods.network.store.RomanStoreMessage;
import com.maw79.mods.network.store.StoreItem1Message;
import com.maw79.mods.util.Utils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class GuiSciencePropertyMatcher extends GuiScreen {
	
	final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/gui/properties.png");
    int guiWidth = 175;
    int guiHeight = 210;
    
    String title = "Properties";
    
   public static int buttonvalue = 0;
    
    
    GuiButton button1, button2, button3, button4, button5, buttonnextpage;
    final int BUTTON1 = 1, BUTTON2 = 2, BUTTON3 = 3, BUTTON4 = 4, BUTTON5 = 5, BUTTON6 = 6;
    
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
            GlStateManager.scale(1.4, 1.4, 1.4);
            fontRendererObj.drawString(title, 0, 0, 0x6028ff);
           
        }
        GlStateManager.popMatrix();
        
        GlStateManager.pushMatrix();
        {
            GlStateManager.translate((width / 2) , centerY + 12, 0);
            GlStateManager.scale(1, 1, 1);
            String heading = "Label : "+ TileEntityPropertiesMatcher.labelName;
            fontRendererObj.drawString(heading, 0, 0, 0xffffff);
           
        }
        GlStateManager.popMatrix();
        
        GlStateManager.pushMatrix();
        {
            GlStateManager.translate((width / 2), centerY + 10, 0);
            GlStateManager.scale(1.4, 1.4, 1.4);
           
            fontRendererObj.drawString("Wood", (-23), (20), 0xffffff); 
    		fontRendererObj.drawString("Metal", (-23), (40), 0xffffff);
    		fontRendererObj.drawString("Glass", (-23), (56), 0xffffff);
    		fontRendererObj.drawString("Plastic", (-23), (74), 0xffffff);
    		fontRendererObj.drawString("Ceramic", (-23), (90), 0xffffff);
    		
        }
        GlStateManager.popMatrix();
        
        
        
        button1.drawButton(mc, mouseX, mouseY);
        button2.drawButton(mc, mouseX, mouseY);
        button3.drawButton(mc, mouseX, mouseY);
        button4.drawButton(mc, mouseX, mouseY);
        button5.drawButton(mc, mouseX, mouseY);
        ItemStack icon = new ItemStack(Blocks.LOG);
        ItemStack icon2 = new ItemStack(Blocks.IRON_BLOCK);
        ItemStack icon3 = new ItemStack(Blocks.GLASS);
        ItemStack icon4 = new ItemStack(ModBlocks.plasticblock);
        ItemStack icon5 = new ItemStack(ModBlocks.mathblockwhite);
        
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
        
       
        
        String s1 ="Wood";
        String s2 = "Metal";
        String s3 = "Glass";
        String s4 = "Plastic";
        String s5 = "Ceramic";
        drawTooltip(s1, mouseX, mouseY, centerX +10, centerY + 33, 22, 22);
        drawTooltip(s2, mouseX, mouseY, centerX +10, centerY + 58, 22, 22);
        drawTooltip(s3, mouseX, mouseY, centerX +10, centerY + 83, 22, 22);
        drawTooltip(s4, mouseX, mouseY, centerX +10, centerY + 108, 22, 22);
        drawTooltip(s5, mouseX, mouseY, centerX +10, centerY + 133, 22, 22);
        
      
    }
    
    public void drawTooltip(String line, int mouseX, int mouseY, int posX, int posY, int width, int height) {
        if (mouseX >= posX && mouseX <= posX + width && mouseY >= posY && mouseY <= posY + height) {
            drawCreativeTabHoveringText(line, mouseX, mouseY);
        }
    }
   
    

    
    @Override
    public void initGui() {
    	
        buttonList.clear();
        int centerY = (height / 2) - guiHeight / 2;
        
        buttonList.add(button1 = new GuiButton(BUTTON1, (width / 2) + 40, centerY + 33, 40, 20, "Select"));
        buttonList.add(button2 = new GuiButton(BUTTON2, (width / 2) + 40, centerY + 59, 40, 20, "Select"));
        buttonList.add(button3 = new GuiButton(BUTTON3, (width / 2) + 40, centerY + 83, 40, 20, "Select"));
        buttonList.add(button4 = new GuiButton(BUTTON4, (width / 2) + 40, centerY + 109, 40, 20, "Select"));
        buttonList.add(button5 = new GuiButton(BUTTON5, (width / 2) + 40, centerY + 133, 40, 20, "Select"));

        super.initGui();
    }
    

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
    	 
    	
        switch (button.id) {
            case BUTTON1:
            	Utils.getLogger().info("Button 1 Pressed");
            	if(TileEntityPropertiesMatcher.propertyType.equals("Wood")){
            		Utils.getLogger().info("Its Wood");
            		mc.player.playSound(ModSoundHandler.MAWSOUND_CORRECT, 1.0f, 1.0f);
            		TileEntityPointsBlock.playerScore +=10;
            		TileEntityPropertiesMatcher.propertyType="";
            		mc.displayGuiScreen((GuiScreen)null);
            	}
            	else{
            		Utils.getLogger().info("Incorrect. Propertie is : "+TileEntityPropertiesMatcher.propertyType);
            		TileEntityPropertiesMatcher.propertyType="";
            		TileEntityPointsBlock.playerScore -=10;
            		mc.player.playSound(ModSoundHandler.MAWSOUND_ERRORSOUND, 1.0f, 1.0f);
            		Maw79Mod.NETWORK.sendToServer(new LabelMessage(mc.player));
            		mc.displayGuiScreen((GuiScreen)null);
            	}
            	
            	
            	
            	break;
            	
            case BUTTON2:
            	Utils.getLogger().info("Button 2 Pressed");
            	if(TileEntityPropertiesMatcher.propertyType.equals("Metal")){
            		Utils.getLogger().info("Its Metal");
            		mc.player.playSound(ModSoundHandler.MAWSOUND_CORRECT, 1.0f, 1.0f);
            		TileEntityPointsBlock.playerScore +=10;
            		TileEntityPropertiesMatcher.propertyType="";
            		mc.displayGuiScreen((GuiScreen)null);
            	}
            	else{
            		Utils.getLogger().info("Incorrect. Propertie is : "+TileEntityPropertiesMatcher.propertyType);
            		TileEntityPropertiesMatcher.propertyType="";
            		TileEntityPointsBlock.playerScore -=10;
            		mc.player.playSound(ModSoundHandler.MAWSOUND_ERRORSOUND, 1.0f, 1.0f);
            		Maw79Mod.NETWORK.sendToServer(new LabelMessage(mc.player));
            		mc.displayGuiScreen((GuiScreen)null);
            	}
            	
            
            	break;
            	
            case BUTTON3:
            	
            	Utils.getLogger().info("Button 3 Pressed");
            	if(TileEntityPropertiesMatcher.propertyType.equals("Glass")){
            		Utils.getLogger().info("Its Glass");
            		mc.player.playSound(ModSoundHandler.MAWSOUND_CORRECT, 1.0f, 1.0f);
            		TileEntityPointsBlock.playerScore +=10;
            		TileEntityPropertiesMatcher.propertyType="";
            		mc.displayGuiScreen((GuiScreen)null);
            	}
            	else{
            		Utils.getLogger().info("Incorrect. Propertie is : "+TileEntityPropertiesMatcher.propertyType);
            		TileEntityPropertiesMatcher.propertyType="";
            		TileEntityPointsBlock.playerScore -=10;
            		mc.player.playSound(ModSoundHandler.MAWSOUND_ERRORSOUND, 1.0f, 1.0f);
            		Maw79Mod.NETWORK.sendToServer(new LabelMessage(mc.player));
            		mc.displayGuiScreen((GuiScreen)null);
            	}
            	
            	
            	break;
            	
            case BUTTON4:
            	Utils.getLogger().info("Button 4 Pressed");
            	if(TileEntityPropertiesMatcher.propertyType.equals("Plastic")){
            		Utils.getLogger().info("Its Plastic");
            		mc.player.playSound(ModSoundHandler.MAWSOUND_CORRECT, 1.0f, 1.0f);
            		TileEntityPointsBlock.playerScore +=10;
            		TileEntityPropertiesMatcher.propertyType="";
            		mc.displayGuiScreen((GuiScreen)null);
            	}
            	else{
            		Utils.getLogger().info("Incorrect. Propertie is : "+TileEntityPropertiesMatcher.propertyType);
            		TileEntityPropertiesMatcher.propertyType="";
            		TileEntityPointsBlock.playerScore -=10;
            		mc.player.playSound(ModSoundHandler.MAWSOUND_ERRORSOUND, 1.0f, 1.0f);
            		Maw79Mod.NETWORK.sendToServer(new LabelMessage(mc.player));
            		mc.displayGuiScreen((GuiScreen)null);
            	}
            	
            	break;
            	
            case BUTTON5:
            	Utils.getLogger().info("Button 5 Pressed");
            	if(TileEntityPropertiesMatcher.propertyType.equals("Ceramic")){
            		Utils.getLogger().info("Its Ceramic");
            		mc.player.playSound(ModSoundHandler.MAWSOUND_CORRECT, 1.0f, 1.0f);
            		TileEntityPointsBlock.playerScore +=10;
            		TileEntityPropertiesMatcher.propertyType="";
            		mc.displayGuiScreen((GuiScreen)null);
            	}
            	else{
            		Utils.getLogger().info("Incorrect. Propertie is : "+TileEntityPropertiesMatcher.propertyType);
            		TileEntityPropertiesMatcher.propertyType="";
            		TileEntityPointsBlock.playerScore -=10;
            		mc.player.playSound(ModSoundHandler.MAWSOUND_ERRORSOUND, 1.0f, 1.0f);
            		Maw79Mod.NETWORK.sendToServer(new LabelMessage(mc.player));
            		mc.displayGuiScreen((GuiScreen)null);
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
        return false;
    }
    
    public void onEvent(){
    	System.out.println("ON EVENT HAS BEEN CALLED!");
    	
         
    }
    
}
	 