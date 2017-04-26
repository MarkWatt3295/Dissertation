package com.maw79.mods.network.store;

import com.maw79.mods.client.gui.mathsgui.GuiFarmerCoins;
import com.maw79.mods.client.gui.mathsgui.GuiMathsStore;
import com.maw79.mods.init.ModItems;
import com.maw79.mods.init.ModTools;
import com.maw79.mods.util.Utils;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class FarmerCoinsPacketHandler implements IMessageHandler<FarmerCoinsMessage, IMessage> {

	public boolean setrec;
	@Override
	public IMessage onMessage(FarmerCoinsMessage message, MessageContext ctx) { 
		Utils.getLogger().info("Farmer Coins message recieved");



		World world = DimensionManager.getWorld(message.dimension);

		if(world == null) return null;
		else if(!world.isRemote) {
			if(ctx.getServerHandler().playerEntity.getEntityId() == message.entityID){
				EntityPlayerMP player = ctx.getServerHandler().playerEntity;
				double x = player.posX;
				double y = player.posY;
				double z = player.posZ;

				if (GuiFarmerCoins.buttonvalue == 1){
					EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(Blocks.LADDER));
					world.spawnEntity(item1);
				}
				else if (GuiFarmerCoins.buttonvalue == 2){
					EntityItem item2 = new EntityItem(world, x, y, z, new ItemStack(ModTools.glassSpade));
					world.spawnEntity(item2);
				}
				else if (GuiFarmerCoins.buttonvalue == 3){	
					EntityItem item3 = new EntityItem(world, x, y, z, new ItemStack(Blocks.GLOWSTONE));
					world.spawnEntity(item3);
				}
				else if (GuiFarmerCoins.buttonvalue == 4){
					EntityItem item4 = new EntityItem(world, x, y, z, new ItemStack(Blocks.TORCH));
					world.spawnEntity(item4);
				}
				else if (GuiFarmerCoins.buttonvalue == 5){
					EntityItem item5 = new EntityItem(world, x, y, z, new ItemStack(ModItems.FRACTIONS_BOOK));
					world.spawnEntity(item5);
				}
			}


		}
		return null;
	}


}
