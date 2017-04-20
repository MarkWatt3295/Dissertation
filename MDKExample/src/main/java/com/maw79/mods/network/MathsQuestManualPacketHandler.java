package com.maw79.mods.network;

import com.maw79.mods.client.gui.GuiMathsQuestGive;
import com.maw79.mods.init.ModItems;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MathsQuestManualPacketHandler implements IMessageHandler<MathsQuestManualMessage, IMessage> {

@Override
 public IMessage onMessage(MathsQuestManualMessage message, MessageContext ctx) { 
 System.out.println("Quest message recieved");
 


World world = DimensionManager.getWorld(message.dimension);
 if(world == null) return null;
 else if(!world.isRemote) {
 if(ctx.getServerHandler().playerEntity.getEntityId() == message.entityID){
 EntityPlayerMP player = ctx.getServerHandler().playerEntity;
 
if(GuiMathsQuestGive.questnumber == 1){
	player.connection.playerEntity.inventory.addItemStackToInventory(new ItemStack(ModItems.PRIME_BOOK, 1));
	 player.sendMessage(new TextComponentString("§c"+"Player Given Prime Quest Manual"));
}
else if(GuiMathsQuestGive.questnumber == 2){
	player.connection.playerEntity.inventory.addItemStackToInventory(new ItemStack(ModItems.EVEN_BOOK, 1));
	 player.sendMessage(new TextComponentString("§d"+"Player Given Even Quest Manual"));
}
else if(GuiMathsQuestGive.questnumber == 3){
	player.connection.playerEntity.inventory.addItemStackToInventory(new ItemStack(ModItems.ODD_BOOK, 1));
	 player.sendMessage(new TextComponentString("§6"+"Player Given Odd Quest Manual"));
}
else if(GuiMathsQuestGive.questnumber == 4){
	player.connection.playerEntity.inventory.addItemStackToInventory(new ItemStack(ModItems.NUMBER_SEQUENCE_BOOK, 1));
	 player.sendMessage(new TextComponentString("§a"+"Player Given Sequence Quest Manual"));
}
	
	
 }
 }
 return null;
 }

}
