package com.maw79.mods.network;

import com.maw79.mods.client.gui.GuiMathsQuestGive;
import com.maw79.mods.client.gui.mathsgui.GuiFarmerJoe;
import com.maw79.mods.init.ModItems;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class FractionsManualPacketHandler implements IMessageHandler<FractionsManualMessage, IMessage> {

@Override
 public IMessage onMessage(FractionsManualMessage message, MessageContext ctx) { 
 System.out.println("Fractions Manual message recieved");
 


World world = DimensionManager.getWorld(message.dimension);
 if(world == null) return null;
 else if(!world.isRemote) {
 if(ctx.getServerHandler().playerEntity.getEntityId() == message.entityID){
 EntityPlayerMP player = ctx.getServerHandler().playerEntity;
 
if(GuiFarmerJoe.questnumber == 1){
	player.connection.playerEntity.inventory.addItemStackToInventory(new ItemStack(ModItems.FRACTIONS_BOOK, 1));
	 player.sendMessage(new TextComponentString("§c"+"Player Given Fractions Quest Manual"));
}
else if(GuiFarmerJoe.questnumber == 2){
	player.connection.playerEntity.inventory.addItemStackToInventory(new ItemStack(ModItems.FRACTIONS_BOOK, 1));
	 player.sendMessage(new TextComponentString("§d"+"Player Given Fractions Quest Manual"));
}
else if(GuiFarmerJoe.questnumber == 3){
	player.connection.playerEntity.inventory.addItemStackToInventory(new ItemStack(ModItems.FRACTIONS_BOOK, 1));
	 player.sendMessage(new TextComponentString("§6"+"Player Given Fractions Quest Manual"));
}
else if(GuiFarmerJoe.questnumber == 4){
	player.connection.playerEntity.inventory.addItemStackToInventory(new ItemStack(ModItems.FRACTIONS_BOOK, 1));
	 player.sendMessage(new TextComponentString("§a"+"Player Given XYZ Quest Manual"));
}
	
	
 }
 }
 return null;
 }

}
