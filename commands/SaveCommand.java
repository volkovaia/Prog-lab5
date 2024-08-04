package commands;


import data.LabWork;
import exception.CommandNeedArgumentException;
import exception.CommandNotAcceptArgumentsException;
import utility.CollectionManager;
import utility.CommandManager;
import utility.FileManager;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Vector;


/**
 * The type Save command.
 */
public class SaveCommand implements Command {
    private FileManager fileManager;

    /**
     * Instantiates a new Save command.
     *
     * @param fileManager       the file manager
     * @param collectionManager the collection manager
     */
    public SaveCommand( FileManager fileManager, CollectionManager collectionManager){
        this.fileManager = fileManager;
        this.collectionManager = collectionManager;
    }
    private CollectionManager collectionManager;
    @Override
    public void execute(String argument) {


        try {
            if (!argument.isEmpty()) throw new CommandNotAcceptArgumentsException();
            fileManager.saveCollection(collectionManager.getLabWorkVector());
            System.out.println("Коллекция успешно сохранена!");

        } catch (CommandNotAcceptArgumentsException e){
            System.out.println("Этой команде не нужны аргументы!");
        }
    }

    /**
     * Execute from file.
     *
     * @param labWork the lab work
     */
    public void executeFromFile(Vector <LabWork> labWork) {
        try {

            fileManager.saveCollection(labWork);
            System.out.println("Коллекция успешно сохранена из файла!");

        } catch (CommandNotAcceptArgumentsException e){
            System.out.println("Этой команде не нужны аргументы!");
        }
    }

    @Override
    public String getName() {
        return "save";
    }

    @Override
    public String getDescription() {
        return "команда, сохраняющая коллекцию в файл";
    }

    /**
     * Save time collection local date.
     *
     * @return the local date
     */
    public LocalDate saveTimeCollection(){
        LocalDate saveTime = LocalDate.now();
        return saveTime;
    }
}