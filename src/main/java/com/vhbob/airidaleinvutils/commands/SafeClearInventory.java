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
                    ItemStack helm = target.getInventory().getHelmet();
                    if (helm != null && (!helm.hasItemMeta() || !helm.getItemMeta().hasLore())) {
                        target.getInventory().setHelmet(null);
                    }
                    ItemStack chest = target.getInventory().getChestplate();
                    if (chest != null && (!chest.hasItemMeta() || !chest.getItemMeta().hasLore())) {
                        target.getInventory().setChestplate(null);
                    }
                    ItemStack leg = target.getInventory().getLeggings();
                    if (leg != null && (!leg.hasItemMeta() || !leg.getItemMeta().hasLore())) {
                        target.getInventory().setLeggings(null);
                    }
                    ItemStack boot = target.getInventory().getBoots();
                    if (boot != null && (!boot.hasItemMeta() || !boot.getItemMeta().hasLore())) {
                        target.getInventory().setBoots(null);
                    }
                    ItemStack offHand = target.getInventory().getItemInOffHand();
                    if (offHand != null && (!offHand.hasItemMeta() || !offHand.getItemMeta().hasLore())) {
                        target.getInventory().setItemInOffHand(null);
                    }
                    commandSender.sendMessage(ChatColor.GREEN + "Safely cleared " + target.getDisplayName() + "'s inventory");
                    return true;
                }
            }
        }
        return false;
    }
}
