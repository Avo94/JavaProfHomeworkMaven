package Algorithms.Prof1Homework_02_06_2023;

import java.util.List;

public class StringApp {

    static List<String> strings;

    public static void main(String[] args) {
        modifier("candibober").forEach(System.out::println);
    }

    public static List<String> modifier(String original) {
        recursion(original.toCharArray(), new char[0]);
        return strings;
    }

    private static void recursion(char[] string, char[] memory) {

    }
}