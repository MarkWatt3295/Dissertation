package com.maw79.mods.client.gui;

import com.maw79.mods.main.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;


/**
 * Created by Toby on 16/12/2016.
 */
public class GuiButtonTutorial extends GuiButton {

    final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/gui/book.png");

    int buttonWidth = 16;
    int buttonHeight = 14;
    int u = 175;
    int v = 1;

    public GuiButtonTutorial(int buttonId, int x, int y) {
        super(buttonId, x, y, 16, 14, "");
    }

    @Override
    public void drawButton(Minecraft mc, int mouseX, int mouseY) {
        if (visible) {
            mc.renderEngine.bindTexture(texture);
            if (mouseX >= xPosition && mouseX <= xPosition + width && mouseY >= yPosition && mouseY <= yPosition + height) {
                hovered = true;
            } else {
                hovered = false;
            }
            if (hovered) {
                v = 18;
            } else {
                v = 1;
            }
            drawTexturedModalRect(xPosition, yPosition, u, v, width, height);
        }
    }
}