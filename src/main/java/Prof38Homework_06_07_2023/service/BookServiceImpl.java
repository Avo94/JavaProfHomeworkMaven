package Prof38Homework_06_07_2023.service;

import Prof38Homework_06_07_2023.model.Book;
import Prof38Homework_06_07_2023.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAll() {
        return bookRepository.getAll();
    }

    @Override
    public Book findOne(long isbn) {
        return bookRepository.findOne(isbn);
    }

    @Override
    public Book borrowFromLibrary(long isbn) {
        return bookRepository.borrowFromLibrary(isbn);
    }

    @Override
    public boolean returnToLibrary(Book book) {
        return bookRepository.returnToLibrary(book);
    }
}
