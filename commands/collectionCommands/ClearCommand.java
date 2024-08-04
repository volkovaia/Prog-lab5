package commands.collectionCommands;

import commands.Command;
import exception.CommandNeedArgumentException;
import exception.CommandNotAcceptArgumentsException;
import exception.CommandNotNeedArgumentException;
import utility.CommandManager;

//
//import exception.CommandNotAcceptArgumentsException;
import utility.CollectionManager;
import utility.FileManager;

/**
 * The type Clear command.
 */
//
///**
// * Команда очистить коллекцию
// */
//public class Clear implements Command {
//    private CollectionManager collectionManager = JavaCollectionManager.getInstance();
//
//    @Override
//    public void execute(String argument) {
//        try {
//            if (!argument.isEmpty()) throw new CommandNotAcceptArgumentsException();
//            collectionManager.clear();
//        } catch (CommandNotAcceptArgumentsException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public String getName() {
//        return null;
//    }
//
//    @Override
//    public String getDescription() {
//        return null;
//    }
//}
public class ClearCommand implements Command {
    /**
     * Instantiates a new Clear command.
     *
     * @param collectionManager the collection manager
     */
    public ClearCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;

    }
    private CollectionManager collectionManager;
    @Override
    public void execute(String argument) {

        try {
            if (!argument.isEmpty()){
                throw new CommandNotAcceptArgumentsException();
            }
            collectionManager.clear();
        } catch (CommandNotAcceptArgumentsException e){
            System.out.println("Этой команде не нужны аргументы!");}

        }

    @Override
    public String getName() {
        return "clear";
    }

    @Override
    public String getDescription() {
        return "команда, очищающая коллекцию";
    }

}