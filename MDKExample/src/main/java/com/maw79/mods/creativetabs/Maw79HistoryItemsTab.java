package com.maw79.mods.creativetabs;


	import com.maw79.mods.init.ModItems;

import net.minecraft.creativetab.CreativeTabs;
	import net.minecraft.item.ItemStack;

	/**
	 * The creative tab for items from our mod
	 * @author Mark Watt
	 *
	 */
	public class Maw79HistoryItemsTab extends CreativeTabs{

		/**
		 * Just says the unlocalized name of our creative tab
		 */
		public Maw79HistoryItemsTab() {
			super("maw79 history items");
		}

		/**
		 * Gets the item that will appear as the tabs icon
		 */
		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(ModItems.ARTIFACT1);
		}

	}

