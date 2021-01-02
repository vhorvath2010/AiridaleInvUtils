package com.vhbob.airidaleinvutils;

import com.vhbob.airidaleinvutils.commands.SafeClearInventory;
import org.bukkit.plugin.java.JavaPlugin;

public class AiridaleInvUtils extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        getCommand("SafeClearInventory").setExecutor(new SafeClearInventory());
    }
}
