package com.maw79.mods.handlers;

import com.maw79.mods.init.ModBlocks;
import com.maw79.mods.init.ModItems;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class OreDictionaryHandler {
	
	/**
	 * Register the ores
	 */
	public static void registerOreDictionary() {
		OreDictionary.registerOre("oreSteel", ModBlocks.steelOre);
		OreDictionary.registerOre("ingotObsidian", ModItems.obsidianingot);
		OreDictionary.registerOre("blockObsidianIngot", ModBlocks.obsidianingotblock);
		OreDictionary.registerOre("chipBasic", new ItemStack(ModItems.chip, 1, 0)); //Basic Chip
		OreDictionary.registerOre("chipAdvanced", new ItemStack(ModItems.chip, 1, 1)); //Advanced Chip
	}

}