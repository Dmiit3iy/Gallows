package repository;

import java.io.IOException;
import java.util.List;


public interface Loadable {
     List <String> load() throws IOException;
}
