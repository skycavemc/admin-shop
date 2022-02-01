package de.leonheuer.skycave.adminshop.enums;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

public enum ItemCategory {

    SPAWNEGG(Material.PIG_SPAWN_EGG, "Spawneier"),
    SPAWNER(Material.SPAWNER, "Mobspawner"),
    WOOD(Material.OAK_LOG, "Holz"),
    STONE(Material.ANDESITE, "Gesteine"),
    MISC(Material.GRASS_BLOCK, "Sonstiges"),
    ;

    private final Material mat;
    private final String title;

    ItemCategory(Material mat, String title) {
        this.mat = mat;
        this.title = title;
    }

    public Material getMat() {
        return mat;
    }

    public String getTitle() {
        return title;
    }

    @SuppressWarnings("deprecation")
    @Nullable
    public static ItemCategory fromItemStack(ItemStack itemStack) {
        for (ItemCategory category : ItemCategory.values()) {
            if (itemStack.getType() == category.mat &&
                    itemStack.getItemMeta().getDisplayName().endsWith(category.getTitle())) { // ignore leading color codes
                return category;
            }
        }
        return null;
    }

    @Nullable
    public static ItemCategory fromString(String title) {
        for (ItemCategory category : ItemCategory.values()) {
            if (title.contains(category.title)) {
                return category;
            }
        }
        return null;
    }

}
