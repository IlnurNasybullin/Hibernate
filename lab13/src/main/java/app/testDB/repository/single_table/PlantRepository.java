package app.testDB.repository.single_table;

import app.testDB.domain.single_table.Plant;
import app.testDB.logger.Loggers;
import app.testDB.repository.AbstractRepository;
import org.springframework.stereotype.Repository;

import java.util.logging.Logger;

@Repository("plantRepository")
public final class PlantRepository extends AbstractRepository<Plant> {

    private static final Logger logger = Loggers.logger(PlantRepository.class);

    @Override
    protected Logger logger() {
        return logger;
    }

    @Override
    protected String entityClass() {
        return "plant";
    }

    @Override
    protected String selectAllQuery() {
        return "SELECT p FROM Plant p";
    }
}
