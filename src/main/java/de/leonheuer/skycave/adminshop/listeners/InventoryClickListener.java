package de.leonheuer.skycave.adminshop.listeners;

import de.leonheuer.skycave.adminshop.AdminShop;
import de.leonheuer.skycave.adminshop.enums.ItemCategory;
import de.leonheuer.skycave.adminshop.enums.ShopItem;
import de.leonheuer.skycave.adminshop.enums.ShopSpawner;
import de.leonheuer.skycave.adminshop.utils.ShopUtils;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class InventoryClickListener implements Listener {

    private final AdminShop main;

    public InventoryClickListener(AdminShop main) {
        this.main = main;
    }

    @SuppressWarnings("deprecation")
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (!player.getOpenInventory().getTitle().equals("§6✪ §4Admin Shop")) {
            return;
        }

        event.setCancelled(true);
        ItemStack item = event.getCurrentItem();
        if (item == null) {
            return;
        }

        ItemCategory category = ItemCategory.fromItemStack(item);
        if (category != null) {
            player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 1.0F, 1.0F);
            ShopUtils.openAdminShop(player, category);
            return;
        }

        String title = Objects.requireNonNull(item.getItemMeta()).getDisplayName();

        switch (item.getType()) {
            case GRAY_DYE -> {
                if (title.startsWith("§e") && title.endsWith(" x1")) {
                    category = ItemCategory.fromString(title);
                    if (category != null) {
                        main.stackItems.add(player);
                        player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 1.0F, 1.0F);
                        ShopUtils.openAdminShop(player, category);
                    }
                }
            }
            case LIME_DYE -> {
                if (title.startsWith("§e") && title.endsWith(" x64")) {
                    category = ItemCategory.fromString(title);
                    if (category != null) {
                        main.stackItems.remove(player);
                        player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 1.0F, 1.0F);
                        ShopUtils.openAdminShop(player, category);
                    }
                }
            }
            case OAK_DOOR -> {
                if (title.equals("§cZurück")) {
                    player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 1.0F, 1.0F);
                    ShopUtils.openAdminShop(player, null);
                }
            }
            default -> {
                if (title.startsWith("§e")) {
                    ShopItem shopItem = ShopItem.fromItemStack(item);
                    if (shopItem != null) {
                        ShopUtils.buyItem(player, shopItem);
                    }
                }
                if (title.startsWith("§b")) {
                    ShopSpawner spawner = ShopSpawner.fromItemStack(item);
                    if (spawner != null) {
                        ShopUtils.buySpawner(player, spawner);
                    }
                }
            }
        }
    }

}
