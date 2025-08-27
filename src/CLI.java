import models.Book;
import models.BookStatus;
import models.Database;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class CLI {
    public CLI() {}

    enum Actions {
        ADD,
        REMOVE,
        CHECK_STATUS,
        NONE
    }

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

    public void userInteractLoop() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("> ");
            String command = scanner.nextLine();

            if (command.equalsIgnoreCase("add")) {
                System.out.println("Title: ");
                String title = scanner.nextLine();
                System.out.println("Author: ");
                String author = scanner.nextLine();

                Book book = new Book(title, author);
                database.addBook(book);

                System.out.println(title + " by " + author + " added to database");
                continue;
            } else if (command.equalsIgnoreCase("search")) {
                System.out.println("Search: ");
                String search = scanner.nextLine();
                ArrayList<Book> books = database.getBooksByTitleSearch(search);

                if (books.size() == 0) {
                    System.out.println("No books match the search: " + search);
                    continue;
                }

                for (Book book : books) {
                    System.out.println(book.getName() + " by " + book.getAuthor() + " >" + book.id);
                }
            }


        }
    }

}
