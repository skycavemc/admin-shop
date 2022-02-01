package de.leonheuer.skycave.adminshop;

import de.leonheuer.skycave.adminshop.commands.SetCommand;
import de.leonheuer.skycave.adminshop.commands.ShopCommand;
import de.leonheuer.skycave.adminshop.listeners.InventoryClickListener;
import de.leonheuer.skycave.adminshop.listeners.PlayerInteractListener;
import de.leonheuer.skycave.adminshop.utils.FileUtils;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.PluginCommand;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public final class AdminShop extends JavaPlugin {

    public final List<Player> setState = new ArrayList<>();
    public final List<Player> stackItems = new ArrayList<>();
    private Economy econ = null;
    private YamlConfiguration config = null;

    @Override
    public void onEnable() {
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            getLogger().severe("Vault economy registration not found, disabling plugin.");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        econ = rsp.getProvider();

        if (!getDataFolder().exists()) {
            //noinspection ResultOfMethodCallIgnored
            getDataFolder().mkdirs();
        }
        if (FileUtils.copyResource(this, "config.yml")) {
            config = YamlConfiguration.loadConfiguration(new File(getDataFolder(), "config.yml"));
        }

        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new InventoryClickListener(this), this);
        pm.registerEvents(new PlayerInteractListener(this), this);

        registerCommand("setadminshop", new SetCommand(this));
        registerCommand("shop", new ShopCommand(this));
    }

    private void registerCommand(String command, CommandExecutor executor) {
        PluginCommand cmd = this.getCommand(command);
        if (cmd == null) {
            getLogger().severe("The command /" + command + " has no entry in the plugin.yml.");
            return;
        }
        cmd.setExecutor(executor);
    }

    public Economy getEcon() {
        return econ;
    }

    @NotNull
    public YamlConfiguration getConfiguration() {
        return config;
    }
}
