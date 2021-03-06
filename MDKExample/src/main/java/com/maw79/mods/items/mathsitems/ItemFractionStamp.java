package com.maw79.mods.items.mathsitems;

import com.google.common.collect.Sets;
import com.maw79.mods.blocks.mathsblocks.recycler.TileEntityRecycler;
import com.maw79.mods.blocks.pointsblocks.TileEntityPointsBlock;
import com.maw79.mods.client.gui.GuiNotif;
import com.maw79.mods.client.gui.GuiTutorial;
import com.maw79.mods.handlers.AchievementHandler;
import com.maw79.mods.handlers.ModSoundHandler;
import com.maw79.mods.init.ModBlocks;
import com.maw79.mods.init.ModFractionsBlocks;
import com.maw79.mods.init.ModItems;
import com.maw79.mods.init.ModTools;
import com.maw79.mods.main.Maw79Mod;
import com.maw79.mods.main.Reference;
import com.maw79.mods.network.MathsQuestManualMessage;
import com.maw79.mods.network.PlayerPointsPlus20Message;
import com.maw79.mods.util.Utils;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;
import java.util.Set;

public class ItemFractionStamp extends ItemTool {
	
	private int maxminus = 100;
	
	private static final Set<Block> EFFECTIVE_BLOCKS = Sets.newHashSet(new Block[] { });

    public ItemFractionStamp(ToolMaterial material, String unlocalizedName) {
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
    	tooltip.add(TextFormatting.WHITE + Utils.getLang().localize("fractionhalfstamp.tooltip"));
    }

    /*
    @Override
	public void onUpdate(ItemStack itemstack, World world, Entity entity, int par4, boolean par5) {
		int i = (int) entity.posX;
		int j = (int) entity.posY;
		int k = (int) entity.posZ;

		if (true) {
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.SPEED, 2, 1));
		}

	}
   /* @Override
	public void onUsingTick(ItemStack itemstack, EntityLivingBase entity, int count) {
		World world = entity.world;
		int i = (int) entity.posX;
		int j = (int) entity.posY;
		int k = (int) entity.posZ;

		if (true) {
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 2, 2));
		}

	}*/

    /*
    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
    	if(!player.isSneaking()){
    	//	BlockPos pos = world.getblo;
    	
           // player.sendMessage(new TextComponentString("Right clicked PB"));
        	//player.inventory.getCurrentItem().damageItem(1, player );
    	
        }
     

        return super.onItemRightClick(world, player, hand);
    }*/
    

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
    	  if (world.getBlockState(pos).getBlock() == ModFractionsBlocks.HALF_1) {
    		playerIn.playSound(ModSoundHandler.MAWSOUND_CORRECT, 3.0F, 1.0F);
    		 world.setBlockState(pos, ModFractionsBlocks.CORRECT.getDefaultState());
        	//world.newExplosion(playerIn, pos.getX(), pos.getY(), pos.getZ(), 0.5F, false, true);
    		 playerIn.inventory.getCurrentItem().damageItem(1, playerIn );
    		pointAddition();
    		if(!playerIn.world.isRemote){
    		 TileEntityPointsBlock.halfscorrect-=1;
    		}
            return EnumActionResult.SUCCESS;
        }
    	else   if (world.getBlockState(pos).getBlock() == ModFractionsBlocks.HALF_2) {
    		playerIn.playSound(ModSoundHandler.MAWSOUND_CORRECT, 3.0F, 1.0F);
    		 world.setBlockState(pos, ModFractionsBlocks.CORRECT.getDefaultState());
    		 playerIn.inventory.getCurrentItem().damageItem(1, playerIn );
    		 pointAddition();
    			if(!playerIn.world.isRemote){
    				TileEntityPointsBlock.halfscorrect-=1;
    	    		}
            return EnumActionResult.SUCCESS;
        }
    	  
    	else   if (world.getBlockState(pos).getBlock() == ModFractionsBlocks.HALF_3) {
    		playerIn.playSound(ModSoundHandler.MAWSOUND_CORRECT, 3.0F, 1.0F);
    		 world.setBlockState(pos, ModFractionsBlocks.CORRECT.getDefaultState());
    		 playerIn.inventory.getCurrentItem().damageItem(1, playerIn );
    		 pointAddition();
    			if(!playerIn.world.isRemote){
    				TileEntityPointsBlock.halfscorrect-=1;
    	    		}
            return EnumActionResult.SUCCESS;
        }
    	else   if (world.getBlockState(pos).getBlock() == ModFractionsBlocks.HALF_4) {
    		playerIn.playSound(ModSoundHandler.MAWSOUND_CORRECT, 3.0F, 1.0F);
    		 world.setBlockState(pos, ModFractionsBlocks.CORRECT.getDefaultState());
    		 playerIn.inventory.getCurrentItem().damageItem(1, playerIn );
    		 pointAddition();
    			if(!playerIn.world.isRemote){
    				TileEntityPointsBlock.halfscorrect-=1;

    	    		}
            return EnumActionResult.SUCCESS;
        }
    	  
    	else   if (world.getBlockState(pos).getBlock() == ModFractionsBlocks.HALF_5) {
    		playerIn.playSound(ModSoundHandler.MAWSOUND_CORRECT, 3.0F, 1.0F);
    		 world.setBlockState(pos, ModFractionsBlocks.CORRECT.getDefaultState());
    		 playerIn.inventory.getCurrentItem().damageItem(1, playerIn );
    		 pointAddition();
    			if(!playerIn.world.isRemote){
    				TileEntityPointsBlock.halfscorrect-=1;
    	    		}
            return EnumActionResult.SUCCESS;
        }
    	  
    
    	  //THIRDS
    	  if (world.getBlockState(pos).getBlock() == ModFractionsBlocks.THIRD_1) {
    		playerIn.playSound(ModSoundHandler.MAWSOUND_INCORRECT, 3.0F, 1.0F);
    		 playerIn.inventory.getCurrentItem().damageItem(1, playerIn );
    		 pointSubtraction();
            return EnumActionResult.SUCCESS;
        }
    	else   if (world.getBlockState(pos).getBlock() == ModFractionsBlocks.THIRD_2) {
    		playerIn.playSound(ModSoundHandler.MAWSOUND_INCORRECT, 3.0F, 1.0F);
    		 playerIn.inventory.getCurrentItem().damageItem(1, playerIn );
    		 pointSubtraction();
            return EnumActionResult.SUCCESS;
        }
    	else   if (world.getBlockState(pos).getBlock() == ModFractionsBlocks.THIRD_3) {
    		playerIn.playSound(ModSoundHandler.MAWSOUND_INCORRECT, 3.0F, 1.0F);
    		 playerIn.inventory.getCurrentItem().damageItem(1, playerIn );
    		 pointSubtraction();
            return EnumActionResult.SUCCESS;
        }
    	else   if (world.getBlockState(pos).getBlock() == ModFractionsBlocks.THIRD_4) {
    		playerIn.playSound(ModSoundHandler.MAWSOUND_INCORRECT, 3.0F, 1.0F);
    		 playerIn.inventory.getCurrentItem().damageItem(1, playerIn );
    		 pointSubtraction();
            return EnumActionResult.SUCCESS;
        }
    	else   if (world.getBlockState(pos).getBlock() == ModFractionsBlocks.THIRD_5) {
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
    	  
    	else   if (world.getBlockState(pos).getBlock() == ModFractionsBlocks.FAKE) {
    		world.newExplosion(playerIn, pos.getX(), pos.getY(), pos.getZ(), 0.5F, false, true);
    		 playerIn.inventory.getCurrentItem().damageItem(1, playerIn );
            return EnumActionResult.SUCCESS;
        }
    	 
    	}
    	
    	  return EnumActionResult.PASS;
    }
    	

    	
    
    	

  
   

   
 
}
