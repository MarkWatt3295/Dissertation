package com.maw79.mods.blocks;

import java.util.List;

import com.maw79.mods.main.Reference;
import com.maw79.mods.util.Utils;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockSpawnSetter extends Block {
	
	/**
	 * Default constructor which sets the hardness and resistance
	 * @param unlocalizedName The unlocalized name
	 */
	public BlockSpawnSetter(String unlocalizedName) {
		super(Material.IRON);
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(Reference.MOD_ID, unlocalizedName));
		this.setHardness(5);
		this.setResistance(20);
	}
	
	 @Override
	    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
	        tooltip.add(I18n.format("tooltip.spawnsetter"));
	    }
	 
	 @Override
		public void onEntityWalk(World world, BlockPos pos, Entity entityIn) {
			if (true) {
				world.setSpawnPoint(pos);
				Utils.getLogger().info("Spaw Point set to : "+pos);
			//if (entityIn instanceof EntityLivingBase)
			//	((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(MobEffects.LEVITATION, 100, 0));
			super.onEntityWalk(world, pos, entityIn);
			}
		}
	

}
