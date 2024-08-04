package utility;

import commands.Command;
import commands.ExecuteScriptCommand;
import commands.HelpCommand;
import data.LabWork;
import exception.CommandNotFoundException;
import lombok.Data;

import java.util.HashMap;
import java.util.Scanner;

@Data
public class ConsoleManager {

    private Scanner scanner = new Scanner(System.in);

    CommandManager manager;

    private boolean isRunning = false;


    public ConsoleManager(CommandManager manager) {
        this.manager = manager;
        //manager.getCommands().put("execute_script", new ExecuteScriptCommand(this, new CollectionManager(new FileManager())));

    }



    public void StartCommandLoop() {

        isRunning = true;
        String in = "";
        while (isRunning) {
            if (scanner.hasNextLine()){
                in = scanner.nextLine();
                if (in.isBlank()){
                    continue;
            }
            }

            else
                break;


            try {
                manager.executeCommand(in);
            } catch (CommandNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}