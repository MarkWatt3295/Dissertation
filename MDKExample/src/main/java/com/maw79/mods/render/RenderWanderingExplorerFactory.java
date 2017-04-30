package com.maw79.mods.render;

import com.maw79.mods.entity.models.ModelHuman;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityCreature;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderWanderingExplorerFactory implements IRenderFactory<EntityCreature>{
	
	public static final RenderWanderingExplorerFactory INSTANCE = new RenderWanderingExplorerFactory();
	

	@Override
	public Render<? super EntityCreature> createRenderFor(RenderManager manager) {
		
		return new RenderWanderingExplorer(manager, new ModelHuman(), 1.0f);
		 
		
	}

}