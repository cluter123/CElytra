package me.cluter.celytra;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{
	public void onEnable() {
		elytra();
		saveDefaultConfig();
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
	}
	
	public void elytra() {
		ItemStack ely = new ItemStack(Material.ELYTRA, 1);
		ItemMeta meta = ely.getItemMeta();
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', getConfig().getString("name")));
		meta.setLore(Arrays.asList(ChatColor.translateAlternateColorCodes('&', getConfig().getString("lore"))));
		ely.setItemMeta(meta);
		
		ShapedRecipe e = new ShapedRecipe(ely);
		e.shape("@#@", "@ @", "@ @");
		e.setIngredient('@', Material.STONE_PLATE);
		e.setIngredient('#', Material.STICK);
		Bukkit.getServer().addRecipe(e);
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		e.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("message")));
	}
}
