package com.maw79.mods.blocks;

import com.maw79.mods.handlers.ModSoundHandler;
import com.maw79.mods.main.Maw79Mod;
import com.maw79.mods.main.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.audio.SoundEventAccessor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
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
		this.setLightLevel(1.0F);
		
	}
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
	
		
		
		world.playSound(player, pos, ModSoundHandler.STEEL_FENCE_GATE_OPEN, SoundCategory.BLOCKS, 1.0F, 1.0F);
        
		//player.sendMessage(new TextComponentString("Pressing the Test Box 1"));
		//playerIn.setNoGravity(true);
		//world.newExplosion(player, pos.getX(), pos.getY(), pos.getZ(), 1, true, true);
		player.setDropItemsWhenDead(false);
		//player.capabilities.allowFlying = true;
		//player.attemptTeleport(x, y, z)
		
		
		return true; 
	}
	public boolean played = false;
	@Override
	public void onEntityWalk(World worldIn, BlockPos pos, Entity player) {
			// if(!player.world.isRemote){
				 //player.playSound(ModSoundHandler.MAWSOUND_VOICE1, 1.0F, 1.0F);
		//worldIn.playSound((EntityPlayer) player, player.getPosition(), ModSoundHandler.MAWSOUND_VOICE1, SoundCategory.MUSIC, 1, 1);
				 if(played == false){
				//player.playSound(ModSoundHandler.MAWSOUND_SQUELCH, 1.0F, 1.0F);
				player.sendMessage(new TextComponentString("😁 Walked On"));
				played = true;
				
				// player.sendMessage(new TextComponentString("Egypt is one of the hottest and sunniest countries in the world. It receives very little rain. The average temperature in the Nile Valley is over one hundred degrees Fahrenheit (38° C) from May through September. The average temperature in the region during the coldest months of the year is in the sixties (15- 20° C)."));
				 }
			// }
		//if (entityIn instanceof EntityLivingBase)
		//	((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(MobEffects.LEVITATION, 100, 0));
		//super.onEntityWalk(worldIn, pos, entityIn);
		
	}
	
	
	
	@Override
	public boolean canProvidePower(IBlockState state) {
		
		return true;
	}
	
	

}
