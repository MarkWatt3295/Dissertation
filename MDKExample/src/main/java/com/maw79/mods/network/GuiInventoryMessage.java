package com.maw79.mods.network;

import com.maw79.mods.blocks.scienceblocks.tileentityscience.TileEntityScience;
import com.maw79.mods.util.Utils;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class GuiInventoryMessage implements IMessage {
	
	public int dimension, entityID;
	 public boolean setremovemess;

	public GuiInventoryMessage() {}

	public GuiInventoryMessage(EntityPlayer player, TileEntityScience te) { 
	 this.dimension = player.dimension;
	 this.entityID = player.getEntityId();
	
	 }
	 
	 /** enconding */
	 @Override
	 public void toBytes(ByteBuf buf) { 
	 buf.writeInt(dimension);
	 buf.writeInt(entityID);
	 buf.writeBoolean(setremovemess);
	
	 }

	/** decoding */
	 @Override
	 public void fromBytes(ByteBuf buf) { 
	 this.dimension = buf.readInt();
	 this.entityID = buf.readInt();
	 this.setremovemess = buf.readBoolean();
	 
	 }

	}
