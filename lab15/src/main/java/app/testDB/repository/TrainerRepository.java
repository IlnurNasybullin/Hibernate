package app.testDB.repository;

import app.testDB.domain.Trainer;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainerRepository extends UpdateRepository<Trainer, Long> {
    Trainer saveAndFlush(Trainer trainer);
}
