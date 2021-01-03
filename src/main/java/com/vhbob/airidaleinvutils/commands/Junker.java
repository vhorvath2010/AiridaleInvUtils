package com.vhbob.airidaleinvutils.commands;

import com.vhbob.airidaleinvutils.AiridaleInvUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class Junker implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (command.getName().equalsIgnoreCase("Junker")) {
            if (commandSender instanceof Player) {
                Inventory junker = Bukkit.createInventory(null, 54, AiridaleInvUtils.getPlugin().getJunkerTitle());
                ((Player) commandSender).openInventory(junker);
            }
        }
        return false;
    }
}
