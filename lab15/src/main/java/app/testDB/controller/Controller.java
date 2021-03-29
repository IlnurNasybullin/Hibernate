package app.testDB.controller;

import app.testDB.domain.Entity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.transaction.Transactional;

public interface Controller<T extends Entity> {

    @ResponseBody
    @Transactional
    T findById(@RequestParam Long id);

    @ResponseBody
    @Transactional
    T persist(@RequestBody T entity);

    @ResponseBody
    @Transactional
    T merge(@RequestBody T entity);

    @ResponseBody
    @Transactional
    T remove(@RequestBody T entity);
}
