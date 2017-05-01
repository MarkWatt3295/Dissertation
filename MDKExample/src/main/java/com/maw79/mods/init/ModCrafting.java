package com.maw79.mods.init;

import com.maw79.mods.items.historyitems.ItemAmulet;
import com.maw79.mods.items.historyitems.ItemAnkh;
import com.maw79.mods.items.historyitems.ItemCanopicJar;
import com.maw79.mods.items.historyitems.ItemFalseDoor;
import com.maw79.mods.items.historyitems.ItemFuneraryCone;
import com.maw79.mods.items.historyitems.ItemMummy;
import com.maw79.mods.items.historyitems.ItemPapyrus;
import com.maw79.mods.items.historyitems.ItemPyramidionStone;
import com.maw79.mods.items.historyitems.ItemSarcophagus;
import com.maw79.mods.items.historyitems.ItemScarab;
import com.maw79.mods.items.historyitems.ItemSenet;
import com.maw79.mods.items.historyitems.ItemSphinx;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModCrafting {

	public static void register(){
		/// XXX XXX XXX Top Middle Bottom
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.rubyblock), "RRR", "RRR", "RRR", 'R', ModItems.ruby);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.ruby), Items.EMERALD, Items.REDSTONE);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.ruby), Items.EMERALD, new ItemStack(Blocks.WOOL, 1,0)); //Quantity folllowed by metadata
		
		//History Relics
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.FRAGMENT1), ModItems.ARTIFACT1);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.FRAGMENT2), ModItems.ARTIFACT2);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.FRAGMENT3), ModItems.ARTIFACT3);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.FRAGMENT4), ModItems.ARTIFACT4);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.FRAGMENT5), ModItems.ARTIFACT5);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.FRAGMENT6), ModItems.ARTIFACT6);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.FRAGMENT7), ModItems.ARTIFACT7);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.FRAGMENT8), ModItems.ARTIFACT8);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.FRAGMENT9), ModItems.ARTIFACT9);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.PHAROH), ModItems.FRAGMENT1, ModItems.FRAGMENT2,ModItems.FRAGMENT3,ModItems.FRAGMENT4, ModItems.FRAGMENT5, ModItems.FRAGMENT6, ModItems.FRAGMENT7, ModItems.FRAGMENT8, ModItems.FRAGMENT9);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.ARTIFACT_AMULET), ModItems.ARTIFACT10);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.ARTIFACT_ANKH), ModItems.ARTIFACT11);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.ARTIFACT_PYRAMIDION), ModItems.ARTIFACT12);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.ARTIFACT_CANOPIC_JAR), ModItems.ARTIFACT13);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.ARTIFACT_PAPYRUS), ModItems.ARTIFACT14);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.ARTIFACT_SCARAB), ModItems.ARTIFACT15);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.ARTIFACT_SARCOPHAGUS), ModItems.ARTIFACT16);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.ARTIFACT_SENET), ModItems.ARTIFACT17);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.ARTIFACT_SPHINX), ModItems.ARTIFACT18);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.ARTIFACT_FALSEDOOR), ModItems.ARTIFACT19);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.ARTIFACT_FUNERARY), ModItems.ARTIFACT20);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.ARTIFACT_MUMMY), ModItems.ARTIFACT21);
		
		//1f = 1 XP
		
		//SMELTING
		GameRegistry.addSmelting(Blocks.OBSIDIAN, new ItemStack(ModItems.obsidianingot), 0.5F);
		GameRegistry.addSmelting(Items.BREAD, new ItemStack(ModItems.burntloaf), 0.5F);
		GameRegistry.addSmelting(ModBlocks.steelOre, new ItemStack(ModItems.steelingot), 0.5F);
		
		//Tool Creation
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.obsidian_sword), ModItems.obsidianingot, ModItems.obsidianingot);
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.obsidian_sword), "I","I","S", 'I', ModItems.obsidianingot, 'S', ModItems.ruby );
		
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.obsidianingotblock), "RRR", "RRR", "RRR", 'R', ModItems.obsidianingot);
	
		
	
	
	
	
	}
}