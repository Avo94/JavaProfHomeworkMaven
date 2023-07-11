package Prof38Homework_06_07_2023.controller;

import Prof38Homework_06_07_2023.model.Book;
import Prof38Homework_06_07_2023.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// https://localhost:8080
@RestController
@RequestMapping("books") // https://localhost:8080/books
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping // https://localhost:8080/books get list all objects
    public List<Book> list() {
        return bookService.getAll();
    }

    @GetMapping("/{isbn}") // GET https://localhost:8080/books/12345
    public Book getByIsbn(@PathVariable(name = "isbn") long isbn) {
        return bookService.findOne(isbn);
    }

    @PostMapping("/return")
    public void returnBookToLibrary(@RequestBody Book book) {
        bookService.returnToLibrary(book);
    }

    @PostMapping("/borrow")
    public Book borrowBookFromLibrary(@PathVariable(name = "isbn") long isbn) {
        return bookService.borrowFromLibrary(isbn);
    }
}