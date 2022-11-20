package Sem2HW;

// Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
//        и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения,
//        вместо этого, необходимо повторно запросить у пользователя ввод данных.

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {

        System.out.println("Введите дробное число\n");
        checkFloat();
    }

    public static void checkFloat (){
        Scanner myScanner = new Scanner(System.in);
        String s = myScanner.next();
        try {
            float f  = Float.parseFloat(s);
            System.out.println("Введено число: " + f);
        }catch (InputMismatchException | NumberFormatException e){
            System.out.println("Ошибка ввода!");
            System.out.println("Введите дробное число\n");
            checkFloat();
        }finally {
            myScanner.close();
        }


    }

}
