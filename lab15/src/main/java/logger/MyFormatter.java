package logger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class MyFormatter extends Formatter {

    private final Map<Level, Color> colorMap;

    public enum Color {
        RESET("\u001B[0m"),
        BLACK("\u001B[30m"),
        RED("\u001B[31m"),
        GREEN("\u001B[32m"),
        YELLOW("\u001B[33m"),
        BLUE("\u001B[34m"),
        PURPLE("\u001B[35m"),
        CYAN("\u001B[36m"),
        WHITE("\u001B[37m");

        Color(String ANSI) {
            this.ANSI = ANSI;
        }

        String ANSI;
    }

    public MyFormatter() {
        this(getDefaultColorMap());
    }

    private static Map<Level, Color> getDefaultColorMap() {
        Map<Level, Color> colorMap = new HashMap<>(7);

        colorMap.put(Level.SEVERE, Color.RED);
        colorMap.put(Level.WARNING, Color.YELLOW);
        colorMap.put(Level.INFO, Color.BLUE);
        colorMap.put(Level.CONFIG, Color.CYAN);
        colorMap.put(Level.FINE, Color.GREEN);
        colorMap.put(Level.FINER, Color.GREEN);
        colorMap.put(Level.FINEST, Color.GREEN);

        return colorMap;
    }

    public MyFormatter(Map<Level, Color> colorMap) {
        this.colorMap = colorMap;
    }

    @Override
    public String format(LogRecord record) {
        Level level = record.getLevel();
        Color color = colorMap.getOrDefault(level, Color.BLACK);

        return color.ANSI +
                "[" +
                calcDate(record.getMillis()) +
                "]" +
                " [" +
                record.getSourceClassName() +
                "]" +
                " [" +
                level.getName() +
                "]" +
                color.ANSI +
                " - " +
                formatMessage(record) +
                color.ANSI +
                "\n";
    }

    private String calcDate(long ms) {
        SimpleDateFormat date_format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date resultDate = new Date(ms);
        return date_format.format(resultDate);
    }
}
