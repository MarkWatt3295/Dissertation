package com.maw79.mods.network;

import java.util.Random;

import com.maw79.mods.blocks.tileentityattempt.ContainerBasic2;
import com.maw79.mods.init.ModBlocks;
import com.maw79.mods.init.ModItems;
import com.maw79.mods.init.ModTools;
import com.maw79.mods.util.Utilities;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GuiInventoryPacketHandler implements IMessageHandler<GuiInventoryMessage, IMessage> {


@Override
 public IMessage onMessage(GuiInventoryMessage message, MessageContext ctx) { 
 System.out.println("GUI Inventory message recieved");
 
 

World world = DimensionManager.getWorld(message.dimension);
 if(world == null) return null;
 else if(!world.isRemote) {
 if(ctx.getServerHandler().playerEntity.getEntityId() == message.entityID){
 EntityPlayerMP player = ctx.getServerHandler().playerEntity;

 //ContainerBasic2.handler.insertItem(7, new ItemStack(Blocks.GOLD_BLOCK), false);

	//player.connection.playerEntity.inventory.addItemStackToInventory(new ItemStack(ModTools.paintbrush, 1));
	 player.sendMessage(new TextComponentString("*Inventory Thingy*"));
	
}

 
 }
 return null;
 }

}
