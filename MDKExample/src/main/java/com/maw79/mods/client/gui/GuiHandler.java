package com.maw79.mods.client.gui;

import com.maw79.mods.blocks.ItemProfiler.ContainerProfiler;
import com.maw79.mods.blocks.ItemProfiler.GuiProfilerTe;
import com.maw79.mods.blocks.ItemProfiler.TileEntityProfiler;
import com.maw79.mods.blocks.historyblocks.artifactupdater.ContainerArtifactResearcher;
import com.maw79.mods.blocks.historyblocks.artifactupdater.GuiArtifactResearcherTe;
import com.maw79.mods.blocks.historyblocks.artifactupdater.TileEntityArtifactResearcher;
import com.maw79.mods.blocks.mathsblocks.coordinatesquest.ContainerCoordinatesQuest;
import com.maw79.mods.blocks.mathsblocks.coordinatesquest.GuiCoordinatesQuest;
import com.maw79.mods.blocks.mathsblocks.coordinatesquest.TileEntityCoordinatesQuest;
import com.maw79.mods.blocks.mathsblocks.questblock.ContainerMathsQuest;
import com.maw79.mods.blocks.mathsblocks.questblock.GuiMathsQuestTe;
import com.maw79.mods.blocks.mathsblocks.questblock.TileEntityMathsQuest;
import com.maw79.mods.blocks.mathsblocks.recycler.ContainerRecycler;
import com.maw79.mods.blocks.mathsblocks.recycler.GuiRecycler;
import com.maw79.mods.blocks.mathsblocks.recycler.TileEntityRecycler;
import com.maw79.mods.blocks.pointsblocks.ContainerPointsBlock;
import com.maw79.mods.blocks.pointsblocks.GuiPointsBlock;
import com.maw79.mods.blocks.pointsblocks.TileEntityPointsBlock;
import com.maw79.mods.blocks.scienceblocks.insulatorblocks.ContainerInsulator;
import com.maw79.mods.blocks.scienceblocks.insulatorblocks.GuiInsulatorTe;
import com.maw79.mods.blocks.scienceblocks.insulatorblocks.TileEntityInsulator;
import com.maw79.mods.blocks.scienceblocks.insulatorblockscalculator.ContainerInsulatorCalculator;
import com.maw79.mods.blocks.scienceblocks.insulatorblockscalculator.GuiInsulatorCalculatorTe;
import com.maw79.mods.blocks.scienceblocks.insulatorblockscalculator.TileEntityInsulatorCalculator;
import com.maw79.mods.blocks.scienceblocks.tileentityscience.ContainerScience;
import com.maw79.mods.blocks.scienceblocks.tileentityscience.GuiScienceTe;
import com.maw79.mods.blocks.scienceblocks.tileentityscience.TileEntityScience;
import com.maw79.mods.blocks.tileentityattempt.ContainerBasic2;
import com.maw79.mods.blocks.tileentityattempt.GuiBasic2;
import com.maw79.mods.blocks.tileentityattempt.TileEntityCustom2;
import com.maw79.mods.container.ContainerBasic;
import com.maw79.mods.container.ContainerBlockBreaker;
import com.maw79.mods.tileentity.TileEntityBlockBreaker;
import com.maw79.mods.tileentity.storetileentity.ContainerStore;
import com.maw79.mods.tileentity.storetileentity.GuiStore;
import com.maw79.mods.util.Utils;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler{

	/**
	 * Each gui needs an ID
	 */
	public static final int BLOCK_BREAKER = 0;
	public static final int GUI_DEVICE = 1;
	public static final int TEST = 2;
	public static final int TEST2 = 3;
	public static final int SCIENCE_GUI = 4;
	public static final int INSULATOR_GUI = 5;
	public static final int PROFILER_GUI = 6;
	public static final int INSULATOR_CALCULATOR_GUI = 7;
	public static final int ARTIFACT_RESEARCHER = 8;
	public static final int STORE_GUI = 9;
	public static final int STORED_DISPLAY_2 = 10;
	public static final int MATHS_QUEST = 11;
	public static final int RECYCLER_BLOCK = 12;
	public static final int POINTS_BLOCK = 13;
	public static final int COORDINATES_QUEST = 14;
	
	/**
	 * Should return the container for that gui. This is called server side because servers handle items in guis
	 */
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == BLOCK_BREAKER) {
			return new ContainerBlockBreaker(player.inventory, (TileEntityBlockBreaker) world.getTileEntity(new BlockPos(x, y, z)));
		}
		if(ID == GUI_DEVICE) {
			return new ContainerBlockBreaker(player.inventory, (TileEntityBlockBreaker) world.getTileEntity(new BlockPos(x, y, z)));
		}
		
		if(ID==TEST){
			Entity test = world.getEntityByID(x);
			
			return new ContainerBasic(player.inventory,test);
		}
		if(ID==TEST2){
			//Entity test2 = world.getEntityByID(x);
			
			return new ContainerBasic2(player.inventory, (TileEntityCustom2) world.getTileEntity(new BlockPos(x, y, z)));
		}
		if(ID==SCIENCE_GUI){
			
			
			return new ContainerScience(player.inventory, (TileEntityScience) world.getTileEntity(new BlockPos(x, y, z)));
		}
		if(ID==INSULATOR_GUI){
			
			
			return new ContainerInsulator(player.inventory, (TileEntityInsulator) world.getTileEntity(new BlockPos(x, y, z)));
		}
		if(ID==PROFILER_GUI){
			
			
			return new ContainerProfiler(player.inventory, (TileEntityProfiler) world.getTileEntity(new BlockPos(x, y, z)));
		}
		if(ID==INSULATOR_CALCULATOR_GUI){
			
			
			return new ContainerInsulatorCalculator(player.inventory, (TileEntityInsulatorCalculator) world.getTileEntity(new BlockPos(x, y, z)));
		}
		if(ID==ARTIFACT_RESEARCHER){
			
			
			return new ContainerArtifactResearcher(player.inventory, (TileEntityArtifactResearcher) world.getTileEntity(new BlockPos(x, y, z)));
		}
		if(ID==STORE_GUI){
			
			Entity tourguide = world.getEntityByID(x);
			
			return new ContainerStore(player.inventory,tourguide);
		}
		if(ID==MATHS_QUEST){
			
			
			return new ContainerMathsQuest(player.inventory, (TileEntityMathsQuest) world.getTileEntity(new BlockPos(x, y, z)));
		}
		if(ID==RECYCLER_BLOCK){
			
			
			return new ContainerRecycler(player.inventory, (TileEntityRecycler) world.getTileEntity(new BlockPos(x, y, z)));
		}
		if(ID==POINTS_BLOCK){
			
			
			return new ContainerPointsBlock(player.inventory, (TileEntityPointsBlock) world.getTileEntity(new BlockPos(x, y, z)));
		}
		if(ID==COORDINATES_QUEST){
			
			
			return new ContainerCoordinatesQuest(player.inventory, (TileEntityCoordinatesQuest) world.getTileEntity(new BlockPos(x, y, z)));
		}
		
		
		return null;
	}
	
		
		

	/**
	 * Should return the actual gui. This is called client side as thats where guis are rendered
	 */
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == BLOCK_BREAKER) {
			return new GuiBlockBreaker(player.inventory, (TileEntityBlockBreaker) world.getTileEntity(new BlockPos(x, y, z)));
		}
		if(ID == GUI_DEVICE) {
			return new ContainerBlockBreaker(player.inventory, (TileEntityBlockBreaker) world.getTileEntity(new BlockPos(x, y, z)));
		}
		
Utils.getLogger().info("GuiHandler: getClientGuiElement");
		
		if(ID==TEST){
			Entity test = world.getEntityByID(x);
			return new GuiBasic(player.inventory, test);
		}
		if(ID==TEST2){
			//Entity test2 = world.getEntityByID(x);
			return new GuiBasic2(player.inventory, (TileEntityCustom2) world.getTileEntity(new BlockPos(x, y, z)));
		}
		if(ID==SCIENCE_GUI){
			//Entity test2 = world.getEntityByID(x);
			Utils.getLogger().info("GuiHandler: client SCIENCE GUI called");
			return new GuiScienceTe(player.inventory, (TileEntityScience) world.getTileEntity(new BlockPos(x, y, z)));
		}
		if(ID==INSULATOR_GUI){
			
			Utils.getLogger().info("GuiHandler: client Insulator GUI called");
			return new GuiInsulatorTe(player.inventory, (TileEntityInsulator) world.getTileEntity(new BlockPos(x, y, z)));
		}
		if(ID==PROFILER_GUI){
			
			Utils.getLogger().info("GuiHandler: client Profiler GUI called");
			return new GuiProfilerTe(player.inventory, (TileEntityProfiler) world.getTileEntity(new BlockPos(x, y, z)));
		}
		if(ID==INSULATOR_CALCULATOR_GUI){
			
			Utils.getLogger().info("GuiHandler: client Insulator CalculatorGUI called");
			return new GuiInsulatorCalculatorTe(player.inventory, (TileEntityInsulatorCalculator) world.getTileEntity(new BlockPos(x, y, z)));
		}
		if(ID==ARTIFACT_RESEARCHER){
			
			Utils.getLogger().info("GuiHandler: client Insulator CalculatorGUI called");
			return new GuiArtifactResearcherTe(player.inventory, (TileEntityArtifactResearcher) world.getTileEntity(new BlockPos(x, y, z)));
		}
		if(ID==STORE_GUI){
			
			Entity tourguide = world.getEntityByID(x);
			return new GuiStore(player.inventory, tourguide);
		}
		if(ID==STORED_DISPLAY_2){
			
			return new GuiMathsQuestGive();
		}
		if(ID==MATHS_QUEST){
			
			return new GuiMathsQuestTe(player.inventory, (TileEntityMathsQuest) world.getTileEntity(new BlockPos(x, y, z)));
		}
		if(ID==RECYCLER_BLOCK){
			
			return new GuiRecycler(player.inventory, (TileEntityRecycler) world.getTileEntity(new BlockPos(x, y, z)));
		}
		if(ID==POINTS_BLOCK){
			
			return new GuiPointsBlock(player.inventory, (TileEntityPointsBlock) world.getTileEntity(new BlockPos(x, y, z)));
		}
		if(ID==COORDINATES_QUEST){
			
			return new GuiCoordinatesQuest(player.inventory, (TileEntityCoordinatesQuest) world.getTileEntity(new BlockPos(x, y, z)));
		}
		
		return null;
	}
	

}
