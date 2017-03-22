package com.maw79.mods.entity.passive;

import com.maw79.mods.client.gui.GuiHandler;
import com.maw79.mods.main.Maw79Mod;
import com.maw79.mods.util.Utils;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class Test extends EntityTameable{
    
    public final ItemStackHandler handler;
    public int stomach;
    private int stomachCap = 1600;
    
    public Test(World worldIn) {
        super(worldIn);
        //Utils.getLogger().info("Test: Constructor");
        
        this.setSize(1.0F, 1.0F);
        this.handler = new ItemStackHandler(9);
        this.stomach = 0;
        
    }
    
    protected void initEntityAI(){
        Utils.getLogger().info("Test: initEntityAI");
        //this.tasks.addTask(0, new EntityAITempt(this, 0.5d, Items.APPLE, false));
        this.tasks.addTask(1, new EntityAIFollowOwner(this, 1.0D, 10.0F, 0.5F));
       // this.tasks.addTask(0, new AIGoto(this, 1.0F));
}
    
    public int getStomach(){
        //Utils.getLogger().info("Test: getStomach");
        
        return this.stomach;
    }
    
    public void setStomach(int value){
        Utils.getLogger().info("Test: setStomach");
        
        this.stomach = value;
    }
    
    public void getOwner(EntityPlayer player){
        //Utils.getLogger().info("Test: getOwner");
        
        if(stomach == stomachCap){
            this.setTamed(true);
            this.navigator.clearPathEntity();
            this.setOwnerId(player.getUniqueID());
        }
        //Utils.getLogger().info("Owner: "+this.getOwner()+" is tamed "+this.isTamed());
    }
    
    @Override
    public boolean isAIDisabled() {
        //Utils.getLogger().info("test: isAIDisabled");
        
        return false;
    }
    
    @Override
    public EntityAgeable createChild(EntityAgeable ageable) {
        Utils.getLogger().info("Test: createChild");
        
        return null;
    }
    
    @Override
    public boolean processInteract(EntityPlayer player, EnumHand hand)
    {
        Utils.getLogger().info("Test: processInteract");
        
        if (!this.world.isRemote)
        {
            int basicID = this.getEntityId();
            player.openGui(Maw79Mod.instance, GuiHandler.TEST, this.world, basicID,0, 0);
        }
        return true;
    }
    
    @Override
    public void onEntityUpdate() {
        //Utils.getLogger().info("Test: onEntityUpdate: "+targetX+" "+targetY+" "+targetZ);
        
        ItemStack foodStack = this.handler.getStackInSlot(0);
        if (this.world != null){
            if(!this.world.isRemote){
                if(foodStack.getItem() == Items.APPLE && stomach < stomachCap && (stomachCap-stomach)>=160){
                    foodStack.splitStack(1);
                    this.stomach += 160;
                }
            }
        }
        super.onEntityUpdate();
    }
    
    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        Utils.getLogger().info("Test: getCapability");
        
        return capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY ? (T) this.handler : super.getCapability(capability, facing);
    }
    
    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        Utils.getLogger().info("Test: hasCapability");
        
        return capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY||super.hasCapability(capability, facing);
    }
    
    @Override
    public void readEntityFromNBT(NBTTagCompound compound) {
        Utils.getLogger().info("Test: readEntityFromNBT");
        
        this.handler.deserializeNBT(compound.getCompoundTag("ItemStackHandler"));
        this.stomach = compound.getInteger("Stomach");
        super.readEntityFromNBT(compound);
    }
    
    @Override
    public void writeEntityToNBT(NBTTagCompound compound) {
        super.writeEntityToNBT(compound);
        Utils.getLogger().info("Test: writeEntityFromNBT");
        
        compound.setTag("ItemStackHandler", this.handler.serializeNBT());
        compound.setInteger("Stomach", this.stomach);
        
        
    }
    
}