package com.maw79.mods.init;

import com.maw79.mods.blocks.BlockBreaker;
import com.maw79.mods.blocks.BlockBridgeBlock;
import com.maw79.mods.blocks.BlockCreativeBlock;
import com.maw79.mods.blocks.BlockCustomModel;
import com.maw79.mods.blocks.BlockGamemodeDetector;
import com.maw79.mods.blocks.BlockGravityBlockNeg;
import com.maw79.mods.blocks.BlockGravityBlockPos;
import com.maw79.mods.blocks.BlockJar;
import com.maw79.mods.blocks.BlockMachineFrame;
import com.maw79.mods.blocks.BlockObsidianIngot;
import com.maw79.mods.blocks.BlockRuby;
import com.maw79.mods.blocks.BlockSteel;
import com.maw79.mods.blocks.BlockSteelButton;
import com.maw79.mods.blocks.BlockSteelFence;
import com.maw79.mods.blocks.BlockSteelFenceGate;
import com.maw79.mods.blocks.BlockSteelOre;
import com.maw79.mods.blocks.BlockSteelPressurePlate;
import com.maw79.mods.blocks.BlockSteelSlabDouble;
import com.maw79.mods.blocks.BlockSteelSlabHalf;
import com.maw79.mods.blocks.BlockSteelStairs;
import com.maw79.mods.blocks.BlockSurvivalBlock;
import com.maw79.mods.blocks.BlockTestBlock;
import com.maw79.mods.blocks.BlockTestBlock2;
import com.maw79.mods.blocks.BlockTestBlock3;
import com.maw79.mods.blocks.BlockTestBlock4;
import com.maw79.mods.blocks.item.ItemBlockBreaker;
import com.maw79.mods.blocks.item.ItemBlockMeta;
import com.maw79.mods.blocks.mathsblocks.BlockBasicBlock;
import com.maw79.mods.blocks.mathsblocks.BlockMathsAdditionBlock;
import com.maw79.mods.blocks.mathsblocks.BlockMathsDivisionBlock;
import com.maw79.mods.blocks.mathsblocks.BlockMathsQuestionBlock;
import com.maw79.mods.blocks.mathsblocks.BlockMathsQuizBlock;
import com.maw79.mods.blocks.mathsblocks.BlockMathsSubtractionBlock;
import com.maw79.mods.blocks.mathsblocks.mcreator_testBlock;
import com.maw79.mods.blocks.scienceblocks.BlockLablerBlock;
import com.maw79.mods.blocks.scienceblocks.BlockScienceWool;
import com.maw79.mods.blocks.scienceblocks.insulatorblocks.BlockInsulatorMainTE;
import com.maw79.mods.blocks.scienceblocks.insulatorblockscalculator.BlockInsulatorCalculatorTE;
import com.maw79.mods.blocks.scienceblocks.sciencewool.BlockScienceWoolP;
import com.maw79.mods.blocks.scienceblocks.sciencewool.ItemScienceWool;
import com.maw79.mods.blocks.scienceblocks.tileentityscience.BlockScienceTE;
import com.maw79.mods.blocks.tileentityattempt.BlockTestTE;
import com.maw79.mods.handlers.EnumHandler;
import com.maw79.mods.blocks.ItemProfiler.BlockProfilerTE;
import com.maw79.mods.blocks.historyblocks.BlockArtifactOre;
import com.maw79.mods.blocks.historyblocks.BlockBrightBlock;
import com.maw79.mods.blocks.historyblocks.artifactupdater.BlockArtifactResearcher;
import com.maw79.mods.main.Maw79Mod;
import com.maw79.mods.main.Reference;
import com.maw79.mods.tileentity.storetileentity.BlockStoreTE;
import com.maw79.mods.util.Utils;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemSlab;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;


public class ModBlocks {
	
	public static Block rubyblock;
	public static Block obsidianingotblock;
	public static Block steelOre;
	public static Block artifactOre;
	public static Block steelBlock;
	public static Block breaker;
	public static Block gamemodeDetector;
	public static Block machineFrame;
	public static BlockSteelSlabHalf steelSlabHalf;
	public static BlockSteelSlabDouble steelSlabDouble;
	public static BlockSteelStairs steelStairs;
	public static BlockSteelFence steelFence;
	public static BlockSteelFenceGate steelFenceGate;
	public static Block steelButton;
	public static Block steelPressurePlate;
	public static Block testBlock;
	public static Block testBlock2;
	public static Block testBlock3;
	public static Block testBlock4;
	public static Block gravityPos;
	public static Block gravityNeg;
	public static Block jar;
	public static Block customModel;
	public static Block creative;
	public static Block survival;
	public static Block profiler;
	public static Block storeblock;
	
	//MATHS BLOCKS
	public static Block mathblock1;
	public static Block mathblock2;
	public static Block mathsquestionblock;
	public static Block mathsquestionblock2;
	public static Block mathsquizblock;
	public static Block newtestblock;
	public static Block mathsdivisionblock;
	public static Block mathsadditionblock;
	public static Block mathssubtractionblock;
	
	//MATH BLOCK COLOURS
	public static Block mathblockbrown;
	public static Block mathblockgreen;
	public static Block mathblockaqua;
	public static Block mathblockblue;
	public static Block mathblockpeach;
	public static Block mathblockwhite;
	
	public static Block mathblockblack;
	public static Block mathblockgold;
	public static Block mathblockorange;
	public static Block mathblocklightorange;
	public static Block mathblockmarrowbrown;
	public static Block mathblockgrey;
	
	//MATH BLOCK TextBlocks
	public static Block mathtextblockbrown;
	public static Block mathtextblockgreen;
	public static Block mathtextblockaqua;
	public static Block mathtextblockblue;
	public static Block mathtextblockpeach;
	public static Block mathtextblockwhite;
	
	public static Block mathtextblockblack;
	public static Block mathtextblockgold;
	public static Block mathtextblockorange;
	public static Block mathtextblocklightorange;
	public static Block mathtextblockmarrowbrown;
	public static Block mathtextblockgrey;
	
	//Science Blocks
	public static Block testblockte;
	public static Block sciencewoolblock;
	public static Block materialproperties;
	public static Block woodproperties;
	public static Block labler;
	public static Block bridge;
	public static Block insulatormain;
	public static Block insulatorcalculator;
	
	//Science Insulators
	public static Block plasticblock;
	public static Block polyurethanefoam;
	public static Block woodfelt;
	public static Block sciencewool;
	public static Block corkboard;
	public static Block copper;
	public static Block insulationwool;

	//HISTORY BLOCKS
	public static Block artifactresearcher;
	public static Block brightsandstone;
	
	
	

	public static void init(){
		
		rubyblock = new BlockRuby("ruby_block");
		obsidianingotblock = new BlockObsidianIngot("obsidian_ingot_block");
		steelOre = new BlockSteelOre("steel_ore", "steel_ore");
		artifactOre = new BlockArtifactOre("artifact_ore", "artifact_ore");
		steelBlock = new BlockSteel("steel_block");
		breaker = new BlockBreaker("block_breaker");
		gamemodeDetector = new BlockGamemodeDetector("gamemode_detector");
		machineFrame = new BlockMachineFrame("machine_frame");
		steelSlabHalf = new BlockSteelSlabHalf("steel_slab_half");
		steelSlabDouble = new BlockSteelSlabDouble("steel_slab_double");
		steelStairs = new BlockSteelStairs("steel_stairs", steelBlock.getDefaultState());
		steelFence = new BlockSteelFence("steel_fence");
		steelFenceGate = new BlockSteelFenceGate("steel_fence_gate");
		steelButton = new BlockSteelButton("steel_button");
		steelPressurePlate = new BlockSteelPressurePlate("steel_pressure_plate");
		testBlock = new BlockTestBlock("test_block");
		testBlock2 = new BlockTestBlock2("test_block2");
		testBlock3 = new BlockTestBlock3("test_block3");
		testBlock4 = new BlockTestBlock4("test_block4");
		gravityPos = new BlockGravityBlockPos("gravity_block_pos");
		gravityNeg = new BlockGravityBlockNeg("gravity_block_neg");
		jar = new BlockJar("block_jar");
		customModel = new BlockCustomModel("custom_model");
		creative = new BlockCreativeBlock("block_creative");
		survival = new BlockSurvivalBlock("block_survival");
		profiler = new BlockProfilerTE("block_profiler");
		storeblock = new BlockStoreTE("store_block");
		
		//MATHS BLOCKS
		mathblock1 = new BlockBasicBlock("math_block_1");
		mathblock2 = new BlockBasicBlock("math_block_2");
		newtestblock = new mcreator_testBlock("newtestblock");
		mathsquestionblock = new BlockMathsQuestionBlock("maths_question_block");
		mathsquestionblock2 = new BlockMathsQuestionBlock("maths_question_block2");
		mathsquizblock = new BlockMathsQuizBlock("maths_quiz1");
		mathsquizblock.setCreativeTab(Maw79Mod.mathsblocks);
		mathsdivisionblock = new BlockMathsDivisionBlock("maths_division_block");
		mathssubtractionblock = new BlockMathsSubtractionBlock("maths_subtraction_block");
		mathsadditionblock = new BlockMathsAdditionBlock("maths_addition_block");
		
		//MATHS BLOCK COLOURS
		mathblockbrown= new BlockBasicBlock("maths_brown_block");
		mathblockgreen= new BlockBasicBlock("maths_green_block");
		mathblockaqua= new BlockBasicBlock("maths_aqua_block");
		mathblockblue= new BlockBasicBlock("maths_blue_block");
		mathblockpeach= new BlockBasicBlock("maths_peach_block");
		mathblockwhite= new BlockBasicBlock("maths_white_block");
		
		mathblockblack= new BlockBasicBlock("maths_black_block");
		mathblockgold= new BlockBasicBlock("maths_gold_block");
		mathblockorange= new BlockBasicBlock("maths_orange_block");
		mathblocklightorange= new BlockBasicBlock("maths_lightorange_block");
		mathblockmarrowbrown= new BlockBasicBlock("maths_marrowbrown_block");
		mathblockgrey= new BlockBasicBlock("maths_grey_block"); 
		
		//MATHS BLOCK Text
		mathtextblockbrown= new BlockBasicBlock("mathtexts_brown_block");
		mathtextblockgreen= new BlockBasicBlock("mathtexts_green_block");
		mathtextblockaqua= new BlockBasicBlock("mathtexts_aqua_block");
		mathtextblockblue= new BlockBasicBlock("mathtexts_blue_block");
		mathtextblockpeach= new BlockBasicBlock("mathtexts_peach_block");
		mathtextblockwhite= new BlockBasicBlock("mathtexts_white_block");
		
		mathtextblockblack= new BlockBasicBlock("mathtexts_black_block");
		mathtextblockgold= new BlockBasicBlock("mathtexts_gold_block");
		mathtextblockorange= new BlockBasicBlock("mathtexts_orange_block");
		mathtextblocklightorange= new BlockBasicBlock("mathtexts_lightorange_block");
		mathtextblockmarrowbrown= new BlockBasicBlock("mathtexts_marrowbrown_block");
		mathtextblockgrey= new BlockBasicBlock("mathtexts_grey_block");
		
		//Science Blocks
		testblockte = new BlockTestTE("test_block_te");
		materialproperties = new BlockScienceTE("science_te");
		woodproperties = new BlockScienceTE("wood_properties_te");
		labler = new BlockLablerBlock("labler_block");
		
		sciencewool = new BlockScienceWoolP("science_wool");
		insulatormain = new BlockInsulatorMainTE("insulator_main");
		insulatorcalculator = new BlockInsulatorCalculatorTE("insulator_calculator");
		bridge = new BlockBridgeBlock("bridge_block");
		//Science Insulators
		plasticblock = new BlockBasicBlock("plastic_block");
		sciencewoolblock = new BlockScienceWool("science_wool_block");
		woodfelt = new BlockBasicBlock("woodfelt_block");
		polyurethanefoam = new BlockBasicBlock("polyurethanefoam_block");
		copper = new BlockBasicBlock("copper_block");
		corkboard = new BlockBasicBlock("corkboard_block");
		insulationwool = new BlockBasicBlock("insulationwool_block");
		
		//History Blocks
		artifactresearcher = new BlockArtifactResearcher("artifactresearcher");
		brightsandstone = new BlockBrightBlock("bright_sandstone");
	}
	
	public static void register(){
		registerBlock(storeblock);
		storeblock.setCreativeTab(Maw79Mod.unused);
		registerBlock(bridge);
		registerBlock(rubyblock);
		registerBlock(obsidianingotblock);
		registerBlock(steelOre, new ItemBlockMeta(steelOre)); //Says that the block uses the ItemBlockMeta as the item block
		registerBlock(artifactOre, new ItemBlockMeta(artifactOre));
		registerBlock(steelBlock);
		registerBlock(breaker, new ItemBlockBreaker(breaker));
		breaker.setCreativeTab(Maw79Mod.unused);
		registerBlock(gamemodeDetector);
		gamemodeDetector.setCreativeTab(Maw79Mod.unused);
		registerBlock(machineFrame, new ItemBlockMeta(machineFrame));
		machineFrame.setCreativeTab(Maw79Mod.unused);
		registerBlock(steelSlabHalf, new ItemSlab(steelSlabHalf, steelSlabHalf, steelSlabDouble));
		GameRegistry.register(steelSlabDouble); //Doesn't need an item
		registerBlock(steelStairs);
		registerBlock(steelFence);
		registerBlock(steelFenceGate);
		registerBlock(steelButton);
		registerBlock(steelPressurePlate);
		registerBlock(testBlock);
		registerBlock(testBlock2);
		registerBlock(testBlock3);
		registerBlock(testBlock4);
		registerBlock(gravityPos);
		registerBlock(gravityNeg);
		registerBlock(jar);
		registerBlock(customModel);
		customModel.setCreativeTab(Maw79Mod.unused);
		registerBlock(creative);
		registerBlock(survival);
		registerBlock(profiler);
		registerBlock(newtestblock);
		
		//MATHS BLOCKS
		registerBlock(mathsdivisionblock);
		mathsdivisionblock.setCreativeTab(Maw79Mod.unused);
		registerBlock(mathsadditionblock);
		mathsadditionblock.setCreativeTab(Maw79Mod.mathsblocks);
		registerBlock(mathssubtractionblock);
		mathssubtractionblock.setCreativeTab(Maw79Mod.mathsblocks);
		registerBlock(mathblock1);
		mathblock1.setCreativeTab(Maw79Mod.mathsblocks);
		registerBlock(mathblock2);
		mathblock2.setCreativeTab(Maw79Mod.mathsblocks);
		registerBlock(mathsquestionblock);
		mathsquestionblock.setCreativeTab(Maw79Mod.mathsblocks);
		registerBlock(mathsquestionblock2);
		mathsquestionblock2.setCreativeTab(Maw79Mod.unused);
		registerBlock(mathsquizblock);
		mathsquizblock.setCreativeTab(Maw79Mod.unused);
		
		//MATHS BLOCK Colours
		registerBlock(mathblockbrown);
		mathblockbrown.setCreativeTab(Maw79Mod.mathsblocks);
		registerBlock(mathblockgreen);
		mathblockgreen.setCreativeTab(Maw79Mod.mathsblocks);
		registerBlock(mathblockaqua);
		mathblockaqua.setCreativeTab(Maw79Mod.mathsblocks);
		registerBlock(mathblockblue);
		mathblockblue.setCreativeTab(Maw79Mod.mathsblocks);
		registerBlock(mathblockpeach);
		mathblockpeach.setCreativeTab(Maw79Mod.mathsblocks);
		registerBlock(mathblockwhite);
		mathblockwhite.setCreativeTab(Maw79Mod.mathsblocks);
		
		registerBlock(mathblockblack);
		mathblockblack.setCreativeTab(Maw79Mod.mathsblocks);
		registerBlock(mathblockgold);
		mathblockgold.setCreativeTab(Maw79Mod.mathsblocks);
		registerBlock(mathblockorange);
		mathblockorange.setCreativeTab(Maw79Mod.mathsblocks);
		registerBlock(mathblocklightorange);
		mathblocklightorange.setCreativeTab(Maw79Mod.mathsblocks);
		registerBlock(mathblockmarrowbrown);
		mathblockmarrowbrown.setCreativeTab(Maw79Mod.mathsblocks);
		registerBlock(mathblockgrey);
		mathblockgrey.setCreativeTab(Maw79Mod.mathsblocks); 
		
		//MATHS BLOCK Text
		registerBlock(mathtextblockbrown);
		mathtextblockbrown.setCreativeTab(Maw79Mod.mathsscratchblocks);
		registerBlock(mathtextblockgreen);
		mathtextblockgreen.setCreativeTab(Maw79Mod.mathsscratchblocks);
		registerBlock(mathtextblockaqua);
		mathtextblockaqua.setCreativeTab(Maw79Mod.mathsscratchblocks);
		registerBlock(mathtextblockblue);
		mathtextblockblue.setCreativeTab(Maw79Mod.mathsscratchblocks);
		registerBlock(mathtextblockpeach);
		mathtextblockpeach.setCreativeTab(Maw79Mod.mathsscratchblocks);
		registerBlock(mathtextblockwhite);
		mathtextblockwhite.setCreativeTab(Maw79Mod.mathsscratchblocks);
		
		
		registerBlock(mathtextblockblack);
		mathtextblockblack.setCreativeTab(Maw79Mod.mathsscratchblocks);
		registerBlock(mathtextblockgold);
		mathtextblockgold.setCreativeTab(Maw79Mod.mathsscratchblocks);
		registerBlock(mathtextblockorange);
		mathtextblockorange.setCreativeTab(Maw79Mod.mathsscratchblocks);
		registerBlock(mathtextblocklightorange);
		mathtextblocklightorange.setCreativeTab(Maw79Mod.mathsscratchblocks);
		registerBlock(mathtextblockmarrowbrown);
		mathtextblockmarrowbrown.setCreativeTab(Maw79Mod.mathsscratchblocks);
		registerBlock(mathtextblockgrey);
		mathtextblockgrey.setCreativeTab(Maw79Mod.mathsscratchblocks); 
		
		//Science Blocks
		registerBlock(testblockte);
		registerBlock(materialproperties);
		registerBlock(woodproperties);
		registerBlock(sciencewool, new ItemScienceWool(sciencewool));
		sciencewool.setCreativeTab(Maw79Mod.unused);
		registerBlock(labler);
		registerBlock(insulatormain);
		registerBlock(insulatorcalculator);
		//Science Insulators
		registerBlock(plasticblock);
		registerBlock(sciencewoolblock);
		registerBlock(polyurethanefoam);
		registerBlock(woodfelt);
		registerBlock(corkboard);
		registerBlock(copper);
		registerBlock(insulationwool);
		
		//History Blocks
		registerBlock(artifactresearcher);
		registerBlock(brightsandstone);

	}
	
	
	public static void registerBlock(Block block) {
		block.setCreativeTab(Maw79Mod.blocks);
		GameRegistry.register(block);
		GameRegistry.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
		Utils.getLogger().info("Registered Block: " + block.getUnlocalizedName().substring(5));
	}
	

	public static void registerBlock(Block block, ItemBlock itemBlock) {
		block.setCreativeTab(Maw79Mod.blocks);
		GameRegistry.register(block);
		GameRegistry.register(itemBlock.setRegistryName(block.getRegistryName()));
		Utils.getLogger().info("Registered Block: " + block.getUnlocalizedName().substring(5));
	}
	
	public static void registerRenders(){
		registerRender(storeblock);
		registerRender(bridge);
		registerRender(rubyblock);
		registerRender(obsidianingotblock);
		//registerRender(steelOre);
		registerRender(steelBlock);
		registerRender(gamemodeDetector);
		registerRender(steelSlabHalf);
		registerRender(steelStairs);
		registerRender(steelFence);
		registerRender(steelFenceGate);
		registerRender(steelButton);
		registerRender(steelPressurePlate);
		registerRender(testBlock);
		registerRender(testBlock2);
		registerRender(testBlock3);
		registerRender(testBlock4);
		registerRender(gravityPos);
		registerRender(gravityNeg);
		registerRender(jar);
		registerRender(customModel);
		registerRender(creative);
		registerRender(survival);
		registerRender(newtestblock);
		registerRender(profiler);
		
		//MATHS BLOCKS
		registerRender(mathblock1);
		registerRender(mathblock2);
		registerRender(mathsquestionblock);
		registerRender(mathsquestionblock2);
		registerRender(mathsquestionblock2);
		registerRender(mathsquizblock);
		registerRender(mathsdivisionblock);
		registerRender(mathsadditionblock);
		registerRender(mathssubtractionblock);
		
		//MATHS BLOCK Colours
		registerRender(mathblockbrown);
		registerRender(mathblockgreen);
		registerRender(mathblockaqua);
		registerRender(mathblockblue);
		registerRender(mathblockpeach);
		registerRender(mathblockwhite);
		
		registerRender(mathblockblack);
		registerRender(mathblockgold);
		registerRender(mathblockorange);
		registerRender(mathblocklightorange);
		registerRender(mathblockmarrowbrown);
		registerRender(mathblockgrey);
		
		
		//MATHS BLOCK Text
		registerRender(mathtextblockbrown);
		registerRender(mathtextblockgreen);
		registerRender(mathtextblockaqua);
		registerRender(mathtextblockblue);
		registerRender(mathtextblockpeach);
		registerRender(mathtextblockwhite);
		
		registerRender(mathtextblockblack);
		registerRender(mathtextblockgold);
		registerRender(mathtextblockorange);
		registerRender(mathtextblocklightorange);
		registerRender(mathtextblockmarrowbrown);
		registerRender(mathtextblockgrey);
		
		//Science Blocks
		registerRender(testblockte);
		registerRender(materialproperties);
		registerRender(woodproperties);
		registerRender(labler);
		registerRender(insulatormain);
		registerRender(insulatorcalculator);
		//Science Insulators
		registerRender(plasticblock);
		registerRender(polyurethanefoam);
		registerRender(woodfelt);
		registerRender(corkboard);
		registerRender(copper);
		registerRender(sciencewoolblock);
		registerRender(insulationwool);
		
		//History Blocks
		registerRender(artifactresearcher);
		registerRender(brightsandstone);
		//brightsandstone.setLightLevel(14.0f);
		
		for(int i = 0; i < EnumHandler.OreType.values().length; i++) {
			registerRender(steelOre, i, "steel_ore_" + EnumHandler.OreType.values()[i].getName());
			registerRender(artifactOre, i, "artifact_ore_" + EnumHandler.OreType.values()[i].getName());
		}
		
		for(int i=0; i < EnumHandler.ChipTypes.values().length; i++){
			registerRender(breaker, i, "block_breaker_" + EnumHandler.ChipTypes.values()[i].getName());
			registerRender(machineFrame, i, "machine_frame_" + EnumHandler.ChipTypes.values()[i].getName());
			registerRender(sciencewool, i, "science_wool_" + EnumHandler.ChipTypes.values()[i].getName());
			
		}
	}
	
	
	
	
	/**
	 * Registers the blocks renders
	 * @param block The block
	 */
	public static void registerRender(Block block) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(new ResourceLocation(Reference.MOD_ID, block.getUnlocalizedName().substring(5)), "inventory"));
		Utils.getLogger().info("Registered render for " + block.getUnlocalizedName().substring(5));
	}
	
	/**
	 * Registers the blocks renders even if it has meta data
	 * @param block The block
	 * @param meta The blocks meta data
	 * @param fileName The file name
	 */
	public static void registerRender(Block block, int meta, String fileName) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta, new ModelResourceLocation(new ResourceLocation(Reference.MOD_ID, fileName), "inventory"));
		Utils.getLogger().info("Registered render for " + block.getUnlocalizedName().substring(5));
	}
	
}
