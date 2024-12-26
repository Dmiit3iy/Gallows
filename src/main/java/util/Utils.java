package util;

import model.User;

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
     *
     * @param wordForGame
     * @return
     */
    public static boolean haveAnyStars(String[] wordForGame) {
        return Arrays.stream(wordForGame).anyMatch(word -> word.equals("*"));
    }

    /**
     * Мощный метод для поиска введенной буквы в загаднном слове. Делает уведомление если букву уже вводили.
     *
     * @param secretWord
     * @param wordForGame
     * @param letter
     * @param user
     */
    public static void findChar2(String secretWord, String[] wordForGame, String letter, User user) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.charAt(i) == letter.charAt(0)) {
                list.add(i);
            }
        }
        if (list.isEmpty()) {
            user.minusLive();
            System.out.println("Вы не угадали!");
        } else {
            for (int i : list) {
                if (wordForGame[i].equals(letter)) {
                    System.out.println("Вы уже вводили эту букву");
                    break;
                } else {
                    wordForGame[i] = String.valueOf(secretWord.charAt(i));
                }
            }
            System.out.println(Arrays.toString(wordForGame));
        }
    }


    /**
     * Метод для создания массива с маскировкой букв
     *
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
