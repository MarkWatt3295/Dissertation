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
	public static final BlockFractionsBlock HALF_1 = new BlockFractionsBlock("fractions_half_1");
	public static final BlockFractionsBlock HALF_2 = new BlockFractionsBlock("fractions_half_2");
	public static final BlockFractionsBlock HALF_3 = new BlockFractionsBlock("fractions_half_3");
	public static final BlockFractionsBlock HALF_4 = new BlockFractionsBlock("fractions_half_4");
	public static final BlockFractionsBlock HALF_5 = new BlockFractionsBlock("fractions_half_5");
	
	public static final BlockFractionsBlock QUARTER_1 = new BlockFractionsBlock("fractions_quarter_1");
	public static final BlockFractionsBlock QUARTER_2 = new BlockFractionsBlock("fractions_quarter_2");
	public static final BlockFractionsBlock QUARTER_3 = new BlockFractionsBlock("fractions_quarter_3");
	public static final BlockFractionsBlock QUARTER_4 = new BlockFractionsBlock("fractions_quarter_4");
	public static final BlockFractionsBlock QUARTER_5 = new BlockFractionsBlock("fractions_quarter_5");
	
	public static final BlockFractionsBlock THIRD_1 = new BlockFractionsBlock("fractions_third_1");
	public static final BlockFractionsBlock THIRD_2 = new BlockFractionsBlock("fractions_third_2");
	public static final BlockFractionsBlock THIRD_3 = new BlockFractionsBlock("fractions_third_3");
	public static final BlockFractionsBlock THIRD_4 = new BlockFractionsBlock("fractions_third_4");
	public static final BlockFractionsBlock THIRD_5 = new BlockFractionsBlock("fractions_third_5");
	
	public static final BlockFractionsBlock CORRECT = new BlockFractionsBlock("correctblock");
	public static final BlockFractionsBlock FAKE = new BlockFractionsBlock("fakefractionsblock");	
	
	
	
	
	
	public static void register(){
		
		//Fraction Block Renders
		registerBlock(HALF_1);
		registerBlock(HALF_2);
		registerBlock(HALF_3);
		registerBlock(HALF_4);
		registerBlock(HALF_5);
		
		registerBlock(QUARTER_1);
		registerBlock(QUARTER_2);
		registerBlock(QUARTER_3);
		registerBlock(QUARTER_4);
		registerBlock(QUARTER_5);
		
		registerBlock(THIRD_1);
		registerBlock(THIRD_2);
		registerBlock(THIRD_3);
		registerBlock(THIRD_4);
		registerBlock(THIRD_5);
		
		registerBlock(CORRECT);
		registerBlock(FAKE);
		
		
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
		registerRender(HALF_1);
		registerRender(HALF_2);
		registerRender(HALF_3);
		registerRender(HALF_4);
		registerRender(HALF_5);
		
		registerRender(QUARTER_1);
		registerRender(QUARTER_2);
		registerRender(QUARTER_3);
		registerRender(QUARTER_4);
		registerRender(QUARTER_5);
		
		registerRender(THIRD_1);
		registerRender(THIRD_2);
		registerRender(THIRD_3);
		registerRender(THIRD_4);
		registerRender(THIRD_5);
		
		registerRender(CORRECT);
		registerRender(FAKE);
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
