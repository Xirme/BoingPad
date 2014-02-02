package me.xir.mc.plugin.boingpad;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

public class BoingPadPlayerListener implements Listener {
	public BoingPad plugin;
	

	
	public BoingPadPlayerListener(BoingPad instance) {
		plugin = instance;
	}

	// TODO: Check if triggering entity is player and player is on foot.
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		Player player = e.getPlayer();

		Block block = player.getLocation().getBlock(); // Block below player
		Block blockBelow = block.getRelative( BlockFace.DOWN ); // Block below that block
		
		if(blockBelow.getType() == Material.IRON_PLATE)
		{
			if(block.getType() == Material.REDSTONE_BLOCK) //Redstone should be on top.
			{
				if(!player.hasPermission("BoingPad.use") || !(Boolean)player.getPlayer().isOp())
					return;
				else if(player.getVehicle() instanceof Horse)
					return ; // What? They should be triggered by the entitymove listener
				else {
					Location location = player.getLocation(); // Current user location
					double locationX = location.getX();
					double locationY = location.getY();
					double locationZ = location.getZ();
					/** Current location x,y,z **/
					
					Vector velocity = player.getVelocity(); // Momentum from direction what?
					double velocityX = velocity.getX();
					double velocityY = velocity.getY();
					double velocityZ = velocity.getZ();
					/** Incoming Velocity  **/
					
					plugin.getConfig().getDouble("velocity-multiplier"); // Variable from the configuration
					
					plugin.velocityMap.put(player.getName(), 2.0 ); // TODO: Set configuration multipiler
					
				}
			}
		}
		else
		{
			return; // Skip checks
		}
		

	}

	@EventHandler
	public void onPlayerMoveEvent(PlayerMoveEvent e) {
	}

	// TODO: Check if triggering entity is horse and passenger is player.
	@EventHandler
	public void onEntityMove(PlayerMoveEvent e) {
		Player ply = e.getPlayer();
		if(ply.getVehicle() instanceof Horse)
		{
			
		}
	}

}
