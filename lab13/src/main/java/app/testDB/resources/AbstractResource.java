package app.testDB.resources;

import app.testDB.domain.AbstractEntry;

import java.util.Objects;

public abstract class AbstractResource<T extends AbstractEntry> implements Resource<T> {

    protected Long id;

    protected AbstractResource() { }

    protected AbstractResource(T entry) {
        this.id = entry.getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractResource<?> that = (AbstractResource<?>) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "AbstractResource{" + "id=" + id +
                '}';
    }
}
