package me.marcel.serversystem.logging;

public class Logger {

	private String prefix;
	private LogType defaultType;
	
	public Logger(String prefix, LogType defaultType) {
		this.prefix = prefix;
		this.defaultType = defaultType;
	}
	
	public void log(String message) {
		this.log(message, this.getDefaultLogType());
	}
	
	public void log(String message, LogType type) {
		switch (type) {
			case INFO:
				System.out.println(this.getPrefix() + " [INFO] " + message);
				break;
			case WARNING:
				System.out.println(this.getPrefix() + " [WARNING] " + message);
				break;
			case ERROR:
				System.out.println(this.getPrefix() + " [ERROR] " + message);
				break;
			default:
				break;
		}
	}
	
	public String getPrefix() {
		return this.prefix;
	}
	
	public LogType getDefaultLogType() {
		return this.defaultType;
	}
	
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	
	public void setDefaultLogType(LogType type) {
		this.defaultType = type;
	}
	
}