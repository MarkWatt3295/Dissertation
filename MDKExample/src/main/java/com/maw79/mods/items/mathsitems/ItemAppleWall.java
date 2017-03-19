package com.maw79.mods.items.mathsitems;

import java.util.List;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ActionResult;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;

import com.maw79.mods.init.ModBlocks;
import com.maw79.mods.main.Maw79Mod;
import com.maw79.mods.main.Reference;
import com.maw79.mods.util.Utilities;
import com.maw79.mods.util.Utils;

import net.minecraft.block.Block;

public class ItemAppleWall  extends Item{
	
public  ItemAppleWall (String unlocalizedName) {
	this.setUnlocalizedName(unlocalizedName);
	this.setRegistryName(new ResourceLocation(Reference.MOD_ID, unlocalizedName));
	this.setCreativeTab(Maw79Mod.mathsblocks);
	this.setMaxDamage(1);
	
	
}

/**
 * Tool tip
 */
@Override
public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
	super.addInformation(stack, playerIn, tooltip, advanced);
	tooltip.add(Utils.getLang().localize("apple_wall.tooltip"));
}

@Override
public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer entity, EnumHand hand) {
	float var4 = 1.0F;
	ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
	int i = (int) (entity.prevPosX + (entity.posX - entity.prevPosX) * (double) var4);
	int j = (int) (entity.prevPosY + (entity.posY - entity.prevPosY) * (double) var4); //+ 1.62D);
	int k = (int) (entity.prevPosZ + (entity.posZ - entity.prevPosZ) * (double) var4);

	//	Vanilla BLOCK IDs
	//1 - Stone
	
	//35-0 - White
	//35-1 - Orange
	//35-2 - Magenta
	//35-3 - Light Blue
	//35-4 - Yellow
	//35-5 - Lime Green
	//35-6 - Pink
	//35-7 - Gray 
	//35-8 - Light Gray
	//35-9 - Cyan
	//35-10 - Purple
	//35-11 - Blue
	//35-12 - Brown
	//35-13 - Green
	//35-14 - Red
	//35-15 - Black
	int m0 = Block.getIdFromBlock(ModBlocks.mathblockwhite);
	int m1 = Block.getIdFromBlock(ModBlocks.mathblockorange);
	//int m2 = Block.getIdFromBlock(ModBlocks.);
	int m3 = Block.getIdFromBlock(ModBlocks.mathblockaqua);
	//int m4 = Block.getIdFromBlock(ModBlocks.mathblockgold);
	int m5 = Block.getIdFromBlock(ModBlocks.mathblockgreen);
	//int m6 = Block.getIdFromBlock(ModBlocks.);
	//int m7 = Block.getIdFromBlock(ModBlocks.);
	int m8 = Block.getIdFromBlock(ModBlocks.mathblockgrey);
	//int m9 = Block.getIdFromBlock(ModBlocks.mathblocklightorange);
	//int m10 = Block.getIdFromBlock(ModBlocks.mathblocklightorange);
	int m11 = Block.getIdFromBlock(ModBlocks.mathblockblue);
	int m12 = Block.getIdFromBlock(ModBlocks.mathtextblockbrown);
	//int m13 = Block.getIdFromBlock(ModBlocks.mathblocklightorange);
	//int m14 = Block.getIdFromBlock(ModBlocks.mathblocklightorange);
	int m15 = Block.getIdFromBlock(ModBlocks.mathblockblack);
//New Colours
	int m16 = Block.getIdFromBlock(ModBlocks.mathblockgold);
	int m17 = Block.getIdFromBlock(ModBlocks.mathblockmarrowbrown);
	int m18 = Block.getIdFromBlock(ModBlocks.mathblockpeach);
	
	//Block.getBlockById(m1).getDefaultState());
	if (true) {
		boolean place = true;

		for (int y = 0; y < 22; y++)
			for (int z = 0; z < 21; z++)
				for (int x = 0; x < 1; x++)
					if (world.getBlockState(new BlockPos(i + x, j + y + 1, k + z)).getBlock() != Blocks.AIR)
						place = false;
						
					if(place == false){
						if(!entity.world.isRemote) entity.sendMessage(new TextComponentString("§c"+"[Warning] "+ "§r" + "Not enough space to place wall"));
					}

		if (place) {
	world.setBlockState(new BlockPos(i + 0, j + 0, k + 0), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 0, k + 1), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 0, k + 2), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 0, k + 3), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 0, k + 4), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 0, k + 5), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 0, k + 6), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 0, k + 7), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 0, k + 8), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 0, k + 9), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 0, k + 10), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 0, k + 11), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 0, k + 12), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 0, k + 13), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 0, k + 14), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 0, k + 15), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 0, k + 16), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 0, k + 17), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 0, k + 18), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 0, k + 19), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 0, k + 20), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 1, k + 0), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 1, k + 1), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 1, k + 2), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 1, k + 3), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 1, k + 4), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 1, k + 5), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 1, k + 6), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 1, k + 7), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 1, k + 8), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 1, k + 9), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 1, k + 10), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 1, k + 11), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 1, k + 12), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 1, k + 13), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 1, k + 14), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 1, k + 15), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 1, k + 16), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 1, k + 17), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 1, k + 18), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 1, k + 19), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 1, k + 20), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 2, k + 0), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 2, k + 1), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 2, k + 2), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 2, k + 3), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 2, k + 4), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 2, k + 5), Block.getBlockById(m15).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 2, k + 6), Block.getBlockById(m15).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 2, k + 7), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 2, k + 8), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 2, k + 9), Block.getBlockById(m15).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 2, k + 10), Block.getBlockById(m15).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 2, k + 11), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 2, k + 12), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 2, k + 13), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 2, k + 14), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 2, k + 15), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 2, k + 16), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 2, k + 17), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 2, k + 18), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 2, k + 19), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 2, k + 20), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 3, k + 0), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 3, k + 1), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 3, k + 2), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 3, k + 3), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 3, k + 4), Block.getBlockById(m15).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 3, k + 5), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 3, k + 6), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 3, k + 7), Block.getBlockById(m15).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 3, k + 8), Block.getBlockById(m15).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 3, k + 9), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 3, k + 10), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 3, k + 11), Block.getBlockById(m15).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 3, k + 12), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 3, k + 13), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 3, k + 14), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 3, k + 15), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 3, k + 16), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 3, k + 17), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 3, k + 18), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 3, k + 19), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 3, k + 20), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 4, k + 0), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 4, k + 1), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 4, k + 2), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 4, k + 3), Block.getBlockById(m15).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 4, k + 4), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 4, k + 5), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 4, k + 6), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 4, k + 7), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 4, k + 8), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 4, k + 9), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 4, k + 10), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 4, k + 11), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 4, k + 12), Block.getBlockById(m15).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 4, k + 13), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 4, k + 14), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 4, k + 15), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 4, k + 16), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 4, k + 17), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 4, k + 18), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 4, k + 19), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 4, k + 20), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 5, k + 0), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 5, k + 1), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 5, k + 2), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 5, k + 3), Block.getBlockById(m15).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 5, k + 4), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 5, k + 5), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 5, k + 6), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 5, k + 7), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 5, k + 8), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 5, k + 9), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 5, k + 10), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 5, k + 11), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 5, k + 12), Block.getBlockById(m15).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 5, k + 13), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 5, k + 14), Block.getBlockById(m15).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 5, k + 15), Block.getBlockById(m15).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 5, k + 16), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 5, k + 17), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 5, k + 18), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 5, k + 19), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 5, k + 20), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 6, k + 0), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 6, k + 1), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 6, k + 2), Block.getBlockById(m15).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 6, k + 3), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 6, k + 4), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 6, k + 5), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 6, k + 6), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 6, k + 7), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 6, k + 8), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 6, k + 9), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 6, k + 10), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 6, k + 11), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 6, k + 12), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 6, k + 13), Block.getBlockById(m15).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 6, k + 14), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 6, k + 15), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 6, k + 16), Block.getBlockById(m15).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 6, k + 17), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 6, k + 18), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 6, k + 19), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 6, k + 20), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 7, k + 0), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 7, k + 1), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 7, k + 2), Block.getBlockById(m15).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 7, k + 3), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 7, k + 4), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 7, k + 5), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 7, k + 6), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 7, k + 7), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 7, k + 8), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 7, k + 9), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 7, k + 10), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 7, k + 11), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 7, k + 12), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 7, k + 13), Block.getBlockById(m15).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 7, k + 14), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 7, k + 15), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 7, k + 16), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 7, k + 17), Block.getBlockById(m15).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 7, k + 18), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 7, k + 19), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 7, k + 20), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 8, k + 0), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 8, k + 1), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 8, k + 2), Block.getBlockById(m15).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 8, k + 3), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 8, k + 4), Block.getBlockById(m0).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 8, k + 5), Block.getBlockById(m0).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 8, k + 6), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 8, k + 7), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 8, k + 8), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 8, k + 9), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 8, k + 10), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 8, k + 11), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 8, k + 12), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 8, k + 13), Block.getBlockById(m15).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 8, k + 14), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 8, k + 15), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 8, k + 16), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 8, k + 17), Block.getBlockById(m15).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 8, k + 18), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 8, k + 19), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 8, k + 20), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 9, k + 0), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 9, k + 1), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 9, k + 2), Block.getBlockById(m15).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 9, k + 3), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 9, k + 4), Block.getBlockById(m0).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 9, k + 5), Block.getBlockById(m0).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 9, k + 6), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 9, k + 7), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 9, k + 8), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 9, k + 9), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 9, k + 10), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 9, k + 11), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 9, k + 12), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 9, k + 13), Block.getBlockById(m15).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 9, k + 14), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 9, k + 15), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 9, k + 16), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 9, k + 17), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 9, k + 18), Block.getBlockById(m15).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 9, k + 19), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 9, k + 20), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 10, k + 0), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 10, k + 1), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 10, k + 2), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 10, k + 3), Block.getBlockById(m15).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 10, k + 4), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 10, k + 5), Block.getBlockById(m0).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 10, k + 6), Block.getBlockById(m0).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 10, k + 7), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 10, k + 8), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 10, k + 9), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 10, k + 10), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 10, k + 11), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 10, k + 12), Block.getBlockById(m15).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 10, k + 13), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 10, k + 14), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 10, k + 15), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 10, k + 16), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 10, k + 17), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 10, k + 18), Block.getBlockById(m15).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 10, k + 19), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 10, k + 20), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 11, k + 0), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 11, k + 1), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 11, k + 2), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 11, k + 3), Block.getBlockById(m15).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 11, k + 4), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 11, k + 5), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 11, k + 6), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 11, k + 7), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 11, k + 8), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 11, k + 9), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 11, k + 10), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 11, k + 11), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 11, k + 12), Block.getBlockById(m15).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 11, k + 13), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 11, k + 14), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 11, k + 15), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 11, k + 16), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 11, k + 17), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 11, k + 18), Block.getBlockById(m15).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 11, k + 19), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 11, k + 20), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 12, k + 0), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 12, k + 1), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 12, k + 2), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 12, k + 3), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 12, k + 4), Block.getBlockById(m15).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 12, k + 5), Block.getBlockById(m15).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 12, k + 6), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 12, k + 7), Block.getBlockById(m17).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 12, k + 8), Block.getBlockById(m17).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 12, k + 9), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 12, k + 10), Block.getBlockById(m15).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 12, k + 11), Block.getBlockById(m15).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 12, k + 12), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 12, k + 13), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 12, k + 14), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 12, k + 15), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 12, k + 16), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 12, k + 17), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 12, k + 18), Block.getBlockById(m15).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 12, k + 19), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 12, k + 20), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 13, k + 0), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 13, k + 1), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 13, k + 2), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 13, k + 3), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 13, k + 4), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 13, k + 5), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 13, k + 6), Block.getBlockById(m15).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 13, k + 7), Block.getBlockById(m15).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 13, k + 8), Block.getBlockById(m17).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 13, k + 9), Block.getBlockById(m15).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 13, k + 10), Block.getBlockById(m0).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 13, k + 11), Block.getBlockById(m0).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 13, k + 12), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 13, k + 13), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 13, k + 14), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 13, k + 15), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 13, k + 16), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 13, k + 17), Block.getBlockById(m15).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 13, k + 18), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 13, k + 19), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 13, k + 20), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 14, k + 0), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 14, k + 1), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 14, k + 2), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 14, k + 3), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 14, k + 4), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 14, k + 5), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 14, k + 6), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 14, k + 7), Block.getBlockById(m15).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 14, k + 8), Block.getBlockById(m15).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 14, k + 9), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 14, k + 10), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 14, k + 11), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 14, k + 12), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 14, k + 13), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 14, k + 14), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 14, k + 15), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 14, k + 16), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 14, k + 17), Block.getBlockById(m15).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 14, k + 18), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 14, k + 19), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 14, k + 20), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 15, k + 0), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 15, k + 1), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 15, k + 2), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 15, k + 3), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 15, k + 4), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 15, k + 5), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 15, k + 6), Block.getBlockById(m15).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 15, k + 7), Block.getBlockById(m15).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 15, k + 8), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 15, k + 9), Block.getBlockById(m15).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 15, k + 10), Block.getBlockById(m15).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 15, k + 11), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 15, k + 12), Block.getBlockById(m17).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 15, k + 13), Block.getBlockById(m17).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 15, k + 14), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 15, k + 15), Block.getBlockById(m15).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 15, k + 16), Block.getBlockById(m15).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 15, k + 17), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 15, k + 18), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 15, k + 19), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 15, k + 20), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 16, k + 0), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 16, k + 1), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 16, k + 2), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 16, k + 3), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 16, k + 4), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 16, k + 5), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 16, k + 6), Block.getBlockById(m15).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 16, k + 7), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 16, k + 8), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 16, k + 9), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 16, k + 10), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 16, k + 11), Block.getBlockById(m15).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 16, k + 12), Block.getBlockById(m15).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 16, k + 13), Block.getBlockById(m17).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 16, k + 14), Block.getBlockById(m15).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 16, k + 15), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 16, k + 16), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 16, k + 17), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 16, k + 18), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 16, k + 19), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 16, k + 20), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 17, k + 0), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 17, k + 1), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 17, k + 2), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 17, k + 3), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 17, k + 4), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 17, k + 5), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 17, k + 6), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 17, k + 7), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 17, k + 8), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 17, k + 9), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 17, k + 10), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 17, k + 11), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 17, k + 12), Block.getBlockById(m15).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 17, k + 13), Block.getBlockById(m15).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 17, k + 14), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 17, k + 15), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 17, k + 16), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 17, k + 17), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 17, k + 18), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 17, k + 19), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 17, k + 20), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 18, k + 0), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 18, k + 1), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 18, k + 2), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 18, k + 3), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 18, k + 4), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 18, k + 5), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 18, k + 6), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 18, k + 7), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 18, k + 8), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 18, k + 9), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 18, k + 10), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 18, k + 11), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 18, k + 12), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 18, k + 13), Block.getBlockById(m15).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 18, k + 14), Block.getBlockById(m15).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 18, k + 15), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 18, k + 16), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 18, k + 17), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 18, k + 18), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 18, k + 19), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 18, k + 20), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 19, k + 0), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 19, k + 1), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 19, k + 2), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 19, k + 3), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 19, k + 4), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 19, k + 5), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 19, k + 6), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 19, k + 7), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 19, k + 8), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 19, k + 9), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 19, k + 10), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 19, k + 11), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 19, k + 12), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 19, k + 13), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 19, k + 14), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 19, k + 15), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 19, k + 16), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 19, k + 17), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 19, k + 18), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 19, k + 19), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 19, k + 20), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 20, k + 0), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 20, k + 1), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 20, k + 2), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 20, k + 3), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 20, k + 4), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 20, k + 5), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 20, k + 6), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 20, k + 7), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 20, k + 8), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 20, k + 9), Block.getBlockById(m16).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 20, k + 10), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 20, k + 11), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 20, k + 12), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 20, k + 13), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 20, k + 14), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 20, k + 15), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 20, k + 16), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 20, k + 17), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 20, k + 18), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 20, k + 19), Block.getBlockById(m1).getDefaultState());
	world.setBlockState(new BlockPos(i + 0, j + 20, k + 20), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 21, k + 0), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 21, k + 1), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 21, k + 2), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 21, k + 3), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 21, k + 4), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 21, k + 5), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 21, k + 6), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 21, k + 7), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 21, k + 8), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 21, k + 9), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 21, k + 10), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 21, k + 11), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 21, k + 12), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 21, k + 13), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 21, k + 14), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 21, k + 15), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 21, k + 16), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 21, k + 17), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 21, k + 18), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 21, k + 19), Block.getBlockById(1).getStateFromMeta(0), 3);
	world.setBlockState(new BlockPos(i + 0, j + 21, k + 20), Block.getBlockById(1).getStateFromMeta(0), 3);

	
	entity.inventory.getCurrentItem().damageItem(2, entity );
		}
	}
		return ar;
}


}
