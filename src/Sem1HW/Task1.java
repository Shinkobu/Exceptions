package Sem1HW;


//1) ���������� 3 ������, ����� � ������ �� ��� �������� ������ ����������

public class Task1 {

    public static void main(String[] args) {

        method1();
        method2();
        method3();

    }

    public static void method1() {
        // ����� �� ������� �������
        int [] myArray = {1,2};

        for (int i = 0; i <= myArray.length; i++) {
            System.out.println(myArray[i]);
        }
    }

    public static void method2() {
        // ������� �� ����
        int a = 5;
        int b = 0;

        System.out.println(a/b);

    }

    public static void method3() {
        // �������� int � null
        int a = 5;
        Integer b = null;
        int c = a + b;
    }

}
