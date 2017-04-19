package com.maw79.mods.handlers;

import java.util.ArrayList;
import java.util.List;

import com.maw79.mods.init.ModArmour;
import com.maw79.mods.init.ModBlocks;
import com.maw79.mods.init.ModItems;
import com.maw79.mods.init.ModTools;
import com.maw79.mods.items.ItemPaintBrush;
import com.maw79.mods.main.Reference;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;


public class AchievementHandler {
	
	/**
	 * A list of all of our achievements
	 */
	private static List<Achievement> achievements = new ArrayList<Achievement>();
	
	/**
	 * State each achievement and use the createAchievement method to register the achievement
	 * List all Achievements to be added to the game
	 */
	public static Achievement achievementNewIngot = createAchievement("newingot", 0, 0, ModItems.obsidianingot); //Image for Achievment Icon
	public static Achievement achievementNewSword = createAchievement2("newsword", 0, 0, ModItems.steelingot);
	public static Achievement achievementTest = createAchievement3("test", 0, 0, ModItems.burntloaf);
	public static Achievement achievementObsidianMan = createAchievement4("obsidianman", 4, 4, ModBlocks.obsidianingotblock); //Image for Achievment Icon
	public static Achievement achievementPainter = createAchievement("painter", 2, 2, ModItems.reversepaintbrush);
	public static Achievement achievementNiceTo = createAchievement("niceto", 2, 4, Blocks.SOUL_SAND);
	public static Achievement achievementMathsQuest = createAchievement("mathsquest", 3, 0, ModBlocks.Mathsquestblock);

	/**
	 * Registers the achievements
	 */
	public static void registerAchievements() {
		Achievement[] achievementArray = new Achievement[achievements.size()]; //Converts the list to an array
		for(Achievement achievement : achievements) {
			achievement.registerStat(); //Registers the achievement
			achievementArray[achievements.indexOf(achievement)] = achievement; //Adds it to the array
		}
		AchievementPage.registerAchievementPage(new AchievementPage(Reference.NAME, achievementArray)); //Adds the array to our achievement page
	}
	
	
	//INGOT ACHIEVEMENT
	//##################################################################
	private static Achievement createAchievement(String name, int column, int row, Item item) {
		Achievement acheivement = new Achievement("achievement." + name, name, column, row, item, (Achievement)null); //The null is for the parent this is if one achievement requires another to unlock it
		achievements.add(acheivement);
		return acheivement;
	}
	
	private static Achievement createAchievement(String name, int column, int row, Block block) {
		Achievement acheivement = new Achievement("achievement." + name, name, column, row, block, (Achievement)null);
		achievements.add(acheivement);
		return acheivement;
	}
	
	private static Achievement createAchievement(String name, int column, int row, ItemStack stack) {
		Achievement acheivement = new Achievement("achievement." + name, name, column, row, stack, (Achievement)null);
		achievements.add(acheivement);
		return acheivement;
	}
	//##################################################################
	
	//Sword ACHIEVEMENT
	//##################################################################
		private static Achievement createAchievement2(String name, int column, int row, Item item) {
			Achievement acheivement2 = new Achievement("achievement2." + name, name, column+=1, row+=1, item, (Achievement)achievementNewIngot); //The null is for the parent this is if one achievement requires another to unlock it
			achievements.add(acheivement2);
			return acheivement2;
		}
		
		private static Achievement createAchievement2(String name, int column, int row, Block block) {
			Achievement acheivement2 = new Achievement("achievement2." + name, name, column+=1, row+=1, block, (Achievement)achievementNewIngot);
			achievements.add(acheivement2);
			return acheivement2;
		}
		
		private static Achievement createAchievement2(String name, int column, int row, ItemStack stack) {
			Achievement acheivement2 = new Achievement("achievement2." + name, name, column+=1, row+=1, stack, (Achievement)achievementNewIngot);
			achievements.add(acheivement2);
			return acheivement2;
		}
		
		//##################################################################

		//Test ACHIEVEMENT
		//##################################################################
			private static Achievement createAchievement3(String name, int column, int row, Item item) {
				Achievement acheivement3 = new Achievement("achievement3." + name, name, column+=1, row+=2, item, (Achievement)achievementNewIngot); //The null is for the parent this is if one achievement requires another to unlock it
				achievements.add(acheivement3);
				return acheivement3;
			}
			
			
			//##################################################################
			
			private static Achievement createAchievement4(String name, int column, int row, Block obsidianingotblock) {
				Achievement acheivement4 = new Achievement("achievement4." + name, name, column+=2, row+=0, obsidianingotblock, (Achievement)null); //The null is for the parent this is if one achievement requires another to unlock it
				achievements.add(acheivement4);
				return acheivement4;
			}
			
			private static Achievement createAchievement5(String name, int column, int row, Item reversepaintbtrush) {
				Achievement acheivement5 = new Achievement("achievement5." + name, name, column+=2, row+=1, reversepaintbtrush, (Achievement)null); //The null is for the parent this is if one achievement requires another to unlock it
				achievements.add(acheivement5);
				return acheivement5;
			}
			
			private static Achievement createAchievement6(String name, int column, int row, Block soulsand) {
				Achievement acheivement6 = new Achievement("achievement6." + name, name, column+=3, row+=2, soulsand, (Achievement)null); //The null is for the parent this is if one achievement requires another to unlock it
				achievements.add(acheivement6);
				return acheivement6;
			}
			private static Achievement createAchievement7(String name, int column, int row, Block mathsquiz) {
				Achievement acheivement7 = new Achievement("achievement7." + name, name, column, row, mathsquiz, (Achievement)null); //The null is for the parent this is if one achievement requires another to unlock it
				achievements.add(acheivement7);
				return acheivement7;
			}
}