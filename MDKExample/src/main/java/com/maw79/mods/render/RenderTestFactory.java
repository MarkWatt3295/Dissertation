package com.maw79.mods.render;

import com.maw79.mods.entity.passive.ModelTest;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import scala.xml.dtd.PublicID;

public class RenderTestFactory implements IRenderFactory<EntityTameable>{
	
	public static final RenderTestFactory INSTANCE = new RenderTestFactory();

	@Override
	public Render<? super EntityTameable> createRenderFor(RenderManager manager) {
		return new RenderEntityTest(manager, new ModelTest(), 1.0f);
	}

}