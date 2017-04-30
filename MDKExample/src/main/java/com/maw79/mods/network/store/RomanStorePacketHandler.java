package com.maw79.mods.network.store;

import com.maw79.mods.client.gui.historygui.GuiRomanStore;
import com.maw79.mods.client.gui.mathsgui.GuiFarmerCoins;
import com.maw79.mods.client.gui.mathsgui.GuiMathsStore;
import com.maw79.mods.init.ModItems;
import com.maw79.mods.init.ModTools;
import com.maw79.mods.util.Utils;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.datafix.fixes.PotionItems;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class RomanStorePacketHandler implements IMessageHandler<RomanStoreMessage, IMessage> {

	public boolean setrec;
	@Override
	public IMessage onMessage(RomanStoreMessage message, MessageContext ctx) { 
		Utils.getLogger().info("Roman Store message recieved");



		World world = DimensionManager.getWorld(message.dimension);

		if(world == null) return null;
		else if(!world.isRemote) {
			if(ctx.getServerHandler().playerEntity.getEntityId() == message.entityID){
				EntityPlayerMP player = ctx.getServerHandler().playerEntity;
				double x = player.posX;
				double y = player.posY;
				double z = player.posZ;

				if (GuiRomanStore.buttonvalue == 1){
					EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.LEVITATION_DUST2));
					world.spawnEntity(item1);
				}
				else if (GuiRomanStore.buttonvalue == 2){
					EntityItem item2 = new EntityItem(world, x, y, z, new ItemStack(ModItems.BUILDER_COIN));
					world.spawnEntity(item2);
				}
				else if (GuiRomanStore.buttonvalue == 3){	
					EntityItem item3 = new EntityItem(world, x, y, z, new ItemStack(ModItems.JUMP_BOOSTER));
					world.spawnEntity(item3);
				}
				else if (GuiRomanStore.buttonvalue == 4){
					EntityItem item4 = new EntityItem(world, x, y, z, new ItemStack(Blocks.CHEST));
					world.spawnEntity(item4);
				}
				else if (GuiRomanStore.buttonvalue == 5){
					EntityItem item5 = new EntityItem(world, x, y, z, new ItemStack(ModItems.HISTORYBOOK));
					world.spawnEntity(item5);
				}
			}


		}
		return null;
	}


}