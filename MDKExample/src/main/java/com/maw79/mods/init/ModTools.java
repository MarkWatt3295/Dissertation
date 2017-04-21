package com.maw79.mods.init;

import com.maw79.mods.handlers.MaterialHandler;
import com.maw79.mods.items.ItemGlassPickaxe;
import com.maw79.mods.items.ItemModAxe;
import com.maw79.mods.items.ItemModHoe;
import com.maw79.mods.items.ItemModPickaxe;
import com.maw79.mods.items.ItemModShovel;
import com.maw79.mods.items.ItemModSword;
import com.maw79.mods.items.ItemPaintBrush;
import com.maw79.mods.items.ItemSoulStealer;
import com.maw79.mods.items.mathsitems.ItemFractionStamp;
import com.maw79.mods.items.mathsitems.ItemFractionStampQuarter;
import com.maw79.mods.items.mathsitems.ItemFractionStampThird;
import com.maw79.mods.items.mathsitems.ItemQuestionWand;
import com.maw79.mods.main.Maw79Mod;
import com.maw79.mods.main.Reference;
import com.maw79.mods.util.Utils;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ResourceLocation;

public class ModTools {
	
		
		
		
		/**
		 * State the individual tools
		 */
		public static ItemPickaxe obsidianPickaxe;
		public static ItemModAxe obsidianAxe; //NOTICE WE USE THE ITEMMODAXE NOT ITEMAXE
		public static ItemHoe obsidianHoe;
		public static ItemSpade obsidianShovel;
		public static ItemSword obsidianSword2;
		public static ItemPickaxe glassPickaxe;
		
		public static ItemSword steelSword;
		
		public static ItemSoulStealer soulStealer;
		public static ItemPaintBrush paintbrush;
		public static ItemPaintBrush rustypaintbrush;
		public static ItemPaintBrush mediumpaintbrush;
		public static ItemPaintBrush infinitepaintbrush;
		public static ItemFractionStamp fractionstamphalf;
		public static ItemFractionStampThird fractionstampthird;
		public static ItemFractionStampQuarter fractionstampquarter;
		public static ItemQuestionWand questionwand;
		
		
		
	
		
		/**
		 * Initialize the tools
		 */
		public static void init() {
			obsidianPickaxe = new ItemModPickaxe(MaterialHandler.obsidianToolMaterial, "obsidian_pickaxe");
			glassPickaxe = new ItemGlassPickaxe(MaterialHandler.glassToolMaterial, "glass_pickaxe");//RENAME ME PLIZ
			obsidianAxe = new ItemModAxe(MaterialHandler.obsidianToolMaterial, "obsidian_axe");
			obsidianHoe = new ItemModHoe(MaterialHandler.obsidianToolMaterial, "obsidian_hoe");
			obsidianShovel = new ItemModShovel(MaterialHandler.obsidianToolMaterial, "obsidian_shovel");
			obsidianSword2 = new ItemModSword(MaterialHandler.obsidianToolMaterial, "obsidian_sword2");
			
			soulStealer = new ItemSoulStealer("soul_stealer");
			paintbrush = new ItemPaintBrush(MaterialHandler.paintBrushToolMaterial,"paint_brush");
			
			rustypaintbrush = new ItemPaintBrush(MaterialHandler.rustyPaintBrushToolMaterial,"rusty_paint_brush");
			
			mediumpaintbrush = new ItemPaintBrush(MaterialHandler.mediumPaintBrushToolMaterial,"medium_paint_brush");
			infinitepaintbrush = new ItemPaintBrush(MaterialHandler.infinitePaintBrushToolMaterial,"infinite_paint_brush");
			
			fractionstamphalf = new ItemFractionStamp(MaterialHandler.halfStampMaterial,"fractions_half_stamp");
			fractionstampthird = new ItemFractionStampThird(MaterialHandler.halfStampMaterial,"fractions_third_stamp");
			fractionstampquarter = new ItemFractionStampQuarter(MaterialHandler.halfStampMaterial,"fractions_quarter_stamp");
			
			steelSword = new ItemModSword(MaterialHandler.steelToolMaterial, "steel_sword");
			
			questionwand = new ItemQuestionWand(MaterialHandler.wandToolMaterial, "question_wand");
		}
		
		/**
		 * Register the tools
		 */
		public static void register() {
			registerItem(obsidianPickaxe);
			registerItem(glassPickaxe);
			registerItem(obsidianAxe);
			registerItem(obsidianHoe);
			registerItem(obsidianShovel);
			registerItem(obsidianSword2);
			
			registerItem(soulStealer);
			registerItem(paintbrush);
			registerItem(rustypaintbrush);
			registerItem(mediumpaintbrush);
			
			registerItem(fractionstamphalf);
			registerItem(fractionstampthird);
			registerItem(fractionstampquarter);
			registerItem(questionwand);
			
			registerItem(infinitepaintbrush);
			infinitepaintbrush.setCreativeTab(Maw79Mod.debug);
			
			GameRegistry.register(steelSword);
			
		}
		
		/**
		 * Register the tools render
		 */
		public static void registerRenders() {
			registerRender(obsidianPickaxe);
			registerRender(glassPickaxe);
			registerRender(obsidianAxe);
			registerRender(obsidianHoe);
			registerRender(obsidianShovel);
			registerRender(obsidianSword2);
			registerRender(paintbrush);
			registerRender(rustypaintbrush);
			registerRender(mediumpaintbrush);
			registerRender(infinitepaintbrush);
			registerRender(soulStealer);
			registerRender(steelSword);
			registerRender(fractionstamphalf);
			registerRender(fractionstampthird);
			registerRender(fractionstampquarter);
			registerRender(questionwand);
			
		}
		
		public static void registerItem(Item item) {
			item.setCreativeTab(Maw79Mod.items); //Sets the creative tab
			GameRegistry.register(item);
			Utils.getLogger().info("Registered Tool: " + item.getUnlocalizedName().substring(5));
		}
		
		
	
		
		/**
		 * Register the items render
		 * @param item The item
		 */
		public static void registerRender(Item item) {
			ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(new ResourceLocation(Reference.MOD_ID, item.getUnlocalizedName().substring(5)), "inventory"));
			Utils.getLogger().info("Registered render for " + item.getUnlocalizedName().substring(5));
		}


	}	
	

