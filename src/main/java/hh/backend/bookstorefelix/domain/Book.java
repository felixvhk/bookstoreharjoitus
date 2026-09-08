package hh.backend.bookstorefelix.domain;

public class Book {

    private String title;
    private String author;
    private int publicationYear;
    private String isbn;
    private int price;

    public Book(String title, String author, int publicationYear, String isbn, int price) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getPrice() {
        return price;
    }
}
