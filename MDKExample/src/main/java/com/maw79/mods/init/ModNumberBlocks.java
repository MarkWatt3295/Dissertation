package com.maw79.mods.init;

import com.maw79.mods.blocks.mathsblocks.BlockBasicBlock;
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


public class ModNumberBlocks {
	

	
	//Number Face Blocks
	public static Block number1;
	public static Block number2;
	public static Block number3;
	public static Block number4;
	public static Block number5;
	public static Block number6;
	public static Block number7;
	public static Block number8;
	public static Block number9;
	public static Block number10;
	public static Block number11;
	public static Block number12;
	public static Block number13;
	public static Block number14;
	public static Block number15;
	public static Block number16;
	public static Block number17;
	public static Block number18;
	public static Block number19;
	public static Block number20;
	public static Block number21;
	

	public static void init(){
	
		//Number Face Blocks
		number1 = new BlockBasicBlock("block_number1");
		number2 = new BlockBasicBlock("block_number2");
		number3 = new BlockBasicBlock("block_number3");
		number4 = new BlockBasicBlock("block_number4");
		number5 = new BlockBasicBlock("block_number5");
		number6 = new BlockBasicBlock("block_number6");
		number7 = new BlockBasicBlock("block_number7");
		number8 = new BlockBasicBlock("block_number8");
		number9 = new BlockBasicBlock("block_number9");
		number10 = new BlockBasicBlock("block_number10");
		number11 = new BlockBasicBlock("block_number11");
		number12 = new BlockBasicBlock("block_number12");
		number13 = new BlockBasicBlock("block_number13");
		number14 = new BlockBasicBlock("block_number14");
		number15 = new BlockBasicBlock("block_number15");
		number16 = new BlockBasicBlock("block_number16");
		number17 = new BlockBasicBlock("block_number17");
		number18 = new BlockBasicBlock("block_number18");
		number19 = new BlockBasicBlock("block_number19");
		number20 = new BlockBasicBlock("block_number20");
		number21 = new BlockBasicBlock("block_number21");
		
	}
	
	public static void register(){
		
		//Number Face Blocks
		registerBlock(number1);
		registerBlock(number2);
		registerBlock(number3);
		registerBlock(number4);
		registerBlock(number5);
		registerBlock(number6);
		registerBlock(number7);
		registerBlock(number8);
		registerBlock(number9);
		registerBlock(number10);
		registerBlock(number11);
		registerBlock(number12);
		registerBlock(number13);
		registerBlock(number14);
		registerBlock(number15);
		registerBlock(number16);
		registerBlock(number17);
		registerBlock(number18);
		registerBlock(number19);
		registerBlock(number20);
		registerBlock(number21);
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
		registerRender(number1);
		registerRender(number2);
		registerRender(number3);
		registerRender(number4);
		registerRender(number5);
		registerRender(number6);
		registerRender(number7);
		registerRender(number8);
		registerRender(number9);
		registerRender(number10);
		registerRender(number11);
		registerRender(number12);
		registerRender(number13);
		registerRender(number14);
		registerRender(number15);
		registerRender(number16);
		registerRender(number17);
		registerRender(number18);
		registerRender(number19);
		registerRender(number20);
		registerRender(number21);
	}
	
		
	
	
	
	/*
	public static void registerRender(Block block){
Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
Utils.getLogger().info("Registered render for " + block.getUnlocalizedName().substring(5));
	}*/
	
	/**
	 * Registers the blocks renders
	 * @param block The block
	 */
	public static void registerRender(Block block) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(new ResourceLocation(Reference.MOD_ID, block.getUnlocalizedName().substring(5)), "inventory"));
		Utils.getLogger().info("Registered render for " + block.getUnlocalizedName().substring(5));
	}
	
	

	
}
