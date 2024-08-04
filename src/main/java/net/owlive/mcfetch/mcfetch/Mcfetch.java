package net.owlive.mcfetch.mcfetch;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Mcfetch extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.broadcastMessage("Powered by Java!");
        this.getCommand("mcfetch").setExecutor(new McfetchCommand());
    }
}
