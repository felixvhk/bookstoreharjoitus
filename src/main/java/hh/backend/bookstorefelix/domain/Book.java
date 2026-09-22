package hh.backend.bookstorefelix.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String author;
    private String title;
    private String isbn;
    private int publicationYear;

    @ManyToOne
    // Prevents infinite recursion during JSON serialization by ignoring the "books" property in the Category class
    @JsonIgnoreProperties ("books") 
    @JoinColumn(name = "categoryid")
    private Category category;

    protected Book() {
    }

    public Book(String author, String title, String isbn, int publicationYear, Category category) {
        this.author = author;
        this.title = title;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", author=" + author + ", title=" + title + ", isbn=" + isbn + ", publicationYear=" + publicationYear + ", category=" + category.getName() + "]";
    }
}
