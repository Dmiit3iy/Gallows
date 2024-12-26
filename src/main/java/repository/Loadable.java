package repository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public interface Loadable {
     List <String> load() throws IOException;
}
