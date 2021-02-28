package app.testDB.repository.joined;

import app.testDB.domain.joined.Cat;
import app.testDB.logger.Loggers;

import java.util.logging.Logger;

import app.testDB.repository.AbstractRepository;
import org.springframework.stereotype.Repository;

@Repository("catRepository")
public final class CatRepository extends AbstractRepository<Cat> {

    private static final Logger logger = Loggers.logger(CatRepository.class);

    @Override
    protected Logger logger() {
        return logger;
    }

    @Override
    protected String entityClass() {
        return "cat";
    }

    @Override
    protected String selectAllQuery() {
        return "SELECT c FROM Cat c";
    }
}
