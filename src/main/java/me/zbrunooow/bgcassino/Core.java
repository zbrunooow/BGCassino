package me.zbrunooow.bgcassino;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin {

    private String prefix = (ChatColor.LIGHT_PURPLE + "[" + getDescription().getName()) + " " + getDescription().getVersion() + "] ";

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(prefix + "§aPlugin habilitado.");
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(prefix + "§aPlugin desabilitado.");
    }

}
