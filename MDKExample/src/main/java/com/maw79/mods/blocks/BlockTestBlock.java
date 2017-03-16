package com.maw79.mods.blocks;

import com.maw79.mods.handlers.ModSoundHandler;
import com.maw79.mods.main.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.audio.SoundEventAccessor;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class BlockTestBlock extends Block {
	
	/**
	 * Default constructor which sets the hardness and resistance
	 * @param unlocalizedName The unlocalized name
	 */
	public BlockTestBlock(String unlocalizedName) {
		super(Material.IRON);
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(Reference.MOD_ID, unlocalizedName));
		this.setHardness(3);
		this.setResistance(20);
		this.setLightLevel(10F);
		
	}
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
	
		
		
		world.playSound(player, pos, ModSoundHandler.STEEL_FENCE_GATE_OPEN, SoundCategory.BLOCKS, 1.0F, 1.0F);
        
		player.sendMessage(new TextComponentString("Pressing the Test Box 1"));
		//playerIn.setNoGravity(true);
		world.newExplosion(player, pos.getX(), pos.getY(), pos.getZ(), 1, true, true);
		player.setDropItemsWhenDead(false);
		player.capabilities.allowFlying = true;
		//player.attemptTeleport(x, y, z)
		
		
		return true; 
	}
	
	
	
	@Override
	public boolean canProvidePower(IBlockState state) {
		
		return true;
	}
	
	

}
