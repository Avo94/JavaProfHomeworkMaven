package Prof38Homework_06_07_2023.repository;

import Prof38Homework_06_07_2023.model.Book;

import java.util.List;

public interface BookRepository {

    List<Book> getAll();

    Book findOne(long isbn);

    Book borrowFromLibrary(long isbn);

    boolean returnToLibrary(Book book);
}
