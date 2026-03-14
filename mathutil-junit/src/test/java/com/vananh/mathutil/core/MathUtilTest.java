package com.vananh.mathutil.core;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MathUtilTest {

    @Test
    public void testGetFactorialGivenRightArgumeentReturnsWell() {
        int n = 0;
        long expected = 1;
        long actual = MathUtil.getFactorial(n);

        assertEquals(expected, actual);
        assertEquals(1, MathUtil.getFactorial(1));
        assertEquals(2, MathUtil.getFactorial(2));
        assertEquals(6, MathUtil.getFactorial(3));
        assertEquals(24, MathUtil.getFactorial(4));
        assertEquals(120, MathUtil.getFactorial(5));
        assertEquals(720, MathUtil.getFactorial(6));
    }

    @Test
    public void testGetFactorialGivenWrongArgumentThrowExcception() {
        Exception exception = assertThrows(
                IllegalArgumentException.class, () -> MathUtil.getFactorial(-5)
        );

        assertEquals(
                "Invalid argument. n must be between 0 and 20",
                exception.getMessage()
        );
    }

}
