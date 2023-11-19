package io.github.fabspu.biggertreesplugin;

import org.bukkit.Bukkit;
import org.bukkit.event.EventPriority;
import org.bukkit.plugin.java.JavaPlugin;

public final class BiggerTreesPlugin extends JavaPlugin{

    public BiggerTreesPlugin(){}

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getPluginManager().registerEvents(new JoinListener(),this);
        Bukkit.getPluginManager().registerEvents(new MessageListener(), this);
        Bukkit.getPluginManager().registerEvents(new TreeListener(), this);
    }




    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
