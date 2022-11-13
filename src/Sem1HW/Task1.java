package Sem1HW;


//1) Реализуйте 3 метода, чтобы в каждом из них получить разные исключения

public class Task1 {

    public static void main(String[] args) {

        method1();
        method2();
        method3();

    }

    public static void method1() {
        // выход за границы массива
        int [] myArray = {1,2};

        for (int i = 0; i <= myArray.length; i++) {
            System.out.println(myArray[i]);
        }
    }

    public static void method2() {
        // деление на ноль
        int a = 5;
        int b = 0;

        System.out.println(a/b);

    }

    public static void method3() {
        // сложение int и null
        int a = 5;
        Integer b = null;
        int c = a + b;
    }

}
