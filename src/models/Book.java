package models;

public class Book {
    public String name;
    public String author;
    public int id;

    public boolean isAvailable;

    public Book(String name, String author, int id) {
        this.name = name;
        this.author = author;
        this.id = id;
        this.isAvailable = true;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
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
        return this.getName() + ";" + this.getAuthor() + ";" + this.getId() + ";" + this.isAvailable();
    }

    public void build(String input) {
        String[] values = input.split(";");
        if (values.length != 4) {
            System.out.println("Error loading string: " + input);
            return;
        }
        this.name = values[0];
        this.author = values[1];
        this.id = Integer.parseInt(values[2]);
        this.isAvailable = Boolean.parseBoolean(values[3]);
    }
}
