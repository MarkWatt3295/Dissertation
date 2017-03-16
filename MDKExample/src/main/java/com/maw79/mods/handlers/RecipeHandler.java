package com.maw79.mods.handlers;

import com.maw79.mods.init.ModArmour;
import com.maw79.mods.init.ModBlocks;
import com.maw79.mods.init.ModItems;
import com.maw79.mods.init.ModTools;
import com.maw79.mods.util.Utils;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class RecipeHandler {
		
		public static void registerCraftingRecipes(){
			registerToolRecipe(ModItems.obsidianingot, ModTools.obsidianPickaxe, ModTools.obsidianAxe, ModTools.obsidianShovel, ModTools.obsidianHoe, ModTools.obsidianSword2);
			registerArmourRecipe(ModItems.obsidianingot,ModArmour.obsidianHelmet, ModArmour.obsidianChestplate, ModArmour.obsidianLeggins, ModArmour.obsidianBoots);
			registerToolRecipe(ModItems.steelingot, ModTools.steelSword, null, null, null, null);
			
			
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.breaker, 1, 0), new Object[] { " P ", "RMR", "TTT", 'P', Items.IRON_PICKAXE, 'R', "dustRedstone", 'M', new ItemStack(ModBlocks.obsidianingotblock, 1, 0), 'T', ModItems.obsidianingot }));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.breaker, 1, 1), new Object[] { " P ", "RMR", "TTT", 'P', Items.IRON_PICKAXE, 'R', "dustRedstone", 'M', new ItemStack(ModBlocks.obsidianingotblock, 1, 1), 'T', ModItems.obsidianingot }));
		
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.steelSlabHalf, 2), new Object[] { "   ", "TTT", "   ", 'T', "ingotSteel" }));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.steelSlabHalf, 2), new Object[] { "TTT", "   ", "   ", 'T', "ingotSteel" }));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.steelSlabHalf, 2), new Object[] { "   ", "   ", "TTT", 'T', "ingotSteel" }));
			//GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.tinStairs, 4), new Object[] { "T  ", "TT ", "TTT", 'T', "ingotTin" }));
			Utils.getLogger().info("Registered Crafting Recipes!");
		
		
		}
		
		/**
		 * Register the furnace recipes
		 */
		public static void registerFurnaceRecipes() {
			GameRegistry.addSmelting(ModBlocks.steelOre, new ItemStack(ModItems.steelingot), 0.7f);
			Utils.getLogger().info("Registered Furnace Recipes!");
		}
		
		/**
		 * Registers a tool using the ingot
		 * @param ingot The ingot
		 * @param pickaxe The pickaxe
		 * @param axe The axe
		 * @param shovel The shovel
		 * @param hoe The hoe
		 * @param sword The sword
		 */
		private static void registerToolRecipe(Item ingot, Item pickaxe, Item axe, Item shovel, Item hoe, Item sword) {
			GameRegistry.addRecipe(new ItemStack(pickaxe), new Object[] { "III", " S ", " S ", 'I', ingot, 'S', Items.STICK });
			GameRegistry.addRecipe(new ItemStack(axe), new Object[] { "II ", "IS ", " S ", 'I', ingot, 'S', Items.STICK });
			GameRegistry.addRecipe(new ItemStack(axe), new Object[] { " II", " SI", " S ", 'I', ingot, 'S', Items.STICK });
			GameRegistry.addRecipe(new ItemStack(shovel), new Object[] { " I ", " S ", " S ", 'I', ingot, 'S', Items.STICK });
			GameRegistry.addRecipe(new ItemStack(hoe), new Object[] { " II", " S ", " S ", 'I', ingot, 'S', Items.STICK });
			GameRegistry.addRecipe(new ItemStack(hoe), new Object[] { "II ", " S ", " S ", 'I', ingot, 'S', Items.STICK });
			GameRegistry.addRecipe(new ItemStack(sword), new Object[] { " I ", " I ", " S ", 'I', ingot, 'S', Items.STICK });
		}
		
		
		/**
		 * Registers armour using the ingot
		 * @param ingot The ingot
		 * @param helmet The helmet
		 * @param chestplate The chestplate
		 * @param leggings The leggings
		 * @param boots The boots
		 */
		public static void registerArmourRecipe(Item ingot, Item helmet, Item chestplate, Item leggings, Item boots) {
			GameRegistry.addRecipe(new ItemStack(helmet), new Object[] { "III","I I","   ",'I',ingot});
			GameRegistry.addRecipe(new ItemStack(helmet), new Object[] { "   ","III","I I",'I',ingot});
			GameRegistry.addRecipe(new ItemStack(chestplate), new Object[] { "I I","III","III",'I',ingot});
			GameRegistry.addRecipe(new ItemStack(leggings), new Object[] { "III","I I","I I",'I',ingot});
			GameRegistry.addRecipe(new ItemStack(boots), new Object[] { "I I","I I","   ",'I',ingot});
			GameRegistry.addRecipe(new ItemStack(boots), new Object[] { "   ","I I","I I",'I',ingot});
		}
		
		
}
