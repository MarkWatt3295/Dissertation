package com.maw79.mods.commands;

import java.util.ArrayList;
import java.util.List;

import com.maw79.mods.client.gui.GuiGameType;
import com.maw79.mods.handlers.ModEventHandler;
import com.maw79.mods.main.Maw79Mod;
import com.maw79.mods.network.AdminCommandMessage;
import com.maw79.mods.network.StandardCommandMessage;
import com.maw79.mods.network.store.StoreItem1Message;
import com.maw79.mods.util.Utils;

import net.minecraft.client.Minecraft;
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


public class MawStandard implements ICommand {

	private final List aliases;
	

	public MawStandard() {
		aliases = new ArrayList();
		aliases.add("mawstandard");
		aliases.add("ms");
		aliases.add("standard");
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
		
		return "mawstandard";
	}

	@Override
	public List getAliases() {
		return this.aliases;
	}


	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) 
			throws CommandException {
	Utils.getLogger().info("Admin Mode Set to False : MawStandard Command Used");
			ModEventHandler.adminmode = false;
			Maw79Mod.NETWORK.sendToServer(new StandardCommandMessage(Minecraft.getMinecraft().player));
			return;
		
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
		return "/mawadmin - New Mod Game Mode";
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