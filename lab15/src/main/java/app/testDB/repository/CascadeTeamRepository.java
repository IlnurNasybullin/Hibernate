package app.testDB.repository;

import app.testDB.domain.cascade.Team;
import org.springframework.stereotype.Repository;

@Repository
public interface CascadeTeamRepository extends UpdateRepository<Team, Long> {
    Team saveAndFlush(Team team);
}
