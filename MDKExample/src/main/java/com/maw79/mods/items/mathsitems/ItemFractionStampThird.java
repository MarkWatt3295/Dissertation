package com.maw79.mods.items.mathsitems;

import com.google.common.collect.Sets;
import com.maw79.mods.blocks.pointsblocks.TileEntityPointsBlock;
import com.maw79.mods.client.gui.GuiNotif;
import com.maw79.mods.handlers.ModSoundHandler;
import com.maw79.mods.init.ModFractionsBlocks;
import com.maw79.mods.main.Maw79Mod;
import com.maw79.mods.main.Reference;
import com.maw79.mods.util.Utils;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import java.util.List;
import java.util.Set;

public class ItemFractionStampThird extends ItemTool {
	
	private int maxminus = 100;
	
	private static final Set<Block> EFFECTIVE_BLOCKS = Sets.newHashSet(new Block[] { });

    public ItemFractionStampThird(ToolMaterial material, String unlocalizedName) {
    	super(material, EFFECTIVE_BLOCKS);
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(Reference.MOD_ID, unlocalizedName));
		this.setCreativeTab(Maw79Mod.items);
		//this.setMaxDamage(5);
		
    }
    
    /**
     * Tool tip
     */
    @Override
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
    	super.addInformation(stack, playerIn, tooltip, advanced);
    	tooltip.add(TextFormatting.YELLOW + Utils.getLang().localize("fractionthirdstamp.tooltip"));
    }

   
    public void pointAddition(){
    	EntityPlayer player = Minecraft.getMinecraft().player;
    	TileEntityPointsBlock.playerScore +=10;
    	
    	if(maxminus < 100){
			 maxminus += 10;
			 Utils.getLogger().info("(Plus)Maxminus is: "+maxminus);
		 
    	}
    }

    public void pointSubtraction(){ //Used to stop high Negative points
    EntityPlayer player = Minecraft.getMinecraft().player;
    	
    	if(maxminus >= 10){
    		TileEntityPointsBlock.playerScore -=10;
			 maxminus -= 10;
			 Utils.getLogger().info("(Minus)Maxminus is: "+maxminus);
		 }
    }
    

   
    @Override
    public EnumActionResult onItemUse(EntityPlayer playerIn, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
    	// if(!playerIn.hasAchievement(AchievementHandler.achievementPainter)){
        // 	playerIn.addStat(AchievementHandler.achievementPainter);
        // }
   
    		
    	if(!playerIn.isSneaking()){		
    	  if (world.getBlockState(pos).getBlock() == ModFractionsBlocks.THIRD_1) {
    		playerIn.playSound(ModSoundHandler.MAWSOUND_CORRECT, 3.0F, 1.0F);
    		 world.setBlockState(pos, ModFractionsBlocks.CORRECT.getDefaultState());
    		 playerIn.inventory.getCurrentItem().damageItem(1, playerIn );
    		pointAddition();
    		 if(!playerIn.world.isRemote){
   				TileEntityPointsBlock.thirdscorrect-=1;
   	    		}
            return EnumActionResult.SUCCESS;
        }
    	else   if (world.getBlockState(pos).getBlock() == ModFractionsBlocks.THIRD_2) {
    		playerIn.playSound(ModSoundHandler.MAWSOUND_CORRECT, 3.0F, 1.0F);
    		 world.setBlockState(pos, ModFractionsBlocks.CORRECT.getDefaultState());
    		 playerIn.inventory.getCurrentItem().damageItem(1, playerIn );
    		 pointAddition();
    		 if(!playerIn.world.isRemote){
   				TileEntityPointsBlock.thirdscorrect-=1;
   	    		}
            return EnumActionResult.SUCCESS;
        }
    	  
    	else   if (world.getBlockState(pos).getBlock() == ModFractionsBlocks.THIRD_3) {
    		playerIn.playSound(ModSoundHandler.MAWSOUND_CORRECT, 3.0F, 1.0F);
    		 world.setBlockState(pos, ModFractionsBlocks.CORRECT.getDefaultState());
    		 playerIn.inventory.getCurrentItem().damageItem(1, playerIn );
    		 pointAddition();
    		 if(!playerIn.world.isRemote){
   				TileEntityPointsBlock.thirdscorrect-=1;
   	    		}
            return EnumActionResult.SUCCESS;
        }
    	else   if (world.getBlockState(pos).getBlock() == ModFractionsBlocks.THIRD_4) {
    		playerIn.playSound(ModSoundHandler.MAWSOUND_CORRECT, 3.0F, 1.0F);
    		 world.setBlockState(pos, ModFractionsBlocks.CORRECT.getDefaultState());
    		 playerIn.inventory.getCurrentItem().damageItem(1, playerIn );
    		 pointAddition();
    		 if(!playerIn.world.isRemote){
   				TileEntityPointsBlock.thirdscorrect-=1;
   	    		}
            return EnumActionResult.SUCCESS;
        }
    	  
    	else   if (world.getBlockState(pos).getBlock() == ModFractionsBlocks.THIRD_5) {
    		playerIn.playSound(ModSoundHandler.MAWSOUND_CORRECT, 3.0F, 1.0F);
    		 world.setBlockState(pos, ModFractionsBlocks.CORRECT.getDefaultState());
    		 playerIn.inventory.getCurrentItem().damageItem(1, playerIn );
    		 pointAddition();
    		 if(!playerIn.world.isRemote){
  				TileEntityPointsBlock.thirdscorrect-=1;
  	    		}
            return EnumActionResult.SUCCESS;
        }
    	  
    	
    
    	  //HALFS
    	  if (world.getBlockState(pos).getBlock() == ModFractionsBlocks.HALF_1) {
    		playerIn.playSound(ModSoundHandler.MAWSOUND_INCORRECT, 3.0F, 1.0F);
    		 playerIn.inventory.getCurrentItem().damageItem(1, playerIn );
    		 pointSubtraction();
            return EnumActionResult.SUCCESS;
        }
    	else   if (world.getBlockState(pos).getBlock() == ModFractionsBlocks.HALF_2) {
    		playerIn.playSound(ModSoundHandler.MAWSOUND_INCORRECT, 3.0F, 1.0F);
    		 playerIn.inventory.getCurrentItem().damageItem(1, playerIn );
    		 pointSubtraction();
            return EnumActionResult.SUCCESS;
        }
    	else   if (world.getBlockState(pos).getBlock() == ModFractionsBlocks.HALF_3) {
    		playerIn.playSound(ModSoundHandler.MAWSOUND_INCORRECT, 3.0F, 1.0F);
    		 playerIn.inventory.getCurrentItem().damageItem(1, playerIn );
    		 pointSubtraction();
            return EnumActionResult.SUCCESS;
        }
    	else   if (world.getBlockState(pos).getBlock() == ModFractionsBlocks.HALF_4) {
    		playerIn.playSound(ModSoundHandler.MAWSOUND_INCORRECT, 3.0F, 1.0F);
    		 playerIn.inventory.getCurrentItem().damageItem(1, playerIn );
    		 pointSubtraction();
            return EnumActionResult.SUCCESS;
        }
    	else   if (world.getBlockState(pos).getBlock() == ModFractionsBlocks.HALF_5) {
    		playerIn.playSound(ModSoundHandler.MAWSOUND_INCORRECT, 3.0F, 1.0F);
    		 playerIn.inventory.getCurrentItem().damageItem(1, playerIn );
    		 pointSubtraction();
            return EnumActionResult.SUCCESS;
        }
    	  
    	 //QUARTER
    	else   if (world.getBlockState(pos).getBlock() == ModFractionsBlocks.QUARTER_1) {
    		playerIn.playSound(ModSoundHandler.MAWSOUND_INCORRECT, 3.0F, 1.0F);
    		 playerIn.inventory.getCurrentItem().damageItem(1, playerIn );
    		 pointSubtraction();
            return EnumActionResult.SUCCESS;
        }
    	 
    	else   if (world.getBlockState(pos).getBlock() == ModFractionsBlocks.QUARTER_2) {
    		playerIn.playSound(ModSoundHandler.MAWSOUND_INCORRECT, 3.0F, 1.0F);
    		 playerIn.inventory.getCurrentItem().damageItem(1, playerIn );
    		 pointSubtraction();
            return EnumActionResult.SUCCESS;
        }
    	else   if (world.getBlockState(pos).getBlock() == ModFractionsBlocks.QUARTER_3) {
    		playerIn.playSound(ModSoundHandler.MAWSOUND_INCORRECT, 3.0F, 1.0F);
    		 playerIn.inventory.getCurrentItem().damageItem(1, playerIn );
    		 pointSubtraction();
            return EnumActionResult.SUCCESS;
        }
    	else   if (world.getBlockState(pos).getBlock() == ModFractionsBlocks.QUARTER_4) {
    		playerIn.playSound(ModSoundHandler.MAWSOUND_INCORRECT, 3.0F, 1.0F);
    		 playerIn.inventory.getCurrentItem().damageItem(1, playerIn );
    		 pointSubtraction();
            return EnumActionResult.SUCCESS;
        }
    	else   if (world.getBlockState(pos).getBlock() == ModFractionsBlocks.QUARTER_5) {
    		playerIn.playSound(ModSoundHandler.MAWSOUND_INCORRECT, 3.0F, 1.0F);
    		 playerIn.inventory.getCurrentItem().damageItem(1, playerIn );
    		 pointSubtraction();
            return EnumActionResult.SUCCESS;
        }
    	 
    	}
    	
    	  return EnumActionResult.PASS;
    }
    	

    	
    
    	

  
   

   
 
}
