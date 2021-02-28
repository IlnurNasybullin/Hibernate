package app.testDB.domain;

import java.util.Objects;

public abstract class AbstractEntry implements Entity {

    public abstract Long getId();
    public abstract void setId(Long id);

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        AbstractEntry that = (AbstractEntry) obj;

        return Objects.equals(getId(), that.getId());
    }
}
