package com.maw79.mods.creativetabs;


	import com.maw79.mods.init.ModBlocks;
import com.maw79.mods.init.ModItems;

import net.minecraft.creativetab.CreativeTabs;
	import net.minecraft.item.Item;
	import net.minecraft.item.ItemStack;

	
	public class Maw79BlocksTab extends CreativeTabs{

		/**
		 * Just says the unlocalized name of our creative tab
		 */
		public Maw79BlocksTab() {
			super("maw79 blocks");
		}

		/**
		 * Gets the item that will appear as the tabs icon
		 */
		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(ModBlocks.steelOre);
		}

	}

