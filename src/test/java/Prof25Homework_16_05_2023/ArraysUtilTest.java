package Prof25Homework_16_05_2023;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ArraysUtilTest {

    @Test
    void getMatches() {
        int[] array1 = new int[]{1, 2, 5, 5, 8, 9, 7, 10};
        int[] array2 = new int[]{1, 0, 6, 15, 6, 4, 7, 0};

        int[] result = ArraysUtil.getMatches(array1, array2);
        Assertions.assertArrayEquals(new int[]{1, 7}, result);
    }

    @Test
    void getMatchesWhenFirstParameterIsNull() {
        Assertions.assertThrows(NullPointerException.class, () -> ArraysUtil.getMatches(new int[]{0}, null));
    }

    @Test
    void getMatchesWhenSecondParameterIsNull() {
        Assertions.assertThrows(NullPointerException.class, () -> ArraysUtil.getMatches(null, new int[]{0}));
    }

    @Test
    void getMatchesWhenBothParameterIsNull() {
        Assertions.assertThrows(NullPointerException.class, () -> ArraysUtil.getMatches(null, null));
    }

    @Test
    void getMatchesWithNullParametersWithException() {
        // Assertions.assertNotNull(ArraysUtil.getMatches(null, null));
    }

    @Test
    void getMatchesWithNullParametersWithoutException() {
        // Assertions.assertNull(ArraysUtil.getMatches(null, null));
    }
}