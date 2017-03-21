package com.maw79.mods.client.gui;

import com.maw79.mods.items.mathsitems.Colours;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;

public class GuiNotif extends Gui
{
	public static String playerlevel = "Select A Level";
    String text = "Hello world!";
 
    public GuiNotif(Minecraft mc)
    {
        ScaledResolution scaled = new ScaledResolution(mc);
        int width = scaled.getScaledWidth() ;
        int height = scaled.getScaledHeight();
        
 if(playerlevel == "1"){
	 drawString(mc.fontRendererObj, "Player Level: "+ playerlevel, width / 2 + (110), (height / 2) + (-107), Integer.parseInt("FC000B", 16));
	// drawRect(width / 2 + (110), 40, width / 2 + (110), (height / 2) + (-107), Integer.parseInt("FC000B", 16));
	 
 }
 else if(playerlevel == "2"){
	 
	 drawString(mc.fontRendererObj, "Player Level: "+ playerlevel, width / 2 + (110), (height / 2) + (-107), Integer.parseInt("32FC00", 16));
 }
 else if(playerlevel == "3"){
	 drawString(mc.fontRendererObj, "Player Level: "+ playerlevel, width / 2 + (110), (height / 2) + (-107), Integer.parseInt("0049FC", 16));
 }
 else    drawCenteredString(mc.fontRendererObj, "Player Level: "+ playerlevel, width / 2 + (110), (height / 2) + (-107), Integer.parseInt("FFFFFF", 16));
    }
}
