package me.marcel.serversystem.commands;

import org.bukkit.plugin.java.JavaPlugin;

import me.marcel.serversystem.world.WorldCommands;

public class CommandManager {
private static JavaPlugin plugin;

	public CommandManager(JavaPlugin pl) {
		plugin = pl;
	}
		
	public static void registerCommands() {
		plugin.getCommand("world").setExecutor(new WorldCommands());
	}
		
}