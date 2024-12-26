import model.User;
import repository.LoadFromFile;
import repository.WorldRepository;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        WorldRepository worldRepository = new WorldRepository(new LoadFromFile());
        worldRepository.initRepository();
        System.out.println("Привет! Введи своё имя и нажми Enter");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        User user = new User(name);
        System.out.println(user.getUsername()+" тебе можно будет "+ user.getLives()+ "раз(раза) ошибиться, что бы отгадать слово");
        String secretWorld= worldRepository.getRandomWorld();
        int length = secretWorld.length();
        String[] wordForGame = new String[length];
        Arrays.fill(wordForGame,"*");
        System.out.println(Arrays.toString(wordForGame));

        while(user.getLives()>0&&haveAnyStars(wordForGame)){

        }


    }

    private static boolean haveAnyStars(String[] wordForGame) {
        return Arrays.stream(wordForGame).anyMatch(word -> word.equals("*"));
    }
}
