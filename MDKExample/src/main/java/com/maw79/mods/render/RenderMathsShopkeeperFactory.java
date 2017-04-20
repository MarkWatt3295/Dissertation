package com.maw79.mods.render;

import com.maw79.mods.entity.models.ModelTourGuide;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityCreature;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderMathsShopkeeperFactory implements IRenderFactory<EntityCreature>{
	
	public static final RenderMathsShopkeeperFactory INSTANCE = new RenderMathsShopkeeperFactory();
	

	@Override
	public Render<? super EntityCreature> createRenderFor(RenderManager manager) {
		
		return new RenderEntityMathsShopkeeper(manager, new ModelTourGuide(), 1.0f);
		 
		
	}

}