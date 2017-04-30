package com.maw79.mods.render;

import com.maw79.mods.main.Reference;
import com.maw79.mods.util.Utils;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderWanderingExplorer extends RenderLiving{
	
	private static final ResourceLocation EntityHumanTextures = new ResourceLocation(Reference.MOD_ID + ":textures/entities/explorer.png");
		
	public RenderWanderingExplorer(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
		super(rendermanagerIn, modelbaseIn, shadowsizeIn);
	
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return EntityHumanTextures;
	}

}
