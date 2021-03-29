package app.testDB.repository;

import app.testDB.domain.Player;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends UpdateRepository<Player, Long> {
    Player saveAndFlush(Player player);
}
