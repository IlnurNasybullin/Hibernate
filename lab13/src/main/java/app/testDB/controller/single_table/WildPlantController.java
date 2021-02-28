package app.testDB.controller.single_table;

import app.testDB.controller.Controller;
import app.testDB.domain.single_table.WildPlant;
import app.testDB.logger.Loggers;
import app.testDB.repository.Repository;
import app.testDB.resources.single_table.WildPlantResource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/wild-plant")
public final class WildPlantController implements Controller<WildPlantResource> {

    private static final Logger logger = Loggers.logger(WildPlantController.class);

    private final Repository<WildPlant> repository;

    public WildPlantController(@Qualifier("wildPlantRepository") Repository<WildPlant> repository) {
        this.repository = repository;
    }

    @Override
    @PostMapping("/save")
    public void post(@RequestBody WildPlantResource wildPlant) {
        logger.log(Level.INFO, "Request to server for posting wild plant {0}", wildPlant);
        if (wildPlant != null) {
            repository.persist(wildPlant.toEntity());
        }
    }

    @Override
    @PostMapping("/save-all")
    public void postAll(@RequestBody WildPlantResource[] wildPlants) {
        logger.info("Request to server for posting wild plants");
        if (wildPlants != null && wildPlants.length != 0) {
            repository.persistAll(Arrays.stream(wildPlants).map(WildPlantResource::toEntity).collect(Collectors.toList()));
        }
    }

    @Override
    @GetMapping("/get-all")
    @ResponseBody
    public List<WildPlantResource> getAll() {
        return repository.select().stream().map(WildPlantResource::new).collect(Collectors.toList());
    }
}
