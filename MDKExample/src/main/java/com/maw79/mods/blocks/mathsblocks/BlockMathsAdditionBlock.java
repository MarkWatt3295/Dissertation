package com.maw79.mods.blocks.mathsblocks;

import com.maw79.mods.client.gui.GuiMathsMultiplicationBlock1;
import com.maw79.mods.client.gui.mathsgui.GuiAdditionBlock;
import com.maw79.mods.client.gui.mathsgui.GuiMathsTest;
import com.maw79.mods.client.gui.mathsgui.GuiSubtractionBlock;
import com.maw79.mods.handlers.ModSoundHandler;
import com.maw79.mods.main.Reference;
import com.maw79.mods.util.Utilities;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class BlockMathsAdditionBlock extends Block {
	
	public boolean blockanswered;
	
	public BlockMathsAdditionBlock(String unlocalizedName) {
		super(Material.CLOTH);
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(Reference.MOD_ID, unlocalizedName));
		this.setHardness(1);
		this.setResistance(1);
		
		
		
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
			
		worldIn.playSound(player, pos, ModSoundHandler.MAWSOUND_COIN, SoundCategory.BLOCKS, 1.0F, 1.0F);
		if(!player.world.isRemote){
			
			Minecraft.getMinecraft().displayGuiScreen(new GuiAdditionBlock());
			this.blockanswered = true;
		}
		
		
		return true;
	}
	
	
	}
