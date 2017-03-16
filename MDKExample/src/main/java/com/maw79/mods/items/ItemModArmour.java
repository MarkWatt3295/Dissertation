package com.maw79.mods.items;

import java.util.Iterator;

import com.maw79.mods.creativetabs.Maw79ItemsTab;
import com.maw79.mods.handlers.AchievementHandler;
import com.maw79.mods.handlers.MaterialHandler;
import com.maw79.mods.main.Maw79Mod;
import com.maw79.mods.main.Reference;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class ItemModArmour extends ItemArmor{

	public ItemModArmour(ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn, String unlocalizedName) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
		

		//setUnlocalizedName(Reference.MawItems.OBSIDIANARMOR.getUnlocalizedName());
		//setRegistryName(Reference.MawItems.OBSIDIANARMOR.getRegistryName());
	
		
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(Reference.MOD_ID, unlocalizedName));
		this.setCreativeTab(Maw79Mod.items);
		
	}
	
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
	 // player.addPotionEffect(new PotionEffect(MobEffects.HEALTH_BOOST, 100, 2));
		int obsidianArmourPeices = 0;
		if(player.getArmorInventoryList() != null) {
			Iterator<ItemStack> iterator = player.getArmorInventoryList().iterator();
			while(iterator.hasNext()) {
				ItemStack stack = iterator.next();
				if(stack != null) {
					if(stack.getItem() instanceof ItemModArmour) {
						ItemModArmour item = (ItemModArmour) stack.getItem();
						if(item.getArmorMaterial() == MaterialHandler.obsidianMaterial) {
							obsidianArmourPeices++;
							continue;
						}
					}
				}
			}
		}
		if(obsidianArmourPeices == 4) {
			if(!player.hasAchievement(AchievementHandler.achievementObsidianMan)) {
				player.addStat(AchievementHandler.achievementObsidianMan);
			}
		}
	}

}
