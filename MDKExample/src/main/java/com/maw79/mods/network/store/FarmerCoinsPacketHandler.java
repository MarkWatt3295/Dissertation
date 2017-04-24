package com.maw79.mods.network.store;

import com.maw79.mods.client.gui.mathsgui.GuiFarmerCoins;
import com.maw79.mods.client.gui.mathsgui.GuiMathsStore;
import com.maw79.mods.init.ModItems;
import com.maw79.mods.init.ModTools;
import com.maw79.mods.util.Utils;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class FarmerCoinsPacketHandler implements IMessageHandler<MathsStore1Message, IMessage> {

public boolean setrec;
@Override
 public IMessage onMessage(MathsStore1Message message, MessageContext ctx) { 
Utils.getLogger().info("Farmer Coins message recieved");
 
 

World world = DimensionManager.getWorld(message.dimension);

 if(world == null) return null;
 else if(!world.isRemote) {
 if(ctx.getServerHandler().playerEntity.getEntityId() == message.entityID){
 EntityPlayerMP player = ctx.getServerHandler().playerEntity;

 if (GuiFarmerCoins.buttonvalue == 1){
 player.connection.playerEntity.inventory.addItemStackToInventory(new ItemStack(Blocks.LADDER, 1));
 }
 else if (GuiFarmerCoins.buttonvalue == 2){
	 player.connection.playerEntity.inventory.addItemStackToInventory(new ItemStack(ModTools.glassSpade, 1));	
}
 else if (GuiFarmerCoins.buttonvalue == 3){
	 player.connection.playerEntity.inventory.addItemStackToInventory(new ItemStack(Blocks.GLOWSTONE, 1));	
}
 else if (GuiFarmerCoins.buttonvalue == 4){
	 player.connection.playerEntity.inventory.addItemStackToInventory(new ItemStack(Blocks.TORCH, 4));	
}
 else if (GuiFarmerCoins.buttonvalue == 5){
	 player.connection.playerEntity.inventory.addItemStackToInventory(new ItemStack(ModItems.FRACTIONS_BOOK, 1));	
}
 }

 
 }
 return null;
 }


}
