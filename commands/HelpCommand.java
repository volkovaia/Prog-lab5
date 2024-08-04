package commands;

import exception.CommandNotAcceptArgumentsException;
import utility.CommandManager;
import utility.ConsoleManager;


/**
 * The type Help command.
 */
public class HelpCommand implements Command {
    private CommandManager commandManager;

    /**
     * Instantiates a new Help command.
     *
     * @param commandManager the command manager
     */
    public HelpCommand(CommandManager commandManager) {
        this.commandManager = commandManager;
    }


    @Override
    public void execute(String argument) {
        commandManager.getCommands().keySet().forEach(key ->{
            System.out.println(key);
            System.out.println(commandManager.getCommands().get(key).getDescription()+"\n");

        });


    }

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getDescription() {
        return ("Команда, выводящая справку по всем доступным командам");
    }
}