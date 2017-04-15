package com.maw79.mods.client.gui.mathsgui;


import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import com.maw79.mods.main.Reference;
public class GuiMathsTest extends GuiScreen
{
int guiWidth = 176;
int guiHeight = 214;
int guiX = (width - guiWidth)/2;
int guiY = (height - guiHeight)/2;
Minecraft mc = Minecraft.getMinecraft();
GuiButton testButton;


@Override
public void drawScreen(int x, int y, float ticks)
{
fontRendererObj.drawString("100 Points", 0, 20, 0xffffff);
int guiX = (width - guiWidth)/2;
int guiY = (height - guiHeight)/2;
GL11.glColor4f(1, 1, 1, 1);
mc.renderEngine.bindTexture(new ResourceLocation(Reference.MOD_ID, "textures/gui/division.png"));
drawTexturedModalRect(guiX, guiY, 0, 0, guiWidth, guiHeight);

super.drawScreen(x, y, ticks);
}

@Override
public void initGui()
{

int guiX = (width - guiWidth)/2;
int guiY = (height - guiHeight)/2;
buttonList.clear();
buttonList.add(testButton = new GuiButton(0, guiX + 10, guiY + 30, 20, 10, "Test"));
super.initGui();
}

@Override
public void actionPerformed(GuiButton testButton)

{

System.out.println("You clicked the button");
}
}