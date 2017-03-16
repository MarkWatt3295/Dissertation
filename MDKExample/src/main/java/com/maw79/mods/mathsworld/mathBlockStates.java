package com.maw79.mods.mathsworld;

import com.maw79.mods.init.ModBlocks;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class mathBlockStates {
	
	public void onEvent3(){
		
//player.inventory.addItemStackToInventory(new ItemStack(ModBlocks.mathblockgreen, 1));
  	}
    
	
	

	private boolean pressed;
	
	
public boolean isPressed() {
		return pressed;
	}

	public boolean setPressed(boolean pressed) {
		return this.pressed = pressed;
	}


public mathBlockStates(){

isPressed();
	}
}


