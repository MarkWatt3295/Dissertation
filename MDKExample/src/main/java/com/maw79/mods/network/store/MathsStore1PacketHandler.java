package com.maw79.mods.network.store;

import com.maw79.mods.client.gui.GuiStoreDisplay2;
import com.maw79.mods.client.gui.mathsgui.GuiMathsStore;
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
				double x = player.posX;
				double y = player.posY;
				double z = player.posZ;

				if (GuiMathsStore.buttonvalue == 1){
					EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(Blocks.TORCH));
					world.spawnEntity(item1);
				}
				else if (GuiMathsStore.buttonvalue == 2){
					EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.LEVITATION_DUST));
					world.spawnEntity(item1);	
				}
				else if (GuiMathsStore.buttonvalue == 3){
					EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModTools.glassPickaxe));
					world.spawnEntity(item1);
				}
				else if (GuiMathsStore.buttonvalue == 4){
					EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.PAINT_ARROW, 2));
					world.spawnEntity(item1);	
				}
				else if (GuiMathsStore.buttonvalue == 5){
					EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.CHEAT_BOOK));
					world.spawnEntity(item1);	
				}
			}


		}
		return null;
	}


}
