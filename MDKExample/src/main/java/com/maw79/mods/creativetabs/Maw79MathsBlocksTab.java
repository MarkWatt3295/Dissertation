package com.maw79.mods.creativetabs;


	import com.maw79.mods.init.ModBlocks;
import net.minecraft.creativetab.CreativeTabs;
	import net.minecraft.item.ItemStack;

	
	public class Maw79MathsBlocksTab extends CreativeTabs{

		/**
		 * Just says the unlocalized name of our creative tab
		 */
		public Maw79MathsBlocksTab() {
			super("maw79 mathsblocks");
		}

		/**
		 * Gets the item that will appear as the tabs icon
		 */
		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(ModBlocks.mathblock1);
		}

	}

