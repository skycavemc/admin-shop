package de.leonheuer.skycave.adminshop.commands;

import de.leonheuer.skycave.adminshop.AdminShop;
import de.leonheuer.skycave.adminshop.enums.Message;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SetCommand  implements CommandExecutor {

    private final AdminShop main;

    public SetCommand(AdminShop main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player player) {
            if (main.setState.contains(player)) {
                player.sendMessage(Message.SET_END.getMessage());
                main.setState.remove(player);
            } else {
                player.sendMessage(Message.SET_BEGIN.getMessage());
                main.setState.add(player);
            }
        } else {
            main.getLogger().warning("Dieser Befehl kann nur von Spielern benutzt werden!");
        }

        return true;
    }

}
