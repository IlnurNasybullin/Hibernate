package app.testDB.config;

import app.testDB.domain.Player;

import java.util.List;

public class TransactionData {

    private Long id;
    private TransactionType type;
    private List<? extends Player> data;
    private volatile Boolean ignoreException;

    public Boolean getIgnoreException() {
        return ignoreException == null ? getDefault() : ignoreException;
    }

    private Boolean getDefault() {
        return true;
    }

    public void setIgnoreException(Boolean ignoreException) {
        this.ignoreException = ignoreException;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public List<? extends Player> getData() {
        return data;
    }

    public void setData(List<? extends Player> data) {
        this.data = data;
    }
}
