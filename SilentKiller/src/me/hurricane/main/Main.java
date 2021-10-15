package me.hurricane.main;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

public class Main extends JavaPlugin {
	
	UpdateSight si;
	SpawnListener lis;
	
	@Override
	public void onEnable() {
		this.getCommand("SilentKiller").setExecutor(new SilentKillerCommand(this));
		this.getServer().getPluginManager().registerEvents(new SpawnListener(si), this);
		BukkitTask coolTask = new UpdateSight(lis).runTaskTimer(this, 0, 200);
		
	}
	@Override
	public void onDisable() {
		
		
		
		
	}

}
