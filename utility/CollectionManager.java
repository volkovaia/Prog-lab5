package utility;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import data.Coordinates;
import data.Difficulty;
import data.Discipline;
import data.LabWork;
import exception.CommandNeedArgumentException;
import lombok.Value;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;




public class CollectionManager implements CollectionManagerInterface {
    private static LocalDate lastInitTime;
    private final Vector<LabWork> labWorkCollection = new Vector<>();

    private final FileManager fileManager;

    @Override
    public Vector<LabWork> getLabWorkVector() {
        return labWorkCollection;
    }

    public CollectionManager(FileManager fileManager) {
        this.fileManager = fileManager;


    }

    public LabWork addFromInput() {
        Scanner scanner = new Scanner(System.in);

        LabWork labWork = new LabWork(LabWork.enterName(scanner),
                new Coordinates(Coordinates.enterCoordinateX(scanner),
                        Coordinates.enterCoordinateY(scanner)), LocalDate.now(),
                LabWork.enterMinimalPoint(scanner),
                LabWork.enterPersonalQualitiesMinimum(scanner),
                LabWork.enterAveragePoint(scanner),
                Difficulty.enterDifficulty(scanner),
                new Discipline(Discipline.enterDisciplineName(scanner),
                        Discipline.enterDisciplinePractiseHours(scanner),
                        Discipline.enterDisciplineLabsCount(scanner)));
        getLabWorkVector().add(labWork);
        labWork.setId(getId());
        return labWork;
    }

    public LabWork addElementFromFile(LabWork labwork) {
        return labwork;
    }

//    public LabWork addElementFromFile(String filename) {
//        if (filename.isEmpty()) throw new CommandNeedArgumentException();
//        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
//            Scanner scanner = new Scanner(reader);
//
//            LabWork labWork = new LabWork(LabWork.enterNameFromFile(reader.readLine()),
//                    new Coordinates(Coordinates.enterCoordinateXFromFile(scanner),
//                            Coordinates.enterCoordinateYFromFile(scanner)), LocalDate.now(),
//                    LabWork.enterMinimalPointFromFile(scanner),
//                    LabWork.enterPersonalQualitiesMinimumFromFile(scanner),
//                    LabWork.enterAveragePointFromFile(scanner),
//                    Difficulty.enterDifficultyFromFile(scanner),
//                    new Discipline(Discipline.enterDisciplineNameFromFile(scanner),
//                            Discipline.enterDisciplinePractiseHoursFromFile(scanner),
//                            Discipline.enterDisciplineLabsCountFromFile(scanner)));
//            getLabWorkVector().add(labWork);
//            labWork.setId(getId());
//            return labWork;
//
//        } catch (IOException e) {
//            System.out.println("Что-то пошло не так...");
//        } return null;
//    }
//public <T> LabWork addElementFromFile(T argument) {
//
//    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
//        Scanner scanner = new Scanner(reader);
//
//        LabWork labWork = new LabWork(LabWork.enterNameFromFile(reader.readLine()),
//                new Coordinates(Coordinates.enterCoordinateXFromFile(scanner),
//                        Coordinates.enterCoordinateYFromFile(scanner)), LocalDate.now(),
//                LabWork.enterMinimalPointFromFile(scanner),
//                LabWork.enterPersonalQualitiesMinimumFromFile(scanner),
//                LabWork.enterAveragePointFromFile(scanner),
//                Difficulty.enterDifficultyFromFile(scanner),
//                new Discipline(Discipline.enterDisciplineNameFromFile(scanner),
//                        Discipline.enterDisciplinePractiseHoursFromFile(scanner),
//                        Discipline.enterDisciplineLabsCountFromFile(scanner)));
//        getLabWorkVector().add(labWork);
//        labWork.setId(getId());
//        return labWork;
//
//    } catch (IOException e) {
//        System.out.println("Что-то пошло не так...");
//    } return null;
//}
    public void updateByIdCollection(int id){
        if (getLabWorkVector().removeIf((labWork -> labWork.getId() == id))) {
            addFromInput().setId(id);
            System.out.println("Элемент с " + id + " успешно обновлён!");
        }
        else {
            System.out.println("Нет элемента с таким id!");
        }
    }

    public void clear(){
        labWorkCollection.clear();
        System.out.println("Коллекция очищена");
    }


    @Override

    public LocalDate getLastInitTime() {
        return lastInitTime;
    }


    public void loadCollection(){
        lastInitTime = LocalDate.now();

        labWorkCollection.addAll(fileManager.readCollection());

        Vector<LabWork> uniqueLabWork = new Vector<>();
        Set<Integer> uniqueIDs = new HashSet<>();
        for (LabWork labWork : getLabWorkVector()) {
            int oldID = labWork.getId();
            if (!uniqueIDs.add(oldID)) {
                System.out.println("Проверьте id " + oldID + ", он не является уникальным!");
                int newID = getId();
                while (!uniqueIDs.add(newID)) {
                    newID = getId();
                }
                labWork.setId(newID);
                System.out.println("Заменён на уникальный id: " + newID);
            }
            uniqueLabWork.add(labWork);
        }

    }
    int lastId = 1;
    public int getId() {
            for (LabWork labWork : getLabWorkVector()) {

                while (labWork.getId() == lastId) {
                    lastId += 1;
                }
            }

        return lastId;
    }
    public boolean checkExist(int id) {
        return labWorkCollection.stream()
                .anyMatch((x) -> x.getId() == id);
    }


}



