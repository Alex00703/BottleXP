package fr.alex.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.minecraft.server.v1_8_R3.EnumChatFormat;

public class BottleXPCommand implements CommandExecutor {

	@SuppressWarnings("unchecked")
	@Override
	public boolean onCommand(CommandSender s, Command c, String arg, String[] args) {
		
		if(s instanceof Player) {
			
			Player p = (Player)s;
			
			if(p.getInventory().firstEmpty() == -1) {
				p.sendMessage(EnumChatFormat.RED + "Votre inventaire est plein.");
				return false;
			}
			
			ItemStack bottle = new ItemStack(Material.EXP_BOTTLE, 1);
			ItemMeta meta = bottle.getItemMeta();
			List lore = new ArrayList<>();
			lore.add("Exp : " + p.getLevel());
			meta.setLore(lore);
			bottle.setItemMeta(meta);
			
			p.getInventory().addItem(bottle);
			p.updateInventory();
			p.sendMessage(EnumChatFormat.GREEN + "Vous venez de convertir votre exp en bouteille.");
			
			p.setLevel(0);
		}
		
		return false;
	}

}
