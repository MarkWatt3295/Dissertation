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
import net.minecraft.util.text.TextFormatting;
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
    
    /**
     * Tool tip
     */
    @Override
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
    	super.addInformation(stack, playerIn, tooltip, advanced);
    	tooltip.add(TextFormatting.GREEN + Utils.getLang().localize("questionwand.tooltip"));
    }

   
    @Override
    public EnumActionResult onItemUse(EntityPlayer playerIn, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
    	
    	if (!world.isRemote) {
    		
    		
    	 if (world.getBlockState(pos).getBlock() == ModFractionsBlocks.HALF_1){
    		 playerIn.sendMessage(new TextComponentString("A Pizza is cut into "+"§a"+ "20 "+"§r"+"slices. You eat "+"§a"+ "10 slices"+"§r"+".\n\nWhat fraction of the Pizza did you eat?"));
    	}
    	 
    	 else if (world.getBlockState(pos).getBlock() == ModFractionsBlocks.HALF_2){
    		 playerIn.sendMessage(new TextComponentString("Farmer Joe had "+"§a"+"48"+"§r"+" Chickens. He sold "+"§a"+ "24"+"§r"+",\nLeaving him with only "+"§a"+ "24"+"§r"+  ".\n\nWhat fraction of Chickens were sold?"));
    	}
    	 else if (world.getBlockState(pos).getBlock() == ModFractionsBlocks.HALF_3){
    		 playerIn.sendMessage(new TextComponentString("Farmer Joe has "+"§a"+ "6 "+"§r"+"Cows. He only has enough Cow feed for\n"+"§a"+ "3"+"§r"+ " of them.\n\nWhat fraction of the cows can he feed?"));
    	}
    	 else if (world.getBlockState(pos).getBlock() == ModFractionsBlocks.HALF_4){
    		 playerIn.sendMessage(new TextComponentString("Farmer Joe has "+"§a"+ "9 Points"+"§r"+ ". He kindly shares the points with you.\nHe gives you "+"§a"+ "4.5 Points"+"§r"+ "\n\nWhat fraction of the points did he share with you?"));
    	}
    	 else if (world.getBlockState(pos).getBlock() == ModFractionsBlocks.HALF_5){
    		 playerIn.sendMessage(new TextComponentString("You score "+"§a"+ "5 "+"§r"+ "Out of a possible "+"§a"+ "10 Points"+"§r"+".\nWhat Fraction of the points did you earn?"));
    	}
    	 
    	 //Quarter
    	 else if (world.getBlockState(pos).getBlock() == ModFractionsBlocks.QUARTER_1){
    		 playerIn.sendMessage(new TextComponentString("A Pizza is cut into "+"§a"+ "4 "+"§r"+ "slices. You eat "+"§a"+ "1 Slice. "+"§r"+"\nWhat Fraction of the Pizza did you eat?"));
    	}
    	 else if (world.getBlockState(pos).getBlock() == ModFractionsBlocks.QUARTER_2){
    		 playerIn.sendMessage(new TextComponentString("You have "+"§a"+ "8 "+"§r"+ "Coloured Wool Blocks. "+"§a"+ "2 "+"§r"+ "are Red and "+"§a"+"4 "+"§r"+ "are White.\nWhat Fraction of the blocks are Red?"));
    	}
    	 else if (world.getBlockState(pos).getBlock() == ModFractionsBlocks.QUARTER_3){
    		 playerIn.sendMessage(new TextComponentString("Farmer Joe gives you "+"§a"+ "5 "+"§r"+ "Of his "+"§a"+ "20 "+"§r"+"Iron Ingots.\nWhat Fraction of the Ingots did you get?"));
    	}
    	 else if (world.getBlockState(pos).getBlock() == ModFractionsBlocks.QUARTER_4){
    		 playerIn.sendMessage(new TextComponentString("You Mine "+"§a"+ "100 "+"§r"+ "Cobblestone Blocks.\nYou only have enough space to hold "+"§a"+ "25 Cobblestone Blocks. "+"§r"+"\n\nWhat Fraction of your " +"§a"+"100"+"§r"+" Cobblestone can you hold??"));
    	}
    	 else if (world.getBlockState(pos).getBlock() == ModFractionsBlocks.QUARTER_5){
    		 playerIn.sendMessage(new TextComponentString("Farmer Joes Chicken Farm makes "+"§a"+ "60 Eggs "+"§r"+ "per day.\nOf the 60, "+"§a"+ "15 Eggs "+"§r"+"produce little Chicks.\n\nWhat Fraction of the daily ammount become Chicks?"));
    	}
    	 
    	 //THIRD
    	 else if (world.getBlockState(pos).getBlock() == ModFractionsBlocks.THIRD_1){
    		 playerIn.sendMessage(new TextComponentString("You hit "+"§a"+ "1 "+"§r"+ "Out of a possible "+"§a"+ "3 "+"§r"+"blocks with your Paint Arrows.\n\nWhat Fraction of the blocks did your arrows hit?"));
    	}
    	 else if (world.getBlockState(pos).getBlock() == ModFractionsBlocks.THIRD_2){
    		 playerIn.sendMessage(new TextComponentString("You find "+"§a"+ "1 Iron"+"§r"+", "+"§a"+ "1 Gold"+"§r"+" and "+"§a"+ "1 Diamond"+"§r"+".\nWhat Fraction of the "+"§a"+"3"+"§r"+" Ores are Iron?"));
    	}
    	 else if (world.getBlockState(pos).getBlock() == ModFractionsBlocks.THIRD_3){
    		 playerIn.sendMessage(new TextComponentString("Farmer Joe makes "+"§a"+ "6 "+"§r"+ "cookies. He eats "+"§a"+ "4 "+"§r"+"and gives you "+"§a"+ "2"+"§r"+".\nWhat Fraction of the cookies did he give you?"));
    	}
    	 else if (world.getBlockState(pos).getBlock() == ModFractionsBlocks.THIRD_4){
    		 playerIn.sendMessage(new TextComponentString("§a"+ "5 "+"§r"+ "out of "+"§a"+ "15"+"§r"+"\nIs equivalent to \""+ "§k"+ "1third"+"§r"+"\""));
    	}
    	 else if (world.getBlockState(pos).getBlock() == ModFractionsBlocks.THIRD_5){
    		 playerIn.sendMessage(new TextComponentString("§a"+ "20 "+"§r"+ "out of "+"§a"+ "60 "+"§r"+"\nIs equivalent to \""+"§k"+"1half"+"§r"+"\""));
    	}
    	 
    	 else if (world.getBlockState(pos).getBlock() == ModFractionsBlocks.FAKE) {
     		world.newExplosion(playerIn, pos.getX(), pos.getY(), pos.getZ(), 0.5F, false, true);
     		 playerIn.inventory.getCurrentItem().damageItem(1, playerIn );
             return EnumActionResult.SUCCESS;
         }
     	 
    	 
    	 else {
    		 Block block;
    		 block = world.getBlockState(pos).getBlock();
    		 playerIn.sendMessage(new TextComponentString("This isn't a fractions Block.\n\nIts a : "+"§a"+ block.getLocalizedName()+"§r" + " (BLOCK)."));
    	 }
    	 
 		
    	}
    	
            return EnumActionResult.SUCCESS;
        }
    	

 
}
