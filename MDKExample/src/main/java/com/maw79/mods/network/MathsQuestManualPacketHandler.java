package com.maw79.mods.network;

import com.maw79.mods.client.gui.GuiMathsQuestGive;
import com.maw79.mods.init.ModItems;
import com.maw79.mods.init.ModTools;

import net.minecraft.entity.item.EntityItem;
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
				double x = player.posX;
				double y = player.posY;
				double z = player.posZ;

				if(GuiMathsQuestGive.questnumber == 1){
					EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.PRIME_BOOK));
					world.spawnEntity(item1);
					player.sendMessage(new TextComponentString("§c"+"Player Given Prime Quest Manual"));
				}
				else if(GuiMathsQuestGive.questnumber == 2){
					EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.EVEN_BOOK));
					world.spawnEntity(item1);
					player.sendMessage(new TextComponentString("§d"+"Player Given Even Quest Manual"));
				}
				else if(GuiMathsQuestGive.questnumber == 3){
					EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.ODD_BOOK));
					world.spawnEntity(item1);
					player.sendMessage(new TextComponentString("§6"+"Player Given Odd Quest Manual"));
				}
				else if(GuiMathsQuestGive.questnumber == 4){
					EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.NUMBER_SEQUENCE_BOOK));
					world.spawnEntity(item1);
					player.sendMessage(new TextComponentString("§a"+"Player Given Sequence Quest Manual"));
				}


			}
		}
		return null;
	}

}
