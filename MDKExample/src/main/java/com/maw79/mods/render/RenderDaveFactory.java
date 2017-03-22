package com.maw79.mods.render;

import com.maw79.mods.entity.models.ModelUselessDave;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerArrow;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderDaveFactory implements IRenderFactory<EntityMob>{
	
	public static final RenderDaveFactory INSTANCE = new RenderDaveFactory();
	

	@Override
	public Render<? super EntityMob> createRenderFor(RenderManager managerDave) {
		
		return new RenderEntityUselessDave(managerDave, new ModelUselessDave(), 1.0f);
		 
		
	}

}