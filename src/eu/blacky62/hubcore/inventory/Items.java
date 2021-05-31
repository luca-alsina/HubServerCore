package eu.blacky62.hubcore.inventory;

import eu.blacky62.hubcore.Main;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Items {

    public void giveHubItems(Player p) {
        System.out.println("GiveHubItems");
        /*
        Players Hider
         */
        if (Main.instance.getConfig().getBoolean("items.players_hide_item.enable")) {
            givePlayersHiderItem(p, true);
        }
        /*
        End Players Hider item
         */

    }

    /*
    Playre p = Player to give the item
    Boolean t = Type of the item (True = Hide, False = Show)
     */
    public void givePlayersHiderItem(Player p, Boolean t) {

        if (t) {
            ItemStack si = new ItemStack(Material.getMaterial(Main.instance.getConfig().getString("items.players_hide_item.show_item.item")), 1, Short.parseShort(Main.instance.getConfig().getString("items.players_hide_item.show_item.data")));
            ItemMeta sim = si.getItemMeta();

            List<String> sl = new ArrayList<>();

            for (String add : Main.instance.getConfig().getStringList("items.players_hide_item.show_item.lore")) sl.add(add);

            sim.setLore(sl);
            sim.setDisplayName(Main.instance.getConfig().getString("items.players_hide_item.show_item.name"));
            si.setItemMeta(sim);
            p.getInventory().setItem(Main.instance.getConfig().getInt("items.players_hide_item.slot") - 1, si);

        } else {
            ItemStack si = new ItemStack(Material.getMaterial(Main.instance.getConfig().getString("items.players_hide_item.hide_item.item")), 1, Short.parseShort(Main.instance.getConfig().getString("items.players_hide_item.show_item.data")));
            ItemMeta sim = si.getItemMeta();

            List<String> sl = new ArrayList<>();

            for (String add : Main.instance.getConfig().getStringList("items.players_hide_item.hide_item.lore")) sl.add(add);

            sim.setLore(sl);
            sim.setDisplayName(Main.instance.getConfig().getString("items.players_hide_item.hide_item.name"));
            si.setItemMeta(sim);
            p.getInventory().setItem(Main.instance.getConfig().getInt("items.players_hide_item.slot") - 1, si);

        }
    }

}
