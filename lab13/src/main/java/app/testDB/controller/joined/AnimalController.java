package app.testDB.controller.joined;

import app.testDB.controller.Controller;
import app.testDB.domain.joined.Animal;
import app.testDB.logger.Loggers;
import app.testDB.repository.Repository;
import app.testDB.resources.joined.AnimalResource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/animal")
public final class AnimalController implements Controller<AnimalResource> {

    private static final Logger logger = Loggers.logger(AnimalController.class);

    private final Repository<Animal> repository;

    public AnimalController(@Qualifier("animalRepository") Repository<Animal> repository) {
        this.repository = repository;
    }

    @Override
    @PostMapping("/save")
    public void post(@RequestBody AnimalResource animal) {
        logger.log(Level.INFO, "Request to server for posting animal {0}", animal);
        if (animal != null) {
            repository.persist(animal.toEntity());
        }
    }

    @Override
    @PostMapping("/save-all")
    public void postAll(AnimalResource[] animals) {
        logger.info("Request to server for posting animals");
        if (animals != null && animals.length != 0) {
            repository.persistAll(Arrays.stream(animals).map(AnimalResource::toEntity).collect(Collectors.toList()));
        }
    }

    @Override
    @GetMapping("/get-all")
    public List<AnimalResource> getAll() {
        return repository.select().stream().map(AnimalResource::new).collect(Collectors.toList());
    }
}
