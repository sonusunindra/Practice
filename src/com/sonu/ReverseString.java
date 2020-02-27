package com.sonu;

import java.util.Scanner;
import java.util.function.Function;

public class ReverseString {
    public static void main(String[] args) {
        System.out.println("Please provide String input for reversing");
        Scanner sc=new Scanner(System.in);
        String stringForReverse=sc.next();
      /*  StringBuffer sb=new StringBuffer(stringForReverse);
        String reversed=sb.reverse().toString();*/
        String reversed=   reversingString(stringForReverse);
        //String reversed=   reversingByRecursion(stringForReverse);

        System.out.println("Reversed String is :: "+reversed);

        System.out.println("Reversing String using java8"+reverseFunction.apply("SONU"));
    }

   static String reversingString(String tobeReversed){
        String st="";
        for(int l=tobeReversed.length()-1;l>=0;l--){
            st=st+tobeReversed.charAt(l);
        }
        System.out.println(st);
        return st;

    }

    static String reversingByRecursion(String tobeReversed){
        System.out.println("tobeReversed" +
                ""+tobeReversed);
        //String st="";
        if(tobeReversed.isEmpty()){
            return tobeReversed;
        }
        return reversingByRecursion(tobeReversed.substring(1))+tobeReversed.charAt(0);
    }

    static Function<String,String> reverseFunction=(m)->new StringBuilder(m).reverse().toString();
}
