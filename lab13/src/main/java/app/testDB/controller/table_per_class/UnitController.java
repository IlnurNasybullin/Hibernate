package app.testDB.controller.table_per_class;

import app.testDB.controller.Controller;
import app.testDB.domain.table_per_class.Unit;
import app.testDB.logger.Loggers;
import app.testDB.repository.Repository;
import app.testDB.resources.table_per_class.UnitResource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/unit")
public final class UnitController implements Controller<UnitResource> {

    private static final Logger logger = Loggers.logger(UnitController.class);

    private final Repository<Unit> repository;

    public UnitController(@Qualifier("unitRepository") Repository<Unit> repository) {
        this.repository = repository;
    }

    @Override
    @PostMapping("/save")
    public void post(@RequestBody UnitResource unit) {
        logger.log(Level.INFO, "Request to server for posting unit {0}", unit);
        if (unit != null) {
            repository.persist(unit.toEntity());
        }
    }

    @Override
    @PostMapping("/save-all")
    public void postAll(@RequestBody UnitResource[] units) {
        logger.info("Request to server for posting units");
        if (units != null && units.length != 0) {
            repository.persistAll(Arrays.stream(units).map(UnitResource::toEntity).collect(Collectors.toList()));
        }
    }

    @Override
    @GetMapping("/get-all")
    @ResponseBody
    public List<UnitResource> getAll() {
        logger.info("Request to server for getting all units");
        return repository.select().stream().map(UnitResource::new).collect(Collectors.toList());
    }
}
