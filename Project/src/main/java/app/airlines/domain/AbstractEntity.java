package app.airlines.domain;

import java.util.Objects;

public abstract class AbstractEntity {

    public abstract Long getId();
    public abstract void setId(Long id);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != this.getClass()) return false;

        AbstractEntity that = (AbstractEntity) o;
        return this.getId().longValue() == that.getId().longValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getClass(), getId());
    }
}
