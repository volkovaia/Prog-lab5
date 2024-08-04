package commands.collectionCommands;
import commands.Command;
import commands.SaveCommand;
import exception.CommandNotAcceptArgumentsException;
import utility.CommandManager;
import utility.CollectionManager;
import utility.FileManager;

import java.time.LocalDate;

/**
 * The type Info command.
 */
public class InfoCommand implements Command {
    private final SaveCommand saveCommand;
    private CollectionManager collectionManager;
    private FileManager fileManager;

    /**
     * Instantiates a new Info command.
     *
     * @param collectionManager the collection manager
     * @param saveCommand       the save command
     */
    public InfoCommand(CollectionManager collectionManager, SaveCommand saveCommand){
        this.collectionManager = collectionManager;
        this.saveCommand = saveCommand;
    }

    @Override
    public void execute(String argument) {
        try {
            if (!argument.isEmpty()){
                throw new CommandNotAcceptArgumentsException();
            }

            System.out.println("Сведения о коллекции:");
            System.out.println("Тип: " + collectionManager.getLabWorkVector().getClass().getSimpleName());
            System.out.println("Дата инициализации: " + collectionManager.getLastInitTime());
            String saveTime = "";
            if (saveCommand.saveTimeCollection() == null) {
                saveTime = "Коллекция не сохранялась в этой сессии";
            } else saveTime = saveCommand.saveTimeCollection().toString();
            System.out.println("Дата сохранения: " + saveTime);
            System.out.println("Количество элементов: " + collectionManager.getLabWorkVector().size());
            }
        catch (CommandNotAcceptArgumentsException e){
            System.out.println("Этой команде не нужны аргументы!");
        }
    }


    @Override
    public String getName() {
        return "info";
    }


    @Override
    public String getDescription() {
        return "команда, выводящая в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.";
    }
}
