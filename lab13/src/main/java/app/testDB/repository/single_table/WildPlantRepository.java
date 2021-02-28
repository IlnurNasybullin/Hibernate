package app.testDB.repository.single_table;

import app.testDB.domain.single_table.WildPlant;
import app.testDB.logger.Loggers;
import app.testDB.repository.AbstractRepository;
import org.springframework.stereotype.Repository;

import java.util.logging.Logger;

@Repository("wildPlantRepository")
public final class WildPlantRepository extends AbstractRepository<WildPlant> {

    private static final Logger logger = Loggers.logger(WildPlantRepository.class);

    @Override
    protected Logger logger() {
        return logger;
    }

    @Override
    protected String entityClass() {
        return "wild plant";
    }

    @Override
    protected String selectAllQuery() {
        return "SELECT w FROM Plant w WHERE dtype='wild_plant'";
    }
}
