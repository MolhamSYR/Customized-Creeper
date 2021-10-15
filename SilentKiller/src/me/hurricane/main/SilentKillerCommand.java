package me.hurricane.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SilentKillerCommand implements CommandExecutor {
	Main main;
	SpawnListener lis;
	public SilentKillerCommand(Main main) {
		this.main = main;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(label.equalsIgnoreCase("SilentKiller")) {
			//Kicking Console
			if(!(sender instanceof Player)) {
				sender.sendMessage("You Cannot Do This!");
				return true;
			}
			Player player = (Player) sender;
			
			if(player.hasPermission("op")) {
				
				if(args.length == 0) {
					player.getWorld().spawnEntity(player.getLocation(), lis.creeper.getType());
					player.sendMessage(ChatColor.GRAY + "You Spawned a " + ChatColor.RED + "Silent Killer!");
					return true;
					
				}
				if(args.length == 1) {
					
					Player target = Bukkit.getPlayerExact(args[0]);
					
					if(target == null) {
						player.sendMessage(ChatColor.RED + "That Player Is Not Online!");
						return true;
					}
					else {
						target.getWorld().spawnEntity(target.getLocation(), lis.creeper.getType());
						return true;
					}
					
					
				}
				if(args.length > 1) {
					player.sendMessage(ChatColor.RED + "Usage: /SilentKiller | /SilentKiller <Player>");
					
				}
				
				
			}
			
			
			
		}
		
		
		return false;
	}
	

}
