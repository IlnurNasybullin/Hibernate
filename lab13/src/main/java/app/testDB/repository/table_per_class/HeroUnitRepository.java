package app.testDB.repository.table_per_class;

import app.testDB.domain.table_per_class.HeroUnit;
import app.testDB.logger.Loggers;
import app.testDB.repository.AbstractRepository;
import org.springframework.stereotype.Repository;

import java.util.logging.Logger;

@Repository("heroUnitRepository")
public final class HeroUnitRepository extends AbstractRepository<HeroUnit> {

    private static final Logger logger = Loggers.logger(HeroUnitRepository.class);

    @Override
    protected Logger logger() {
        return logger;
    }

    @Override
    protected String entityClass() {
        return "hero unit";
    }

    @Override
    protected String selectAllQuery() {
        return "SELECT h FROM hero_unit h";
    }
}
