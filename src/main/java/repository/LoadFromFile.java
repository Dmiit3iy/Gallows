package repository;

import constant.Constants;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class LoadFromFile implements Loadable {

    @Override
    public List<String> load() throws IOException {
        List<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(Constants.FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
            return list;
        }
    }
}
