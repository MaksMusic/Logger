package utilLoging;

import org.apache.log4j.Logger;

import java.io.FileWriter;
import java.io.IOException;


public class Main {

    private static final Logger logManager = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {

        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter("C:\\Users\\Admin\\IdeaProjects\\Logi\\src\\main\\resources\\logi.txt");
        } catch (IOException e) {
           logManager.error("не найден файл",e);
        }

        for (int i = 0; i < 10; i++) {
            logManager.error("!@3");
        }


    }
}
