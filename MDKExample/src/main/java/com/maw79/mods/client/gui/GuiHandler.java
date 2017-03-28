package com.maw79.mods.client.gui;

import com.maw79.mods.blocks.scienceblocks.tileentityscience.ContainerScience;
import com.maw79.mods.blocks.scienceblocks.tileentityscience.GuiScienceTe;
import com.maw79.mods.blocks.scienceblocks.tileentityscience.TileEntityScience;
import com.maw79.mods.blocks.tileentityattempt.ContainerBasic2;
import com.maw79.mods.blocks.tileentityattempt.GuiBasic2;
import com.maw79.mods.blocks.tileentityattempt.TileEntityCustom2;
import com.maw79.mods.container.ContainerBasic;
import com.maw79.mods.container.ContainerBlockBreaker;
import com.maw79.mods.tileentity.TileEntityBlockBreaker;
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
		return null;
	}
	

}
