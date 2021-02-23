package com.vhbob.airidaleinvutils.events;

import com.vhbob.airidaleinvutils.AiridaleInvUtils;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;

public class JunkerEvents implements Listener {

    @EventHandler
    public void closeJunker(InventoryCloseEvent event) {
        if (event.getView().getTitle().equalsIgnoreCase(AiridaleInvUtils.getPlugin().getJunkerTitle())) {
            // Calculate totals
            double total = 0;
            double worth = AiridaleInvUtils.getPlugin().getConfig().getDouble("worth");
            for (ItemStack selling : event.getView().getTopInventory().getContents()) {
                if (selling != null)
                    total += worth * selling.getAmount();
            }
            // Give money
            if (total > 0) {
                AiridaleInvUtils.getEconomy().depositPlayer((OfflinePlayer) event.getPlayer(), total * 100 / 100);
                event.getPlayer().sendMessage(ChatColor.GREEN + "+$" + round(total, 2));
            } else {
                event.getPlayer().sendMessage(ChatColor.RED + "You did not junk anything valuable");
            }
        }
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

}
