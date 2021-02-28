package app.testDB.controller.single_table;

import app.testDB.controller.Controller;
import app.testDB.domain.single_table.HomePlant;
import app.testDB.logger.Loggers;
import app.testDB.repository.Repository;
import app.testDB.resources.single_table.HomePlantResource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/home-plant")
public final class HomePlantController implements Controller<HomePlantResource> {

    private static final Logger logger = Loggers.logger(HomePlantController.class);

    private final Repository<HomePlant> repository;

    public HomePlantController(@Qualifier("homePlantRepository") Repository<HomePlant> repository) {
        this.repository = repository;
    }

    @Override
    @PostMapping("/save")
    public void post(@RequestBody HomePlantResource homePlant) {
        logger.log(Level.INFO, "Request to server for posting home plant {0}", homePlant);
        if (homePlant != null) {
            repository.persist(homePlant.toEntity());
        }
    }

    @Override
    @PostMapping("/save-all")
    public void postAll(@RequestBody HomePlantResource[] homePlants) {
        logger.info("Request to server for posting home plants");
        if (homePlants != null && homePlants.length != 0) {
            repository.persistAll(Arrays.stream(homePlants).map(HomePlantResource::toEntity).collect(Collectors.toList()));
        }
    }

    @Override
    @GetMapping("/get-all")
    @ResponseBody
    public List<HomePlantResource> getAll() {
        logger.info("Request to server for getting all home plants");
        return repository.select().stream().map(HomePlantResource::new).collect(Collectors.toList());
    }
}
