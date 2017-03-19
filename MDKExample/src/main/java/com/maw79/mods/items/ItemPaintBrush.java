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

public class ItemPaintBrush extends ItemTool {
	
	private static final Set<Block> EFFECTIVE_BLOCKS = Sets.newHashSet(new Block[] {});

    public ItemPaintBrush(ToolMaterial material, String unlocalizedName) {
    	super(material, EFFECTIVE_BLOCKS);
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(Reference.MOD_ID, unlocalizedName));
		this.setCreativeTab(Maw79Mod.items);
		//this.setMaxDamage(5);
		
		
			
		
       
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
    	if (world.getBlockState(pos).getBlock() == ModBlocks.mathtextblockblue) {
            world.setBlockState(pos, ModBlocks.mathblockblue.getDefaultState());
            playerIn.playSound(ModSoundHandler.MAWSOUND_SQUELCH, 1.0F, 1.0F);
            playerIn.inventory.getCurrentItem().damageItem(1, playerIn );
            return EnumActionResult.SUCCESS;
        }else   if (world.getBlockState(pos).getBlock() == ModBlocks.mathtextblockbrown) {
            world.setBlockState(pos, ModBlocks.mathblockbrown.getDefaultState());
            playerIn.playSound(ModSoundHandler.MAWSOUND_SQUELCH, 1.0F, 1.0F);
            playerIn.inventory.getCurrentItem().damageItem(1, playerIn );
            return EnumActionResult.SUCCESS;
        }
        else   if (world.getBlockState(pos).getBlock() == ModBlocks.mathtextblockaqua) {
            world.setBlockState(pos, ModBlocks.mathblockaqua.getDefaultState());
            playerIn.playSound(ModSoundHandler.MAWSOUND_SQUELCH, 1.0F, 1.0F);
            playerIn.inventory.getCurrentItem().damageItem(1, playerIn );
            return EnumActionResult.SUCCESS;
        }
        else   if (world.getBlockState(pos).getBlock() == ModBlocks.mathtextblockgreen) {
            world.setBlockState(pos, ModBlocks.mathblockgreen.getDefaultState());
            playerIn.playSound(ModSoundHandler.MAWSOUND_SQUELCH, 1.0F, 1.0F);
            playerIn.inventory.getCurrentItem().damageItem(1, playerIn );
            return EnumActionResult.SUCCESS;
        }
        else   if (world.getBlockState(pos).getBlock() == ModBlocks.mathtextblockpeach) {
            world.setBlockState(pos, ModBlocks.mathblockpeach.getDefaultState());
            playerIn.playSound(ModSoundHandler.MAWSOUND_SQUELCH, 1.0F, 1.0F);
            playerIn.inventory.getCurrentItem().damageItem(1, playerIn );
            return EnumActionResult.SUCCESS;
        }
        else   if (world.getBlockState(pos).getBlock() == ModBlocks.mathtextblockwhite) {
            world.setBlockState(pos, ModBlocks.mathblockwhite.getDefaultState());
            playerIn.playSound(ModSoundHandler.MAWSOUND_SQUELCH, 1.0F, 1.0F);
            playerIn.inventory.getCurrentItem().damageItem(1, playerIn );
            return EnumActionResult.SUCCESS;
        }
        else   if (world.getBlockState(pos).getBlock() == ModBlocks.mathtextblockgold) {
            world.setBlockState(pos, ModBlocks.mathblockgold.getDefaultState());
            playerIn.playSound(ModSoundHandler.MAWSOUND_SQUELCH, 1.0F, 1.0F);
            playerIn.inventory.getCurrentItem().damageItem(1, playerIn );
            return EnumActionResult.SUCCESS;
        }
        else   if (world.getBlockState(pos).getBlock() == ModBlocks.mathtextblockmarrowbrown) {
            world.setBlockState(pos, ModBlocks.mathblockmarrowbrown.getDefaultState());
            playerIn.playSound(ModSoundHandler.MAWSOUND_SQUELCH, 1.0F, 1.0F);
            playerIn.inventory.getCurrentItem().damageItem(1, playerIn );
            return EnumActionResult.SUCCESS;
        }
        else   if (world.getBlockState(pos).getBlock() == ModBlocks.mathtextblockgrey) {
            world.setBlockState(pos, ModBlocks.mathblockgrey.getDefaultState());
            playerIn.playSound(ModSoundHandler.MAWSOUND_SQUELCH, 1.0F, 1.0F);
            playerIn.inventory.getCurrentItem().damageItem(1, playerIn );
            return EnumActionResult.SUCCESS;
        }
        else   if (world.getBlockState(pos).getBlock() == ModBlocks.mathtextblocklightorange) {
            world.setBlockState(pos, ModBlocks.mathblocklightorange.getDefaultState());
            playerIn.playSound(ModSoundHandler.MAWSOUND_SQUELCH, 1.0F, 1.0F);
            playerIn.inventory.getCurrentItem().damageItem(1, playerIn );
            return EnumActionResult.SUCCESS;
        }
        else   if (world.getBlockState(pos).getBlock() == ModBlocks.mathtextblockorange) {
            world.setBlockState(pos, ModBlocks.mathblockorange.getDefaultState());
            playerIn.playSound(ModSoundHandler.MAWSOUND_SQUELCH, 1.0F, 1.0F);
            playerIn.inventory.getCurrentItem().damageItem(1, playerIn );
            return EnumActionResult.SUCCESS;
        }
        else   if (world.getBlockState(pos).getBlock() == ModBlocks.mathtextblockblack) {
            world.setBlockState(pos, ModBlocks.mathblockblack.getDefaultState());
            playerIn.playSound(ModSoundHandler.MAWSOUND_SQUELCH, 1.0F, 1.0F);
            playerIn.inventory.getCurrentItem().damageItem(1, playerIn );
            return EnumActionResult.SUCCESS;
        }
        return EnumActionResult.PASS;
    }

  
    

    
    @Override
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
        tooltip.add("Paintbrush");
        super.addInformation(stack, playerIn, tooltip, advanced);
    }

   
    
  /*  public  ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player){
     itemstack.damageItem(1, player);
    System.out.println("Item stack damage called");
return itemstack;
}*/
}
