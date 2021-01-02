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
            for (ItemStack selling : event.getView().getTopInventory()) {
                if (AiridaleInvUtils.getPlugin().getConfig().contains("worth." + selling.getType().toString())) {
                    double worth = AiridaleInvUtils.getPlugin().getConfig().getDouble("worth." + selling.getType().toString());
                    total += worth * selling.getAmount();
                }
            }
            // Give money
            AiridaleInvUtils.getEconomy().depositPlayer((OfflinePlayer) event.getPlayer(), total);
            event.getPlayer().sendMessage(ChatColor.GREEN + "+$" + total);
        }
    }

}
