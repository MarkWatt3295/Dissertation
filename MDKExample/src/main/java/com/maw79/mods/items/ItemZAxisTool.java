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

public class ItemZAxisTool  extends Item{
	
public  ItemZAxisTool (String unlocalizedName) {
	this.setUnlocalizedName(unlocalizedName);
	this.setRegistryName(new ResourceLocation(Reference.MOD_ID, unlocalizedName));
	
}

/**
 * Tool tip
 */
@Override
public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
	super.addInformation(stack, playerIn, tooltip, advanced);
	tooltip.add(TextFormatting.BLUE + Utils.getLang().localize("z_axis_tool.tooltip"));
}

@Override
public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
	 
	if(player.isSneaking()){
			System.out.println("Think your sneaking?");
			int playerMZ = (int) player.posZ;
			player.move(null, 0, 0, -1); 
			if(!player.world.isRemote) player.sendMessage(new TextComponentString("Moving Along " + "§9"+ "-Z "+ "§r"+"Axis ("+ "§9" + playerMZ+"§r"+")"));
		}
	
	else if (!player.isSneaking()){
		System.out.println("Not sneaking?");
		int playerZ = (int) player.posZ;
		 if(!player.world.isRemote) player.sendMessage(new TextComponentString("Moving Along " + "§9"+ "+Z "+ "§r"+"Axis ("+ "§9" + playerZ+"§r"+")"));
		 player.move(null, 0, 0, 1);
	 }
	
	return super.onItemRightClick(world, player, hand);
}



}
