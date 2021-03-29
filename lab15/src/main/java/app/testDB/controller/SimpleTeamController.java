package app.testDB.controller;

import app.testDB.domain.Player;
import app.testDB.domain.Trainer;
import app.testDB.domain.simple.Team;
import app.testDB.repository.SimpleTeamRepository;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/simple-team")
public class SimpleTeamController implements Controller<Team> {

    private final SimpleTeamRepository repository;
    private final TrainerController trainerController;
    private final PlayerController playerController;

    public SimpleTeamController(SimpleTeamRepository repository, TrainerController trainerController, PlayerController playerController) {
        this.repository = repository;
        this.trainerController = trainerController;
        this.playerController = playerController;
    }

    @Override
    @ResponseBody
    @Transactional
    @GetMapping("/get")
    public Team findById(@RequestParam("id") Long id) {
        if (id == null) {
            return null;
        }
        Optional<Team> team = repository.findById(id);
        return team.orElse(null);
    }

    @ResponseBody
    @Transactional
    @PostMapping("/persist")
    public Team persist(@RequestBody Team team) {
        if (team == null) {
            return null;
        }
        if (team.getId() != null) {
            throw new IllegalArgumentException("Id isn't null!");
        }

        save(team.getTrainer());
        save(team.getPlayers());

        return repository.save(team);
    }

    private void save(List<Player> players) {
        if (players == null) {
            return;
        }
        
        for (Player player: players) {
            save(player);
        }
    }

    private void save(Player player) {
        if (player == null) {
            return;
        }

        Long id = player.getId();
        if (id == null) {
            playerController.persist(player);
        } else {
            playerController.merge(player);
        }
    }

    private void save(Trainer trainer) {
        if (trainer == null) {
            return;
        }

        Long id = trainer.getId();
        if (id == null) {
            trainerController.persist(trainer);
        } else {
            trainerController.merge(trainer);
        }
    }

    @Override
    @ResponseBody
    @Transactional
    @PutMapping("/merge")
    public Team merge(@RequestBody Team team) {
        if (team == null) {
            return null;
        }
        if (team.getId() == null) {
            throw new IllegalArgumentException("Id is null!");
        }

        save(team.getPlayers());
        save(team.getTrainer());

        return repository.saveAndFlush(team);
    }

    @Override
    @ResponseBody
    @Transactional
    @DeleteMapping("/remove")
    public Team remove(@RequestBody Team team) {
        if (team == null){
            return null;
        }

        repository.delete(team);
        return team;
    }
}
