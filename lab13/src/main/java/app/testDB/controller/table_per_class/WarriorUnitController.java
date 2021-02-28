package app.testDB.controller.table_per_class;

import app.testDB.controller.Controller;
import app.testDB.domain.table_per_class.WarriorUnit;
import app.testDB.logger.Loggers;
import app.testDB.repository.Repository;
import app.testDB.resources.table_per_class.WarriorUnitResource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/warrior-unit")
public final class WarriorUnitController implements Controller<WarriorUnitResource> {

    private final static Logger logger = Loggers.logger(WarriorUnitController.class);

    private final Repository<WarriorUnit> repository;

    public WarriorUnitController(@Qualifier("warriorUnitRepository") Repository<WarriorUnit> repository) {
        this.repository = repository;
    }

    @Override
    @PostMapping("/save")
    public void post(@RequestBody WarriorUnitResource warriorUnit) {
        logger.log(Level.INFO, "Request to server for posting warrior unit {0}", warriorUnit);
        if (warriorUnit != null) {
            repository.persist(warriorUnit.toEntity());
        }
    }

    @Override
    @PostMapping("/save-all")
    public void postAll(@RequestBody WarriorUnitResource[] warriorsUnits) {
        logger.info("Request to server for posting warrior units");
        if (warriorsUnits != null && warriorsUnits.length != 0) {
            repository.persistAll(Arrays.stream(warriorsUnits).map(WarriorUnitResource::toEntity).collect(Collectors.toList()));
        }
    }

    @Override
    @GetMapping("/get-all")
    @ResponseBody
    public List<WarriorUnitResource> getAll() {
        return repository.select().stream().map(WarriorUnitResource::new).collect(Collectors.toList());
    }
}
