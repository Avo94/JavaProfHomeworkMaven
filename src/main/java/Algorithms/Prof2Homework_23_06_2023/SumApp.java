package Algorithms.Prof2Homework_23_06_2023;

public class SumApp {

    public static void main(String[] args) {
        int[] intArray = {3, 4, 10, 9, 1, 5, 6, 8, 2, 7};
        int result = getTheHighestSumOfTwoNumbers(intArray);
        System.out.println(result);
    }

    public static int getTheHighestSumOfTwoNumbers(int[] array) {
        int result = 0;
        for (int i = 0; i < array.length - 2; i++) {
            for (int j = i + 2; j < array.length; j++) {
                if (result < array[i] + array[j]) result = array[i] + array[j];
            }
        }
        return result;
    }
}