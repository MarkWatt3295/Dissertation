package com.maw79.mods.network;

import com.maw79.mods.init.ModBlocks;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketHandler implements IMessageHandler<TeleportMessage, IMessage> {

@Override
 public IMessage onMessage(TeleportMessage message, MessageContext ctx) { 
 System.out.println("message recieved");

World world = DimensionManager.getWorld(message.dimension);
 if(world == null) return null;
 else if(!world.isRemote) {
 if(ctx.getServerHandler().playerEntity.getEntityId() == message.entityID){
 EntityPlayerMP player = ctx.getServerHandler().playerEntity;
 player.connection.setPlayerLocation(player.posX, player.posY + 10, player.posZ, player.rotationYaw, player.rotationPitch);
 player.connection.playerEntity.inventory.addItemStackToInventory(new ItemStack(ModBlocks.mathblockblue));

 }
 }
 return null;
 }

}
