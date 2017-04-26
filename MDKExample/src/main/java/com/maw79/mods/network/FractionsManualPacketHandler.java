package com.maw79.mods.network;

import com.maw79.mods.client.gui.GuiMathsQuestGive;
import com.maw79.mods.client.gui.mathsgui.GuiFarmerJoe;
import com.maw79.mods.init.ModItems;

import net.minecraft.entity.item.EntityItem;
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
 double x = player.posX;
	double y = player.posY;
	double z = player.posZ;
 
if(GuiFarmerJoe.questnumber == 1){
	EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.FRACTIONS_BOOK));
	world.spawnEntity(item1);
	 player.sendMessage(new TextComponentString("§c"+"Player Given Fractions Quest Manual"));
}
else if(GuiFarmerJoe.questnumber == 2){
	EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.FRACTIONS_BOOK));
	world.spawnEntity(item1);
	 player.sendMessage(new TextComponentString("§d"+"Player Given Fractions Quest Manual"));
}
else if(GuiFarmerJoe.questnumber == 3){
	EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.FRACTIONS_BOOK));
	world.spawnEntity(item1);
	 player.sendMessage(new TextComponentString("§6"+"Player Given Fractions Quest Manual"));
}

	
	
 }
 }
 return null;
 }

}
