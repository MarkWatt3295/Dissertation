package com.maw79.mods.render;

import com.maw79.mods.entity.models.ModelTourGuide;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityCreature;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderWanderingInfoRomanFactory implements IRenderFactory<EntityCreature>{
	
	public static final RenderWanderingInfoRomanFactory INSTANCE = new RenderWanderingInfoRomanFactory();
	
	@Override
	public Render<? super EntityCreature> createRenderFor(RenderManager manager) {
		
		return new RenderEntityWanderingInfoRoman(manager, new ModelTourGuide(), 1.0f);	
	}

}