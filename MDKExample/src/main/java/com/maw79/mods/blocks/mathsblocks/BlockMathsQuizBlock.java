package com.maw79.mods.blocks.mathsblocks;

import com.maw79.mods.client.gui.GuiMathsMultiplicationBlock1;
import com.maw79.mods.handlers.ModSoundHandler;
import com.maw79.mods.main.Maw79Mod;
import com.maw79.mods.util.Utilities;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class BlockMathsQuizBlock extends BlockMathsQuestionBlock{

	public BlockMathsQuizBlock(String unlocalizedName) {
		super(unlocalizedName);
		this.setCreativeTab(Maw79Mod.mathsblocks);
		
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		//if(this.blockanswered == false){		
		worldIn.playSound(player, pos, ModSoundHandler.MAWSOUND_COIN, SoundCategory.BLOCKS, 5.0F, 5.0F);
		if(!player.world.isRemote){
			player.sendMessage(new TextComponentString("Maths Question"));
			Minecraft.getMinecraft().displayGuiScreen(new GuiMathsMultiplicationBlock1());
			this.blockanswered = true;
		}
		//}
		//else if(this.blockanswered == true){
		//	player.sendMessage(new TextComponentString(Utilities.stringToGolden("This Block Has been attempted", 5, true)));
		//}
		
		return true;

}
	
}
