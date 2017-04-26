package com.maw79.mods.network.store;

import com.maw79.mods.client.gui.mathsgui.GuiFarmerCoins;
import com.maw79.mods.client.gui.mathsgui.GuiMathsStore;
import com.maw79.mods.init.ModItems;
import com.maw79.mods.init.ModTools;
import com.maw79.mods.util.Utils;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class XYZPacketHandler implements IMessageHandler<XYZMessage, IMessage> {

public boolean setrec;
@Override
 public IMessage onMessage(XYZMessage message, MessageContext ctx) { 
Utils.getLogger().info("XYZ message recieved");
 
 

World world = DimensionManager.getWorld(message.dimension);

 if(world == null) return null;
 else if(!world.isRemote) {
 if(ctx.getServerHandler().playerEntity.getEntityId() == message.entityID){
 EntityPlayerMP player = ctx.getServerHandler().playerEntity;
 double x = player.posX;
 double y = player.posY;
 double z = player.posZ;

	 //player.connection.playerEntity.inventory.addItemStackToInventory(new ItemStack(ModItems.COORDINATES_MANUAL, 1));
	 //player.connection.playerEntity.inventory.addItemStackToInventory(new ItemStack(ModTools.glassSpade, 2));
	// player.connection.playerEntity.inventory.addItemStackToInventory(new ItemStack(ModItems.xaxistool, 1));
	// player.connection.playerEntity.inventory.addItemStackToInventory(new ItemStack(ModItems.yaxistool, 1));
	 //player.connection.playerEntity.inventory.addItemStackToInventory(new ItemStack(ModItems.zaxistool, 1));
	 EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.xaxistool));
	 EntityItem item2 = new EntityItem(world, x, y, z, new ItemStack(ModItems.zaxistool));
	 EntityItem item3 = new EntityItem(world, x, y, z, new ItemStack(ModItems.yaxistool));
	 EntityItem item4 = new EntityItem(world, x, y, z, new ItemStack(ModItems.COORDINATES_MANUAL));
	 EntityItem item5 = new EntityItem(world, x, y, z, new ItemStack(ModTools.glassSpade));
	 EntityItem item6 = new EntityItem(world, x, y, z, new ItemStack(ModTools.glassSpade));
	 world.spawnEntity(item1);
	 world.spawnEntity(item2);
	 world.spawnEntity(item3);
	 world.spawnEntity(item4);
	 world.spawnEntity(item5);
	 world.spawnEntity(item6);

 }

 
 }
 return null;
 }


}
