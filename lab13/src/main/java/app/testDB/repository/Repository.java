package app.testDB.repository;

import app.testDB.domain.Entity;

import java.util.Collection;
import java.util.List;

public interface Repository<T extends Entity> {
    List<T> select();

    void persist(T entity);
    void persistAll(Collection<? extends T> entities);
}
