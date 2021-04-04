package app.testDB;

import app.testDB.config.TransactionData;
import app.testDB.domain.Player;
import com.thoughtworks.xstream.XStream;

import java.nio.file.Path;
import java.util.List;

public class ThreadData {

    private String name;
    private List<TransactionData> transactions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TransactionData> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionData> transactions) {
        this.transactions = transactions;
    }

    public static List<ThreadData> get(Path path) {
        XStream stream = getConfiguredStream();
        return (List<ThreadData>) stream.fromXML(path.toFile());
    }

    private static XStream getConfiguredStream() {
        XStream stream = new XStream();
        stream.alias("thread-data", ThreadData.class);
        stream.alias("transaction", TransactionData.class);
        stream.alias("player", Player.class);
        stream.aliasField("ignore-exception", TransactionData.class, "ignoreException");

        stream.useAttributeFor(ThreadData.class, "name");
        stream.useAttributeFor(TransactionData.class, "type");
        stream.useAttributeFor(TransactionData.class, "id");
        stream.useAttributeFor(Player.class, "id");

        return stream;
    }
}
