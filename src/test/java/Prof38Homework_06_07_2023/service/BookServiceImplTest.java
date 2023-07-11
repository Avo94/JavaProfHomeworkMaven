package Prof38Homework_06_07_2023.service;

import Prof38Homework_06_07_2023.model.Author;
import Prof38Homework_06_07_2023.model.Book;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookServiceImplTest {

    @Autowired
    private BookService bookService;

    @Test
    void getAll() {
        assertEquals(3, bookService.getAll().size());
    }

    @Test
    void findOne() {
        Book book = bookService.findOne(12345L);
        assertNotNull(book);
        assertEquals("Harry Potter I", book.getName());
        assertEquals("Rowling", book.getAuthor().getSurname());
        assertEquals(1995, book.getYear());
    }

    @Disabled
    @Test
    void borrowFromLibrary() {
        Book book = bookService.borrowFromLibrary(12346L);
        List<Book> all = bookService.getAll();
        assertEquals(2, all.size());
    }

    @Disabled
    @Test
    void returnToLibrary() {
        Book book = new Book("Harry Potter II", 12346L,
                new Author("J", "Rowling"), 1996);
        boolean returned = bookService.returnToLibrary(book);
        Book bookFromLibrary = bookService.findOne(12346L);
        assertNotNull(bookFromLibrary);
        assertEquals("Harry Potter II", book.getName());
        assertEquals("Rowling", book.getAuthor().getSurname());
        assertEquals(1996, book.getYear());
    }
}