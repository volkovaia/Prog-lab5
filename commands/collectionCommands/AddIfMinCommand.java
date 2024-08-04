package commands.collectionCommands;

import commands.Command;
import data.LabWork;
import utility.CollectionManager;
import utility.CommandManager;
import utility.ConsoleManager;

import java.util.Collections;
import java.util.Comparator;
import java.util.Optional;

/**
 * The type Add if min command.
 */
public class AddIfMinCommand implements Command {
    private CollectionManager collectionManager;

    /**
     * Instantiates a new Add if min command.
     *
     * @param collectionManager the collection manager
     */
    public AddIfMinCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }
    @Override
    public void execute(String argument) {
        try {


            collectionManager.getLabWorkVector().stream()
                    .min(Comparator.comparingDouble(LabWork::getAveragePoint))
                    .ifPresentOrElse((labWork) -> {

                        if (labWork.getAveragePoint() > Float.parseFloat(argument)) {
                            collectionManager.addFromInput();
                        } else {

                            System.out.println("Добавляемое значение не является наименьшим");
                        }
                    }, () -> {
                        System.out.println("Пустая коллекция");
                    });
        }catch (NumberFormatException e){
            System.out.println("getAveragePoint должен быть типа Float!");
        }

    }

    @Override
    public String getName() {
        return "add_if_min";
    }

    @Override
    public String getDescription() {
        return "команда, добавляющая элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции. Команда ожидает аргумент числового типа";
    }
}
