package commands.collectionCommands;

import commands.Command;
import data.Coordinates;
import data.Difficulty;
import data.Discipline;
import data.LabWork;
import utility.CollectionManager;
import utility.CommandManager;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * The type Add command.
 */
public class AddCommand implements Command {
    /**
     * The Collection manager.
     */
    static CollectionManager collectionManager;

    /**
     * Instantiates a new Add command.
     *
     * @param collectionManager the collection manager
     */
    public AddCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;

    }


    @Override
    public void execute(String argument) {
        collectionManager.addFromInput();
        System.out.println("Элемент добавлен в коллекцию!");
    }

    @Override
    public String getName() {
        return "add";
    }

    @Override
    public String getDescription() {
        return "команда, добавляющая новый элемент в коллекцию";
    }
}
