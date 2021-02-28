package app.testDB.repository.joined;

import app.testDB.domain.joined.Wolf;
import app.testDB.logger.Loggers;
import app.testDB.repository.AbstractRepository;
import org.springframework.stereotype.Repository;

import java.util.logging.Logger;

@Repository("wolfRepository")
public final class WolfRepository extends AbstractRepository<Wolf> {

    private static final Logger logger = Loggers.logger(Wolf.class);

    @Override
    protected Logger logger() {
        return logger;
    }

    @Override
    protected String entityClass() {
        return "wolf";
    }

    @Override
    protected String selectAllQuery() {
        return "SELECT w FROM Wolf w";
    }
}
