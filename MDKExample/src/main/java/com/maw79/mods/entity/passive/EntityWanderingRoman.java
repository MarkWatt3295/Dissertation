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

public  class EntityWanderingRoman extends EntityCreature {
	
	public final ItemStackHandler handler;
	
	
	

	public EntityWanderingRoman(World var1) {
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
		setCustomNameTag("Roman");
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
			if(TickHandler.npcwait==false){
			System.out.println("Printing from Wandering Roman");
			 if (this.world.isRemote)
			 {
				 String romantalk;
					String[] romansayings = {
							"Oh its you again",
							"What day is it again?",
							"I'm a Roman",
							"Rome was founded in 753BC by our first king, Romulus. It grew into a rich and powerful city during the next few hundred years.",
							"Roman legend says that Romulus had a twin brother called Remus. As babies they were abandoned in the area which later became Rome. A she-wolf found and raised them, but when they grew up, Romulus fought and killed Remus and became the first ruler of Rome!",
							"During battle, a Roman soldier or ‘legionary’ first hurled his spear at the enemy. He would then proceed to fight him with his sword. To protect himself, he carried a wooden shield and wore a metal helmet and armour",
							"Us Romans didn’t spend all of our time fighting. We were amazing architects and engineers too! We built roads and walls, things people now take for granted",
							"To bring water to our cities, us clever Romans built aqueducts. Aqueducts are a system of channels and bridges used to transport water for public baths and toilets!",
							"A Roman soldier is knows as a Legionary",
							"The Romans liked to enjoy their food, often lying down on a couch while eating with their hands. They occasionally used a spoon, but they would never use a knife and fork.Rich Romans liked to eat exotic food, such as stork, roast parrot and even flamingo!",
							"The Romans believed in gods and goddesses who ruled over different areas of life. For example, Neptune was the god of the ocean, and they prayed to him to protect them at sea. Temples were built to honour the gods, and people would visit them with offerings",
							"One of the most famous buildings left by the Ancient Romans is the Colosseum. Its a huge ampitheatre in the centre of Rome. This is where members of the public would come to watch sporting events and games, including battles between Roman gladiators!",
							"What do you mean whats a Tunic?\n A tunic is two pieces of woollen fabric sewn together at the sides and shoulders. It has openings for your arms and head. They were the most common clothes in Rome. Wealthy Romans also wore togas. Togas are a kind of woollen shawl"
							
							
					};
					Random rand = new Random();
					romantalk = romansayings [rand.nextInt( romansayings.length)];
				 entity.sendMessage(new TextComponentString(" "));
				 entity.sendMessage(new TextComponentString("§9"+"Wandering Roman: \n\n"+"§9"+"\""+ "§f"+ romantalk+"§9"+"\""));
				 entity.sendMessage(new TextComponentString(" "));
		         TickHandler.npcwait = true;
		            
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

