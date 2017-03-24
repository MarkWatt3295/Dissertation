package com.maw79.mods.items;


import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import java.util.function.BiFunction;

import com.maw79.mods.main.Reference;


public class ItemModArrow extends ItemArrow {
	/**
	 * A factory function to create the arrow entity.
	 */
	private final BiFunction<World, EntityLivingBase, EntityTippedArrow> entityFactory;

	public ItemModArrow(String unlocalizedName, BiFunction<World, EntityLivingBase, EntityTippedArrow> entityFactory) {
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(Reference.MOD_ID, unlocalizedName));
		this.entityFactory = entityFactory;
		this.setMaxDamage(1);
	}

	@Override
	public EntityArrow createArrow(World worldIn, ItemStack stack, EntityLivingBase shooter) {
		final EntityTippedArrow entityModArrow = entityFactory.apply(worldIn, shooter);
		entityModArrow.setPotionEffect(stack);
		return entityModArrow;
	}

	@Override
	public boolean isInfinite(ItemStack stack, ItemStack bow, EntityPlayer player) {
		//return true;
		return false;
	}
}