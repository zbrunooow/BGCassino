package me.zbrunooow.bgcassino.listeners;

import me.zbrunooow.bgcassino.Core;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class InventoryUpdate implements Listener {

    @EventHandler
    public void aoClicarInventario(InventoryClickEvent e) {
        if(e.getWhoClicked().hasMetadata("cassino") || e.getWhoClicked().hasMetadata("abrindo")) {
            e.setCancelled(true);
            e.getWhoClicked().sendMessage("Você não pode clicar em nenhum item enquanto abre uma chave de cassino!");
        }
    }

    @EventHandler
    public void aoFecharInventory(InventoryCloseEvent e) {
        if (e.getInventory().getName().contains("Cassino")) {
            e.getPlayer().removeMetadata("abrindo", Core.getInstance());
        }
    }

}
