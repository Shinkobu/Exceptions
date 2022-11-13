package Sem1HW;

public class Task2 {

    public static void main(String[] args) {

        String[][] arr = {{"1","2"},{"1","2"},{"3","4"}};
        sum2d(arr);
    }

    public static int sum2d(String[][] arr) {

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                int val = Integer.parseInt(arr[i][j]);
                sum+= val;

            }
        }
        return sum;
    }

}
