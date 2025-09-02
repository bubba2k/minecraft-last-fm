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

public class NoKeyErrorCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        StringBuilder builder = new StringBuilder();
        builder .append("§c§o[fm] ERROR: Incorrect configuration: No last.fm API key supplied. Contact the server admin.");
        FMPlugin.INSTANCE.getServer().broadcast(Component.text(builder.toString()));

        return true;
    }
}
