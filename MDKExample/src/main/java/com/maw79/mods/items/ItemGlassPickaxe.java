package com.maw79.mods.items;

import com.maw79.mods.main.Maw79Mod;
import com.maw79.mods.main.Reference;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public class ItemGlassPickaxe extends ItemPickaxe {
	
	public ItemGlassPickaxe(ToolMaterial material, String unlocalizedName) {
		super(material);
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(Reference.MOD_ID, unlocalizedName));
		this.setCreativeTab(Maw79Mod.debug);
		this.setMaxDamage(2);
		
	}

	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
		  player.inventory.getCurrentItem().damageItem(1, player );
		//  player.playSound(SoundEvent.REGISTRY.getObject(new ResourceLocation("block.glass.brake")), 2, 2);
		return super.onLeftClickEntity(stack, player, entity);
	}
	
	
}