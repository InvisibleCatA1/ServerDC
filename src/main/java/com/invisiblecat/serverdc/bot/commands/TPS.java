package com.invisiblecat.serverdc.bot.commands;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.Bukkit;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class TPS extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        if (event.getName().equals("tps")) {
            event.reply(Bukkit.getServer().getIp() + ": TPS is currently: " + Arrays.toString(Bukkit.getTPS())).queue();
        }

    }
}
