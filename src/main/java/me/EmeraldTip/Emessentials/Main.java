package me.EmeraldTip.Emessentials;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.annotation.permission.ChildPermission;
import org.bukkit.plugin.java.annotation.permission.Permission;
import org.bukkit.plugin.java.annotation.permission.Permissions;
import org.bukkit.plugin.java.annotation.plugin.Description;
import org.bukkit.plugin.java.annotation.plugin.LogPrefix;
import org.bukkit.plugin.java.annotation.plugin.Plugin;
import org.bukkit.plugin.java.annotation.plugin.author.Author;

import co.aikar.commands.PaperCommandManager;
import io.papermc.paper.plugin.configuration.PluginMeta;
import me.EmeraldTip.Emessentials.Commands.CommandEmessentials;
import me.EmeraldTip.Emessentials.Commands.CommandFly;

//plugin.yml annotations setup
@Plugin(name="Emessentials", version="0.0.1")
@Description("Garbage essentials plugin")
@Author("Emerald_tip")
@LogPrefix("Emessentials")

@Permissions(
@Permission(
		name="emessentials.*", 
		children = 
			{@ChildPermission(name ="emessentials.info"),
			@ChildPermission(name ="emessentials.admin"),
			@ChildPermission(name ="emessentials.fly")}
		)
)

public class Main extends JavaPlugin implements Listener{
	
    private static PaperCommandManager commandManager;
	
	public void onEnable() {
		PluginMeta pluginMeta = getPluginMeta(); 
		Logger logger = Logger.getLogger("Minecraft");
		logger.info("[" + pluginMeta.getName() + "] " + pluginMeta.getName() + " has been enabled! " + "(v" + pluginMeta.getVersion() + ")");
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
		registerCmds();
	}
	
	public void onDisable() {
		PluginMeta pluginMeta = getPluginMeta(); 
		Logger logger = Logger.getLogger("Minecraft");
		logger.info("[" + pluginMeta.getName() + "] " + pluginMeta.getName() + " has been disabled! " + "(v" + pluginMeta.getVersion() + ")");
	}
	
	   
    private void registerCmds()
    {
    	commandManager = new PaperCommandManager(this);
    	
    	commandManager.registerCommand(new CommandEmessentials(this));
    	commandManager.registerCommand(new CommandFly());
    }
	
	//TODO list
	/*
	 * Commands to add:
	 * 	Fly
	 * 	Suicide
	 * 	Gamemode commands (gmc, gms, gmsp, gma)
	 * 	Tpall
	 * 	Tphere
	 * 	Enchant (remove limits on ench levels)
	 * 	Spawn
	 * 	Heal
	 * 	Feed
	 * 	Sudo?
	 * 
	 */	
}
