/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hmyndooo.mathutil;

import static com.hmyndooo.mathutil.core.MathUtil.getFactorial;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 *
 * @author hmynd
 */
public class MathUtilTestDTT {
    // DDT, tách data ra khỏi câu lệnh kiểm thử, tham số hóa data này vào trong câu lệnh kiểm thử
    // chuẩn bị bộ data
    public static Object[][] initData() {
        return new Integer[][] {
            {1, 1},
            {2, 2},
            {5, 120},
            {6, 720},
            {4, 24}
        };
    }

    @ParameterizedTest
    @MethodSource(value = "initData") // tên hàm cung cấp data ngầm định thứ tự của các phần tử mảng, map vào tham số hàm
    public void testGetFactorialGivenRightArgReturnWell(int input, long expected) {
        assertEquals(expected, getFactorial(input));
    }

    @Test
    public void testGetFactorialGivenWrongArgThrowException() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> getFactorial(-5));
        assertEquals("Invalid argument. n must be between 0 and 20.", ex.getMessage());
    }
}
