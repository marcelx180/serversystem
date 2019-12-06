package me.marcel.serversystem.yml;

import java.io.File;
import java.io.IOException;

import me.marcel.serversystem.logging.ConsoleLogger;
import me.marcel.serversystem.logging.LogType;

public class FileManager {

	private ConsoleLogger logger;
	
	private String path;
	private String fileName;
	
	public FileManager(String path, String fileName) {
		this.logger = new ConsoleLogger("§8[§aServerSystem §8- §5FileManager§8]", LogType.INFO);
		
		this.path = path;
		this.fileName = fileName;
	}
	
	public File getFile() {
		return new File(this.getPath() + this.getFileName());
	}
	
	public boolean exists() {
		return this.getFile().exists();
	}
	
	public void create() {
		if (!(this.exists())) {
			try {
				this.getFile().createNewFile();
				
				this.getLogger().log("Die Datei (" + this.getFileName() + ") wurde erfolgreich erstellt!");
			} catch (IOException e) {
				this.getLogger().log("Beim Erstellen der Datei (" + this.getFileName() + ") ist ein Fehler aufgetreten!", LogType.ERROR);
			}
		}
	}
	
	public void delete() {
		if (this.exists()) {
			boolean deleted = this.getFile().delete();
			
			if (deleted) {
				this.getLogger().log("Die Datei (" + this.getFileName() + ") wurde erfolgreich entfernt!");
			} else {
				this.getLogger().log("Beim Entfernen der Datei (" + this.getFileName() + ") ist ein Fehler aufgetreten!", LogType.ERROR);
			}
		}
	}
	
	public ConsoleLogger getLogger() {
		return this.logger;
	}
	
	public String getPath() {
		return this.path;
	}
	
	public String getFileName() {
		return this.fileName;
	}
	
	public void setLogger(ConsoleLogger logger) {
		this.logger = logger;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	
	public void setFileName(String name) {
		this.fileName = name;
	}
	
}