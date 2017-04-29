package com.maw79.mods.items;

import java.util.List;

import com.maw79.mods.handlers.ModEventHandler;
import com.maw79.mods.main.Reference;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ItemJumpBooster extends Item {

    public ItemJumpBooster(String unlocalizedName) {
    	 this.setMaxStackSize(1);
         this.setMaxDamage(3);
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(Reference.MOD_ID, unlocalizedName));
	}
       
    
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);
        if(!worldIn.isRemote) {
            stack.damageItem(1, playerIn);
            Vec3d lookVec = playerIn.getLookVec();
            playerIn.addVelocity(lookVec.xCoord * 0D, lookVec.yCoord *1.5D, lookVec.zCoord * 0D);
        
            playerIn.velocityChanged = true;
            if(itemRand.nextInt(20) == 0 && !playerIn.capabilities.isCreativeMode) stack = ItemStack.EMPTY;
        }
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
    }
    
    @Override
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
        tooltip.add(I18n.format("tooltip.jumpbooster"));
       
    }

}
