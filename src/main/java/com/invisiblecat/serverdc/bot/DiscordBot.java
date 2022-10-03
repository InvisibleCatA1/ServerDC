package com.invisiblecat.serverdc.bot;

import com.invisiblecat.serverdc.bot.commands.IRC;
import com.invisiblecat.serverdc.bot.commands.TPS;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.Command;
import org.w3c.dom.events.Event;

import java.util.EventListener;


public class DiscordBot {
    private JDA api;
    private final String token;
    private final Activity activity;
    public DiscordBot(String token, Activity activity) {
        this.token = token;
        this.activity = activity;
    }

    public void start() {
        JDABuilder builder = JDABuilder.createDefault(token);
        builder.setActivity(activity);
        api = builder.build();

        // Register commands
        registerCommand(new TPS());
        registerCommand(new IRC());
    }

    private void registerCommand(ListenerAdapter command) {
        api.addEventListener(command);
    }

    public void stop() {
        api.shutdown();
    }
}
