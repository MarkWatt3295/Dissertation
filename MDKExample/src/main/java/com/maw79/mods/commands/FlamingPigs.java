package com.maw79.mods.commands;

import java.util.ArrayList;
import java.util.List;

import com.maw79.mods.handlers.ModEventHandler;

import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import scala.swing.TextComponent;


public class FlamingPigs implements ICommand {

	private final List aliases;
	private int numberOfPigs = 0;

	public FlamingPigs() {
		aliases = new ArrayList();
		aliases.add("flamingpigs");
		aliases.add("fp");
	}

	@Override
	public int compareTo(ICommand o) {
		
		return 0;
	}

	

	@Override
	public boolean isUsernameIndex(String[] args, int index) {
		return false;
	}

	@Override
	public String getName() {
		
		return "flamingpigs";
	}

	@Override
	public List getAliases() {
		return this.aliases;
	}


	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) 
			throws CommandException {
		if (args.length != 1) {
			sendErrorMessage(sender, "Invalid number of arguments!");
			return;
		}
		try {
			numberOfPigs = Integer.parseInt(args[0]);
		} catch (NumberFormatException e) {
			sendErrorMessage(sender, "The argument \"" + args[0]
					+ "\" is not a valid number!");
			return;
		}
		EntityPlayer player = (EntityPlayer) sender;
		//ModEventHandler.adminmode = true;
		for (int i = 0; i < numberOfPigs; i++) {
			EntityPig pig = new EntityPig(player.world);
			pig.setLocationAndAngles(player.posX, player.posY, player.posZ, 0,
					0);
			pig.setFire(10000);
			player.world.spawnEntity(pig);
		}
	}

	private void sendErrorMessage(ICommandSender sender, String message) {
		sender.sendMessage(new TextComponentString(TextFormatting.DARK_RED
				+ message));
	}

	
	public boolean canCommandSenderUse(ICommandSender sender) {
		return true;
				//sender instanceof EntityPlayer;
	}

	

	@Override
	public String getUsage(ICommandSender sender) {
		return "/flamingpigs <number of pigs> or help";
	}

	

	@Override
	public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
	
		return true;
	}

	@Override
	public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args,
			BlockPos targetPos) {
	
		return null;
	}

}