package commands.collectionCommands;
import commands.Command;
import data.LabWork;
import utility.CollectionManager;
import utility.CommandManager;

/**
 * The type Update id command.
 */
public class UpdateIdCommand implements Command {
    private final CollectionManager collectionManager;

    /**
     * Instantiates a new Update id command.
     *
     * @param collectionManager the collection manager
     */
    public UpdateIdCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;

    }
    @Override
    public void execute(String argument) {
        try {
            int id = Integer.parseInt(argument);
            collectionManager.updateByIdCollection(id);


        }catch (NumberFormatException e){
            System.out.println("Команде нужен аргумент типа int!");
        }
    }
    @Override
    public String getName() {
        return "update_by_id";
    }

    @Override
    public String getDescription() {
        //removeIf
        return "команда, обновить значение элемента коллекции, id которого равен заданному. Команда ожидает аргумент типа int!";
    }
}