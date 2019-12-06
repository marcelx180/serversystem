package me.marcel.serversystem.yml;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;

import me.marcel.serversystem.logging.LogType;

public class Config {

	private ConfigManager configManager;
	
	public Config(ConfigManager configManager) {
		this.configManager = configManager;
	}
	
	public String getString(String path) {
		return this.getConfigManager().getConfigFile().getString(path);
	}
	
	public boolean getBoolean(String path) {
		return this.getConfigManager().getConfigFile().getBoolean(path);
	}
	
	public int getInteger(String path) {
		return this.getConfigManager().getConfigFile().getInt(path);
	}
	
	public double getDouble(String path) {
		return this.getConfigManager().getConfigFile().getDouble(path);
	}
	
	public List<String> getStringList(String path) {
		return this.getConfigManager().getConfigFile().getStringList(path);
	}
	
	public void update(String path, Object value) {
		File file = this.getConfigManager().getFile();
		FileConfiguration configFile = this.getConfigManager().getConfigFile();
		configFile.set(path, value);
		try {
			configFile.save(file);
			
			this.getConfigManager().getLogger().log("Die Konfigurationsdatei (" + this.getConfigManager().getFileName() + ") wurde erfolgreich aktualisiert!");
		} catch (IOException e) {
			this.getConfigManager().getLogger().log("Beim Aktualisieren der Konfigurationsdatei (" + this.getConfigManager().getFileName() + ") ist ein Fehler aufgetreten!", LogType.ERROR);
		}
	}
	
	public ConfigManager getConfigManager() {
		return this.configManager;
	}
	
	public void setConfigManager(ConfigManager configManager) {
		this.configManager = configManager;
	}
	
}