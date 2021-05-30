package me.kodysimpson.simpapi.command;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public abstract class SubCommand {

    @NotNull
    public abstract String getName();

    @NotNull
    public abstract String getDescription();

    @NotNull
    public abstract String getSyntax();

    public abstract void perform(Player player, String[] args);

    @NotNull
    public abstract List<String> getSubcommandArguments(Player player, String[] args);

}

