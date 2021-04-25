package app.testDB.handler;

import app.testDB.config.TransactionData;
import app.testDB.domain.Player;
import app.testDB.repository.PlayerRepository;
import logger.Loggers;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBTransactionHandler implements TransactionHandler {

    private final List<TransactionData> transactions;
    private final PlayerRepository repository;

    private final static Logger logger = Loggers.logger(DBTransactionHandler.class);

    public DBTransactionHandler(List<TransactionData> transactions) {
        this.transactions = transactions;
        this.repository = new PlayerRepository();
    }

    @Override
    public void processTransaction(TransactionData transaction) {
        try {
            Long id = transaction.getId();
            logger.log(Level.INFO, "process transaction with id {0}", id);
            switch (transaction.getType()) {
                case PERSIST -> {
                    repository.persistAll(transaction.getData());
                    logger.log(Level.INFO, "transaction data with id {0} is persisted", id);
                }
                case MERGE -> {
                    for (Player player : transaction.getData()) {
                        repository.merge(player);
                    }
                    logger.log(Level.INFO, "transaction data with id {0} is merged", id);
                }
                case REMOVE -> {
                    for (Player player : transaction.getData()) {
                        repository.remove(player);
                    }
                    logger.log(Level.INFO, "transaction data with id {0} is removed", id);
                }
                default -> throw new UnsupportedOperationException("Unsupported transaction type! (id = " + id + ")");
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (!transaction.getIgnoreException()) {
                System.err.println("not-ignore");
                throw new RuntimeException(e);
            } else {
                System.err.println("ignore");
            }
        }
    }

    @Override
    public List<? extends TransactionData> getTransactions() {
        return transactions;
    }

    @Override
    public void close() {
        logger.log(Level.INFO, "transaction handler is closing");
        repository.close();
    }
}
