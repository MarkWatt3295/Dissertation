package com.maw79.mods.entity.passive;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.EnumHand;
import net.minecraft.util.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.Minecraft;

import java.util.Random;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings("unchecked")
public class mcreator_human {

	public int mobid = 0;
	public static Object instance;

	public void load(FMLInitializationEvent event) {
	}

	public void generateNether(World world, Random random, int chunkX, int chunkZ) {
	}

	public void generateSurface(World world, Random random, int chunkX, int chunkZ) {
	}

	public int addFuel(ItemStack fuel) {
		return 0;
	}

	@SideOnly(Side.CLIENT)
	public void registerRenderers() {
		RenderBiped customRender = new RenderBiped(Minecraft.getMinecraft().getRenderManager(), new ModelBiped(), 0) {
			protected ResourceLocation getEntityTexture(Entity par1Entity) {
				return new ResourceLocation("maw79/Sparky3295.png");
			}
		};
		customRender.addLayer(new net.minecraft.client.renderer.entity.layers.LayerHeldItem(customRender));
		customRender.addLayer(new net.minecraft.client.renderer.entity.layers.LayerBipedArmor(customRender) {
			protected void initArmor() {
				this.modelLeggings = new ModelBiped();
				this.modelArmor = new ModelBiped();
			}
		});
		RenderingRegistry.registerEntityRenderingHandler(mcreator_human.Entityhuman.class, customRender);

	}

	public void serverLoad(FMLServerStartingEvent event) {
	}

	public void preInit(FMLPreInitializationEvent event) {
		int entityID = MathHelper.getRandomUUID().hashCode();
		mobid = entityID;
		EntityRegistry.registerModEntity(new ResourceLocation("testenvironmentmod:human"), mcreator_human.Entityhuman.class, "human", entityID,
				instance, 64, 1, true, (255 << 16) + (255 << 8) + 255, (255 << 16) + (255 << 8) + 255);
		EntityRegistry.addSpawn(mcreator_human.Entityhuman.class, 20, 1, 4, EnumCreatureType.CREATURE, clean(Biome.REGISTRY));

	}

	public static Biome[] clean(net.minecraft.util.registry.RegistryNamespaced<ResourceLocation, Biome> in) {
		Iterator<Biome> itr = in.iterator();
		ArrayList<Biome> ls = new ArrayList<Biome>();
		while (itr.hasNext()) {
			ls.add(itr.next());
		}
		return ls.toArray(new Biome[ls.size()]);
	}

	public static class Entityhuman extends EntityCreature {
		World world = null;

		public Entityhuman(World var1) {
			super(var1);
			world = var1;
			experienceValue = 5;
			this.isImmuneToFire = false;
			addRandomArmor();
			setNoAI(!true);
			this.tasks.addTask(0, new EntityAISwimming(this));
			this.tasks.addTask(6, new EntityAIWander(this, 1.0D));
			this.tasks.addTask(8, new EntityAILookIdle(this));
			this.tasks.addTask(1, new EntityAIWander(this, 0.8D));
			this.tasks.addTask(1, new EntityAILookIdle(this));

			setCustomNameTag("Human");
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
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.player.burp"));
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
				System.out.println("Printing from human mob");
			}

			return true;
		}

		@Override
		protected float getSoundVolume() {
			return 1.0F;
		}

	}

}