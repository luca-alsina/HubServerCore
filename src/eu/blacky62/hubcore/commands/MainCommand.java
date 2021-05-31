package eu.blacky62.hubcore.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MainCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("You can only execute this command ingame !");
        } else {
            Player p = (Player) sender;
            if (!p.hasPermission("rank.admin")) {
                sender.sendMessage("You don't have permission for that !");
            } else {

            }
        }
        return true;
    }
}
