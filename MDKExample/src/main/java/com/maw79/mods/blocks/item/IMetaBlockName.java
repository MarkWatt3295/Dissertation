package com.maw79.mods.blocks.item;

import net.minecraft.item.ItemStack;

public interface IMetaBlockName {

	/**
	 * Should return the name of the variant i.e. when we have the block breaker
	 * we have two types, Basic and Advanced, I just used "basic" and "advanced"
	 * for the correct item damage
	 * Refer to {@link ItemStack}.getItemDamage() to get the correct damage
	 * 
	 * @param stack The stack
	 * @return The name of the variant that specific item is
	 */
	String getSpecialName(ItemStack stack);

}