package Sem2HW;

// Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
// Пользователю должно показаться сообщение, что пустые строки вводить нельзя.

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        System.out.println("Введите значение");
        Scanner myScanner = new Scanner(System.in);
        String k = myScanner.nextLine();
        if (k.equals("")){
            throw new RuntimeException("Введена пустая строка. Пустые строки вводить нельзя");
        }else {
            System.out.println(k);
        }

    }
}
