package com.maw79.mods.render;

import com.maw79.mods.entity.models.ModelHuman;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityCreature;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderMummyFactory implements IRenderFactory<EntityCreature>{
	
	public static final RenderMummyFactory INSTANCE = new RenderMummyFactory();
	

	@Override
	public Render<? super EntityCreature> createRenderFor(RenderManager manager) {
		
		return new RenderEntityMummy(manager, new ModelHuman(), 1.0f);
		 
		
	}

}