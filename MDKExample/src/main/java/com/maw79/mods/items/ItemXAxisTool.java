package com.maw79.mods.items;

import java.util.List;

import com.maw79.mods.main.Reference;
import com.maw79.mods.util.Utilities;
import com.maw79.mods.util.Utils;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class ItemXAxisTool  extends Item{
	
public  ItemXAxisTool (String unlocalizedName) {
	this.setUnlocalizedName(unlocalizedName);
	this.setRegistryName(new ResourceLocation(Reference.MOD_ID, unlocalizedName));
	
}

/**
 * Tool tip
 */
@Override
public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
	super.addInformation(stack, playerIn, tooltip, advanced);
	tooltip.add(TextFormatting.RED + Utils.getLang().localize("x_axis_tool.tooltip"));
}

@Override
public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
	 
	if(player.isSneaking()){
			System.out.println("Think your sneaking?");
			player.move(null, -1, 0, 0); 
			int playerMX = (int) player.posX;
			if(!player.world.isRemote) player.sendMessage(new TextComponentString("Moving Along " + "§c"+ "-X "+ "§r"+"Axis ("+ "§c" + playerMX+"§r"+")"));
		}
	
	else if (!player.isSneaking()){
		System.out.println("Not sneaking?");
		 player.move(null, 1, 0, 0);
		int playerX = (int) player.posX;
		 if(!player.world.isRemote) player.sendMessage(new TextComponentString("Moving Along " + "§c"+ "+X "+ "§r"+"Axis ("+ "§c" + playerX+"§r"+")"));
		
	 }
	


	
	return super.onItemRightClick(world, player, hand);
}



}
