package com.maw79.mods.network.store;



import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class FarmerCoinsMessage implements IMessage {
	 public int dimension, entityID;

	public FarmerCoinsMessage() {}

	public FarmerCoinsMessage(EntityPlayer player) { 
	 this.dimension = player.dimension;
	 this.entityID = player.getEntityId();
	 }
	 
	 /** enconding */
	 @Override
	 public void toBytes(ByteBuf buf) { 
	 buf.writeInt(dimension);
	 buf.writeInt(entityID);
	 }

	/** decoding */
	 @Override
	 public void fromBytes(ByteBuf buf) { 
	 this.dimension = buf.readInt();
	 this.entityID = buf.readInt();
	 }

	}