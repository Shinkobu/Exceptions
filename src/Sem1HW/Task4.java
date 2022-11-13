package Sem1HW;

//4) Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
//        и возвращающий новый массив, каждый элемент которого равен частному элементов двух входящих массивов
//        в той же ячейке. Если длины массивов не равны, необходимо как-то оповестить пользователя.
//        Важно: При выполнении метода единственное исключение,
//        которое пользователь может увидеть - RuntimeException, т.е. ваше

import java.util.Arrays;

public class Task4 {

    public static void main(String[] args) {

        int [] arr1 = {4,3,2,-1};
        int [] arr2 = {1,2,3,15};
        System.out.println(Arrays.toString(arrayDivision(arr1, arr2)));
    }
    public static float[] arrayDivision(int[] arr1, int[] arr2) {

        if (arr1.length != arr2.length){
            throw new RuntimeException("Arrays have different number of elements");
        }

        float[] resultArr = new float[arr1.length];

        for (int i = 0; i < arr1.length; i++) {
            if (arr2[i] == 0){
                throw new RuntimeException("Division by null");
            }
            resultArr[i] = (float) arr1[i] / arr2[i];
        }
        return resultArr;
    }
}
