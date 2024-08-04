package commands;

import utility.CommandManager;

/**
 * The interface Command.
 */
public interface Command {

    /**
     * Execute.
     *
     * @param argument the argument
     */
    void execute(String argument);

    /**
     * Gets name.
     *
     * @return the name
     */
    String getName();

    /**
     * Gets description.
     *
     * @return the description
     */
    String getDescription();


}