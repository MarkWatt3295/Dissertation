package com.maw79.mods.items.mathsitems;

import com.maw79.mods.client.gui.GuiHandler;
import com.maw79.mods.client.gui.mathsgui.GuiXyzDevice;
import com.maw79.mods.main.Maw79Mod;
import com.maw79.mods.main.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
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
		
		 Minecraft.getMinecraft().displayGuiScreen(new GuiXyzDevice());
	
		 
		 return super.onItemRightClick(world, player, hand);
		
}
	
	/*public EnumActionResult onItemUseFirst(ItemStack itemStack, EntityPlayer entity, World world, BlockPos pos, EnumFacing side, float hitX,
			float hitY, float hitZ, EnumHand hand) {
		float var4 = 1.0F;
		int i = pos.getX();
		int j = pos.getY();
		int k = pos.getZ();

		if (true) {
			if (entity instanceof EntityPlayer)
				((EntityPlayer) entity).openGui(Maw79Mod.instance, GuiHandler.GUI_DEVICE, world, i, j, k);
		}

		return EnumActionResult.PASS;
	}
*/
}

