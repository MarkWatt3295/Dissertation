package com.maw79.mods.entity.arrows;

import com.maw79.mods.init.ModBlocks;
import com.maw79.mods.init.ModItems;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

/**
 * An arrow entity that tells its shooter which block it hit.
 * <p>
 */
public class EntityPaintArrow extends EntityModArrow {
	public EntityPaintArrow(World worldIn) {
		super(worldIn);
	}

	public EntityPaintArrow(World worldIn, double x, double y, double z) {
		super(worldIn, x, y, z);
	}

	public EntityPaintArrow(World worldIn, EntityLivingBase shooter) {
		super(worldIn, shooter);
	}

	@Override
	protected ItemStack getArrowStack() {
		return new ItemStack(ModItems.PAINT_ARROW);
	}

	@Override
	protected void onHit(RayTraceResult raytraceResultIn) {
		super.onHit(raytraceResultIn);

		if (raytraceResultIn.typeOfHit == RayTraceResult.Type.BLOCK && shootingEntity != null) {
			final BlockPos pos = raytraceResultIn.getBlockPos();
			final IBlockState state = world.getBlockState(pos).getActualState(world, pos);
			//PAINTING
			if (world.getBlockState(pos).getBlock() == ModBlocks.mathtextblockblue) {
	            world.setBlockState(pos, ModBlocks.mathblockblue.getDefaultState());
	            this.isDead = true;
			}
			 else   if (world.getBlockState(pos).getBlock() == ModBlocks.mathtextblockaqua) {
		            world.setBlockState(pos, ModBlocks.mathblockaqua.getDefaultState());
		            this.isDead = true;
			 }
			 else   if (world.getBlockState(pos).getBlock() == ModBlocks.mathtextblockgreen) {
		            world.setBlockState(pos, ModBlocks.mathblockgreen.getDefaultState());
		            this.isDead = true;
			 }
			 else   if (world.getBlockState(pos).getBlock() == ModBlocks.mathtextblockpeach) {
		            world.setBlockState(pos, ModBlocks.mathblockpeach.getDefaultState());
		            this.isDead = true;
			 }
			 else   if (world.getBlockState(pos).getBlock() == ModBlocks.mathtextblockwhite) {
		            world.setBlockState(pos, ModBlocks.mathblockwhite.getDefaultState());
		            this.isDead = true;
			 }
			 else   if (world.getBlockState(pos).getBlock() == ModBlocks.mathtextblockgold) {
		            world.setBlockState(pos, ModBlocks.mathblockgold.getDefaultState());
		            this.isDead = true;
			 }
			  else   if (world.getBlockState(pos).getBlock() == ModBlocks.mathtextblockmarrowbrown) {
		            world.setBlockState(pos, ModBlocks.mathblockmarrowbrown.getDefaultState());
		            this.isDead = true;
			  }
			  else   if (world.getBlockState(pos).getBlock() == ModBlocks.mathtextblockgrey) {
		            world.setBlockState(pos, ModBlocks.mathblockgrey.getDefaultState());
		            this.isDead = true;
			  }
			  else   if (world.getBlockState(pos).getBlock() == ModBlocks.mathtextblocklightorange) {
		            world.setBlockState(pos, ModBlocks.mathblocklightorange.getDefaultState());
		            this.isDead = true;
			  }
			  else   if (world.getBlockState(pos).getBlock() == ModBlocks.mathtextblockorange) {
		            world.setBlockState(pos, ModBlocks.mathblockorange.getDefaultState());
		            this.isDead = true;
			  }
			  else   if (world.getBlockState(pos).getBlock() == ModBlocks.mathtextblockblack) {
		            world.setBlockState(pos, ModBlocks.mathblockblack.getDefaultState());
		            this.isDead = true;
			  }
			  else{
			shootingEntity.sendMessage(new TextComponentTranslation("Missed Paint Block"));
			  }
			  }
	
	}
}