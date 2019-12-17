package bookshop.books;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.sql.DataSource;
import java.util.List;

@Singleton
public class BooksService {

    private List<Book> staticBookList = List.of(
            Book.builder()
                    .title("Das Café am Ende der Welt")
                    .author("John Strelecky")
                    .build(),
            Book.builder()
                    .title("Siddharta")
                    .author("Hermann Hesse")
                    .build()
    );

    private final BooksRepository repository;

    public BooksService(BooksRepository repository) {
        this.repository = repository;
    }

    public List<Book> fetchBooks() {
        return repository.findAll();
    }
}
