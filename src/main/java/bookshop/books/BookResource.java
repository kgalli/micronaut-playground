package bookshop.books;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class BookResource {
    private String title;
    private String author;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public static BookResource from(Book book) {
        var bookResource =  new BookResource();

        bookResource.setTitle(book.getTitle());
        bookResource.setAuthor(book.getAuthor());

        return bookResource;
    }
}
