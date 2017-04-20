package com.maw79.mods.items;

import com.maw79.mods.main.Maw79Mod;
import com.maw79.mods.main.Reference;

import net.minecraft.item.ItemSword;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

	public class ItemObsidianSword extends ItemSword {
		
		public ItemObsidianSword(String unlocalizedName, ToolMaterial material) {
			super(material);
				this.setUnlocalizedName(unlocalizedName);
				this.setRegistryName(new ResourceLocation(Reference.MOD_ID, unlocalizedName));
			
		
		}
		
	}


	


