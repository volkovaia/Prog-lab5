package data;

import exception.IllegalValueException;
import lombok.Data;
import lombok.NoArgsConstructor;
import utility.CollectionManager;

import java.io.BufferedReader;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Scanner;

import static javax.management.Query.isInstanceOf;
import static javax.management.Query.value;

/**
 * The type Lab work.
 */
@Data
@NoArgsConstructor
public class LabWork implements Comparator<LabWork> {


    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private long minimalPoint; //Значение поля должно быть больше 0
    private Float personalQualitiesMinimum; //Поле не может быть null, Значение поля должно быть больше 0
    private float averagePoint; //Значение поля должно быть больше 0
    private Difficulty difficulty; //Поле может быть null
    private Discipline discipline; //Поле может быть null


    /**
     * Check all variables.
     *
     * @throws IllegalValueException the illegal value exception
     */
    public void checkAllVariables() throws IllegalValueException {
        if (id < 0) {
            throw new IllegalValueException("ID меньше нуля");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalValueException("Введите имя");
        }
        if (coordinates == null) {
            throw new IllegalValueException("Поле не может быть null");
        }
        if (creationDate == null) {
            throw new IllegalValueException("Поле не может быть пустым");
        }
        if (minimalPoint <= 0) {
            throw new IllegalValueException("Значение поля должно быть больше 0");
        }
        if (personalQualitiesMinimum == null || personalQualitiesMinimum <= 0) {
            throw new IllegalValueException("Поле должно быть больше 0, не может быть пустым");
        }
        if (averagePoint <= 0) {
            throw new IllegalValueException("Значение поля должно быть больше 0");
        }
    }

    /**
     * Instantiates a new Lab work.
     *
     * @param name                     the name
     * @param coordinates              the coordinates
     * @param creationDate             the creation date
     * @param minimalPoint             the minimal point
     * @param personalQualitiesMinimum the personal qualities minimum
     * @param averagePoint             the average point
     * @param difficulty               the difficulty
     * @param discipline               the discipline
     */
    public LabWork(String name, Coordinates coordinates, LocalDate creationDate, long minimalPoint, Float personalQualitiesMinimum, float averagePoint, Difficulty difficulty, Discipline discipline) {
        try {
            this.name = name;
            this.coordinates = coordinates;
            this.creationDate = creationDate;
            this.minimalPoint = minimalPoint;
            this.personalQualitiesMinimum = personalQualitiesMinimum;
            this.averagePoint = averagePoint;
            this.difficulty = difficulty;
            this.discipline = discipline;

            checkAllVariables();

        } catch (IllegalValueException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public String toString() {
        return "{\n\"id\": " + id + ",\n" +
                "\"name\": \"" + name + "\",\n" +
                "\"coordinates\": " + coordinates + ",\n" +
                "\"creationDate\": \"" + creationDate + "\",\n" +
                "\"minimalPoint\": " + minimalPoint + ",\n" +
                "\"personalQualitiesMinimum\": " + personalQualitiesMinimum + ",\n" +
                "\"averagePoint\": " + averagePoint + ",\n" +
                "\"difficulty\": " + (difficulty == null ? "null" : "\"" + difficulty + "\"") + ",\n" +
                "\"discipline\": " + discipline + "\n" + "}\n";
    }


    @Override
    public int compare(LabWork o1, LabWork o2) {
        return Integer.compare(o1.id, o2.id);
    }


    /**
     * Enter name string.
     *
     * @param scanner the scanner
     * @return the string
     */
    public static String enterName(Scanner scanner) {
        System.out.println("Введите name: ");

        String in = scanner.nextLine();
        if (in.isBlank()) {
            System.out.println("Имя не может быть пустым");
            return enterName(scanner);
        } else {
            return in;
        }
    }

    /**
     * Enter name from file string.
     *
     * @param line the line
     * @return the string
     */
    public static String enterNameFromFile(String line) {
        String in = line;
        if (in.isBlank()) {
            System.out.println("Имя не может быть пустым");
            //return enterNameFromFile(line);
            return ("Проверьте скрипт!");
        } else {
            return in;
        }
    }

    /**
     * Enter minimal point long.
     *
     * @param scanner the scanner
     * @return the long
     */
    public static long enterMinimalPoint(Scanner scanner) {
        System.out.println("Введите minimalPoint: ");
        try {
            long in = Long.parseLong(scanner.nextLine());
            if (in <= 0) {
                System.out.println("Минимальное значение не может быть пустым или меньшим нуля");
                return enterMinimalPoint(scanner);
            } else {
                return in;
            }
        } catch (NumberFormatException e) {
            System.out.println("Минимальное значение должно быть типа long. Попробуйте снова!");
            return enterMinimalPoint(scanner);
        }

    }

    /**
     * Enter minimal point from file long.
     *
     * @param line the line
     * @return the long
     */
    public static long enterMinimalPointFromFile(String line) {
        try {
            long in = Long.parseLong(line);
            if (in <= 0) {
                System.out.println("Минимальное значение не может быть пустым или меньшим нуля");
                return enterMinimalPointFromFile(line);

            } else {
                //System.out.println(in instanceof Long);
                return in;
            }
        } catch (NumberFormatException e) {
            System.out.println("Минимальное значение должно быть типа long. Попробуйте снова!");
            return enterMinimalPointFromFile(line);
        }

    }
//    public static long enterIDFromFile(Scanner scanner) {
//        try {
//            int in = Integer.parseInt(scanner.nextLine());
//            if (in <= 0) {
//                System.out.println("ID не может быть пустым или меньшим нуля");
//                return enterIDFromFile(scanner);
//            } else {
//                return in;
//            }
//        } catch (NumberFormatException e) {
//            System.out.println("Минимальное значение должно быть типа long. Попробуйте снова!");
//            return enterIDFromFile(scanner);
//        }
//
//    }

    /**
     * Enter personal qualities minimum float.
     *
     * @param scanner the scanner
     * @return the float
     */
    public static Float enterPersonalQualitiesMinimum(Scanner scanner) {
        System.out.println("Введите personalQualitiesMinimum: ");
        try {
            Float in = Float.parseFloat(scanner.nextLine());
            if (in <= 0 || in == null) {
                System.out.println("Минимальные личностные качества не могут быть меньше 0 или пустым");
                return enterPersonalQualitiesMinimum(scanner);
            } else {
                return in;
            }
        } catch (NumberFormatException e) {
            System.out.println("Минимальные личностные качества должны быть типа Float. Попробуйте снова!");
            return enterPersonalQualitiesMinimum(scanner);
        }
    }

    /**
     * Enter personal qualities minimum from file float.
     *
     * @param line the line
     * @return the float
     */
    public static Float enterPersonalQualitiesMinimumFromFile(String line) {
        try {
            Float in = Float.parseFloat(line);
            if (in <= 0 || in == null) {
                System.out.println("Минимальные личностные качества не могут быть меньше 0 или пустым");
                return enterPersonalQualitiesMinimumFromFile(line);
            } else {
                return in;
            }
        } catch (NumberFormatException e) {
            System.out.println("Минимальные личностные качества должны быть типа Float. Попробуйте снова!");
            return enterPersonalQualitiesMinimumFromFile(line);
        }
    }

    /**
     * Enter average point float.
     *
     * @param scanner the scanner
     * @return the float
     */
    public static float enterAveragePoint(Scanner scanner) {
        System.out.println("Введите averagePoint: ");
        try {
            Float in = Float.parseFloat(scanner.nextLine());
            if (in <= 0) {
                System.out.println("Среднее значение не может быть меньше 0");
                return enterAveragePoint(scanner);
            } else {
                return in;
            }
        } catch (NumberFormatException e) {
            System.out.println("Среднее значение должно быть типа float. Попробуйте снова!");
            return enterAveragePoint(scanner);
        }
    }

    /**
     * Enter average point from file float.
     *
     * @param line the line
     * @return the float
     */
    public static float enterAveragePointFromFile(String line) {
        try {
            Float in = Float.parseFloat(line);
            if (in <= 0) {
                System.out.println("Среднее значение не может быть меньше 0");
                return enterAveragePointFromFile(line);
            } else {
                return in;
            }
        } catch (NumberFormatException e) {
            System.out.println("Среднее значение должно быть типа float. Попробуйте снова!");
            return enterAveragePointFromFile(line);
        }
    }


}


