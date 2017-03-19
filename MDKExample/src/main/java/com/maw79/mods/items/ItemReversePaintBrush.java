package com.maw79.mods.items;

import com.google.common.collect.Sets;
import com.maw79.mods.client.gui.GuiTutorial;
import com.maw79.mods.handlers.AchievementHandler;
import com.maw79.mods.handlers.ModSoundHandler;
import com.maw79.mods.init.ModBlocks;
import com.maw79.mods.init.ModItems;
import com.maw79.mods.init.ModTools;
import com.maw79.mods.main.Maw79Mod;
import com.maw79.mods.main.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;

import java.util.List;
import java.util.Set;

public class ItemReversePaintBrush extends Item {
	
	

    public ItemReversePaintBrush(String unlocalizedName) {
    	
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(Reference.MOD_ID, unlocalizedName));
		this.setCreativeTab(Maw79Mod.debug);
       
    }
    

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer player, EnumHand hand) {
        if (!worldIn.isRemote) {
           // player.sendMessage(new TextComponentString("Right clicked PB"));
        	//player.inventory.getCurrentItem().damageItem(1, player );
			
        }
     

        return super.onItemRightClick(worldIn, player, hand);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer playerIn, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
    	 if(!playerIn.hasAchievement(AchievementHandler.achievementPainter)){
         	playerIn.addStat(AchievementHandler.achievementPainter);
         }
    	if (world.getBlockState(pos).getBlock() == ModBlocks.mathblockblue) {
            world.setBlockState(pos, ModBlocks.mathtextblockblue.getDefaultState());
            playerIn.playSound(ModSoundHandler.MAWSOUND_SQUELCH, 3.0F, 3.0F);
            
            return EnumActionResult.SUCCESS;
        }else   if (world.getBlockState(pos).getBlock() == ModBlocks.mathblockbrown) {
            world.setBlockState(pos, ModBlocks.mathtextblockbrown.getDefaultState());
            playerIn.playSound(ModSoundHandler.MAWSOUND_SQUELCH, 1.0F, 1.0F);
            
            return EnumActionResult.SUCCESS;
        }
        else   if (world.getBlockState(pos).getBlock() == ModBlocks.mathblockaqua) {
            world.setBlockState(pos, ModBlocks.mathtextblockaqua.getDefaultState());
            playerIn.playSound(ModSoundHandler.MAWSOUND_SQUELCH, 1.0F, 1.0F);
           
            return EnumActionResult.SUCCESS;
        }
        else   if (world.getBlockState(pos).getBlock() == ModBlocks.mathblockgreen) {
            world.setBlockState(pos, ModBlocks.mathtextblockgreen.getDefaultState());
            playerIn.playSound(ModSoundHandler.MAWSOUND_SQUELCH, 1.0F, 1.0F);
          
            return EnumActionResult.SUCCESS;
        }
        else   if (world.getBlockState(pos).getBlock() == ModBlocks.mathblockpeach) {
            world.setBlockState(pos, ModBlocks.mathtextblockpeach.getDefaultState());
            playerIn.playSound(ModSoundHandler.MAWSOUND_SQUELCH, 1.0F, 1.0F);
          
            return EnumActionResult.SUCCESS;
        }
        else   if (world.getBlockState(pos).getBlock() == ModBlocks.mathblockwhite) {
            world.setBlockState(pos, ModBlocks.mathtextblockwhite.getDefaultState());
            playerIn.playSound(ModSoundHandler.MAWSOUND_SQUELCH, 1.0F, 1.0F);
          
            return EnumActionResult.SUCCESS;
        }
        else   if (world.getBlockState(pos).getBlock() == ModBlocks.mathblockgold) {
            world.setBlockState(pos, ModBlocks.mathtextblockgold.getDefaultState());
            playerIn.playSound(ModSoundHandler.MAWSOUND_SQUELCH, 1.0F, 1.0F);
           
            return EnumActionResult.SUCCESS;
        }
        else   if (world.getBlockState(pos).getBlock() == ModBlocks.mathblockmarrowbrown) {
            world.setBlockState(pos, ModBlocks.mathtextblockmarrowbrown.getDefaultState());
            playerIn.playSound(ModSoundHandler.MAWSOUND_SQUELCH, 1.0F, 1.0F);
          
            return EnumActionResult.SUCCESS;
        }
        else   if (world.getBlockState(pos).getBlock() == ModBlocks.mathblockgrey) {
            world.setBlockState(pos, ModBlocks.mathtextblockgrey.getDefaultState());
            playerIn.playSound(ModSoundHandler.MAWSOUND_SQUELCH, 1.0F, 1.0F);
         
            return EnumActionResult.SUCCESS;
        }
        else   if (world.getBlockState(pos).getBlock() == ModBlocks.mathblocklightorange) {
            world.setBlockState(pos, ModBlocks.mathtextblocklightorange.getDefaultState());
            playerIn.playSound(ModSoundHandler.MAWSOUND_SQUELCH, 1.0F, 1.0F);
         
            return EnumActionResult.SUCCESS;
        }
        else   if (world.getBlockState(pos).getBlock() == ModBlocks.mathblockorange) {
            world.setBlockState(pos, ModBlocks.mathtextblockorange.getDefaultState());
            playerIn.playSound(ModSoundHandler.MAWSOUND_SQUELCH, 1.0F, 1.0F);
          
            return EnumActionResult.SUCCESS;
        }
        else   if (world.getBlockState(pos).getBlock() == ModBlocks.mathblockblack) {
            world.setBlockState(pos, ModBlocks.mathtextblockblack.getDefaultState());
            playerIn.playSound(ModSoundHandler.MAWSOUND_SQUELCH, 1.0F, 1.0F);
         
            return EnumActionResult.SUCCESS;
        }
        return EnumActionResult.PASS;
    }

  
    

    
    @Override
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
        tooltip.add("ReversePaintbrush");
        super.addInformation(stack, playerIn, tooltip, advanced);
    }

    @Override
    public void setDamage(ItemStack stack, int damage) {
    	
    	super.setDamage(stack, damage);
    }
    
    public  ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player){
     itemstack.damageItem(1, player);
    System.out.println("Item stack damage called");
return itemstack;
}
}
