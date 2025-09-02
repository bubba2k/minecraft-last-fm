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

public class FMCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        // Check if the sender is a player.
        if( !(sender instanceof Player)) {
            sender.sendMessage("This command can only be issued by players.");
            return true;
        }
        Player player = (Player) sender;

        String fmUsername = FMUsernameTable.getFMUsername(player.getUniqueId().toString());

        // If the player has not set a last.fm username yet
        if(fmUsername == null) {
            sender.sendMessage("§7You have not set a last.fm username yet. Use /fmset to do so.");
            return true;
        }

        // Get the most recent track for user
        PaginatedResult<Track> trackPages = User.getRecentTracks(fmUsername, 1, 1, FMPlugin.getApiKey());
        Collection<Track> tracks = trackPages.getPageResults();

        // Check if there are any recent tracks, if not message user accordingly
        if(tracks.size() == 0) {
            sender.sendMessage("§7You have not listened to any tracks recently.");
            return true;
        }

        // Get the most recent track
        Track track = tracks.iterator().next();

        StringBuilder builder = new StringBuilder();
        builder .append("<" + player.getName() + "> ")
                .append("Now playing: §a")
                .append(track.getName())
                .append(" §rby §6§l")
                .append(track.getArtist())
                .append("§r | §9§o")
                .append(track.getAlbum());

        FMPlugin.INSTANCE.getServer().broadcast(Component.text(builder.toString()));

        return true;
    }
}
