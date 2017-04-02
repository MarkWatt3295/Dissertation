package com.maw79.mods.blocks;


import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.world.World;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
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
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.Minecraft;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.ITileEntityProvider;

import java.util.Random;

import com.maw79.mods.init.ModBlocks;
import com.maw79.mods.main.Reference;
import com.maw79.mods.tileentity.TileEntityCustom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;


	public class BlockBridgeBlock extends Block  {
		

		//public static Object instance;
		//int a1 = 0, a2 = 0, a3 = 0, a4 = 0, a5 = 0, a6 = 0;

		boolean red = false;
		
		public BlockBridgeBlock(String unlocalizedName) {
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

		

		/*@SideOnly(Side.CLIENT)
		@Override
		public BlockRenderLayer getBlockLayer() {
			return BlockRenderLayer.SOLID;
		}*/

		/*@Override
		@javax.annotation.Nullable
		public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
			return NULL_AABB;
		}*/

		@Override
		public boolean isFullCube(IBlockState state) {
			return true;
		}

	/*	@Override
		public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
			return new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
		}*/

		/*@Override
		public int tickRate(World world) {
			return 10;
		}*/

		@Override
		public int quantityDropped(Random par1Random) {
			return 1;
		}

		@Override
		public Item getItemDropped(IBlockState state, Random par2Random, int par3) {
			return new ItemStack(ModBlocks.bridge, 1, 0).getItem();
		}
		
		@Override
		public void onBlockClicked(World world, BlockPos pos, EntityPlayer entity) {
			int i = pos.getX();
			int j = pos.getY();
			int k = pos.getZ();
			if (true) {
				if (entity instanceof EntityLivingBase)
					((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 100, 0));
			}

		}
		
		@Override
		public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
			if (true) {
			if (entityIn instanceof EntityLivingBase)
				((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(MobEffects.LEVITATION, 100, 0));
			super.onEntityWalk(worldIn, pos, entityIn);
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

			
			}
			return true;
		}
		}

	