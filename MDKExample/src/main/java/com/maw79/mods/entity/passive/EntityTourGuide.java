package com.maw79.mods.entity.passive;

import com.maw79.mods.handlers.AchievementHandler;
import com.maw79.mods.handlers.ModSoundHandler;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public  class EntityTourGuide extends EntityCreature {
	World world = null;

	public EntityTourGuide(World var1) {
		super(var1);
		world = var1;
		experienceValue = 5;
		this.isImmuneToFire = false;
		addRandomArmor();
		setNoAI(!true);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIWatchClosest(this, EntityPlayer.class, 10.0F));
		this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		
		setCustomNameTag("Tour Guide");
		setAlwaysRenderNameTag(true);

	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10D);
		if (this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
			this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3D);
	}

	protected void addRandomArmor() {

	}

	@Override
	protected Item getDropItem() {
		return null;
	}

	@Override
	protected net.minecraft.util.SoundEvent getAmbientSound() {
		return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.chicken.say"));
	}

	@Override
	protected net.minecraft.util.SoundEvent getHurtSound() {
		return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.snowman.hurt"));
	}

	@Override
	protected net.minecraft.util.SoundEvent getDeathSound() {
		return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.player.death"));
	}

	@Override
	public void onStruckByLightning(EntityLightningBolt entityLightningBolt) {
		super.onStruckByLightning(entityLightningBolt);
		int i = (int) this.posX;
		int j = (int) this.posY;
		int k = (int) this.posZ;
		Entity entity = this;

	}

	@Override
	public void fall(float l, float d) {
		super.fall(l, d);
		int i = (int) this.posX;
		int j = (int) this.posY;
		int k = (int) this.posZ;
		super.fall(l, d);
		Entity entity = this;

	}

	@Override
	public void onDeath(DamageSource source) {
		super.onDeath(source);
		int i = (int) this.posX;
		int j = (int) this.posY;
		int k = (int) this.posZ;
		Entity entity = this;

	}

	@Override
	public boolean processInteract(EntityPlayer entity, EnumHand hand) {
		super.processInteract(entity, hand);
		int i = (int) this.posX;
		int j = (int) this.posY;
		int k = (int) this.posZ;

		if (true) {
			System.out.println("Printing from Tour Guide mob");
			//entity.playSound(ModSoundHandler.MAWSOUND_VOICE1, 1.0F, 4.0F);
		}
		if(!entity.hasAchievement(AchievementHandler.achievementNiceTo)){
         	entity.addStat(AchievementHandler.achievementNiceTo);
         }

		return true;
	}

	@Override
	protected float getSoundVolume() {
		return 1.0F;
	}

}

