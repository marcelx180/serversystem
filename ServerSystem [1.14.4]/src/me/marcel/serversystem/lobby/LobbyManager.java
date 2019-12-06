package me.marcel.serversystem.lobby;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;

import me.marcel.serversystem.logging.ConsoleLogger;
import me.marcel.serversystem.logging.LogType;
import me.marcel.serversystem.yml.Config;

public class LobbyManager {

	private Config config;
	private ConsoleLogger logger;
	
	private List<Lobby> lobbies;
	
	public LobbyManager(Config config) {
		this.logger = new ConsoleLogger("§8[§aServerSystem §8- §5LobbyManager§8]", LogType.INFO);
		
		this.config = config;
		this.lobbies = new ArrayList<Lobby>();
	}
	
	public void loadLobbies() {
		List<String> names = this.getConfig().getStringList("lobbies");
		
		for (String name : names) {
			Lobby lobby = new Lobby(name, new Location(Bukkit.getWorld(""), 0, 0, 0));
			
			this.addLobby(lobby);
		}
	}
	
	public void addLobby(Lobby lobby) {
		if (!(this.exists(lobby.getName()))) {
			this.getLobbies().add(lobby);
			
			this.getLogger().log("Die Lobby \"" + lobby.getName() + "\" wurde geladen!");
		}
	}
	
	public void removeLobby(Lobby lobby) {
		if (this.exists(lobby.getName())) {
			this.getLobbies().remove(lobby);
		}
	}
	
	public boolean exists(String name) {
		boolean exists = false;
		
		for (Lobby lobby : this.getLobbies()) {
			if (lobby.getName().equalsIgnoreCase(name)) {
				exists = true;
			}
		}
		
		return exists;
	}
	
	public Lobby getLobby(String name) {
		Lobby lobbyRet = new Lobby("world", new Location(Bukkit.getWorld("world"), 0, 0, 0));
		
		for (Lobby lobby : this.getLobbies()) {
			if (lobby.getName().equalsIgnoreCase(name)) {
				lobbyRet = lobby;
			}
		}
		
		return lobbyRet;
	}
	
	public Config getConfig() {
		return this.config;
	}
	
	public List<Lobby> getLobbies() {
		return this.lobbies;
	}
	
	public ConsoleLogger getLogger() {
		return this.logger;
	}
	
	public void setConfig(Config config) {
		this.config = config;
	}
	
	public void setLobbies(List<Lobby> lobbies) {
		this.lobbies = lobbies;
	}
	
	public void setLogger(ConsoleLogger logger) {
		this.logger = logger;
	}
	
}