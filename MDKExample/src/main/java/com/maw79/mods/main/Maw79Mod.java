package com.maw79.mods.main;

import com.maw79.mods.client.gui.Overlay.GUIRenderEventClass;
import com.maw79.mods.commands.FlamingPigs;
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
import com.maw79.mods.init.ModItems;
import com.maw79.mods.init.ModNumberBlocks;
import com.maw79.mods.init.ModTools;
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
import com.maw79.mods.proxy.CommonProxy;
import com.maw79.mods.worldgen.OreGen;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
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

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION, acceptedMinecraftVersions = Reference.ACCEPTED_VERSION)

public class Maw79Mod {
	
	public static SimpleNetworkWrapper networkWrapper, networkWrapper2, networkWrapper3, networkWrapper4, networkWrapper5,
	networkWrapper6, networkWrapper7, networkWrapper8;

	
	public static final CreativeTabs blocks = new Maw79BlocksTab();
	public static final CreativeTabs debug = new Maw79DebugTab();
	public static final CreativeTabs items = new Maw79ItemsTab();
	public static final CreativeTabs mathsblocks = new Maw79MathsBlocksTab();
	public static final CreativeTabs mathsscratchblocks = new Maw79ScratchBlocksTab();
	
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
		
		proxy.registerRenders();
		proxy.registerTileEntities();
		
		//ModEntities.registerEntities();
		
		 networkWrapper = NetworkRegistry.INSTANCE.newSimpleChannel("maw79");/* I recommend you to use your mod id, the channel name should be unique */
		 networkWrapper2 = NetworkRegistry.INSTANCE.newSimpleChannel("mathsMessage");
		 networkWrapper3 = NetworkRegistry.INSTANCE.newSimpleChannel("xmanagerMessage");
		 networkWrapper4 = NetworkRegistry.INSTANCE.newSimpleChannel("nxmanagerMessage");
		 networkWrapper5 = NetworkRegistry.INSTANCE.newSimpleChannel("yanagerMessage");
		 networkWrapper6 = NetworkRegistry.INSTANCE.newSimpleChannel("nymanagerMessage");
		 networkWrapper7 = NetworkRegistry.INSTANCE.newSimpleChannel("zmanagerMessage");
		 networkWrapper8 = NetworkRegistry.INSTANCE.newSimpleChannel("nzmanagerMessage");
		 
		 networkWrapper.registerMessage(PacketHandler.class, TeleportMessage.class, 0, Side.SERVER); 
		 networkWrapper2.registerMessage(mathsPacketHandler.class, MathsMessage.class, 0, Side.SERVER); 
		 networkWrapper3.registerMessage(XmanagerPacketHandler.class, XmanagerMessage.class, 0, Side.SERVER); 
		 networkWrapper4.registerMessage(NXmanagerPacketHandler.class, NXmanagerMessage.class, 0, Side.SERVER); 
		 networkWrapper5.registerMessage(YmanagerPacketHandler.class, YmanagerMessage.class, 0, Side.SERVER); 
		 networkWrapper6.registerMessage(NYmanagerPacketHandler.class, NYmanagerMessage.class, 0, Side.SERVER);
		 networkWrapper7.registerMessage(ZmanagerPacketHandler.class, ZmanagerMessage.class, 0, Side.SERVER); 
		 networkWrapper8.registerMessage(NZmanagerPacketHandler.class, NZmanagerMessage.class, 0, Side.SERVER);
	
		 
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
