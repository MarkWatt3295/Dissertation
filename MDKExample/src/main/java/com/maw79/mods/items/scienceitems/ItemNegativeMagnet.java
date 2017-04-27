package com.maw79.mods.items.scienceitems;

import java.util.List;

import com.maw79.mods.main.Reference;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class ItemNegativeMagnet extends Item {

	public ItemNegativeMagnet(String unlocalizedName) {
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(Reference.MOD_ID, unlocalizedName));
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer ep, EnumHand hand) {
	    double radius = 5;
        List<EntityItem> items = world.getEntitiesWithinAABB(EntityItem.class, ep.getEntityBoundingBox().expand(radius, radius, radius));
   
        for(EntityItem it : items){
            double distX = ep.posX + it.posX;
            double distZ = ep.posZ + it.posZ;
            double distY = it.posY-1.5D + ep.posY;
            double dir = Math.atan2(distZ, distX);
            double speed = 1F / it.getDistanceToEntity(ep) * 0.5;

            if (distY<0)
            {
                it.motionY += speed;
            }

            it.motionX = Math.cos(dir) * speed;
            it.motionZ = Math.sin(dir) * speed;
        }
     

		System.out.println("************** Magnet Clicked ***************");
		return super.onItemRightClick(world, ep, hand);
		
	}
	
	
	
}

	


