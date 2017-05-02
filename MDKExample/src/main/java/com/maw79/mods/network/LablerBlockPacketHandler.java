package com.maw79.mods.network;

import java.util.Random;

import com.maw79.mods.blocks.scienceblocks.propertiesmatcher.TileEntityPropertiesMatcher;
import com.maw79.mods.init.ModItems;
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

public class LablerBlockPacketHandler implements IMessageHandler<LablerBlockMessage, IMessage> {

	@Override
	public IMessage onMessage(LablerBlockMessage message, MessageContext ctx) { 
		System.out.println("Labler Block message recieved");

		int max = 25; 
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
					player.sendMessage(new TextComponentString("§4"+"Player Given a Random Label"));
					EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.LABELCHAIR));
					TileEntityPropertiesMatcher.labelType="";
					world.spawnEntity(item1);
						
					}
				if (randanswer == 2){
					player.sendMessage(new TextComponentString("§4"+"Player Given a Random Label"));
						EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.LABELDURABLE));
						TileEntityPropertiesMatcher.labelType="";
						world.spawnEntity(item1);
					}
				if (randanswer == 3){
					player.sendMessage(new TextComponentString("§4"+"Player Given a Random Label"));
						EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.LABELFLEXIBLE));
						TileEntityPropertiesMatcher.labelType="";
						world.spawnEntity(item1);
					}
				if (randanswer == 4){
					player.sendMessage(new TextComponentString("§4"+"Player Given a Random Label"));
						EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.LABELOPAQUE));
						TileEntityPropertiesMatcher.labelType="";
						world.spawnEntity(item1);
					}
				if (randanswer == 5){
					player.sendMessage(new TextComponentString("§4"+"Player Given a Random Label"));
					player.sendMessage(new TextComponentString("§4"+"Player Given a Random Label"));
						EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.LABELSTRONG));
						TileEntityPropertiesMatcher.labelType="";
						world.spawnEntity(item1);
					}
				if (randanswer == 6){
					player.sendMessage(new TextComponentString("§4"+"Player Given a Random Label"));
						EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.LABELTOUGH));
						TileEntityPropertiesMatcher.labelType="";
						world.spawnEntity(item1);
					}
				if (randanswer == 7){
					player.sendMessage(new TextComponentString("§4"+"Player Given a Random Label"));
						EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.LABELFERROUS));
						TileEntityPropertiesMatcher.labelType="";
						world.spawnEntity(item1);
					}
				if (randanswer == 8){
					player.sendMessage(new TextComponentString("§4"+"Player Given a Random Label"));
						EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.LABELNONFERROUS));
						TileEntityPropertiesMatcher.labelType="";
						world.spawnEntity(item1);
					}
				if (randanswer == 9){
					player.sendMessage(new TextComponentString("§4"+"Player Given a Random Label"));
						EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.LABELMAGNETIC));
						TileEntityPropertiesMatcher.labelType="";
						world.spawnEntity(item1);
					}
				if (randanswer == 10){
					player.sendMessage(new TextComponentString("§4"+"Player Given a Random Label"));
						EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.LABELLUSTROUS));
						TileEntityPropertiesMatcher.labelType="";
						world.spawnEntity(item1);
					}
				if (randanswer == 11){
					player.sendMessage(new TextComponentString("§4"+"Player Given a Random Label"));
						EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.LABELHIGHDENSITY));
						TileEntityPropertiesMatcher.labelType="";
						world.spawnEntity(item1);
					}
				if (randanswer == 12){
					player.sendMessage(new TextComponentString("§4"+"Player Given a Random Label"));
						EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.LABELFRAGILE));
						TileEntityPropertiesMatcher.labelType="";
						world.spawnEntity(item1);
					}
				if (randanswer == 13){
					player.sendMessage(new TextComponentString("§4"+"Player Given a Random Label"));
						EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.LABELTRANSPARENT));
						TileEntityPropertiesMatcher.labelType="";
						world.spawnEntity(item1);
					}
				if (randanswer == 14){
					player.sendMessage(new TextComponentString("§4"+"Player Given a Random Label"));
						EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.LABELSPECTACLES));
						TileEntityPropertiesMatcher.labelType="";
						world.spawnEntity(item1);
					}
				if (randanswer == 15){
					player.sendMessage(new TextComponentString("§4"+"Player Given a Random Label"));
						EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.LABELWINDOWS));
						TileEntityPropertiesMatcher.labelType="";
						world.spawnEntity(item1);
					}
				if (randanswer == 16){
					player.sendMessage(new TextComponentString("§4"+"Player Given a Random Label"));
						EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.LABELBAGS));
						TileEntityPropertiesMatcher.labelType="";
						world.spawnEntity(item1);
					}
				if (randanswer == 17){
					player.sendMessage(new TextComponentString("§4"+"Player Given a Random Label"));
						EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.LABELWATERPROOF));
						TileEntityPropertiesMatcher.labelType="";
						world.spawnEntity(item1);
					}
				if (randanswer == 18){
					player.sendMessage(new TextComponentString("§4"+"Player Given a Random Label"));
						EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.LABELTOXICITY));
						TileEntityPropertiesMatcher.labelType="";
						world.spawnEntity(item1);
					}
				if (randanswer == 19){
					player.sendMessage(new TextComponentString("§4"+"Player Given a Random Label"));
						EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.LABELACRYLIC));
						TileEntityPropertiesMatcher.labelType="";
						world.spawnEntity(item1);
					}
				if (randanswer == 20){
					player.sendMessage(new TextComponentString("§4"+"Player Given a Random Label"));
						EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.LABELPVC));
						TileEntityPropertiesMatcher.labelType="";
						world.spawnEntity(item1);
					}
				if (randanswer == 21){
					player.sendMessage(new TextComponentString("§4"+"Player Given a Random Label"));
						EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.LABELCELLOPHANE));
						TileEntityPropertiesMatcher.labelType="";
						world.spawnEntity(item1);
					}
				if (randanswer == 22){
					player.sendMessage(new TextComponentString("§4"+"Player Given a Random Label"));
						EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.LABELPOLYTHENE));
						TileEntityPropertiesMatcher.labelType="";
						world.spawnEntity(item1);
					}
				if (randanswer == 23){
					player.sendMessage(new TextComponentString("§4"+"Player Given a Random Label"));
						EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.LABELANTISTATIC));
						TileEntityPropertiesMatcher.labelType="";
						world.spawnEntity(item1);
					}
				if (randanswer == 24){
					player.sendMessage(new TextComponentString("§4"+"Player Given a Random Label"));
						EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.LABELPOTTERY));
						TileEntityPropertiesMatcher.labelType="";
						world.spawnEntity(item1);
					}
				if (randanswer == 25){
					player.sendMessage(new TextComponentString("§4"+"Player Given a Random Label"));
						EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.LABELMUGS));
						TileEntityPropertiesMatcher.labelType="";
						world.spawnEntity(item1);
					}


			}
		}
		return null;
	}

}
