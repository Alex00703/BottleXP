package fr.alex.plugin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import fr.alex.commands.BottleXPCommand;
import fr.alex.listeners.BottleXPListener;

public class BottleXP extends JavaPlugin {

	@Override
	public void onEnable() {
		getCommand("bottlexp").setExecutor(new BottleXPCommand());
		Bukkit.getPluginManager().registerEvents(new BottleXPListener(), this);
	}
	
	@Override
	public void onDisable() {

	}
	
}
