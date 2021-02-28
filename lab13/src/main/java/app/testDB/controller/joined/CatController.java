package app.testDB.controller.joined;

import app.testDB.controller.Controller;
import app.testDB.domain.joined.Cat;
import app.testDB.logger.Loggers;
import app.testDB.repository.Repository;
import app.testDB.resources.joined.CatResource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cat")
public final class CatController implements Controller<CatResource> {

    private static final Logger logger = Loggers.logger(CatController.class);

    private final Repository<Cat> repository;

    public CatController(@Qualifier("catRepository") Repository<Cat> repository) {
        this.repository = repository;
    }

    @Override
    @PostMapping("/save")
    public void post(@RequestBody CatResource cat) {
        logger.log(Level.INFO, "Request to server for posting cat {0}", cat);
        if (cat != null) {
            repository.persist(cat.toEntity());
        }
    }

    @Override
    @PostMapping("/save-all")
    public void postAll(@RequestBody CatResource[] cats) {
        logger.info("Request to server for posting cats");
        if (cats != null && cats.length != 0) {
            repository.persistAll(Arrays.stream(cats).map(CatResource::toEntity).collect(Collectors.toList()));
        }
    }

    @Override
    @GetMapping("/get-all")
    @ResponseBody
    public List<CatResource> getAll() {
        logger.info("Request to server for getting all cats");
        return repository.select().stream().map(CatResource::new).collect(Collectors.toList());
    }
}
