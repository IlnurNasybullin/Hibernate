package app.testDB.controller.table_per_class;

import app.testDB.controller.Controller;
import app.testDB.domain.table_per_class.HeroUnit;
import app.testDB.logger.Loggers;
import app.testDB.repository.Repository;
import app.testDB.resources.table_per_class.HeroUnitResource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/hero-unit")
public final class HeroUnitController implements Controller<HeroUnitResource> {

    private static final Logger logger = Loggers.logger(HeroUnitController.class);

    private final Repository<HeroUnit> repository;

    public HeroUnitController(@Qualifier("heroUnitRepository") Repository<HeroUnit> repository) {
        this.repository = repository;
    }

    @Override
    @PostMapping("/save")
    public void post(@RequestBody HeroUnitResource heroUnit) {
        logger.log(Level.INFO, "Request to server for posting hero unit {0}", heroUnit);
        if (heroUnit != null) {
            repository.persist(heroUnit.toEntity());
        }
    }

    @Override
    @PostMapping("/save-all")
    public void postAll(@RequestBody HeroUnitResource[] heroUnits) {
        logger.info("Request to server for posting hero units");
        if (heroUnits != null && heroUnits.length != 0) {
            repository.persistAll(Arrays.stream(heroUnits).map(HeroUnitResource::toEntity).collect(Collectors.toList()));
        }
    }

    @Override
    @GetMapping("/get-all")
    @ResponseBody
    public List<HeroUnitResource> getAll() {
        return repository.select().stream().map(HeroUnitResource::new).collect(Collectors.toList());
    }
}
