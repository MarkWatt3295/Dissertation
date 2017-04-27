package com.maw79.mods.render;

import com.maw79.mods.entity.models.ModelHuman;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityCreature;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderRomanSteveFactory implements IRenderFactory<EntityCreature>{
	
	public static final RenderRomanSteveFactory INSTANCE = new RenderRomanSteveFactory();
	

	@Override
	public Render<? super EntityCreature> createRenderFor(RenderManager manager) {
		
		return new RenderRomanSteve(manager, new ModelHuman(), 1.0f);
		 
		
	}

}