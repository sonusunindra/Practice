package com.sonu;



import java.util.Scanner;
import java.util.function.Function;

public class PalindromeChecker {
static Function<String,String> fun=(m)->new StringBuilder(m).reverse().toString();

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        System.out.println("Your Entry is:: "+str);
       String palindromechecker= fun.apply(str);
       if(str.equals(palindromechecker.trim())){
           System.out.println("Your Entry is palindrome::"+palindromechecker);
       }
       else
        System.out.println("Your Entry is not palindrome::"+palindromechecker);
    }
}
