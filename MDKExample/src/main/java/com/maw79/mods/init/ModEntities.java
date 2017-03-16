package com.maw79.mods.init;

import com.maw79.mods.main.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/*
 * /import com.maw79.mods.entity.hostile.EntityPlayerAvoidingCreeper;
import com.maw79.mods.entity.passive.EntityCustomVillager;
import com.maw79.mods.main.Maw79Mod;
import com.maw79.mods.main.Reference;
import com.maw79.mods.util.Utils;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityGuardian;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries; */

//public class ModEntities {
	//public static int mobid = 0;
	//public static  Object instance;
	
	/*public static void registerEntities() {
		
		

		
		int entityID = MathHelper.getRandomUUID().hashCode();
		mobid = entityID;
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, "chris"), Entitychris.class, "chris", entityID,
				instance, 64, 1, true, (255 << 16) + (255 << 8) + 255, (255 << 16) + (255 << 8) + 255);
		//EntityRegistry.addSpawn(Entitychris.class, 34, 10, 30, EnumCreatureType.AMBIENT);
		
		//registerEntity(EntityPlayerAvoidingCreeper.class, "player_avoiding_creeper", 80, 3, true, 0x0DA70B, 0x101010);
		//registerEntity(EntityCustomVillager.class, "custom_villager", 80, 3, true, 0x0DA50B, 0x202020);
		
	}

	public static void addSpawns() {
	//	EntityRegistry.addSpawn(Entitychris.class, 34, 10, 30, EnumCreatureType.AMBIENT);
		//copySpawns(EntityPlayerAvoidingCreeper.class, EnumCreatureType.MONSTER, EntityCreeper.class, EnumCreatureType.MONSTER);
		//copySpawns2(EntityCustomVillager.class, EnumCreatureType.AMBIENT, EntityVillager.class, EnumCreatureType.AMBIENT);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerRenderers() {
		RenderBiped customRender = new RenderBiped(Minecraft.getMinecraft().getRenderManager(), new ModelBiped(), 0) {
			protected ResourceLocation getEntityTexture(Entity par1Entity) {
				return new ResourceLocation("sparky3295.png");
			}
		};
		customRender.addLayer(new net.minecraft.client.renderer.entity.layers.LayerHeldItem(customRender));
		customRender.addLayer(new net.minecraft.client.renderer.entity.layers.LayerBipedArmor(customRender) {
			protected void initArmor() {
				this.modelLeggings = new ModelBiped();
				this.modelArmor = new ModelBiped();
			}
		});
		RenderingRegistry.registerEntityRenderingHandler(Entitychris.class, customRender);

	}
	
}
*/
