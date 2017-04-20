package com.maw79.mods.items.mathsitems;

import com.google.common.collect.Sets;
import com.maw79.mods.client.gui.GuiTutorial;
import com.maw79.mods.handlers.AchievementHandler;
import com.maw79.mods.handlers.ModSoundHandler;
import com.maw79.mods.init.ModBlocks;
import com.maw79.mods.init.ModFractionsBlocks;
import com.maw79.mods.init.ModItems;
import com.maw79.mods.init.ModTools;
import com.maw79.mods.main.Maw79Mod;
import com.maw79.mods.main.Reference;
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
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;

import java.util.List;
import java.util.Set;

public class ItemQuestionWand extends ItemTool {
	
	private static final Set<Block> EFFECTIVE_BLOCKS = Sets.newHashSet(new Block[] { });

    public ItemQuestionWand(ToolMaterial material, String unlocalizedName) {
    	super(material, EFFECTIVE_BLOCKS);
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(Reference.MOD_ID, unlocalizedName));
		this.setCreativeTab(Maw79Mod.items);
		//this.setMaxDamage(5);
		
    }
    
    @Override
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
        tooltip.add(I18n.format("tooltip.fractionshalf"));
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
    
   
    @Override
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity){
    	player.sendMessage(new TextComponentString("I am Just a left click "));
    World world = Minecraft.getMinecraft().world;
    //BlockPos pos = Blockpos ;
   BlockPos pos = entity.getPosition();
    
    	if(world.getBlockState(pos).getBlock() == ModFractionsBlocks.HALF){
			player.sendMessage(new TextComponentString("I am : "+ ModFractionsBlocks.HALF.getLocalizedName()));
		}
    	return true;
    }
    

   
    @Override
    public EnumActionResult onItemUse(EntityPlayer playerIn, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
    	// if(!playerIn.hasAchievement(AchievementHandler.achievementPainter)){
        // 	playerIn.addStat(AchievementHandler.achievementPainter);
        // }
    	Block block;
    	if(playerIn.isSneaking()){
    	if (!world.isRemote) {
    		//block = world.getBlockState(pos).getBlock();
    		//	playerIn.sendMessage(new TextComponentString("I am : "+ block.getLocalizedName()));
    		
    		
    	 if (world.getBlockState(pos).getBlock() == ModFractionsBlocks.HALF){
    		 playerIn.sendMessage(new TextComponentString("A Huge Pizza is cut into 24 slices. You eat "+"§a"+ "12 "+"§r"+"slices. \n\nWhat fraction of the Pizza did you eat?"));
    	}
    	 
    	 else if (world.getBlockState(pos).getBlock() == ModFractionsBlocks.TWOFOURTHS){
    		 playerIn.sendMessage(new TextComponentString("Farmer Joe had 4 Chickens. He sold "+"§a"+ "2 "+"§r"+"leaving him with "+"§a"+ "2"+"§r"+  ".\n\nWhat fraction of Chickens were sold?"));
    	}
    	 else if (world.getBlockState(pos).getBlock() == ModFractionsBlocks.THREESIXTHS){
    		 playerIn.sendMessage(new TextComponentString("Farmer Joe has "+"§a"+ "6 "+"§r"+"Cows. He only has enough Cow feed for\n"+"§a"+ "3"+"§r"+ " of them.\n\nWhat fraction of the cows can he feed?"));
    	}
    	 else if (world.getBlockState(pos).getBlock() == ModFractionsBlocks.HALFDECIMAL){
    		 playerIn.sendMessage(new TextComponentString("Farmer Joe has "+"§a"+ "9 Points."+"§r"+ " He kindly shares the points with you. \nHe gives you "+"§a"+ "4.5 Points"+"§r"+ "\n\nWhat fraction of the points did he share with you?"));
    	}
    	 if (world.getBlockState(pos).getBlock() == ModFractionsBlocks.FIFTY100){
    		 playerIn.sendMessage(new TextComponentString("You score "+"§a"+ "500 "+"§r"+ "Out of a possible "+"§a"+ "1000 Points. "+"§r"+"\nWhat Fraction of the points did you earn?"));
    	}
    	 else {
    		 //block = world.getBlockState(pos).getBlock();
    		 //playerIn.sendMessage(new TextComponentString("I am : "+ block.getLocalizedName()));
    	 }
 		
    	}
    	}
    			
    	if(!playerIn.isSneaking()){		
    	  if (world.getBlockState(pos).getBlock() == ModFractionsBlocks.HALF) {
    		playerIn.playSound(ModSoundHandler.MAWSOUND_CORRECT, 3.0F, 1.0F);
    		 world.setBlockState(pos, ModFractionsBlocks.CORRECT.getDefaultState());
        	//world.newExplosion(playerIn, pos.getX(), pos.getY(), pos.getZ(), 0.5F, false, true);
           // playerIn.inventory.getCurrentItem().damageItem(1, playerIn );
            return EnumActionResult.SUCCESS;
        }
    	else   if (world.getBlockState(pos).getBlock() == ModFractionsBlocks.TWOFOURTHS) {
    		playerIn.playSound(ModSoundHandler.MAWSOUND_CORRECT, 3.0F, 1.0F);
    		 world.setBlockState(pos, ModFractionsBlocks.CORRECT.getDefaultState());
        	//world.newExplosion(playerIn, pos.getX(), pos.getY(), pos.getZ(), 0.5F, false, true);
           // playerIn.inventory.getCurrentItem().damageItem(1, playerIn );
            return EnumActionResult.SUCCESS;
        }
    	  
    	else   if (world.getBlockState(pos).getBlock() == ModFractionsBlocks.THREESIXTHS) {
    		playerIn.playSound(ModSoundHandler.MAWSOUND_CORRECT, 3.0F, 1.0F);
    		 world.setBlockState(pos, ModFractionsBlocks.CORRECT.getDefaultState());
        	//world.newExplosion(playerIn, pos.getX(), pos.getY(), pos.getZ(), 0.5F, false, true);
           // playerIn.inventory.getCurrentItem().damageItem(1, playerIn );
            return EnumActionResult.SUCCESS;
        }
    	else   if (world.getBlockState(pos).getBlock() == ModFractionsBlocks.HALFDECIMAL) {
    		playerIn.playSound(ModSoundHandler.MAWSOUND_CORRECT, 3.0F, 1.0F);
    		 world.setBlockState(pos, ModFractionsBlocks.CORRECT.getDefaultState());
        	//world.newExplosion(playerIn, pos.getX(), pos.getY(), pos.getZ(), 0.5F, false, true);
           // playerIn.inventory.getCurrentItem().damageItem(1, playerIn );
            return EnumActionResult.SUCCESS;
        }
    	  
    	else   if (world.getBlockState(pos).getBlock() == ModFractionsBlocks.FIFTY100) {
    		playerIn.playSound(ModSoundHandler.MAWSOUND_CORRECT, 3.0F, 1.0F);
    		 world.setBlockState(pos, ModFractionsBlocks.CORRECT.getDefaultState());
        	
            return EnumActionResult.SUCCESS;
        }
    	

    	}
        
        return EnumActionResult.PASS;
    }
    	

  
   

   
 
}
