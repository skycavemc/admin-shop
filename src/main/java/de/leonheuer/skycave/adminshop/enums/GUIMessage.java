package de.leonheuer.skycave.adminshop.enums;

public enum GUIMessage {

    GUI_CATEGORY_DESCRIPTION("&7Hier klicken, um dir", "&e%title &7zu kaufen."),
    GUI_ITEM_DESCRIPTION("&7Anzahl: &6%amount", "&7Preis: &6%price$", "&eKlicke zum kaufen"),
    GUI_ITEMS_X64("&7Klicke um Anzahl der Items", "&7auf &a1 &7zu ändern"),
    GUI_ITEMS_X1("&7Klicke um Anzahl der Items", "&7auf &a64 &7zu ändern"),
    ;

    private final String[] string;

    GUIMessage(String... string) {
        this.string = string;
    }

    public String[] getStrings() {
        return string;
    }

}
