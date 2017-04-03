package com.maw79.mods.init;

import com.maw79.mods.entity.arrows.EntityBlockDetectionArrow;
import com.maw79.mods.entity.arrows.EntityModArrow;
import com.maw79.mods.entity.arrows.EntityPaintArrow;
import com.maw79.mods.handlers.EnumHandler;
import com.maw79.mods.items.ItemBookOne;
import com.maw79.mods.items.ItemBurntLoaf;
import com.maw79.mods.items.ItemChip;
import com.maw79.mods.items.ItemCustomFuel;
import com.maw79.mods.items.ItemGameSwitcher;
import com.maw79.mods.items.ItemHeart;
import com.maw79.mods.items.ItemLightningSpawner;
import com.maw79.mods.items.ItemMathsBook;
import com.maw79.mods.items.ItemModArrow;
import com.maw79.mods.items.ItemModBow;
import com.maw79.mods.items.ItemMw;
import com.maw79.mods.items.ItemObsidianingot;
import com.maw79.mods.items.ItemReversePaintBrush;
import com.maw79.mods.items.ItemRuby;
import com.maw79.mods.items.ItemScoreDebug;
import com.maw79.mods.items.ItemSnowballLauncher;
import com.maw79.mods.items.ItemSteelIngot;
import com.maw79.mods.items.ItemTomato;
import com.maw79.mods.items.ItemTutorial;
import com.maw79.mods.items.ItemXAxisTool;
import com.maw79.mods.items.ItemYAxisTool;
import com.maw79.mods.items.ItemZAxisTool;
import com.maw79.mods.items.mathsitems.ItemAppleWall;
import com.maw79.mods.items.mathsitems.ItemAppleWallAxis;
import com.maw79.mods.items.mathsitems.ItemAppleWallBorder;
import com.maw79.mods.items.mathsitems.ItemAppleWallWool;
import com.maw79.mods.items.mathsitems.ItemCalculator;
import com.maw79.mods.items.mathsitems.ItemCompleteAppleWall;
import com.maw79.mods.items.mathsitems.ItemPictureWall;
import com.maw79.mods.items.mathsitems.ItemPlayerLevel;
import com.maw79.mods.items.mathsitems.ItemXyzDevice;
import com.maw79.mods.items.scienceitems.ItemElementFire;
import com.maw79.mods.items.scienceitems.ItemMagnet;
import com.maw79.mods.items.scienceitems.ItemPropertyLabel;
import com.maw79.mods.main.Maw79Mod;
import com.maw79.mods.main.Reference;
import com.maw79.mods.util.Utils;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {
	
	
	public static Item obsidianingot;
	public static Item ruby;
	public static Item mw;
	public static Item tomato;
	public static Item burntloaf;
	public static Item mouldyapple;
	public static Item heart;
	public static Item bolt;
	public static Item steelingot;
	public static Item chip;
	public static Item customfuel;
	public static Item firstbook;
	public static Item xaxistool;
	public static Item yaxistool;
	public static Item zaxistool;
	public static Item tutorialItem;
	public static Item reversepaintbrush;
	public static Item gameswitcher;
	public static Item stevepicturewall;
	public static Item applepicturewall;
	public static Item applepicturewallwool;
	public static Item completeapplepicturewall;
	public static Item xyzdevice;
	public static Item applepicturewallborder;
	public static Item applewallaxis;
	public static Item playerlevel;
	public static Item mathsbook;
	public static Item fireelement;
	public static Item magnet;
	
	
	
	//Projectiles
	public static final Item ARROW = new ItemModArrow("arrow", EntityModArrow::new);
	public static final ItemModArrow BLOCK_DETECTION_ARROW = new ItemModArrow("block_detection_arrow", EntityBlockDetectionArrow::new);
	public static final ItemModArrow PAINT_ARROW = new ItemModArrow("paint_arrow", EntityPaintArrow::new);
	public static final ItemModBow BOW = new ItemModBow("bow");
	public static ItemSnowballLauncher SNOW = new ItemSnowballLauncher("snow");
	
	//Science Labels
	public static final Item LABELSTRONG = new ItemPropertyLabel("label_strong");
	public static final Item LABELOPAQUE = new ItemPropertyLabel("label_opaque");
	public static final Item LABELCHAIR = new ItemPropertyLabel("label_chair");
	public static final Item LABELFLEXIBLE = new ItemPropertyLabel("label_flexible");
	public static final Item LABELDURABLE = new ItemPropertyLabel("label_durable");
	public static final Item LABELTOUGH = new ItemPropertyLabel("label_tough");
	
	public static ItemScoreDebug SCOREDEBUG = new ItemScoreDebug("scoredebug");
	public static ItemCalculator CALCULATOR = new ItemCalculator("calculator");
	
	
	
	//Tool Materials
	public static ToolMaterial obsidianMaterial = EnumHelper.addToolMaterial("obsidianingot", 2, 300, 5.0F, 2.0F, 12);
	//Tools
	public static ItemSword obsidian_sword;
	
	

	public static void init(){
		//Items
		obsidianingot = new ItemObsidianingot("itemobsidianingot");
		steelingot = new ItemSteelIngot("steelingot");
		ruby = new ItemRuby("itemruby");
		mw = new ItemMw("itemmw");
		heart = new ItemHeart("heart");
		bolt = new ItemLightningSpawner("bolt");
		chip = new ItemChip("chip");
		applepicturewall = new ItemAppleWall("apple_wall");
		applewallaxis = new ItemAppleWallAxis("apple_wall_axis");
		playerlevel = new ItemPlayerLevel("player_level");
		mathsbook = new ItemMathsBook("maths_book");
		
		//Food
		tomato = new ItemTomato("itemtomato");
		burntloaf = new ItemBurntLoaf("burntloaf");
		
		//Tools
		//obsidian_sword= new ItemObsidianSword(obsidianMaterial);
		customfuel = new ItemCustomFuel("customfuel");
		firstbook = new ItemBookOne("first_book");
		xaxistool = new ItemXAxisTool("x_axis_tool");
		yaxistool = new ItemYAxisTool("y_axis_tool");
		zaxistool = new ItemZAxisTool("z_axis_tool");
		xyzdevice = new ItemXyzDevice("xyz_device");
		
		
		tutorialItem = new ItemTutorial("tutorial_item");
		
		//Debug Items
		reversepaintbrush = new ItemReversePaintBrush("reverse_paint_brush");
		gameswitcher = new ItemGameSwitcher("game_switcher");
		stevepicturewall = new ItemPictureWall("picture_wall");
		
		applepicturewallwool = new ItemAppleWallWool("apple_wall_wool");
		applepicturewallborder = new ItemAppleWallBorder("apple_wall_border");
		completeapplepicturewall = new ItemCompleteAppleWall("complete_apple_wall");
		
		//Science Items
		fireelement = new ItemElementFire("fire_element");
		magnet = new ItemMagnet("magnet");
		
	
		
		
	}
	
	
	public static void register(){
		registerItem(SNOW);
		registerItem(BOW);
		registerItem(ARROW);
		registerItem(BLOCK_DETECTION_ARROW);
		registerItem(PAINT_ARROW);
		
		//SCIENCE LABELS
		registerItem(LABELSTRONG);
		registerItem(LABELOPAQUE);
		registerItem(LABELCHAIR);
		registerItem(LABELFLEXIBLE);
		registerItem(LABELDURABLE);
		registerItem(LABELTOUGH);
		
		registerItem(SCOREDEBUG);
		registerItem(CALCULATOR);
		
		//Items
		//GameRegistry.register(obsidianingot);
		registerItem(obsidianingot);
		registerItem(ruby);
		registerItem(mw);
		registerItem(heart);
		registerItem(bolt);
		registerItem(steelingot);
		registerItem(chip);
		registerItem(customfuel);
		registerItem(playerlevel);
		//Food
		registerItem(tomato);
		//registerItem(mouldyapple);
		registerItem(burntloaf);
		//Tools
		//registerItem(obsidian_sword);
		registerItem(tutorialItem);
		
		//MATHS ITEMS
		registerItem(firstbook);
		registerItem(xaxistool);
		registerItem(yaxistool);
		registerItem(zaxistool);
		registerItem(stevepicturewall);
		registerItem(applepicturewall);
		registerItem(xyzdevice);
		registerItem(applewallaxis);
		registerItem(mathsbook);
		
		//Debug Items
		registerItem(reversepaintbrush);
		registerItem(gameswitcher);
		registerItem(completeapplepicturewall);
		registerItem(applepicturewallwool);
		registerItem(applepicturewallborder);
		
		//Science Items
		registerItem(fireelement);
		registerItem(magnet);
	}
	
	
	public static void registerRenders(){
		//Items
		registerRender(obsidianingot);
		registerRender(ruby);
		registerRender(mw);
		registerRender(heart);
		registerRender(bolt);
		registerRender(steelingot);
		registerRender(customfuel);
		registerRender(firstbook);
		registerRender(xaxistool);
		registerRender(yaxistool);
		registerRender(zaxistool);
		registerRender(tutorialItem);
		registerRender(stevepicturewall);
		registerRender(applepicturewall);
		registerRender(applewallaxis);
		registerRender(playerlevel);
		registerRender(xyzdevice);
		registerRender(mathsbook);
		registerRender(BOW);
		registerRender(ARROW);
		registerRender(BLOCK_DETECTION_ARROW);
		registerRender(SNOW);
		registerRender(PAINT_ARROW);
		
		//SCIENCE LABELS
		registerRender(LABELCHAIR);
		registerRender(LABELOPAQUE);
		registerRender(LABELSTRONG);
		registerRender(LABELDURABLE);
		registerRender(LABELFLEXIBLE);
		registerRender(LABELTOUGH);
		
		registerRender(SCOREDEBUG);
		SCOREDEBUG.setCreativeTab(Maw79Mod.debug);
		
		registerRender(CALCULATOR);
	
		
		//Food
		registerRender(tomato);
		registerRender(burntloaf);
		
		//Debug Items
		registerRender(reversepaintbrush);
		reversepaintbrush.setCreativeTab(Maw79Mod.debug);
		registerRender(gameswitcher);
		gameswitcher.setCreativeTab(Maw79Mod.debug);
		registerRender(completeapplepicturewall);
		completeapplepicturewall.setCreativeTab(Maw79Mod.debug);
		registerRender(applepicturewall);
		applepicturewall.setCreativeTab(Maw79Mod.debug);
		registerRender(applepicturewallwool);
		applepicturewallwool.setCreativeTab(Maw79Mod.debug);
		registerRender(applepicturewallborder);
		applepicturewallborder.setCreativeTab(Maw79Mod.debug);
		
		//Science Items
		registerRender(fireelement);
		registerRender(magnet);
		
		
		//Meta Data
		for(int i = 0; i < EnumHandler.ChipTypes.values().length; i++) {
			registerRender(chip, i, "chip_" + EnumHandler.ChipTypes.values()[i].getName());
		}
	}
	
	public static void registerItem(Item item) {
		item.setCreativeTab(Maw79Mod.items); //Sets the creative tab
		GameRegistry.register(item);
		Utils.getLogger().info("Registered Item: " + item.getUnlocalizedName().substring(5));
	}
	
	
	
	/**
	 * Registers the item render MUST BE CALLED IN THE PRE INIT METHOD IN YOUR MAIN CLASS
	 * @param item The item
	 */
	public static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(new ResourceLocation(Reference.MOD_ID, item.getUnlocalizedName().substring(5)), "inventory"));
		Utils.getLogger().info("Registered render for " + item.getUnlocalizedName().substring(5));
	}
	
	/**
	 * Registers the item render for an item which has meta data
	 * @param item The item
	 * @param meta The meta data
	 * @param fileName The file name
	 */
	public static void registerRender(Item item, int meta, String fileName) {
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(new ResourceLocation(Reference.MOD_ID, fileName), "inventory"));
		Utils.getLogger().info("Registered render for " + item.getUnlocalizedName().substring(5));
	}
}
