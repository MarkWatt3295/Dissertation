package com.maw79.mods.main;

import java.io.File;

import com.maw79.mods.client.gui.RenderGuiHandler;
import com.maw79.mods.commands.FlamingPigs;
import com.maw79.mods.commands.MawAdmin;
import com.maw79.mods.commands.MawStandard;
import com.maw79.mods.config.Maw79Config;
import com.maw79.mods.creativetabs.Maw79BlocksTab;
import com.maw79.mods.creativetabs.Maw79DebugTab;
import com.maw79.mods.creativetabs.Maw79HistoryItemsTab;
import com.maw79.mods.creativetabs.Maw79ItemsTab;
import com.maw79.mods.creativetabs.Maw79MathsBlocksTab;
import com.maw79.mods.creativetabs.Maw79ScratchBlocksTab;
import com.maw79.mods.creativetabs.Maw79UnusedTab;
import com.maw79.mods.events.SoulStealerEvents;
import com.maw79.mods.handlers.AchievementHandler;
import com.maw79.mods.handlers.DropHandler;
import com.maw79.mods.handlers.FuelHandler;
import com.maw79.mods.handlers.ModEventHandler;
import com.maw79.mods.handlers.ModSoundHandler;
import com.maw79.mods.handlers.OreDictionaryHandler;
import com.maw79.mods.handlers.RecipeHandler;
import com.maw79.mods.handlers.TickHandler;
import com.maw79.mods.init.ModArmour;
import com.maw79.mods.init.ModBlocks;
import com.maw79.mods.init.ModCrafting;
import com.maw79.mods.init.ModEntities;
import com.maw79.mods.init.ModFractionsBlocks;
import com.maw79.mods.init.ModItems;
import com.maw79.mods.init.ModNumberBlocks;
import com.maw79.mods.init.ModTools;
import com.maw79.mods.network.AdminCommandMessage;
import com.maw79.mods.network.AdminCommandPacketHandler;
import com.maw79.mods.network.FractionsManualMessage;
import com.maw79.mods.network.FractionsManualPacketHandler;
import com.maw79.mods.network.GuiInventoryMessage;
import com.maw79.mods.network.GuiInventoryPacketHandler;
import com.maw79.mods.network.MathsMessage;
import com.maw79.mods.network.MathsQuestManualMessage;
import com.maw79.mods.network.MathsQuestManualPacketHandler;
import com.maw79.mods.network.NXmanagerMessage;
import com.maw79.mods.network.NXmanagerPacketHandler;
import com.maw79.mods.network.NYmanagerMessage;
import com.maw79.mods.network.NYmanagerPacketHandler;
import com.maw79.mods.network.NZmanagerMessage;
import com.maw79.mods.network.NZmanagerPacketHandler;
import com.maw79.mods.network.PacketHandler;
import com.maw79.mods.network.PlayerPointsPlus20Message;
import com.maw79.mods.network.PlayerPointsPlus20PacketHandler;
import com.maw79.mods.network.RomanQuestMessage;
import com.maw79.mods.network.RomanQuestPacketHandler;
import com.maw79.mods.network.StandardCommandMessage;
import com.maw79.mods.network.StandardCommandPacketHandler;
import com.maw79.mods.network.TeleportMessage;
import com.maw79.mods.network.XmanagerMessage;
import com.maw79.mods.network.XmanagerPacketHandler;
import com.maw79.mods.network.YmanagerMessage;
import com.maw79.mods.network.YmanagerPacketHandler;
import com.maw79.mods.network.ZmanagerMessage;
import com.maw79.mods.network.ZmanagerPacketHandler;
import com.maw79.mods.network.mathsPacketHandler;
import com.maw79.mods.network.store.FarmerCoinsMessage;
import com.maw79.mods.network.store.FarmerCoinsPacketHandler;
import com.maw79.mods.network.store.MathsStore1Message;
import com.maw79.mods.network.store.MathsStore1PacketHandler;
import com.maw79.mods.network.store.RomanStoreMessage;
import com.maw79.mods.network.store.RomanStorePacketHandler;
import com.maw79.mods.network.store.ScarecrowSalesMessage;
import com.maw79.mods.network.store.ScarecrowSalesPacketHandler;
import com.maw79.mods.network.store.StoreItem1Message;
import com.maw79.mods.network.store.StoreItem1PacketHandler;
import com.maw79.mods.network.store.XYZMessage;
import com.maw79.mods.network.store.XYZPacketHandler;
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
	
	public static SimpleNetworkWrapper NETWORK;

	
	public static final CreativeTabs blocks = new Maw79BlocksTab();
	public static final CreativeTabs debug = new Maw79DebugTab();
	public static final CreativeTabs items = new Maw79ItemsTab();
	public static final CreativeTabs historyitems = new Maw79HistoryItemsTab();
	public static final CreativeTabs mathsblocks = new Maw79MathsBlocksTab();
	public static final CreativeTabs mathsscratchblocks = new Maw79ScratchBlocksTab();
	public static final CreativeTabs unused = new Maw79UnusedTab();
	
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
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
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
		ModFractionsBlocks.register();
		
		
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
		proxy.preInit();
		//ModEntities.registerEntities();
		
		
		 NETWORK = NetworkRegistry.INSTANCE.newSimpleChannel("maw79");
		 
		 NETWORK.registerMessage(PacketHandler.class, TeleportMessage.class, 0, Side.SERVER); 
		 NETWORK.registerMessage(mathsPacketHandler.class, MathsMessage.class, 1, Side.SERVER); 
		 NETWORK.registerMessage(XmanagerPacketHandler.class, XmanagerMessage.class, 2, Side.SERVER); 
		 NETWORK.registerMessage(NXmanagerPacketHandler.class, NXmanagerMessage.class, 3, Side.SERVER); 
		 NETWORK.registerMessage(YmanagerPacketHandler.class, YmanagerMessage.class, 4, Side.SERVER); 
		 NETWORK.registerMessage(NYmanagerPacketHandler.class, NYmanagerMessage.class, 5, Side.SERVER);
		 NETWORK.registerMessage(ZmanagerPacketHandler.class, ZmanagerMessage.class, 6, Side.SERVER); 
		 NETWORK.registerMessage(NZmanagerPacketHandler.class, NZmanagerMessage.class, 7, Side.SERVER);
		 NETWORK.registerMessage(StoreItem1PacketHandler.class, StoreItem1Message.class, 8, Side.SERVER);
		 NETWORK.registerMessage(GuiInventoryPacketHandler.class, GuiInventoryMessage.class, 9, Side.SERVER);
		 NETWORK.registerMessage(MathsQuestManualPacketHandler.class, MathsQuestManualMessage.class, 10, Side.SERVER);
		 NETWORK.registerMessage(AdminCommandPacketHandler.class, AdminCommandMessage.class, 11, Side.SERVER);
		 NETWORK.registerMessage(MathsStore1PacketHandler.class, MathsStore1Message.class, 12, Side.SERVER);
		 NETWORK.registerMessage(StandardCommandPacketHandler.class, StandardCommandMessage.class, 13, Side.SERVER);
		 NETWORK.registerMessage(PlayerPointsPlus20PacketHandler.class, PlayerPointsPlus20Message.class, 14, Side.SERVER);
		 NETWORK.registerMessage(ScarecrowSalesPacketHandler.class, ScarecrowSalesMessage.class, 15, Side.SERVER);
		 NETWORK.registerMessage(FractionsManualPacketHandler.class, FractionsManualMessage.class, 16, Side.SERVER);
		 NETWORK.registerMessage(FarmerCoinsPacketHandler.class, FarmerCoinsMessage.class, 17, Side.SERVER);
		 NETWORK.registerMessage(XYZPacketHandler.class, XYZMessage.class, 18, Side.SERVER);
		 NETWORK.registerMessage(RomanQuestPacketHandler.class, RomanQuestMessage.class, 19, Side.SERVER);
		 NETWORK.registerMessage(RomanStorePacketHandler.class, RomanStoreMessage.class, 20, Side.SERVER);
	
		 
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
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		MinecraftForge.EVENT_BUS.register(new ModEventHandler());
		MinecraftForge.EVENT_BUS.register(new RenderGuiHandler());
		MinecraftForge.EVENT_BUS.register(new TickHandler());
		

		
		
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
		event.registerServerCommand(new MawAdmin());
		event.registerServerCommand(new MawStandard());
		
	}
	
	





}
