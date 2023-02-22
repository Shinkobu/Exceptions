package Sem3HW;

/*Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке,
        разделенные пробелом:

        Фамилия Имя Отчество дата рождения номер телефона пол
        Форматы данных:
        фамилия, имя, отчество - строки
        дата_рождения - строка формата dd.mm.yyyy
        номер_телефона - целое беззнаковое число без форматирования
        пол - символ латиницей f или m.

        Приложение должно проверить введенные данные по количеству. Если количество не совпадает с требуемым,
        вернуть код ошибки, обработать его и показать пользователю сообщение,
        что он ввел меньше и больше данных, чем требуется.
        Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры.
        Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы.
        Можно использовать встроенные типы java и создать свои. Исключение должно быть корректно обработано,
        пользователю выведено сообщение с информацией, что именно неверно.

        Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии,
        в него в одну строку должны записаться полученные данные, вида
<Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>

Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
        Не забудьте закрыть соединение с файлом.
        При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано,
        пользователь должен увидеть стектрейс ошибки.
        */


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class App {

    public static void main(String[] args) {
        System.out.println("Введите данные через пробел в произвольном порядке:\n" +
                "Фамилия, Имя, Отчество\n" +
                "дата рождения в формате dd.mm.yyyy\n" +
                "номер телефона - только цифры без пробелов\n" +
                "пол - символ латиницей f или m\n");
//        Scanner myScan = new Scanner(System.in);
//        String k = myScan.nextLine();
//                while (k.equals("")){
//                    System.out.println("Ошибка! Введено пустое значение. Повторите ввод");
//                    k = myScan.nextLine();
//                }
        ArrayList<String> inputData = new ArrayList<>();
        inputData.add("Кузнецов Олег Николаевич 24.05.1986 89211391441 f"); // правильный ввод
        inputData.add("24.05.1986 Кузнецов Олег Николаевич f 89211391441 "); // правильный ввод
//        inputData.add("Кузнецов Николаевич 24.05.1986 Олег 89211391441 f"); // неправильный порядок фио
//        inputData.add("К123нецов О николаевич 24.05.1986 89211391441 f"); // фио некорректное
        inputData.add("Кузнецов Олег Николаевич 24.0dd5.1986 89211391441 f"); // ошибка в дате
//        inputData.add("Кузнецов Олег Николаевич 24.05.1986 89211391441 f, 224485, Голенищев"); // лишние данные
        inputData.add("24.05.1986 89211391441 f"); // нет одного из полей
        inputData.add("Кузнецов Олег Николаевич 89211391441 f"); // нет одного из полей
        inputData.add("Кузнецов Олег Николаевич 24.05.1986 f"); // нет одного из полей
        inputData.add("Кузнецов Олег Николаевич 24.05.1986 89211391441"); // нет одного из полей

        for (int i = 0; i < inputData.size(); i++) {
            String[] dataArray;
            dataArray = inputData.get(i).split(" ");
            System.out.println(Arrays.toString(dataArray));
//            Проверка по количеству введённых данных
            if (dataArray.length != 6){
                throw new RuntimeException("Ошибка по количеству введённых данных");
            }

            String [] tempName = LookForName(dataArray);
            LookForDate(dataArray);
//            LookForTel(dataArray);
//            LookForGender(dataArray);

            ArrayList<String> resultData = new ArrayList<>();
            for (int j = 0; j <= 2; j++) {
                resultData.add(j,tempName[j]);
            }

        }
//        ArrayList<String> resultData = new ArrayList<>(Arrays.asList("Кузнецов Олег Николаевич", "24.05.1986", "89211391441", "f"));
//        String someName = "Кузнецов";
//
//        DataWriter.WriteDataToFile(someName, resultData);


    }

    public static long LookForTel(String[] dataArray) {

        for (int i = 0; i < dataArray.length; i++) {
            boolean success = false;
            try {
                Long temp = Long.parseLong(dataArray[i]);
                success = true;
                System.out.println(temp);
                return temp;
            } catch (NumberFormatException e) {
                success = false;
            }

        }
        return -1;
    }

    public static Date LookForDate(String[] dataArray) {

        for (int i = 0; i < dataArray.length; i++) {
            DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
            Date temp;
            try {
                temp = df.parse(dataArray[i]);
                System.out.println(temp);
                return temp;
            } catch (NumberFormatException | ParseException e) {
            }
        }
        throw new RuntimeException("Ошибка распознавания даты");
    }

    public static String LookForGender(String[] dataArray) {

        for (int i = 0; i < dataArray.length; i++) {
            boolean success = false;
            String temp;
            if (dataArray[i].equals("f")) {
                success = true;
                System.out.println("f");
                return "f";
            } else if (dataArray[i].equals("m")) {
                success = true;
                System.out.println("m");
                return "m";
            }
        }
        return "-1";
    }


    public static String[] LookForName(String[] dataArray) {

        /*
        1) Находим первую строку, которая проходит проверку. Считаем, что это фамилия
        2) Следующий элемент должен пройти проверку и это будет имя
        3) Следующий элемент должен пройти проверку и это будет отчество
        */

        String[] FIO = new String[3];
        int nameCounter = 0;
        for (String s : dataArray) {
            String temp = s;

            //  Проверка на условия: первая буква большая, нет цифр, букв больше 1
            if (Character.isUpperCase(temp.charAt(0)) &&
                    temp.matches("[а-яА-Я]+") &&
                    temp.toCharArray().length > 1) {
                System.out.println(s);
                FIO[nameCounter] = s;
                if (nameCounter == 2) {
                    return FIO;
                }
                nameCounter++;
            } else if (nameCounter != 0) {
                throw new RuntimeException("Ошибка ввода ФИО");
            }
        }
        throw new RuntimeException("Ошибка ввода ФИО");
    }
}
