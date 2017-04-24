package com.maw79.mods.network.store;

import com.maw79.mods.client.gui.mathsgui.GuiMathsStore;
import com.maw79.mods.client.gui.mathsgui.GuiScarecrow;
import com.maw79.mods.init.ModBlocks;
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

public class ScarecrowSalesPacketHandler implements IMessageHandler<ScarecrowSalesMessage, IMessage> {

public boolean setrec;
@Override
 public IMessage onMessage(ScarecrowSalesMessage message, MessageContext ctx) { 
Utils.getLogger().info("Scarecrow Sales message recieved");
 
 

World world = DimensionManager.getWorld(message.dimension);



 if(world == null) return null;
 else if(!world.isRemote) {
 if(ctx.getServerHandler().playerEntity.getEntityId() == message.entityID){
 EntityPlayerMP player = ctx.getServerHandler().playerEntity;

 if (GuiScarecrow.buttonvalue == 1){
 player.connection.playerEntity.inventory.addItemStackToInventory(new ItemStack(ModTools.fractionstamphalf, 1));
 }
 else if (GuiScarecrow.buttonvalue == 2){
	 player.connection.playerEntity.inventory.addItemStackToInventory(new ItemStack(ModTools.fractionstampthird, 1));	
}
 else if (GuiScarecrow.buttonvalue == 3){
	 player.connection.playerEntity.inventory.addItemStackToInventory(new ItemStack(ModTools.fractionstampquarter, 1));	
	 
}
 else if (GuiScarecrow.buttonvalue == 4){
	 player.connection.playerEntity.inventory.addItemStackToInventory(new ItemStack(ModTools.glassSpade, 1));	
}
 else if (GuiScarecrow.buttonvalue == 5){
	 player.connection.playerEntity.inventory.addItemStackToInventory(new ItemStack(ModTools.questionwand, 1));	
}
 }

 
 }
 return null;
 }


}
