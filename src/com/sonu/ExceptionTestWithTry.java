package com.sonu;

public class ExceptionTestWithTry {

    public static void main(String[] args) {
        try{
            System.out.println("try here");
            throw new RuntimeException();
        }catch(Exception ex){
            System.out.println("ex catch here");
        }

        finally{
            System.out.println("finally here");
        }

        System.out.println("Sonu my name");
    }

}
