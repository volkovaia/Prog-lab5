package commands.collectionCommands;

import commands.Command;
import data.LabWork;
import exception.CommandNotAcceptArgumentsException;
import utility.CollectionManager;
import utility.CommandManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The type Shuffle command.
 */
public class ShuffleCommand implements Command {
    private final CollectionManager collectionManager;

    /**
     * Instantiates a new Shuffle command.
     *
     * @param collectionManager the collection manager
     */
    public ShuffleCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }
    @Override
    public void execute(String argument) {
        try {
            if (!argument.isEmpty()) {
                throw new CommandNotAcceptArgumentsException();
            }
            //Vector<LabWork> labWorkVector = collectionManager.getLabWorkVector();
            List<LabWork> labWorkList = new ArrayList<>(collectionManager.getLabWorkVector());
            Collections.shuffle(labWorkList);

            labWorkList.forEach(System.out::println);

        } catch (CommandNotAcceptArgumentsException e) {
            System.out.println("Этой команде не нужны аргументы!");
        }
    }


    @Override
    public String getName() {
        return "shuffle";
    }

    @Override
    public String getDescription() {
        return "команда, перемешивающая все элементы коллекции в случайном порядке";
    }
}

