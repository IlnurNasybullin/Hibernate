package app.testDB.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface UpdateRepository<T, ID> extends CrudRepository<T, ID> {
    T saveAndFlush(T entity);
}
