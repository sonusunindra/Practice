package com.sonu;

import java.util.Comparator;

public class J8ComparatorTest {
    public static void main(String[] args) {
        Comparator<Integer> integerComparator=(I1,I2)->I1>I2?1:I1<I2?-1:0;
    }
}
