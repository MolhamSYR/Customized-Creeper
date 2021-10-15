package me.hurricane.main;

import java.util.List;
import java.util.Random;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class SpawnListener implements Listener {
	UpdateSight si;
	
	public Creeper creeper;
	
	public SpawnListener(UpdateSight si) {
		this.si = si;
	}
	
	@EventHandler()
	public void onSpawn(EntitySpawnEvent event) {
		if(!(event.getEntity() instanceof Creeper))
			return;
		
		if(!isCustomMob())
			return;
		
		event.setCancelled(true);
		
		World world = event.getEntity().getWorld();
		Location loc = event.getEntity().getLocation();
		
		
		 creeper = (Creeper) world.spawnEntity(loc, EntityType.CREEPER);
		
		
		creeper.setInvisible(true);	
		creeper.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 2));
		creeper.setMaxFuseTicks(20);
		
		if(hasPlayerIn(si.getNearbyEntities())) {
			
			for(Entity e : si.getNearbyEntities()) {
				if(!(e instanceof Player)) {
					si.getNearbyEntities().remove(e);
				}
			}
			
			for(int i = 0; i <= si.getNearbyEntities().size(); i++) {
				Player player = (Player) si.getNearbyEntities().get(i);
				
				creeper.setTarget(player);
				
				
			}
			
			
		}
		
		
		
		
		
		
		
	}
	
	public boolean isCustomMob() {
		Random r = new Random();
		int randomNumber = r.nextInt(100);
		if(randomNumber <= 90) {
			return true;
		}
		else {
			return false;
		}
		
	
	}
	public boolean hasPlayerIn(List<Entity> bruh) {
		boolean ReturnTrue = false;
		
		for(Entity en : bruh) {
			if(en instanceof Player) {
				ReturnTrue = true;
			}
			else {
				continue;
			}
			
		}
		return ReturnTrue;
		
	}

}
