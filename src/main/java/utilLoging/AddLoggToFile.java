package utilLoging;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class AddLoggToFile {

    private static final Logger ERROR_LOGGER = Logger.getLogger("errorLogger");
    private static final Logger INFO_LOGGER = Logger.getLogger("infoLogger");

    public static void main(String[] args) {
        // Настройка логгеров
        configureLoggers();

        // Пример логирования ошибки
        try {
            throw new IOException("Пример ошибки");
        } catch (IOException e) {
            // Запись сообщения об ошибке в лог
            ERROR_LOGGER.log(Level.SEVERE, "Ошибка ввода-вывода", e);
        }

        // Пример логирования информационного сообщения
        INFO_LOGGER.info("Пример информационного сообщения");
    }

    private static void configureLoggers() {
        try {
            // Создание хэндлера для записи логов в файл
            FileHandler errorFileHandler = new FileHandler("errors.log");
            FileHandler infoFileHandler = new FileHandler("info.log");

            // Форматирование записей логов
            SimpleFormatter formatter = new SimpleFormatter();
            errorFileHandler.setFormatter(formatter);
            infoFileHandler.setFormatter(formatter);

            // Установка уровней логирования
            ERROR_LOGGER.setLevel(Level.SEVERE);
            INFO_LOGGER.setLevel(Level.INFO);

            // Добавляем хэндлеры в логгеры
            ERROR_LOGGER.addHandler(errorFileHandler);
            INFO_LOGGER.addHandler(infoFileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}