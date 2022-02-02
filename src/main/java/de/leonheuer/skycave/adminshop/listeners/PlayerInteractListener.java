package de.leonheuer.skycave.adminshop.listeners;

import de.leonheuer.skycave.adminshop.AdminShop;
import de.leonheuer.skycave.adminshop.enums.Message;
import de.leonheuer.skycave.adminshop.utils.ShopUtils;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;

import java.io.File;
import java.io.IOException;

public class PlayerInteractListener implements Listener {

    private final AdminShop main;

    public PlayerInteractListener(AdminShop main) {
        this.main = main;
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractAtEntityEvent event) {
        Player player = event.getPlayer();
        Entity entity = event.getRightClicked();
        YamlConfiguration config = main.getConfiguration();

        if (main.setState.contains(player)) {
            config.set("npc_location", entity.getLocation());
            try {
                config.save(new File(main.getDataFolder(), "config.yml"));
                player.sendMessage(Message.SET_SUCCESS.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
                player.sendMessage(Message.SET_ERROR.getMessage());
            }
            main.setState.remove(player);
            return;
        }

        try {
            Location location = config.getObject("npc_location", Location.class);
            if (location != null && location.distance(entity.getLocation()) < .5) {
                player.playSound(player.getLocation(), Sound.ENTITY_PIGLIN_ADMIRING_ITEM, 1.0F, 1.0F);
                ShopUtils.openAdminShop(player, null);
            }
        } catch (Exception ignored) {
        }
    }

}
