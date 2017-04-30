package com.maw79.mods.items;

import java.util.List;

import com.maw79.mods.handlers.ModEventHandler;
import com.maw79.mods.main.Reference;
import com.maw79.mods.util.Utils;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class ItemJumpBooster extends Item {

	public ItemJumpBooster(String unlocalizedName) {
		this.setMaxStackSize(1);
		this.setMaxDamage(1);
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(Reference.MOD_ID, unlocalizedName));
	}


	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer player, EnumHand handIn) {
		ItemStack stack = player.getHeldItem(handIn);

		stack.damageItem(1, player);

		if (!player.isSneaking()){
			player.move(null, 0, 4, 0);
			int playerY = (int) player.posY;
		}

		return super.onItemRightClick(worldIn, player, handIn);
	}


	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		super.addInformation(stack, playerIn, tooltip, advanced);
		tooltip.add(TextFormatting.BLUE + Utils.getLang().localize("jumpbooster.tooltip"));
	}

}
