package com.maw79.mods.network.store;

import com.maw79.mods.client.gui.mathsgui.GuiMathsStore;
import com.maw79.mods.client.gui.mathsgui.GuiScarecrow;
import com.maw79.mods.init.ModBlocks;
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
				double x = player.posX;
				double y = player.posY;
				double z = player.posZ;

				if (GuiScarecrow.buttonvalue == 1){
					EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModTools.fractionstamphalf));
					world.spawnEntity(item1);
				}
				else if (GuiScarecrow.buttonvalue == 2){
					EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModTools.fractionstampthird));
					world.spawnEntity(item1);
				}
				else if (GuiScarecrow.buttonvalue == 3){
					EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModTools.fractionstampquarter));
					world.spawnEntity(item1);

				}
				else if (GuiScarecrow.buttonvalue == 4){
					EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModTools.glassSpade));
					world.spawnEntity(item1);	
				}
				else if (GuiScarecrow.buttonvalue == 5){
					EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModTools.questionwand));
					world.spawnEntity(item1);
				}
			}


		}
		return null;
	}


}
