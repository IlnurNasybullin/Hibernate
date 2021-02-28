package app.testDB.controller.mapperSuperclass;

import app.testDB.controller.Controller;
import app.testDB.domain.mappedSuperclass.Client;
import app.testDB.logger.Loggers;
import app.testDB.repository.Repository;
import app.testDB.resources.mappedSuperclass.ClientResource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/client")
public final class ClientController implements Controller<ClientResource> {

    private final static Logger logger = Loggers.logger(ClientController.class);

    private final Repository<Client> repository;

    public ClientController(@Qualifier("clientRepository") Repository<Client> repository) {
        this.repository = repository;
    }

    @Override
    @PostMapping("/save")
    public void post(@RequestBody ClientResource client) {
        logger.log(Level.INFO, "Request to server for posting client {1}", client);
        if (client != null) {
            repository.persist(client.toEntity());
        }
    }

    @Override
    @PostMapping("/save-all")
    public void postAll(@RequestBody ClientResource[] clients) {
        logger.log(Level.INFO, "Request to server for posting clients");
        if (clients != null && clients.length != 0) {
            repository.persistAll(Arrays.stream(clients).map(ClientResource::toEntity).collect(Collectors.toList()));
        }
    }

    @Override
    @GetMapping("/get-all")
    @ResponseBody
    public List<ClientResource> getAll() {
        logger.info("Request to server for getting all clients");
        return repository.select().stream().map(ClientResource::new).collect(Collectors.toList());
    }
}
