package Prof38Homework_06_07_2023.repository;

import Prof38Homework_06_07_2023.model.Reader;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ReaderRepositoryImpl implements ReaderRepository {

    private Map<String, Reader> cardIndexOfReader = new HashMap<>();

    @PostConstruct
    private void init() {
        Reader reader1 = new Reader("Reader001", "12345", "Alex", "Alexeev", 30);
        Reader reader2 = new Reader("Reader002", "12346", "Alexej", "Alexov", 30);
        Reader reader3 = new Reader("Reader003", "12347", "Alexandr", "Alexiev", 30);
        cardIndexOfReader.put(reader1.getLogin(), reader1);
        cardIndexOfReader.put(reader2.getLogin(), reader2);
        cardIndexOfReader.put(reader3.getLogin(), reader3);
    }

    @Override
    public List<Reader> getAll() {
        return new ArrayList<>(cardIndexOfReader.values());
    }

    @Override
    public Reader findOne(String login) {
        return cardIndexOfReader.get(login);
    }

    @Override
    public List<Reader> create(Reader reader) {
        cardIndexOfReader.put(reader.getLogin(), reader);
        return new ArrayList<>(cardIndexOfReader.values());
    }
}
