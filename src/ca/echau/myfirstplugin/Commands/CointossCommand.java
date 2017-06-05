package ca.echau.myfirstplugin.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CointossCommand implements CommandExecutor {
	@Override
	public boolean onCommand(final CommandSender theSender, final Command cmd, final String commandLabel,
			final String args[]) {
		if (theSender instanceof Player) {
			final Player player = (Player) theSender;
			if (commandLabel.equalsIgnoreCase("cointoss")) {
				if (player.hasPermission("myfirstplugin.cointoss")) {
					if (args.length == 1) {
						if (args[0].equalsIgnoreCase("heads") || args[0].equalsIgnoreCase("tails")) {
							double coinTossResult = Math.round(Math.random()); //Either 0 or 1 value
							if (coinTossResult == 0) { //Coin toss returned heads
								player.sendMessage(ChatColor.GOLD + "You guessed " + ChatColor.RED + args[0] + ChatColor.GOLD + ". The result was " + ChatColor.RED + "heads" + ChatColor.GOLD + ".");
								if (args[0].equalsIgnoreCase("heads")) {
									player.sendMessage(ChatColor.GREEN + "You win!");
								} else {
									player.sendMessage(ChatColor.RED + "You lose.");
								}
							} else { //Coin toss returned tails
								player.sendMessage(ChatColor.GOLD + "You guessed " + ChatColor.RED + args[0] + ChatColor.GOLD + ". The result was " + ChatColor.RED + "tails" + ChatColor.GOLD + ".");
								if (args[0].equalsIgnoreCase("tails")) {
									player.sendMessage(ChatColor.GREEN + "You win!");
								} else {
									player.sendMessage(ChatColor.RED + "You lose.");
								}
							}
							return true;
						} else { //Player typed something other than heads or tails.
							player.sendMessage(ChatColor.RED + "Invalid arguments! Command usage: /cointoss <heads / tails>");
						}
					} else { //Player did not have exactly 1 argument
						player.sendMessage(ChatColor.RED + "Invalid arguments! Command usage: /cointoss <heads / tails>");
					}
				} else { //No perms
					player.sendMessage(ChatColor.RED + "You don't have permission to use this command!" );
				}
			} 
		}
		return false;
	}
}
