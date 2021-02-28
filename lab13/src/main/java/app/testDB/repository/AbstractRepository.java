package app.testDB.repository;

import app.testDB.domain.Entity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractRepository<T extends Entity> implements Repository<T> {

    @PersistenceContext
    protected EntityManager manager;

    @Override
    @Transactional
    public List<T> select() {
        logger().log(Level.INFO, "Request to database for selecting all {0}", entityClass());
        return manager.createQuery(selectAllQuery()).getResultList();
    }

    @Override
    @Transactional
    public void persist(T entity) {
        logger().log(Level.INFO, "Request to database for persisting {0} {1}", new Object[]{entityClass(), entity});
        manager.persist(entity);
    }

    @Override
    @Transactional
    public void persistAll(Collection<? extends T> entities) {
        for (T entity: entities) {
            persist(entity);
        }
    }

    protected abstract Logger logger();

    protected abstract String entityClass();

    protected abstract String selectAllQuery();
}
