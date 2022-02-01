package de.leonheuer.skycave.adminshop.enums;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

public enum ShopSpawner {

    CREEPER(EntityType.CREEPER, "Creeper", 75000),
    SKELETON(EntityType.SKELETON, "Skelett", 75000),
    CAVE_SPIDER(EntityType.CAVE_SPIDER, "Höhlenspinne", 75000),
    ZOMBIE(EntityType.ZOMBIE, "Zombie", 150000),
    WITCH(EntityType.WITCH, "Hexe", 250000),
    IRON_GOLEM(EntityType.IRON_GOLEM, "Eisengolem", 500000),
    ;

    private final EntityType entity;
    private final String name;
    private final int price;

    ShopSpawner(EntityType entity, String name, int price) {
        this.entity = entity;
        this.name = name;
        this.price = price;
    }

    public EntityType getEntity() {
        return entity;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @SuppressWarnings("deprecation")
    @Nullable
    public static ShopSpawner fromItemStack(ItemStack itemStack) {
        for (ShopSpawner spawner : ShopSpawner.values()) {
            if (itemStack.getType() == Material.SPAWNER &&
                    itemStack.getItemMeta().getDisplayName().endsWith(spawner.getName() + " Spawner")) { // ignore leading color codes
                return spawner;
            }
        }
        return null;
    }

}
