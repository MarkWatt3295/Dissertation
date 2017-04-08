package com.maw79.mods.blocks.ItemProfiler;


import java.util.Random;

import com.maw79.mods.client.gui.GuiHandler;
import com.maw79.mods.handlers.ModSoundHandler;
import com.maw79.mods.handlers.EnumHandler.ChipTypes;
import com.maw79.mods.main.Maw79Mod;
import com.maw79.mods.main.Reference;
import com.maw79.mods.util.Utils;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class BlockProfilerTE extends BlockContainer implements ITileEntityProvider {
	
	
	 
	public BlockProfilerTE(String unlocalizedName) {
		super(Material.IRON);
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(Reference.MOD_ID, unlocalizedName));
		this.setHardness(3);
		this.setResistance(20);
		this.setLightLevel(10F);
		this.setDefaultState(this.blockState.getBaseState());
		this.isBlockContainer = true;
		
	}
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
	
		
		
		world.playSound(player, pos, ModSoundHandler.STEEL_FENCE_GATE_OPEN, SoundCategory.BLOCKS, 1.0F, 1.0F);
        
		
		
		if (!world.isRemote)
	        {
	            player.openGui(Maw79Mod.instance, GuiHandler.PROFILER_GUI,  world, pos.getX(), pos.getY(), pos.getZ());
	        }
		
		
		return true; 
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityProfiler();
	}
	
	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		return new TileEntityProfiler();
	}
	
	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state) {
		TileEntityProfiler te = (TileEntityProfiler) world.getTileEntity(pos);
		IItemHandler handler = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
		for(int slot = 0; slot < handler.getSlots(); slot++) {
			ItemStack stack = handler.getStackInSlot(slot);
			InventoryHelper.spawnItemStack(world, pos.getX(), pos.getY(), pos.getZ(), stack);
		}
		super.breakBlock(world, pos, state);
	}
	@Override
	public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY,
			float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
		return this.getDefaultState();
	}
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.MODEL;
	}
	
	@Override
	public void randomDisplayTick(IBlockState state, World world, BlockPos pos, Random random) {
		EntityPlayer entity = Minecraft.getMinecraft().player;
		int i = pos.getX();
		int j = pos.getY();
		int k = pos.getZ();
		World par1World = world;
		int par2 = i;
		int par3 = j;
		int par4 = k;
		Random par5Random = random;
		if (true)
			for (int la = 0; la < 2; ++la) {
				double d0 = (double) ((float) par2 + 0.5F) + (double) (par5Random.nextFloat() - 0.5F) * 0.5D;
				double d1 = ((double) ((float) par3 + 0.7F) + (double) (par5Random.nextFloat() - 0.5F) * 0.5D) + 0.5D;
				double d2 = (double) ((float) par4 + 0.5F) + (double) (par5Random.nextFloat() - 0.5F) * 0.5D;
				double d3 = 0.2199999988079071D;
				double d4 = 0.27000001072883606D;
				par1World.spawnParticle(EnumParticleTypes.SMOKE_LARGE, d0 - d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
			}

	}
	

}
