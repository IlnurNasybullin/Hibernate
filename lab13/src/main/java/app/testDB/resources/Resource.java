package app.testDB.resources;

import app.testDB.domain.Entity;

public interface Resource<T extends Entity> {
    T toEntity();
}
