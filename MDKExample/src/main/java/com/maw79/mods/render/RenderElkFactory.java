package com.maw79.mods.render;

import com.maw79.mods.entity.models.ModelElk;
import com.maw79.mods.entity.models.ModelUselessDave;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerArrow;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderElkFactory implements IRenderFactory<EntityAnimal>{
	
	public static final RenderElkFactory INSTANCE = new RenderElkFactory();
	

	@Override
	public Render<? super EntityAnimal> createRenderFor(RenderManager manager) {
		
		return new RenderEntityElk(manager, new ModelElk(), 1.0f);
		 
		
	}

}