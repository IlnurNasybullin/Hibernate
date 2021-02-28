package app.testDB.controller;

import app.testDB.resources.Resource;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public interface Controller<T extends Resource<?>> {

    void post(@RequestBody T resource);
    void postAll(@RequestBody T[] resources);

    @ResponseBody
    List<T> getAll();
}
