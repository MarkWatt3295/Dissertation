package com.maw79.mods.proxy;

import com.maw79.mods.client.gui.GuiHandler;
import com.maw79.mods.config.Maw79Config;
import com.maw79.mods.init.ModArmour;
import com.maw79.mods.init.ModBlocks;
import com.maw79.mods.init.ModItems;
import com.maw79.mods.init.ModNumberBlocks;
import com.maw79.mods.init.ModTools;
import com.maw79.mods.main.Maw79Mod;
import com.maw79.mods.main.Reference;

import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class ClientProxy extends CommonProxy {
	
	/**
	 * Everything that should be ran client side only in the pre initalization phase
	 */
	@Override
	public void preInit() {
		
		Maw79Config.clientPreInit();
	}

	@Override
	public void init() {
		NetworkRegistry.INSTANCE.registerGuiHandler(Maw79Mod.instance, new GuiHandler());
		
	}
	
	
	 @Override
	public void registerRenders() {
		ModItems.registerRenders();
		ModBlocks.registerRenders();
		ModNumberBlocks.registerRenders();
		ModArmour.registerRenders();
		ModTools.registerRenders();
	}

	
		@Override
		public void registerModelBakeryStuff() {
			ModelBakery.registerItemVariants(ModItems.chip, new ResourceLocation(Reference.MOD_ID, "chip_basic"), new ResourceLocation(Reference.MOD_ID, "chip_advanced"));
			ModelBakery.registerItemVariants(Item.getItemFromBlock(ModBlocks.breaker), new ResourceLocation(Reference.MOD_ID, "block_breaker_basic"), new ResourceLocation(Reference.MOD_ID, "block_breaker_advanced"));
			ModelBakery.registerItemVariants(Item.getItemFromBlock(ModBlocks.steelOre), new ResourceLocation(Reference.MOD_ID, "steel_ore_overworld"), new ResourceLocation(Reference.MOD_ID, "steel_ore_nether"), new ResourceLocation(Reference.MOD_ID, "steel_ore_end"));
			ModelBakery.registerItemVariants(Item.getItemFromBlock(ModBlocks.machineFrame), new ResourceLocation(Reference.MOD_ID, "machine_frame_basic"), new ResourceLocation(Reference.MOD_ID, "machine_frame_advanced"));
	}
	
	
	

}
