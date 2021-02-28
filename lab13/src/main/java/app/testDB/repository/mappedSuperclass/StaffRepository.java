package app.testDB.repository.mappedSuperclass;

import app.testDB.domain.mappedSuperclass.Staff;
import app.testDB.logger.Loggers;
import app.testDB.repository.AbstractRepository;
import org.springframework.stereotype.Repository;

import java.util.logging.Logger;

@Repository("staffRepository")
public final class StaffRepository extends AbstractRepository<Staff> {

    private static final Logger logger = Loggers.logger(StaffRepository.class);

    @Override
    protected Logger logger() {
        return logger;
    }

    @Override
    protected String entityClass() {
        return "staff";
    }

    @Override
    protected String selectAllQuery() {
        return "SELECT s FROM Staff s";
    }
}
