package com.maw79.mods.main;

import java.io.File;

import com.maw79.mods.client.gui.RenderGuiHandler;
import com.maw79.mods.commands.FlamingPigs;
import com.maw79.mods.config.Maw79Config;
import com.maw79.mods.creativetabs.Maw79BlocksTab;
import com.maw79.mods.creativetabs.Maw79DebugTab;
import com.maw79.mods.creativetabs.Maw79ItemsTab;
import com.maw79.mods.creativetabs.Maw79MathsBlocksTab;
import com.maw79.mods.creativetabs.Maw79ScratchBlocksTab;
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
import com.maw79.mods.init.ModEntities;
import com.maw79.mods.init.ModItems;
import com.maw79.mods.init.ModNumberBlocks;
import com.maw79.mods.init.ModTools;
import com.maw79.mods.modattempts.blockvariants.StartupClientOnly;
import com.maw79.mods.modattempts.blockvariants.StartupCommon;
import com.maw79.mods.network.GuiInventoryMessage;
import com.maw79.mods.network.GuiInventoryPacketHandler;
import com.maw79.mods.network.MathsMessage;
import com.maw79.mods.network.NXmanagerMessage;
import com.maw79.mods.network.NXmanagerPacketHandler;
import com.maw79.mods.network.NYmanagerMessage;
import com.maw79.mods.network.NYmanagerPacketHandler;
import com.maw79.mods.network.NZmanagerMessage;
import com.maw79.mods.network.NZmanagerPacketHandler;
import com.maw79.mods.network.PacketHandler;
import com.maw79.mods.network.TeleportMessage;
import com.maw79.mods.network.XmanagerMessage;
import com.maw79.mods.network.XmanagerPacketHandler;
import com.maw79.mods.network.YmanagerMessage;
import com.maw79.mods.network.YmanagerPacketHandler;
import com.maw79.mods.network.ZmanagerMessage;
import com.maw79.mods.network.ZmanagerPacketHandler;
import com.maw79.mods.network.mathsPacketHandler;
import com.maw79.mods.network.store.StoreItem1Message;
import com.maw79.mods.network.store.StoreItem1PacketHandler;
import com.maw79.mods.proxy.CommonProxy;
import com.maw79.mods.worldgen.OreGen;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
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
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION, acceptedMinecraftVersions = Reference.ACCEPTED_VERSION, guiFactory = Reference.GUI_FACTORY)


public class Maw79Mod {
	
	public static SimpleNetworkWrapper networkWrapper, networkWrapper2, networkWrapper3, networkWrapper4, networkWrapper5,
	networkWrapper6, networkWrapper7, networkWrapper8, networkWrapper9;
	
	public static SimpleNetworkWrapper networkWrapperGuiInventory1;

	
	public static final CreativeTabs blocks = new Maw79BlocksTab();
	public static final CreativeTabs debug = new Maw79DebugTab();
	public static final CreativeTabs items = new Maw79ItemsTab();
	public static final CreativeTabs mathsblocks = new Maw79MathsBlocksTab();
	public static final CreativeTabs mathsscratchblocks = new Maw79ScratchBlocksTab();
	
	public static Object instance2;
	public static int GUIID = 4;
	
	public static int playerlevel = 1;
	public static Configuration config;

	
	
	@Instance(Reference.MOD_ID)
	public static Maw79Mod instance;
	
	
	
	/**
	 * Proxy so that we register the correct things on server and client side.
	 * Client side handles the model bakery
	 * Server side handles tile entities and world generation
	 */
	
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
		ModNumberBlocks.init();
		ModNumberBlocks.register();
		
		
		//Initialise Achievements
		AchievementHandler.registerAchievements();
		
		//Initialise Armour
		ModArmour.init();
		ModArmour.register();
		
		//Initialise Tools
		ModTools.init();
		ModTools.register();
		
		Maw79Config.preInit();
		proxy.registerRenders();
		proxy.registerTileEntities();
		StartupCommon.preInitCommon();
		//StartupClientOnly.preInitClientOnly();
		proxy.preInit();
		//ModEntities.registerEntities();
		
		
		 networkWrapper = NetworkRegistry.INSTANCE.newSimpleChannel("maw79");
		 networkWrapper2 = NetworkRegistry.INSTANCE.newSimpleChannel("mathsMessage");
		 networkWrapper3 = NetworkRegistry.INSTANCE.newSimpleChannel("xmanagerMessage");
		 networkWrapper4 = NetworkRegistry.INSTANCE.newSimpleChannel("nxmanagerMessage");
		 networkWrapper5 = NetworkRegistry.INSTANCE.newSimpleChannel("yanagerMessage");
		 networkWrapper6 = NetworkRegistry.INSTANCE.newSimpleChannel("nymanagerMessage");
		 networkWrapper7 = NetworkRegistry.INSTANCE.newSimpleChannel("zmanagerMessage");
		 networkWrapper8 = NetworkRegistry.INSTANCE.newSimpleChannel("nzmanagerMessage");
		 networkWrapper9 = NetworkRegistry.INSTANCE.newSimpleChannel("storemessage");
		 
		 networkWrapper.registerMessage(PacketHandler.class, TeleportMessage.class, 0, Side.SERVER); 
		 networkWrapper2.registerMessage(mathsPacketHandler.class, MathsMessage.class, 0, Side.SERVER); 
		 networkWrapper3.registerMessage(XmanagerPacketHandler.class, XmanagerMessage.class, 0, Side.SERVER); 
		 networkWrapper4.registerMessage(NXmanagerPacketHandler.class, NXmanagerMessage.class, 0, Side.SERVER); 
		 networkWrapper5.registerMessage(YmanagerPacketHandler.class, YmanagerMessage.class, 0, Side.SERVER); 
		 networkWrapper6.registerMessage(NYmanagerPacketHandler.class, NYmanagerMessage.class, 0, Side.SERVER);
		 networkWrapper7.registerMessage(ZmanagerPacketHandler.class, ZmanagerMessage.class, 0, Side.SERVER); 
		 networkWrapper8.registerMessage(NZmanagerPacketHandler.class, NZmanagerMessage.class, 0, Side.SERVER);
		 networkWrapper9.registerMessage(StoreItem1PacketHandler.class, StoreItem1Message.class, 0, Side.SERVER);
		 
		 networkWrapperGuiInventory1 = NetworkRegistry.INSTANCE.newSimpleChannel("guiinventorymanagermessage");
		 
		 networkWrapperGuiInventory1.registerMessage(GuiInventoryPacketHandler.class, GuiInventoryMessage.class, 0, Side.SERVER);
	
		 
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
		//MinecraftForge.EVENT_BUS.register(new Overlay());
		MinecraftForge.EVENT_BUS.register(new RenderGuiHandler());
		

		
		
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
