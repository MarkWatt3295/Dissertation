package com.maw79.mods.network;

import com.maw79.mods.blocks.pointsblocks.TileEntityPointsBlock;
import com.maw79.mods.blocks.scienceblocks.propertiesmatcher.TileEntityPropertiesMatcher;
import com.maw79.mods.client.gui.GuiNotif;
import com.maw79.mods.client.gui.historygui.GuiEgyptStore;
import com.maw79.mods.init.ModItems;
import com.maw79.mods.util.Utils;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class LabelPacketHandler implements IMessageHandler<LabelMessage, IMessage> {

@Override
 public IMessage onMessage(LabelMessage message, MessageContext ctx) { 
 Utils.getLogger().info("Label Message Recieved");
 


World world = DimensionManager.getWorld(message.dimension);
 if(world == null) return null;
 else if(!world.isRemote) {
 if(ctx.getServerHandler().playerEntity.getEntityId() == message.entityID){
 EntityPlayerMP player = ctx.getServerHandler().playerEntity;

	double x = player.posX;
	double y = player.posY;
	double z = player.posZ;
 
 if (TileEntityPropertiesMatcher.labelType.equals("Chairs")){
		EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.LABELCHAIR));
		TileEntityPropertiesMatcher.labelType="";
		world.spawnEntity(item1);
	}
 else if (TileEntityPropertiesMatcher.labelType.equals("Durable")){
		EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.LABELDURABLE));
		TileEntityPropertiesMatcher.labelType="";
		world.spawnEntity(item1);
	}
 else if (TileEntityPropertiesMatcher.labelType.equals("Flexible")){
		EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.LABELFLEXIBLE));
		TileEntityPropertiesMatcher.labelType="";
		world.spawnEntity(item1);
	}
 else if (TileEntityPropertiesMatcher.labelType.equals("Opaque")){
		EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.LABELOPAQUE));
		TileEntityPropertiesMatcher.labelType="";
		world.spawnEntity(item1);
	}
 else if (TileEntityPropertiesMatcher.labelType.equals("Strong")){
		EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.LABELSTRONG));
		TileEntityPropertiesMatcher.labelType="";
		world.spawnEntity(item1);
	}
 else if (TileEntityPropertiesMatcher.labelType.equals("Tough")){
		EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.LABELTOUGH));
		TileEntityPropertiesMatcher.labelType="";
		world.spawnEntity(item1);
	}
	
 }
 }
 return null;
 }

}
