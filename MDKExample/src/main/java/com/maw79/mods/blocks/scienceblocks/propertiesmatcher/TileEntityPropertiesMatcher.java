package com.maw79.mods.blocks.scienceblocks.propertiesmatcher;

import com.maw79.mods.blocks.pointsblocks.TileEntityPointsBlock;
import com.maw79.mods.client.gui.GuiHandler;
import com.maw79.mods.client.gui.GuiMathsMultiplicationBlock1;
import com.maw79.mods.client.gui.GuiSciencePropertyMatcher;
import com.maw79.mods.handlers.ModSoundHandler;
import com.maw79.mods.init.ModItems;
import com.maw79.mods.main.Maw79Mod;
import com.maw79.mods.util.Utils;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityPropertiesMatcher extends TileEntity implements ITickable, ICapabilityProvider {

	public static String propertyType ="";
	public static String labelType ="";
	public static String labelName ="";
	public ItemStackHandler handler;
	
	
	/**
	 * Initializes our variables. MUST NOT HAVE ANY PARAMETERS
	 */
	public TileEntityPropertiesMatcher() {
		this.handler = new ItemStackHandler(10);

	}
	/**
	 * New 1.9.4 onwards. Capability system
	 */
	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
			return (T) this.handler;
		return super.getCapability(capability, facing);
	}

	/**
	 * Says what our block is capable of
	 */
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
			return true;
		return super.hasCapability(capability, facing);
	}

	public boolean isUseableByPlayer(EntityPlayer player) {
		return this.world.getTileEntity(this.getPos()) == this
				&& player.getDistanceSq(this.pos.add(0.5, 0.5, 0.5)) <= 64;
	}

	/**
	 * Says that if the block state updates, the tile entity shouldn't get
	 * destroyed but should not refresh
	 */
	@Override
	public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newSate) {
		return false;
	}

	@Override
	public void update() {
	
	

		if (!world.isRemote) {
			IBlockState currentState = this.world.getBlockState(pos);
			EntityPlayer player = Minecraft.getMinecraft().player;

			if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModItems.LABELCHAIR))) {
				Utils.getLogger().info("Label Chair");
				labelName =handler.getStackInSlot(4).getDisplayName();
				handler.extractItem(4, 1, false);
				propertyType="Wood";
				labelType="Chairs";
				Minecraft.getMinecraft().displayGuiScreen(new GuiSciencePropertyMatcher());
		}
			else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModItems.LABELDURABLE))) {
				Utils.getLogger().info("Label Durable");
				labelName =handler.getStackInSlot(4).getDisplayName();
				handler.extractItem(4, 1, false);
				propertyType="Wood";
				labelType="Durable";
				Minecraft.getMinecraft().displayGuiScreen(new GuiSciencePropertyMatcher());
		}
			else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModItems.LABELFLEXIBLE))) {
				Utils.getLogger().info("Label Flexible");
				labelName =handler.getStackInSlot(4).getDisplayName();
				handler.extractItem(4, 1, false);
				propertyType="Wood";
				labelType="Flexible";
				Minecraft.getMinecraft().displayGuiScreen(new GuiSciencePropertyMatcher());
		}
			else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModItems.LABELOPAQUE))) {
				Utils.getLogger().info("Label Opaque");
				labelName =handler.getStackInSlot(4).getDisplayName();
				handler.extractItem(4, 1, false);
				propertyType="Wood";
				labelType="Opaque";
				Minecraft.getMinecraft().displayGuiScreen(new GuiSciencePropertyMatcher());
		}
			else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModItems.LABELSTRONG))) {
				Utils.getLogger().info("Label Strong");
				labelName =handler.getStackInSlot(4).getDisplayName();
				handler.extractItem(4, 1, false);
				propertyType="Wood";
				labelType="Strong";
				Minecraft.getMinecraft().displayGuiScreen(new GuiSciencePropertyMatcher());
		}
			else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModItems.LABELTOUGH))) {
				Utils.getLogger().info("Label Tough");
				labelName =handler.getStackInSlot(4).getDisplayName();
				handler.extractItem(4, 1, false);
				propertyType="Wood";
				labelType="Tough";
				Minecraft.getMinecraft().displayGuiScreen(new GuiSciencePropertyMatcher());
		}
			else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModItems.LABELFERROUS))) {
				Utils.getLogger().info("Label Ferrous");
				labelName =handler.getStackInSlot(4).getDisplayName();
				handler.extractItem(4, 1, false);
				propertyType="Metal";
				labelType="Ferrous";
				Minecraft.getMinecraft().displayGuiScreen(new GuiSciencePropertyMatcher());
		}
			else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModItems.LABELNONFERROUS))) {
				Utils.getLogger().info("Label Non Ferrous");
				labelName =handler.getStackInSlot(4).getDisplayName();
				handler.extractItem(4, 1, false);
				propertyType="Metal";
				labelType="Non Ferrous";
				Minecraft.getMinecraft().displayGuiScreen(new GuiSciencePropertyMatcher());
		}
			else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModItems.LABELMAGNETIC))) {
				Utils.getLogger().info("Label Magnetic");
				labelName =handler.getStackInSlot(4).getDisplayName();
				handler.extractItem(4, 1, false);
				propertyType="Metal";
				labelType="Magnetic";
				Minecraft.getMinecraft().displayGuiScreen(new GuiSciencePropertyMatcher());
		}
			else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModItems.LABELLUSTROUS))) {
				Utils.getLogger().info("Label Lustrous");
				labelName =handler.getStackInSlot(4).getDisplayName();
				handler.extractItem(4, 1, false);
				propertyType="Metal";
				labelType="Lustrous";
				Minecraft.getMinecraft().displayGuiScreen(new GuiSciencePropertyMatcher());
		}
			else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModItems.LABELHIGHDENSITY))) {
				Utils.getLogger().info("Label High Density");
				labelName =handler.getStackInSlot(4).getDisplayName();
				handler.extractItem(4, 1, false);
				propertyType="Metal";
				labelType="High Density";
				Minecraft.getMinecraft().displayGuiScreen(new GuiSciencePropertyMatcher());
		}
			else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModItems.LABELFRAGILE))) {
				Utils.getLogger().info("Label Fragile");
				labelName =handler.getStackInSlot(4).getDisplayName();
				handler.extractItem(4, 1, false);
				propertyType="Glass";
				labelType="Fragile";
				Minecraft.getMinecraft().displayGuiScreen(new GuiSciencePropertyMatcher());
		}
			else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModItems.LABELTRANSPARENT))) {
				Utils.getLogger().info("Label Transparent");
				labelName =handler.getStackInSlot(4).getDisplayName();
				handler.extractItem(4, 1, false);
				propertyType="Glass";
				labelType="Transparent";
				Minecraft.getMinecraft().displayGuiScreen(new GuiSciencePropertyMatcher());
		}
			else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModItems.LABELSPECTACLES))) {
				Utils.getLogger().info("Label Spectacles");
				labelName =handler.getStackInSlot(4).getDisplayName();
				handler.extractItem(4, 1, false);
				propertyType="Glass";
				labelType="Spectacles";
				Minecraft.getMinecraft().displayGuiScreen(new GuiSciencePropertyMatcher());
		}
			else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModItems.LABELWINDOWS))) {
				Utils.getLogger().info("Label Windows");
				labelName =handler.getStackInSlot(4).getDisplayName();
				handler.extractItem(4, 1, false);
				propertyType="Glass";
				labelType="Windows";
				Minecraft.getMinecraft().displayGuiScreen(new GuiSciencePropertyMatcher());
		}
			else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModItems.LABELBAGS))) {
				Utils.getLogger().info("Label Bags");
				labelName =handler.getStackInSlot(4).getDisplayName();
				handler.extractItem(4, 1, false);
				propertyType="Plastic";
				labelType="Bags";
				Minecraft.getMinecraft().displayGuiScreen(new GuiSciencePropertyMatcher());
		}
			else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModItems.LABELWATERPROOF))) {
				Utils.getLogger().info("Label Waterproof");
				labelName =handler.getStackInSlot(4).getDisplayName();
				handler.extractItem(4, 1, false);
				propertyType="Plastic";
				labelType="Waterproof";
				Minecraft.getMinecraft().displayGuiScreen(new GuiSciencePropertyMatcher());
		}
			else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModItems.LABELTOXICITY))) {
				Utils.getLogger().info("Label Toxicity");
				labelName =handler.getStackInSlot(4).getDisplayName();
				handler.extractItem(4, 1, false);
				propertyType="Plastic";
				labelType="Tocicity";
				Minecraft.getMinecraft().displayGuiScreen(new GuiSciencePropertyMatcher());
		}
			else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModItems.LABELACRYLIC))) {
				Utils.getLogger().info("Label Acrylic");
				labelName =handler.getStackInSlot(4).getDisplayName();
				handler.extractItem(4, 1, false);
				propertyType="Plastic";
				labelType="Acrylic";
				Minecraft.getMinecraft().displayGuiScreen(new GuiSciencePropertyMatcher());
		}
			else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModItems.LABELPVC))) {
				Utils.getLogger().info("Label PVC");
				labelName =handler.getStackInSlot(4).getDisplayName();
				handler.extractItem(4, 1, false);
				propertyType="Plastic";
				labelType="PVC";
				Minecraft.getMinecraft().displayGuiScreen(new GuiSciencePropertyMatcher());
		}
			else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModItems.LABELCELLOPHANE))) {
				Utils.getLogger().info("Label Cellophane");
				labelName =handler.getStackInSlot(4).getDisplayName();
				handler.extractItem(4, 1, false);
				propertyType="Plastic";
				labelType="Cellophane";
				Minecraft.getMinecraft().displayGuiScreen(new GuiSciencePropertyMatcher());
		}
			else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModItems.LABELPOLYTHENE))) {
				Utils.getLogger().info("Label Polythene");
				labelName =handler.getStackInSlot(4).getDisplayName();
				handler.extractItem(4, 1, false);
				propertyType="Plastic";
				labelType="Polythene";
				Minecraft.getMinecraft().displayGuiScreen(new GuiSciencePropertyMatcher());
		}
			else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModItems.LABELANTISTATIC))) {
				Utils.getLogger().info("Label Antistatic");
				labelName =handler.getStackInSlot(4).getDisplayName();
				handler.extractItem(4, 1, false);
				propertyType="Ceramic";
				labelType="Antistatic";
				Minecraft.getMinecraft().displayGuiScreen(new GuiSciencePropertyMatcher());
		}
			else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModItems.LABELPOTTERY))) {
				Utils.getLogger().info("Label Pottery");
				labelName =handler.getStackInSlot(4).getDisplayName();
				handler.extractItem(4, 1, false);
				propertyType="Ceramic";
				labelType="Pottery";
				Minecraft.getMinecraft().displayGuiScreen(new GuiSciencePropertyMatcher());
		}
			else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModItems.LABELMUGS))) {
				Utils.getLogger().info("Label Mugs");
				labelName =handler.getStackInSlot(4).getDisplayName();
				handler.extractItem(4, 1, false);
				propertyType="Ceramic";
				labelType="Mugs";
				Minecraft.getMinecraft().displayGuiScreen(new GuiSciencePropertyMatcher());
		}
			
			
			}
			
		
			}
		
		}


