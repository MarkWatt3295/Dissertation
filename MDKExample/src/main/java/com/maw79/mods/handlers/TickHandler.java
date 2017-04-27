package com.maw79.mods.handlers;


import com.maw79.mods.blocks.historyblocks.romanquests.TileEntityRomanQuest;
import com.maw79.mods.client.gui.GuiNotif;
import com.maw79.mods.util.Utils;

import net.minecraft.client.Minecraft;
import net.minecraft.world.GameType;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.WorldTickEvent;


public class TickHandler {


public static int ticker = 0;
public static String ticktime = "";

@SubscribeEvent
public void onWorldTick(WorldTickEvent handler){

	if (this.ticker < 100){
		ticker++;
		//System.out.println("Ticks executed:" + ticker);
	} else {
		//do the method
	//	System.out.println("Executed and Done!");
	}
	
}

@SubscribeEvent
public void onPlayerTick(PlayerTickEvent handler){
if(ModEventHandler.romandomus ==true){
	GuiNotif.BUILDERTIME = "start";
	if (this.ticker < 25000){
		Minecraft.getMinecraft().player.setGameType(GameType.SURVIVAL);
		ticker++;
		System.out.println("Player Ticker Ticks executed:" + ticker);
		
		if(ticker < 5000){
			ticktime = "5 Minutes";
			Utils.getLogger().info("5 MINUTES REMAIN");
		}
		else if(ticker == 5000){
			ticktime = "4 Minutes";
			Utils.getLogger().info("4 MINUTES REMAIN");
		}
		else if(ticker ==10000){
			ticktime = "3 Minutes";
			Utils.getLogger().info("3 MINUTES REMAIN");
		}
		else if(ticker ==15000){
			ticktime = "2 Minutes";
			Utils.getLogger().info("2 MINUTES REMAIN");
		}
		else if(ticker ==20000){
			ticktime = "1 Minute";
			Utils.getLogger().info("1 MINUTE REMAIN");
		}
		else if(ticker ==25000){
			ticktime = "Done";
			Utils.getLogger().info("1 MINUTES REMAIN");
			TileEntityRomanQuest.buildmodedone = true;
		}
		
	} else {
		//do the method
		Minecraft.getMinecraft().player.setGameType(GameType.ADVENTURE);
		ModEventHandler.romandomus = false;
		ticker=0;
		System.out.println("Player Ticker Executed and Done!");
		GuiNotif.BUILDERTIME = "";
	}


}
}
}
	
 