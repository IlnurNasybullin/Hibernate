package app.testDB.controller.single_table;

import app.testDB.controller.Controller;
import app.testDB.domain.single_table.Plant;
import app.testDB.logger.Loggers;
import app.testDB.repository.Repository;
import app.testDB.resources.single_table.PlantResource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/plant")
public final class PlantController implements Controller<PlantResource> {

    private static final Logger logger = Loggers.logger(PlantController.class);

    private final Repository<Plant> repository;

    public PlantController(@Qualifier("plantRepository") Repository<Plant> repository) {
        this.repository = repository;
    }

    @Override
    @PostMapping("/save")
    public void post(@RequestBody PlantResource plant) {
        logger.log(Level.INFO, "Request to server for posting plant {0}", plant);
        if (plant != null) {
            repository.persist(plant.toEntity());
        }
    }

    @Override
    @PostMapping("/save-all")
    public void postAll(@RequestBody PlantResource[] resource) {
        logger.info("Request to server for posting plants");
        if (resource != null && resource.length != 0) {
            repository.persistAll(Arrays.stream(resource).map(PlantResource::toEntity).collect(Collectors.toList()));
        }
    }

    @Override
    @GetMapping("/get-all")
    @ResponseBody
    public List<PlantResource> getAll() {
        logger.info("Request to server for getting all plants");
        return repository.select().stream().map(PlantResource::new).collect(Collectors.toList());
    }
}
