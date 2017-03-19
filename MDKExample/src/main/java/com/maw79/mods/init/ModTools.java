package com.maw79.mods.init;

import com.maw79.mods.handlers.MaterialHandler;
import com.maw79.mods.items.ItemModAxe;
import com.maw79.mods.items.ItemModHoe;
import com.maw79.mods.items.ItemModPickaxe;
import com.maw79.mods.items.ItemModShovel;
import com.maw79.mods.items.ItemModSword;
import com.maw79.mods.items.ItemPaintBrush;
import com.maw79.mods.items.ItemSoulStealer;
import com.maw79.mods.main.Maw79Mod;
import com.maw79.mods.util.Utils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;

public class ModTools {
	
		
		
		
		/**
		 * State the individual tools
		 */
		public static ItemPickaxe obsidianPickaxe;
		public static ItemModAxe obsidianAxe; //NOTICE WE USE THE ITEMMODAXE NOT ITEMAXE
		public static ItemHoe obsidianHoe;
		public static ItemSpade obsidianShovel;
		public static ItemSword obsidianSword2;
		
		public static ItemSword steelSword;
		
		public static ItemSoulStealer soulStealer;
		public static ItemPaintBrush paintbrush;
		public static ItemPaintBrush rustypaintbrush;
		public static ItemPaintBrush mediumpaintbrush;
		public static ItemPaintBrush infinitepaintbrush;
		
		
	
		
		/**
		 * Initialize the tools
		 */
		public static void init() {
			obsidianPickaxe = new ItemModPickaxe(MaterialHandler.obsidianToolMaterial, "obsidian_pickaxe");
			obsidianAxe = new ItemModAxe(MaterialHandler.obsidianToolMaterial, "obsidian_axe");
			obsidianHoe = new ItemModHoe(MaterialHandler.obsidianToolMaterial, "obsidian_hoe");
			obsidianShovel = new ItemModShovel(MaterialHandler.obsidianToolMaterial, "obsidian_shovel");
			obsidianSword2 = new ItemModSword(MaterialHandler.obsidianToolMaterial, "obsidian_sword2");
			
			soulStealer = new ItemSoulStealer("soul_stealer");
			paintbrush = new ItemPaintBrush(MaterialHandler.paintBrushToolMaterial,"paint_brush");
			
			rustypaintbrush = new ItemPaintBrush(MaterialHandler.rustyPaintBrushToolMaterial,"rusty_paint_brush");
			//String tm = rustypaintbrush.getToolMaterialName();
			//System.out.println("***********************"+tm+"*************************");
			mediumpaintbrush = new ItemPaintBrush(MaterialHandler.mediumPaintBrushToolMaterial,"medium_paint_brush");
			infinitepaintbrush = new ItemPaintBrush(MaterialHandler.infinitePaintBrushToolMaterial,"infinite_paint_brush");
			
			
			
			steelSword = new ItemModSword(MaterialHandler.steelToolMaterial, "steel_sword");
			
		}
		
		/**
		 * Register the tools
		 */
		public static void register() {
			registerItem(obsidianPickaxe);
			registerItem(obsidianAxe);
			registerItem(obsidianHoe);
			registerItem(obsidianShovel);
			registerItem(obsidianSword2);
			
			registerItem(soulStealer);
			registerItem(paintbrush);
			registerItem(rustypaintbrush);
			registerItem(mediumpaintbrush);
			
			registerItem(infinitepaintbrush);
			infinitepaintbrush.setCreativeTab(Maw79Mod.debug);
			
			GameRegistry.register(steelSword);
			
		}
		
		/**
		 * Register the tools render
		 */
		public static void registerRenders() {
			registerRender(obsidianPickaxe);
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
			
		}
		
		public static void registerItem(Item item) {
			item.setCreativeTab(Maw79Mod.items); //Sets the creative tab
			GameRegistry.register(item);
			Utils.getLogger().info("Registered Tool: " + item.getUnlocalizedName().substring(5));
		}
		
		
		/**
		 * Register the com.maw79.mods.items render
		 * @param item The item
		 */
		
		
		private static void registerRender(Item item){
			
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
				
			Utils.getLogger().info("Registered render for Tools: " + item.getUnlocalizedName().substring(5));
				}

	}	
	

