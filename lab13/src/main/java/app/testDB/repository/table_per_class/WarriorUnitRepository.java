package app.testDB.repository.table_per_class;

import app.testDB.domain.table_per_class.WarriorUnit;
import app.testDB.logger.Loggers;
import app.testDB.repository.AbstractRepository;
import org.springframework.stereotype.Repository;

import java.util.logging.Logger;

@Repository("warriorUnitRepository")
public final class WarriorUnitRepository extends AbstractRepository<WarriorUnit> {

    private static final Logger logger = Loggers.logger(WarriorUnitRepository.class);

    @Override
    protected Logger logger() {
        return logger;
    }

    @Override
    protected String entityClass() {
        return "warrior unit";
    }

    @Override
    protected String selectAllQuery() {
        return "SELECT w FROM warrior_unit w";
    }
}
