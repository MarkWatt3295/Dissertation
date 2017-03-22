package com.maw79.mods.entity.hostile;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;

import net.minecraft.world.World;

import javax.annotation.Nullable;

import com.maw79.mods.client.gui.GuiFamilyCow;
import com.maw79.mods.init.ModItems;

/**
 * A creeper that avoids players holding an item in their off hand.
 */

 
public class EntityPlayerAvoidingCreeper extends EntityCreeper {
	public EntityPlayerAvoidingCreeper(World worldIn) {
		super(worldIn);
	}

	@Override
	protected void initEntityAI() {
		super.initEntityAI();

		// Remove the EntityAINearestAttackableTarget task added by EntityCreeper so it can be replaced
		targetTasks.taskEntries.stream()
				.filter(taskEntry -> taskEntry.action instanceof EntityAINearestAttackableTarget)
				.findFirst()
				.ifPresent(taskEntry -> targetTasks.removeTask(taskEntry.action));

		// Avoid players if they have an item in their off hand
		tasks.addTask(3, new EntityAIAvoidEntity<>(this, EntityPlayer.class, this::shouldAvoidPlayer, 6.0F, 1.0D, 1.2D));

		// Only attack players without an item in their off hand
		targetTasks.addTask(1, new EntityAINearestAttackableTarget<>(this, EntityPlayer.class, 10, true, false, (player) -> !shouldAvoidPlayer(player)));
	}

	/**
	 * Should this creeper avoid the specified player?
	 *
	 * @param player The player
	 * @return True if the player has an item in their off hand
	 */
	 
	private boolean shouldAvoidPlayer(@Nullable EntityPlayer player) {
		return player != null && !player.getHeldItemOffhand().equals(ModItems.ruby);
		//return player != null && !player.getHeldItemOffhand().isEmpty();
	}
	
	/**
     * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
     */
     
    public boolean interact(EntityPlayer parPlayer)
    {
    	// check if have already spawned castle
    	
    	
	    	// Family cow doesn't provide milk (that's why your mother wants you to sell it)
	    	// don't open gui if holding items, e.g. wheat that should incite mating instead
	    	// also don't open gui if already gone through gui to get a lead
	    	if (parPlayer.getHeldEquipment()== null || parPlayer.getHeldEquipment() == Items.BUCKET)
	    	{
				collideWithNearbyEntities();
				if (parPlayer.world.isRemote)
				{
					Minecraft.getMinecraft().displayGuiScreen(new GuiFamilyCow());
				}
	    	
	    	
	    	
		return false;
    }
			return false;
    
    /**
     * Returns true if the mob is currently able to mate with the specified mob.
     */
}
} 