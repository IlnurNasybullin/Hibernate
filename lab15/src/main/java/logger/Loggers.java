package logger;

import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;

public class Loggers {

    public static Logger logger(Class<?> loggerClass) {
        Logger logger = Logger.getLogger(loggerClass.getName());

        ConsoleHandler handler = new ConsoleHandler();
        handler.setFormatter(new MyFormatter());
        logger.setUseParentHandlers(false);
        logger.addHandler(handler);

        return logger;
    }

}
