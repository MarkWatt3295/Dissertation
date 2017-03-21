package com.maw79.mods.handlers;


import com.maw79.mods.init.ModBlocks;
import com.maw79.mods.init.ModItems;
import com.maw79.mods.main.Reference;
import net.minecraft.init.Items;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import scala.swing.TextComponent;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerPickupXpEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


public class ModEventHandler {


   /* @SubscribeEvent
    public void entityJoinWorld(EntityJoinWorldEvent event) {
        if (event.getEntity() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getEntity();
         //   player.sendMessage(new TextComponentString("HelloWorld New V2"));
            System.out.println("Entity Joined Called V2");
            //add shovel on start
            //player.inventory.addItemStackToInventory(new ItemStack(Items.IRON_SHOVEL));
            //System.out.println("Shovel Collected");    
        }
    }*/
    
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
    
   
    
    

}
