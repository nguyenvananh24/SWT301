package com.vananh.mathutil.core;

import static com.vananh.mathutil.core.MathUtil.getFactorial;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class MathUtilTestDDT {

    public static Object[][] initData() {
        return new Integer[][]{
            {1, 1}, {2, 2}, {5, 120}, {6, 720}, {4, 24}
        };
    }

    @ParameterizedTest
    @MethodSource(value = "initData")
    public void testGetFactorialGivenRightArgReturnWell(int input, long expected) {
        assertEquals(expected, getFactorial(input));
    }
    
    @Test
    public void testGetFactorialGivenWrongArgThrowException(){
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> getFactorial(-5));
        assertEquals("Invalid argument. n must be between 0 and 20", ex.getMessage());
    }

}
