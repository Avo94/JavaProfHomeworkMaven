package Prof25Homework_16_05_2023;

import java.util.Arrays;

public class Calculator {

    public int max(int[] array) {
        return Arrays.stream(array).max().getAsInt();
    }

    public int min(int[] array) {
        return Arrays.stream(array).min().getAsInt();
    }
}
