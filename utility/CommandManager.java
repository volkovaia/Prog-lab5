package utility;

import commands.*;
import commands.collectionCommands.*;
import exception.CommandNeedArgumentException;
import exception.CommandNotFoundException;
import lombok.Getter;

import java.util.HashMap;
import java.util.Stack;

@Getter
public class CommandManager {

    @Getter
    private final HashMap<String, Command> commands = new HashMap<>();



    public CommandManager(){
        commands.put("help", new HelpCommand(this));
        commands.put("exit", new ExitCommand());
    }



    public void executeCommand(String stringCommand) throws CommandNotFoundException {

        String[] commandSplit = stringCommand.split(" ", 2);

        String commandName = commandSplit[0];

        String commandArguments = "";


        if (commandSplit.length == 2) {
            commandArguments = commandSplit[1];
        }

        Command command = commands.get(commandName);


        if (command == null) {
            throw new CommandNotFoundException(commandName);
        }
        try {
            command.execute(commandArguments);
        } catch (CommandNeedArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}