package Seminar2;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Task3 {
    public static void main(String[] args) {

        WriteDataToFile();

;
        WriteDataToFile2(readFileByLine());




//        FileReader myReader = null;
//        try {
//            myReader = new FileReader("names.txt");
//
//
//            myReader.close();
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }


    }

    // построчное считывание файла
    public static HashMap<String,Integer> readFileByLine() {
        HashMap<String,Integer> myHashMap = new HashMap<>();
        try {
            File file = new File("names.txt");
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();


            while (line != null) {
                System.out.println(line);
                Integer nameLength;

                String [] tempArr = line.split("=");
                try {
                    nameLength = Integer.parseInt(tempArr[1]);
                    myHashMap.put(tempArr[0],nameLength);
                }
                catch (NumberFormatException e){
                    System.out.println("Не обнаружено число. Запускаю метод подсчёта количества букв");
                    nameLength = tempArr[0].length();
                    System.out.println(nameLength);
                    myHashMap.put(tempArr[0],nameLength);
                }
                myHashMap.put(tempArr[0],nameLength);

                // считываем остальные строки в цикле
                line = reader.readLine();
                System.out.println(myHashMap);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return myHashMap;
    }

    public static void WriteDataToFile() {

        try {
            FileWriter myWriter = new FileWriter("names.txt");
            myWriter.write("Анна=4");
            myWriter.append("\n");
            myWriter.write("Елена=5");
            myWriter.append("\n");
            myWriter.write("Марина=6");
            myWriter.append("\n");
            myWriter.write("Владимир=?");
            myWriter.append("\n");
            myWriter.write("Константин=?");
            myWriter.append("\n");
            myWriter.write("Иван=4");
            myWriter.append("\n");
            myWriter.flush();
        } catch (IOException e) {
            System.out.println("Ошибка");
        }

    }

    public static void WriteDataToFile2 (HashMap <String,Integer> myHM)  {

        try {
            FileWriter myWriter = new FileWriter("names.txt");

            for (Map.Entry<String,Integer> entry: myHM.entrySet()) {
                myWriter.write(entry.getKey() + "=" + entry.getValue());
                myWriter.append("\n");
            }
            myWriter.flush();
        } catch (IOException e) {
            System.out.println("Ошибка");
        }

    }
}
