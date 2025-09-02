// Copyright (c) 2022 bubba2k
// Using the last.fm Java project: Copyright (c) 2012, the Last.fm Java Project and Committers. All rights reserved.

package xyz.bubba2k.mcplugins.fmplugin;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.bubba2k.mcplugins.fmplugin.commands.FMCommand;
import xyz.bubba2k.mcplugins.fmplugin.commands.FMSetCommand;
import xyz.bubba2k.mcplugins.fmplugin.commands.FMHelpCommand;
import xyz.bubba2k.mcplugins.fmplugin.commands.NoKeyErrorCommand;

import javax.annotation.Nullable;

public final class FMPlugin extends JavaPlugin {

    public static FMPlugin INSTANCE;

    /**
     * Query the config file for the last.fm API key.
     * @return The API key, or null if no API key is found in the config file.
     */
    @Nullable
    public static String getApiKey() {
        return (String) FMPlugin.INSTANCE.getConfig().get("api_key");
    }

    @Override
    public void onEnable() {
        // Get our instance
        INSTANCE = this;

        // Write out the default config - function should fail if config already exists
        this.saveDefaultConfig();

        // Check whether a last.fm API key is present in the config
        if (getApiKey() == null) {
            getLogger().severe("CRITICAL: Please supply a last.fm API key in the config.");
            // Initialize the commands
            Bukkit.getPluginCommand("fm").setExecutor(new NoKeyErrorCommand());
            Bukkit.getPluginCommand("fmset").setExecutor(new NoKeyErrorCommand());
            Bukkit.getPluginCommand("fmhelp").setExecutor(new FMHelpCommand());
        } else {
            // Initialize the commands
            Bukkit.getPluginCommand("fm").setExecutor(new FMCommand());
            Bukkit.getPluginCommand("fmset").setExecutor(new FMSetCommand());
            Bukkit.getPluginCommand("fmhelp").setExecutor(new FMHelpCommand());
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
