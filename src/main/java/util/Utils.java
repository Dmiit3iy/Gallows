package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Utils {

    public static String readChar() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите одну букву: ");
        String input = scanner.nextLine();
        while (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
            System.out.print("Ошибка! Введите одну букву: ");
            input = scanner.nextLine();
        }
        return input;
    }

    public static String readWord() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (input.isEmpty()) {
            System.out.print("Ошибка, вы ввели пустое слово. Повторите ввод:");
            input = scanner.nextLine();
        }
        return input;
    }

    /**
     * Метод для проверки, того что в слове остались не отгаданные буквы
     * @param wordForGame
     * @return
     */
    public static boolean haveAnyStars(String[] wordForGame) {
        return Arrays.stream(wordForGame).anyMatch(word -> word.equals("*"));
    }

    /**
     * Метод для поиска индекса переданной буквы в угадываемом слове. Если нет такой буквы, возвращаем -1
     * @param secretWord
     * @param letter
     * @return
     */
    public static int findChar(String secretWord, String letter) {
        return secretWord.indexOf(letter);
    }

    public static List<Integer> findChar2(String secretWord, String letter) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.charAt(i) == letter.charAt(0)) {

                list.add(i);
            }
        }
        return list;
    }


    /**
     * Метод для создания массива с маскировкой букв
     * @param secretWord
     * @return
     */
    public static String[] makeSecretArr(String secretWord) {
        int length = secretWord.length();
        String[] wordForGame = new String[length];
        Arrays.fill(wordForGame, "*");
        return wordForGame;
    }
}
