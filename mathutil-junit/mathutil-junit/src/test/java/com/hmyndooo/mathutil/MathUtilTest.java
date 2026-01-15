/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hmyndooo.mathutil; 
/**
 *
 * @author hmynd
 */
import com.hmyndooo.mathutil.core.MathUtil;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
public class MathUtilTest {
    @Test
    public void testGetFactorialGivenRightArgumentReturnsWell() {
        int n = 0;
        long expected = 1; // kỳ vọng 0! = 1
        long actual = MathUtil.getFactorial(n);
        // so sánh expected vs. actual
         assertEquals(expected, actual);// hàm giúp so sánh 2 giá trị nào đó có giống nhau hay không?
        assertEquals(1, MathUtil.getFactorial(1)); // muốn 1! = 1
        assertEquals(2, MathUtil.getFactorial(2));
        assertEquals(6, MathUtil.getFactorial(3));
        assertEquals(24, MathUtil.getFactorial(4));
        assertEquals(120, MathUtil.getFactorial(5));
        assertEquals(720, MathUtil.getFactorial(6));
    }

    @Test
    public void testGetFactorialGivenWrongArgumentThrowException() {
        Exception exception = assertThrows(
            IllegalArgumentException.class,
            () -> MathUtil.getFactorial(-5)
        );

         assertEquals(
             "Invalid argument. n must be between 0 and 20.",
             exception.getMessage()
         );
    }
}
