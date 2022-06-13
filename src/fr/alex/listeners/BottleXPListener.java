package fr.alex.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class BottleXPListener implements Listener {

	
	@EventHandler
	public void interact(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		Action a = e.getAction();
		ItemStack bottle = p.getItemInHand();
		Material m = bottle.getType();
		
		if(m == Material.EXP_BOTTLE) {
			if(bottle.hasItemMeta() && bottle.getItemMeta().getLore().get(0).contains("Exp")) {
				String xp = bottle.getItemMeta().getLore().get(0).replace("Exp : ", "");
				p.giveExpLevels(Integer.valueOf(xp));
				p.getInventory().remove(bottle);
			}
		}
		
	}
	
}
