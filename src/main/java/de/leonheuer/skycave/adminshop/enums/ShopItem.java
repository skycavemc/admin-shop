package de.leonheuer.skycave.adminshop.enums;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

public enum ShopItem {

    // wood items
    // logs/stems
    OAK_LOG(Material.OAK_LOG, "Eichen-Stamm", 1, 15, true, ItemCategory.WOOD),
    DARK_OAK_LOG(Material.DARK_OAK_LOG, "Schwarzeichen-Stamm", 1, 15, true, ItemCategory.WOOD),
    SPRUCE_LOG(Material.SPRUCE_LOG, "Fichten-Stamm", 1, 15, true, ItemCategory.WOOD),
    BIRCH_LOG(Material.BIRCH_LOG, "Birken-Stamm", 1, 15, true, ItemCategory.WOOD),
    ACACIA_LOG(Material.ACACIA_LOG, "Akazien-Stamm", 1, 24, true, ItemCategory.WOOD),
    JUNGLE_LOG(Material.JUNGLE_LOG, "Tropenbaum-Stamm", 1, 24, true, ItemCategory.WOOD),
    CRIMSON_STEM(Material.CRIMSON_STEM, "Karmesin-Stiel", 1, 30, true, ItemCategory.WOOD),
    WARPED_STEM(Material.WARPED_STEM, "Wirr-Stiel", 1, 30, true, ItemCategory.WOOD),
    // saplings/fungus
    OAK_SAPLING(Material.OAK_SAPLING, "Eichen-Setzling", 1, 25, true, ItemCategory.WOOD),
    DARK_OAK_SAPLING(Material.DARK_OAK_SAPLING, "Schwarzeichen-Setzling", 1, 25, true, ItemCategory.WOOD),
    SPRUCE_SAPLING(Material.SPRUCE_SAPLING, "Fichten-Setzling", 1, 25, true, ItemCategory.WOOD),
    BIRCH_SAPLING(Material.BIRCH_SAPLING, "Birken-Setzling", 1, 25, true, ItemCategory.WOOD),
    ACACIA_SAPLING(Material.ACACIA_SAPLING, "Akazien-Setzling", 1, 40, true, ItemCategory.WOOD),
    JUNGLE_SAPLING(Material.JUNGLE_SAPLING, "Tropenbaum-Setzling", 1, 40, true, ItemCategory.WOOD),
    CRIMSON_FUNGUS(Material.CRIMSON_FUNGUS, "Karmesin-Pilz", 1, 50, true, ItemCategory.WOOD),
    WARPED_FUNGUS(Material.WARPED_FUNGUS, "Wirr-Pilz", 1, 50, true, ItemCategory.WOOD),

    // stone items
    COBBLE(Material.COBBLESTONE, "Bruchstein", 64, 6, false, ItemCategory.STONE),
    STONE(Material.STONE, "Stein", 64, 8, false, ItemCategory.STONE),
    OBSIDIAN(Material.OBSIDIAN, "Obsidian", 1, 80, true, ItemCategory.STONE),
    QUARTZ_BLOCK(Material.QUARTZ_BLOCK, "Quarzblock", 1, 50, true, ItemCategory.STONE),
    GRANITE(Material.GRANITE, "Granit", 1, 30, true, ItemCategory.STONE),
    ANDESITE(Material.ANDESITE, "Andesit", 1, 30, true, ItemCategory.STONE),
    DIORITE(Material.DIORITE, "Diorit", 1, 30, true, ItemCategory.STONE),
    BLACKSTONE(Material.BLACKSTONE, "Schwarzstein", 1, 10, true, ItemCategory.STONE),
    BASALT(Material.BASALT, "Basalt", 1, 10, true, ItemCategory.STONE),
    PRISMARINE(Material.PRISMARINE, "Prismarin", 1, 120, true, ItemCategory.STONE),
    PRISMARINE_BRICKS(Material.PRISMARINE_BRICKS, "Prismarinziegel", 1, 270, true, ItemCategory.STONE),
    DARK_PRISMARINE(Material.DARK_PRISMARINE, "Dunkler Prismarin", 1, 250, true, ItemCategory.STONE),
    SEA_LANTERN(Material.SEA_LANTERN, "Seelaterne", 1, 370, true, ItemCategory.STONE),
    CALCITE(Material.CALCITE, "Kalzit", 1, 25, true, ItemCategory.STONE),
    TUFF(Material.TUFF, "Tuffstein", 1, 20, true, ItemCategory.STONE),
    DRIPSTONE_BLOCK(Material.DRIPSTONE_BLOCK, "Tropfsteinblock", 1, 200, true, ItemCategory.STONE),
    DEEPSLATE(Material.DEEPSLATE, "Tiefenschiefer", 1, 30, true, ItemCategory.STONE),
    COBBLED_DEEPSLATE(Material.COBBLED_DEEPSLATE, "Bruchtiefenschiefer", 1, 40, true, ItemCategory.STONE),
    POLISHED_DEEPSLATE(Material.POLISHED_DEEPSLATE, "Polierter Tiefenschiefer", 1, 40, true, ItemCategory.STONE),
    DEEPSLATE_COAL_ORE(Material.DEEPSLATE_COAL_ORE, "Tiefenschiefer-Steinkohle", 1, 50, true, ItemCategory.STONE),
    DEEPSLATE_IRON_ORE(Material.DEEPSLATE_IRON_ORE, "Tiefenschiefer-Eisenerz", 1, 60, true, ItemCategory.STONE),
    DEEPSLATE_GOLD_ORE(Material.DEEPSLATE_GOLD_ORE, "Tiefenschiefer-Golderz", 1, 70, true, ItemCategory.STONE),
    DEEPSLATE_DIAMOND_ORE(Material.DEEPSLATE_DIAMOND_ORE, "Tiefenschiefer-Diamanterz", 1, 300, true, ItemCategory.STONE),
    DEEPSLATE_COPPER_ORE(Material.DEEPSLATE_COPPER_ORE, "Tiefenschiefer-Kupfererz", 1, 150, true, ItemCategory.STONE),
    DEEPSLATE_REDSTONE_ORE(Material.DEEPSLATE_REDSTONE_ORE, "Tiefenschiefer-Redstone-Erz", 1, 70, true, ItemCategory.STONE),

    // miscellaneous items
    DIRT(Material.DIRT, "Erde", 1, 90, true, ItemCategory.MISC),
    GRASS(Material.GRASS_BLOCK, "Gras", 1, 100, true, ItemCategory.MISC),
    MOSS_BLOCK(Material.MOSS_BLOCK, "Moos", 1, 100, true, ItemCategory.MISC),
    SAND(Material.SAND, "Sand", 1, 120, true, ItemCategory.MISC),
    GRAVEL(Material.GRAVEL, "Kies", 1, 15, true, ItemCategory.MISC),
    LAVA(Material.LAVA_BUCKET, "Lava Eimer", 1, 120, false, ItemCategory.MISC),
    REDSTONE(Material.REDSTONE, "Redstone", 64, 600, false, ItemCategory.MISC),
    POWDER_SNOW_BUCKET(Material.POWDER_SNOW_BUCKET, "Pulverschneeeimer", 1, 30, true, ItemCategory.MISC),
    COPPER_BLOCK(Material.COPPER_BLOCK, "Kupferblock", 1, 150, true, ItemCategory.MISC),
    EXPOSED_COPPER(Material.EXPOSED_COPPER, "Angelaufener Kupferblock", 1, 200, true, ItemCategory.MISC),
    WEATHERED_COPPER(Material.WEATHERED_COPPER, "Verwitterter Kupferblock", 1, 250, true, ItemCategory.MISC),
    OXIDIZED_COPPER(Material.OXIDIZED_COPPER, "Oxidierter Kupferblock", 1, 300, true, ItemCategory.MISC),
    AMETHYST_SHARD(Material.AMETHYST_SHARD, "Amethystscherbe", 1, 150, true, ItemCategory.MISC),
    AMETHYST_BLOCK(Material.AMETHYST_BLOCK, "Amethystblock", 1, 600, true, ItemCategory.MISC),
    SMALL_AMETHYST_BUD(Material.SMALL_AMETHYST_BUD, "Kleine Amethystknospe", 1, 100, true, ItemCategory.MISC),
    MEDIUM_AMETHYST_BUD(Material.MEDIUM_AMETHYST_BUD, "Mittlere Amethystknospe", 1, 200, true, ItemCategory.MISC),
    LARGE_AMETHYST_BUD(Material.LARGE_AMETHYST_BUD, "Große Amethystknospe", 1, 300, true, ItemCategory.MISC),
    AMETHYST_CLUSTER(Material.AMETHYST_CLUSTER, " Amethysthaufen", 1, 600, true, ItemCategory.MISC),

    // spawn egg items
    CHICKEN(Material.CHICKEN_SPAWN_EGG, "Huhn Spawnei", 1, 10000, true, ItemCategory.SPAWNEGG),
    RABBIT(Material.RABBIT_SPAWN_EGG, "Hase Spawnei", 1, 15000, true, ItemCategory.SPAWNEGG),
    CAT(Material.CAT_SPAWN_EGG, "Katze Spawnei", 1, 15000, true, ItemCategory.SPAWNEGG),
    WOLF(Material.WOLF_SPAWN_EGG, "Wolf Spawnei", 1, 15000, true, ItemCategory.SPAWNEGG),
    FOX(Material.FOX_SPAWN_EGG, "Fuchs Spawnei", 1, 15000, true, ItemCategory.SPAWNEGG),
    DONKEY(Material.DONKEY_SPAWN_EGG, "Esel Spawnei", 1, 15000, true, ItemCategory.SPAWNEGG),
    HORSE(Material.HORSE_SPAWN_EGG, "Pferd Spawnei", 1, 15000, true, ItemCategory.SPAWNEGG),
    COW(Material.COW_SPAWN_EGG, "Kuh Spawnei", 1, 30000, true, ItemCategory.SPAWNEGG),
    PIG(Material.PIG_SPAWN_EGG, "Schwein Spawnei", 1, 30000, true, ItemCategory.SPAWNEGG),
    SHEEP(Material.SHEEP_SPAWN_EGG, "Schaf Spawnei", 1, 30000, true, ItemCategory.SPAWNEGG),
    BEE(Material.BEE_SPAWN_EGG, "Biene Spawnei", 1, 75000, true, ItemCategory.SPAWNEGG),
    MOOSHROOM(Material.MOOSHROOM_SPAWN_EGG, "Pilzkuh Spawnei", 1, 100000, true, ItemCategory.SPAWNEGG),
    ZOMBIE_VILLAGER(Material.ZOMBIE_VILLAGER_SPAWN_EGG, "Zombie-Dorfbewohner Spawnei", 1, 200000, true, ItemCategory.SPAWNEGG),
    ;

    private final Material mat;
    private final String name;
    private final int amount;
    private final int price;
    private final boolean stackAllowed;
    private final ItemCategory category;

    ShopItem(Material mat, String name, int amount, int price, boolean stackAllowed, ItemCategory category) {
        this.mat = mat;
        this.name = name;
        this.amount = amount;
        this.price = price;
        this.stackAllowed = stackAllowed;
        this.category = category;
    }

    public Material getMat() {
        return mat;
    }

    public int getStackSize() {
        return mat.getMaxStackSize();
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public boolean isStackAllowed() {
        return stackAllowed;
    }

    public ItemCategory getCategory() {
        return category;
    }

    @SuppressWarnings("deprecation")
    @Nullable
    public static ShopItem fromItemStack(ItemStack itemStack) {
        for (ShopItem item : ShopItem.values()) {
            if (itemStack.getType() == item.mat &&
                    // ignore leading color codes
                    itemStack.getItemMeta().getDisplayName().endsWith(item.getName())) {
                return item;
            }
        }
        return null;
    }

}
