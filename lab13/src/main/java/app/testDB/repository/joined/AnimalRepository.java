package app.testDB.repository.joined;


import app.testDB.domain.joined.Animal;
import app.testDB.logger.Loggers;
import app.testDB.repository.AbstractRepository;
import org.springframework.stereotype.Repository;

import java.util.logging.Logger;

@Repository("animalRepository")
public final class AnimalRepository extends AbstractRepository<Animal> {

    private static final Logger logger = Loggers.logger(AnimalRepository.class);

    @Override
    protected Logger logger() {
        return logger;
    }

    @Override
    protected String entityClass() {
        return "animal";
    }

    @Override
    protected String selectAllQuery() {
        return "SELECT a FROM Animal a";
    }
}
