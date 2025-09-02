// Copyright (c) 2022 bubba2k
// Using the last.fm Java project: Copyright (c) 2012, the Last.fm Java Project and Committers. All rights reserved.

package xyz.bubba2k.mcplugins.fmplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import xyz.bubba2k.mcplugins.fmplugin.FMUsernameTable;

public class FMSetCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        // Check the correct number of arguments is present.
        if(args.length != 1) return false;

        // Check if the sender is a player.
        if( !(sender instanceof Player)) {
            sender.sendMessage("This command can only be issued by players.");
        }

        Player player = (Player) sender;

        // Associate the last.fm name with this player
        boolean addSuccess = FMUsernameTable.addFMUsername(player.getUniqueId().toString(), args[0]);
        if(!addSuccess) {
            sender.sendMessage("§cThe last.fm account '" + args[0] + "' could not be found.");
            return true;
        }

        sender.sendMessage("§aThe last.fm account " + args[0] + " is now associated with you.");
        return true;
    }
}
