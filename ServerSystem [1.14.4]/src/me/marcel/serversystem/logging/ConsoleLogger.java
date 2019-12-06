package me.marcel.serversystem.logging;

import org.bukkit.Bukkit;

public class ConsoleLogger extends Logger {

	public ConsoleLogger(String prefix, LogType type) {
		super(prefix, type);
	}
	
	@Override
	public void log(String message, LogType type) {
		switch (type) {
			case INFO:
				Bukkit.getConsoleSender().sendMessage(this.getPrefix() + " §8[§6INFO§8] " + message);
				break;
			case WARNING:
				Bukkit.getConsoleSender().sendMessage(this.getPrefix() + " §8[§5WARNING§8] " + message);
				break;
			case ERROR:
				Bukkit.getConsoleSender().sendMessage(this.getPrefix() + " §8[§cERROR§8] " + message);
				break;
			default:
				break;
		}
	}
	
}