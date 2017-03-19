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

public class ItemYAxisTool  extends Item{
	
public  ItemYAxisTool (String unlocalizedName) {
	this.setUnlocalizedName(unlocalizedName);
	this.setRegistryName(new ResourceLocation(Reference.MOD_ID, unlocalizedName));
	
}

/**
 * Tool tip
 */
@Override
public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
	super.addInformation(stack, playerIn, tooltip, advanced);
	tooltip.add(TextFormatting.GREEN + Utils.getLang().localize("y_axis_tool.tooltip"));
}

@Override
public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
	 
	if(player.isSneaking()){
			System.out.println("Think your sneaking?");
			int playerMY = (int) player.posY;
			player.move(null, 0, -1, 0); 
			if(!player.world.isRemote) player.sendMessage(new TextComponentString("Moving Along " + "§a"+ "-Y "+ "§r"+"Axis ("+ "§a" + playerMY+"§r"+")"));
		}
	
	else if (!player.isSneaking()){
		System.out.println("Not sneaking?");
		int playerY = (int) player.posY;
		 if(!player.world.isRemote) player.sendMessage(new TextComponentString("Moving Along " + "§a"+ "+Y "+ "§r"+"Axis ("+ "§a" + playerY+"§r"+")"));
		 player.move(null, 0, 1, 0);
	 }
	
	return super.onItemRightClick(world, player, hand);
}



}
