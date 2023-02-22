package Sem3HW;

import java.io.*;
import java.io.IOException;
import java.util.ArrayList;

public class DataWriter {

    public static void WriteDataToFile(String surname, ArrayList<String> data) {

        try (FileWriter myWriter = new FileWriter(surname + ".txt", true))
            {
                for (int i = 0; i < data.size(); i++) {
                    myWriter.append("<" + data.get(i) + ">");
                }
            myWriter.append("\n");
        } catch (IOException e) {
            System.out.println("Ошибка");
        }

    }

}
