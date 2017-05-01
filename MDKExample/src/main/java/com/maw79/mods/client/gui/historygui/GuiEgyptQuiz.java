package com.maw79.mods.client.gui.historygui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.maw79.mods.blocks.historyblocks.artifactupdater.TileEntityArtifactResearcher;
import com.maw79.mods.blocks.historyblocks.romanquests.TileEntityRomanQuest;
import com.maw79.mods.blocks.pointsblocks.TileEntityPointsBlock;
import com.maw79.mods.client.gui.GuiNotif;
import com.maw79.mods.handlers.ModSoundHandler;
import com.maw79.mods.init.ModItems;
import com.maw79.mods.init.ModTools;
import com.maw79.mods.main.Maw79Mod;
import com.maw79.mods.main.Reference;
import com.maw79.mods.network.store.FarmerCoinsMessage;
import com.maw79.mods.network.store.MathsStore1Message;
import com.maw79.mods.network.store.RomanStoreMessage;
import com.maw79.mods.network.store.StoreItem1Message;
import com.maw79.mods.util.Utils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;

public class GuiEgyptQuiz extends GuiScreen {




	final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/gui/egyptquiz.png");
	int guiWidth = 175;
	int guiHeight = 210;

	String title = "Egypt Quiz";

	public static int buttonvalue = 0;
	String s1 ="In Ancient Egypt the Pharoh was the ruler of Egypt. Kind of like a King or an Emporer\nTrue or False?";
	String s2 = "The Ankh is an Ancient Egyption Hieroglph which means Life\nTrue or False?";
	String s3 = "Tutankhamun died when he was only 18 years old\nTrue or False?";
	String s4 = "The Ancient Egyptians invented Paper, Pens and Toothpaste\nTrue or False?"; 
	String s5 = "There are only 50 Hieroglphs in the ancient egyptian alphabet\nTrue or False?"; 
	String s6 = "A Sphinx is a mythical creature with the head of a lion and the body of a man\nTrue or False?"; 
	String s7 = "The Benben Stone resides at the bottom of a Pyramid\nTrue or False?"; 
	String s8 = "Tutankhamun was nicknamed the Golden King\nTrue or False?"; 
	String s9 = "Canopic Jars were used to store Jewellery and Amulets\nTrue or False?";  
	String s10 = "Ancient Egyptians mummified bodys to preserve them. They did this as they believed a mummified body would allow their soul to live on forever in the after-life\nTrue or False?"; 

	GuiButton button1, button2, button3, button4, button5;
	GuiButton button1false, button2false, button3false, button4false, button5false;
	GuiButton right1t, right2t, right3t, right4t, right5t;
	GuiButton right1f, right2f, right3f, right4f, right5f;
	final int BUTTON1 = 1, BUTTON2 = 2, BUTTON3 = 3, BUTTON4 = 4, BUTTON5 = 5;
	final int BUTTON1F = 11, BUTTON2F = 22, BUTTON3F = 33, BUTTON4F = 44, BUTTON5F = 55;
	final int RIGHT1T = 111, RIGHT2T = 222, RIGHT3T = 333, RIGHT4T = 444, RIGHT5T = 555;
	final int RIGHT1F = 1111, RIGHT2F = 2222, RIGHT3F = 3333, RIGHT4F = 4444, RIGHT5F = 5555;

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
			GlStateManager.translate((width / 2) -50, centerY + 10, 0);
			GlStateManager.scale(2, 2, 2);
			fontRendererObj.drawString(title, 0, 0, 0x6028ff);

		}
		GlStateManager.popMatrix();

		button1.drawButton(mc, mouseX, mouseY);
		button1false.drawButton(mc, mouseX, mouseY);
		button2.drawButton(mc, mouseX, mouseY);
		button2false.drawButton(mc, mouseX, mouseY);
		button3.drawButton(mc, mouseX, mouseY);
		button3false.drawButton(mc, mouseX, mouseY);
		button4.drawButton(mc, mouseX, mouseY);
		button4false.drawButton(mc, mouseX, mouseY);
		button5.drawButton(mc, mouseX, mouseY);
		button5false.drawButton(mc, mouseX, mouseY);
		right1t.drawButton(mc, mouseX, mouseY);
		right2t.drawButton(mc, mouseX, mouseY);
		right3t.drawButton(mc, mouseX, mouseY);
		right4t.drawButton(mc, mouseX, mouseY);
		right5t.drawButton(mc, mouseX, mouseY);
		right1f.drawButton(mc, mouseX, mouseY);
		right2f.drawButton(mc, mouseX, mouseY);
		right3f.drawButton(mc, mouseX, mouseY);
		right4f.drawButton(mc, mouseX, mouseY);
		right5f.drawButton(mc, mouseX, mouseY);

		ItemStack icon = new ItemStack(ModItems.EGYPT_MANUAL);
		ItemStack iconf = new ItemStack(ModItems.EGYPT_MANUAL);
		ItemStack icon2 = new ItemStack(ModItems.EGYPT_MANUAL);
		ItemStack icon2f = new ItemStack(ModItems.EGYPT_MANUAL);
		ItemStack icon3 = new ItemStack(ModItems.EGYPT_MANUAL);
		ItemStack icon3f = new ItemStack(ModItems.EGYPT_MANUAL);
		ItemStack icon4 = new ItemStack(ModItems.EGYPT_MANUAL);
		ItemStack icon4f = new ItemStack(ModItems.EGYPT_MANUAL);
		ItemStack icon5 = new ItemStack(ModItems.EGYPT_MANUAL);
		ItemStack icon5f = new ItemStack(ModItems.EGYPT_MANUAL);

		GlStateManager.pushMatrix();
		{
			//Icon 1
			GlStateManager.translate((width / 2) - 85, centerY + 33, 0);
			GlStateManager.scale(1.4, 1.4, 1.4);
			mc.getRenderItem().renderItemAndEffectIntoGUI(icon, 0, 0);

		}     
		GlStateManager.popMatrix();

		GlStateManager.pushMatrix();
		{
			//Icon 1 False
			GlStateManager.translate((width / 2) + 3, centerY + 33, 0);
			GlStateManager.scale(1.4, 1.4, 1.4);
			mc.getRenderItem().renderItemAndEffectIntoGUI(iconf, 0, 0);

		}     
		GlStateManager.popMatrix();

		GlStateManager.pushMatrix();
		{
			//Icon 2
			GlStateManager.translate((width / 2) -85, centerY + 59, 0);
			GlStateManager.scale(1.4, 1.4, 1.4);
			mc.getRenderItem().renderItemAndEffectIntoGUI(icon2, 0, 0);

		}     
		GlStateManager.popMatrix();

		GlStateManager.pushMatrix();
		{
			//Icon 2 False
			GlStateManager.translate((width / 2) +3, centerY + 59, 0);
			GlStateManager.scale(1.4, 1.4, 1.4);
			mc.getRenderItem().renderItemAndEffectIntoGUI(icon2, 0, 0);

		}     
		GlStateManager.popMatrix();

		GlStateManager.pushMatrix();
		{
			//Icon 3
			GlStateManager.translate((width / 2) - 85, centerY + 88, 0);
			GlStateManager.scale(1.4, 1.4, 1.4);
			mc.getRenderItem().renderItemAndEffectIntoGUI(icon3, 0, 0);

		}     
		GlStateManager.popMatrix();

		GlStateManager.pushMatrix();
		{
			//Icon 3 False
			GlStateManager.translate((width / 2) +3, centerY + 88, 0);
			GlStateManager.scale(1.4, 1.4, 1.4);
			mc.getRenderItem().renderItemAndEffectIntoGUI(icon3, 0, 0);

		}     
		GlStateManager.popMatrix();


		GlStateManager.pushMatrix();
		{
			//Icon 4
			GlStateManager.translate((width / 2) - 85, centerY + 115, 0);
			GlStateManager.scale(1.4, 1.4, 1.4);
			mc.getRenderItem().renderItemAndEffectIntoGUI(icon4, 0, 0);

		}     
		GlStateManager.popMatrix();

		GlStateManager.pushMatrix();
		{
			//Icon 4 False
			GlStateManager.translate((width / 2) +3, centerY + 115, 0);
			GlStateManager.scale(1.4, 1.4, 1.4);
			mc.getRenderItem().renderItemAndEffectIntoGUI(icon4, 0, 0);

		}     
		GlStateManager.popMatrix();

		GlStateManager.pushMatrix();
		{
			//Icon 5
			GlStateManager.translate((width / 2) - 85, centerY + 140, 0);
			GlStateManager.scale(1.4, 1.4, 1.4);
			mc.getRenderItem().renderItemAndEffectIntoGUI(icon5, 0, 0);

		}     
		GlStateManager.popMatrix();
		GlStateManager.pushMatrix();
		{
			//Icon 5 False
			GlStateManager.translate((width / 2) +3, centerY + 140, 0);
			GlStateManager.scale(1.4, 1.4, 1.4);
			mc.getRenderItem().renderItemAndEffectIntoGUI(icon5, 0, 0);

		}     
		GlStateManager.popMatrix();

		drawTooltip(s1, mouseX, mouseY, centerX +6, centerY + 33, 15, 18);
		drawTooltip(s2, mouseX, mouseY, centerX +6, centerY + 58, 15, 18);
		drawTooltip(s3, mouseX, mouseY, centerX +6, centerY + 88, 15, 18);
		drawTooltip(s4, mouseX, mouseY, centerX +6, centerY + 115, 15, 18);
		drawTooltip(s5, mouseX, mouseY, centerX +6, centerY + 140, 15, 18);

		drawTooltip(s6, mouseX, mouseY, centerX +90, centerY + 33, 15, 18);
		drawTooltip(s7, mouseX, mouseY, centerX +90, centerY + 58, 15, 18);
		drawTooltip(s8, mouseX, mouseY, centerX +90, centerY + 88, 15, 18);
		drawTooltip(s9, mouseX, mouseY, centerX +90, centerY + 115, 15, 18);
		drawTooltip(s10, mouseX, mouseY, centerX +90, centerY + 140, 15, 18);


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

		buttonList.add(button1 = new GuiButton(BUTTON1, (width / 2) - 61, centerY + 33, 30, 20, "§a"+"True"));
		buttonList.add(button1false = new GuiButton(BUTTON1F, (width / 2) - 31, centerY + 33, 30, 20, "§c"+"False"));

		buttonList.add(button2 = new GuiButton(BUTTON2, (width / 2) - 61, centerY + 59, 30, 20, "§a"+"True"));
		buttonList.add(button2false = new GuiButton(BUTTON2F, (width / 2) - 31, centerY + 59, 30, 20, "§c"+"False"));

		buttonList.add(button3 = new GuiButton(BUTTON3, (width / 2) - 61, centerY + 88, 30, 20, "§a"+"True"));
		buttonList.add(button3false = new GuiButton(BUTTON3F, (width / 2) - 31, centerY + 88, 30, 20, "§c"+"False"));

		buttonList.add(button4 = new GuiButton(BUTTON4, (width / 2) - 61, centerY + 115, 30, 20, "§a"+"True"));
		buttonList.add(button4false = new GuiButton(BUTTON4F, (width / 2) - 31, centerY + 115, 30, 20, "§c"+"False"));

		buttonList.add(button5 = new GuiButton(BUTTON5, (width / 2) - 61, centerY + 140, 30, 20, "§a"+"True"));
		buttonList.add(button5false = new GuiButton(BUTTON5F, (width / 2) - 31, centerY + 140, 30, 20, "§c"+"False"));

		buttonList.add(right1t = new GuiButton(RIGHT1T, (width / 2) + 27, centerY + 33, 30, 20, "§a"+"True"));
		buttonList.add(right1f = new GuiButton(RIGHT1F, (width / 2) + 57, centerY + 33, 30, 20, "§c"+"False"));

		buttonList.add(right2t = new GuiButton(RIGHT2T, (width / 2) + 27, centerY + 59, 30, 20, "§a"+"True"));
		buttonList.add(right2f = new GuiButton(RIGHT2F, (width / 2) + 57, centerY + 59, 30, 20, "§c"+"False"));

		buttonList.add(right3t = new GuiButton(RIGHT3T, (width / 2) + 27, centerY + 88, 30, 20, "§a"+"True"));
		buttonList.add(right3f = new GuiButton(RIGHT3F, (width / 2) + 57, centerY + 88, 30, 20, "§c"+"False"));

		buttonList.add(right4t = new GuiButton(RIGHT4T, (width / 2) + 27, centerY + 115, 30, 20, "§a"+"True"));
		buttonList.add(right4f = new GuiButton(RIGHT4F, (width / 2) + 57, centerY + 115, 30, 20, "§c"+"False"));

		buttonList.add(right5t = new GuiButton(RIGHT5T, (width / 2) + 27, centerY + 140, 30, 20, "§a"+"True"));
		buttonList.add(right5f = new GuiButton(RIGHT5F, (width / 2) + 57, centerY + 140, 30, 20, "§c"+"False"));

		if(TileEntityArtifactResearcher.button1enabled==true){
			button1.enabled=false;
		}
		if(TileEntityArtifactResearcher.button2enabled==true){
			button2.enabled=false;
		}
		if(TileEntityArtifactResearcher.button3enabled==true){
			button3.enabled=false;
		}
		if(TileEntityArtifactResearcher.button4enabled==true){
			button4.enabled=false;
		}
		if(TileEntityArtifactResearcher.button5enabled==true){
			button5false.enabled=false;
		}
		if(TileEntityArtifactResearcher.right1tenabled==true){
			right1f.enabled=false;
		}
		if(TileEntityArtifactResearcher.right2tenabled==true){
			right2f.enabled=false;
		}
		if(TileEntityArtifactResearcher.right3tenabled==true){
			right3f.enabled=false;
		}
		if(TileEntityArtifactResearcher.right4tenabled==true){
			right4f.enabled=false;
		}
		if(TileEntityArtifactResearcher.right5tenabled==true){
			right5t.enabled=false;
		}
		super.initGui();
	}

	@Override
	protected void actionPerformed(GuiButton button) throws IOException {

		switch (button.id) {
		case BUTTON1:
			if(TileEntityArtifactResearcher.button1pressed==false){
				mc.player.playSound(ModSoundHandler.MAWSOUND_CORRECT, 1.0f, 1.0f);
				TileEntityPointsBlock.playerScore += 20;
				Utils.getLogger().info("Button 1 Pressed");
				button1.enabled=false;
				TileEntityArtifactResearcher.button1enabled=true;
				s1 = "§2"+"CORRECT A Pharoh was indeed the ruler of Egypt just like a King or an Emporer";
				TileEntityArtifactResearcher.button1pressed=true;
			}
			break;
		case BUTTON1F:
			if(TileEntityArtifactResearcher.button1pressed==false){
			Utils.getLogger().info("Button 1 False Pressed");
			mc.player.playSound(ModSoundHandler.MAWSOUND_INCORRECT, 1.0f, 1.0f);
			TileEntityPointsBlock.playerScore -= 10;
			button1.enabled=false;
			TileEntityArtifactResearcher.button1enabled=true;
			TileEntityArtifactResearcher.button1pressed=true;
			s1 = "§c"+"INCORRECT A Pharoh was infact the ruler of Egypt. Just like a King or an Emporer";
			}
		break;
		
		
		case BUTTON2:
			if(TileEntityArtifactResearcher.button2pressed==false){
				mc.player.playSound(ModSoundHandler.MAWSOUND_CORRECT, 1.0f, 1.0f);
				TileEntityPointsBlock.playerScore += 20;
				Utils.getLogger().info("Button 2 Pressed");
				button2.enabled=false;
				TileEntityArtifactResearcher.button2enabled=true;
				s2 = "§2"+"CORRECT Ankh Hieroglyph represents Life";
				TileEntityArtifactResearcher.button2pressed=true;
			}
		break;
		
		case BUTTON2F:
			if(TileEntityArtifactResearcher.button2pressed==false){
				Utils.getLogger().info("Button 1 False Pressed");
				mc.player.playSound(ModSoundHandler.MAWSOUND_INCORRECT, 1.0f, 1.0f);
				TileEntityPointsBlock.playerScore -= 10;
				button2.enabled=false;
				TileEntityArtifactResearcher.button2enabled=true;
				TileEntityArtifactResearcher.button2pressed=true;
				s2 = "§c"+"INCORRECT The Ankh Hieroglyph does infact mean Life";
				}
		break;
		case BUTTON3:
			if(TileEntityArtifactResearcher.button3pressed==false){
				mc.player.playSound(ModSoundHandler.MAWSOUND_CORRECT, 1.0f, 1.0f);
				TileEntityPointsBlock.playerScore += 20;
				Utils.getLogger().info("Button 3 Pressed");
				button3.enabled=false;
				TileEntityArtifactResearcher.button3enabled=true;
				s3 = "§2"+"CORRECT Tutankhamuns reign started when he was just 9 and ended when he died at age 18";
				TileEntityArtifactResearcher.button3pressed=true;
			}
		
		case BUTTON3F:
			if(TileEntityArtifactResearcher.button3pressed==false){
				Utils.getLogger().info("Button 3 False Pressed");
				mc.player.playSound(ModSoundHandler.MAWSOUND_INCORRECT, 1.0f, 1.0f);
				TileEntityPointsBlock.playerScore -= 10;
				button3.enabled=false;
				TileEntityArtifactResearcher.button3enabled=true;
				TileEntityArtifactResearcher.button3pressed=true;
				s3 = "§c"+"INCORRECT Tutankhamun did infact die at 18 years old";
				}
		break;
		case BUTTON4:
			if(TileEntityArtifactResearcher.button4pressed==false){
				Utils.getLogger().info("Button 4  Pressed");
				mc.player.playSound(ModSoundHandler.MAWSOUND_CORRECT, 1.0f, 1.0f);
				TileEntityPointsBlock.playerScore -= 10;
				button4.enabled=false;
				TileEntityArtifactResearcher.button4enabled=true;
				TileEntityArtifactResearcher.button4pressed=true;
				s4 = "§2"+"CORRECT In addition to paper, pens and toothpaste, they also invented Locks and Keys.";
				}
		break;
		
		case BUTTON4F:
			if(TileEntityArtifactResearcher.button4pressed==false){
				mc.player.playSound(ModSoundHandler.MAWSOUND_INCORRECT, 1.0f, 1.0f);
				TileEntityPointsBlock.playerScore += 20;
				Utils.getLogger().info("Button 4F Pressed");
				button4.enabled=false;
				TileEntityArtifactResearcher.button4enabled=true;
				s4 = "§c"+"INCORRECT The Ancient Egyptians created the first forms of paper, pens and toothpaste. They also invented Locks and Keys.";
				TileEntityArtifactResearcher.button4pressed=true;
			}
		break;
		case BUTTON5:
			if(TileEntityArtifactResearcher.button5pressed==false){
				Utils.getLogger().info("Button 5  Pressed");
				mc.player.playSound(ModSoundHandler.MAWSOUND_INCORRECT, 1.0f, 1.0f);
				TileEntityPointsBlock.playerScore -= 10;
				button5false.enabled=false;
				TileEntityArtifactResearcher.button5enabled=true;
				TileEntityArtifactResearcher.button5pressed=true;
				s5 = "§c"+"INCORRECT The Ancient Egyptian had over 700 Hieroglyphs in its Alphabet";
				}
		break;
		
		case BUTTON5F:
			if(TileEntityArtifactResearcher.button5pressed==false){
				mc.player.playSound(ModSoundHandler.MAWSOUND_CORRECT, 1.0f, 1.0f);
				TileEntityPointsBlock.playerScore += 20;
				Utils.getLogger().info("Button 5F Pressed");
				button5false.enabled=false;
				TileEntityArtifactResearcher.button5enabled=true;
				s5 = "§2"+"CORRECT There were over 700 Hieroglyphs in the Ancient Egyptian Alphabet";
				TileEntityArtifactResearcher.button5pressed=true;
			}
		break;
		
		case RIGHT1T:
			if(TileEntityArtifactResearcher.right1tpressed==false){
				Utils.getLogger().info("Right 1 Pressed");
				mc.player.playSound(ModSoundHandler.MAWSOUND_INCORRECT, 1.0f, 1.0f);
				TileEntityPointsBlock.playerScore -= 10;
				right1f.enabled=false;
				TileEntityArtifactResearcher.right1tenabled=true;
				TileEntityArtifactResearcher.right1tpressed=true;
				s6 = "§c"+"INCORRECT The Sphinx is a mythical creature that has the body of a Lion and the Head of a Man";
				}
		break;
		
		case RIGHT1F:
			if(TileEntityArtifactResearcher.right1tpressed==false){
				mc.player.playSound(ModSoundHandler.MAWSOUND_CORRECT, 1.0f, 1.0f);
				TileEntityPointsBlock.playerScore += 20;
				Utils.getLogger().info("Button R1F Pressed");
				right1f.enabled=false;
				TileEntityArtifactResearcher.right1tenabled=true;
				s6 = "§2"+"CORRECT The Sphinx is infact a mythical creature that has the body of a Lion and the Head of a Man";
				TileEntityArtifactResearcher.right1tpressed=true;
			}
		break;
		
		case RIGHT2T:
			if(TileEntityArtifactResearcher.right2tpressed==false){
				Utils.getLogger().info("Right 2 Pressed");
				mc.player.playSound(ModSoundHandler.MAWSOUND_INCORRECT, 1.0f, 1.0f);
				TileEntityPointsBlock.playerScore -= 10;
				right2f.enabled=false;
				TileEntityArtifactResearcher.right2tenabled=true;
				TileEntityArtifactResearcher.right2tpressed=true;
				s7 = "§c"+"INCORRECT The Benben Stone or Pyramidion is the top point (Pyramid Tip). It usually had religious markings and symbols aswel as the name of who resided in the Pyramid below inscribed on it";
				}
		break;
		
		case RIGHT2F:
			if(TileEntityArtifactResearcher.right2tpressed==false){
				mc.player.playSound(ModSoundHandler.MAWSOUND_CORRECT, 1.0f, 1.0f);
				TileEntityPointsBlock.playerScore += 20;
				Utils.getLogger().info("Button R2F Pressed");
				right2f.enabled=false;
				TileEntityArtifactResearcher.right2tenabled=true;
				s7 = "§2"+"CORRECT The Benben Stone or Pyramidion is the top point (Pyramid Tip). It usually had religious markings and symbols aswel as the name of who resided in the Pyramid below inscribed on it";
				TileEntityArtifactResearcher.right2tpressed=true;
			}
		break;
		case RIGHT3T:
			if(TileEntityArtifactResearcher.right3tpressed==false){
				Utils.getLogger().info("Right 3 Pressed");
				mc.player.playSound(ModSoundHandler.MAWSOUND_INCORRECT, 1.0f, 1.0f);
				TileEntityPointsBlock.playerScore -= 10;
				right3f.enabled=false;
				TileEntityArtifactResearcher.right3tenabled=true;
				TileEntityArtifactResearcher.right3tpressed=true;
				s8 = "§c"+"INCORRECT Tutankhamun was actually nicknamed the Boy King as his reign started when he was just 9 Years old";
				}
		break;
		
		case RIGHT3F:
			if(TileEntityArtifactResearcher.right3tpressed==false){
				mc.player.playSound(ModSoundHandler.MAWSOUND_CORRECT, 1.0f, 1.0f);
				TileEntityPointsBlock.playerScore += 20;
				Utils.getLogger().info("Button R3F Pressed");
				right3f.enabled=false;
				TileEntityArtifactResearcher.right3tenabled=true;
				s8 = "§2"+"CORRECT Tutankhamun was actually nicknamed the Boy King as his reign started when he was just 9 Years old";
				TileEntityArtifactResearcher.right3tpressed=true;
			}
		break;
		
		case RIGHT4T:
			if(TileEntityArtifactResearcher.right4tpressed==false){
				mc.player.playSound(ModSoundHandler.MAWSOUND_INCORRECT, 1.0f, 1.0f);
				TileEntityPointsBlock.playerScore += 20;
				Utils.getLogger().info("Button R4 Pressed");
				right4f.enabled=false;
				TileEntityArtifactResearcher.right4tenabled=true;
				s9 = "§c"+"INCORRECT Canopic Jars were used to store and perserve the organs of the deceased";
				TileEntityArtifactResearcher.right4tpressed=true;
			}
		break;
		case RIGHT4F:
			if(TileEntityArtifactResearcher.right4tpressed==false){
				Utils.getLogger().info("R4F Pressed");
				mc.player.playSound(ModSoundHandler.MAWSOUND_CORRECT, 1.0f, 1.0f);
				TileEntityPointsBlock.playerScore -= 10;
				right4f.enabled=false;
				TileEntityArtifactResearcher.right4tenabled=true;
				TileEntityArtifactResearcher.right4tpressed=true;
				s9 = "§2"+"CORRECT Canopic Jars were infact used to store and perserve the organs of the deceased";
				}
		break;
		
		case RIGHT5T:
			if(TileEntityArtifactResearcher.right5tpressed==false){
				Utils.getLogger().info("Right 5 Pressed");
				mc.player.playSound(ModSoundHandler.MAWSOUND_CORRECT, 1.0f, 1.0f);
				TileEntityPointsBlock.playerScore -= 10;
				right5t.enabled=false;
				TileEntityArtifactResearcher.right5tenabled=true;
				TileEntityArtifactResearcher.right5tpressed=true;
				s10 = "§2"+"CORRECT The afterlife was incredibly important to the Egyptians. They believed that by preserving a dead person’s body, which they did through the process of mummification, their soul would live on in the after-life forever.";
				}
		break;
		
		case RIGHT5F:
			if(TileEntityArtifactResearcher.right5tpressed==false){
				mc.player.playSound(ModSoundHandler.MAWSOUND_INCORRECT, 1.0f, 1.0f);
				TileEntityPointsBlock.playerScore += 20;
				Utils.getLogger().info("Button R5F Pressed");
				right5t.enabled=false;
				TileEntityArtifactResearcher.right5tenabled=true;
				s10 = "§c"+"CORRECT The Ancient Egyptians believed that by preserving a dead person’s body, which they did through the process of mummification, their soul would live on in the after-life forever.";
				TileEntityArtifactResearcher.right5tpressed=true;
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



}
