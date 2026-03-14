package com.vananh.mathutil.core;

public class MathUtil {
    public static long getFactorial(int n) {
        if (n < 0 || n > 20)
            throw new IllegalArgumentException("Invalid argument. n must be between 0 and 20");
        if   (n == 0 || n == 1)   
            return 1;
        return n * getFactorial(n-1);
    }       
    
}
