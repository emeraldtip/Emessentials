package me.EmeraldTip.Emessentials.Commands;

import org.bukkit.entity.Player;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import me.EmeraldTip.Emessentials.Main;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;

@CommandAlias("emessentials")
@CommandPermission("emessentials.info")
public class CommandEmessentials extends BaseCommand {
	
	Main plugin;
	
	public CommandEmessentials(Main main) {
		plugin = main;
	}

	@Default
    public void onCommand(Player sender) {
    	TextComponent component = Component.text("§a§l---Emessentials---\n")
    			.append(Component.text(plugin.getPluginMeta().getDescription()+"\n"))
    			.append(Component.text("§2Version: §e"+plugin.getPluginMeta().getVersion()+"\n"))
    			.append(Component.text("§2By: §e"+plugin.getPluginMeta().getAuthors().get(0)+"\n"))
    			.append(Component.text("§a§l------------------"));
    	sender.sendMessage(component);
    }
}
