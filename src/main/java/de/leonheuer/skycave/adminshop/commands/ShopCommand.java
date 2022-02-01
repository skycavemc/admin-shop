package de.leonheuer.skycave.adminshop.commands;

import de.leonheuer.skycave.adminshop.AdminShop;
import de.leonheuer.skycave.adminshop.enums.ItemCategory;
import de.leonheuer.skycave.adminshop.enums.Message;
import de.leonheuer.skycave.adminshop.utils.ShopUtils;
import org.apache.commons.lang.StringUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class ShopCommand implements CommandExecutor, TabCompleter {

    private final AdminShop main;

    public ShopCommand(AdminShop main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player player)) {
            main.getLogger().severe("This command is for players only.");
            return true;
        }

        if (args.length == 0) {
            ShopUtils.openAdminShop(player, null);
            return true;
        }

        try {
            ItemCategory category = ItemCategory.valueOf(args[0].toUpperCase());
            ShopUtils.openAdminShop(player, category);
        } catch (IllegalArgumentException e) {
            StringJoiner sj = new StringJoiner(", ");
            Arrays.stream(ItemCategory.values()).forEach(cat -> sj.add(StringUtils.capitalize(cat.toString().toLowerCase())));
            player.sendMessage(Message.SHOP_UNKNOWN.getMessage().replaceAll("%categories", sj.toString()));
        }
        return true;

    }

    @Nullable
    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        List<String> arguments = new ArrayList<>();
        List<String> completions = new ArrayList<>();

        if (args.length == 1) {
            Arrays.stream(ItemCategory.values()).forEach(cat -> arguments.add(StringUtils.capitalize(cat.toString().toLowerCase())));
            StringUtil.copyPartialMatches(args[0], arguments, completions);
        }

        Collections.sort(completions);
        return completions;
    }
}
