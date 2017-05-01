package com.maw79.mods.network;

import com.maw79.mods.blocks.pointsblocks.TileEntityPointsBlock;
import com.maw79.mods.blocks.scienceblocks.propertiesmatcher.TileEntityPropertiesMatcher;
import com.maw79.mods.client.gui.GuiNotif;
import com.maw79.mods.client.gui.historygui.GuiEgyptStore;
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

public class LabelPacketHandler implements IMessageHandler<LabelMessage, IMessage> {

@Override
 public IMessage onMessage(LabelMessage message, MessageContext ctx) { 
 Utils.getLogger().info("Label Message Recieved");
 


World world = DimensionManager.getWorld(message.dimension);
 if(world == null) return null;
 else if(!world.isRemote) {
 if(ctx.getServerHandler().playerEntity.getEntityId() == message.entityID){
 EntityPlayerMP player = ctx.getServerHandler().playerEntity;

	double x = player.posX;
	double y = player.posY;
	double z = player.posZ;
 
 if (TileEntityPropertiesMatcher.labelType.equals("Chairs")){
		EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.LABELCHAIR));
		TileEntityPropertiesMatcher.labelType="";
		world.spawnEntity(item1);
	}
 else if (TileEntityPropertiesMatcher.labelType.equals("Durable")){
		EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.LABELDURABLE));
		TileEntityPropertiesMatcher.labelType="";
		world.spawnEntity(item1);
	}
 else if (TileEntityPropertiesMatcher.labelType.equals("Flexible")){
		EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.LABELFLEXIBLE));
		TileEntityPropertiesMatcher.labelType="";
		world.spawnEntity(item1);
	}
 else if (TileEntityPropertiesMatcher.labelType.equals("Opaque")){
		EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.LABELOPAQUE));
		TileEntityPropertiesMatcher.labelType="";
		world.spawnEntity(item1);
	}
 else if (TileEntityPropertiesMatcher.labelType.equals("Strong")){
		EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.LABELSTRONG));
		TileEntityPropertiesMatcher.labelType="";
		world.spawnEntity(item1);
	}
 else if (TileEntityPropertiesMatcher.labelType.equals("Tough")){
		EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.LABELTOUGH));
		TileEntityPropertiesMatcher.labelType="";
		world.spawnEntity(item1);
	}
 else if (TileEntityPropertiesMatcher.labelType.equals("Ferrous")){
		EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.LABELFERROUS));
		TileEntityPropertiesMatcher.labelType="";
		world.spawnEntity(item1);
	}
 else if (TileEntityPropertiesMatcher.labelType.equals("Non Ferrous")){
		EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.LABELNONFERROUS));
		TileEntityPropertiesMatcher.labelType="";
		world.spawnEntity(item1);
	}
 else if (TileEntityPropertiesMatcher.labelType.equals("Magnetic")){
		EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.LABELMAGNETIC));
		TileEntityPropertiesMatcher.labelType="";
		world.spawnEntity(item1);
	}
 else if (TileEntityPropertiesMatcher.labelType.equals("Lustrous")){
		EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.LABELLUSTROUS));
		TileEntityPropertiesMatcher.labelType="";
		world.spawnEntity(item1);
	}
 else if (TileEntityPropertiesMatcher.labelType.equals("High Density")){
		EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.LABELHIGHDENSITY));
		TileEntityPropertiesMatcher.labelType="";
		world.spawnEntity(item1);
	}
 else if (TileEntityPropertiesMatcher.labelType.equals("Fragile")){
		EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.LABELFRAGILE));
		TileEntityPropertiesMatcher.labelType="";
		world.spawnEntity(item1);
	}
 else if (TileEntityPropertiesMatcher.labelType.equals("Transparent")){
		EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.LABELTRANSPARENT));
		TileEntityPropertiesMatcher.labelType="";
		world.spawnEntity(item1);
	}
 else if (TileEntityPropertiesMatcher.labelType.equals("Spectacles")){
		EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.LABELSPECTACLES));
		TileEntityPropertiesMatcher.labelType="";
		world.spawnEntity(item1);
	}
 else if (TileEntityPropertiesMatcher.labelType.equals("Windows")){
		EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.LABELWINDOWS));
		TileEntityPropertiesMatcher.labelType="";
		world.spawnEntity(item1);
	}
 else if (TileEntityPropertiesMatcher.labelType.equals("Bags")){
		EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.LABELBAGS));
		TileEntityPropertiesMatcher.labelType="";
		world.spawnEntity(item1);
	}
 else if (TileEntityPropertiesMatcher.labelType.equals("Waterproof")){
		EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.LABELWATERPROOF));
		TileEntityPropertiesMatcher.labelType="";
		world.spawnEntity(item1);
	}
 else if (TileEntityPropertiesMatcher.labelType.equals("Tocicity")){
		EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.LABELTOXICITY));
		TileEntityPropertiesMatcher.labelType="";
		world.spawnEntity(item1);
	}
 else if (TileEntityPropertiesMatcher.labelType.equals("Acrylic")){
		EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.LABELACRYLIC));
		TileEntityPropertiesMatcher.labelType="";
		world.spawnEntity(item1);
	}
 else if (TileEntityPropertiesMatcher.labelType.equals("PVC")){
		EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.LABELPVC));
		TileEntityPropertiesMatcher.labelType="";
		world.spawnEntity(item1);
	}
 else if (TileEntityPropertiesMatcher.labelType.equals("Cellophane")){
		EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.LABELCELLOPHANE));
		TileEntityPropertiesMatcher.labelType="";
		world.spawnEntity(item1);
	}
 else if (TileEntityPropertiesMatcher.labelType.equals("Polythene")){
		EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.LABELPOLYTHENE));
		TileEntityPropertiesMatcher.labelType="";
		world.spawnEntity(item1);
	}
 else if (TileEntityPropertiesMatcher.labelType.equals("Antistatic")){
		EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.LABELANTISTATIC));
		TileEntityPropertiesMatcher.labelType="";
		world.spawnEntity(item1);
	}
 else if (TileEntityPropertiesMatcher.labelType.equals("Pottery")){
		EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.LABELPOTTERY));
		TileEntityPropertiesMatcher.labelType="";
		world.spawnEntity(item1);
	}
 else if (TileEntityPropertiesMatcher.labelType.equals("Mugs")){
		EntityItem item1 = new EntityItem(world, x, y, z, new ItemStack(ModItems.LABELMUGS));
		TileEntityPropertiesMatcher.labelType="";
		world.spawnEntity(item1);
	}
	
 }
 }
 return null;
 }

}
