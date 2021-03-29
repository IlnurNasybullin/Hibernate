package app.testDB.repository;

import app.testDB.domain.simple.Team;
import org.springframework.stereotype.Repository;

@Repository
public interface SimpleTeamRepository extends UpdateRepository<Team, Long> {
    Team saveAndFlush(Team team);
}
