package app.testDB.controller;

import app.testDB.domain.AbstractEntity;
import app.testDB.repository.UpdateRepository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.transaction.Transactional;
import java.util.Optional;

public abstract class AbstractController<T extends AbstractEntity> implements Controller<T> {

    protected final UpdateRepository<T, Long> repository;

    public AbstractController(UpdateRepository<T, Long> repository) {
        this.repository = repository;
    }

    @Override
    @ResponseBody
    @Transactional
    public T findById(@RequestParam Long id) {
        if (id == null) {
            return null;
        }
        Optional<T> entity = repository.findById(id);
        return entity.orElse(null);
    }

    @Override
    @ResponseBody
    @Transactional
    public T persist(@RequestBody T entity) {
        if (entity == null) {
            return null;
        }
        if (entity.getId() != null) {
            throw new IllegalArgumentException("Id isn't null!");
        }

        return repository.save(entity);
    }

    @Override
    @ResponseBody
    @Transactional
    public T merge(@RequestBody T entity) {
        if (entity == null) {
            return null;
        }
        if (entity.getId() == null) {
            throw new IllegalArgumentException("Id is null!");
        }

        return repository.saveAndFlush(entity);
    }

    @Override
    @ResponseBody
    @Transactional
    public T remove(@RequestBody T entity) {
        if (entity == null) {
            return null;
        }

        repository.delete(entity);
        return entity;
    }
}
