package Sem1HW;

//4) ���������� �����, ����������� � �������� ���������� ��� ������������� �������,
//        � ������������ ����� ������, ������ ������� �������� ����� �������� ��������� ���� �������� ��������
//        � ��� �� ������. ���� ����� �������� �� �����, ���������� ���-�� ���������� ������������.
//        �����: ��� ���������� ������ ������������ ����������,
//        ������� ������������ ����� ������� - RuntimeException, �.�. ����

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
