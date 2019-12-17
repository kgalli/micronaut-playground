package bookshop.books;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.util.List;
import java.util.stream.Collectors;


@Controller("/books")
public class BooksController {

    private final BooksService booksService;

    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    @Get
    public List<BookResource> index() {
        return booksService.fetchBooks()
                .stream()
                .map(book -> BookResource.from(book))
                .collect(Collectors.toList());
    }
}
