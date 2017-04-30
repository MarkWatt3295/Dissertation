package com.maw79.mods.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModCrafting {

	public static void register(){
		/// XXX XXX XXX Top Middle Bottom
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.rubyblock), "RRR", "RRR", "RRR", 'R', ModItems.ruby);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.ruby), Items.EMERALD, Items.REDSTONE);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.ruby), Items.EMERALD, new ItemStack(Blocks.WOOL, 1,0)); //Quantity folllowed by metadata
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.obsidianingot), ModItems.ARTIFACT1);
		//GameRegistry.addShapelessRecipe(new ItemStack(ModItems.ruby), new ItemStack(Blocks.DIRT), new ItemStack(Blocks.DIRT)); Testing making com.maw79.mods.items
		//1f = 1 XP
		
		//SMELTING
		GameRegistry.addSmelting(Blocks.OBSIDIAN, new ItemStack(ModItems.obsidianingot), 0.5F);
		GameRegistry.addSmelting(Items.BREAD, new ItemStack(ModItems.burntloaf), 0.5F);
		GameRegistry.addSmelting(ModBlocks.steelOre, new ItemStack(ModItems.steelingot), 0.5F);
		
		//Tool Creation
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.obsidian_sword), ModItems.obsidianingot, ModItems.obsidianingot);
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.obsidian_sword), "I","I","S", 'I', ModItems.obsidianingot, 'S', ModItems.ruby );
		
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.obsidianingotblock), "RRR", "RRR", "RRR", 'R', ModItems.obsidianingot);
	
		
	
	
	
	
	}
}