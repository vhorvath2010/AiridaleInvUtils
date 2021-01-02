package com.vhbob.airidaleinvutils.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class SafeClearInventory implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (command.getName().equalsIgnoreCase("SafeClearInventory")) {
            if (strings.length == 1) {
                Player target = Bukkit.getPlayer(strings[0]);
                if (target != null) {
                    for (ItemStack itemStack : target.getInventory().getContents()) {
                        if (itemStack != null && (!itemStack.hasItemMeta() || !itemStack.getItemMeta().hasLore())) {
                            target.getInventory().removeItem(itemStack);
                        }
                    }
                    commandSender.sendMessage(ChatColor.GREEN + "Safely cleared " + target.getDisplayName() + "'s inventory");
                    return true;
                }
            }
        }
        return false;
    }
}
