package utilLoging;
import java.io.IOException;
import java.util.logging.*;

public class AddingLoggDifferentToFile {
    private static final Logger ERROR_LOGGER = ErrorLoggerInitializer.getLogger();
    private static final Logger INFO_LOGGER = InfoLoggerInitializer.getLogger();

    public static void main(String[] args) {
        ErrorLoggerInitializer.initializeLogger();
        InfoLoggerInitializer.initializeLogger();

        ERROR_LOGGER.severe("Пример сообщения об ошибке");
        INFO_LOGGER.info("Пример информационного сообщения");

        WorkerClass worker = new WorkerClass();
        worker.performWork();
    }
}

class ErrorLoggerInitializer {
    private static final Logger ERROR_LOGGER = Logger.getLogger("errorLogger");

    public static void initializeLogger()  {
        ERROR_LOGGER.setLevel(Level.SEVERE);
        FileHandler fileHandlerErr = null;
        try {
            fileHandlerErr = new FileHandler("ErrorLogger.log");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SimpleFormatter simpleFormatter = new SimpleFormatter();
        //fileHandlerErr.setLevel(Level.SEVERE);

        fileHandlerErr.setFormatter(simpleFormatter);
        ERROR_LOGGER.addHandler(fileHandlerErr);

    }

    public static Logger getLogger() {
        return ERROR_LOGGER;
    }
}


class InfoLoggerInitializer {
    private static final Logger INFO_LOGGER = Logger.getLogger("infoLogger");

    public static void initializeLogger() {
        INFO_LOGGER.setLevel(Level.INFO);

        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.INFO);

        INFO_LOGGER.addHandler(consoleHandler);
    }

    public static Logger getLogger() {
        return INFO_LOGGER;
    }
}

class WorkerClass {
    private static final Logger ERROR_LOGGER = ErrorLoggerInitializer.getLogger();
    private static final Logger INFO_LOGGER = InfoLoggerInitializer.getLogger();

    public void performWork() {
        INFO_LOGGER.info("Выполняется работа");

        HelperClass helper = new HelperClass();
        helper.performAction();

        // Генерирование ошибки для примера
        try {
            int result = 10 / 0;
        } catch (Exception e) {
            ERROR_LOGGER.log(Level.SEVERE, "Ошибка во время работы", e);
        }
    }
}

class HelperClass {
    private static final Logger INFO_LOGGER = InfoLoggerInitializer.getLogger();

    public void performAction() {
        INFO_LOGGER.info("Выполняется действие performAction");
    }
}
