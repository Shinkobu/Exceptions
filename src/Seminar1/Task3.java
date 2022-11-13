package Seminar1;

/*Реализуйте метод, принимающий в качестве аргумента целочисленный двумерный массив.
        Необходимо посчитать и вернуть сумму элементов этого массива.
        При этом накладываем на метод 2 ограничения:

        метод может работать только с квадратными массивами (кол-во строк = кол-ву столбцов),
        и в каждой ячейке может лежать только значение 0 или 1.

        Если нарушается одно из условий, метод должен бросить RuntimeException с сообщением об ошибке.
*/

public class Task3 {

    public static void main(String[] args) {
        int [][] myArray = {{1,0},{0,1}};

        System.out.println(arraySum(myArray));

    }

    public static int arraySum(int [][] myArray) {

        if (myArray.length != myArray[0].length) {
            throw new RuntimeException("Not square array!");}

        int sum = 0;
        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray[i].length; j++) {

                if (myArray[i][j] == 0 || myArray[i][j] == 1) {
                    sum = myArray[i][j] + sum;
                } else {
                throw new RuntimeException("Wrong value in the array!");}
            }
        }
        return sum;

    }

}
