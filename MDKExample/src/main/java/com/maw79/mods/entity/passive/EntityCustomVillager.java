package com.maw79.mods.entity.passive;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIFollowGolem;
import net.minecraft.entity.ai.EntityAILookAtTradePlayer;
import net.minecraft.entity.ai.EntityAIMoveIndoors;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAIRestrictOpenDoor;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITradePlayer;
import net.minecraft.entity.ai.EntityAIVillagerInteract;
import net.minecraft.entity.ai.EntityAIVillagerMate;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityAIWatchClosest2;
import net.minecraft.entity.monster.EntityEvoker;
import net.minecraft.entity.monster.EntityVex;
import net.minecraft.entity.monster.EntityVindicator;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.world.World;

public class EntityCustomVillager extends EntityVillager{
	
	 private InventoryBasic villagerInventory;
	 
	public EntityCustomVillager(World worldIn) {
		super(worldIn);
		
	}
	

	
	 public EntityCustomVillager(World worldIn, int professionId)
	    {
	        super(worldIn);
	        this.villagerInventory = new InventoryBasic("Items", false, 8);
	        this.setProfession(professionId);
	        this.setSize(0.6F, 1.95F);
	        ((PathNavigateGround)this.getNavigator()).setBreakDoors(true);
	        this.setCanPickUpLoot(true);
	    }
	 
	 protected void initEntityAI()
	    {
	        this.tasks.addTask(0, new EntityAISwimming(this));
	        this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityZombie.class, 8.0F, 0.6D, 0.6D));
	        this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityEvoker.class, 12.0F, 0.8D, 0.8D));
	        this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityVindicator.class, 8.0F, 0.8D, 0.8D));
	        this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityVex.class, 8.0F, 0.6D, 0.6D));
	        this.tasks.addTask(1, new EntityAITradePlayer(this));
	        this.tasks.addTask(1, new EntityAILookAtTradePlayer(this));
	        this.tasks.addTask(2, new EntityAIMoveIndoors(this));
	        this.tasks.addTask(3, new EntityAIRestrictOpenDoor(this));
	        this.tasks.addTask(4, new EntityAIOpenDoor(this, true));
	        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 0.6D));
	        this.tasks.addTask(6, new EntityAIVillagerMate(this));
	        this.tasks.addTask(7, new EntityAIFollowGolem(this));
	        this.tasks.addTask(9, new EntityAIWatchClosest2(this, EntityPlayer.class, 3.0F, 1.0F));
	        this.tasks.addTask(9, new EntityAIVillagerInteract(this));
	        this.tasks.addTask(9, new EntityAIWanderAvoidWater(this, 0.6D));
	        this.tasks.addTask(10, new EntityAIWatchClosest(this, EntityLiving.class, 8.0F));
	    }

}
