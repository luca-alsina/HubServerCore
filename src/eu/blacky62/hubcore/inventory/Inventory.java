package eu.blacky62.hubcore.inventory;

import eu.blacky62.hubcore.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Inventory implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        System.out.println("Player join");
        /*
        Clear the player inv
         */
        if (Main.instance.getConfig().getBoolean("onjoin.clearinv")) {
            p.getInventory().clear();
        }

        if (Main.instance.getConfig().getBoolean("items.enable")) {
            Main.items.giveHubItems(p);
        }

    }

}
