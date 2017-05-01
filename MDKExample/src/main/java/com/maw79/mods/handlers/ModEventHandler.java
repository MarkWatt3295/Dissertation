package com.maw79.mods.handlers;


import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.WorldTickEvent;
import scala.collection.parallel.ParIterableLike.Min;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;
import com.maw79.mods.blocks.pointsblocks.TileEntityPointsBlock;
import com.maw79.mods.blocks.scienceblocks.BlockScienceWool;
import com.maw79.mods.client.gui.GuiNotif;
import com.maw79.mods.init.ModBlocks;
import com.maw79.mods.init.ModItems;
import com.maw79.mods.init.ModTools;
import com.maw79.mods.util.Utils;

import ibxm.Player;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.gui.PlayerListComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.GameType;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.entity.player.PlayerPickupXpEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;


public class ModEventHandler {

private static final TimeUnit MILLISECONDS = null;
private static int ticker = 0;
public static boolean adminmode = false;
public static boolean romandomus = false;


	
    @SubscribeEvent
    public void onLivingUpdateEvent(LivingUpdateEvent event){
    
    	if (event.getEntity() instanceof EntityPlayer)
    	{
    	EntityPlayer player = (EntityPlayer) event.getEntity();
    	
    	player.fallDistance = 0.0F;
    	
    
    	ItemStack hand = player.inventory.getCurrentItem();
    	Item blocky = Item.getItemFromBlock(Blocks.SANDSTONE);
    	if(romandomus==false){
    	if(adminmode == false){
    	if(hand != null)
    	{
    		if(hand.getItem() == ModTools.glassPickaxe ){
    			//Utils.getLogger().info("Player holding Glass Pick : " + adminmode);
    			player.setGameType(GameType.SURVIVAL);
    		}
    		
    		
    		else if(hand.getItem() == blocky ){
    			//Utils.getLogger().info("Player holding block : " + adminmode);
    			player.setGameType(GameType.SURVIVAL);
    		}
    		
    			
    		
    		else{
    			//Utils.getLogger().info("Im the else : " + adminmode);
    			player.setGameType(GameType.ADVENTURE);
    		}
    	}
    	if(hand == null){
    		//Utils.getLogger().info("Not Holding Anything :" + adminmode);
    		player.setGameType(GameType.ADVENTURE);
    	}
    	}}
    	if(adminmode == true){
    		//Utils.getLogger().info("In ADMIN MODE :" + adminmode);
    		player.setGameType(GameType.CREATIVE);
    	}
    	
    	
    	if(romandomus == true){
    		player.setGameType(GameType.SURVIVAL);
    		
    		}
    		
    		

    	
    	}
    	}
    	
    	
    @SubscribeEvent
    public void onDeath(LivingDeathEvent event){
    	if (event.getEntity() instanceof EntityPlayer)
    	{
    	Utils.getLogger().info("OnDeath Event Called");
    	EntityPlayer player = (EntityPlayer) event.getEntity();
    	if(!(TileEntityPointsBlock.playerScore <=0)){
    	TileEntityPointsBlock.playerScore-=300;
    	if(TileEntityPointsBlock.playerScore <0){
    		TileEntityPointsBlock.playerScore = 0;
    	}
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
    
    
    @SubscribeEvent
    public void PlayerJoin(EntityJoinWorldEvent event) {
    	if(!(event.getEntity() instanceof EntityPlayer)) {
    		return;
    	}
    	EntityPlayer player = (EntityPlayer) event.getEntity();
    	if(!event.getEntity().getEntityWorld().isRemote) {
    		
    		player.sendMessage(new TextComponentString("\u00A7a" + "Thank you, "+ player.getName() + ", for downloading my KS2 MOD!"));
    		System.out.println("Player Joined Called");
    		Utils.getLogger().info("Set Ticker to 0");
    		TickHandler.ticker=0;
    		
    		player.setNoGravity(false);
    		if(player.hasNoGravity()== true){
    			player.sendMessage(new TextComponentString("\u00A7a" + "Player is floating already"));
    		}
    	}
    	event.getEntity().getEntityWorld().getGameRules().setOrCreateGameRule("keepInventory", "true");
    	//Minecraft.getMinecraft().world.getGameRules().setOrCreateGameRule("keepInventory", "true");
		Utils.getLogger().info("Keep Inventory is True");

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
        	//player.addStat(AchievementHandler.achievementNewIngot);
        }

    }
    
    @SubscribeEvent
    public void PlayerRespawn(EntityJoinWorldEvent event) {
    	if(!(event.getEntity() instanceof EntityPlayer)) {
    		return;
    	}
    	EntityPlayer player = (EntityPlayer) event.getEntity();
    	if(!event.getEntity().getEntityWorld().isRemote) {
    		Utils.getLogger().info("Respawn Fired!");
    		if(TileEntityPointsBlock.spawnIsSet==true){
    		//player.attemptTeleport(TileEntityPointsBlock.playerX, TileEntityPointsBlock.playerY, TileEntityPointsBlock.playerZ);
    			 
    		}
    	}
    }


    @SubscribeEvent
    public void breakEvent(BlockEvent.BreakEvent event) {
        if (event.getState().getBlock() == Blocks.DIRT) {
            event.setExpToDrop(10);
            BlockPos pos = event.getPos();
           // event.getWorld().spawnEntity(new EntityItem(event.getWorld(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Items.DIAMOND)));
      
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
