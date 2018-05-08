package ru.reeson2003.simpleobject;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Pavel Gavrilov
 */
public class SimpleObjectTest {
    @Test
    public void simpleObjectTest() {
        String[] arr = {"Hello", " ", "world"};
        Arrays.stream(arr)
                .map(s -> SimpleObject.of(s, s.toUpperCase()))
                .map(o2 -> SimpleObject.of(o2.value1, o2.value1.toLowerCase(), o2.value2.toCharArray()))
                ;
    }
}
