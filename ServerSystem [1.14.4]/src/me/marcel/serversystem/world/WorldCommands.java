package me.marcel.serversystem.world;

import org.bukkit.Server;
import org.bukkit.World.Environment;
import org.bukkit.WorldCreator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.generator.ChunkGenerator;

public class WorldCommands implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// TODO Auto-generated method stub
		if(sender instanceof Player) {
			Player player = (Player) sender;
			if(args[0] == "create") {
				if(args.length >= 3 && args.length <= 4) {
					String worldType = args[1];
					boolean validWorldType= false;
					Environment environment = null;
					switch(worldType){
						case "Normal":
							validWorldType = true;
							environment = Environment.NORMAL;
							break;
						case "Nether":
							validWorldType = true;
							environment = Environment.NETHER;
							break;
						case "End":
							validWorldType = true;
							environment = Environment.THE_END;
							break;
						case "Flat":
							validWorldType = true;
							environment = Environment.NORMAL;
							break;
						default:
							validWorldType= false;
					}
					if(validWorldType) {						
						String worldName = args[2];
						WorldCreator worldCreator = null;
						if(args.length == 4) {
							String worldSeed = args[3];
							worldCreator = new WorldCreator(worldSeed);
						}
						else {
							worldCreator= new WorldCreator("");
						}
						worldCreator.name(worldName);
						if(worldType == "Flat") {
							
						}
						worldCreator.environment(environment);
						player.getServer().createWorld(worldCreator);
					}
				}
			}
		}
		return true;
	}

}
