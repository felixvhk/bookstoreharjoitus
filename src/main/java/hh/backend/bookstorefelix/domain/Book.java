package hh.backend.bookstorefelix.domain;

public class Book {

    private String title;
    private String author;
    private int publicationYear;
    private String isbn;
    private int price;

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
