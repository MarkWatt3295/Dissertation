package com.maw79.mods.network;

import com.maw79.mods.client.gui.mathsgui.GuiXyzDevice;
import com.maw79.mods.handlers.ModSoundHandler;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class YmanagerPacketHandler implements IMessageHandler<YmanagerMessage, IMessage> {

@Override
 public IMessage onMessage(YmanagerMessage message, MessageContext ctx) { 
 System.out.println("Maths message recieved");
 
 int xyzresponse = GuiXyzDevice.answer;


System.out.println("******************  "+ xyzresponse + "  ******************");


World world = DimensionManager.getWorld(message.dimension);
 if(world == null) return null;
 else if(!world.isRemote) {
 if(ctx.getServerHandler().playerEntity.getEntityId() == message.entityID){
 EntityPlayerMP player = ctx.getServerHandler().playerEntity;
 

 player.connection.setPlayerLocation(player.posX, player.posY + xyzresponse, player.posZ, player.rotationYaw, player.rotationPitch);
 System.out.println(xyzresponse + " Added to player Y");
 player.sendMessage(new TextComponentString(xyzresponse + " Added to player Y"));


 
 }
 }
 return null;
 }

}
