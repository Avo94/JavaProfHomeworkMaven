package Algorithms.Prof1Homework_02_06_2023;

import java.util.ArrayList;
import java.util.List;

public class StringApp {

    public static void main(String[] args) {
        System.out.println(modifier("cafe"));
    }

    public static List<String> modifier(String original) {
        List<String> strings = new ArrayList<>();
        recursion(original.toCharArray(), 0, strings);
        return strings;
    }

    private static void recursion(char[] string, int startIndex, List<String> strings) {
        if (startIndex == string.length - 1) {
            strings.add(new String(string));
        } else {
            for (int i = startIndex; i < string.length; i++) {
                swap(string, startIndex, i);
                recursion(string, startIndex + 1, strings);
                swap(string, startIndex, i);
            }
        }
    }

    private static void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}