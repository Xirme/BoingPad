package me.xir.mc.plugin.boingpad;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class BoingPadBlock implements Listener {

	private BoingPad plugin;

	public BoingPadBlock(BoingPad p) {
		plugin = p;
	}

	@EventHandler
	public void onBoingPad(PlayerInteractEvent e) {
		Player player = e.getPlayer();
		Block block = player.getLocation().getBlock();
		Block blockUnder = block.getRelative(BlockFace.DOWN);
		Block blockAbove = block.getRelative(BlockFace.UP);
		if (blockAbove.getType() == Material.IRON_PLATE || blockUnder.getType() == Material.REDSTONE_BLOCK) {
			if (e.getAction() == Action.PHYSICAL) {
				if (e.getClickedBlock().getType() == Material.IRON_PLATE) {
					player.sendMessage("IT WORKS");
					System.out.println(player + "has stepped on the BoingPad!");
				}
			}
		} else {
			player.sendMessage("Something went wrong at blockAbove/blockUnder");
		}
	}
}
