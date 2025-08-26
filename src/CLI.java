import models.Book;
import models.Database;

import java.io.File;

public class CLI {
    public CLI() {}

    public void init() {
        Database database = new Database();
        database.addBook(new Book("test", "test"));
        for (int i = 0; i < 1000; i++) {
            database.addBook(new Book("test" + i, "test"));
        }

        database.saveToFile(new File("save.csv"));
        Database testing = new Database();
        testing.loadFromFile(new File("save.csv"));

        System.out.println(testing.getBook("test1").getAuthor());
    }
}
