package com.maw79.mods.client.gui;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

import net.minecraft.world.World;
import net.minecraft.server.MinecraftServer;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.Minecraft;

import java.util.Random;

import com.maw79.mods.main.Maw79Mod;



public class Overlay {
	public int playerlevel = 0;
	
		@SubscribeEvent(priority = EventPriority.NORMAL)
		public void eventHandler(RenderGameOverlayEvent event) {

			if (!event.isCancelable() && event.getType() == RenderGameOverlayEvent.ElementType.HELMET) {

				int posX = (event.getResolution().getScaledWidth()) / 2;
				int posY = (event.getResolution().getScaledHeight()) / 2;

				//EntityPlayer entity = Minecraft.getMinecraft().player;
				//int i = (int) entity.posX;
				///int j = (int) entity.posY;
				//int k = (int) entity.posZ;
				//int x = i;
				//int y = j;
				//int z = k;
				//MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
				//World world = server.worlds[0];

				if (true) {
					int s =0;
					
					Minecraft.getMinecraft().fontRendererObj.drawString("Player Level : "+playerlevel, posX + (110), posY + (-107), 0xffffff);
					Minecraft.getMinecraft().fontRendererObj.drawString("Score : ", posX + (140), posY + (-86), 0xffffff);

				}

			}

		}
	}


