package com.maw79.mods.entity.passive;


import net.minecraft.block.Block;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIEatGrass;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Elk extends EntityAnimal
{

	public Elk(World worldIn)
	{
		super(worldIn);
		this.setSize(1.8F, 2.5F);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIPanic(this, 2.0D));
		this.tasks.addTask(2, new EntityAIMate(this, 1.0D));
		this.tasks.addTask(3,
		new EntityAITempt(this, 1.25D, Item.getItemFromBlock(Blocks.GRASS), false));
		this.tasks.addTask(4, new EntityAIFollowParent(this, 1.25D));
		this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(5, new EntityAIEatGrass(this));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
		this.tasks.addTask(7, new EntityAILookIdle(this));

	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED)
				.setBaseValue(0.20000000298023224D);
	}


	

	@Override
	protected float getSoundVolume()
	{
		return 0.4F;
	}

	@Override
	protected Item getDropItem()
	{
		return null;
		
	}

	

	@Override
	public Elk createChild(EntityAgeable ageable)
	{
		return new Elk(this.world);
	}

	@Override
	public float getEyeHeight()
	{
		return this.height;
	}
}