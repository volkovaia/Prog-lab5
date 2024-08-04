package data;

import commands.Command;
import commands.ExecuteScriptCommand;

import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

/**
 * The enum Difficulty.
 */
public enum Difficulty {
    /**
     * Easy difficulty.
     */
    EASY,
    /**
     * Normal difficulty.
     */
    NORMAL,
    /**
     * Insane difficulty.
     */
    INSANE;
    private static HashMap<Integer, String> putByNumber = new HashMap<>();


    /**
     * Enter difficulty difficulty.
     *
     * @param scanner the scanner
     * @return the difficulty
     */
    public static Difficulty enterDifficulty(Scanner scanner) {
        putByNumber.put(1, "EASY");
        putByNumber.put(2, "NORMAL");
        putByNumber.put(3, "INSANE");

        try {

            StringBuilder stringBuilder = new StringBuilder("Введите difficulty: ");
            for (Difficulty difficulty1 : Difficulty.values()) {
                stringBuilder.append(difficulty1).append(" ");
            }
            System.out.println(stringBuilder);
            int in = Integer.parseInt(scanner.nextLine());
            //String in = scanner.nextLine().toUpperCase(Locale.ROOT);


            return Difficulty.valueOf(Difficulty.putByNumber.get(in));
            //return Difficulty.valueOf(putByNumber(in));
//            StringBuilder stringBuilder = new StringBuilder("Введите difficulty: ");
//            for (Difficulty difficulty : Difficulty.values()){
//                for (Integer values : putByNumber.values()){
//
//                }

        } catch (NullPointerException e) {
            System.out.println("Нет такого уровня сложности!");
            return enterDifficulty(scanner);
        }
    }

    /**
     * Enter difficulty from file difficulty.
     *
     * @param line the line
     * @return the difficulty
     */
    public static Difficulty enterDifficultyFromFile(String line) {
        putByNumber.put(1, "EASY");
        putByNumber.put(2, "NORMAL");
        putByNumber.put(3, "INSANE");

        try {
            StringBuilder stringBuilder = new StringBuilder();
            for (Difficulty difficulty1 : Difficulty.values()) {
                stringBuilder.append(difficulty1).append(" ");
            }
            //System.out.println(stringBuilder);
            int in = Integer.parseInt(line);
            //String in = scanner.nextLine().toUpperCase(Locale.ROOT);


            return Difficulty.valueOf(Difficulty.putByNumber.get(in));
            //return Difficulty.valueOf(putByNumber(in));
//            StringBuilder stringBuilder = new StringBuilder("Введите difficulty: ");
//            for (Difficulty difficulty : Difficulty.values()){
//                for (Integer values : putByNumber.values()){
//
//                }

        } catch (NullPointerException e) {
            System.out.println("Нет такого уровня сложности!");
            return enterDifficultyFromFile(line);
        }
    }
}