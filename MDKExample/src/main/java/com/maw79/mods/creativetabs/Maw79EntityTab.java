package com.maw79.mods.creativetabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class Maw79EntityTab extends CreativeTabs{

	/**
	 * Just says the unlocalized name of our creative tab
	 */
	public Maw79EntityTab() {
		super("maw79 entity");
	}

	/**
	 * Gets the item that will appear as the tabs icon
	 */
	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(Items.SPAWN_EGG);
	}

}
