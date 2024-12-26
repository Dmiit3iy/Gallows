import model.Game;
import repository.LoadFromFile;
import repository.WorldRepository;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            WorldRepository worldRepository = new WorldRepository(new LoadFromFile());
            worldRepository.initRepository();
            Game game = new Game(worldRepository);
            game.start();
        } catch (IOException e) {
            System.out.println("Ошибка запуска игры. Не найден файл со словами для загадки."
            );
        }

    }

}
