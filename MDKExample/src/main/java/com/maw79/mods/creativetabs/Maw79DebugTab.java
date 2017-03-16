package com.maw79.mods.creativetabs;


	import com.maw79.mods.init.ModBlocks;
import com.maw79.mods.init.ModItems;
import com.maw79.mods.init.ModTools;

import net.minecraft.creativetab.CreativeTabs;
	import net.minecraft.item.Item;
	import net.minecraft.item.ItemStack;

	
	public class Maw79DebugTab extends CreativeTabs{

		/**
		 * Just says the unlocalized name of our creative tab
		 */
		public Maw79DebugTab() {
			super("maw79 debug");
		}

		/**
		 * Gets the item that will appear as the tabs icon
		 */
		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(ModTools.rustypaintbrush);
		}

	}

