package model;

import lombok.AllArgsConstructor;
import repository.WorldRepository;
import util.Utils;

import java.util.Arrays;

import static util.Utils.findChar;
import static util.Utils.haveAnyStars;

@AllArgsConstructor
public class Game {
    private WorldRepository worldRepository;

    public void start() {
        System.out.println("Привет! Введи своё имя и нажми Enter");
        String name = Utils.readWord();
        User user = new User(name);
        System.out.println(user.getUsername() + " тебе можно будет " + user.getLives() + "раз(раза) ошибиться, чтобы отгадать слово");
        String secretWord = worldRepository.getRandomWorld();


        String[] wordForGame = Utils.makeSecretArr(secretWord);
        System.out.println(Arrays.toString(wordForGame));

        while (user.getLives() > 0 && haveAnyStars(wordForGame)) {
            String letter = Utils.readChar();
            int charIndex = findChar(secretWord, letter);
            if (charIndex >= 0) {
                wordForGame[charIndex] = String.valueOf(secretWord.charAt(charIndex));
                System.out.println(Arrays.toString(wordForGame));
            } else {
                user.minusLive();
                System.out.println("Вы не угадали!");
            }
        }
        if (user.getLives() == 0) {
            System.out.println("КОНЦ ИГРЫ. ЗАКОНЧИЛИСЬ ПОПЫТКИ!\nЭто было слово: " + secretWord);
        } else {
            System.out.println("ТЫ ПОБЕДИЛ!!!\nЭто было слово: " + secretWord);
        }

    }
}
