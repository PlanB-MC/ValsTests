package planB.mc.val.pbUtils;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandList implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            if (cmd.getName().equalsIgnoreCase("planb")) {
                if (args.length == 0) {
                    sender.sendMessage(ChatColor.GOLD + "Usage test");
                    return true;
                }
                switch (args[0]) {
                    case "test": {
                        return test(args, sender);
                    }
                    default: {
                        sender.sendMessage(ChatColor.RED + "command not found!!");
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }

    private boolean test(String[] args, CommandSender sender) {
        if (args.length == 1) {
            sender.sendMessage(ChatColor.RED + "Usage includes Smiling :)");
            return true;
        }
        switch (args[1]) {
            case "a": {
                if (sender.hasPermission("planb.opped")) {

                    return true;
                } else noPermMsg(sender);
                break;
            }
            case "b": {
                if (sender.hasPermission("planb.all")) {

                    return true;
                } else noPermMsg(sender);
                break;
            }
        }
        return false;
    }


    private void noPermMsg(CommandSender sender) {
        sender.sendMessage(ChatColor.RED + "You dont have the permission to use this planB command!");
    }
}
