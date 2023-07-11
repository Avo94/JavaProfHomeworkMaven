package Prof38Homework_06_07_2023.controller;

import Prof38Homework_06_07_2023.model.Reader;
import Prof38Homework_06_07_2023.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/readers")
public class ReaderController {

    @Autowired
    private ReaderService readerService;

    @GetMapping
    public List<Reader> getAll() {
        return readerService.getAll();
    }

    @GetMapping("/{login}")
    public Reader getByLogin(@PathVariable(name = "login") String login) {
        return readerService.findOne(login);
    }

    @PostMapping("/create")
    public List<Reader> create(@RequestBody Reader reader) {
        return readerService.create(reader);
    }
}