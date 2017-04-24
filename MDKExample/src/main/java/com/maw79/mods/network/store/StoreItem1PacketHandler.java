package com.maw79.mods.network.store;

import com.maw79.mods.client.gui.GuiStoreDisplay2;
import com.maw79.mods.init.ModItems;
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

 if (GuiStoreDisplay2.buttonvalue == 1){
 player.connection.playerEntity.inventory.addItemStackToInventory(new ItemStack(ModItems.MATHS_TOKEN, 1));
 }
 else if (GuiStoreDisplay2.buttonvalue == 2){
	 player.connection.playerEntity.inventory.addItemStackToInventory(new ItemStack(ModItems.ENGLISH_TOKEN, 1));	
}
 else if (GuiStoreDisplay2.buttonvalue == 3){
	 player.connection.playerEntity.inventory.addItemStackToInventory(new ItemStack(ModItems.SCIENCE_TOKEN, 1));	
	 
}
 else if (GuiStoreDisplay2.buttonvalue == 4){
	 player.connection.playerEntity.inventory.addItemStackToInventory(new ItemStack(ModItems.HISTORY_TOKEN, 1));	
}
 else if (GuiStoreDisplay2.buttonvalue == 5){
	 player.connection.playerEntity.inventory.addItemStackToInventory(new ItemStack(ModItems.FREEPLAY_TOKEN, 1));	
}
 }

 
 }
 return null;
 }


}
