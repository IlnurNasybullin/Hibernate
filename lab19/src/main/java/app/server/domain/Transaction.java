package app.server.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Transaction extends AbstractEntity<Long> {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transactionIdGenerator")
    @SequenceGenerator(name = "transactionIdGenerator", sequenceName = "transaction_seq", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Account from;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Account to;

    @Column(name = "transaction_sum", nullable = false)
    private Double transactionSum;

    @ManyToOne
    @JoinColumn(name = "responsible_agent_id", nullable = false)
    private UserAgent responsibleAgent;

    @Column(name = "date_time", nullable = false)
    private LocalDateTime dateTime;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Account getFrom() {
        return from;
    }

    public void setFrom(Account from) {
        this.from = from;
    }

    public Account getTo() {
        return to;
    }

    public void setTo(Account to) {
        this.to = to;
    }

    public Double getTransactionSum() {
        return transactionSum;
    }

    public void setTransactionSum(Double transactionSum) {
        this.transactionSum = transactionSum;
    }

    public UserAgent getResponsibleAgent() {
        return responsibleAgent;
    }

    public void setResponsibleAgent(UserAgent responsibleAgent) {
        this.responsibleAgent = responsibleAgent;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
