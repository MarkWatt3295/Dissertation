package com.maw79.mods.proxy;

import com.maw79.mods.main.Reference;
import com.maw79.mods.tileentity.TileEntityBlockBreaker;
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