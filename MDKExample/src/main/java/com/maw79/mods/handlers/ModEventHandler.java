package com.maw79.mods.handlers;


import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import com.maw79.mods.client.gui.GuiNotif;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;

import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.entity.player.PlayerPickupXpEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;


public class ModEventHandler {

	boolean messageCall = false;
	
    @SubscribeEvent
    public void onLivingUpdateEvent(LivingUpdateEvent event){
    
    	if (event.getEntity() instanceof EntityPlayer)
    	{
    	EntityPlayer player = (EntityPlayer) event.getEntity();
    	
    	if( GuiNotif.playerlevel == "1"){
    		if(messageCall == false){
    		player.sendMessage(new TextComponentString("Player level 1"));
    		player.capabilities.allowFlying = true;
        	
    		messageCall = true;
    		}
    		
    		if( GuiNotif.playerlevel == "2"){
    			
    		}
    		
    		if(GuiNotif.playerlevel == "3"){
    			
    		}
    		
    		
    	}
    	
    	
    	
    	
    
    	}
    	//if(!(event.getEntity() instanceof EntityPlayer)) {
    	////	return;
    	//}
    	//if( GuiNotif.playerlevel == "2"){
    		//event.sendMessage(new TextComponentString("Player level 2"));
    	//}
        //if (event.getEntity() instanceof EntityPlayer) {
            //EntityPlayer player = (EntityPlayer) event.getEntity();
         //   player.sendMessage(new TextComponentString("HelloWorld New V2"));
           // System.out.println("Entity Joined Called V2");
            //add shovel on start
            //player.inventory.addItemStackToInventory(new ItemStack(Items.IRON_SHOVEL));
            //System.out.println("Shovel Collected");    
        //}
    }
    
    @SubscribeEvent
    public void PlayerJoin(EntityJoinWorldEvent event) {
    	if(!(event.getEntity() instanceof EntityPlayer)) {
    		return;
    	}
    	EntityPlayer player = (EntityPlayer) event.getEntity();
    	if(!event.getEntity().getEntityWorld().isRemote) {
    		player.sendMessage(new TextComponentString("\u00A7a" + "Thank you, "+ player.getName() + ", for downloading my KS2 MOD!"));
    		System.out.println("Player Joined Called");
    		player.setNoGravity(false);
    		if(player.hasNoGravity()== true){
    			player.sendMessage(new TextComponentString("\u00A7a" + "Player is floating already"));
    		}
    	}
    }
  

        
    
    @SubscribeEvent(priority = EventPriority.NORMAL) //Set a priority for the event
    public void onPlayerPickupXP(PlayerPickupXpEvent e){
    	e.getOrb().xpValue *=2;
    	
    }
    
    
    @SubscribeEvent
    public void pickupItem(EntityItemPickupEvent event) {
        System.out.println("Item picked up! EVENT MESSAGE");
        EntityPlayer player = (EntityPlayer) event.getEntity();
      //  player.setFire(2);
       // player.inventory.clear(); if(item.isEntityEqual(ModItems.mw))
        if(!player.hasAchievement(AchievementHandler.achievementNewIngot)){
        	player.addStat(AchievementHandler.achievementNewIngot);
        }

    }

    
    @SubscribeEvent
    public void itemTooltip(ItemTooltipEvent event) {
        if (event.getItemStack().getItem() == Items.APPLE) {
            event.getToolTip().add("Flaming Apple");
        }
    }

    @SubscribeEvent
    public void breakEvent(BlockEvent.BreakEvent event) {
        if (event.getState().getBlock() == Blocks.DIRT) {
            event.setExpToDrop(10);
            BlockPos pos = event.getPos();
            event.getWorld().spawnEntity(new EntityItem(event.getWorld(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Items.DIAMOND)));
      
        }
    }
    
    
   
    
    
    @SubscribeEvent //Super Jump
	public void makeJumpHigher(LivingJumpEvent event) {
		if (!(event.getEntity() instanceof EntityPlayer)) {
			return;
		}

		//event.getEntity().motionY *= 5;
	}
    
    public class GenericJumpEvent 
    {
        @SubscribeEvent
        public void onLivingJumpEvent(LivingJumpEvent event)
        {
           // double addY = 1.38D; // change to the entity's Y motion.
           // event.entity.motionY *= addY;
           // event.entity.velocityChanged = true;
        }
    }
    
   
    
    

}
