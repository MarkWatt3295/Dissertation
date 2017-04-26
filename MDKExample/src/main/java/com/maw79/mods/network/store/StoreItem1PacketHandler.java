package com.maw79.mods.network.store;

import com.maw79.mods.client.gui.GuiStoreDisplay2;
import com.maw79.mods.init.ModItems;
import com.maw79.mods.init.ModTools;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class StoreItem1PacketHandler implements IMessageHandler<StoreItem1Message, IMessage> {


	@Override
	public IMessage onMessage(StoreItem1Message message, MessageContext ctx) { 
		System.out.println("GUI Inventory message recieved");



		World world = DimensionManager.getWorld(message.dimension);



		if(world == null) return null;
		else if(!world.isRemote) {
			if(ctx.getServerHandler().playerEntity.getEntityId() == message.entityID){
				EntityPlayerMP player = ctx.getServerHandler().playerEntity;
				double x = player.posX;
				double y = player.posY;
				double z = player.posZ;

				if (GuiStoreDisplay2.buttonvalue == 1){
					EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.MATHS_TOKEN));
					world.spawnEntity(item1);
				}
				else if (GuiStoreDisplay2.buttonvalue == 2){
					EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.ENGLISH_TOKEN));
					world.spawnEntity(item1);	
				}
				else if (GuiStoreDisplay2.buttonvalue == 3){
					EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.SCIENCE_TOKEN));
					world.spawnEntity(item1);	

				}
				else if (GuiStoreDisplay2.buttonvalue == 4){
					EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.HISTORY_TOKEN));
					world.spawnEntity(item1);
				}
				else if (GuiStoreDisplay2.buttonvalue == 5){
					EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.FREEPLAY_TOKEN));
					world.spawnEntity(item1);	
				}
			}


		}
		return null;
	}


}
