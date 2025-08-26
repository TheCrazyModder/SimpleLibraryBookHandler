import models.Book;
import models.BookStatus;
import models.Database;

import java.io.File;

public class CLI {
    public CLI() {}

    Database database;

    public void init() {
        database = new Database();
    }

    public void tempTest() {
        database.addBook(new Book("test", "test"));
        for (int i = 0; i < 1000; i++) {
            database.addBook(new Book("test" + i, "test"));
        }

        database.saveToFile(new File("save.csv"));
        Database testing = new Database();
        testing.loadFromFile(new File("save.csv"));

        testing.getBook("test1").setStatus(BookStatus.BORROWED);

        System.out.println(testing.getBook("test1").getStatus().toString());
    }
}
