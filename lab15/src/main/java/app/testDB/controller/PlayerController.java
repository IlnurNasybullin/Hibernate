package app.testDB.controller;

import app.testDB.domain.Player;
import app.testDB.repository.UpdateRepository;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/player")
public class PlayerController extends AbstractController<Player> implements Controller<Player> {

    public PlayerController(UpdateRepository<Player, Long> repository) {
        super(repository);
    }

    @Override
    @Transactional
    @ResponseBody
    @GetMapping("/get")
    public Player findById(@RequestParam("id") Long id) {
        return super.findById(id);
    }

    @Override
    @Transactional
    @ResponseBody
    @PostMapping("/persist")
    public Player persist(@RequestBody Player player) {
        return super.persist(player);
    }

    @Override
    @Transactional
    @ResponseBody
    @PutMapping("/merge")
    public Player merge(@RequestBody Player player) {
        return super.merge(player);
    }

    @Override
    @Transactional
    @ResponseBody
    @DeleteMapping("/remove")
    public Player remove(@RequestBody Player player) {
        return super.remove(player);
    }
}
