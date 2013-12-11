package me.xir.mc.plugin.boingpad;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class BoingPadPlayerListener implements Listener {
	public BoingPad plugin;

	public BoingPadPlayerListener(BoingPad instance) {
		plugin = instance;
	}

	// TODO: Check if triggering entity is player and player is on foot.
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {

	}

	// TODO: Check if triggering entity is horse and passenger is player.
	@EventHandler
	public void onEntityMove(PlayerMoveEvent e) {

	}

}
