package app.server.domain;

import javax.persistence.*;

@Entity
public class Account extends AbstractEntity<Long> {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "accountIdGenerator")
    @SequenceGenerator(name = "accountIdGenerator", sequenceName = "account_seq", allocationSize = 1)
    private Long id;

    @ManyToOne
    private Bank bank;

    @ManyToOne
    private Client client;

    private Double balance;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
