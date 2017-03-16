package com.maw79.mods.main;

import java.util.ArrayList;
import java.util.Iterator;

import com.maw79.mods.client.gui.Overlay.GUIRenderEventClass;
import com.maw79.mods.commands.FlamingPigs;
import com.maw79.mods.creativetabs.Maw79BlocksTab;
import com.maw79.mods.creativetabs.Maw79DebugTab;
import com.maw79.mods.creativetabs.Maw79ItemsTab;
import com.maw79.mods.creativetabs.Maw79MathsBlocksTab;
import com.maw79.mods.entity.passive.mcreator_chris;
import com.maw79.mods.events.SoulStealerEvents;
import com.maw79.mods.handlers.AchievementHandler;
import com.maw79.mods.handlers.DropHandler;
import com.maw79.mods.handlers.FuelHandler;
import com.maw79.mods.handlers.ModEventHandler;
import com.maw79.mods.handlers.ModSoundHandler;
import com.maw79.mods.handlers.OreDictionaryHandler;
import com.maw79.mods.handlers.RecipeHandler;
import com.maw79.mods.init.ModArmour;
import com.maw79.mods.init.ModBlocks;
import com.maw79.mods.init.ModCrafting;
import com.maw79.mods.init.ModItems;
import com.maw79.mods.init.ModTools;
import com.maw79.mods.network.MathsMessage;
import com.maw79.mods.network.PacketHandler;
import com.maw79.mods.network.TeleportMessage;
import com.maw79.mods.network.mathsPacketHandler;
import com.maw79.mods.proxy.CommonProxy;
import com.maw79.mods.worldgen.OreGen;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION, acceptedMinecraftVersions = Reference.ACCEPTED_VERSION)

public class Maw79Mod {
	
	public static SimpleNetworkWrapper networkWrapper, networkWrapper2;

	
	public static final CreativeTabs blocks = new Maw79BlocksTab();
	public static final CreativeTabs debug = new Maw79DebugTab();
	public static final CreativeTabs items = new Maw79ItemsTab();
	public static final CreativeTabs mathsblocks = new Maw79MathsBlocksTab();
	
	public static Object instance2;
	public static int GUIID = 4;

	
	
	@Instance(Reference.MOD_ID)
	public static Maw79Mod instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	//EVENT HANDLERS

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		//Initialise Items
		ModItems.init();
		ModItems.register();
		
		//Initialise Blocks
		ModBlocks.init();
		ModBlocks.register();
		
		//Initialise Achievements
		AchievementHandler.registerAchievements();
		
		//Initialise Armour
		ModArmour.init();
		ModArmour.register();
		
		//Initialise Tools
		ModTools.init();
		ModTools.register();
		
		proxy.registerRenders();
		proxy.registerTileEntities();
		
		//ModEntities.registerEntities();
		
		 networkWrapper = NetworkRegistry.INSTANCE.newSimpleChannel("maw79");/* I recommend you to use your mod id, the channel name should be unique */
		 networkWrapper2 = NetworkRegistry.INSTANCE.newSimpleChannel("mathsMessage");
		 
		 networkWrapper.registerMessage(PacketHandler.class, TeleportMessage.class, 0, Side.SERVER); 
		 networkWrapper2.registerMessage(mathsPacketHandler.class, MathsMessage.class, 0, Side.SERVER); 
	
		 
	}

	@EventHandler
	public void Init(FMLInitializationEvent event)
	{
		
		OreDictionaryHandler.registerOreDictionary();
		proxy.init();
		proxy.registerModelBakeryStuff();
		ModCrafting.register();
		RecipeHandler.registerCraftingRecipes();
		GameRegistry.registerWorldGenerator(new OreGen(), 0);
		GameRegistry.registerFuelHandler(new FuelHandler());
		ModSoundHandler.init();
		
		//ModEntities.addSpawns();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		 MinecraftForge.EVENT_BUS.register(new ModEventHandler());
		MinecraftForge.EVENT_BUS.register(new GUIRenderEventClass());
		
		
	}

	

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		//other stuff
		MinecraftForge.EVENT_BUS.register(new DropHandler());
		MinecraftForge.EVENT_BUS.register(new SoulStealerEvents());
		
		
		
	}
	
	@EventHandler
	public void registerCommands(FMLServerStartingEvent event) {
		event.registerServerCommand(new FlamingPigs());
		
	}
	
	





}
