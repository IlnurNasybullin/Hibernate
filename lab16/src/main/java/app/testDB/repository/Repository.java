package app.testDB.repository;

import app.testDB.domain.Entity;

import java.util.Collection;

public interface Repository<T extends Entity> {

    T find(Long id);

    void persist(T entity);
    void persistAll(Collection<? extends T> entities);

    T merge(T entity);
    void remove(T entity);

}
