package me.zbrunooow.bgcassino;

import me.zbrunooow.bgcassino.utils.General;
import me.zbrunooow.bgcassino.utils.Item;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;

public class Comandos implements CommandExecutor {

    Item amarelo = new Item(Material.STAINED_GLASS_PANE, (short) 4);
    int[] slotscustom = {19,21,23,25};

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
        if(cmd.getName().equalsIgnoreCase("cassino")) {
            Player p = (Player) sender;
            Inventory inv = Bukkit.createInventory(null, 9*5, General.get().getBaseCassino().getTitle());
            inv.setContents(General.get().getBaseCassino().getContents());

            p.openInventory(inv);
            p.setMetadata("abrindo", new FixedMetadataValue(Core.getInstance(), "existe"));
            p.setMetadata("cassino", new FixedMetadataValue(Core.getInstance(), "existe"));

            new BukkitRunnable() {
                Random rnd = new Random();
                int i = 0;
                @Override
                public void run() {
                    if(i < 31) {
                        if(i == 0) {
                            inv.setItem(11, General.get().getItems().get(rnd.nextInt(9)).build());
                        }
                        if(i == 1) {
                            inv.setItem(20, inv.getItem(11));
                            inv.setItem(11, General.get().getItems().get(rnd.nextInt(9)).build());
                        }
                        inv.setItem(29, inv.getItem(20));
                        inv.setItem(20, inv.getItem(11));
                        inv.setItem(11, General.get().getItems().get(rnd.nextInt(9)).build());
                    } else if(i < 61) {
                        if(i == 31) {
                            inv.setItem(13, General.get().getItems().get(rnd.nextInt(9)).build());
                        }
                        if(i == 32) {
                            inv.setItem(22, inv.getItem(13));
                            inv.setItem(13, General.get().getItems().get(rnd.nextInt(9)).build());
                        }
                        inv.setItem(31, inv.getItem(22));
                        inv.setItem(22, inv.getItem(13));
                        inv.setItem(13, General.get().getItems().get(rnd.nextInt(9)).build());
                    } else if(i < 91) {
                        if(i == 0) {
                            inv.setItem(15, General.get().getItems().get(rnd.nextInt(9)).build());
                        }
                        if(i == 1) {
                            inv.setItem(24, inv.getItem(15));
                            inv.setItem(15, General.get().getItems().get(rnd.nextInt(9)).build());
                        }
                        inv.setItem(33, inv.getItem(24));
                        inv.setItem(24, inv.getItem(15));
                        inv.setItem(15, General.get().getItems().get(rnd.nextInt(9)).build());
                    } else {
                        p.getInventory().addItem(General.get().getItem(ChatColor.stripColor(inv.getItem(20).getItemMeta().getDisplayName().split(" ")[0]).replace("C", "")));
                        p.getInventory().addItem(General.get().getItem(ChatColor.stripColor(inv.getItem(22).getItemMeta().getDisplayName().split(" ")[0]).replace("C", "")));
                        p.getInventory().addItem(General.get().getItem(ChatColor.stripColor(inv.getItem(24).getItemMeta().getDisplayName().split(" ")[0]).replace("C", "")));

                        amarelo.setDisplayName("§6S§eo§6r§et§6e§ea§6d§eo§f!!!");
                        for(int o : slotscustom) {
                            inv.setItem(o, amarelo.build().clone());
                        }

                        p.removeMetadata("cassino", Core.getInstance());
                        p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 1, 1);
                        p.sendMessage("VC GANHOU AI OS BGL");
                        cancel();
                    }
                    p.playSound(p.getLocation(), Sound.CLICK, 1, 1);
                    i++;
                }
            }.runTaskTimerAsynchronously(Core.getInstance(), 0, 2);

        }

        return false;
    }
}
