package me.marcel.serversystem.lobby.event;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import me.marcel.serversystem.lobby.Lobby;

public class LobbyQuitEvent extends Event {

	public static HandlerList handlers = new HandlerList();
	
	private Player player;
	private Lobby lobby;
	
	public LobbyQuitEvent(Player player, Lobby lobby) {
		this.player = player;
		this.lobby = lobby;
	}
	
	public Player getPlayer() {
		return this.player;
	}
	
	public Lobby getLobby() {
		return this.lobby;
	}
	
	@Override
	public HandlerList getHandlers() {
		return handlers;
	}

	public HandlerList getHandlerList() {
		return handlers;
	}
	
}