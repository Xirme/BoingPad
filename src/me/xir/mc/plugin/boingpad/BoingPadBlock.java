package me.xir.mc.plugin.boingpad;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class BoingPadBlock implements Listener {
	
	private BoingPad plugin;
	
	public BoingPadBlock(BoingPad p) {
		plugin = p;
	}
	
	@EventHandler
	public void onStep(PlayerInteractEvent e) {
		if ((e.getAction() == Action.PHYSICAL) && /* INVISIBLE PLAYER :( */) {
			e.setCancelled(true);
		}
		
	}

}
