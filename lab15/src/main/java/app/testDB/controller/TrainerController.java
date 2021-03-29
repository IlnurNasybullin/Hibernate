package app.testDB.controller;

import app.testDB.domain.Trainer;
import app.testDB.repository.UpdateRepository;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/trainer")
public class TrainerController extends AbstractController<Trainer> {

    public TrainerController(UpdateRepository<Trainer, Long> repository) {
        super(repository);
    }

    @Override
    @ResponseBody
    @Transactional
    @GetMapping("/get")
    public Trainer findById(@RequestParam Long id) {
        return super.findById(id);
    }

    @Override
    @ResponseBody
    @Transactional
    @PostMapping("/persist")
    public Trainer persist(@RequestBody Trainer trainer) {
        return super.persist(trainer);
    }

    @Override
    @ResponseBody
    @Transactional
    @PutMapping("/merge")
    public Trainer merge(@RequestBody Trainer trainer) {
        return super.merge(trainer);
    }

    @Override
    @ResponseBody
    @Transactional
    @DeleteMapping("/remove")
    public Trainer remove(@RequestBody Trainer trainer) {
        return super.remove(trainer);
    }
}
