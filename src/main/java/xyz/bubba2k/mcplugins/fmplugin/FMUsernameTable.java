// Copyright (c) 2022 bubba2k
// Using the last.fm Java project: Copyright (c) 2012, the Last.fm Java Project and Committers. All rights reserved.

package xyz.bubba2k.mcplugins.fmplugin;

import de.umass.lastfm.User;

public class FMUsernameTable {

    public static String getFMUsername(String mcUUID) {
        return (String) FMPlugin.INSTANCE.getConfig().get("users." + mcUUID);
    }

    // Associate a last.fm username with the UUID. Returns false if last.fm username
    // does not exist, else true.
    public static boolean addFMUsername(String mcUUID, String fmUsername) {
        // Remove any existing record for this UUID
        FMPlugin.INSTANCE.getConfig().set("users." + mcUUID, null);

        // Check if the last.fm account with the given name exists
        User user = User.getInfo(fmUsername, FMPlugin.getApiKey());

        // If the last.fm user does not exist, return false
        if(user == null) return false;
        FMPlugin.INSTANCE.getConfig().set("users." + mcUUID, fmUsername);

        // Write config to file if new name was added
        FMPlugin.INSTANCE.saveConfig();
        FMPlugin.INSTANCE.reloadConfig();

        return true;
    }
}
