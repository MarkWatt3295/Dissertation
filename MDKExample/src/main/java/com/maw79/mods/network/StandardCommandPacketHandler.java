package com.maw79.mods.network;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class StandardCommandPacketHandler implements IMessageHandler<StandardCommandMessage, IMessage> {

	@Override
	public IMessage onMessage(StandardCommandMessage message, MessageContext ctx) { 
		System.out.println("Admin Command Recieved");



		World world = DimensionManager.getWorld(message.dimension);
		if(world == null) return null;
		else if(!world.isRemote) {
			if(ctx.getServerHandler().playerEntity.getEntityId() == message.entityID){
				EntityPlayerMP player = ctx.getServerHandler().playerEntity;

				player.connection.playerEntity.inventory.clear();
				player.sendMessage(new TextComponentString("Standard Mode Enabled"));


			}
		}
		return null;
	}

}
