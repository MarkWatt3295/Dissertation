package com.maw79.mods.init;

import com.maw79.mods.blocks.mathsblocks.BlockBasicBlock;
import com.maw79.mods.blocks.mathsblocks.BlockFractionsBlock;
import com.maw79.mods.items.ItemModBow;
import com.maw79.mods.main.Maw79Mod;
import com.maw79.mods.main.Reference;
import com.maw79.mods.util.Utils;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;


public class ModFractionsBlocks {
	

	
	//Fractions Block Creation
	public static final BlockFractionsBlock HALF = new BlockFractionsBlock("fractions_half");
	public static final BlockFractionsBlock TWOFOURTHS = new BlockFractionsBlock("fractions_two_fourths");
	public static final BlockFractionsBlock THREESIXTHS = new BlockFractionsBlock("fractions_three_sixths");
	public static final BlockFractionsBlock HALFDECIMAL = new BlockFractionsBlock("fractions_half_decimal");
	public static final BlockFractionsBlock FIFTY100 = new BlockFractionsBlock("fractions_fifty_100");
	
	public static final BlockFractionsBlock QUARTER = new BlockFractionsBlock("fractions_quarter");
	public static final BlockFractionsBlock QUARTERDECIMAL = new BlockFractionsBlock("fractions_quarter_decimal");
	public static final BlockFractionsBlock TWOEIGHTS = new BlockFractionsBlock("fractions_two_eights");
	public static final BlockFractionsBlock TWENTYFIVE100 = new BlockFractionsBlock("fractions_twentyfive_100");
	public static final BlockFractionsBlock FIFTY200 = new BlockFractionsBlock("fractions_fifty_200");
	
	public static final BlockFractionsBlock THIRD = new BlockFractionsBlock("fractions_third");
	public static final BlockFractionsBlock TWOSIXTHS = new BlockFractionsBlock("fractions_two_sixths");
	public static final BlockFractionsBlock THREETWELVES = new BlockFractionsBlock("fractions_three_twelves");
	public static final BlockFractionsBlock FORTY120 = new BlockFractionsBlock("fractions_forty_120");
	public static final BlockFractionsBlock SEVENTY210 = new BlockFractionsBlock("fractions_seventy_210");
	
	public static final BlockFractionsBlock CORRECT = new BlockFractionsBlock("correctblock");
	
	
	
	
	
	
	public static void register(){
		
		//Fraction Block Renders
		registerBlock(HALF);
		registerBlock(TWOFOURTHS);
		registerBlock(THREESIXTHS);
		registerBlock(HALFDECIMAL);
		registerBlock(FIFTY100);
		
		registerBlock(QUARTER);
		registerBlock(QUARTERDECIMAL);
		registerBlock(TWOEIGHTS);
		registerBlock(TWENTYFIVE100);
		registerBlock(FIFTY200);
		
		registerBlock(THIRD);
		registerBlock(TWOSIXTHS);
		registerBlock(THREETWELVES);
		registerBlock(FORTY120);
		registerBlock(SEVENTY210);
		
		registerBlock(CORRECT);
		
		
	}
	
	
	public static void registerBlock(Block block) {
		block.setCreativeTab(Maw79Mod.mathsblocks);
		GameRegistry.register(block);
		GameRegistry.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
		Utils.getLogger().info("Registered Block: " + block.getUnlocalizedName().substring(5));
	}
	

	public static void registerBlock(Block block, ItemBlock itemBlock) {
		block.setCreativeTab(Maw79Mod.mathsblocks);
		GameRegistry.register(block);
		GameRegistry.register(itemBlock.setRegistryName(block.getRegistryName()));
		Utils.getLogger().info("Registered Block: " + block.getUnlocalizedName().substring(5));
	}
	
	public static void registerRenders(){
	
		
		//Number Face Blocks
		registerRender(HALF);
		registerRender(TWOFOURTHS);
		registerRender(THREESIXTHS);
		registerRender(HALFDECIMAL);
		registerRender(FIFTY100);
		
		registerRender(QUARTER);
		registerRender(QUARTERDECIMAL);
		registerRender(TWOEIGHTS);
		registerRender(TWENTYFIVE100);
		registerRender(FIFTY200);
		
		registerRender(THIRD);
		registerRender(TWOSIXTHS);
		registerRender(THREETWELVES);
		registerRender(FORTY120);
		registerRender(SEVENTY210);
		
		registerRender(CORRECT);
	}
	
	
	/**
	 * Registers the blocks renders
	 * @param block The block
	 */
	public static void registerRender(Block block) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(new ResourceLocation(Reference.MOD_ID, block.getUnlocalizedName().substring(5)), "inventory"));
		Utils.getLogger().info("Registered render for " + block.getUnlocalizedName().substring(5));
	}
	
	

	
}
