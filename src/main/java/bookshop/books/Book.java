package bookshop.books;

public class Book {
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

    public static BookBuilder builder() {
        return new BookBuilder();
    }

    static class BookBuilder {
        private String title;
        private String author;

        public BookBuilder title(String title) {
            this.title = title;
            return this;
        }

        public BookBuilder author(String author) {
            this.author = author;
            return this;
        }

        public Book build() {
            var book = new Book();

            book.setTitle(title);
            book.setAuthor(author);

            return book;
        }
    }
}
