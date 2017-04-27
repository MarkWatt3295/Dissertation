package com.maw79.mods.client.gui;

import com.maw79.mods.blocks.pointsblocks.TileEntityPointsBlock;
import com.maw79.mods.handlers.TickHandler;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;

public class GuiNotif extends Gui
{
	public static String playerlevel = "Select A Level";
	
	public static int multimax = 5;
	public static int multimin = 1;
	public static int addmax = 20;
	public static int addmin = 10;
	public static String xyztrack ="";
	public static String BUILDERTIME ="";
	
	
    public GuiNotif(Minecraft mc)
    {
        ScaledResolution scaled = new ScaledResolution(mc);
        int width = scaled.getScaledWidth() ;
        int height = scaled.getScaledHeight();
    	
        drawString(mc.fontRendererObj, "Score: "+ TileEntityPointsBlock.playerScore, width / 2 + (110), (height / 2) + (-87), Integer.parseInt("FFFFFF", 16));
        drawString(mc.fontRendererObj, xyztrack, width / 2 + (80), (height / 2) + (-67), Integer.parseInt("FFFFFF", 16));
      
        
        if(BUILDERTIME == "start"){
        drawString(mc.fontRendererObj, "Build Time Left : "+TickHandler.ticktime, width / 2 + (80), (height / 2) + (-67), Integer.parseInt("FFFFFF", 16));
        }
        if(BUILDERTIME == "stop"){
            drawString(mc.fontRendererObj, BUILDERTIME, width / 2 + (80), (height / 2) + (-67), Integer.parseInt("FFFFFF", 16));
            }
          
 if(playerlevel == "1"){
	 drawString(mc.fontRendererObj, "Player Level: "+ playerlevel, width / 2 + (110), (height / 2) + (-107), Integer.parseInt("FC000B", 16));
	multimax = 5;
	multimin = 1;
	addmax= 100;
	addmin = 10;
 }
 else if(playerlevel == "2"){
	 drawString(mc.fontRendererObj, "Player Level: "+ playerlevel, width / 2 + (110), (height / 2) + (-107), Integer.parseInt("32FC00", 16));
	 multimax = 10;
	 multimin = 2;
	 addmax = 500;
	 addmin = 60;
 }
 else if(playerlevel == "3"){
	 drawString(mc.fontRendererObj, "Player Level: "+ playerlevel, width / 2 + (110), (height / 2) + (-107), Integer.parseInt("0049FC", 16));
	 multimax = 12;
	 multimin = 5;
	 addmax = 1000;
	 addmin = 210;
 }
 else    drawCenteredString(mc.fontRendererObj, "Player Level: "+ playerlevel, width / 2 + (110), (height / 2) + (-107), Integer.parseInt("FFFFFF", 16));
    }
    
    
}
