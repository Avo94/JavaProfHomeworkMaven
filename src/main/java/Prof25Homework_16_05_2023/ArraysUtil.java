package Prof25Homework_16_05_2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysUtil {

    public static int[] getMatches(int[] array1, int[] array2) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] == array2[i]) {
                result.add(array1[i]);
            }
        }
        return result.stream().mapToInt(x -> x).toArray();
    }

    public static int[] removeDuplicates(int[] array) {
        return Arrays.stream(array).distinct().toArray();
    }
}
