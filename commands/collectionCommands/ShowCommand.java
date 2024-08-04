package commands.collectionCommands;

import commands.Command;
import data.LabWork;
import exception.CommandNotAcceptArgumentsException;
import utility.CollectionManager;

/**
 * The type Show command.
 */
public class ShowCommand implements Command {
    private final CollectionManager collectionManager;

    /**
     * Instantiates a new Show command.
     *
     * @param collectionManager the collection manager
     */
    public ShowCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String argument) {
        try {
            if (!argument.isEmpty()){
                throw new CommandNotAcceptArgumentsException();
            }

            if (collectionManager.getLabWorkVector().isEmpty()) {
                System.out.println("Коллекция пуста");
            } else for (LabWork index : collectionManager.getLabWorkVector()) {
                System.out.println(index);
            }
    }catch (CommandNotAcceptArgumentsException e){
            System.out.println("Этой команде не нужны аргументы!");
        }
    }

    @Override
    public String getName() {
        return "show";
    }

    @Override
    public String getDescription() {
        return "команда, выводящая в стандартный поток вывода все элементы коллекции в строковом представлении";
    }
}