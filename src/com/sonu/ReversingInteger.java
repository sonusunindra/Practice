package com.sonu;

public class ReversingInteger {

    public static void main(String[] args) {
        long re = reverse();
        System.out.println(re);
    }

    public static long reverse() {
        int i = 5678;
        long reversed = 0;
        while (i != 0) {
            reversed = (reversed * 10) + i % 10;
           // i /= 10;
            i=i/10;
            if (reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE) {
                return 0;
            }
        }
        return reversed;
    }
}
