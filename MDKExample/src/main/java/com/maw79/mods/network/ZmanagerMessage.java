package com.maw79.mods.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class ZmanagerMessage implements IMessage {
	 public int dimension, entityID;

	public ZmanagerMessage() {}

	public ZmanagerMessage(EntityPlayer player) { 
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