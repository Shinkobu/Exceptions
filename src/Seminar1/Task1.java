package Seminar1;

//        Реализуйте метод, принимающий в качестве аргумента целочисленный массив.
//        Если длина массива меньше некоторого заданного минимума, метод возвращает -1, в качестве кода ошибки, иначе - длину массива.

public class Task1 {

    public static final int MIN_LENGTH = 3;

    public static void main(String[] args) {
        int[] myArray = {1,2,};

        System.out.println(checkArrayLength(myArray));

    }

    public static int checkArrayLength(int[] myArray) {

        if (myArray != null) {
            if (myArray.length >= MIN_LENGTH) {
                return myArray.length;
            }
            return -1;
        }
        return -2;

    }

}
