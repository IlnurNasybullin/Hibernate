package app.server.domain;

import javax.persistence.*;

@Entity
public class Client extends AbstractEntity<Long> {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clientIdGenerator")
    @SequenceGenerator(name = "clientIdGenerator", sequenceName = "client_seq", allocationSize = 1)
    private Long id;

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

    public void setName(String name) {
        this.name = name;
    }
}
