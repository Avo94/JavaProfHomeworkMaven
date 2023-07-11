package Prof38Homework_06_07_2023.service;

import Prof38Homework_06_07_2023.model.Reader;
import Prof38Homework_06_07_2023.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReaderServiceImpl implements ReaderService {

    @Autowired
    private ReaderRepository readerRepository;

    @Override
    public List<Reader> getAll() {
        return readerRepository.getAll();
    }

    @Override
    public Reader findOne(String login) {
        return readerRepository.findOne(login);
    }

    @Override
    public List<Reader> create(Reader reader) {
        return readerRepository.create(reader);
    }
}
