package com.maw79.mods.init;

import com.maw79.mods.handlers.MaterialHandler;
import com.maw79.mods.items.ItemModArmour;
import com.maw79.mods.main.Maw79Mod;
import com.maw79.mods.main.Reference;
import com.maw79.mods.util.Utils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModArmour {
	
	//public static ArmorMaterial obsidianMaterial = EnumHelper.addArmorMaterial("obsidian", "maw79:obsidian", 15, new int[]{2,6,5,2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 2.0f);

	public static ItemArmor obsidianHelmet;
	public static ItemArmor obsidianChestplate;
	public static ItemArmor obsidianLeggins;
	public static ItemArmor obsidianBoots;
	
	public static ItemArmor rubyHelmet;
	
	public static void init(){
		obsidianHelmet = new ItemModArmour(MaterialHandler.obsidianMaterial, 0, EntityEquipmentSlot.HEAD, "obsidian_helmet");
		obsidianChestplate = new ItemModArmour(MaterialHandler.obsidianMaterial, 0, EntityEquipmentSlot.CHEST, "obsidian_chestplate");
		obsidianLeggins = new ItemModArmour(MaterialHandler.obsidianMaterial, 1, EntityEquipmentSlot.LEGS, "obsidian_leggings");
		obsidianBoots = new ItemModArmour(MaterialHandler.obsidianMaterial, 0, EntityEquipmentSlot.FEET, "obsidian_boots");
		
		rubyHelmet = new ItemModArmour(MaterialHandler.obsidianMaterial, 0, EntityEquipmentSlot.HEAD, "ruby_helmet");
		
	}
	

	
	
	
	
	public static void register(){
		
		GameRegistry.register(obsidianHelmet);
		GameRegistry.register(obsidianChestplate);
		GameRegistry.register(obsidianLeggins);
		GameRegistry.register(obsidianBoots);
		
		GameRegistry.register(rubyHelmet);
	}
	
	public static void registerRenders(){
		registerRender(obsidianHelmet);
		registerRender(obsidianChestplate);
		registerRender(obsidianLeggins);
		registerRender(obsidianBoots);
		
		registerRender(rubyHelmet);
	}
	
	/*
	public static void registerRender(Item item){
	
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}*/
	/**
	 * Registers an item render and logs that is has been registered to the console
	 * @param item The item to register the render for
	 */
	public static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(new ResourceLocation(Reference.MOD_ID, item.getUnlocalizedName().substring(5)), "inventory"));
		Utils.getLogger().info("Registered render for " + item.getUnlocalizedName().substring(5));
	}
}
