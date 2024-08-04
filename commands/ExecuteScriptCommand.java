package commands;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import commands.Command;
import data.Coordinates;
import data.Difficulty;
import data.Discipline;
import data.LabWork;
import exception.CommandNeedArgumentException;
import exception.CommandNotAcceptArgumentsException;
import utility.CollectionManager;
import utility.CommandManager;
import utility.ConsoleManager;
import utility.FileManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;


/**
 * The type Execute script command.
 */
public class ExecuteScriptCommand implements Command {
    //private static LocalDate lastInitTime;
    private final Vector<LabWork> labWorkCollection = new Vector<>();

    /**
     * Gets lab work vector.
     *
     * @return the lab work vector
     */
    public Vector<LabWork> getLabWorkVector() {
        return labWorkCollection;
    }
    private ConsoleManager consoleManager;
    /**
     * The File name stack.
     */
//private CollectionManager collectionManager;
    Stack<String> fileNameStack = new Stack<>();
    private CollectionManager collectionManager;

    /**
     * Instantiates a new Execute script command.
     *
     * @param consoleManager    the console manager
     * @param collectionManager the collection manager
     */
    public ExecuteScriptCommand(ConsoleManager consoleManager, CollectionManager collectionManager) {
        this.consoleManager = consoleManager;
        this.collectionManager = collectionManager;
    }


    @Override
    public void execute(String argument) {
        List<String> data = new ArrayList<>();
        try {
            //if (argument.isEmpty()) throw new CommandNeedArgumentException();

            try (BufferedReader reader = new BufferedReader(new FileReader(argument))) {
                Scanner userScanner = new Scanner(reader);
                consoleManager.setScanner(userScanner);
                fileNameStack.add(argument);



                while (userScanner.hasNext()) {
                    String line = userScanner.nextLine();
                    if (line.equals("add")) {
                        //System.out.println("это оно");
                        userScanner.nextLine();
                        try {
                            var name = LabWork.enterNameFromFile(userScanner.nextLine());
                            var coordinate = new Coordinates(Coordinates.enterCoordinateXFromFile(userScanner.nextLine()),
                                            Coordinates.enterCoordinateYFromFile(userScanner.nextLine()));
                            var minimalPoint = LabWork.enterMinimalPointFromFile(userScanner.nextLine());
                            var personalQualitiesMinimum = LabWork.enterPersonalQualitiesMinimumFromFile(userScanner.nextLine());
                            var averagePoint = LabWork.enterAveragePointFromFile(userScanner.nextLine());
                            var difficulty =  Difficulty.enterDifficultyFromFile(userScanner.nextLine());
                            var discipline = new Discipline(Discipline.enterDisciplineNameFromFile(userScanner.nextLine()),
                                              Discipline.enterDisciplinePractiseHoursFromFile(userScanner.nextLine()),
                                              Discipline.enterDisciplineLabsCountFromFile(userScanner.nextLine()));



//                            LabWork labWork = new LabWork(LabWork.enterNameFromFile(userScanner.nextLine()),
//                                    new Coordinates(Coordinates.enterCoordinateXFromFile(userScanner.nextLine()),
//                                            Coordinates.enterCoordinateYFromFile(userScanner.nextLine())), LocalDate.now(),
//                                    LabWork.enterMinimalPointFromFile(userScanner.nextLine()),
//                                    LabWork.enterPersonalQualitiesMinimumFromFile(userScanner.nextLine()),
//                                    LabWork.enterAveragePointFromFile(userScanner.nextLine()),
//                                    Difficulty.enterDifficultyFromFile(userScanner.nextLine()),
//                                    new Discipline(Discipline.enterDisciplineNameFromFile(userScanner.nextLine()),
//                                            Discipline.enterDisciplinePractiseHoursFromFile(userScanner.nextLine()),
//                                            Discipline.enterDisciplineLabsCountFromFile(userScanner.nextLine())));
                            LabWork labWork = new LabWork(name, coordinate, LocalDate.now(), minimalPoint, personalQualitiesMinimum, averagePoint, difficulty, discipline);
                            collectionManager.getLabWorkVector().add(labWork);
                            labWork.setId(collectionManager.getId());

                            collectionManager.addElementFromFile(labWork);
                            //collectionManager.updateByIdCollection(collectionManager.getId());
                            System.out.println("Элемент успешно добавлен в коллекцию!");

                            //collectionManager.loadCollection();

                            //SaveCommand saveCommand = new SaveCommand(new FileManager("C:\\Users\\Ирина\\IdeaProjects\\laborat5\\json\\file_new.json"), collectionManager);


                        }
                        catch (IllegalArgumentException e) {
                        System.out.println("Что-то пошло не так...");
                        }
                    } else if (line.contains("update_by_id")) {
                            String[] args = line.split(" ");
                            Integer id = Integer.parseInt(args[1]);

                            if (collectionManager.getLabWorkVector().removeIf((labWork -> labWork.getId() == id))) {
                                //collectionManager.loadCollection();

                                var name = LabWork.enterNameFromFile(userScanner.nextLine());
                                var coordinate = new Coordinates(Coordinates.enterCoordinateXFromFile(userScanner.nextLine()),
                                        Coordinates.enterCoordinateYFromFile(userScanner.nextLine()));
                                var minimalPoint = LabWork.enterMinimalPointFromFile(userScanner.nextLine());
                                var personalQualitiesMinimum = LabWork.enterPersonalQualitiesMinimumFromFile(userScanner.nextLine());
                                var averagePoint = LabWork.enterAveragePointFromFile(userScanner.nextLine());
                                var difficulty =  Difficulty.enterDifficultyFromFile(userScanner.nextLine());
                                var discipline = new Discipline(Discipline.enterDisciplineNameFromFile(userScanner.nextLine()),
                                        Discipline.enterDisciplinePractiseHoursFromFile(userScanner.nextLine()),
                                        Discipline.enterDisciplineLabsCountFromFile(userScanner.nextLine()));

                                LabWork labWork = new LabWork(name,  coordinate, LocalDate.now(), minimalPoint, personalQualitiesMinimum, averagePoint, difficulty, discipline);



                                collectionManager.getLabWorkVector().add(labWork);
                                labWork.setId(id);

                                collectionManager.addElementFromFile(labWork);
                                //collectionManager.loadCollection();


                            }

                                System.out.println("Элемент с " + id + " успешно обновлён!");


                    } else if (line.contains("C:\\")){
                        if (!fileNameStack.contains(line)) {
                            fileNameStack.add(line);
//                          consoleManager.StartCommandLoop();
                            execute(line);
                        } else {
                            System.err.println("Обнаружена рекурсия, проверьте скрипт!");
                        }


                    } else {
                        System.out.println("Обработка этой команды не предусмотрена");
                    }
                }

//                        String result = userScanner.nextLine();
//                        System.out.println(result);


            } catch (IOException ex) {
                System.out.println("Неправильный ввод данных, проверьте скрипт!");
            }

//                    String line;
//                    while (userScanner.hasNextLine()){
//                        line = userScanner.nextLine();
//                        data.add(line);
//                    }


            consoleManager.setScanner(new Scanner(System.in));


//        } catch (IOException e) {
//            System.err.println(e.getMessage());
        } catch (CommandNeedArgumentException e) {
            System.out.println("Этой команде необходим аргумент, введите адрес файла!");
        }
    }

        @Override
        public String getName () {
            return "execute_script";
        }

        @Override
        public String getDescription () {
            return "команда, считывающая и исполняющая скрипт из указанного файла";
        }
}
