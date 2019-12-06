package me.marcel.serversystem.logging;

import org.bukkit.Bukkit;

public class BroadcastLogger extends Logger {

	public BroadcastLogger(String prefix, LogType type) {
		super(prefix, type);
	}
	
	@Override
	public void log(String message, LogType type) {
		switch (type) {
			case INFO:
				Bukkit.broadcastMessage(this.getPrefix() + " §8[§3INFO§8] " + message);
				break;
			case WARNING:
				Bukkit.broadcastMessage(this.getPrefix() + " §8[§3WARNING§8] " + message);
				break;
			case ERROR:
				Bukkit.broadcastMessage(this.getPrefix() + " §8[§cERROR§8] " + message);
				break;
			default:
				break;
		}
	}
	
}