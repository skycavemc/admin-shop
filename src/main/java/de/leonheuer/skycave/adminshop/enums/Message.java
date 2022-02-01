package de.leonheuer.skycave.adminshop.enums;

import org.bukkit.ChatColor;

public enum Message {

    PREFIX("&8&l| &eSky&6Bee &8» "),
    
    // GUI messages
    GUI_CATEGORY_DESCRIPTION("&7Hier klicken, um dir%nl%&e%title &7zu kaufen."),
    GUI_ITEM_DESCRIPTION("&7Anzahl: &6%amount%nl%&7Preis: &6%price$%nl%&eKlicke zum kaufen"),
    GUI_ITEMS_X64("&7Klicke um Anzahl der Items%nl%&7auf &a1 &7zu ändern"),
    GUI_ITEMS_X1("&7Klicke um Anzahl der Items%nl%&7auf &a64 &7zu ändern"),

    // Buy messages
    BUY_SPAWNER_SUCCESS("&7Du hast einen &a%type Spawner &7für &e%cost$ &7erworben."),
    BUY_SPAWNER_NOMONEY("&cDir fehlen %diff$ für den %type Spawner."),
    BUY_ITEM_SUCCESS("&7Du hast &a%type &7für &e%cost$ &7erworben."),
    BUY_ITEM_NOMONEY("&cDir fehlen %diff$ für %type."),
    BUY_NOSPACE("&cDu hast keinen Platz im Inventar!"),

    // Set command messages
    SET_BEGIN("&7Klicke nun einen NPC an, um den &cAdmin Shop &7zu setzen."),
    SET_END("&cSetzen des Admin Shops abgebrochen."),
    SET_SUCCESS("&aAdmin Shop erfolgreich gesetzt!"),
    SET_ERROR("&cEs ist ein Fehler beim Speichern aufgetreten. Für mehr Informationen siehe Konsole"),

    // Shop command messages
    SHOP_UNKNOWN("&cUnbekannte Kategorie. Bitte wähle eine der Folgenden: %categories"),
    ;

    private final String msg;

    Message(String msg) {
        this.msg = msg;
    }

    public String getFormatted() {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

    public String getMessage() {
        return ChatColor.translateAlternateColorCodes('&', PREFIX.msg + msg);
    }
}
