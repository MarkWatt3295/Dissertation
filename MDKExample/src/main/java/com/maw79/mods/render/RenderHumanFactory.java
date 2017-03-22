package com.maw79.mods.render;

import com.maw79.mods.entity.models.ModelEntityDrek;
import com.maw79.mods.entity.models.ModelHuman;
import com.maw79.mods.entity.models.ModelTest;
import com.maw79.mods.entity.models.ModelUselessDave;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerArrow;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.monster.EntityMob;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderHumanFactory implements IRenderFactory<EntityCreature>{
	
	public static final RenderHumanFactory INSTANCE = new RenderHumanFactory();
	

	@Override
	public Render<? super EntityCreature> createRenderFor(RenderManager manager) {
		
		return new RenderEntityHuman(manager, new ModelHuman(), 1.0f);
		 
		
	}

}