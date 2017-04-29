package com.maw79.mods.blocks.historyblocks.romanquests;


import com.maw79.mods.client.gui.books.GuiDomusScorer;
import com.maw79.mods.handlers.ModSoundHandler;
import com.maw79.mods.main.Reference;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class BlockDomusScorer extends BlockContainer {
	
	
	 
	public BlockDomusScorer(String unlocalizedName) {
		super(Material.IRON);
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(Reference.MOD_ID, unlocalizedName));
		this.setHardness(3);
		this.setResistance(20);
		this.setLightLevel(10F);
		this.setDefaultState(this.blockState.getBaseState());
	
		
	}
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
	
		
		world.playSound(player, pos, ModSoundHandler.MAWSOUND_PAGETURN, SoundCategory.BLOCKS, 3.0F, 1.0F);
        
		
		if (world.isRemote)
	        {
			if(TileEntityRomanQuest.buildmodedone==true){
			Minecraft.getMinecraft().displayGuiScreen(new GuiDomusScorer());
			TileEntityRomanQuest.buildquestdone = true;
			}
			else{
				player.sendMessage(new TextComponentString("§c"+"A Build Coin Must First Be used"));
			}
	        }
		
		return true; 
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityRomanQuest();
	}
	
	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		return new TileEntityRomanQuest();
	}
	
	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state) {
		TileEntityRomanQuest te = (TileEntityRomanQuest) world.getTileEntity(pos);
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
	
	

}
