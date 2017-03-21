package com.maw79.mods.items;

import com.maw79.mods.init.ModBlocks;
import com.maw79.mods.main.Maw79Mod;
import com.maw79.mods.main.Reference;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemMw extends Item {

	public ItemMw(String unlocalizedName) {
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(Reference.MOD_ID, unlocalizedName));
	}
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer entity, EnumHand hand) {
		float var4 = 1.0F;
		int i = (int) (entity.prevPosX + (entity.posX - entity.prevPosX) * (double) var4);
		int j = (int) (entity.prevPosY + (entity.posY - entity.prevPosY) * (double) var4 + 1.62D);
		int k = (int) (entity.prevPosZ + (entity.posZ - entity.prevPosZ) * (double) var4);
		int l = (int) entity.posX;
		int m = (int) entity.posY;
		int n = (int) entity.posZ;
		world.setBlockState(new BlockPos(l + 0, m + 0, n + 0), Blocks.DIAMOND_BLOCK.getDefaultState());
		int q = Block.getIdFromBlock(ModBlocks.mathblockblue);
		world.setBlockState(new BlockPos(l + 0, m + 0, n + 0), Block.getBlockById(q).getDefaultState());
		world.setBlockState(new BlockPos(l + 1, m + 0, n + 0), Blocks.IRON_BLOCK.getDefaultState());
		world.setBlockState(new BlockPos(l + 2, m + 0, n + 0), Blocks.DIRT.getDefaultState());
		System.out.println("right clicked mw item" + q);
		//setBlock(9, 64, 20, Blocks.DIRT);
		int ten = 10;
		Maw79Mod.playerlevel += ten;
		int pl = Maw79Mod.playerlevel;
		System.out.println("******************** "+ pl + "***********************");
		return super.onItemRightClick(world, entity, hand);
		//world.setBlockState(new BlockPos(i + 0, j + 0, k + 0), Block.getBlockById(4158).getStateFromMeta(0), 3);
	}
	
	
	
}
