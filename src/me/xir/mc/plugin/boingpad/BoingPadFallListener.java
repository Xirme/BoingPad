package me.xir.mc.plugin.boingpad;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public class BoingPadFallListener implements Listener {

	// TODO: Check if player was launched by a BoingPad and disable fall damage
	// if so and re-enable fall damage after.
	
	public BoingPad plugin;
	
	
	public BoingPadFallListener(BoingPad instance){
		this.plugin = instance;
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onEntityDamage(final EntityDamageEvent e )
	{
		if(!(e.getEntity() instanceof Player)) // If the Player isn't found, don't include him.
			return;
		
		
		Player player = (Player) e.getEntity();
		
		if(e.getCause() == DamageCause.FALL) { // Make sure damage was due to falling
			
			if(plugin.airborneMap.containsKey(player.getPlayer().getName())) // Get the current user. Check if he was affected.
			{
				if(plugin.airborneMap.containsValue(true))
				{
					// Do something to stop fall damage
				}
			}
		}
	}

}
