package Sem3HW;

import java.util.Arrays;

public class ElementsQuantityException extends RuntimeException {

    private int numberOfElements;
    String[] array;

    public ElementsQuantityException(int numberOfElements, String[] array) {
        super("Ошибка по количеству элементов в введённых данных. \n" +
                "Введено " + numberOfElements + " а должно быть 6 \n" +
                "Массив данных:" + Arrays.toString(array));
        this.numberOfElements = numberOfElements;
        this.array = array;
    }


}
