package others;

import java.util.ArrayList;
import java.util.List;

public class Library extends Building {

    public static void main(String[] args) {
        List<Library> libraries = new ArrayList<>();
        libraries.add(new Library());
        printBuildings(libraries);
    }
}