package com.maw79.mods.network;

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

public class AdminCommandPacketHandler implements IMessageHandler<AdminCommandMessage, IMessage> {

	@Override
	public IMessage onMessage(AdminCommandMessage message, MessageContext ctx) { 
		System.out.println("Admin Command Recieved");



		World world = DimensionManager.getWorld(message.dimension);
		if(world == null) return null;
		else if(!world.isRemote) {
			if(ctx.getServerHandler().playerEntity.getEntityId() == message.entityID){
				EntityPlayerMP player = ctx.getServerHandler().playerEntity;
				double x = player.posX;
				double y = player.posY;
				double z = player.posZ;
				player.connection.playerEntity.inventory.clear();
				EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.GAMETYPE));
				EntityItem item2 = new EntityItem(world, x, y, z, new ItemStack(ModItems.SCOREDEBUG));
				world.spawnEntity(item1);
				world.spawnEntity(item2);
				player.sendMessage(new TextComponentString("§c"+"Admin Mode Enabled"));


			}
		}
		return null;
	}

}
