package app.testDB.handler;

import app.testDB.config.TransactionData;
import logger.Loggers;

import java.io.IOException;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadHandler implements Runnable {

    private final TransactionHandler transactionHandler;
    private final CyclicBarrier barrier;
    private final static AtomicInteger unusefulThreads = new AtomicInteger(0);
    private final static Logger logger = Loggers.logger(ThreadHandler.class);

    public ThreadHandler(TransactionHandler transactionHandler, CyclicBarrier barrier) {
        this.transactionHandler = transactionHandler;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        logger.log(Level.INFO, "run thread {0}", threadName);

        try(transactionHandler) {
            for (TransactionData transaction : transactionHandler.getTransactions()) {
                logger.log(Level.INFO, "Waiting other threads... [{0}]", threadName);
                barrier.await();
                logger.log(Level.INFO, "process transaction... [{0}]", threadName);
                transactionHandler.processTransaction(transaction);
                logger.log(Level.INFO, "transaction is processed [{0}]", threadName);
            }

            unusefulThreads.incrementAndGet();
            logger.log(Level.INFO, "All transactions are processed, waiting other threads [{0}]", threadName);

            do {
                barrier.await();
            } while (unusefulThreads.get() != barrier.getParties());

            logger.log(Level.INFO, "All threads done... [{0}]", threadName);
        } catch (InterruptedException | BrokenBarrierException | IOException | RuntimeException e) {
            unusefulThreads.incrementAndGet();
            e.printStackTrace();
        }
    }
}
