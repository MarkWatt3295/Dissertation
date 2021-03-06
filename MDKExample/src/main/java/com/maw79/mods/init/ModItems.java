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
import com.maw79.mods.items.ItemJumpBooster;
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
import com.maw79.mods.items.historyitems.ItemAmulet;
import com.maw79.mods.items.historyitems.ItemAnkh;
import com.maw79.mods.items.historyitems.ItemArtifact;
import com.maw79.mods.items.historyitems.ItemBuilderCoin;
import com.maw79.mods.items.historyitems.ItemBuilderCoinDebug;
import com.maw79.mods.items.historyitems.ItemCanopicJar;
import com.maw79.mods.items.historyitems.ItemEgyptArtifactsManual;
import com.maw79.mods.items.historyitems.ItemEgyptQuestDebug;
import com.maw79.mods.items.historyitems.ItemFalseDoor;
import com.maw79.mods.items.historyitems.ItemFragment;
import com.maw79.mods.items.historyitems.ItemFuneraryCone;
import com.maw79.mods.items.historyitems.ItemHistoryBook;
import com.maw79.mods.items.historyitems.ItemMummy;
import com.maw79.mods.items.historyitems.ItemPapyrus;
import com.maw79.mods.items.historyitems.ItemPharoh;
import com.maw79.mods.items.historyitems.ItemPyramidionStone;
import com.maw79.mods.items.historyitems.ItemRomanArtifactsManual;
import com.maw79.mods.items.historyitems.ItemSarcophagus;
import com.maw79.mods.items.historyitems.ItemScarab;
import com.maw79.mods.items.historyitems.ItemSenet;
import com.maw79.mods.items.historyitems.ItemSphinx;
import com.maw79.mods.items.mathsitems.ItemAppleWall;
import com.maw79.mods.items.mathsitems.ItemAppleWallAxis;
import com.maw79.mods.items.mathsitems.ItemAppleWallBorder;
import com.maw79.mods.items.mathsitems.ItemAppleWallWool;
import com.maw79.mods.items.mathsitems.ItemBasic;
import com.maw79.mods.items.mathsitems.ItemCalculator;
import com.maw79.mods.items.mathsitems.ItemCheatBook;
import com.maw79.mods.items.mathsitems.ItemCompleteAppleWall;
import com.maw79.mods.items.mathsitems.ItemCoordinatesManual;
import com.maw79.mods.items.mathsitems.ItemDomusBuilderBook;
import com.maw79.mods.items.mathsitems.ItemEvenBook;
import com.maw79.mods.items.mathsitems.ItemFractionStamp;
import com.maw79.mods.items.mathsitems.ItemFractionsBook;
import com.maw79.mods.items.mathsitems.ItemGameTypeSetter;
import com.maw79.mods.items.mathsitems.ItemNumberSequenceBook;
import com.maw79.mods.items.mathsitems.ItemOddBook;
import com.maw79.mods.items.mathsitems.ItemPictureWall;
import com.maw79.mods.items.mathsitems.ItemPlayerLevel;
import com.maw79.mods.items.mathsitems.ItemPrimeBook;
import com.maw79.mods.items.mathsitems.ItemXyzDevice;
import com.maw79.mods.items.scienceitems.ItemElementFire;
import com.maw79.mods.items.scienceitems.ItemGravityBooster;
import com.maw79.mods.items.scienceitems.ItemMagnet;
import com.maw79.mods.items.scienceitems.ItemNegativeMagnet;
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
	public static final Item GRAVITYBOOSTER = new ItemGravityBooster("gravity_booster");
	public static final Item LEVITATION_DUST = new ItemLevitationDust("levitationdust");
	public static final Item LEVITATION_DUST2 = new ItemLevitationDust2("levitationdust2");
	public static final Item LEVITATION_DUST3 = new ItemLevitationDust3("levitationdust3");
	public static final Item NUMBER_SEQUENCE_BOOK = new ItemNumberSequenceBook("number_sequence_book");
	public static final Item PRIME_BOOK = new ItemPrimeBook("prime_book");
	public static final Item ODD_BOOK = new ItemOddBook("odd_book");
	public static final Item EVEN_BOOK = new ItemEvenBook("even_book");
	public static final Item CHEAT_BOOK = new ItemCheatBook("cheat_book");
	public static final Item FRACTIONS_BOOK = new ItemFractionsBook("fractions_book");
	public static final Item COORDINATES_MANUAL = new ItemCoordinatesManual("coordinates_quest_manual");
	public static final Item NEGATIVE_MAGNET = new ItemNegativeMagnet("negative_magnet");
	
	public static final Item COORDINATES_QUEST_ITEM_1 = new ItemBasic("coordinates_quest_item_1");
	public static final Item COORDINATES_QUEST_ITEM_2 = new ItemBasic("coordinates_quest_item_2");
	public static final Item COORDINATES_QUEST_ITEM_3 = new ItemBasic("coordinates_quest_item_3");
	public static final Item COORDINATES_QUEST_ITEM_4 = new ItemBasic("coordinates_quest_item_4");
	public static final Item COORDINATES_QUEST_ITEM_5 = new ItemBasic("coordinates_quest_item_5");
	public static final Item COORDINATES_QUEST_ITEM_6 = new ItemBasic("coordinates_quest_item_6");
	public static final Item COORDINATES_QUEST_ITEM_7 = new ItemBasic("coordinates_quest_item_7");
	public static final Item COORDINATES_QUEST_ITEM_8 = new ItemBasic("coordinates_quest_item_8");
	
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
	
	public static final Item LABELFERROUS = new ItemPropertyLabel("label_ferrous");
	public static final Item LABELNONFERROUS = new ItemPropertyLabel("label_nonferrous");
	public static final Item LABELMAGNETIC = new ItemPropertyLabel("label_magnetic");
	public static final Item LABELLUSTROUS = new ItemPropertyLabel("label_lustrous");
	public static final Item LABELHIGHDENSITY = new ItemPropertyLabel("label_high_density");
	
	public static final Item LABELFRAGILE = new ItemPropertyLabel("label_fragile");
	public static final Item LABELTRANSPARENT = new ItemPropertyLabel("label_transparent");
	public static final Item LABELSPECTACLES = new ItemPropertyLabel("label_spectacles");
	public static final Item LABELWINDOWS = new ItemPropertyLabel("label_windows");
	
	public static final Item LABELBAGS= new ItemPropertyLabel("label_bags");
	public static final Item LABELWATERPROOF = new ItemPropertyLabel("label_waterproof");
	public static final Item LABELTOXICITY = new ItemPropertyLabel("label_toxicity");
	public static final Item LABELACRYLIC = new ItemPropertyLabel("label_acrylic");
	public static final Item LABELPVC = new ItemPropertyLabel("label_pvc");
	public static final Item LABELCELLOPHANE = new ItemPropertyLabel("label_cellophane");
	public static final Item LABELPOLYTHENE = new ItemPropertyLabel("label_polythene");
	
	public static final Item LABELANTISTATIC = new ItemPropertyLabel("label_antistatic");
	public static final Item LABELPOTTERY = new ItemPropertyLabel("label_pottery");
	public static final Item LABELMUGS = new ItemPropertyLabel("label_mugs");
	
	
	public static ItemScoreDebug SCOREDEBUG = new ItemScoreDebug("scoredebug");
	public static ItemCalculator CALCULATOR = new ItemCalculator("calculator");
	public static ItemGameTypeSetter GAMETYPE = new ItemGameTypeSetter("gamesetter");
	
	//HISTORY ITEMS
	public static ItemArtifact ARTIFACT1 = new ItemArtifact("artifact1");
	public static ItemArtifact ARTIFACT2 = new ItemArtifact("artifact2");
	public static ItemArtifact ARTIFACT3 = new ItemArtifact("artifact3");
	public static ItemArtifact ARTIFACT4 = new ItemArtifact("artifact4");
	public static ItemArtifact ARTIFACT5 = new ItemArtifact("artifact5");
	public static ItemArtifact ARTIFACT6 = new ItemArtifact("artifact6");
	public static ItemArtifact ARTIFACT7 = new ItemArtifact("artifact7");
	public static ItemArtifact ARTIFACT8 = new ItemArtifact("artifact8");
	public static ItemArtifact ARTIFACT9 = new ItemArtifact("artifact9");
	public static ItemArtifact ARTIFACT10 = new ItemArtifact("artifact10");
	public static ItemArtifact ARTIFACT11= new ItemArtifact("artifact11");
	public static ItemArtifact ARTIFACT12 = new ItemArtifact("artifact12");
	public static ItemArtifact ARTIFACT13 = new ItemArtifact("artifact13");
	public static ItemArtifact ARTIFACT14 = new ItemArtifact("artifact14");
	public static ItemArtifact ARTIFACT15 = new ItemArtifact("artifact15");
	public static ItemArtifact ARTIFACT16 = new ItemArtifact("artifact16");
	public static ItemArtifact ARTIFACT17 = new ItemArtifact("artifact17");
	public static ItemArtifact ARTIFACT18 = new ItemArtifact("artifact18");
	public static ItemArtifact ARTIFACT19 = new ItemArtifact("artifact19");
	public static ItemArtifact ARTIFACT20 = new ItemArtifact("artifact20");
	public static ItemArtifact ARTIFACT21 = new ItemArtifact("artifact21");
	public static ItemPharoh PHAROH = new ItemPharoh("pharoh");
	public static ItemEgyptArtifactsManual EGYPT_MANUAL = new ItemEgyptArtifactsManual("egyptmanual");
	public static ItemFragment FRAGMENT1 = new ItemFragment("fragment1");
	public static ItemFragment FRAGMENT2 = new ItemFragment("fragment2");
	public static ItemFragment FRAGMENT3 = new ItemFragment("fragment3");
	public static ItemFragment FRAGMENT4 = new ItemFragment("fragment4");
	public static ItemFragment FRAGMENT5 = new ItemFragment("fragment5");
	public static ItemFragment FRAGMENT6 = new ItemFragment("fragment6");
	public static ItemFragment FRAGMENT7 = new ItemFragment("fragment7");
	public static ItemFragment FRAGMENT8 = new ItemFragment("fragment8");
	public static ItemFragment FRAGMENT9 = new ItemFragment("fragment9");
	
	public static ItemAmulet ARTIFACT_AMULET = new ItemAmulet("artifact_amulet");
	public static ItemAnkh ARTIFACT_ANKH = new ItemAnkh("artifact_ankh");
	public static ItemPyramidionStone ARTIFACT_PYRAMIDION = new ItemPyramidionStone("artifact_pyramidion");
	public static ItemCanopicJar ARTIFACT_CANOPIC_JAR = new ItemCanopicJar("artifact_canopic_jar");
	public static ItemPapyrus ARTIFACT_PAPYRUS = new ItemPapyrus("artifact_papyrus");
	public static ItemScarab ARTIFACT_SCARAB = new ItemScarab("artifact_scarab");
	public static ItemSarcophagus ARTIFACT_SARCOPHAGUS = new ItemSarcophagus("artifact_sarcophagus");
	public static ItemSenet ARTIFACT_SENET = new ItemSenet("artifact_senet");
	public static ItemSphinx ARTIFACT_SPHINX = new ItemSphinx("artifact_sphinx");
	public static ItemFalseDoor ARTIFACT_FALSEDOOR = new ItemFalseDoor("artifact_falsedoor");
	public static ItemFuneraryCone ARTIFACT_FUNERARY = new ItemFuneraryCone("artifact_funerary");
	public static ItemMummy ARTIFACT_MUMMY = new ItemMummy("artifact_mummy");
	
	
	public static ItemEgyptQuestDebug QUEST_DEBUG = new ItemEgyptQuestDebug("egypt_quest_debug");
	
	public static ItemHistoryBook HISTORYBOOK = new ItemHistoryBook("history_book");
	public static ItemBuilderCoin BUILDER_COIN = new ItemBuilderCoin("builders_coin");
	public static ItemBuilderCoinDebug BUILDER_COIN_DEBUG = new ItemBuilderCoinDebug("builders_coin_debug");
	public static ItemDomusBuilderBook DOMUS_BUILDER = new ItemDomusBuilderBook("domus_builder");
	public static ItemArtifact ROMAN_ARTIFACT1 = new ItemArtifact("roman_artifact1");
	public static ItemArtifact ROMAN_ARTIFACT2 = new ItemArtifact("roman_artifact2");
	public static ItemArtifact ROMAN_ARTIFACT3 = new ItemArtifact("roman_artifact3");
	public static ItemArtifact ROMAN_ARTIFACT4 = new ItemArtifact("roman_artifact4");
	public static ItemArtifact ROMAN_ARTIFACT5 = new ItemArtifact("roman_artifact5");
	public static ItemArtifact ROMAN_ARTIFACT6 = new ItemArtifact("roman_artifact6");
	public static ItemArtifact ROMAN_ARTIFACT7 = new ItemArtifact("roman_artifact7");
	public static ItemArtifact ROMAN_ARTIFACT8 = new ItemArtifact("roman_artifact8");
	public static ItemArtifact ROMAN_ARTIFACT9 = new ItemArtifact("roman_artifact9");
	public static ItemArtifact ROMAN_ARTIFACT10 = new ItemArtifact("roman_artifact10");
	public static ItemArtifact ROMAN_ARTIFACT_DEBUG = new ItemArtifact("roman_artifact_debug");
	public static ItemJumpBooster JUMP_BOOSTER = new ItemJumpBooster("jump_booster");
	public static ItemRomanArtifactsManual ROMAN_ARTIFACTS_MANUAL = new ItemRomanArtifactsManual("roman_artifacts_manual");
	
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
		registerItem(ARTIFACT3);
		registerItem(ARTIFACT4);
		registerItem(ARTIFACT5);
		registerItem(ARTIFACT6);
		registerItem(ARTIFACT7);
		registerItem(ARTIFACT8);
		registerItem(ARTIFACT9);
		registerItem(ARTIFACT10);
		registerItem(ARTIFACT11);
		registerItem(ARTIFACT12);
		registerItem(ARTIFACT13);
		registerItem(ARTIFACT14);
		registerItem(ARTIFACT15);
		registerItem(ARTIFACT16);
		registerItem(ARTIFACT17);
		registerItem(ARTIFACT18);
		registerItem(ARTIFACT19);
		registerItem(ARTIFACT20);
		registerItem(ARTIFACT21);
		registerItem(PHAROH);
		registerItem(QUEST_DEBUG);
		registerItem(EGYPT_MANUAL);
		
		registerItem(FRAGMENT1);
		registerItem(FRAGMENT2);
		registerItem(FRAGMENT3);
		registerItem(FRAGMENT4);
		registerItem(FRAGMENT5);
		registerItem(FRAGMENT6);
		registerItem(FRAGMENT7);
		registerItem(FRAGMENT8);
		registerItem(FRAGMENT9);
		
		registerItem(ARTIFACT_AMULET);
		registerItem(ARTIFACT_ANKH);
		registerItem(ARTIFACT_PYRAMIDION);
		registerItem(ARTIFACT_CANOPIC_JAR);
		registerItem(ARTIFACT_PAPYRUS);
		registerItem(ARTIFACT_SCARAB);
		registerItem(ARTIFACT_SARCOPHAGUS);
		registerItem(ARTIFACT_SENET);
		registerItem(ARTIFACT_SPHINX);
		registerItem(ARTIFACT_FALSEDOOR);
		registerItem(ARTIFACT_FUNERARY);
		registerItem(ARTIFACT_MUMMY);
		
		registerItem(HISTORYBOOK);
		registerItem(BUILDER_COIN);
		registerItem(BUILDER_COIN_DEBUG);
		registerItem(DOMUS_BUILDER);
		registerItem(ROMAN_ARTIFACT1);
		registerItem(ROMAN_ARTIFACT2);
		registerItem(ROMAN_ARTIFACT3);
		registerItem(ROMAN_ARTIFACT4);
		registerItem(ROMAN_ARTIFACT5);
		registerItem(ROMAN_ARTIFACT6);
		registerItem(ROMAN_ARTIFACT7);
		registerItem(ROMAN_ARTIFACT8);
		registerItem(ROMAN_ARTIFACT9);
		registerItem(ROMAN_ARTIFACT10);
		registerItem(ROMAN_ARTIFACT_DEBUG);
		registerItem(JUMP_BOOSTER);
		
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
		registerItem(GRAVITYBOOSTER);
		registerItem(LEVITATION_DUST);
		registerItem(LEVITATION_DUST2);
		registerItem(LEVITATION_DUST3);
		registerItem(CHEAT_BOOK);
		registerItem(GAMETYPE);
		GAMETYPE.setCreativeTab(Maw79Mod.debug);
		registerItem(FRACTIONS_BOOK);
		registerItem(COORDINATES_QUEST_ITEM_1);
		registerItem(COORDINATES_QUEST_ITEM_2);
		registerItem(COORDINATES_QUEST_ITEM_3);
		registerItem(COORDINATES_QUEST_ITEM_4);
		registerItem(COORDINATES_QUEST_ITEM_5);
		registerItem(COORDINATES_QUEST_ITEM_6);
		registerItem(COORDINATES_QUEST_ITEM_7);
		registerItem(COORDINATES_QUEST_ITEM_8);
		registerItem(COORDINATES_MANUAL);
		registerItem(NEGATIVE_MAGNET);
		registerItem(ROMAN_ARTIFACTS_MANUAL);
		
		//SCIENCE LABELS
		registerItem(LABELSTRONG);
		registerItem(LABELOPAQUE);
		registerItem(LABELCHAIR);
		registerItem(LABELFLEXIBLE);
		registerItem(LABELDURABLE);
		registerItem(LABELTOUGH);
		
		
		registerItem(LABELFERROUS);
		registerItem(LABELNONFERROUS);
		registerItem(LABELMAGNETIC); 
		registerItem(LABELLUSTROUS);
		registerItem(LABELHIGHDENSITY);
		
		registerItem(LABELFRAGILE);
		registerItem(LABELTRANSPARENT);
		registerItem(LABELSPECTACLES);
		registerItem(LABELWINDOWS);
		
		registerItem(LABELBAGS);
		registerItem(LABELWATERPROOF);
		registerItem(LABELTOXICITY);
		registerItem(LABELACRYLIC);
		registerItem(LABELPVC);
		registerItem(LABELCELLOPHANE);
		registerItem(LABELPOLYTHENE);
		
		registerItem(LABELANTISTATIC);
		registerItem(LABELPOTTERY);
		registerItem(LABELMUGS);
		
		
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
		registerRender(FRACTIONS_BOOK);
		registerRender(COORDINATES_MANUAL);
		registerRender(NEGATIVE_MAGNET);
		registerRender(GRAVITYBOOSTER);
		registerRender(BUILDER_COIN);
		registerRender(BUILDER_COIN_DEBUG);
		BUILDER_COIN_DEBUG.setCreativeTab(Maw79Mod.debug);
		registerRender(DOMUS_BUILDER);
		registerRender(ROMAN_ARTIFACTS_MANUAL);
		registerRender(JUMP_BOOSTER);
		registerRender(EGYPT_MANUAL);
		
		registerRender(COORDINATES_QUEST_ITEM_1);
		registerRender(COORDINATES_QUEST_ITEM_2);
		registerRender(COORDINATES_QUEST_ITEM_3);
		registerRender(COORDINATES_QUEST_ITEM_4);
		registerRender(COORDINATES_QUEST_ITEM_5);
		registerRender(COORDINATES_QUEST_ITEM_6);
		registerRender(COORDINATES_QUEST_ITEM_7);
		registerRender(COORDINATES_QUEST_ITEM_8);
		
		
		//SCIENCE LABELS
		registerRender(LABELCHAIR);
		registerRender(LABELOPAQUE);
		registerRender(LABELSTRONG);
		registerRender(LABELDURABLE);
		registerRender(LABELFLEXIBLE);
		registerRender(LABELTOUGH);
		
		registerRender(LABELFERROUS);
		registerRender(LABELNONFERROUS);
		registerRender(LABELMAGNETIC); 
		registerRender(LABELLUSTROUS);
		registerRender(LABELHIGHDENSITY);
		
		registerRender(LABELFRAGILE);
		registerRender(LABELTRANSPARENT);
		registerRender(LABELSPECTACLES);
		registerRender(LABELWINDOWS);
		
		registerRender(LABELBAGS);
		registerRender(LABELWATERPROOF);
		registerRender(LABELTOXICITY);
		registerRender(LABELACRYLIC);
		registerRender(LABELPVC);
		registerRender(LABELCELLOPHANE);
		registerRender(LABELPOLYTHENE);
		
		registerRender(LABELANTISTATIC);
		registerRender(LABELPOTTERY);
		registerRender(LABELMUGS);
		
		registerRender(SCOREDEBUG);
		SCOREDEBUG.setCreativeTab(Maw79Mod.debug);
		
		registerRender(CALCULATOR);
	
		//HISTORY ITEMS
		registerRender(ARTIFACT1);
		registerRender(ARTIFACT2);
		registerRender(ARTIFACT3);
		registerRender(ARTIFACT4);
		registerRender(ARTIFACT5);
		registerRender(ARTIFACT6);
		registerRender(ARTIFACT7);
		registerRender(ARTIFACT8);
		registerRender(ARTIFACT9);
		registerRender(ARTIFACT10);
		registerRender(ARTIFACT11);
		registerRender(ARTIFACT12);
		registerRender(ARTIFACT13);
		registerRender(ARTIFACT14);
		registerRender(ARTIFACT15);
		registerRender(ARTIFACT16);
		registerRender(ARTIFACT17);
		registerRender(ARTIFACT18);
		registerRender(ARTIFACT19);
		registerRender(ARTIFACT20);
		registerRender(ARTIFACT21);
		registerRender(PHAROH);
		registerRender(QUEST_DEBUG);
		QUEST_DEBUG.setCreativeTab(Maw79Mod.debug);
		PHAROH.setCreativeTab(Maw79Mod.historyitems);
		ARTIFACT1.setCreativeTab(Maw79Mod.historyitems);
		ARTIFACT2.setCreativeTab(Maw79Mod.historyitems);
		ARTIFACT3.setCreativeTab(Maw79Mod.historyitems);
		ARTIFACT4.setCreativeTab(Maw79Mod.historyitems);
		ARTIFACT5.setCreativeTab(Maw79Mod.historyitems);
		ARTIFACT6.setCreativeTab(Maw79Mod.historyitems);
		ARTIFACT7.setCreativeTab(Maw79Mod.historyitems);
		ARTIFACT8.setCreativeTab(Maw79Mod.historyitems);
		ARTIFACT9.setCreativeTab(Maw79Mod.historyitems);
		ARTIFACT10.setCreativeTab(Maw79Mod.historyitems);
		ARTIFACT11.setCreativeTab(Maw79Mod.historyitems);
		ARTIFACT12.setCreativeTab(Maw79Mod.historyitems);
		ARTIFACT13.setCreativeTab(Maw79Mod.historyitems);
		ARTIFACT14.setCreativeTab(Maw79Mod.historyitems);
		ARTIFACT15.setCreativeTab(Maw79Mod.historyitems);
		ARTIFACT16.setCreativeTab(Maw79Mod.historyitems);
		ARTIFACT17.setCreativeTab(Maw79Mod.historyitems);
		ARTIFACT18.setCreativeTab(Maw79Mod.historyitems);
		ARTIFACT19.setCreativeTab(Maw79Mod.historyitems);
		ARTIFACT20.setCreativeTab(Maw79Mod.historyitems);
		ARTIFACT21.setCreativeTab(Maw79Mod.historyitems);
		
		registerRender(FRAGMENT1);
		registerRender(FRAGMENT2);
		registerRender(FRAGMENT3);
		registerRender(FRAGMENT4);
		registerRender(FRAGMENT5);
		registerRender(FRAGMENT6);
		registerRender(FRAGMENT7);
		registerRender(FRAGMENT8);
		registerRender(FRAGMENT9);
		FRAGMENT1.setCreativeTab(Maw79Mod.historyitems);
		FRAGMENT2.setCreativeTab(Maw79Mod.historyitems);
		FRAGMENT3.setCreativeTab(Maw79Mod.historyitems);
		FRAGMENT4.setCreativeTab(Maw79Mod.historyitems);
		FRAGMENT5.setCreativeTab(Maw79Mod.historyitems);
		FRAGMENT6.setCreativeTab(Maw79Mod.historyitems);
		FRAGMENT7.setCreativeTab(Maw79Mod.historyitems);
		FRAGMENT8.setCreativeTab(Maw79Mod.historyitems);
		FRAGMENT9.setCreativeTab(Maw79Mod.historyitems);
		
		registerRender(ARTIFACT_AMULET);
		registerRender(ARTIFACT_ANKH);
		registerRender(ARTIFACT_PYRAMIDION);
		registerRender(ARTIFACT_CANOPIC_JAR);
		registerRender(ARTIFACT_PAPYRUS);
		registerRender(ARTIFACT_SCARAB);
		registerRender(ARTIFACT_SARCOPHAGUS);
		registerRender(ARTIFACT_SENET);
		registerRender(ARTIFACT_SPHINX);
		registerRender(ARTIFACT_FALSEDOOR);
		registerRender(ARTIFACT_FUNERARY);
		registerRender(ARTIFACT_MUMMY);
		ARTIFACT_AMULET.setCreativeTab(Maw79Mod.historyitems);
		ARTIFACT_ANKH.setCreativeTab(Maw79Mod.historyitems);
		ARTIFACT_PYRAMIDION.setCreativeTab(Maw79Mod.historyitems);
		ARTIFACT_CANOPIC_JAR.setCreativeTab(Maw79Mod.historyitems);
		ARTIFACT_PAPYRUS.setCreativeTab(Maw79Mod.historyitems);
		ARTIFACT_SCARAB.setCreativeTab(Maw79Mod.historyitems);
		ARTIFACT_SARCOPHAGUS.setCreativeTab(Maw79Mod.historyitems);
		ARTIFACT_SENET.setCreativeTab(Maw79Mod.historyitems);
		ARTIFACT_SPHINX.setCreativeTab(Maw79Mod.historyitems);
		ARTIFACT_FALSEDOOR.setCreativeTab(Maw79Mod.historyitems);
		ARTIFACT_FUNERARY.setCreativeTab(Maw79Mod.historyitems);
		ARTIFACT_MUMMY.setCreativeTab(Maw79Mod.historyitems);
		
		registerRender(HISTORYBOOK);
		registerRender(ROMAN_ARTIFACT1);
		registerRender(ROMAN_ARTIFACT2);
		registerRender(ROMAN_ARTIFACT3);
		registerRender(ROMAN_ARTIFACT4);
		registerRender(ROMAN_ARTIFACT5);
		registerRender(ROMAN_ARTIFACT6);
		registerRender(ROMAN_ARTIFACT7);
		registerRender(ROMAN_ARTIFACT8);
		registerRender(ROMAN_ARTIFACT9);
		registerRender(ROMAN_ARTIFACT10);
		registerRender(ROMAN_ARTIFACT_DEBUG);
		ROMAN_ARTIFACT_DEBUG.setCreativeTab(Maw79Mod.debug);
		
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
