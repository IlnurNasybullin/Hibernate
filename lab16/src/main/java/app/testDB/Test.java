package app.testDB;

import app.testDB.handler.DBTransactionHandler;
import app.testDB.handler.ThreadHandler;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.CyclicBarrier;

public class Test {
    public static void main(String[] args) throws IOException {
        List<ThreadData> data = ThreadData.get(Path.of("./lab16/src/main/resources/threads/config.xml"));

        CyclicBarrier barrier = new CyclicBarrier(data.size());
        data.stream().map(threadData -> new Thread(new ThreadHandler
                (new DBTransactionHandler(threadData.getTransactions()), barrier), threadData.getName())).
                forEach(Thread::start);
    }
}
