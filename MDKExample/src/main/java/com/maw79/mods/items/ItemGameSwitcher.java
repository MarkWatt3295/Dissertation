package com.maw79.mods.items;

import java.util.List;

import com.maw79.mods.creativetabs.Maw79DebugTab;
import com.maw79.mods.main.Maw79Mod;
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
import net.minecraft.world.GameType;
import net.minecraft.world.World;

public class ItemGameSwitcher  extends Item{
	
public  ItemGameSwitcher (String unlocalizedName) {
	this.setUnlocalizedName(unlocalizedName);
	this.setRegistryName(new ResourceLocation(Reference.MOD_ID, unlocalizedName));
	this.setCreativeTab(Maw79Mod.debug);
	
	
}

/**
 * Tool tip
 */
@Override
public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
	super.addInformation(stack, playerIn, tooltip, advanced);
	tooltip.add(TextFormatting.BLACK.BOLD + Utils.getLang().localize("game_switcher.tooltip"));
}

@Override
public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
	 
	if(player.isSneaking()){
		if(!player.world.isRemote) player.sendMessage(new TextComponentString(Utilities.stringToGolden("***Survival Mode Activated***", 0, true)));
			
		player.setGameType(GameType.SURVIVAL);
		}
	
	else if (!player.isSneaking()){
		if(!player.world.isRemote) player.sendMessage(new TextComponentString(Utilities.stringToGolden("***Creative Mode Activated***", 0, true)));
		player.setGameType(GameType.CREATIVE);
	 }
	
	
	return super.onItemRightClick(world, player, hand);
}



}
