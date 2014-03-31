package com.frogman786;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.Listener;

public class daylight extends JavaPlugin implements Listener {

	public final Logger Log = Logger.getLogger("Minecarft");
	public static daylight plugin;

	public void onDisable(){
		PluginDescriptionFile pdfFile = this.getDescription();
		this.Log.info(pdfFile.getName() + " Has Been Disabled! ");
	}

	public void onEnable(){
		getServer().getPluginManager().registerEvents(this, this);
		PluginDescriptionFile pdfFile = this.getDescription();
		this.Log.info(pdfFile.getName() + pdfFile.getVersion() +  " Has Been Enabled! ");
	}

	public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args){
		Player player = (Player) sender;
		World world = player.getWorld();
		if(lbl.equalsIgnoreCase("dawn")){
			if(player.hasPermission("frog.time.dawn")){
				getServer().broadcastMessage(player.getPlayerListName() + ChatColor.WHITE +" Set " + ChatColor.DARK_GREEN + player.getWorld().getName() + ChatColor.WHITE + " to dawn.");
				world.setTime(23000);
				return true;
			}else{
				player.sendMessage(ChatColor.RED + "You do not have permission to use this command!");
				return true;
			}
		}
		if(lbl.equalsIgnoreCase("day")){
			if(player.hasPermission("frog.time.day")){
				getServer().broadcastMessage(player.getPlayerListName() + ChatColor.WHITE +" Set " + ChatColor.DARK_GREEN + player.getWorld().getName() + ChatColor.WHITE + " to day.");
				world.setTime(0);
				return true;
			}else{
				player.sendMessage(ChatColor.RED + "You do not have permission to use this command!");
				return true;
			}
		}
		if(lbl.equalsIgnoreCase("noon")){
			if(player.hasPermission("frog.time.noon")){
				getServer().broadcastMessage(player.getPlayerListName() + ChatColor.WHITE +" Set " + ChatColor.DARK_GREEN + player.getWorld().getName() + ChatColor.WHITE + " to noon.");
				world.setTime(7000);
				return true;
			}else{
				player.sendMessage(ChatColor.RED + "You do not have permission to use this command!");
				return true;
			}
		}
		if(lbl.equalsIgnoreCase("dusk")){
			if(player.hasPermission("frog.time.dusk")){
				getServer().broadcastMessage(player.getPlayerListName() + ChatColor.WHITE +" Set " + ChatColor.DARK_GREEN + player.getWorld().getName() + ChatColor.WHITE + " to dusk.");
				world.setTime(12500);
				return true;
			}else{
				player.sendMessage(ChatColor.RED + "You do not have permission to use this command!");
				return true;
			}
		}
		if(lbl.equalsIgnoreCase("night")){
			if(player.hasPermission("frog.time.night")){
				getServer().broadcastMessage(player.getPlayerListName() + ChatColor.WHITE +" Set " + ChatColor.DARK_GREEN + player.getWorld().getName() + ChatColor.WHITE + " to night.");
				world.setTime(15000);
				return true;
			}else{
				player.sendMessage(ChatColor.RED + "You do not have permission to use this command!");
				return true;
			}
		}
		if(lbl.equalsIgnoreCase("who")){
			if(player.hasPermission("frog.who.who")){
				player.sendMessage("there are some people online");
			return true;
			}else{
				player.sendMessage(ChatColor.RED + "You do not have permission to use this command!");
				return true;
			}
		}
		if(lbl.equalsIgnoreCase("gm")){
			if(player.hasPermission("frog.gamemode.self")){
				player.sendMessage("Gamemode set to" + ChatColor.DARK_GREEN + "nothing");
			return true;
			}else{
				player.sendMessage(ChatColor.RED + "You do not have permission to use this command!");
				return true;
			}
		}
		//NEED TO ADD REGION AND AIR CHECKING TO THIS
		if(lbl.equalsIgnoreCase("platform")){
			if(player.hasPermission("frog.platform.single")){
			    Location loc = player.getPlayer().getLocation();
			    loc.setY(loc.getY() - 1);
			    Block b = loc.getBlock();
			    b.setType(Material.GLASS);
				player.sendMessage(ChatColor.DARK_GREEN + "Platform created.");
			return true;
			}else{
				player.sendMessage(ChatColor.RED + "You do not have permission to use this command!");
				return true;
			}
		}
		return false; 
	
	}

}