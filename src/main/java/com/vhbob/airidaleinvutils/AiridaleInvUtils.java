package com.vhbob.airidaleinvutils;

import com.vhbob.airidaleinvutils.commands.SafeClearInventory;
import com.vhbob.airidaleinvutils.events.JunkerEvents;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class AiridaleInvUtils extends JavaPlugin {

    private static AiridaleInvUtils plugin;
    private static Economy econ;

    @Override
    public void onEnable() {
        if (!setupEconomy() ) {
            Bukkit.getConsoleSender().sendMessage(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        plugin = this;
        saveDefaultConfig();
        getCommand("SafeClearInventory").setExecutor(new SafeClearInventory());
        Bukkit.getPluginManager().registerEvents(new JunkerEvents(), this);
    }

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }

    public static AiridaleInvUtils getPlugin() {
        return plugin;
    }

    public static Economy getEconomy() {
        return econ;
    }

    public String getJunkerTitle() {
        return ChatColor.translateAlternateColorCodes('&', AiridaleInvUtils.getPlugin().getConfig().getString("junker-title"));
    }

}
