package me.marcel.serversystem.lobby;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Lobby {

	private String name;
	private Location spawn;
	private List<Player> players;
	
	public Lobby(String name, Location spawn) {
		this.name = name;
		this.spawn = spawn;
		
		this.players = new ArrayList<Player>();
	}
	
	public void broadcastMessage(String message) {
		for (Player player : this.getPlayers()) {
			player.sendMessage(message);
		}
	}
	
	public void addPlayer(Player player) {
		if (!(this.getPlayers().contains(player))) {
			this.getPlayers().add(player);
		}
	}
	
	public void removePlayer(Player player) {
		if (this.getPlayers().contains(player)) {
			this.getPlayers().remove(player);
		}
	}
	
	public String getName() {
		return this.name;
	}
	
	public Location getSpawn() {
		return this.spawn;
	}
	
	public List<Player> getPlayers() {
		return this.players;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSpawn(Location spawn) {
		this.spawn = spawn;
	}
	
	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	
}