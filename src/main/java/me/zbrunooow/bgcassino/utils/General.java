package me.zbrunooow.bgcassino.utils;

import me.zbrunooow.bgcassino.Core;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class General {

    public Inventory baseCassino = Bukkit.createInventory(null, 9*5, "§2$ Cassino");
    public List<Item> items = new ArrayList<>();

    public General() {
        int[] slotspreto = {1,3,5,7,9,10,12,14,16,17,18,26,27,28,30,32,34,35,37,39,41,43};
        int[] slotsbranco = {0,8,36,44};
        int[] slotsferro = {2,4,6,38,40,42};
        int[] slotscustom = {19,21,23,25};
        Item vidropreto = new Item(Material.STAINED_GLASS_PANE, (short) 15);
        vidropreto.setDisplayName(" ");
        Item vidrobranco = new Item(Material.STAINED_GLASS_PANE, (short) 0);
        vidrobranco.setDisplayName(" ");
        Item ferro = new Item(Material.IRON_FENCE);
        ferro.setDisplayName(" ");
        Item netherstar = new Item(Material.NETHER_STAR);
        netherstar.setDisplayName("§eS§6o§er§6t§ee§6a§en§6d§eo§7...");
        for(int i : slotspreto) {
            baseCassino.setItem(i, vidropreto.build().clone());
        }
        for(int i : slotsbranco) {
            baseCassino.setItem(i, vidrobranco.build().clone());
        }
        for(int i : slotsferro) {
            baseCassino.setItem(i, ferro.build().clone());
        }
        for(int i : slotscustom) {
            baseCassino.setItem(i, netherstar.build().clone());
        }
        Item C1 = new Item(Material.INK_SACK, (short) 15);
        C1.setDisplayName("§3C1 §8/ §7Sorteando...");
        Item C2 = new Item(Material.INK_SACK, (short) 7);
        C2.setDisplayName("§3C2 §8/ §7Sorteando...");
        Item C3 = new Item(Material.INK_SACK, (short) 8);
        C3.setDisplayName("§3C3 §8/ §7Sorteando...");
        Item C4 = new Item(Material.INK_SACK, (short) 10);
        C4.setDisplayName("§3C4 §8/ §7Sorteando...");
        Item C5 = new Item(Material.INK_SACK, (short) 14);
        C5.setDisplayName("§3C5 §8/ §7Sorteando...");
        Item C6 = new Item(Material.INK_SACK, (short) 9);
        C6.setDisplayName("§3C6 §8/ §7Sorteando...");
        Item C7 = new Item(Material.INK_SACK, (short) 5);
        C7.setDisplayName("§3C7 §8/ §7Sorteando...");
        Item C8 = new Item(Material.INK_SACK, (short) 6);
        C8.setDisplayName("§3C8 §8/ §7Sorteando...");
        Item C9 = new Item(Material.INK_SACK, (short) 1);
        C9.setDisplayName("§3C9 §8/ §7Sorteando...");

        items.add(C1);items.add(C2);items.add(C3);
        items.add(C4);items.add(C5);items.add(C6);
        items.add(C7);items.add(C8);items.add(C9);
    }

    public ItemStack getItem(String nome) {
        Item item = getItems().get(Integer.parseInt(nome)-1);
        item.setDisplayName("§3C" + nome + " §8/ §7Right Click");
        item.setLore("§e/cassino");

        return item.build().clone();
    }

    public static General get(){
        return Core.getInstance().getGeneral();
    }

    public Inventory getBaseCassino() {
        return baseCassino;
    }

    public List<Item> getItems() {
        return items;
    }
}
