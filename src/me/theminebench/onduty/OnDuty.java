package me.theminebench.onduty;

import org.bukkit.ChatColor;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class OnDuty extends JavaPlugin {
	private static OnDuty plugin;
	
	private String enableDutyMessage;
	private String disableDutyMessage;
	
	private String playersOnDutyMessage;
	private String playersOffDutyMessage;
	
	private String unableToFindPlayerMessage;
	
	@Override
	public void onEnable() {
		setPlugin(this);
		saveDefaultConfig();
		
		this.enableDutyMessage =  ChatColor.translateAlternateColorCodes('&', getConfig().getString("enableDutyMessage"));
		this.disableDutyMessage =  ChatColor.translateAlternateColorCodes('&', getConfig().getString("disableDutyMessage"));
		
		this.playersOnDutyMessage =  ChatColor.translateAlternateColorCodes('&', getConfig().getString("playersOnDutyMessage"));
		this.playersOffDutyMessage =  ChatColor.translateAlternateColorCodes('&', getConfig().getString("playersOffDutyMessage"));
		
		this.unableToFindPlayerMessage = ChatColor.translateAlternateColorCodes('&', getConfig().getString("unableToFindPlayerMessage"));
		
		
		PluginCommand command = getCommand("Budeti");
		if (command == null) {
			System.out.print("Something went very wrong!");
		}
		command.setExecutor(new Buteti());
	}
	/**
	 * Gets the message broadcasted when someone goes on duty!
	 * @return the enableDutyMessage
	 */
	public static String getEnableDutyMessage() {
		return getPlugin().enableDutyMessage;
	}
	/**
	 * Gets the message broadcasted when someone goes off duty!
	 * @return the disableDutyMessage
	 */
	public static String getDisableDutyMessage() {
		return getPlugin().disableDutyMessage;
	}
	
	/**
	 * Gets the message sent when someone checks to see if someone is on duty and they are!
	 * @return the playersOnDutyMessage
	 */
	public static String getPlayersOnDutyMessage() {
		return getPlugin().playersOnDutyMessage;
	}
	
	/**
	 * Gets the message sent when someone checks to see if someone is on duty and they arn't!
	 * @return the playersOffDutyMessage
	 */
	public static String getPlayersOffDutyMessage() {
		return getPlugin().playersOffDutyMessage;
	}
	
	/**
	 * Gets the message sent when someone checks to see if someone is on duty and the person is not found!
	 * @return the playersOffDutyMessage
	 */
	public static String getUnableToFindPlayerMessage() {
		return getPlugin().unableToFindPlayerMessage;
	}
	
	public static OnDuty getPlugin() {
		return plugin;
	}
	
	public static void setPlugin(OnDuty plugin) {
		OnDuty.plugin = plugin;
	}
	
}
