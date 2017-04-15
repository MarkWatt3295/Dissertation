package com.maw79.mods.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;

public class GuiNotif extends Gui
{
	public static String playerlevel = "Select A Level";
	public static int playerScore = 0;
	public static int multimax = 5;
	public static int multimin = 0;
	public static int divimax = 5;
	public static int divimin = 1;
    
    
 
    public GuiNotif(Minecraft mc)
    {
        ScaledResolution scaled = new ScaledResolution(mc);
        int width = scaled.getScaledWidth() ;
        int height = scaled.getScaledHeight();
    	//Minecraft.getMinecraft().fontRendererObj.drawString("Score : ", width + (140), height + (-86), 0xffffff);
    	//drawRect(width / 2 + (110), 40, width / 2 + (110), (height / 2) + (-107), Integer.parseInt("FC000B", 16));
        drawString(mc.fontRendererObj, "Score: "+ playerScore, width / 2 + (110), (height / 2) + (-87), Integer.parseInt("FFFFFF", 16));
        
          
        
        
 if(playerlevel == "1"){
	 drawString(mc.fontRendererObj, "Player Level: "+ playerlevel, width / 2 + (110), (height / 2) + (-107), Integer.parseInt("FC000B", 16));
	multimax = 5;
	multimin = 0;
	divimax= 10;
	divimin = 1;
 }
 else if(playerlevel == "2"){
	 drawString(mc.fontRendererObj, "Player Level: "+ playerlevel, width / 2 + (110), (height / 2) + (-107), Integer.parseInt("32FC00", 16));
	 multimax = 10;
	 multimin = 2;
	 divimax = 20;
	 divimin = 2;
 }
 else if(playerlevel == "3"){
	 drawString(mc.fontRendererObj, "Player Level: "+ playerlevel, width / 2 + (110), (height / 2) + (-107), Integer.parseInt("0049FC", 16));
	 multimax = 12;
	 multimin = 5;
	 divimax = 50;
	 divimin = 5;
 }
 else    drawCenteredString(mc.fontRendererObj, "Player Level: "+ playerlevel, width / 2 + (110), (height / 2) + (-107), Integer.parseInt("FFFFFF", 16));
    }
}
