package com.maw79.mods.proxy;

import com.maw79.mods.blocks.scienceblocks.insulatorblocks.TileEntityInsulator;
import com.maw79.mods.blocks.scienceblocks.insulatorblockscalculator.TileEntityInsulatorCalculator;
import com.maw79.mods.blocks.scienceblocks.tileentityscience.TileEntityScience;
import com.maw79.mods.blocks.tileentityattempt.TileEntityCustom2;
import com.maw79.mods.blocks.ItemProfiler.TileEntityProfiler;
import com.maw79.mods.blocks.historyblocks.artifactupdater.TileEntityArtifactResearcher;
import com.maw79.mods.main.Reference;
import com.maw79.mods.modattempts.blockvariants.BlockVariants;
import com.maw79.mods.modattempts.blockvariants.StartupCommon;
import com.maw79.mods.tileentity.TileEntityBlockBreaker;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {

	/**
	 * Called on the initialization phase of the game loading
	 */
	public void init() {
		//MOVED THESE TO MAIN CLASS - FIX FOR MC 1.11.2
	}
	
	/**
	 * Registers our tile entities
	 */
	public void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityBlockBreaker.class, Reference.MOD_ID + ":block_breaker");
		GameRegistry.registerTileEntity(TileEntityCustom2.class, Reference.MOD_ID + ":custom2");
		GameRegistry.registerTileEntity(TileEntityScience.class, Reference.MOD_ID + ":science_te");
		GameRegistry.registerTileEntity(TileEntityInsulator.class, Reference.MOD_ID + ":insulator_main");
		GameRegistry.registerTileEntity(TileEntityProfiler.class, Reference.MOD_ID + ":block_profiler");
		GameRegistry.registerTileEntity(TileEntityInsulatorCalculator.class, Reference.MOD_ID + ":insulator_calculator");
		GameRegistry.registerTileEntity(TileEntityArtifactResearcher.class, Reference.MOD_ID + ":artifactresearcher");
	}
	
	/**
	 * Registers the renders - refer to the {@link ClientProxy}
	 */
	public void registerRenders() {
		
	}
	
	public void registerModelBakeryStuff() {
		
	}

	public void preInit() {
		// TODO Auto-generated method stub
	}

	
}