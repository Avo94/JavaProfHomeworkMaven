package Prof38Homework_06_07_2023.service;

import Prof38Homework_06_07_2023.model.Reader;

import java.util.List;

public interface ReaderService {

    List<Reader> getAll();

    Reader findOne(String login);

    List<Reader> create(Reader reader);

}
