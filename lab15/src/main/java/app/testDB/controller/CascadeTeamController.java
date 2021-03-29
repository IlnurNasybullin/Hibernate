package app.testDB.controller;

import app.testDB.domain.cascade.Team;
import app.testDB.repository.UpdateRepository;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/cascade-team")
public class CascadeTeamController extends AbstractController<Team>{

    public CascadeTeamController(UpdateRepository<Team, Long> repository) {
        super(repository);
    }

    @Override
    @Transactional
    @ResponseBody
    @GetMapping("/get")
    public Team findById(@RequestParam("id") Long id) {
        return super.findById(id);
    }

    @Override
    @Transactional
    @ResponseBody
    @PostMapping("/persist")
    public Team persist(@RequestBody Team team) {
        return super.persist(team);
    }

    @Override
    @Transactional
    @ResponseBody
    @PutMapping("/merge")
    public Team merge(@RequestBody Team team) {
        return super.merge(team);
    }

    @Override
    @Transactional
    @ResponseBody
    @DeleteMapping("/remove")
    public Team remove(@RequestBody Team team) {
        return super.remove(team);
    }
}
