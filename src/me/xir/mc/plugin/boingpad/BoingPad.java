package me.xir.mc.plugin.boingpad;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityInteractEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

public class BoingPad extends JavaPlugin implements Listener {

	public HashMap<String, Double> velocityMap;
	public HashMap<String, Boolean> airborneMap;
	
	public void onEnable() {
		
		velocityMap = HashMap<String, Double>(); // This is the map to adjust velocity for the player
		airborneMap = HashMap<String, Boolean>(); // This is a metaKey to say the user is flying in the air.
		getServer().getPluginManager().registerEvents(this, this);

		// TODO: CONFIGS
		saveDefaultConfig();
	}

	public void onDisable() {
		// do nothing
	}
}
