package app.testDB.repository;

import app.testDB.DBWork;
import app.testDB.domain.Player;

import javax.persistence.EntityManager;
import java.io.Closeable;
import java.util.Collection;

public class PlayerRepository implements Repository<Player>, Closeable {

    private final DBWork dbWork;

    public PlayerRepository() {
        this.dbWork = DBWork.getInstance();
    }

    @Override
    public Player find(Long id) {
        EntityManager entityManager = dbWork.getEntityManager();
        dbWork.startTransaction();
        Player player = entityManager.find(Player.class, id);
        dbWork.endTransaction(true);

        return player;
    }

    @Override
    public void persist(Player entity) {
        EntityManager entityManager = dbWork.getEntityManager();
        dbWork.startTransaction();
        entityManager.persist(entity);
        dbWork.endTransaction(true);
    }

    @Override
    public void persistAll(Collection<? extends Player> entities) {
        EntityManager entityManager = dbWork.getEntityManager();
        dbWork.startTransaction();
        for (Player player: entities) {
            entityManager.persist(player);
        }
        dbWork.endTransaction(true);
    }

    @Override
    public Player merge(Player entity) {
        EntityManager entityManager = dbWork.getEntityManager();
        dbWork.startTransaction();

        Player player = entityManager.merge(entity);
        dbWork.endTransaction(true);

        return player;
    }

    @Override
    public void remove(Player entity) {
        EntityManager entityManager = dbWork.getEntityManager();
        dbWork.startTransaction();
        Player player = entityManager.find(Player.class, entity.getId());
        entityManager.remove(player);
        dbWork.endTransaction(true);
    }

    @Override
    public void close() {
        dbWork.closeEntityManager();
    }
}
