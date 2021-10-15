package me.hurricane.main;

import java.util.List;

import org.bukkit.entity.Entity;
import org.bukkit.scheduler.BukkitRunnable;

public class UpdateSight extends BukkitRunnable{
	
	List<Entity> nearbyEntities;
	SpawnListener lis;
	public UpdateSight(SpawnListener lis) {
		this.lis = lis;
	}
	public void run() {
		nearbyEntities = lis.creeper.getNearbyEntities(30, 30, 30);
		
		
	}
	public List<Entity> getNearbyEntities() {
		return this.nearbyEntities;
	}

}
