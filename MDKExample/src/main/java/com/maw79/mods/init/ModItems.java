package com.maw79.mods.init;

import com.maw79.mods.entity.arrows.EntityBlockDetectionArrow;
import com.maw79.mods.entity.arrows.EntityModArrow;
import com.maw79.mods.entity.arrows.EntityPaintArrow;
import com.maw79.mods.entity.arrows.EntityPaintRemoverArrow;
import com.maw79.mods.handlers.EnumHandler;
import com.maw79.mods.items.ItemBookOne;
import com.maw79.mods.items.ItemBooster;
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
import com.maw79.mods.items.historyitems.ItemArtifact;
import com.maw79.mods.items.historyitems.ItemHistoryBook;
import com.maw79.mods.items.mathsitems.ItemAppleWall;
import com.maw79.mods.items.mathsitems.ItemAppleWallAxis;
import com.maw79.mods.items.mathsitems.ItemAppleWallBorder;
import com.maw79.mods.items.mathsitems.ItemAppleWallWool;
import com.maw79.mods.items.mathsitems.ItemCalculator;
import com.maw79.mods.items.mathsitems.ItemCheatBook;
import com.maw79.mods.items.mathsitems.ItemCompleteAppleWall;
import com.maw79.mods.items.mathsitems.ItemEvenBook;
import com.maw79.mods.items.mathsitems.ItemFractionStamp;
import com.maw79.mods.items.mathsitems.ItemGameTypeSetter;
import com.maw79.mods.items.mathsitems.ItemNumberSequenceBook;
import com.maw79.mods.items.mathsitems.ItemOddBook;
import com.maw79.mods.items.mathsitems.ItemPictureWall;
import com.maw79.mods.items.mathsitems.ItemPlayerLevel;
import com.maw79.mods.items.mathsitems.ItemPrimeBook;
import com.maw79.mods.items.mathsitems.ItemXyzDevice;
import com.maw79.mods.items.scienceitems.ItemElementFire;
import com.maw79.mods.items.scienceitems.ItemMagnet;
import com.maw79.mods.items.scienceitems.ItemPropertyLabel;
import com.maw79.mods.items.teleporters.ItemEnglishToken;
import com.maw79.mods.items.teleporters.ItemFreePlayToken;
import com.maw79.mods.items.teleporters.ItemHistoryToken;
import com.maw79.mods.items.teleporters.ItemHubToken;
import com.maw79.mods.items.teleporters.ItemLevitationDust;
import com.maw79.mods.items.teleporters.ItemLevitationDust2;
import com.maw79.mods.items.teleporters.ItemLevitationDust3;
import com.maw79.mods.items.teleporters.ItemMathsToken;
import com.maw79.mods.items.teleporters.ItemScienceToken;
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
	
	//OTHER
	public static final Item BOOSTER = new ItemBooster("booster");
	public static final Item LEVITATION_DUST = new ItemLevitationDust("levitationdust");
	public static final Item LEVITATION_DUST2 = new ItemLevitationDust2("levitationdust2");
	public static final Item LEVITATION_DUST3 = new ItemLevitationDust3("levitationdust3");
	public static final Item NUMBER_SEQUENCE_BOOK = new ItemNumberSequenceBook("number_sequence_book");
	public static final Item PRIME_BOOK = new ItemPrimeBook("prime_book");
	public static final Item ODD_BOOK = new ItemOddBook("odd_book");
	public static final Item EVEN_BOOK = new ItemEvenBook("even_book");
	public static final Item CHEAT_BOOK = new ItemCheatBook("cheat_book");
	
	//TP Tokens
	public static final Item SCIENCE_TOKEN = new ItemScienceToken("science_token");
	public static final Item ENGLISH_TOKEN = new ItemEnglishToken("english_token");
	public static final Item MATHS_TOKEN = new ItemMathsToken("maths_token");
	public static final Item HISTORY_TOKEN = new ItemHistoryToken("history_token");
	public static final Item HUB_TOKEN = new ItemHubToken("hub_token");
	public static final Item FREEPLAY_TOKEN = new ItemFreePlayToken("freeplay_token");
	
	//Projectiles
	public static final Item ARROW = new ItemModArrow("arrow", EntityModArrow::new);
	public static final ItemModArrow BLOCK_DETECTION_ARROW = new ItemModArrow("block_detection_arrow", EntityBlockDetectionArrow::new);
	public static final ItemModArrow PAINT_ARROW = new ItemModArrow("paint_arrow", EntityPaintArrow::new);
	public static final ItemModArrow PAINTREMOVER_ARROW = new ItemModArrow("paintremover_arrow", EntityPaintRemoverArrow::new);
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
	public static ItemGameTypeSetter GAMETYPE = new ItemGameTypeSetter("gamesetter");
	
	//HISTORY ITEMS
	public static ItemArtifact ARTIFACT1 = new ItemArtifact("artifact1");
	public static ItemArtifact ARTIFACT2 = new ItemArtifact("artifact2");
	public static ItemHistoryBook HISTORYBOOK = new ItemHistoryBook("history_book");
	
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
		
		//HISTORY ITEMS
		registerItem(ARTIFACT1);
		registerItem(ARTIFACT2);
		registerItem(HISTORYBOOK);
		
		//Others
		registerItem(SNOW);
		SNOW.setCreativeTab(Maw79Mod.unused);
		registerItem(BOW);
		registerItem(ARROW);
		registerItem(BLOCK_DETECTION_ARROW);
		registerItem(PAINT_ARROW);
		registerItem(PAINTREMOVER_ARROW);
		registerItem(SCIENCE_TOKEN);
		registerItem(MATHS_TOKEN);
		registerItem(ENGLISH_TOKEN);
		registerItem(HISTORY_TOKEN);
		registerItem(HUB_TOKEN);
		registerItem(FREEPLAY_TOKEN);
		registerItem(BOOSTER);
		registerItem(LEVITATION_DUST);
		registerItem(LEVITATION_DUST2);
		registerItem(LEVITATION_DUST3);
		registerItem(CHEAT_BOOK);
		registerItem(GAMETYPE);
		GAMETYPE.setCreativeTab(Maw79Mod.debug);
		
		
	
		
		//SCIENCE LABELS
		registerItem(LABELSTRONG);
		registerItem(LABELOPAQUE);
		registerItem(LABELCHAIR);
		registerItem(LABELFLEXIBLE);
		registerItem(LABELDURABLE);
		registerItem(LABELTOUGH);
		
		registerItem(SCOREDEBUG);
		registerItem(CALCULATOR);
		CALCULATOR.setCreativeTab(Maw79Mod.unused);
		
		//Items
		registerItem(obsidianingot);
		registerItem(ruby);
		registerItem(mw);
		registerItem(heart);
		registerItem(bolt);
		registerItem(steelingot);
		registerItem(chip);
		chip.setCreativeTab(Maw79Mod.unused);
		registerItem(customfuel);
		registerItem(playerlevel);
		//Food
		registerItem(tomato);
		registerItem(burntloaf);
		registerItem(tutorialItem);
		tutorialItem.setCreativeTab(Maw79Mod.unused);
		
		//MATHS ITEMS
		registerItem(firstbook);
		registerItem(xaxistool);
		registerItem(yaxistool);
		registerItem(zaxistool);
		registerItem(stevepicturewall);
		registerItem(applepicturewall);
		registerItem(xyzdevice);
		xyzdevice.setCreativeTab(Maw79Mod.unused);
		registerItem(applewallaxis);
		registerItem(mathsbook);
		registerItem(NUMBER_SEQUENCE_BOOK);
		registerItem(EVEN_BOOK);
		registerItem(ODD_BOOK);
		registerItem(PRIME_BOOK);
		
		//Debug Items
		registerItem(reversepaintbrush);
		registerItem(gameswitcher);
		registerItem(completeapplepicturewall);
		registerItem(applepicturewallwool);
		registerItem(applepicturewallborder);
		
		//Science Items
		registerItem(fireelement);
		fireelement.setCreativeTab(Maw79Mod.unused);
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
		registerRender(PAINTREMOVER_ARROW);
		registerRender(SCIENCE_TOKEN);
		registerRender(MATHS_TOKEN);
		registerRender(HISTORY_TOKEN);
		registerRender(ENGLISH_TOKEN);
		registerRender(FREEPLAY_TOKEN);
		registerRender(HUB_TOKEN);
		registerRender(BOOSTER);
		registerRender(LEVITATION_DUST);
		registerRender(LEVITATION_DUST2);
		registerRender(LEVITATION_DUST3);
		registerRender(NUMBER_SEQUENCE_BOOK);
		registerRender(EVEN_BOOK);
		registerRender(ODD_BOOK);
		registerRender(PRIME_BOOK);
		registerRender(CHEAT_BOOK);
		registerRender(GAMETYPE);
		
		
		
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
	
		//HISTORY ITEMS
		registerRender(ARTIFACT1);
		registerRender(ARTIFACT2);
		registerRender(HISTORYBOOK);
		
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
