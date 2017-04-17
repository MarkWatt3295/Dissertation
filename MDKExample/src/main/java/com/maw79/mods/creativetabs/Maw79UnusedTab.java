package com.maw79.mods.creativetabs;


import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

	
	public class Maw79UnusedTab extends CreativeTabs{

		/**
		 * Just says the unlocalized name of our creative tab
		 */
		public Maw79UnusedTab() {
			super("maw79 unsed");
		}

		/**
		 * Gets the item that will appear as the tabs icon
		 */
		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(Items.SKULL);
		}

	}

