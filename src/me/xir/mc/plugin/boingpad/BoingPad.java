package me.xir.mc.plugin.boingpad;

import java.util.ArrayList;

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
	
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
		
		//TODO: CONFIGS
		saveDefaultConfig();
	}
	
	public void onDisable() {
		//do nothing
	}
	
	ArrayList<Integer> bouncingEntities = new ArrayList<Integer>();
	
	@EventHandler
	public void onBoingPad(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (e.getAction().equals(Action.PHYSICAL)) {
			if (e.getClickedBlock().getType().equals(Material.IRON_PLATE)) {
				if (e.getClickedBlock().getRelative(BlockFace.DOWN).getType().equals(Material.REDSTONE_BLOCK)) {
					onBoing(new BoingEvent(e.getClickedBlock(), e.getClickedBlock().getRelative(BlockFace.DOWN), e.getPlayer()));
					p.sendMessage(ChatColor.RED + "BOIINNNG!");
				}
			}
		}
	}
	
	@EventHandler
	public void onBoingPadEnt(EntityInteractEvent e) {
		if (e.getBlock().getType().equals(Material.IRON_PLATE)) {
			if (e.getBlock().getRelative(BlockFace.DOWN).getType().equals(Material.REDSTONE_BLOCK)) {
				onBoing(new BoingEvent(e.getBlock(), e.getBlock().getRelative(BlockFace.DOWN), e.getEntity()));
			}
		}
	}
	
	@EventHandler
	public void onHurt(EntityDamageEvent e) {
		if (e.getCause().equals(EntityDamageEvent.DamageCause.FALL)) {
			Entity ent = e.getEntity();
			if (bouncingEntities.contains(ent.getEntityId())) {
				e.setCancelled(true);
				ent.setFallDistance(0);
				bouncingEntities.remove(bouncingEntities.indexOf(ent.getEntityId()));
			}
		}
	}
	
	public void onBoing(BoingEvent e) {
		Block b = e.getBoingBlock();
		World w = b.getWorld();
		
		int power = 0;
		
		for (int i = 0; i < 3; i++) {
			if (w.getBlockAt(b.getX(), b.getY() - i, b.getZ()).getType().equals(Material.REDSTONE_BLOCK)) {
				power++;
			}
		}
		
		final Entity ent = e.getTriggeringEntity();
		ent.setVelocity(new Vector(0, (2 * power) - 1, 0));
		
		Bukkit.getScheduler().runTaskLater(this,  new Runnable() {
			@Override
			public void run() {
				if (!bouncingEntities.contains(ent.getEntityId())) {
					bouncingEntities.add(ent.getEntityId());
				}
			}
		}, 5);
	}
}
