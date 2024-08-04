package commands.collectionCommands;

import commands.Command;
import data.LabWork;
import exception.CommandNotAcceptArgumentsException;
import utility.CollectionManager;
import utility.CommandManager;

import java.util.Comparator;

/**
 * The type Sort command.
 */
public class SortCommand implements Command {
    /**
     * The Collection manager.
     */
    CollectionManager collectionManager;

    /**
     * Instantiates a new Sort command.
     *
     * @param collectionManager the collection manager
     */
    public SortCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }
        @Override
        public void execute(String argument) {
            try {
                if (!argument.isEmpty()) {
                    throw new CommandNotAcceptArgumentsException();
                }
        collectionManager.getLabWorkVector().stream()
                    .sorted(Comparator.comparing(LabWork::getName))
                    .forEach(labWork -> System.out.println(labWork));
            }catch (CommandNotAcceptArgumentsException e) {
                System.out.println("Этой команде не нужны аргументы!");
            }
    }

        @Override
        public String getName() {
            return "sort";
        }

        @Override
        public String getDescription() {
            return "команда, сортирующая коллекцию в естественном порядке";
        }
    }

