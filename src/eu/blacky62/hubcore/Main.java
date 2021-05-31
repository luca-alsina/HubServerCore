package eu.blacky62.hubcore;

import eu.blacky62.hubcore.commands.MainCommand;
import eu.blacky62.hubcore.inventory.Inventory;
import eu.blacky62.hubcore.inventory.ItemInterract;
import eu.blacky62.hubcore.inventory.Items;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static Main instance;
    public static Items items;
    public String consolePrefix =  "[" + this.getConfig().getString("server.plugin") + "] ";

    @Override
    public void onEnable() {
        System.out.println(consolePrefix + "Enabling plugin for " + this.getConfig().getString("server.name"));
        registerConfig();
        registerInstances();
        registerEvents();

        System.out.println(consolePrefix + "Plugin enabled for  " + this.getConfig().getString("server.name"));
    }

    @Override
    public void onDisable() {
        System.out.println(consolePrefix + "Disabling plugin for " + this.getConfig().getString("server.name"));
    }

    public void registerCmds() {
        getCommand("hubcore").setExecutor(new MainCommand());
    }

    public void registerConfig() {
        this.saveDefaultConfig();
        this.reloadConfig();
    }

    public void registerInstances() {
        instance = this;
        items = new Items();
    }

    public void registerEvents() {
        PluginManager pm = getServer().getPluginManager();

        pm.registerEvents(new Inventory(), this);
        pm.registerEvents(new ItemInterract(), this);
    }


}
