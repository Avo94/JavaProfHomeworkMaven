package Prof38Homework_06_07_2023.model;

public class Book {

    private String name;
    private long isbn;
    private Author author;
    private int year;

    public Book(String name, long isbn, Author author, int year) {
        this.name = name;
        this.isbn = isbn;
        this.author = author;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", isbn=" + isbn +
                ", author=" + author +
                ", year=" + year +
                '}';
    }
}
