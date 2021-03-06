package com.maw79.mods.entity.passive;

import com.maw79.mods.entity.hostile.EntityUselessDave;
import com.maw79.mods.main.Maw79Mod;
import com.maw79.mods.main.Reference;
import com.maw79.mods.render.RenderBeetleFactory;
import com.maw79.mods.render.RenderDaveFactory;
import com.maw79.mods.render.RenderEgyptianFactory;
import com.maw79.mods.render.RenderElkFactory;
import com.maw79.mods.render.RenderEntityTokenShopkeeper;
import com.maw79.mods.render.RenderEntityTourGuide;
import com.maw79.mods.render.RenderEntityWanderingRoman;
import com.maw79.mods.render.RenderFarmerCoinsFactory;
import com.maw79.mods.render.RenderFarmerJoeFactory;
import com.maw79.mods.render.RenderHomerFactory;
import com.maw79.mods.render.RenderHumanFactory;
import com.maw79.mods.render.RenderMathsShopkeeperFactory;
import com.maw79.mods.render.RenderMummyFactory;
import com.maw79.mods.render.RenderNumberHunterFactory;
import com.maw79.mods.render.RenderRomanSteveFactory;
import com.maw79.mods.render.RenderScarecrowFactory;
import com.maw79.mods.render.RenderTestFactory;
import com.maw79.mods.render.RenderTokenShopkeeper;
import com.maw79.mods.render.RenderTourGuideFactory;
import com.maw79.mods.render.RenderWanderingExplorerFactory;
import com.maw79.mods.render.RenderWanderingInfoRomanFactory;
import com.maw79.mods.render.RenderWanderingRomanFactory;
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
		createDave(EntityUselessDave.class, "Dave", 0xa62323, 0xed1515, 2);
		createHuman(Entityhuman.class, "Human", 789, 567, 3);
		createElk(Elk.class, "Elk", 0x73388, 0x247480, 4);
		createBeetle(EntityBeetle.class, "Beetle", 0x1111, 0x12830, 5);
		createTourGuide(EntityTourGuide.class, "Tour Guide", 789, 567, 6);
		createShopkeeper(EntityTokenShopKeeper.class, "Shopkeeper", 439, 127, 7);
		createHomer(EntityHomer.class, "Homer", 439, 127, 8);
		createNumberHunter(EntityNumberHunter.class, "Number Hunter", 222, 555, 9);
		createMathsShopkeeper(EntityMathsShopKeeper.class, "Maths Shopkeeper", 888, 5559, 10);
		createFarmerJoe(EntityFarmerJoe.class, "Farmer Joe", 3288, 1689, 11);
		createScarecrow(EntityScarecrow.class, "Scarecrow", 555, 999, 12);
		createFarmerCoins(EntityFarmerCoins.class, "Farmer Coins", 0xa444, 0xed8215, 13);
		createRomanSteve(EntityRomanSteve.class, "Roman Steve", 0xff3245, 0xed2215, 14);
		createRomanGuide(EntityRomanGuide.class, "Roman Guide", 789, 567, 15);
		createWanderingRoman(EntityWanderingRoman.class, "Wandering Roman", 789, 567, 16);
		createWanderingInfoRoman(EntityWanderingInfoRoman.class, "Wandering Info Roman", 789, 567, 17);
		createWanderingExplorer(EntityWanderingExplorer.class, "Wandering Explorer", 4334, 1234, 18);
		createMummy(EntityMummy.class, "Mummy", 7829, 2567, 19);
		createEgyptian(EntityAncientEgyptian.class, "Egyptian", 7829, 2567, 20);
	}
	private static void createEgyptian(Class entityClass, String entityName, int solidColor, int spotColor, int id){
		Utils.getLogger().info("EntitiesLivingHandler: createMummy");
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, entityName), entityClass, entityName, id, Maw79Mod.instance, 64, 1, true, solidColor, spotColor);
	}
	private static void createMummy(Class entityClass, String entityName, int solidColor, int spotColor, int id){
		Utils.getLogger().info("EntitiesLivingHandler: createMummy");
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, entityName), entityClass, entityName, id, Maw79Mod.instance, 64, 1, true, solidColor, spotColor);
	}
	private static void createWanderingExplorer(Class entityClass, String entityName, int solidColor, int spotColor, int id){
		Utils.getLogger().info("EntitiesLivingHandler: createWanderingExplorer");
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, entityName), entityClass, entityName, id, Maw79Mod.instance, 64, 1, true, solidColor, spotColor);
	}
	private static void createWanderingInfoRoman(Class entityClass, String entityName, int solidColor, int spotColor, int id){
		Utils.getLogger().info("EntitiesLivingHandler: createWanderingInfoRoman");
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, entityName), entityClass, entityName, id, Maw79Mod.instance, 64, 1, true, solidColor, spotColor);
	}
	private static void createWanderingRoman(Class entityClass, String entityName, int solidColor, int spotColor, int id){
		Utils.getLogger().info("EntitiesLivingHandler: createWanderingRoman");
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, entityName), entityClass, entityName, id, Maw79Mod.instance, 64, 1, true, solidColor, spotColor);
	}
	private static void createRomanSteve(Class entityClass, String entityName, int solidColor, int spotColor, int id){
		Utils.getLogger().info("EntitiesLivingHandler: createRomanSteve");
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, entityName), entityClass, entityName, id, Maw79Mod.instance, 64, 1, true, solidColor, spotColor);
	}
	private static void createFarmerCoins(Class entityClass, String entityName, int solidColor, int spotColor, int id){
		Utils.getLogger().info("EntitiesLivingHandler: createFarmerCoins");
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, entityName), entityClass, entityName, id, Maw79Mod.instance, 64, 1, true, solidColor, spotColor);
	}
	private static void createScarecrow(Class entityClass, String entityName, int solidColor, int spotColor, int id){
		Utils.getLogger().info("EntitiesLivingHandler: createScarecrow");
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, entityName), entityClass, entityName, id, Maw79Mod.instance, 64, 1, true, solidColor, spotColor);
	}
	private static void createFarmerJoe(Class entityClass, String entityName, int solidColor, int spotColor, int id){
		Utils.getLogger().info("EntitiesLivingHandler: createFarmerJoe");
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, entityName), entityClass, entityName, id, Maw79Mod.instance, 64, 1, true, solidColor, spotColor);
	}
	private static void createHomer(Class entityClass, String entityName, int solidColor, int spotColor, int id){
		Utils.getLogger().info("EntitiesLivingHandler: createHomer");
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, entityName), entityClass, entityName, id, Maw79Mod.instance, 64, 1, true, solidColor, spotColor);
	}
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
	
	private static void createTourGuide(Class entityClass, String entityName, int solidColor, int spotColor, int id){
		Utils.getLogger().info("EntitiesLivingHandler: createTourGuide");
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, entityName), entityClass, entityName, id, Maw79Mod.instance, 64, 1, true, solidColor, spotColor);
	}
	private static void createRomanGuide(Class entityClass, String entityName, int solidColor, int spotColor, int id){
		Utils.getLogger().info("EntitiesLivingHandler: createTourGuide");
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, entityName), entityClass, entityName, id, Maw79Mod.instance, 64, 1, true, solidColor, spotColor);
	}
	private static void createShopkeeper(Class entityClass, String entityName, int solidColor, int spotColor, int id){
		Utils.getLogger().info("EntitiesLivingHandler: createShopkeeper");
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, entityName), entityClass, entityName, id, Maw79Mod.instance, 64, 1, true, solidColor, spotColor);
	}
	
	private static void createNumberHunter(Class entityClass, String entityName, int solidColor, int spotColor, int id){
		Utils.getLogger().info("EntitiesLivingHandler: createNumberHunter");
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, entityName), entityClass, entityName, id, Maw79Mod.instance, 64, 1, true, solidColor, spotColor);
	}
	private static void createMathsShopkeeper(Class entityClass, String entityName, int solidColor, int spotColor, int id){
		Utils.getLogger().info("EntitiesLivingHandler: createMathsShopkeeper");
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
		registerTourGuide(EntityTourGuide.class, RenderTourGuideFactory.INSTANCE);
		registerTourGuide(EntityRomanGuide.class, RenderTourGuideFactory.INSTANCE);
		registerShopkeeper(EntityTokenShopKeeper.class, RenderTokenShopkeeper.INSTANCE);
		registerHomer(EntityHomer.class, RenderHomerFactory.INSTANCE);
		registerNumberHunter(EntityNumberHunter.class, RenderNumberHunterFactory.INSTANCE);
		registerMathsShopkeeper(EntityMathsShopKeeper.class, RenderMathsShopkeeperFactory.INSTANCE);
		registerFarmerJoe(EntityFarmerJoe.class, RenderFarmerJoeFactory.INSTANCE);
		registerScarecrow(EntityScarecrow.class, RenderScarecrowFactory.INSTANCE);
		registerFarmerCoins(EntityFarmerCoins.class, RenderFarmerCoinsFactory.INSTANCE);
		registerRomanSteve(EntityRomanSteve.class, RenderRomanSteveFactory.INSTANCE);
		registerWanderingRoman(EntityWanderingRoman.class, RenderWanderingRomanFactory.INSTANCE);
		registerWanderingInfoRoman(EntityWanderingInfoRoman.class, RenderWanderingInfoRomanFactory.INSTANCE);
		registerWanderingExplorer(EntityWanderingExplorer.class, RenderWanderingExplorerFactory.INSTANCE);
		registerMummy(EntityMummy.class, RenderMummyFactory.INSTANCE);
		registerEgyptian(EntityAncientEgyptian.class, RenderEgyptianFactory.INSTANCE);
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
	
	private static <T extends EntityCreature> void registerTourGuide(Class<T> entity, IRenderFactory<? super T> renderFactory3)
	{
		Utils.getLogger().info("EntitiesLivingHandler: registerTourGuide");
		
		RenderingRegistry.registerEntityRenderingHandler(entity, renderFactory3);
	}
	private static <T extends EntityCreature> void registerRomanGuide(Class<T> entity, IRenderFactory<? super T> renderFactory3)
	{
		Utils.getLogger().info("EntitiesLivingHandler: registerTourGuide");
		
		RenderingRegistry.registerEntityRenderingHandler(entity, renderFactory3);
	}
	
	private static <T extends EntityCreature> void registerShopkeeper(Class<T> entity, IRenderFactory<? super T> renderFactory3)
	{
		Utils.getLogger().info("EntitiesLivingHandler: registerShopkeeper");
		
		RenderingRegistry.registerEntityRenderingHandler(entity, renderFactory3);
	}
	
	private static <T extends EntityCreature> void registerHomer(Class<T> entity, IRenderFactory<? super T> renderFactory3)
	{
		Utils.getLogger().info("EntitiesLivingHandler: registerHomer");
		
		RenderingRegistry.registerEntityRenderingHandler(entity, renderFactory3);
	}

	private static <T extends EntityCreature> void registerNumberHunter(Class<T> entity, IRenderFactory<? super T> renderFactory3)
	{
		Utils.getLogger().info("EntitiesLivingHandler: registerNumberHunter");
		
		RenderingRegistry.registerEntityRenderingHandler(entity, renderFactory3);
	}
	private static <T extends EntityCreature> void registerMathsShopkeeper(Class<T> entity, IRenderFactory<? super T> renderFactory3)
	{
		Utils.getLogger().info("EntitiesLivingHandler: registerMathsShopkeeper");
		
		RenderingRegistry.registerEntityRenderingHandler(entity, renderFactory3);
	}
	private static <T extends EntityCreature> void registerFarmerJoe(Class<T> entity, IRenderFactory<? super T> renderFactory3)
	{
		Utils.getLogger().info("EntitiesLivingHandler: registerFarmerJoe");
		
		RenderingRegistry.registerEntityRenderingHandler(entity, renderFactory3);
	}
	private static <T extends EntityCreature> void registerScarecrow(Class<T> entity, IRenderFactory<? super T> renderFactory3)
	{
		Utils.getLogger().info("EntitiesLivingHandler: registerScarecrow");
		
		RenderingRegistry.registerEntityRenderingHandler(entity, renderFactory3);
	}
	private static <T extends EntityCreature> void registerFarmerCoins(Class<T> entity, IRenderFactory<? super T> renderFactory3)
	{
		Utils.getLogger().info("EntitiesLivingHandler: registerFarmerCoins");
		
		RenderingRegistry.registerEntityRenderingHandler(entity, renderFactory3);
	}
	private static <T extends EntityCreature> void registerRomanSteve(Class<T> entity, IRenderFactory<? super T> renderFactory3)
	{
		Utils.getLogger().info("EntitiesLivingHandler: registerRomanSteve");
		
		RenderingRegistry.registerEntityRenderingHandler(entity, renderFactory3);
	}
	private static <T extends EntityCreature> void registerWanderingRoman(Class<T> entity, IRenderFactory<? super T> renderFactory3)
	{
		Utils.getLogger().info("EntitiesLivingHandler: registerWanderingRoman");
		
		RenderingRegistry.registerEntityRenderingHandler(entity, renderFactory3);
	}
	private static <T extends EntityCreature> void registerWanderingInfoRoman(Class<T> entity, IRenderFactory<? super T> renderFactory3)
	{
		Utils.getLogger().info("EntitiesLivingHandler: registerWanderingInfoRoman");
		
		RenderingRegistry.registerEntityRenderingHandler(entity, renderFactory3);
	}
	private static <T extends EntityCreature> void registerWanderingExplorer(Class<T> entity, IRenderFactory<? super T> renderFactory3)
	{
		Utils.getLogger().info("EntitiesLivingHandler: registerWanderingExplorer");
		
		RenderingRegistry.registerEntityRenderingHandler(entity, renderFactory3);
	}
	private static <T extends EntityCreature> void registerMummy(Class<T> entity, IRenderFactory<? super T> renderFactory3)
	{
		Utils.getLogger().info("EntitiesLivingHandler: registerMummy");
		
		RenderingRegistry.registerEntityRenderingHandler(entity, renderFactory3);
	}
	private static <T extends EntityCreature> void registerEgyptian(Class<T> entity, IRenderFactory<? super T> renderFactory3)
	{
		Utils.getLogger().info("EntitiesLivingHandler: registerEgyyptian");
		
		RenderingRegistry.registerEntityRenderingHandler(entity, renderFactory3);
	}
}

