package repository;

import constant.Constants;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


public class LoadFromFile implements Loadable {

    @Override
    public List<String> load() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(Constants.FILE_NAME))) {
            return reader.lines().collect(Collectors.toList());
        }
    }
}
