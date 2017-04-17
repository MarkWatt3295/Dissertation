package com.maw79.mods.items.mathsitems;

import com.maw79.mods.client.gui.mathsgui.GuiXyzDevice;
import com.maw79.mods.main.Maw79Mod;
import com.maw79.mods.main.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class ItemXyzDevice extends Item {
	
	public  ItemXyzDevice (String unlocalizedName) {
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(Reference.MOD_ID, unlocalizedName));
		this.setCreativeTab(Maw79Mod.items);
		this.setMaxDamage(1);
		
		
	}
	

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		 if(!player.world.isRemote) player.sendMessage(new TextComponentString("XYZ Item Activated"));
		 if(player.world.isRemote){
		 Minecraft.getMinecraft().displayGuiScreen(new GuiXyzDevice());
		 }
		 
		 return super.onItemRightClick(world, player, hand);
		
}
	
	
}

