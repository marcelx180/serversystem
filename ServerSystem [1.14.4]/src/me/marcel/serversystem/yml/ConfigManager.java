package me.marcel.serversystem.yml;

import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import me.marcel.serversystem.logging.ConsoleLogger;
import me.marcel.serversystem.logging.LogType;

public class ConfigManager extends FileManager {

	public ConfigManager(String configName) {
		super("plugins/ServerSystem/", configName);
		
		this.setLogger(new ConsoleLogger("§8[§aServerSystem §8- §5ConfigManager§8]", LogType.INFO));
	}
	
	@Override
	public void create() {
		if (!(this.exists())) {
			FileConfiguration configFile = this.getConfigFile();
			configFile.options().copyDefaults(true);
			try {
				configFile.save(this.getFile());
				
				this.getLogger().log("Die Konfigurationsdatei (" + this.getFileName() + ") wurde erfolgreich erstellt!");
			} catch (IOException e) {
				this.getLogger().log("Beim Erstellen der Konfigurationsdatei (" + this.getFileName() + ") ist ein Fehler aufgetreten!", LogType.ERROR);
			}
		}
	}
	
	public FileConfiguration getConfigFile() {
		return YamlConfiguration.loadConfiguration(this.getFile());
	}

}