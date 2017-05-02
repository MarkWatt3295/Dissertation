package com.maw79.mods.network;

import java.util.Random;

import com.maw79.mods.init.ModBlocks;
import com.maw79.mods.init.ModItems;
import com.maw79.mods.init.ModTools;
import com.maw79.mods.util.Utilities;
import com.maw79.mods.util.Utils;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class mathsPacketHandler implements IMessageHandler<MathsMessage, IMessage> {

	@Override
	public IMessage onMessage(MathsMessage message, MessageContext ctx) { 
		System.out.println("Maths message recieved");

		int max = 8; //was 5
		int min = 1;
		Random rand = new Random();
		int randomNum = rand.nextInt(( max - min)+1)+min;
		Utils.getLogger().info("mathsPacketHandler: randomNum "+randomNum);
		int randanswer  =  randomNum;
		Utils.getLogger().info("mathsPacketHandler: randanswer "+randanswer);

		World world = DimensionManager.getWorld(message.dimension);
		if(world == null) return null;
		else if(!world.isRemote) {
			if(ctx.getServerHandler().playerEntity.getEntityId() == message.entityID){
				EntityPlayerMP player = ctx.getServerHandler().playerEntity;
				double x = player.posX;
				double y = player.posY;
				double z = player.posZ;


				if (randanswer == 1){
					EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModTools.paintbrush));
					world.spawnEntity(item1);
					player.sendMessage(new TextComponentString("§4"+"Player Given a Good Paint Brush"));

				}
				else if (randanswer == 2){
					EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModTools.mediumpaintbrush));
					world.spawnEntity(item1);
					player.sendMessage(new TextComponentString("Player Given a Medium Paint Brush"));
				}
				else if (randanswer == 3){
					EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModTools.rustypaintbrush));
					world.spawnEntity(item1);
					player.sendMessage(new TextComponentString("Player Given a Rusty Paint Brush"));
				}
				else if (randanswer == 4){
					EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.PAINT_ARROW));
					world.spawnEntity(item1);
					player.sendMessage(new TextComponentString("Player Given 1 Paint Arrow"));
				}
				else if (randanswer == 5){
					EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.PAINT_ARROW , 3));
					world.spawnEntity(item1);
					player.sendMessage(new TextComponentString("Player Given 3 Paint Arrows"));
				}
				else if (randanswer == 6){
					EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.LEVITATION_DUST));
					world.spawnEntity(item1);
					player.sendMessage(new TextComponentString("Player Given Weak Levitation Dust"));
				}
				else if (randanswer == 7){
					EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.LEVITATION_DUST2));
					world.spawnEntity(item1);
					player.sendMessage(new TextComponentString("Player Given Levitation Dust"));
				}
				else if (randanswer == 8){
					EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.LEVITATION_DUST3));
					world.spawnEntity(item1);
					player.sendMessage(new TextComponentString("Player Given Strong Levitation Dust"));
				}


			}
		}
		return null;
	}

}
