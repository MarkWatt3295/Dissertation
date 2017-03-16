package com.maw79.mods.blocks;

import java.util.Random;

import com.maw79.mods.blocks.item.IMetaBlockName;
import com.maw79.mods.handlers.EnumHandler.OreType;
import com.maw79.mods.main.Maw79Mod;
import com.maw79.mods.main.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class BlockSteelOre extends Block implements IMetaBlockName {
	

		/**
		 * The type property
		 */
		public static final PropertyEnum TYPE = PropertyEnum.create("type", OreType.class);
		
		/**
		 * Default constructor
		 * @param unlocalizedName The block's unlocalized name
		 * @param registryName The block's registry name - defaultly the unlocalized name
		 */
		public BlockSteelOre(String unlocalizedName, String registryName) {
			super(Material.ROCK);
			this.setUnlocalizedName(unlocalizedName);
			this.setRegistryName(new ResourceLocation(Reference.MOD_ID, registryName));
			this.setHardness(20); //Sets how hard the block is to break
			this.setResistance(20); //Sets the blocks blast resitance to explosions
			this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, OreType.OVERWORLD)); //Default state
		}
		
		/**
		 * All the different item variants for the block
		 */
		@Override
		public void getSubBlocks(Item itemIn, CreativeTabs tab, NonNullList<ItemStack> list) {
			for(int i = 0; i < OreType.values().length; i++) {
				list.add(new ItemStack(itemIn, 1, i));
			}
		}
		
		/**
		 * Makes sure the block drops the correct version of itself
		 */
		@Override
		public int damageDropped(IBlockState state) {
			return getMetaFromState(state);
		}
		
		/**
		 * Makes sure when you pick block it will work correctly
		 */
		@Override
		public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos,
				EntityPlayer player) {
			return new ItemStack(Item.getItemFromBlock(this), 1, getMetaFromState(state));
		}
		
		/**
		 * Adds the properties to the block
		 */
		@Override
		protected BlockStateContainer createBlockState() {
			return new BlockStateContainer(this, new IProperty[] {TYPE});
		}
		
		/**
		 * Gets the right meta data from the {@link IBlockState}
		 */
		@Override
		public int getMetaFromState(IBlockState state) {
			OreType type = (OreType) state.getValue(TYPE);
			return type.getID();
		}
		
		/**
		 * Gets the correct {@link IBlockState} from the meta data
		 */
		@Override
		public IBlockState getStateFromMeta(int meta) {
			return this.getDefaultState().withProperty(TYPE, OreType.values()[meta]);
		}

		/**
		 * Inherited from the {@link IMetaBlockName}
		 */
		@Override
		public String getSpecialName(ItemStack stack) {
			return OreType.values()[stack.getItemDamage()].getName();
		}

	}