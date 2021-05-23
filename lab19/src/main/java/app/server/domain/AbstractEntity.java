package app.server.domain;

import java.util.Objects;

public abstract class AbstractEntity<ID> {

    public abstract ID getId();
    public abstract void setId(ID id);

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || obj.getClass() != getClass()) return false;
        AbstractEntity<?> that = (AbstractEntity<?>) obj;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
