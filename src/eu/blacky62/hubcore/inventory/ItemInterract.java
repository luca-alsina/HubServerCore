package eu.blacky62.hubcore.inventory;

import eu.blacky62.hubcore.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class ItemInterract implements Listener {

    @EventHandler
    public void onItemInterract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        Action a = e.getAction();

        if (a == Action.RIGHT_CLICK_AIR || a == Action.RIGHT_CLICK_BLOCK) {
            if (Main.instance.getConfig().getBoolean("items.players_hide_item.enable")) {
                System.out.println("RC Air/Block & enabled in conf");
                if (p.getItemInHand().getItemMeta() == null
                        || p.getItemInHand() == null
                        || p.getItemInHand().getItemMeta().getDisplayName() == null) return;
                if (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(Main.instance.getConfig().getString("items.players_hide_item.show_item.name"))) {
                    System.out.println("Good item");
                    Main.items.givePlayersHiderItem(p, false);
                } else if (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(Main.instance.getConfig().getString("items.players_hide_item.hide_item.name"))) {
                    System.out.println("Good item 2");
                    Main.items.givePlayersHiderItem(p, true);
                }
            }
        }

    }
}
