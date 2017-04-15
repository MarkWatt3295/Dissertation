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
public class EntityPaintRemoverArrow extends EntityModArrow {
	public EntityPaintRemoverArrow(World worldIn) {
		super(worldIn);
	}

	public EntityPaintRemoverArrow(World worldIn, double x, double y, double z) {
		super(worldIn, x, y, z);
	}

	public EntityPaintRemoverArrow(World worldIn, EntityLivingBase shooter) {
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
			if (world.getBlockState(pos).getBlock() == ModBlocks.mathblockblue) {
	            world.setBlockState(pos, ModBlocks.mathtextblockblue.getDefaultState());
	            this.isDead = true;
			}
			 else   if (world.getBlockState(pos).getBlock() == ModBlocks.mathblockaqua) {
		            world.setBlockState(pos, ModBlocks.mathtextblockaqua.getDefaultState());
		            this.isDead = true;
			 }
			 else   if (world.getBlockState(pos).getBlock() == ModBlocks.mathblockgreen) {
		            world.setBlockState(pos, ModBlocks.mathtextblockgreen.getDefaultState());
		            this.isDead = true;
			 }
			 else   if (world.getBlockState(pos).getBlock() == ModBlocks.mathblockpeach) {
		            world.setBlockState(pos, ModBlocks.mathtextblockpeach.getDefaultState());
		            this.isDead = true;
			 }
			 else   if (world.getBlockState(pos).getBlock() == ModBlocks.mathblockwhite) {
		            world.setBlockState(pos, ModBlocks.mathtextblockwhite.getDefaultState());
		            this.isDead = true;
			 }
			 else   if (world.getBlockState(pos).getBlock() == ModBlocks.mathblockgold) {
		            world.setBlockState(pos, ModBlocks.mathtextblockgold.getDefaultState());
		            this.isDead = true;
			 }
			  else   if (world.getBlockState(pos).getBlock() == ModBlocks.mathblockmarrowbrown) {
		            world.setBlockState(pos, ModBlocks.mathtextblockmarrowbrown.getDefaultState());
		            this.isDead = true;
			  }
			  else   if (world.getBlockState(pos).getBlock() == ModBlocks.mathblockgrey) {
		            world.setBlockState(pos, ModBlocks.mathtextblockgrey.getDefaultState());
		            this.isDead = true;
			  }
			  else   if (world.getBlockState(pos).getBlock() == ModBlocks.mathblocklightorange) {
		            world.setBlockState(pos, ModBlocks.mathtextblocklightorange.getDefaultState());
		            this.isDead = true;
			  }
			  else   if (world.getBlockState(pos).getBlock() == ModBlocks.mathblockorange) {
		            world.setBlockState(pos, ModBlocks.mathtextblockorange.getDefaultState());
		            this.isDead = true;
			  }
			  else   if (world.getBlockState(pos).getBlock() == ModBlocks.mathblockblack) {
		            world.setBlockState(pos, ModBlocks.mathtextblockblack.getDefaultState());
		            this.isDead = true;
			  }
			  else{
			shootingEntity.sendMessage(new TextComponentTranslation("Missed Painted Block"));
			  }
			  }
	
	}
}