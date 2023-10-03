package logi;

import java.util.logging.*;
import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;

public class CreateLogger {
   static Logger loggerInfo = Logger.getLogger(CreateLogger.class.getName());
    public static void main(String[] args) {

        //назначение логера
        loggerInfo.setLevel(Level.INFO);

        //handler для вывода логов в консоль
        //добавляем его в логер
        ConsoleHandler consoleHandler = new ConsoleHandler();
        loggerInfo.addHandler(consoleHandler);

        //для Hendler нужен SimpleFormatter чтоб знать в каком формате выводить логи
        SimpleFormatter sp = new SimpleFormatter();
        consoleHandler.setFormatter(sp);

 //         или
//        XMLFormatter xmlFormatter = new XMLFormatter();
//        consoleHandler.setFormatter(xmlFormatter);


        //добавление записи в лог
        //loggerInfo.log(Level.INFO,"логер хендлер и симпл форматер созданны");

        //или через метод
        loggerInfo.info("логер хендлер и симпл форматер созданны");

    }
}
