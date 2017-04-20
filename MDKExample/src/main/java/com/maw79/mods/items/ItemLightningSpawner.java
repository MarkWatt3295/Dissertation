package com.maw79.mods.items;

import com.maw79.mods.main.Maw79Mod;
import com.maw79.mods.main.Reference;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class ItemLightningSpawner extends Item {

	public ItemLightningSpawner(String unlocalizedName) {
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(Reference.MOD_ID, unlocalizedName));
		
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		if(!worldIn.isRemote){
			RayTraceResult pos = playerIn.rayTrace(100, 20);
			double x = pos.getBlockPos().getX();
			double y = pos.getBlockPos().getY();
			double z = pos.getBlockPos().getZ();
			worldIn.addWeatherEffect(new EntityLightningBolt(worldIn, x, y, z, true));
			return new ActionResult(EnumActionResult.SUCCESS, new ItemStack(this));

		}
		else{
		    return new ActionResult(EnumActionResult.FAIL, new ItemStack(this));
		}
	
	
	}
	
	
	
		
	
}
