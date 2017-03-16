package com.maw79.mods.items;

import com.maw79.mods.main.Maw79Mod;
import com.maw79.mods.main.Reference;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class ItemModFood extends ItemFood{
	
	private PotionEffect[] effects;
	
	public ItemModFood(String unlocalizedName, int amount, boolean isWolfFood, PotionEffect...potionEffects) {
		super(amount, isWolfFood);
		this.effects = potionEffects;
		
		setUnlocalizedName(Reference.MawItems.MA.getUnlocalizedName());
		setRegistryName(Reference.MawItems.MA.getRegistryName());
		
		// TODO Auto-generated constructor stub
	}
	
	
	public ItemModFood(String unlocalizedName, int amount, float saturation, boolean isWolfFood, PotionEffect...potionEffects) {
		super(amount, saturation, isWolfFood);
		setUnlocalizedName(Reference.MawItems.MA.getUnlocalizedName());
		setRegistryName(Reference.MawItems.MA.getRegistryName());
	
		this.effects = potionEffects;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
		// TODO Auto-generated method stub
		for(PotionEffect effect : effects){
			player.addPotionEffect(effect);
		}
	}

}
