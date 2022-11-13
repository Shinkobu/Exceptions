package Seminar1;

/*  Реализуйте метод, принимающий в качестве аргумента целочисленный массив и некоторое значение.
Метод ищет в массиве заданное значение и возвращает его индекс. При этом, например:

        если длина массива меньше некоторого заданного минимума, метод возвращает -1, в качестве кода ошибки.
        если искомый элемент не найден, метод вернет -2 в качестве кода ошибки.
        если вместо массива пришел null, метод вернет -3

        придумайте свои варианты исключительных ситуаций и верните соответствующие коды ошибок.
        Напишите метод, в котором реализуйте взаимодействие с пользователем.
        То есть, этот метод запросит искомое число у пользователя, вызовет первый, обработает возвращенное значение
        и покажет читаемый результат пользователю. Например, если вернулся -2,
        пользователю выведется сообщение: “Искомый элемент не найден”.
*/

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Task2 {
    public static final int MIN_LENGTH = 3;
    public static final Integer[] myArray = {1,2,3,4};

    public static void main(String[] args) {

        run();

    }

    public static void run() {

        System.out.println("Введите искомое число");
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNextInt()) sc.next();
        int num = sc.nextInt();

        System.out.println("Искомое число: " + num);

        Integer result = checkArray(myArray, num);

        switch (result){
            case -1:
                System.out.println("Длина массива меньше " + MIN_LENGTH);
                break;
            case -2:
                System.out.println("Значение не найдено");
                break;
            case -3:
                System.out.println("Массив пустой");
                break;
            default:
                System.out.println("Найдено значение в массиве. Это элемент с индексом " + result);
                break;
        }

    }

    public static int checkArray(Integer[] myArray, int someValue) {

        if (myArray == null) {
            return -3; // массив пустой
        }

        if (myArray.length < MIN_LENGTH) {
            return -1; // длина массива меньше MIN_LENGTH
        }



        Integer result = Arrays.asList(myArray).indexOf(someValue);
        if (result != -1) {
            return result;

        }else return -2;    // значение не найдено




}
}
