package com.maw79.mods.network;

import com.maw79.mods.blocks.historyblocks.romanquests.GuiRomanQuest;
import com.maw79.mods.client.gui.GuiMathsQuestGive;
import com.maw79.mods.client.gui.historygui.GuiRomanSteve;
import com.maw79.mods.init.ModItems;
import com.maw79.mods.init.ModTools;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class RomanQuestPacketHandler implements IMessageHandler<RomanQuestMessage, IMessage> {

	@Override
	public IMessage onMessage(RomanQuestMessage message, MessageContext ctx) { 
		System.out.println("Quest message recieved");



		World world = DimensionManager.getWorld(message.dimension);
		if(world == null) return null;
		else if(!world.isRemote) {
			if(ctx.getServerHandler().playerEntity.getEntityId() == message.entityID){
				EntityPlayerMP player = ctx.getServerHandler().playerEntity;
				double x = player.posX;
				double y = player.posY;
				double z = player.posZ;

				if(GuiRomanSteve.questnumber == 1){
					EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.DOMUS_BUILDER));
					EntityItem item2 = new EntityItem(world, x, y, z, new ItemStack(ModItems.BUILDER_COIN));
					world.spawnEntity(item1);
					world.spawnEntity(item2);
					player.sendMessage(new TextComponentString("§c"+"Player Given Builder Quest Items"));
				}
				else if(GuiRomanSteve.questnumber == 2){
					EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.ROMAN_ARTIFACTS_MANUAL));
					world.spawnEntity(item1);
					player.sendMessage(new TextComponentString("§c"+"Player Given Relic Hunter Quest Items"));
				}
				else if(GuiRomanSteve.questnumber == 3){
					EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.ODD_BOOK));
					world.spawnEntity(item1);
					player.sendMessage(new TextComponentString("§6"+"Player Given Odd Quest Manual"));
				}
				


			}
		}
		return null;
	}

}
