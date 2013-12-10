package me.xir.mc.plugin.boingpad;

import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class BoingPad extends JavaPlugin implements Listener {
	
	public void onEnable() {
		
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new BoingPadBlock(this), this);
		
		saveDefaultConfig();
		
	}
	
	public void onDisable() {
		//do nothing
	}

}
