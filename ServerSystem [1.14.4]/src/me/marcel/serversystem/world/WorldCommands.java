package me.marcel.serversystem.world;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WorldCommands implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// TODO Auto-generated method stub
		if(sender instanceof Player) {
			Player player = (Player) sender;
			if(args[0] == "create") {
				if(args.length >= 3 && args.length <= 4) {
					String worldType = args[1];
					String worldName = args[2];
					String worldSeed = args[3];
					
				}
			}
		}
		return true;
	}

}
