package com.maw79.mods.proxy;

import com.maw79.mods.blocks.scienceblocks.insulatorblocks.TileEntityInsulator;
import com.maw79.mods.blocks.scienceblocks.insulatorblockscalculator.TileEntityInsulatorCalculator;
import com.maw79.mods.blocks.scienceblocks.tileentityscience.TileEntityScience;
import com.maw79.mods.blocks.tileentityattempt.TileEntityCustom2;
import com.maw79.mods.client.gui.GuiHandler;
import com.maw79.mods.entity.passive.EntitiesLivingHandler;
import com.maw79.mods.blocks.ItemProfiler.TileEntityProfiler;
import com.maw79.mods.blocks.historyblocks.artifactupdater.TileEntityArtifactResearcher;
import com.maw79.mods.blocks.mathsblocks.questblock.TileEntityMathsQuest;
import com.maw79.mods.blocks.mathsblocks.recycler.TileEntityRecycler;
import com.maw79.mods.blocks.pointsblocks.TileEntityPointsBlock;
import com.maw79.mods.main.Maw79Mod;
import com.maw79.mods.main.Reference;
import com.maw79.mods.tileentity.TileEntityBlockBreaker;
import com.maw79.mods.tileentity.storetileentity.TileEntityStore;

import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {

	/**
	 * Called on the initialization phase of the game loading
	 */
	public void init() {
		NetworkRegistry.INSTANCE.registerGuiHandler(Maw79Mod.instance, new GuiHandler());
		EntitiesLivingHandler.registerEntity();
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
		GameRegistry.registerTileEntity(TileEntityStore.class, Reference.MOD_ID + ":store");
		GameRegistry.registerTileEntity(TileEntityMathsQuest.class, Reference.MOD_ID + ":maths_quest");
		GameRegistry.registerTileEntity(TileEntityRecycler.class, Reference.MOD_ID + ":maths_recycler");
		GameRegistry.registerTileEntity(TileEntityPointsBlock.class, Reference.MOD_ID + ":points_block");
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