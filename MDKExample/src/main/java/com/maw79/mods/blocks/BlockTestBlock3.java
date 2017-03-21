package com.maw79.mods.blocks;

import com.maw79.mods.client.gui.GuiFirstBook;
import com.maw79.mods.client.gui.GuiSecondBook;
import com.maw79.mods.client.gui.GuiTutorial;
import com.maw79.mods.handlers.ModSoundHandler;
import com.maw79.mods.init.ModBlocks;
import com.maw79.mods.init.ModItems;
import com.maw79.mods.main.Reference;
import com.maw79.mods.util.Utilities;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.GameType;
import net.minecraft.world.World;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockTestBlock3 extends Block {
	
	
	/**
	 * Default constructor which sets the hardness and resistance
	 * @param unlocalizedName The unlocalized name
	 */
	public BlockTestBlock3(String unlocalizedName) {
		super(Material.IRON);
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(Reference.MOD_ID, unlocalizedName));
		this.setHardness(3);
		this.setResistance(20);
		this.setLightLevel(10F);
		
		
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
	
		
		
		worldIn.playSound(player, pos, ModSoundHandler.MAWSOUND_OPEN, SoundCategory.BLOCKS, 1.0F, 1.0F);
       
	//	player.sendMessage(new TextComponentString(Utilities.stringToRainbow("Test Block 2 Activated", true)));
		//player.inventory.addItemStackToInventory(new ItemStack(ModItems.mw));
		//player.setGameType(GameType.CREATIVE);
		//player.setNoGravity(false);
		//player.chasingPosZ= 40;
		//player.eyeHeight=10; Sets eye position
		//player.noClip = true; Nope
		//player.motionY = 1; 
		//player.motionX = -1; 
		//player.posZ += 80; NS
		//player.playSound(ModSoundHandler.MAWSOUND_OPEN, 1.0f, 1.0f);
		 if(!player.world.isRemote) player.sendMessage(new TextComponentString(Utilities.stringToRainbow("TestBlock 3 pressed", true)));
		
		//player.move(null, 2, 0, 0);
		// if(pressed == false){
		 Minecraft.getMinecraft().displayGuiScreen(new GuiTutorial());
		//Minecraft.getMinecraft().displayGuiScreen(new GuiMathsBlock());
		//while(blockreturn == false){
		//ClientCommandHandler.instance.executeCommand(Minecraft.getMinecraft().player, "sddf");
		
		 
		//if(gm.returns == "hello creator"){
		//	player.inventory.addItemStackToInventory(new ItemStack(ModBlocks.mathblockblue));
		//}
		
		
		//gm.GuiLoaded();
			//System.out.println("Im the while loop");
		//Minecraft.getMinecraft().currentScreen.onGuiClosed();
			//player.inventory.addItemStackToInventory(new ItemStack(ModBlocks.mathblockblue));
        	//player.inventory.addItemStackToInventory(new ItemStack(ModBlocks.mathblockgreen, 1));
		
		 //Minecraft.getMinecraft().currentScreen.onGuiClosed();
		//System.out.println("skipped me :(");
		
		
		return true; 
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		
		return true;
	}
	
	@Override
	public boolean canProvidePower(IBlockState state) {
		// TODO Auto-generated method stub
		return super.canProvidePower(state);
	}
	
	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY,
			float hitZ, int meta, EntityLivingBase placer) {
		// TODO Auto-generated method stub
		return super.getStateForPlacement(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer);
	}
	
	

}
