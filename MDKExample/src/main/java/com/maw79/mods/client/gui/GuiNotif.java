package com.maw79.mods.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;

public class GuiNotif extends Gui
{
	public static String playerlevel = "Select A Level";
	public static int playerScore = 0;
    
    
 
    public GuiNotif(Minecraft mc)
    {
        ScaledResolution scaled = new ScaledResolution(mc);
        int width = scaled.getScaledWidth() ;
        int height = scaled.getScaledHeight();
    	//Minecraft.getMinecraft().fontRendererObj.drawString("Score : ", width + (140), height + (-86), 0xffffff);
    	//drawRect(width / 2 + (110), 40, width / 2 + (110), (height / 2) + (-107), Integer.parseInt("FC000B", 16));
        drawString(mc.fontRendererObj, "Score: "+ playerScore, width / 2 + (110), (height / 2) + (-87), Integer.parseInt("FFFFFF", 16));
        
        
        
           // drawGradientRect(20, 20, width - 20, height - 20, 0x60500000, 0xa0803030);
            //drawRect(60, 60, width - 60, height - 60, 0xFFFFFFFF);
           // drawRect(230, 10, width - 30, height - 130, 0xFFFFFFFF);
        //drawGradientRect(230, 10, width - 20, height - 130, 0x60500000, 0xa0803030);
            //left, top(), right, bottom
          
          
        
        
 if(playerlevel == "1"){
	 drawString(mc.fontRendererObj, "Player Level: "+ playerlevel, width / 2 + (110), (height / 2) + (-107), Integer.parseInt("FC000B", 16));
	
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
