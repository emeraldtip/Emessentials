package me.EmeraldTip.Emessentials.Commands;

import org.bukkit.entity.Player;

import co.aikar.commands.BaseCommand;

public class CommandFly  extends BaseCommand {


    public void onCommand(Player sender) {
		if (sender.getAllowFlight()){
			sender.setAllowFlight(false);
		}
		else {
			sender.setAllowFlight(true);
		}
    }
}
