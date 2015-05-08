package me.theminebench.onduty;

import java.util.HashSet;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Buteti implements CommandExecutor {

	private Set<String> players = new HashSet<String>();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (args.length >= 1 && sender.hasPermission("onduty.checkBudeti")) {

			String playersName = null;
			if (args[0].equalsIgnoreCase("console")) {
				playersName = "CONSOLE";
			} else
				for (Player p : Bukkit.getOnlinePlayers()) {
					if (p.getName().equalsIgnoreCase(args[0]))
						playersName = p.getName();
				}
			
			if (playersName == null) {
				sender.sendMessage(format(args[0], OnDuty.getUnableToFindPlayerMessage()));
				return true;
			}
			
			if (players.contains(playersName)) {
				sender.sendMessage(format(playersName, OnDuty.getPlayersOnDutyMessage()));
			} else {
				sender.sendMessage(format(playersName, OnDuty.getPlayersOffDutyMessage()));
			}
			return true;
		}

		if (players.contains(sender.getName())) {
			players.remove(sender.getName());
			Bukkit.broadcastMessage(format(sender.getName(), OnDuty.getDisableDutyMessage()));
		} else {
			players.add(sender.getName());
			Bukkit.broadcastMessage(format(sender.getName(), OnDuty.getEnableDutyMessage()));
		}
		return true;

	}

	public String format(String name, String msg) {
		return msg.replaceAll("<player>", name);
	}

}
