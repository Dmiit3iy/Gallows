package repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WorldRepository {
    private Loadable loadable;

    private List<String> worlds = new ArrayList<>();
    private Random rand = new Random();

    public WorldRepository(Loadable loadable) {
        this.loadable = loadable;
    }

    /**
     * Метод для инициализации репозитория
     */
    public void initRepository() throws IOException {
        worlds.addAll(loadable.load());
    }

    /**
     * Метод для получения случайного слова
     *
     * @return
     */
    public String getRandomWorld() {
        if (!worlds.isEmpty()) {
            return worlds.get(this.rand.nextInt(worlds.size()));
        } else  {
            return "транзакция";
        }
    }
}
