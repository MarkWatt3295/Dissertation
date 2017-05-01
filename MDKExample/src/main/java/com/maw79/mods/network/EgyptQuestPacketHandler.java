package com.maw79.mods.network;

import com.maw79.mods.client.gui.historygui.GuiEgyptianQuests;
import com.maw79.mods.client.gui.historygui.GuiRomanSteve;
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

public class EgyptQuestPacketHandler implements IMessageHandler<EgyptQuestMessage, IMessage> {

	@Override
	public IMessage onMessage(EgyptQuestMessage message, MessageContext ctx) { 
		System.out.println("Quest message recieved");



		World world = DimensionManager.getWorld(message.dimension);
		if(world == null) return null;
		else if(!world.isRemote) {
			if(ctx.getServerHandler().playerEntity.getEntityId() == message.entityID){
				EntityPlayerMP player = ctx.getServerHandler().playerEntity;
				double x = player.posX;
				double y = player.posY;
				double z = player.posZ;

				if(GuiEgyptianQuests.questnumber == 1){
					EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.EGYPT_MANUAL));
					world.spawnEntity(item1);
					player.sendMessage(new TextComponentString("§c"+"Player Given Egypt Artifact Manual"));
				}
				

			}
		}
		return null;
	}

}
