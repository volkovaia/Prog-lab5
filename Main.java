import commands.Command;
import commands.ExecuteScriptCommand;
import commands.HelpCommand;
import commands.SaveCommand;
import commands.collectionCommands.*;
import data.LabWork;
import utility.CollectionManager;
import utility.CommandManager;
import utility.ConsoleManager;
import utility.FileManager;

import java.util.HashMap;
import java.util.List;
import java.util.Vector;

/**
 * The type Main.
 */
public class Main {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        FileManager fileManager = new FileManager(args[0]);

        CommandManager commandManager = new CommandManager();
        CollectionManager collectionManager = new CollectionManager(fileManager);
        ConsoleManager consoleManager = new ConsoleManager(commandManager);
        HashMap<String, Command> commands = commandManager.getCommands();

       commands.put("save", new SaveCommand(fileManager, collectionManager));
       commands.put("clear", new ClearCommand(collectionManager));
       commands.put("info", new InfoCommand(collectionManager, new SaveCommand(fileManager, collectionManager)));
       commands.put("filter_less_than_personal_qualities_minimum", new FilterLessThanPersonalQualitiesMinimumCommand(collectionManager));
       commands.put("print_field_ascending_discipline", new PrintFieldAscendingPersonalQualitiesMinimumCommand(collectionManager));
       commands.put("remove_by_id", new RemoveByIdCommand(consoleManager, collectionManager));
       commands.put("remove_all_by_personal_qualities_minimum", new RemoveByPersonalQualitiesMinimumCommand(collectionManager));
       commands.put("sort", new SortCommand(collectionManager));
       commands.put("add", new AddCommand(collectionManager));
       commands.put("show", new ShowCommand(collectionManager));
       commands.put("shuffle", new ShuffleCommand(collectionManager));
       commands.put("add_if_min", new AddIfMinCommand(collectionManager));
       commands.put("update_by_id", new UpdateIdCommand(collectionManager));
       commands.put("execute_script", new ExecuteScriptCommand(consoleManager, collectionManager));


        HelpCommand helpCommand = new HelpCommand(commandManager);
        helpCommand.execute("help");
        

        collectionManager.loadCollection();

        consoleManager.StartCommandLoop();




    }
}