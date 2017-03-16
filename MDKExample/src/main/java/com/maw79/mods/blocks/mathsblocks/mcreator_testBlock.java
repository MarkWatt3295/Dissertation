package com.maw79.mods.blocks.mathsblocks;


import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.world.World;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.NonNullList;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.tileentity.TileEntityLockableLoot;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.ContainerDispenser;
import net.minecraft.inventory.Container;
import net.minecraft.init.SoundEvents;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.Minecraft;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.ITileEntityProvider;

import java.util.Random;

import com.maw79.mods.main.Reference;
import com.maw79.mods.tileentity.TileEntityCustom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;


	public class mcreator_testBlock extends BlockFalling  {
		public static Object instance;
		int a1 = 0, a2 = 0, a3 = 0, a4 = 0, a5 = 0, a6 = 0;

		boolean red = false;
		
		public mcreator_testBlock(String unlocalizedName) {
			super(Material.CLOTH);
			this.setUnlocalizedName(unlocalizedName);
			this.setRegistryName(new ResourceLocation(Reference.MOD_ID, unlocalizedName));
			this.setHardness(1);
			this.setResistance(1);
			this.setSoundType(SoundType.WOOD);
		}

	
	


		@Override
		public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
			int i = pos.getX();
			int j = pos.getY();
			int k = pos.getZ();
			world.scheduleUpdate(new BlockPos(i, j, k), this, this.tickRate(world));

		}

		@Override
		public int getWeakPower(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
			return red ? 15 : 0;
		}

		@Override
		public int getStrongPower(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
			return red ? 15 : 0;
		}

		

		@SideOnly(Side.CLIENT)
		@Override
		public BlockRenderLayer getBlockLayer() {
			return BlockRenderLayer.SOLID;
		}

		@Override
		@javax.annotation.Nullable
		public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
			return NULL_AABB;
		}

		@Override
		public boolean isFullCube(IBlockState state) {
			return false;
		}

		@Override
		public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
			return new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
		}

		@Override
		public int tickRate(World world) {
			return 10;
		}

		@Override
		public int quantityDropped(Random par1Random) {
			return 3;
		}

		@Override
		public Item getItemDropped(IBlockState state, Random par2Random, int par3) {
			return new ItemStack(Blocks.PLANKS, 1, 0).getItem();
		}
		
		@Override
		public void onBlockClicked(World world, BlockPos pos, EntityPlayer entity) {
			int i = pos.getX();
			int j = pos.getY();
			int k = pos.getZ();
			if (true) {
				if (entity instanceof EntityLivingBase)
					((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.SPEED, 100, 0));
			}

		}
		
		@Override
		public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer entity, EnumHand hand, EnumFacing side,
				float hitX, float hitY, float hitZ) {
			int i = pos.getX();
			int j = pos.getY();
			int k = pos.getZ();
			if (true) {
				boolean place = true;

				
				if (place) {
					world.setBlockState(new BlockPos(i + 0, j + 0, k + 0), Block.getBlockById(2).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 1, j + 0, k + 0), Block.getBlockById(2).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 2, j + 0, k + 0), Block.getBlockById(2).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 3, j + 0, k + 0), Block.getBlockById(2).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 4, j + 0, k + 0), Block.getBlockById(2).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 0, j + 0, k + 1), Block.getBlockById(2).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 1, j + 0, k + 1), Block.getBlockById(3).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 2, j + 0, k + 1), Block.getBlockById(5).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 3, j + 0, k + 1), Block.getBlockById(3).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 4, j + 0, k + 1), Block.getBlockById(2).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 0, j + 0, k + 2), Block.getBlockById(2).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 1, j + 0, k + 2), Block.getBlockById(5).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 2, j + 0, k + 2), Block.getBlockById(89).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 3, j + 0, k + 2), Block.getBlockById(3).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 4, j + 0, k + 2), Block.getBlockById(2).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 0, j + 0, k + 3), Block.getBlockById(2).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 1, j + 0, k + 3), Block.getBlockById(3).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 2, j + 0, k + 3), Block.getBlockById(5).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 3, j + 0, k + 3), Block.getBlockById(3).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 4, j + 0, k + 3), Block.getBlockById(2).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 0, j + 0, k + 4), Block.getBlockById(2).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 1, j + 0, k + 4), Block.getBlockById(2).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 2, j + 0, k + 4), Block.getBlockById(2).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 3, j + 0, k + 4), Block.getBlockById(2).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 4, j + 0, k + 4), Block.getBlockById(2).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 1, j + 1, k + 1), Block.getBlockById(5).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 2, j + 1, k + 1), Block.getBlockById(20).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 3, j + 1, k + 1), Block.getBlockById(5).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 2, j + 1, k + 2), Block.getBlockById(65).getStateFromMeta(4), 3);
					world.setBlockState(new BlockPos(i + 3, j + 1, k + 2), Block.getBlockById(5).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 1, j + 1, k + 3), Block.getBlockById(5).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 2, j + 1, k + 3), Block.getBlockById(20).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 3, j + 1, k + 3), Block.getBlockById(5).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 1, j + 2, k + 1), Block.getBlockById(5).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 2, j + 2, k + 1), Block.getBlockById(20).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 3, j + 2, k + 1), Block.getBlockById(5).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 2, j + 2, k + 2), Block.getBlockById(65).getStateFromMeta(4), 3);
					world.setBlockState(new BlockPos(i + 3, j + 2, k + 2), Block.getBlockById(5).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 1, j + 2, k + 3), Block.getBlockById(5).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 2, j + 2, k + 3), Block.getBlockById(20).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 3, j + 2, k + 3), Block.getBlockById(5).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 1, j + 3, k + 1), Block.getBlockById(5).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 2, j + 3, k + 1), Block.getBlockById(20).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 3, j + 3, k + 1), Block.getBlockById(5).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 2, j + 3, k + 2), Block.getBlockById(65).getStateFromMeta(4), 3);
					world.setBlockState(new BlockPos(i + 3, j + 3, k + 2), Block.getBlockById(5).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 1, j + 3, k + 3), Block.getBlockById(5).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 2, j + 3, k + 3), Block.getBlockById(20).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 3, j + 3, k + 3), Block.getBlockById(5).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 1, j + 4, k + 1), Block.getBlockById(5).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 2, j + 4, k + 1), Block.getBlockById(20).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 3, j + 4, k + 1), Block.getBlockById(5).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 2, j + 4, k + 2), Block.getBlockById(65).getStateFromMeta(4), 3);
					world.setBlockState(new BlockPos(i + 3, j + 4, k + 2), Block.getBlockById(5).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 1, j + 4, k + 3), Block.getBlockById(5).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 2, j + 4, k + 3), Block.getBlockById(20).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 3, j + 4, k + 3), Block.getBlockById(5).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 1, j + 5, k + 1), Block.getBlockById(5).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 2, j + 5, k + 1), Block.getBlockById(20).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 3, j + 5, k + 1), Block.getBlockById(5).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 2, j + 5, k + 2), Block.getBlockById(65).getStateFromMeta(4), 3);
					world.setBlockState(new BlockPos(i + 3, j + 5, k + 2), Block.getBlockById(5).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 1, j + 5, k + 3), Block.getBlockById(5).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 2, j + 5, k + 3), Block.getBlockById(20).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 3, j + 5, k + 3), Block.getBlockById(5).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 0, j + 6, k + 0), Block.getBlockById(5).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 1, j + 6, k + 0), Block.getBlockById(5).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 2, j + 6, k + 0), Block.getBlockById(5).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 3, j + 6, k + 0), Block.getBlockById(5).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 4, j + 6, k + 0), Block.getBlockById(5).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 0, j + 6, k + 1), Block.getBlockById(5).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 1, j + 6, k + 1), Block.getBlockById(5).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 2, j + 6, k + 1), Block.getBlockById(5).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 3, j + 6, k + 1), Block.getBlockById(5).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 4, j + 6, k + 1), Block.getBlockById(5).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 0, j + 6, k + 2), Block.getBlockById(5).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 1, j + 6, k + 2), Block.getBlockById(5).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 2, j + 6, k + 2), Block.getBlockById(65).getStateFromMeta(4), 3);
					world.setBlockState(new BlockPos(i + 3, j + 6, k + 2), Block.getBlockById(5).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 4, j + 6, k + 2), Block.getBlockById(5).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 0, j + 6, k + 3), Block.getBlockById(5).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 1, j + 6, k + 3), Block.getBlockById(5).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 2, j + 6, k + 3), Block.getBlockById(5).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 3, j + 6, k + 3), Block.getBlockById(5).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 4, j + 6, k + 3), Block.getBlockById(5).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 0, j + 6, k + 4), Block.getBlockById(5).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 1, j + 6, k + 4), Block.getBlockById(5).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 2, j + 6, k + 4), Block.getBlockById(5).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 3, j + 6, k + 4), Block.getBlockById(5).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 4, j + 6, k + 4), Block.getBlockById(5).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 0, j + 7, k + 0), Block.getBlockById(85).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 1, j + 7, k + 0), Block.getBlockById(85).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 2, j + 7, k + 0), Block.getBlockById(85).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 3, j + 7, k + 0), Block.getBlockById(85).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 4, j + 7, k + 0), Block.getBlockById(85).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 0, j + 7, k + 1), Block.getBlockById(85).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 4, j + 7, k + 1), Block.getBlockById(85).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 0, j + 7, k + 2), Block.getBlockById(85).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 4, j + 7, k + 2), Block.getBlockById(85).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 0, j + 7, k + 3), Block.getBlockById(85).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 4, j + 7, k + 3), Block.getBlockById(85).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 0, j + 7, k + 4), Block.getBlockById(85).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 1, j + 7, k + 4), Block.getBlockById(85).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 2, j + 7, k + 4), Block.getBlockById(85).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 3, j + 7, k + 4), Block.getBlockById(85).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 4, j + 7, k + 4), Block.getBlockById(85).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 0, j + 8, k + 0), Block.getBlockById(85).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 4, j + 8, k + 0), Block.getBlockById(85).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 0, j + 8, k + 4), Block.getBlockById(85).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 4, j + 8, k + 4), Block.getBlockById(85).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 0, j + 9, k + 0), Block.getBlockById(5).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 1, j + 9, k + 0), Block.getBlockById(5).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 2, j + 9, k + 0), Block.getBlockById(5).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 3, j + 9, k + 0), Block.getBlockById(5).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 4, j + 9, k + 0), Block.getBlockById(5).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 0, j + 9, k + 1), Block.getBlockById(5).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 4, j + 9, k + 1), Block.getBlockById(5).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 0, j + 9, k + 2), Block.getBlockById(5).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 4, j + 9, k + 2), Block.getBlockById(5).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 0, j + 9, k + 3), Block.getBlockById(5).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 4, j + 9, k + 3), Block.getBlockById(5).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 0, j + 9, k + 4), Block.getBlockById(5).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 1, j + 9, k + 4), Block.getBlockById(5).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 2, j + 9, k + 4), Block.getBlockById(5).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 3, j + 9, k + 4), Block.getBlockById(5).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 4, j + 9, k + 4), Block.getBlockById(5).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 1, j + 10, k + 1), Block.getBlockById(5).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 2, j + 10, k + 1), Block.getBlockById(5).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 3, j + 10, k + 1), Block.getBlockById(5).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 1, j + 10, k + 2), Block.getBlockById(5).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 2, j + 10, k + 2), Block.getBlockById(89).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 3, j + 10, k + 2), Block.getBlockById(5).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 1, j + 10, k + 3), Block.getBlockById(5).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 2, j + 10, k + 3), Block.getBlockById(5).getStateFromMeta(0), 3);
					world.setBlockState(new BlockPos(i + 3, j + 10, k + 3), Block.getBlockById(5).getStateFromMeta(0), 3);
				}
			}
			return true;
		}
		}

	