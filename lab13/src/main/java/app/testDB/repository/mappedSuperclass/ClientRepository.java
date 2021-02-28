package app.testDB.repository.mappedSuperclass;

import app.testDB.domain.mappedSuperclass.Client;
import app.testDB.logger.Loggers;
import app.testDB.repository.AbstractRepository;
import org.springframework.stereotype.Repository;

import java.util.logging.Logger;

@Repository("clientRepository")
public final class ClientRepository extends AbstractRepository<Client> {

    private static final Logger logger = Loggers.logger(ClientRepository.class);

    @Override
    protected Logger logger() {
        return logger;
    }

    @Override
    protected String entityClass() {
        return "client";
    }

    @Override
    protected String selectAllQuery() {
        return "SELECT c FROM Client c";
    }
}
