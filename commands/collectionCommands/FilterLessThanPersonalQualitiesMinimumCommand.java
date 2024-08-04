package commands.collectionCommands;

import commands.Command;
import data.LabWork;
import utility.CollectionManager;
import utility.CommandManager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

/**
 * The type Filter less than personal qualities minimum command.
 */
public class FilterLessThanPersonalQualitiesMinimumCommand implements Command {

    /**
     * The Collection manager.
     */
    CollectionManager collectionManager;

    /**
     * Instantiates a new Filter less than personal qualities minimum command.
     *
     * @param collectionManager the collection manager
     */
    public FilterLessThanPersonalQualitiesMinimumCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }
    @Override
    public void execute(String argument) {

        try {
            Float arg = Float.parseFloat(argument);
            List<LabWork> array;
            array = collectionManager.getLabWorkVector().stream()
                    .filter((labWork -> {
                        Float compare = labWork.getPersonalQualitiesMinimum();
                        return arg > compare;
                    })).collect(Collectors.toList());
            if (array.isEmpty()) {
                System.out.println("Нет полей personalQualitiesMinimum меньше заданного");
            } else {array.stream().forEach((labWork -> System.out.println(labWork.toString())));}

        }catch (NumberFormatException e){
            System.out.println("Команде нужен числовой аргумент, попробуйте снова!");
        }

    }

    @Override
    public String getName() {
        return "filter_less_than_personal_qualities_minimum";
    }

    @Override
    public String getDescription() {
        return "команда, выводящая элементы, значение поля personalQualitiesMinimum которых меньше заданного. Команда ожидает числовой аргумент";
    }
}

