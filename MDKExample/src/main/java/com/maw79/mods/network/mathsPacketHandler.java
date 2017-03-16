package com.maw79.mods.network;

import java.util.Random;

import com.maw79.mods.init.ModBlocks;
import com.maw79.mods.init.ModItems;
import com.maw79.mods.init.ModTools;
import com.maw79.mods.util.Utilities;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class mathsPacketHandler implements IMessageHandler<MathsMessage, IMessage> {

@Override
 public IMessage onMessage(MathsMessage message, MessageContext ctx) { 
 System.out.println("Maths message recieved");
 
 int max = 3; 
int min = 1;
Random rand = new Random();
int randomNum = rand.nextInt(( max - min)+1)+min;
System.out.println("******************  "+ randomNum + "  ******************");
int randanswer  =  randomNum;
System.out.println("******************  "+ randanswer + "  ******************");

World world = DimensionManager.getWorld(message.dimension);
 if(world == null) return null;
 else if(!world.isRemote) {
 if(ctx.getServerHandler().playerEntity.getEntityId() == message.entityID){
 EntityPlayerMP player = ctx.getServerHandler().playerEntity;
 
if (randanswer == 1){
	player.connection.playerEntity.inventory.addItemStackToInventory(new ItemStack(ModTools.paintbrush, 1));
	 player.sendMessage(new TextComponentString("*Player Given a Good Paint Brush*"));
	
}
else if (randanswer == 2){
	player.connection.playerEntity.inventory.addItemStackToInventory(new ItemStack(ModTools.mediumpaintbrush, 1));
	 player.sendMessage(new TextComponentString("*Player Given a Medium Paint Brush*"));
}
else if (randanswer == 3){
	player.connection.playerEntity.inventory.addItemStackToInventory(new ItemStack(ModTools.rustypaintbrush, 1));
	 player.sendMessage(new TextComponentString("*Player Given a Rusty Paint Brush*"));
}
 
 }
 }
 return null;
 }

}
/*
 *  //int max = 5; Previously used to give Random ammount of MAth Blocks
// int min = 1;
 Random rand = new Random();
 int randomNum = rand.nextInt(( max - min)+1)+min;
 System.out.println("££££££££££ "+ randomNum + " £££££££££££");
 int randanswer  =  randomNum;
 System.out.println("££££££££££ "+ randanswer + " £££££££££££");
  player.connection.playerEntity.inventory.addItemStackToInventory(new ItemStack(ModBlocks.mathblockwhite, randanswer));
 */
