package com.maw79.mods.main;

public class Reference {
 public static final String MOD_ID = "maw79";
 public static final String NAME = "Maw79 KS2 Mod";
 public static final String VERSION = "0.40 mathsbuild - Alpha";
 public static final String ACCEPTED_VERSION = "[1.11, 1.11.2]";
 
 public static final String CLIENT_PROXY_CLASS = "com.maw79.mods.proxy.ClientProxy";
 public static final String SERVER_PROXY_CLASS = "com.maw79.mods.proxy.ServerProxy";
 
 /**
	 * Where the gui factory if found
	 */
	public static final String GUI_FACTORY = "com.maw79.mods.config.Maw79ConfigGuiFactory";
 
 //##############################################################################################
 //ITEMS
 public static enum MawItems {
	 
	 //Items
	 OBSIDIANINGOT("obsidianingot", "ItemObsidianingot"),
	 RUBY("ruby", "ItemRuby"),
	 MW("mw", "ItemMw"),
	 MA("mouldyapple", "ItemMouldyapple"),
	
	 
	 //Food Items
	 TOMATO("tomato", "ItemTomato"),
	 
	 //Tools
	 OBSIDIANSWORD("obsidian_sword", "ItemObsidianSword");
	 
	
	 
	 
	 private String unlocalizedName;
	 private String registryName;
	 
	 MawItems(String unlocalizedName, String registryName){
	 this.unlocalizedName = unlocalizedName;
	 this.registryName = registryName;
	 }
	 
	 public String getUnlocalizedName(){
		 return unlocalizedName;
	 }
	 
	 public String getRegistryName(){
		 return registryName;
	 }
 }
 //##############################################################################################
 //Blocks
 public static enum MawBlocks {
	 RUBYBLOCK("rubyblock", "BlockRuby"),
	 OBSIDIANINGOTBLOCK("obsidianingotblock", "BlockObsidianIngot");
	
	
	 private String unlocalizedName;
	 private String registryName;
	 
	 MawBlocks(String unlocalizedName, String registryName){
	 this.unlocalizedName = unlocalizedName;
	 this.registryName = registryName;
	 }
	 
	 public String getUnlocalizedName(){
		 return unlocalizedName;
	 }
	 
	 public String getRegistryName(){
		 return registryName;
	 }
 }
 //##############################################################################################
 

 
 
 
 //Foods
 public static enum MawFoods {
	 ROTTENAPPLE("rottenapple", "RottenApple");
	
	 private String unlocalizedName;
	 private String registryName;
	 
	 MawFoods(String unlocalizedName, String registryName){
	 this.unlocalizedName = unlocalizedName;
	 this.registryName = registryName;
	 }
	 
	 public String getUnlocalizedName(){
		 return unlocalizedName;
	 }
	 
	 public String getRegistryName(){
		 return registryName;
	 }
 }
}
