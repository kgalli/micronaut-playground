package bookshop.books;

import org.jooq.DSLContext;

import javax.inject.Singleton;
import java.util.List;

import static bookshop.jooq.Tables.BOOKS;

@Singleton
public class BooksRepository {

    private final DSLContext context;

    public BooksRepository(DSLContext context) {
        this.context = context;
    }

    public List<Book> findAll() {
        return context
                .select()
                .from(BOOKS)
                .fetchInto(Book.class);
    }
}
