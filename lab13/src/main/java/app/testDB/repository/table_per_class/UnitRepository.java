package app.testDB.repository.table_per_class;

import app.testDB.domain.table_per_class.Unit;
import app.testDB.logger.Loggers;
import app.testDB.repository.AbstractRepository;
import org.springframework.stereotype.Repository;

import java.util.logging.Logger;

@Repository("unitRepository")
public final class UnitRepository extends AbstractRepository<Unit> {

    private static final Logger logger = Loggers.logger(UnitRepository.class);

    @Override
    protected Logger logger() {
        return logger;
    }

    @Override
    protected String entityClass() {
        return "unit";
    }

    @Override
    protected String selectAllQuery() {
        return "SELECT u FROM Unit u";
    }
}
