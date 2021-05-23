package app.server.service;

import app.server.domain.Language;
import app.server.repository.TestRepository;
import app.server.utils.TranslateData;
import app.server.utils.TranslateQueryData;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TestService {

    private final TestRepository repository;

    public TestService(TestRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public List<TranslateData> getTranslateData(TranslateQueryData data) {
        return repository.getTranslateData(data.getFrom(), data.getTo());
    }

    @Transactional
    public Language updateLanguage(Integer id, Language language) {
        repository.updateLanguage(id, language.getName(), language.getAlphabet());
        return repository.findById(id).orElse(null);
    }

    @Transactional
    public void deleteLanguageByName(String name) {
        repository.deleteByName(name);
    }
}
