package app.airlines.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractDictionary extends AbstractEntity implements BiDictionary {

    @Id
    @Column
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }
}
