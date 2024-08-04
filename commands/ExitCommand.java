package commands;
import exception.CommandNeedArgumentException;
import exception.CommandNotAcceptArgumentsException;
import utility.CommandManager;


/**
 * The type Exit command.
 */
public class ExitCommand implements Command {
    @Override
    public void execute(String argument) {
        try {
            if (!argument.isEmpty()) {
                throw new CommandNotAcceptArgumentsException();}
            System.exit(0);
        }catch (CommandNotAcceptArgumentsException e){
            System.out.println("Этой команде не нужны аргументы!");
        }
    }

    @Override
    public String getName() {
        return "exit";
    }

    @Override
    public String getDescription() {
        return "команда, завершающая программу (без сохранения в файл)";
    }
}