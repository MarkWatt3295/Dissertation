package com.maw79.mods.entity.passive;

import java.util.Random;

import com.maw79.mods.client.gui.historygui.GuiRomanSteve;
import com.maw79.mods.client.gui.mathsgui.GuiMathsStore;
import com.maw79.mods.handlers.AchievementHandler;
import com.maw79.mods.handlers.ModSoundHandler;
import com.maw79.mods.handlers.TickHandler;

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
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public  class EntityMummy extends EntityCreature {
	World world = null;

	public EntityMummy(World var1) {
		super(var1);
		world = var1;
		experienceValue = 5;
		this.isImmuneToFire = false;
		addRandomArmor();
		setNoAI(!true);
		this.enablePersistence();
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIWatchClosest(this, EntityPlayer.class, 10.0F));
		this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		
		setCustomNameTag("Facts Mummy");
		setAlwaysRenderNameTag(true);

	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10000D);
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
			if(TickHandler.mummywait==false){
			System.out.println("Printing from Mummy");
			 if (this.world.isRemote)
			 {
				 String egyptiantalk;
					String[] egyptiansayings = {
							"These Bandages are Itchy",
							"Smells like old socks in these bandages",
							" Most Ancient Egyptian pyramids were built as tombs for pharaohs and their families. To date, over 130 pyramids have been discovered in Egypt",
							"A Pharaoh is the ruler of Egypt. Kind of like the King or Emporer",
							"The afterlife was incredibly important to the Egyptians. They believed that by preserving a dead person’s body. Which they did through the process of mummification",
							" The Pyramid of Khufu at Giza is the largest Egyptian pyramid. This incredible structure weighs as much as 16 Empire State buildings!",
							"Both Egyptian men and women wore make-up. The eye-paint was usually green (made from copper) or black (made from lead). As well as offering protection from the sun, the Egyptians believed make-up had magical healing powers, too!",
							"Unwrapped, the bandages of an Ancient Egyptian mummy could stretch for 1.6km",
							"The Egyptian alphabet contained more than 700 hieroglyphs!",
							" Ancient Egyptians believed in more than 2,000 deities! They had gods for everything, from dangers to chores! Each had different responsibilities and needed to be worshipped so that life could be kept in balance",
							"Cats were considered to be a sacred animal by the Ancient Egyptians. It’s thought that most families kept a cat as a pet, which they believed would bring the household good luck!",
							"The Ancient Egyptians invented lots of things we still use today, such as paper, pens, locks and keys and – believe it or not – toothpaste!"
					};
					Random rand = new Random();
					egyptiantalk = egyptiansayings [rand.nextInt( egyptiansayings.length)];
				 entity.sendMessage(new TextComponentString(" "));
				 entity.sendMessage(new TextComponentString("§6"+"Facts Mummy: \n\n"+"§6"+"\""+ "§f"+ egyptiantalk+"§6"+"\""));
				 entity.sendMessage(new TextComponentString(" "));
		         TickHandler.mummywait = true;
		            
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

}

