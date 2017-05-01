package com.maw79.mods.render;

import com.maw79.mods.entity.models.ModelHuman;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityCreature;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderEgyptianFactory implements IRenderFactory<EntityCreature>{
	
	public static final RenderEgyptianFactory INSTANCE = new RenderEgyptianFactory();
	

	@Override
	public Render<? super EntityCreature> createRenderFor(RenderManager manager) {
		
		return new RenderEntityEgyptian(manager, new ModelHuman(), 1.0f);
		 
		
	}

}