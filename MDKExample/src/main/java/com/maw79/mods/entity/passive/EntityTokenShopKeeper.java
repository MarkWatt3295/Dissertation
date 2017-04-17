package com.maw79.mods.entity.passive;

import com.maw79.mods.client.gui.GuiHandler;
import com.maw79.mods.client.gui.GuiStoreDisplay;
import com.maw79.mods.handlers.AchievementHandler;
import com.maw79.mods.handlers.ModSoundHandler;
import com.maw79.mods.init.ModItems;
import com.maw79.mods.main.Maw79Mod;
import com.maw79.mods.util.Utils;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public  class EntityTokenShopKeeper extends EntityCreature {
	
	public final ItemStackHandler handler;

	public EntityTokenShopKeeper(World var1) {
		super(var1);
		this.handler = new ItemStackHandler(9);
		world = var1;
		experienceValue = 5;
		this.isImmuneToFire = false;
		this.enablePersistence();
		setNoAI(!true);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIWatchClosest(this, EntityPlayer.class, 10.0F));
		this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		setCustomNameTag("Shopkeeper");
		setAlwaysRenderNameTag(true);

	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(50D);
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
	protected SoundEvent getHurtSound()
    {
        return ModSoundHandler.MAWSOUND_OUCH;
    }
	
	

	@Override
	protected net.minecraft.util.SoundEvent getAmbientSound() {
		return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.chicken.say"));
	}

	//@Override
	//protected net.minecraft.util.SoundEvent getHurtSound() {
	///	return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.player.hurt"));
	//}

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
		entity.playSound(ModSoundHandler.MAWSOUND_CHACHING, 3.0F, 1.0F);
		int i = (int) this.posX;
		int j = (int) this.posY;
		int k = (int) this.posZ;

		if (true) {
			System.out.println("Printing from Shopkeeper mob");
			 if (this.world.isRemote)
		        {
		            int basicID = this.getEntityId();
		           // entity.openGui(Maw79Mod.instance, GuiHandler.STORE_GUI, this.world, basicID, 0, 0);
		            Minecraft.getMinecraft().displayGuiScreen(new GuiStoreDisplay());
		            
		           
		        }
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

	 @Override
	    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
	       
	        
	        return capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY ? (T) this.handler : super.getCapability(capability, facing);
	    }
	    
	    @Override
	    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
	        
	        
	        return capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY||super.hasCapability(capability, facing);
	    }
	    
}

