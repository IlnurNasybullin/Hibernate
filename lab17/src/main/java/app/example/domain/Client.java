package app.example.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client")
    @SequenceGenerator(name = "client", sequenceName = "client_seq", allocationSize=1)
    private Long id;

    @Version
    protected long version;

    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    private Bank bank;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.REFRESH, CascadeType.REMOVE, CascadeType.DETACH, CascadeType.ALL})

    private PersonInfo personInfo;

    @ManyToMany
    private Map<String, BankAccount> accounts;

    @ManyToMany
    @JoinTable(name = "addressofclient")
    private List<Address> addresses;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public PersonInfo getPersonInfo() {
        return personInfo;
    }

    public void setPersonInfo(PersonInfo personInfo) {
        this.personInfo = personInfo;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public Map<String, BankAccount> getAccounts() {
        return accounts;
    }

    public void setAccounts(Map<String, BankAccount> accounts) {
        this.accounts = accounts;
    }

    public long getVersion() {
        return version;
    }
}
