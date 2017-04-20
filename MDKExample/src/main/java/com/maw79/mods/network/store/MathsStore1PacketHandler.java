package com.maw79.mods.network.store;

import com.maw79.mods.client.gui.GuiStoreDisplay2;
import com.maw79.mods.client.gui.mathsgui.GuiMathsStore;
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

public class MathsStore1PacketHandler implements IMessageHandler<MathsStore1Message, IMessage> {

public boolean setrec;
@Override
 public IMessage onMessage(MathsStore1Message message, MessageContext ctx) { 
Utils.getLogger().info("Maths Store 1 message recieved");
 
 

World world = DimensionManager.getWorld(message.dimension);



 if(world == null) return null;
 else if(!world.isRemote) {
 if(ctx.getServerHandler().playerEntity.getEntityId() == message.entityID){
 EntityPlayerMP player = ctx.getServerHandler().playerEntity;

 if (GuiMathsStore.buttonvalue == 1){
 player.connection.playerEntity.inventory.addItemStackToInventory(new ItemStack(Blocks.TORCH, 4));
 }
 else if (GuiMathsStore.buttonvalue == 2){
	 player.connection.playerEntity.inventory.addItemStackToInventory(new ItemStack(ModItems.LEVITATION_DUST, 1));	
}
 else if (GuiMathsStore.buttonvalue == 3){
	 player.connection.playerEntity.inventory.addItemStackToInventory(new ItemStack(ModTools.glassPickaxe, 1));	
}
 else if (GuiMathsStore.buttonvalue == 4){
	 player.connection.playerEntity.inventory.addItemStackToInventory(new ItemStack(ModItems.PAINT_ARROW, 2));	
}
 else if (GuiMathsStore.buttonvalue == 5){
	 player.connection.playerEntity.inventory.addItemStackToInventory(new ItemStack(ModItems.CHEAT_BOOK, 1));	
}
 }

 
 }
 return null;
 }


}
