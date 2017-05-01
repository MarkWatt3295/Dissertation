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

public static boolean npcwait = false;
public static boolean npcwait2 = false;
public static boolean wandererwait = false;
public static boolean mummywait = false;
public static int mummytick = 0;
public static int ticker = 0;
public static int npcticker = 0;
public static int npcticker2 = 0;
public static int wandererticker=0;
public static String ticktime = "";
public static int npcchats = 6;

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

@SubscribeEvent
public void onPlayerTick2(PlayerTickEvent handler){
	if(npcwait == true){
		if (this.npcticker < 500){
			npcticker++;
			System.out.println("NPC-wait Ticker Ticks executed:" + npcticker);
	}
		if(npcticker == 500){
			Utils.getLogger().info("Npc Wait Over");
			npcwait =false;
			npcticker = 0;
		}
}
}
@SubscribeEvent
public void romanInfo(PlayerTickEvent handler){
	if(npcwait2 == true){
		if (this.npcticker2 < 350){
			npcticker2++;
			System.out.println("NPC-wait Ticker Ticks executed:" + npcticker2);
	}
		if(npcticker2 == 350){
			Utils.getLogger().info("Npc Wait Over");
			npcwait2 =false;
			npcticker2 = 0;
		}
}
}

@SubscribeEvent
public void explorertick(PlayerTickEvent handler){
	if(wandererwait == true){
		if (this.wandererticker < 350){
			wandererticker++;
			System.out.println("Wander Ticker Ticker Ticks executed:" + wandererticker);
	}
		if(wandererticker == 350){
			Utils.getLogger().info("WanderTicker Wait Over");
			wandererwait =false;
			wandererticker = 0;
		}
}
}

@SubscribeEvent
public void mummyticks(PlayerTickEvent handler){
	if(mummywait == true){
		if (this.mummytick < 350){
			mummytick++;
			System.out.println("Mummy Ticker Ticks executed:" + mummytick);
	}
		if(mummytick == 350){
			Utils.getLogger().info("Mummy Wait Over");
			mummywait =false;
			mummytick = 0;
		}
}
}
}
	
 