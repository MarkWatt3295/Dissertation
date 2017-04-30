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

public  class EntityWanderingInfoRoman extends EntityCreature {

	public final ItemStackHandler handler;




	public EntityWanderingInfoRoman(World var1) {
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
		setCustomNameTag("Colosseum Expert");
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
			if(TickHandler.npcwait2==false){
				System.out.println("Printing from Wandering INFO Roman");
				if (this.world.isRemote)
				{
					String romantalk;
					String[] romansayings = {
							"Welcome to the Colosseum",
							"One of the most famous buildings left by the Ancient Romans is the Colosseum. Its a huge ampitheatre in the centre of Rome. This is where members of the public would come to watch sporting events and games, including battles between Roman gladiators!",
							"The Colosseum was built between 72 A.D and 80 A.D under the Emperor Vespasian, in the heart of Ancient Rome",
							"Made from stone and concrete, this magnificent monument was built with the man power of tens of thousands of slaves",
							"The Colosseum is the largest Theatre in the world! Its Oval in shape and measures 189m long, 156m wide and 50m high. This ancient sporting arena could easily fit a modern day football pitch inside!",
							"This brilliant building had 80 entrances and could seat approximately 50,000 spectators who would come to watch sporting events and games. These events included gladiatorial combats, wild animal hunts and, believe it or not, ship naval battles!",
							"Emperors would often organise and pay for events at the Colosseum and give free entry to the public. They would also sometimes offer free food during the events. They did this to gain popularity and support",
							"The events at the Colosseum were seriously brutal, though – during certain games held by the emperors around 10,000 animals were killed in a single day",
							"The first games ever to be held were in 80 A.D, under Emperor Titus (the son of Vespasian), and they ran for 100 days straight. Games continued to be held for centuries to come – gladiatorial games until the fifth century and animal hunts until the 6th century",
							"To protect the spectators from the blistering sun and heat of Ancient Rome, there was the velarium – an awning that could be pulled over the top of the seating area to provide shade",
							"Below the Colosseum were numerous rooms and underground passages. Here is where the animals and gladiators were kept, waiting to meet their fate in the arena above. There were also 36 trap doors in the arena for special effects!",
							"Although two-thirds of the colosseum has been destroyed over time – mostly the result of vandalism, earthquakes and fires – it is today a popular tourist site, attracting thousands of people every year!"

					};
					Random rand = new Random();
					romantalk = romansayings [rand.nextInt( romansayings.length)];
					entity.sendMessage(new TextComponentString(" "));
					entity.sendMessage(new TextComponentString("§c"+"Colosseum Expert: \n\n"+"§c"+"\""+ "§f"+ romantalk+"§c"+"\""));
					entity.sendMessage(new TextComponentString(" "));
					TickHandler.npcwait2 = true;

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

