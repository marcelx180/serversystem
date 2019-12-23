package me.marcel.serversystem;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import me.marcel.serversystem.commands.CommandManager;
import me.marcel.serversystem.event.EventManager;
import me.marcel.serversystem.lobby.Lobby;
import me.marcel.serversystem.lobby.LobbyManager;
import me.marcel.serversystem.lobby.event.LobbyJoinEvent;
import me.marcel.serversystem.lobby.event.LobbyQuitEvent;
import me.marcel.serversystem.logging.ConsoleLogger;
import me.marcel.serversystem.logging.LogType;
import me.marcel.serversystem.yml.Config;
import me.marcel.serversystem.yml.ConfigManager;

public class Main extends JavaPlugin implements Listener {

	private ConsoleLogger consoleLogger;
	
	// Konfigurationsdateien
	private Config settingsConfig;
	private Config lobbiesConfig;
	
	// Lobby
	private LobbyManager lobbyManager;
	
	// Events
	private EventManager eventManager;
	
	private CommandManager commandManager;
	
	@Override
	public void onLoad() {
		this.init();
	}
	
	@Override
	public void onEnable() {
		// Konfigurationsdateien erstellen
		this.getSettingsConfig().getConfigManager().create();
		this.getLobbieConfig().getConfigManager().create();
		
		// Lobby
		this.getLobbyManager().loadLobbies();
		this.getEventManager().registerEvent(this);
		
		//Command
		
		this.getConsoleLogger().log("Das Plugin wurde aktiviert!");
	}
	
	@Override
	public void onDisable() {
		this.getConsoleLogger().log("Das Plugin wurde deaktiviert!");
	}
	
	private void init() {
		this.consoleLogger = new ConsoleLogger("§8[§aServerSystem§8]", LogType.INFO);
		
		// Konfigurationsdateien initialisieren
		this.settingsConfig = new Config(new ConfigManager("settings.yml"));
		this.lobbiesConfig = new Config(new ConfigManager("lobbies.yml"));
		
		// Lobby
		this.lobbyManager = new LobbyManager(this.getLobbieConfig());
		
		// Events
		this.eventManager = new EventManager(this);
		
		// Commands 
		this.commandManager = new CommandManager(this);
	}
	
	public ConsoleLogger getConsoleLogger() {
		return this.consoleLogger;
	}
	
	public Config getSettingsConfig() {
		return this.settingsConfig;
	}
	
	public Config getLobbieConfig() {
		return this.lobbiesConfig;
	}
	
	public LobbyManager getLobbyManager() {
		return this.lobbyManager;
	}
	
	public EventManager getEventManager() {
		return this.eventManager;
	}
	
	public CommandManager getCommandManager() {
		return this.commandManager;
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		String worldName = player.getWorld().getName();
		
		// Lobby
		if (this.getLobbyManager().exists(worldName)) {
			Lobby lobby = this.getLobbyManager().getLobby(worldName); 
			lobby.addPlayer(player);
			
			this.getServer().getPluginManager().callEvent(new LobbyJoinEvent(player, lobby));
		}
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent event) {
		Player player = event.getPlayer();
		String worldName = player.getWorld().getName();
		
		// Lobby
		if (this.getLobbyManager().exists(worldName)) {
			Lobby lobby = this.getLobbyManager().getLobby(worldName); 
			lobby.removePlayer(player);
			
			this.getServer().getPluginManager().callEvent(new LobbyQuitEvent(player, lobby));
		}
	}
	
}