package com.invisiblecat.serverdc;

import com.invisiblecat.serverdc.bot.DiscordBot;
import net.dv8tion.jda.api.entities.Activity;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.Nullable;

public final class ServerDC extends JavaPlugin {

    private DiscordBot bot;
    @Override
    public void onEnable() {
        FileConfiguration config = getConfig();
        config.addDefault("token", "DISCORD_BOT_TOKEN");
        config.addDefault("activityMessage", "Minecraft Server {serverIP}");
        config.options().copyDefaults(true);
        saveConfig();

        String token = config.getString("token");
        String activityMessage = config.getString("activityMessage");

        try {
            bot = new DiscordBot(token, Activity.watching(activityMessage));
            bot.start();
        }  catch (Exception e) {
            e.printStackTrace();
        }

        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        bot.stop();
    }
}
