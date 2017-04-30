package com.maw79.mods.entity.passive;

import java.util.Random;

import com.maw79.mods.handlers.ModSoundHandler;
import com.maw79.mods.handlers.TickHandler;
import com.maw79.mods.util.Utils;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public  class EntityWanderingExplorer extends EntityCreature {
	
	public final ItemStackHandler handler;
	
	
	

	public EntityWanderingExplorer(World var1) {
		super(var1);
		this.handler = new ItemStackHandler(9);
		world = var1;
		experienceValue = 5;
		this.isImmuneToFire = false;
		this.enablePersistence();
		setNoAI(!true);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(6, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(8, new EntityAILookIdle(this));
		this.tasks.addTask(1, new EntityAIWander(this, 0.8D));
		this.tasks.addTask(1, new EntityAILookIdle(this));
		setCustomNameTag("Explorer");
		setAlwaysRenderNameTag(true);

	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(1000D);
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
		this.setDead();

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
		//entity.playSound(ModSoundHandler.MAWSOUND_CHACHING, 3.0F, 1.0F);
		
		if (true) {
			if(TickHandler.wandererwait==false){
			System.out.println("Printing from Wandering Explorer");
			 if (this.world.isRemote)
			 {
				 String egyptiantalk;
					String[] egyptiansayings = {
							"I love Exploring",
							"Did you know that Over 130 pyramids have been discovered in Egypt.",
							"Have you been to Roman Island yet?",
							"The first Egyptian pyramid is believed to be the Pyramid of Djoser, it was built in Saqqara around 4650 years ago (2640 BC).",
							"The Great Pyramid of Giza is the oldest and largest of three pyramids in the Giza Necropolis",
							"For over 3800 years, the Great Pyramid of Giza was the tallest man made structure in the world.",
							"Nearly all Egyptian Pyramids are located on the west bank of the Nile.",
							"It sure is hot here!",
							"Egyptian Pyramids often contain multiple chambers and passages.",
							"Bodies placed in the tombs were preserved by mummification",
							"Egyptians buried their dead with burial goods that ranged from everyday items they believed would useful in the afterlife to more expensive items such as jewelry.",
							"One tomb that was left largely intact was that of Tutankhamun in the Valley of the Kings. Rediscovered in 1922 by Howard Carter, this famous tomb is best known for the solid gold funerary mask of Tutankhamun.",
							"Tutankhamun was a pharaoh from 1332 BC to 1323 BC."
							
					};
					Random rand = new Random();
					egyptiantalk = egyptiansayings [rand.nextInt( egyptiansayings.length)];
				 entity.sendMessage(new TextComponentString(" "));
				 entity.sendMessage(new TextComponentString("§6"+"Pyramid Explorer: \n\n"+"§6"+"\""+ "§f"+ egyptiantalk+"§6"+"\""));
				 entity.sendMessage(new TextComponentString(" "));
		         TickHandler.wandererwait = true;
		            
		        }
			}
			
		}
		//if(!entity.hasAchievement(AchievementHandler.achievementNiceTo)){
         //	entity.addStat(AchievementHandler.achievementNiceTo);
        // }

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

