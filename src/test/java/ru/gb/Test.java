package ru.gb;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.gb.lesson3_6.MainApp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Test {
    @ParameterizedTest
    @MethodSource("dataForAfterFour")
    public void testAfterFour(int[] arr, Object result) {
        if(result instanceof int[]) {
            Assertions.assertArrayEquals((int[]) result, MainApp.afterFour(arr));
        } else {
            Assertions.assertThrows(RuntimeException.class, () -> MainApp.afterFour(arr));
        }
    }

    @ParameterizedTest
    @MethodSource("dataForIsThere14")
    public void testIsThere14(int[] arr, boolean result) {
        Assertions.assertEquals(result, MainApp.isThere14(arr));
    }

    public static Stream<Arguments> dataForAfterFour() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}, new int[]{1, 7}));
        out.add(Arguments.arguments(new int[]{1, 2, 4, 1, 7, 5, 3, 2}, new int[]{1, 7, 5, 3, 2}));
        out.add(Arguments.arguments(new int[]{1, 2, 4}, new int[]{}));
        out.add(Arguments.arguments(new int[]{1, 2, 5, 6}, RuntimeException.class));
        return out.stream();
    }

    public static Stream<Arguments> dataForIsThere14() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[]{1, 1, 1, 4, 4, 1, 4, 4}, true));
        out.add(Arguments.arguments(new int[]{1, 1, 1, 1, 1, 1}, false));
        out.add(Arguments.arguments(new int[]{4, 4, 4, 4}, false));
        out.add(Arguments.arguments(new int[]{1, 4, 4, 1, 1, 4, 3}, false));
        return out.stream();
    }
}
