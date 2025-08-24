package models;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Database {
    public ArrayList<Book> books;

    public Database() {
        books = new ArrayList<>();
    }

    public Book getBook(String name) {
        for (Book book : books) {
            if (book.getName().equalsIgnoreCase(name)) {
                return book;
            }
        }
        return null;
    }

    public Book getBook(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    public ArrayList<Book> getBooksByAuthor(String author) {
        ArrayList<Book> matches = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                matches.add(book);
            }
        }

        return matches;
    }


    public void addBook(Book book) {
        int id = book.getName().hashCode();
        if (getBook(id) != null) {return;} // duplicate book
        books.add(book);
    }

    public boolean loadFromFile(File file) {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println("line: " + line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Can't open file: " + file.getName());
            return false;
        }
        return true;
    }

    public void saveToFile(File file) {
        try {
            FileWriter writer = new FileWriter(file);
            for (Book book : books) {
                writer.write(book.export());

                // DEBUG
                System.out.println(book.export());

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
