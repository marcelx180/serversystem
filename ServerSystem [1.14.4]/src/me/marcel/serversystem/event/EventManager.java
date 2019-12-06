package me.marcel.serversystem.event;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class EventManager {

	private JavaPlugin plugin;
	
	public EventManager(JavaPlugin plugin) {
		this.plugin = plugin;
	}
	
	public void registerEvent(Listener listener) {
		this.getPlugin().getServer().getPluginManager().registerEvents(listener, this.getPlugin());
	}
	
	public JavaPlugin getPlugin() {
		return this.plugin;
	}
	
	public void setPlugin(JavaPlugin plugin) {
		this.plugin = plugin;
	}
	
}