package data;


import lombok.Data;
import lombok.Getter;

import java.util.Scanner;

/**
 * The type Discipline.
 */
@Data
public class Discipline implements Comparable<Discipline>{

    private String name; //Поле не может быть null, Строка не может быть пустой

    private Long practiceHours; //Поле может быть null

    private Long labsCount; //Поле не может быть null


    /**
     * Instantiates a new Discipline.
     *
     * @param name          the name
     * @param practiceHours the practice hours
     * @param labsCount     the labs count
     */
    public Discipline(String name, Long practiceHours, Long labsCount) {
        this.name = name;
        this.practiceHours = practiceHours;
        this.labsCount = labsCount;
    }

    @Override
    public String toString() {
        return "{ \"name\": " + name + "\", \"practiceHours\": " + practiceHours + ", \"labsCount\": " + labsCount + " }";
    }

    /**
     * Enter discipline name string.
     *
     * @param scanner the scanner
     * @return the string
     */
    public static String enterDisciplineName(Scanner scanner) {
        System.out.println("Введите disciplineName: ");
        String in = scanner.nextLine();
        if (in.isBlank()) {
            System.out.println("Имя дисциплины не может быть пустым");
            return enterDisciplineName(scanner);
        } else {
            return in;
        }
    }

    /**
     * Enter discipline name from file string.
     *
     * @param line the line
     * @return the string
     */
    public static String enterDisciplineNameFromFile(String line) {
        String in = line;
        if (in.isBlank()) {
            System.out.println("Имя дисциплины не может быть пустым");
            return enterDisciplineNameFromFile(line);
        } else {
            return in;
        }
    }

    /**
     * Enter discipline practise hours long.
     *
     * @param scanner the scanner
     * @return the long
     */
    public static Long enterDisciplinePractiseHours(Scanner scanner) {
        System.out.println("Введите disciplinePractiseHours: ");
        try {
            Long in = Long.parseLong(scanner.nextLine());
            return in;
        } catch (NumberFormatException e) {
            System.out.println("Команда ожидает целочисленное значение, попробуйте снова!");
            return enterDisciplinePractiseHours(scanner);
        }
    }

    /**
     * Enter discipline practise hours from file long.
     *
     * @param line the line
     * @return the long
     */
    public static Long enterDisciplinePractiseHoursFromFile(String line) {
        try {
            Long in = Long.parseLong(line);
            return in;
        } catch (NumberFormatException e) {
            System.out.println("Команда ожидает целочисленное значение, попробуйте снова!");
            return enterDisciplinePractiseHoursFromFile(line);
        }
    }

    /**
     * Enter discipline labs count long.
     *
     * @param scanner the scanner
     * @return the long
     */
    public static Long enterDisciplineLabsCount(Scanner scanner) {
        System.out.println("Введите disciplineLabsCount: ");
        try {
            Long in = Long.parseLong(scanner.nextLine());
            return in;

        } catch (NumberFormatException e) {
            System.out.println("Команда ожидает численное значение, попробуйте снова!");
            return enterDisciplineLabsCount(scanner);
        }
    }

    /**
     * Enter discipline labs count from file long.
     *
     * @param line the line
     * @return the long
     */
    public static Long enterDisciplineLabsCountFromFile(String line) {
        try {
            Long in = Long.parseLong(line);
            return in;

        } catch (NumberFormatException e) {
            System.out.println("Команда ожидает численное значение, попробуйте снова!");
            return enterDisciplineLabsCountFromFile(line);
        }
    }
    public int compareTo(Discipline getDiscipline){
        return (int)(this.labsCount - getDiscipline.getLabsCount());

    }
}