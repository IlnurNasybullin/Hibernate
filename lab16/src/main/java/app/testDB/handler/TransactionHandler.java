package app.testDB.handler;

import app.testDB.config.TransactionData;

import java.io.Closeable;
import java.util.List;

public interface TransactionHandler extends Closeable {

    void processTransaction(TransactionData transaction);

    List<? extends TransactionData> getTransactions();

}
