package com.maw79.mods.items.teleporters;

import java.util.List;

import com.maw79.mods.main.Reference;
import com.maw79.mods.util.Utils;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class ItemLevitationDust extends Item {

    public ItemLevitationDust(String unlocalizedName) {
    	 this.setMaxStackSize(1);
         this.setMaxDamage(2);
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(Reference.MOD_ID, unlocalizedName));
	}
       
    /**
     * Tool tip
     */
    @Override
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
    	super.addInformation(stack, playerIn, tooltip, advanced);
    	tooltip.add(TextFormatting.DARK_RED + Utils.getLang().localize("levitationdust.tooltip"));
    }
    
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);
        if(!worldIn.isRemote) {
            stack.damageItem(1, playerIn);
           playerIn.getCooldownTracker().setCooldown(this, 100);
           playerIn.addPotionEffect(new PotionEffect(MobEffects.LEVITATION, 100, 0));
           
           
        }
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
    }
    
    

}
