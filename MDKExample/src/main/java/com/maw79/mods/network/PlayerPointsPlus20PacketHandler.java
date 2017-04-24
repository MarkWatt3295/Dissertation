package com.maw79.mods.network;

import com.maw79.mods.blocks.pointsblocks.TileEntityPointsBlock;
import com.maw79.mods.client.gui.GuiNotif;
import com.maw79.mods.init.ModItems;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PlayerPointsPlus20PacketHandler implements IMessageHandler<PlayerPointsPlus20Message, IMessage> {

@Override
 public IMessage onMessage(PlayerPointsPlus20Message message, MessageContext ctx) { 
 System.out.println("Player Points (PLUS 20) Recieved");
 


World world = DimensionManager.getWorld(message.dimension);
 if(world == null) return null;
 else if(!world.isRemote) {
 if(ctx.getServerHandler().playerEntity.getEntityId() == message.entityID){
 EntityPlayerMP player = ctx.getServerHandler().playerEntity;
 
 
TileEntityPointsBlock.playerScore +=20;
	
 }
 }
 return null;
 }

}
