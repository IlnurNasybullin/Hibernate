package app.testDB.controller.joined;

import app.testDB.controller.Controller;
import app.testDB.domain.joined.Wolf;
import app.testDB.logger.Loggers;
import app.testDB.repository.Repository;
import app.testDB.resources.joined.WolfResource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/wolf")
public final class WolfController implements Controller<WolfResource> {

    private static final Logger logger = Loggers.logger(WolfController.class);

    private final Repository<Wolf> repository;

    public WolfController(@Qualifier("wolfRepository") Repository<Wolf> repository) {
        this.repository = repository;
    }

    @Override
    @PostMapping("/save")
    public void post(@RequestBody WolfResource wolf) {
        logger.log(Level.INFO, "Request to server for posting wolf {0}", wolf);
        if (wolf != null) {
            repository.persist(wolf.toEntity());
        }
    }

    @Override
    @PostMapping("/save-all")
    public void postAll(@RequestBody WolfResource[] wolfs) {
        logger.info("Request to server for posting wolfs");
        if (wolfs != null && wolfs.length != 0) {
            repository.persistAll(Arrays.stream(wolfs).map(WolfResource::toEntity).collect(Collectors.toList()));
        }
    }

    @Override
    @GetMapping("/get-all")
    @ResponseBody
    public List<WolfResource> getAll() {
        logger.info("Request to server for getting all wolfs");
        return repository.select().stream().map(WolfResource::new).collect(Collectors.toList());
    }
}
