package com.maw79.mods.init;

import com.maw79.mods.handlers.EnumHandler;
import com.maw79.mods.items.ItemBookOne;
import com.maw79.mods.items.ItemBurntLoaf;
import com.maw79.mods.items.ItemChip;
import com.maw79.mods.items.ItemGameSwitcher;
import com.maw79.mods.items.ItemHeart;
import com.maw79.mods.items.ItemLightningSpawner;
import com.maw79.mods.items.ItemModFood;
import com.maw79.mods.items.ItemMw;
import com.maw79.mods.items.ItemObsidianSword;
import com.maw79.mods.items.ItemObsidianingot;
import com.maw79.mods.items.ItemReversePaintBrush;
import com.maw79.mods.items.ItemRuby;
import com.maw79.mods.items.ItemSteelIngot;
import com.maw79.mods.items.ItemTomato;
import com.maw79.mods.items.ItemTutorial;
import com.maw79.mods.items.ItemXAxisTool;
import com.maw79.mods.items.ItemYAxisTool;
import com.maw79.mods.items.ItemZAxisTool;
import com.maw79.mods.items.mathsitems.ItemAppleWall;
import com.maw79.mods.items.mathsitems.ItemCompleteAppleWall;
import com.maw79.mods.items.mathsitems.ItemPictureWall;
import com.maw79.mods.items.mathsitems.ItemXyzDevice;
import com.maw79.mods.main.Maw79Mod;
import com.maw79.mods.main.Reference;
import com.maw79.mods.util.Utils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
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
	public static Item completeapplepicturewall;
	public static Item xyzdevice;
	
	
	//Tool Materials
	public static ToolMaterial obsidianMaterial = EnumHelper.addToolMaterial("obsidianingot", 2, 300, 5.0F, 2.0F, 12);
	//Tools
	public static ItemSword obsidian_sword;
	
	

	public static void init(){
		//Items
		obsidianingot = new ItemObsidianingot();
		steelingot = new ItemSteelIngot("steelingot");
		ruby = new ItemRuby();
		mw = new ItemMw();
		heart = new ItemHeart("heart");
		bolt = new ItemLightningSpawner("bolt");
		chip = new ItemChip("chip");
		//Food
		tomato = new ItemTomato();
		burntloaf = new ItemBurntLoaf("burntloaf");
		mouldyapple = new ItemModFood("mouldyapple", 4, 4, false, new PotionEffect(Potion.getPotionById(3),10,2));
		//Tools
		obsidian_sword= new ItemObsidianSword(obsidianMaterial);
		customfuel = new Item().setUnlocalizedName("custom fuel").setRegistryName(new ResourceLocation(Reference.MOD_ID, "customfuel"));
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
		applepicturewall = new ItemAppleWall("apple_wall");
		completeapplepicturewall = new ItemCompleteAppleWall("complete_apple_wall");
		
		
	}
	
	
	public static void register(){
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
		//Food
		registerItem(tomato);
		registerItem(mouldyapple);
		registerItem(burntloaf);
		//Tools
		registerItem(obsidian_sword);
		registerItem(tutorialItem);
		
		//MATHS ITEMS
		registerItem(firstbook);
		registerItem(xaxistool);
		registerItem(yaxistool);
		registerItem(zaxistool);
		registerItem(stevepicturewall);
		registerItem(applepicturewall);
		registerItem(xyzdevice);
		
		//Debug Items
		registerItem(reversepaintbrush);
		registerItem(gameswitcher);
		registerItem(completeapplepicturewall);
		
		
		
		
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
		registerRender(xyzdevice);
		
		//Food
		registerRender(tomato);
		registerRender(mouldyapple);
		registerRender(burntloaf);
		//Tools
		registerRender(obsidian_sword);
		
		//Debug Items
		registerRender(reversepaintbrush);
		reversepaintbrush.setCreativeTab(Maw79Mod.debug);
		registerRender(gameswitcher);
		gameswitcher.setCreativeTab(Maw79Mod.debug);
		registerRender(completeapplepicturewall);
		completeapplepicturewall.setCreativeTab(Maw79Mod.debug);
		
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
	
	
	
	private static void registerRender(Item item){
		
Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
		//ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(new ResourceLocation(Reference.MOD_ID, item.getUnlocalizedName().substring(5)), "inventory"));
Utils.getLogger().info("Registered render for " + item.getUnlocalizedName().substring(5));
	}
	

	private static void registerRender(Item item, int meta, String fileName){
		
Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, meta, new ModelResourceLocation(new ResourceLocation(Reference.MOD_ID, fileName), "inventory"));
		//ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(new ResourceLocation(Reference.MOD_ID, fileName), "inventory"));
Utils.getLogger().info("Registered render for MULTIITEMS " + item.getUnlocalizedName().substring(5));
	}
	
	
}
