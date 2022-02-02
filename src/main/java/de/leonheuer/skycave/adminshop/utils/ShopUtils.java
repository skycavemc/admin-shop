package de.leonheuer.skycave.adminshop.utils;

import de.leonheuer.skycave.adminshop.AdminShop;
import de.leonheuer.skycave.adminshop.enums.ItemCategory;
import de.leonheuer.skycave.adminshop.enums.Message;
import de.leonheuer.skycave.adminshop.enums.ShopItem;
import de.leonheuer.skycave.adminshop.enums.ShopSpawner;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.Nullable;

import java.text.NumberFormat;
import java.util.Locale;

public class ShopUtils {

    public static final ItemStack BACK_DOOR = new ItemBuilder(Material.OAK_DOOR, 1)
            .name("&cZurück").getResult();
    public static final ItemStack PLACEHOLDER = new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1)
            .name("&0").getResult();
    private static final NumberFormat nf = NumberFormat.getNumberInstance(Locale.GERMAN);
    private static final AdminShop main = JavaPlugin.getPlugin(AdminShop.class);

    public static void openAdminShop(Player player, @Nullable ItemCategory category) {
        Inventory inv = Bukkit.getServer().createInventory(player, 45, Component.text("§6✪ §4Admin Shop"));

        // if no category given, assume category overview is wanted
        if (category == null) {
            int slot = 20;
            for (ItemCategory cat : ItemCategory.values()) {
                inv.setItem(slot, new ItemBuilder(cat.getMat(), 1)
                        .name("&6" + cat.getTitle())
                        .description(Message.GUI_CATEGORY_DESCRIPTION.getFormatted()
                                .replaceAll("%title", cat.getTitle()))
                        .getResult());
                slot++;
            }
            player.openInventory(inv);
            return;
        }

        // if spawner given, format without the option of stacking
        if (category == ItemCategory.SPAWNER) {
            int slot = 0;
            placeholders(inv);
            for (ShopSpawner spawner : ShopSpawner.values()) {
                inv.setItem(slot, new ItemBuilder(Material.SPAWNER, 1)
                        .name("&b" + spawner.getName() + " Spawner")
                        .description(Message.GUI_ITEM_DESCRIPTION.getFormatted()
                                .replaceAll("%amount", "1")
                                .replaceAll("%price", nf.format(spawner.getPrice())))
                        .getResult());
                slot++;
            }
            inv.setItem(44, BACK_DOOR);
            player.openInventory(inv);
            return;
        }

        // otherwise, format dynamically with default layout
        int slot = 0;
        placeholders(inv);
        for (ShopItem item: ShopItem.values()) {
            if (item.getCategory() == category) {
                if (main.stackItems.contains(player) && item.isStackAllowed()) {
                    String calculatedPrice = nf.format((long) item.getPrice() * item.getStackSize());
                    inv.setItem(slot, new ItemBuilder(item.getMat(), item.getStackSize())
                            .name("&e" + item.getName())
                            .description(Message.GUI_ITEM_DESCRIPTION.getFormatted()
                                    .replaceAll("%amount", "" + item.getStackSize())
                                    .replaceAll("%price", calculatedPrice))
                            .getResult());
                } else {
                    inv.setItem(slot, new ItemBuilder(item.getMat(), item.getAmount())
                            .name("&e" + item.getName())
                            .description(Message.GUI_ITEM_DESCRIPTION.getFormatted()
                                    .replaceAll("%amount", "" + item.getAmount())
                                    .replaceAll("%price", nf.format(item.getPrice())))
                            .getResult());
                }
                slot++;
            }
        }

        if (main.stackItems.contains(player)) {
            inv.setItem(40, new ItemBuilder(Material.LIME_DYE, 1)
                    .name("&e" + category.getTitle() + " x64")
                    .description(Message.GUI_ITEMS_X64.getFormatted())
                    .getResult());
        } else {
            inv.setItem(40, new ItemBuilder(Material.GRAY_DYE, 1)
                    .name("&e" + category.getTitle())
                    .description(Message.GUI_ITEMS_X1.getFormatted())
                    .getResult());
        }
        inv.setItem(44, BACK_DOOR);
        player.openInventory(inv);
    }

    public static void placeholders(Inventory inv) {
        for (int i = 36; i < 45; i++) {
            inv.setItem(i, PLACEHOLDER);
        }
    }

    public static boolean hasSpace(Inventory inv) {
        int free = 0;
        for (int i = 0; i < inv.getSize(); i++) {
            if (inv.getItem(i) == null) {
                free++;
            }
        }
        return free > 0;
    }

    public static void buySpawner(Player player, ShopSpawner spawner) {
        OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(player.getUniqueId());
        Inventory inv = player.getInventory();

        if (main.getEcon().getBalance(offlinePlayer) >= (double) spawner.getPrice()) {
            if (hasSpace(inv)) {
                main.getEcon().withdrawPlayer(offlinePlayer, spawner.getPrice());
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0F, 1.0F);
                player.sendMessage(Message.BUY_SPAWNER_SUCCESS.getMessage()
                        .replaceAll("%type", spawner.getName())
                        .replaceAll("%cost", nf.format(spawner.getPrice()))
                );
                inv.addItem(new ItemBuilder(Material.SPAWNER, 1)
                        .name("&b" + spawner.getEntity().toString())
                        .getResult());
                main.getLogger().info(player.getName() + " has bought 1x " + spawner.name() + " Spawner for " +
                        spawner.getPrice() + "$");
            } else {
                player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0F, 1.0F);
                player.closeInventory();
                player.sendMessage(Message.BUY_NOSPACE.getMessage());
            }
        } else {
            double needed = spawner.getPrice() - main.getEcon().getBalance(offlinePlayer);
            player.playSound(player.getLocation(), Sound.ENTITY_ITEM_BREAK, 1.0F, 1.0F);
            player.closeInventory();
            player.sendMessage(Message.BUY_SPAWNER_NOMONEY.getMessage()
                    .replaceAll("%diff", nf.format(needed))
                    .replaceAll("%type", spawner.getName())
            );
        }
    }

    public static void buyItem(Player player, ShopItem item) {
        OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(player.getUniqueId());
        Inventory inv = player.getInventory();

        int price = item.getPrice();
        int amount = item.getAmount();

        if (main.stackItems.contains(player) && item.isStackAllowed()) {
            price = item.getPrice() * item.getMat().getMaxStackSize();
            amount = item.getMat().getMaxStackSize();
        }

        String name = amount + "x " + item.getName();

        if (main.getEcon().getBalance(offlinePlayer) >= (double) price) {
            if (hasSpace(inv)) {
                main.getEcon().withdrawPlayer(offlinePlayer, price);
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0F, 1.0F);
                player.sendMessage(Message.BUY_ITEM_SUCCESS.getMessage()
                        .replaceAll("%type", name)
                        .replaceAll("%cost", nf.format(price)));
                player.getInventory().addItem(new ItemStack(item.getMat(), amount));
                main.getLogger().info(player.getName() + " has bought " + name + " for " + price + "$");
            } else {
                player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0F, 1.0F);
                player.closeInventory();
                player.sendMessage(Message.BUY_NOSPACE.getMessage());
            }
        } else {
            player.playSound(player.getLocation(), Sound.ENTITY_ITEM_BREAK, 1.0F, 1.0F);
            player.closeInventory();
            player.sendMessage(Message.BUY_ITEM_NOMONEY.getMessage()
                    .replaceAll("%diff", nf.format(price - main.getEcon().getBalance(offlinePlayer)))
                    .replaceAll("%type", name));
        }
    }
}
