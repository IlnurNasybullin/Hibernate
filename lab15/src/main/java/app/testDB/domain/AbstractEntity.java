package app.testDB.domain;

import javax.persistence.MappedSuperclass;
import java.util.Objects;

@MappedSuperclass
public abstract class AbstractEntity implements Entity {

    public abstract Long getId();
    public abstract void setId(Long id);

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || obj.getClass() != getClass()) return false;
        AbstractEntity that = (AbstractEntity) obj;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(AbstractEntity.class, getId());
    }
}
