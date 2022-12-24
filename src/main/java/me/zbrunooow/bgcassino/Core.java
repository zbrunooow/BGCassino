package me.zbrunooow.bgcassino;

import me.zbrunooow.bgcassino.listeners.InventoryUpdate;
import me.zbrunooow.bgcassino.utils.General;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin {

    private String prefix = (ChatColor.LIGHT_PURPLE + "[" + getDescription().getName()) + " " + getDescription().getVersion() + "] ";

    public static Core instance;

    private General api;

    @Override
    public void onEnable() {
        instance = this;
        api = new General();

        getServer().getPluginManager().registerEvents(new InventoryUpdate(), this);

        getCommand("cassino").setExecutor(new Comandos());
        Bukkit.getConsoleSender().sendMessage(prefix + "§aPlugin habilitado.");
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(prefix + "§aPlugin desabilitado.");
    }

    public static Core getInstance() {
        return instance;
    }

    public General getGeneral() {
        return api;
    }

}
