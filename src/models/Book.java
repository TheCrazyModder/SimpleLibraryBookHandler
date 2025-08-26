package models;

import static models.BookStatus.AVAILABLE;
import static models.BookStatus.NULL;

public class Book {
    public String name;
    public String author;
    public int id;

    public BookStatus status;

    public Book() {
        this.name = "undefined";
        this.author = "undefined";
        this.id = 0;
        this.status = NULL;
    }

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
        this.id = 0;
        this.status = AVAILABLE;
    }

    public BookStatus getStatus() {
        return this.status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String export() {
        return this.getName() + ";" + this.getAuthor() + ";" + this.getId() + ";" + this.status.toString() + "\n";
    }

    public Book build(String input) {
        String[] values = input.split(";");
        if (values.length != 4) {
            System.out.println("Error loading string: " + input);
            return new Book();
        }
        this.name = values[0];
        this.author = values[1];
        this.id = Integer.parseInt(values[2]);
        this.status = BookStatus.valueOf(values[3]);

        return this;
    }
}
