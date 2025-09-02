// Copyright (c) 2022 bubba2k
// Using the last.fm Java project: Copyright (c) 2012, the Last.fm Java Project and Committers. All rights reserved.

package xyz.bubba2k.mcplugins.fmplugin.commands;

import de.umass.lastfm.PaginatedResult;
import de.umass.lastfm.Track;
import de.umass.lastfm.User;
import net.kyori.adventure.text.Component;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import xyz.bubba2k.mcplugins.fmplugin.FMPlugin;
import xyz.bubba2k.mcplugins.fmplugin.FMUsernameTable;

import java.util.Collection;

public class FMHelpCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        StringBuilder str = new StringBuilder();


        str.append("§bfm-plugin - last.fm integration for your Minecraft server.\n");
        str.append("§fCommands:\n");
        str.append("/fmset <last.fm username> - Set your last.fm username.\n");
        str.append("/fm - Display your last/current scrobble.\n");
        str.append("/fmhelp - Display this text.\n\n");

        str.append("§7fm-plugin v1.2 | Copyright (c) 2025 bubba2k\n");
        str.append("lastfm-java | Copyright (c) 2012, the Last.fm Java Project and Committers\n");

        sender.sendMessage(str.toString());

        return true;
    }
}
