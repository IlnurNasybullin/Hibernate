package app.testDB.repository.single_table;

import app.testDB.domain.single_table.HomePlant;
import app.testDB.logger.Loggers;
import app.testDB.repository.AbstractRepository;
import org.springframework.stereotype.Repository;

import java.util.logging.Logger;

@Repository("homePlantRepository")
public final class HomePlantRepository extends AbstractRepository<HomePlant> {

    private static final Logger logger = Loggers.logger(HomePlantRepository.class);

    @Override
    protected Logger logger() {
        return logger;
    }

    @Override
    protected String entityClass() {
        return "home plant";
    }

    @Override
    protected String selectAllQuery() {
        return "SELECT h FROM Plant h WHERE dtype='home_plant'";
    }
}
