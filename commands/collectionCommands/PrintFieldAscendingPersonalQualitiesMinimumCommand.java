package commands.collectionCommands;

import commands.Command;
import data.Discipline;
import data.LabWork;
import exception.CommandNotAcceptArgumentsException;
import utility.CollectionManager;

import java.util.stream.Stream;


/**
 * The type Print field ascending personal qualities minimum command.
 */
public class PrintFieldAscendingPersonalQualitiesMinimumCommand implements Command {

    /**
     * The Collection manager.
     */
    CollectionManager collectionManager;

    /**
     * Instantiates a new Print field ascending personal qualities minimum command.
     *
     * @param collectionManager the collection manager
     */
    public PrintFieldAscendingPersonalQualitiesMinimumCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }
    @Override
    public void execute(String argument) {
        try {
            if (!argument.isEmpty()) {
                throw new CommandNotAcceptArgumentsException();
            }
            collectionManager.getLabWorkVector().stream()
                    .map(LabWork::getDiscipline)
                    .sorted()
                    .forEach(System.out::println);

        } catch (CommandNotAcceptArgumentsException e) {
            System.out.println("Этой команде не нужны аргументы!");
        }
    }
    @Override
    public String getName() {
        return "print_field_ascending_discipline";
    }

    @Override
    public String getDescription() {
        return "команда, выводящая значение поля discipline всех элементов в порядке возрастания";
    }
}
