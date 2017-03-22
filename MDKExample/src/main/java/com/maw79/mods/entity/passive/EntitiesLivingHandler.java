package com.maw79.mods.entity.passive;

import com.maw79.mods.entity.hostile.EntityUselessDave;
import com.maw79.mods.main.Maw79Mod;
import com.maw79.mods.main.Reference;
import com.maw79.mods.render.RenderBeetleFactory;
import com.maw79.mods.render.RenderDaveFactory;
import com.maw79.mods.render.RenderElkFactory;
import com.maw79.mods.render.RenderHumanFactory;
import com.maw79.mods.render.RenderTestFactory;
import com.maw79.mods.util.Utils;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntitiesLivingHandler {
	
	public static void registerEntity(){
		Utils.getLogger().info("EntitiesLivingHandler: registerEntity");
		
		createEntity(Test.class, "Test", 0xa62323, 0xed1515, 1);
		createHuman(Entityhuman.class, "Human", 789, 567, 3);
		createDave(EntityUselessDave.class, "Dave", 0xa62323, 0xed1515, 2);
		createElk(Elk.class, "Elk", 0x73388, 0x247480, 4);
		createBeetle(EntityBeetle.class, "Beetle", 0x1111, 0x12830, 5);
	}
	
	//public static void registerDave(){
		//createDave(EntityUselessDave.class, "Dave2", 0xa62323, 0xed1515, 3);
	//}
	
	private static void createEntity(Class entityClass, String entityName, int solidColor, int spotColor, int id){
		Utils.getLogger().info("EntitiesLivingHandler: createEntity");
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, entityName), entityClass, entityName, id, Maw79Mod.instance, 64, 1, true, solidColor, spotColor);
	}
	
	private static void createHuman(Class entityClass, String entityName, int solidColor, int spotColor, int id){
		Utils.getLogger().info("EntitiesLivingHandler: createHuman");
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, entityName), entityClass, entityName, id, Maw79Mod.instance, 64, 1, true, solidColor, spotColor);
	}
	
	private static void createDave(Class entityClass, String entityName, int solidColor, int spotColor, int id){
		Utils.getLogger().info("EntitiesLivingHandler: createDave");
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, entityName), entityClass, entityName, id, Maw79Mod.instance, 64, 1, true, solidColor, spotColor);
	}
	
	private static void createElk(Class entityClass, String entityName, int solidColor, int spotColor, int id){
		Utils.getLogger().info("EntitiesLivingHandler: createElk");
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, entityName), entityClass, entityName, id, Maw79Mod.instance, 64, 1, true, solidColor, spotColor);
	}
	
	private static void createBeetle(Class entityClass, String entityName, int solidColor, int spotColor, int id){
		Utils.getLogger().info("EntitiesLivingHandler: createBeetle");
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, entityName), entityClass, entityName, id, Maw79Mod.instance, 64, 1, true, solidColor, spotColor);
	}
	
	public static void registerAllModels(){
		Utils.getLogger().info("EntitiesLivingHandler: registerAllModels");
		
		registerMobModels();
	}
	
	private static void registerMobModels(){
		Utils.getLogger().info("EntitiesLivingHandler: registerMobModels");
		
		registerMobModel(Test.class, RenderTestFactory.INSTANCE);
		registerDave(EntityUselessDave.class, RenderDaveFactory.INSTANCE);
		registerHuman(Entityhuman.class, RenderHumanFactory.INSTANCE);
		registerElk(Elk.class, RenderElkFactory.INSTANCE);
		registerBeetle(EntityBeetle.class, RenderBeetleFactory.INSTANCE);
	}
	
	
	private static <T extends Entity> void registerMobModel(Class<T> entity, IRenderFactory<? super T> renderFactory)
	{
		Utils.getLogger().info("EntitiesLivingHandler: registerMobModel");
		
		RenderingRegistry.registerEntityRenderingHandler(entity, renderFactory);
		
	}
	
	private static <T extends EntityMob> void registerDave(Class<T> entity, IRenderFactory<? super T> renderFactory2)
	{
		Utils.getLogger().info("EntitiesLivingHandler: registerMobModel2");
		
		RenderingRegistry.registerEntityRenderingHandler(entity, renderFactory2);
	}
	
	private static <T extends EntityCreature> void registerHuman(Class<T> entity, IRenderFactory<? super T> renderFactory3)
	{
		Utils.getLogger().info("EntitiesLivingHandler: registerHuman");
		
		RenderingRegistry.registerEntityRenderingHandler(entity, renderFactory3);
	}
	
	private static <T extends EntityAnimal> void registerElk(Class<T> entity, IRenderFactory<? super T> renderFactory3)
	{
		Utils.getLogger().info("EntitiesLivingHandler: registerElk");
		
		RenderingRegistry.registerEntityRenderingHandler(entity, renderFactory3);
	}
	
	private static <T extends EntityCreature> void registerBeetle(Class<T> entity, IRenderFactory<? super T> renderFactory3)
	{
		Utils.getLogger().info("EntitiesLivingHandler: registerBeetle");
		
		RenderingRegistry.registerEntityRenderingHandler(entity, renderFactory3);
	}

}

