package com.invisiblecat.serverdc.bot.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.Bukkit;

import java.util.Objects;

public class IRC extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (event.getName().equals("irc")) {
            Bukkit.broadcastMessage("[ " + event.getUser().getName() +  "] " +  Objects.requireNonNull(event.getOption("message")).getAsString());
        }
    }
}
