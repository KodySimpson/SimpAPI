package me.kodysimpson.simpapi.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents a main command that has subcommands within it. Like /stafftools freeze is /[corecommand] [subcommand]
 */
class CoreCommand extends Command {

    @NotNull
    private final ArrayList<SubCommand> subcommands;
    @NotNull
    private final CommandList commandList;

    public CoreCommand(@NotNull String name,
                       @NotNull String description,
                       @NotNull String usageMessage,
                       @NotNull CommandList commandList,
                       @NotNull List<String> aliases,
                       @NotNull ArrayList<SubCommand> subCommands){
        super(name, description, usageMessage, aliases);
        //Get the subcommands so we can access them in the command manager class(here)
        this.subcommands = subCommands;
        this.commandList = commandList;
    }

    @NotNull
    public ArrayList<SubCommand> getSubCommands(){
        return subcommands;
    }

    // /weener
    @Override
    public boolean execute(@NotNull CommandSender sender,
                           @NotNull String commandLabel,
                           @NotNull String[] args) {

        if (sender instanceof Player){
            Player p = (Player) sender;

            if (args.length > 0){
                for (int i = 0; i < getSubCommands().size(); i++){
                    if (args[0].equalsIgnoreCase(getSubCommands().get(i).getName())){
                        getSubCommands().get(i).perform(p, args);
                    }
                }
            }else {
                commandList.displayCommandList(p, subcommands);
            }

        }

        return true;
    }

    @Override
    @NotNull
    public List<String> tabComplete(@NotNull CommandSender sender, @NotNull String alias, String[] args) throws IllegalArgumentException {
        if (args.length == 1){ //prank <subcommand> <args>
            ArrayList<String> subcommandsArguments = new ArrayList<>();

            for (int i = 0; i < getSubCommands().size(); i++){
                subcommandsArguments.add(getSubCommands().get(i).getName());
            }

            return subcommandsArguments;
        }else if(args.length >= 2){
            for (int i = 0; i < getSubCommands().size(); i++){
                if (args[0].equalsIgnoreCase(getSubCommands().get(i).getName())){
                    return getSubCommands().get(i).getSubcommandArguments((Player) sender, args);
                }
            }
        }
        return Collections.emptyList();
    }


}
